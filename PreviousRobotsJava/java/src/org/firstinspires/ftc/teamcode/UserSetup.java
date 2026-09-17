package	org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.hardware.DcMotor;
import	com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name	=	"UserSetup	(Blocks	to	Java)")
public	class	UserSetup	extends	LinearOpMode	{

		private	DcMotor	FR;
		private	DcMotor	FL;

		/**
			*	This	function	is	executed	when	this	Op	Mode	is	selected	from	the	Driver	Station.
			*/
		@Override
		public	void	runOpMode()	{
				FR	=	hardwareMap.get(DcMotor.class,	"FR");
				FL	=	hardwareMap.get(DcMotor.class,	"FL");

				//	Put	initialization	blocks	here.
				waitForStart();
				if	(opModeIsActive())	{
						//	Put	run	blocks	here.
						while	(opModeIsActive())	{
								//	Put	loop	blocks	here.
								telemetry.update();
						}
				}
				if	(gamepad1.dpad_up)	{
						((DcMotorEx)	FR).setVelocity(1);
						((DcMotorEx)	FL).setVelocity(1);
				}	else	{
						((DcMotorEx)	FR).setVelocity(0);
						((DcMotorEx)	FL).setVelocity(0);
				}
				if	(gamepad1.dpad_left)	{
						((DcMotorEx)	FR).setVelocity(1);
						((DcMotorEx)	FL).setVelocity(-1);
				}	else	{
						((DcMotorEx)	FR).setVelocity(0);
						((DcMotorEx)	FL).setVelocity(0);
				}
				if	(gamepad1.dpad_right)	{
						((DcMotorEx)	FR).setVelocity(-1);
						((DcMotorEx)	FL).setVelocity(1);
				}	else	{
						((DcMotorEx)	FR).setVelocity(0);
						((DcMotorEx)	FL).setVelocity(0);
				}
				if	(gamepad1.dpad_down)	{
						((DcMotorEx)	FR).setVelocity(-1);
						((DcMotorEx)	FL).setVelocity(-1);
				}	else	{
						((DcMotorEx)	FR).setVelocity(0);
						((DcMotorEx)	FL).setVelocity(0);
				}
		}
}
