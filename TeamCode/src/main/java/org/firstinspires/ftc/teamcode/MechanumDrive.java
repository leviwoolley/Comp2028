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
    private final Gamepad gamepad1;

    private DcMotor fL, bL, fR, bR;
    private DrivingMode drivingSelected;

    private double x, y, turn, max;
    private double fLPower, bLPower, fRPower, bRPower;

    public MechanumDrive(LinearOpMode lOM) {
        this.robotOpMode = lOM;
        this.hardwareMap = this.robotOpMode.hardwareMap;
        this.telemetry = this.robotOpMode.telemetry;
        this.gamepad1 = this.robotOpMode.gamepad1;
    }


    public void drivingLoop() {

        this.x = -this.gamepad1.right_stick_x;
        this.y = -this.gamepad1.left_stick_y;

        this.turn = this.gamepad1.left_stick_x;

        // Select Driving
        if (this.gamepad1.dpad_left) {
            this.drivingSelected = DrivingMode.BRUTE;
        }else if (this.gamepad1.dpad_up) {
            this.drivingSelected = DrivingMode.HYBRID;
        }else if (this.gamepad1.dpad_right) {
            this.drivingSelected = DrivingMode.MATH;
        }else if (this.gamepad1.dpad_down) {
            this.drivingSelected = DrivingMode.OLD;
        }

        switch (this.drivingSelected) {
            case BRUTE -> {
                try {
                    bruteDriving();
                } catch (Exception e) {
                    telemetry.addData("Unknown Exception for Brute", e);
                }

            }
            case HYBRID -> hybridDriving();
            case MATH -> mathDriving();
            case OLD -> oldDriving();
            default -> {
                break;
            }

        }
    }

    public void drivingTelemetry() {
        this.telemetry.addData("Driving Mode", drivingSelected);

        this.telemetry.addData("Front	left/Right", "%4.2f,	%4.2f", fLPower, fRPower);
        this.telemetry.addData("Back	left/Right", "%4.2f,	%4.2f", bLPower, bRPower);
    }
    public void initMotors(DcMotorSimple.Direction fLDirection, DcMotorSimple.Direction fRDirection, DcMotorSimple.Direction bLDirection, DcMotorSimple.Direction bRDirection) {
        this.fL = this.hardwareMap.get(DcMotor.class, "fL");
        this.fR = this.hardwareMap.get(DcMotor.class, "fR");
        this.bL = this.hardwareMap.get(DcMotor.class, "bL");
        this.bR = this.hardwareMap.get(DcMotor.class, "bR");

        this.drivingSelected = DrivingMode.MATH;

        this.fL.setDirection(fLDirection);
        this.fR.setDirection(fRDirection);
        this.bL.setDirection(bLDirection);
        this.bR.setDirection(bRDirection);
    }

    public void setDriveChainPower(double fLP, double fRP, double bLP, double bRP) {
        this.fL.setPower(fLP);
        this.fR.setPower(fRP);
        this.bL.setPower(bLP);
        this.bR.setPower(bRP);
    }

    public void setDriveChainPower() {
        this.setDriveChainPower(this.fLPower, this.fRPower, this.bLPower, this.bRPower);
    }

    private void mathDriving() {
        // Get position of sticks as a decimal


        // Determine tilt of the left stick in radians
        double theta = Math.atan2(y, x);
        // Determine magnitude/distance of the left stick as a decimal
        double power = Math.hypot(x, y);

        // Get the sine/cosine of the given angle, offset by 45 degrees. Returns a decimal between -1 and 1, depending on the stick orientation.
        double sin = Math.sin(theta - Math.PI / 4);
        double cos = Math.cos(theta - Math.PI / 4);
        // Returns the larger the two
        this.max = Math.max(Math.abs(sin), Math.abs(cos));

                 /*
                Power * cos | Power * sin
                Multiply the magnitude of the stick direction (power) by the sine/cosine of its angle to return a decimal.

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

        this.fLPower = power * cos / max - turn;
        this.fRPower = power * sin / max + turn;
        this.bLPower = power * sin / max - turn;
        this.bRPower = power * cos / max + turn;

            /*
                If wheel power exceeds 1, then scale them down proportionately.

                Divide the set by wheel power by the magnitude of the left stick direction, then add the value of the turn back in.

                Don't need to add/subtract opposite wheel positions because it is already accounted for in the original calculation.
            */

        if ((power + Math.abs(turn)) > 1) {
            this.fLPower /= power + turn;
            this.fRPower /= power + turn;
            this.bLPower /= power + turn;
            this.bRPower /= power + turn;
        }

        setDriveChainPower();
    }

    private void bruteDriving() {
        this.max = Math.max((y + x + turn), 1.0);

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

        setDriveChainPower(fLPower,fRPower,bLPower,bRPower);
    }

    private void hybridDriving() {
        if (Math.abs(x) < 0.5 || Math.abs(y) < 0.5) {
            bruteDriving();
        } else {
            mathDriving();
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
