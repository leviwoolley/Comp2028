package	org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.hardware.DcMotor;
import	com.qualcomm.robotcore.util.ElapsedTime;
import  com.qualcomm.robotcore.hardware.Servo;

import  com.qualcomm.robotcore.hardware.HardwareDevice;

import  com.qualcomm.robotcore.hardware.HardwareMap;
import  com.qualcomm.robotcore.hardware.Gamepad;


@TeleOp(name="Mechanum	Drive",	group="Linear	OpMode")

public	class	MechanumDrive	extends	LinearOpMode	{
    
    private DcMotor fL, bL, fR, bR;

    private DcMotor rLaunch, lLaunch, transfer;

    private Servo rStopper, lStopper;

    private boolean rbPressed, lbPressed, lastState;

    private double x, y, turn, theta, power, sin, cos, max;

    private double fLPower, bLPower, fRPower, bRPower;

	@Override
	public void	runOpMode()	{

	fL	=	hardwareMap.get(DcMotor.class,	"fL");
	fR	=	hardwareMap.get(DcMotor.class,	"fR");
	bL	=	hardwareMap.get(DcMotor.class,	"bL");
	bR	=	hardwareMap.get(DcMotor.class,	"bR");

    rLaunch = hardwareMap.get(DcMotor.class, "rLauncher");
    lLaunch = hardwareMap.get(DcMotor.class, "lLauncher");
    transfer = hardwareMap.get(DcMotor.class, "transfer");

    lastState = false;
    


	telemetry.addData("Status",	"Initialized");
	telemetry.update();

    waitForStart();

		while	(opModeIsActive())	{

            // Get status of right and left bumpers
            rbPressed = gamepad1.right_bumper;
            lbPressed = gamepad1.left_bumper;

            // Get position of sticks as a decimal 
            x = -gamepad1.right_stick_x;
            y = -gamepad1.left_stick_y;
            turn = gamepad1.left_stick_x;

            // Determine tilt of the left stick in radians
            theta = Math.atan2(y, x);
            // Determine magnitude/distance of the left stick as a decimal
            power = Math.hypot(x, y);

            // Get the sine/cosine of the given angle, offset by 45 degrees. Returns a decimal between -1 and 1, depending on the stick orientation.
            sin = Math.sin(theta - Math.PI/4);
            cos = Math.cos(theta - Math.PI/4);
            // Returns the larger the two
            max = Math.max(Math.abs(sin), Math.abs(cos));

            calculateMotorPower();

            setDriveChainPower();

            // https://javadoc.io/doc/org.firstinspires.ftc/RobotCore/latest/com/qualcomm/robotcore/hardware/DcMotor.html

            if (rbPressed){
                setIntakeToggle();
            }
            if (gamepad1.dpad_up) {
                shootToggle();
            }

            // https://javadoc.io/doc/org.firstinspires.ftc/RobotCore/latest/com/qualcomm/robotcore/hardware/Gamepad.html

			telemetry.addData("Front	left/Right",	"%4.2f,	%4.2f",	fLPower,	fRPower);
			telemetry.addData("Back		left/Right",	"%4.2f,	%4.2f",	bLPower,	bRPower);
			telemetry.update();

		}

	}

    public void calculateMotorPower() {
         /* 
                Power * cos | Power * sin
                Multiple the magnitude of the stick direction (power) by the sine/cosine of its angle to return a decimal. 
                
                (Power * cos)/max | (Power * sin)/max
               	Scales the values down proportionally by the larger of the sin/cosine values.
                The reasoning for this is that the y-value of any given controller can actually exceed 1.0, sometimes up to 1.28.
				This leads to the control hub disconnecting the offending motor.

                + turn | - turn
                Adds the x-value of the right stick to the total. Allows for strafing.
                Easy to visualize if the left sick is neutral. 
                Push the right stick to the <---, and the left wheels need to spin the same direction, and the right the opposite.
                This achieves strafing with mechanum wheels.
            */

            this.fLPower = power * cos/max - turn;
            this.fRPower = power * sin/max + turn;
            this.bLPower = power * sin/max - turn;
            this.bRPower = power * cos/max + turn;

            
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

    }

    public void setDriveChainPower(double fLP, double fRP, double bLP, double bRP) {
        this.fL.setPower(fLP);
        this.fR.setPower(fRP);
        this.bL.setPower(bLP);
        this.bR.setPower(bRP);
    }

    public void setDriveChainPower() {
        setDriveChainPower(this.fLPower, this.fRPower, this.bLPower, this.bRPower);
    }

    public void setIntakeToggle() {
            switch (this.rLaunch.getPower()) {
                case 1:
                    this.rLaunch.setPower(0);
                    this.lLaunch.setPower(0);
                    break;
            
                default:
                    this.rLaunch.setPower(1);
                    this.lLaunch.setPower(-1);
                    break;
            }
    }

    public void shootToggle() {
      switch (this.transfer.getPower) {
        case 1:
            this.transfer.setPower(0);
            break;
      
        default:
            this.transfer.setPower(1);
            break;
      }
    }
 
    public void servoControl() {
            if (gamepad1.right_trigger_pressed) {
                this.rStopper.setPosition(0.7);
                this.lStopper.setPosition(0.7);
            }

            if (gamepad1.left_trigger_pressed) {
                this.rStopper.setPosition(0.5);
                this.lStopper.setPosition(0.5);
            }
    }

    public void rotationTesting() {
        if (gamepad1.a) {
            this.fL.setPower(1);
            sleep(500);
            this.fL.setPower(0);
        }
        if (gamepad1.b) {
            this.bL.setPower(1);
            sleep(500);
            this.bL.setPower(0);
        }
        if (gamepad1.x) {
            this.bR.setPower(1);
            sleep(500);
            this.bR.setPower(0);
        }
        if (gamepad1.y) {
            this.fR.setPower(1);
            sleep(500);
            this.fR.setPower(0);
        }
    }
}
