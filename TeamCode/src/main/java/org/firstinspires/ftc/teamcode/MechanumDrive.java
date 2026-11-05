package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MechanumDrive {
    public enum MotorStatus {
        FORWARD,
        BACKWARD,
        OFF
    }

    public enum DrivingMode {
        BRUTE,
        HYBRID,
        MATH,
        OLD
    }

    private final LinearOpMode robotOpMode;
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    private Gamepad gamepad1;

    private DcMotor fL, bL, fR, bR;
    private DrivingMode drivingSelected;

    private double turn, max;
    private double fLPower, bLPower, fRPower, bRPower;

    private boolean xReverse, yReverse, xFlip;

    public MechanumDrive(LinearOpMode lOM) {
        this.robotOpMode = lOM;
        this.hardwareMap = this.robotOpMode.hardwareMap;
        this.telemetry = this.robotOpMode.telemetry;
        this.gamepad1 = this.robotOpMode.gamepad1;
    }


    public void drivingLoop() {

        double x = this.gamepad1.left_stick_x;
        double y = -this.gamepad1.left_stick_y;

        this.turn = this.gamepad1.right_stick_x;

        // Select Driving Mode through enum using DPAD | left = BRUTE | up = HYBRID | right = MATH | down = OLD
        if (this.gamepad1.dpad_left) {
            this.drivingSelected = DrivingMode.BRUTE;
        }

        else if (this.gamepad1.dpad_up) {
            this.drivingSelected = DrivingMode.HYBRID;
        }

        else if (this.gamepad1.dpad_right) {
            this.drivingSelected = DrivingMode.MATH;
        }

        else if (this.gamepad1.dpad_down) {
            this.drivingSelected = DrivingMode.OLD;
        }

        // Reversing values for testing purposes. Probably encapsulate later.

        if (this.gamepad1.xWasPressed()) {
            xReverse = !xReverse;
        }

        if (this.gamepad1.yWasPressed()) {
            yReverse = !yReverse;
        }

        if (this.gamepad1.aWasPressed()) {
            xFlip = !xFlip;

        }

        if (xReverse) {
            x = -x;
        }

        if (yReverse) {
            y = -y;
        }

        if (xFlip) {
            double temp = x;
            x = turn;
            turn = temp;
        }

        // Using mode selection by above if statement, then direct to function for it.

        switch (this.drivingSelected) {
            case BRUTE -> bruteDriving(x, -y, turn);
            case HYBRID -> hybridDriving(x, y, turn);
            case MATH -> mathDriving(-x, -y, turn);
            case OLD -> oldDriving(); // Calls x and y internally. Grabbed from Alex's last year, with minimal modification.
            default -> {
                break; // Redundant, but please leave for clarity. Needed for Java to consider the Switch exhaustive.
            }

        }
    }

    public void drivingTelemetry() {
        // FTC's way to convey data to the user through the driving station. Adds to buffer but does not flush, so it can be used and then added upon in actual teleop.
        this.telemetry.addData("Driving Mode", drivingSelected);

        this.telemetry.addData("Front	left/Right", "%4.2f,	%4.2f", fLPower, fRPower);
        this.telemetry.addData("Back	left/Right", "%4.2f,	%4.2f", bLPower, bRPower);

        this.telemetry.addData("xReverse, yReverse, xFLip values: ", "f, f, f", xReverse, yReverse, xFlip);
    }

    public void initMotors(DcMotorSimple.Direction fLDirection, DcMotorSimple.Direction fRDirection, DcMotorSimple.Direction bLDirection, DcMotorSimple.Direction bRDirection) {
        // Overload later for additional option to change motor names, or default.
        this.fL = this.hardwareMap.get(DcMotor.class, "fL");
        this.fR = this.hardwareMap.get(DcMotor.class, "fR");
        this.bL = this.hardwareMap.get(DcMotor.class, "bL");
        this.bR = this.hardwareMap.get(DcMotor.class, "bR");

        this.drivingSelected = DrivingMode.MATH;

        this.fL.setDirection(fLDirection);
        this.fR.setDirection(fRDirection);
        this.bL.setDirection(bLDirection);
        this.bR.setDirection(bRDirection);

        xReverse = false;
        yReverse = false;
        xFlip = false;
    }

    public void setDriveChainPower(double fLP, double fRP, double bLP, double bRP) {
        this.fL.setPower(fLP);
        this.fR.setPower(fRP);
        this.bL.setPower(bLP);
        this.bR.setPower(bRP);
    }
    // Overloaded version, to use default variables.
    public void setDriveChainPower() {
        this.setDriveChainPower(this.fLPower, this.fRPower, this.bLPower, this.bRPower);
    }

    private void mathDriving(double x, double y, double turn) {
        // Determine magnitude/distance of the left stick as a decimal
        double power = Math.hypot(x, y);
        // Determine tilt of the left stick in radians | Above/power gives us a magnitude, but not a direction.
        double theta = Math.atan2(x,y) - Math.PI/4;

        // Get the sine/cosine of the given angle, offset by 45 degrees. Used to effectively "rotate" the magnitude by reducing it by sin/cosine through multiplication.
        double sin = Math.sin(theta);
        double cos = Math.cos(theta);
        // Returns the larger the two, which is later used to scale everything down proportionally, should it exceed 1/-1.
        this.max = Math.max(Math.abs(sin), Math.abs(cos));

        /*
                Power * cos | Power * sin
                Multiply the magnitude of the stick direction (power) by the sine/cosine of its angle to return a decimal.
                Effectively "rotates" the magnitude for each wheel, so their vectors cancel out when needed.

                (Power * cos)/max | (Power * sin)/max
               	Scales the values down proportionally by the larger of the sin/cosine values.
                The reasoning for this is that the y-value of any given controller can actually exceed 1.0, sometimes up to 1.28.
				This leads to the control hub disconnecting the offending motor.

                + turn | - turn
                Adds the x-value of the right stick to the total. Allows for strafing.
                Easy to visualize if the left sick is neutral.
                Push the right stick to the <---, and the left wheels need to spin the same direction, and the right the opposite.
                This achieves strafing with mecanum wheels.
         */

        this.fLPower = power * cos / max + turn;
        this.fRPower = power * sin / max - turn;
        this.bLPower = power * sin / max + turn;
        this.bRPower = power * cos / max - turn;

        /*
            If wheel power exceeds 1, then scale them down proportionately.

            Divide the set by wheel power by the magnitude of the left stick direction, then add the value of the turn back in.

            Don't need to add/subtract opposite wheel positions because it is already accounted for in the original calculation.
         */

        if (Math.abs(power + Math.abs(turn)) > 1) {
            this.fLPower = (fLPower/power) + turn;
            this.fRPower = (fRPower/power) + turn;
            this.bLPower = (bLPower/power) + turn;
            this.bRPower = (bRPower/power) + turn;
        }

        setDriveChainPower();
    }

    private void bruteDriving(double x, double y, double turn) {
        this.max = Math.max((y + x + turn), 1.0);
        // Imperfect strafing due to just how motors works, this correctional value can make it feel more natural, apparently.
        x *= 1.1;

        this.fLPower = y + x + turn;
        this.fRPower = y - x - turn;
        this.bLPower = y - x + turn;
        this.bRPower = y + x - turn;

        if ((y + x + turn) > 1.0) {
            this.fLPower /= max;
            this.fRPower /= max;
            this.bLPower /= max;
            this.bRPower /= max;
        }

        setDriveChainPower(this.fLPower,this.fRPower,this.bLPower,this.bRPower);
    }

    private void hybridDriving(double x, double y, double turn) {
        // Effectively maintains efficiency of the Math driving mode, but the "feel" of brute.
        // Just switches between the two based on if x/y exceed 0.5
        if (Math.abs(x) < 0.5 || Math.abs(y) < 0.5) {
            bruteDriving(x, -y, turn);
        } else {
            mathDriving(-x, -y, turn);
        }
    }

    private void oldDriving() {
        if (gamepad1.left_stick_y >= 0.1) {
            fL.setPower(gamepad1.left_stick_y);
            fR.setPower(gamepad1.left_stick_y);
            bL.setPower(gamepad1.left_stick_y);
            bR.setPower(gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_y <= -0.1) {
            fL.setPower(gamepad1.left_stick_y);
            fR.setPower(gamepad1.left_stick_y);
            bL.setPower(gamepad1.left_stick_y);
            bR.setPower(gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_x <= -0.1) {
            fL.setPower(Math.abs(gamepad1.left_stick_x));
            fR.setPower(gamepad1.left_stick_x);
            bL.setPower(gamepad1.left_stick_x);
            bR.setPower(Math.abs(gamepad1.left_stick_x));
        } else if (gamepad1.left_stick_x >= 0.1) {
            fL.setPower(-gamepad1.left_stick_x);
            fR.setPower(gamepad1.left_stick_x);
            bL.setPower(gamepad1.left_stick_x);
            bR.setPower(-gamepad1.left_stick_x);
        }
        if (gamepad1.right_stick_y >= 0.1) {
            fL.setPower(0.5 * gamepad1.right_stick_y);
            fR.setPower(0.5 * gamepad1.right_stick_y);
            bL.setPower(0.5 * gamepad1.right_stick_y);
            bR.setPower(0.5 * gamepad1.right_stick_y);
        } else if (gamepad1.right_stick_y <= -0.1) {
            fL.setPower(0.5 * gamepad1.right_stick_y);
            fR.setPower(0.5 * gamepad1.right_stick_y);
            bL.setPower(0.5 * gamepad1.right_stick_y);
            bR.setPower(0.5 * gamepad1.right_stick_y);
        } else if (gamepad1.right_stick_x <= -0.1) {
            fL.setPower(0.5 * Math.abs(gamepad1.right_stick_x));
            fR.setPower(0.5 * gamepad1.right_stick_x);
            bL.setPower(0.5 * gamepad1.right_stick_x);
            bR.setPower(0.5 * Math.abs(gamepad1.right_stick_x));
        } else if (gamepad1.right_stick_x >= 0.1) {
            fL.setPower(0.5 * -gamepad1.right_stick_x);
            fR.setPower(0.5 * gamepad1.right_stick_x);
            bL.setPower(0.5 * gamepad1.right_stick_x);
            bR.setPower(0.5 * -gamepad1.right_stick_x);
        }

        if (gamepad1.left_stick_y < 0.1) {
            fL.setPower(0);
            fR.setPower(0);
            bL.setPower(0);
            bR.setPower(0);
        } else if (gamepad1.left_stick_y > -0.1) {
            fL.setPower(0);
            fR.setPower(0);
            bL.setPower(0);
            bR.setPower(0);
        }
    }

    public void rotationTesting() {
        if (this.gamepad1.a) {
            this.fL.setPower(1);
            this.robotOpMode.sleep(500);
            this.fL.setPower(0);
        }
        if (this.gamepad1.b) {
            this.bL.setPower(1);
            this.robotOpMode.sleep(500);
            this.bL.setPower(0);
        }
        if (this.gamepad1.x) {
            this.bR.setPower(1);
            this.robotOpMode.sleep(500);
            this.bR.setPower(0);
        }
        if (this.gamepad1.y) {
            this.fR.setPower(1);
            this.robotOpMode.sleep(500);
            this.fR.setPower(0);
        }
    }

}
