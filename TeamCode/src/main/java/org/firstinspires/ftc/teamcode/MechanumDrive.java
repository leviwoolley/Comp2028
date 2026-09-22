package	org.firstinspires.ftc.robotcontroller.external.samples;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.hardware.DcMotor;
import	com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Mechanum	Drive",	group="Linear	OpMode")

public	class	MechanumDrive	extends	LinearOpMode	{

	private	DcMotor	fL;
	private	DcMotor	bL;
	private	DcMotor	fR;
	private	DcMotor	bR;

	private	double	x;
	private	double	y;
	private	double	turn;
	private	double	theta;
	private	double	power;
				
	private double sin;
	private double cos;
	private double max;

	private	double	frontLeftP;
	private	double	backLeftP;
	private	double	frontRightP;
	private	double	backRightP;

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

			x	=	gamepad1.left_stick_x;
			y	=	-gamepad1.left_stick_y;
			turn	=	gamepad1.right_stick_x;

			theta	=	Math.atan2(y,	x);
			power	=	Math.hypot(x,	y);

			sin	=	Math.sin(theta	-	Math.PI/4);
			cos	=	Math.cos(theta	-	Math.PI/4);
			max	=	Math.max(Math.abs(sin),	Math.abs(cos));

			frontLeftP	=	power	*	cos/max	+	turn;
			frontRightP	=	power	*	sin/max	-	turn;
			backLeftP	=	power	*	sin/max	+	turn;
			backRightP	=	power	*	cos/max	-	turn;

			if	((power	+	Math.abs(turn))	>	1)	{
				frontLeftP	/=	power	+	Math.abs(turn);
				frontRightP	/=	power	+	Math.abs(turn);
				backLeftP	/=	power	+	Math.abs(turn);
				backRightP	=	power	+	Math.abs(turn);
				}
												
			if (gamepad1.a) {
				fL.setPower(1.0);
			}
			if (gamepad1.b) {
				fR.setPower(1.0);
			}
			if (gamepad1.x) {
				bL.setPower(1.0);
			}
			if (gamepad1.y) {
				fR.setPower(1.0);
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
