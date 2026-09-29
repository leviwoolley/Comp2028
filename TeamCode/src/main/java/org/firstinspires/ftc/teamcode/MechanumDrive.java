package	org.firstinspires.ftc.robotcontroller.external.samples;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.hardware.DcMotor;
import	com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Mechanum	Drive",	group="Linear	OpMode")

public	class	MechanumDrive	extends	LinearOpMode	{

    // Declare OpMode members for each of the 4 motors.
    
    private DcMotor fL, bL, fR, bR;

    private double x, y, turn, theta, sin, cos, max;

    private double fLPower, bLPower, fRPower, bRPower;

	@Override
	public	void	runOpMode()	{

	fL	=	hardwareMap.get(DcMotor.class,	"fL");
	fR	=	hardwareMap.get(DcMotor.class,	"fR");
	bL	=	hardwareMap.get(DcMotor.class,	"bL");
	bR	=	hardwareMap.get(DcMotor.class,	"bR");

	telemetry.addData("Status",	"Initialized");
	telemetry.update();


								//	run	until	the	end	of	the	match	(driver	presses	STOP)
		while	(opModeIsActive())	{

            // Get position of sticks as a decimal 
            x = gamepad1.left_stick_x;
            y = -gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;

            // Determine tilt of the left stick in radians
            theta = Math.atan2(y, x);
            // Determine magnitude/distance of the left stick as a decimal
            power = Math.hypot(x, y);

            // Get the sine/cosine of the given angle, offset by 45 degrees. Returns a decimal between -1 and 1, depending on the stick orientation.
            sin = Math.sin(theta - Math.PI/4);
            cos = Math.cos(theta - Math.PI/4);
            // Returns the larger the two
            max = Math.max(Math.abs(sin), Math.abs(cos));

            /* 
                Power * cos | Power * sin
                Multiple the magnitude of the stick direction (power) by the sine/cosine of its angle to return a decimal. 
                
                cos/max | sin/max
                Sets the larger of the two to 1 and scales down the other proportionally. The goal is to not burn out/disconnect the motors.
                The reasoning for this is that the y-value of any given controller actually exceeds 1.0, sometimes up to 1.28.

                + turn | - turn
                Adds the x-value of the right stick to the total. Allows for strafing.
                Easy to visualize if the left sick is neutral. 
                Push the right stick to the <---, and the left wheels need to spin the same direction, and the right the opposite.
                This achieves strafing with mechanum wheels.
            */

            fLPower = power * cos/max + turn;
            fRPower = power * sin/max - turn;
            bLPower = power * sin/max + turn;
            bRPower = power * cos/max - turn;

            
            /*
                If wheel power exceeds 1, then scale them down proportionately.

                Divide the set by wheel power by the magnitude of the left stick direction, then add the value of the turn back in. 

                Don't need to add/subtract opposite wheel positions because it is already accounted for in the original calculation.
            */

            if ((power + Math.abs(turn)) > 1) {
                fLPower /= power + turn;
                fRPower /= power + turn;
                bLPower /= power + turn;
                bRPower /= power + turn;
            }

            fL.setPower(frontLeftP);
            fR.setPower(frontRightP);
            bL.setPower(backLeftP);
            bR.setPower(backRightP);

			telemetry.addData("Front	left/Right",	"%4.2f,	%4.2f",	frontLeftP,	frontRightP);
			telemetry.addData("Back		left/Right",	"%4.2f,	%4.2f",	backLeftP,	backRightP);
			telemetry.update();

		}
	}
}
