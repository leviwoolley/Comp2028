package	org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name	=	"Trial12	(Blocks	to	Java)")
public	class	Trial12	extends	LinearOpMode	{

		private	DcMotor	BL;
		private	DcMotor	FL;
		private	DcMotor	FR;
		private	DcMotor	BR;

		/**
			*	This	function	is	executed	when	this	Op	Mode	is	selected	from	the	Driver	Station.
			*/
		@Override
		public	void	runOpMode()	{
				float	Left;
				double	right;

				BL	=	hardwareMap.get(DcMotor.class,	"BL");
				FL	=	hardwareMap.get(DcMotor.class,	"FL");
				FR	=	hardwareMap.get(DcMotor.class,	"FR");
				BR	=	hardwareMap.get(DcMotor.class,	"BR");

				//	Put	initialization	blocks	here.
				waitForStart();
				if	(opModeIsActive())	{
						//	Put	run	blocks	here.
						while	(opModeIsActive())	{
								//	Put	loop	blocks	here.
								Left	=	gamepad1.left_stick_y;
								right	=	-gamepad1.right_stick_y;
								BL.setPower(Left);
								telemetry.addData("read	target	power",	Left);
								telemetry.addData("Motor	power",	BL.getPower());
								FL.setPower(Left);
								telemetry.addData("read	target	power",	Left);
								telemetry.addData("Motor	power",	FL.getPower());
								telemetry.update();
								FR.setPower(right);
								telemetry.addData("read	target	power",	right);
								telemetry.addData("Motor	power",	FR.getPower());
								BR.setPower(right);
								telemetry.addData("read	target	power",	right);
								telemetry.addData("Motor	power",	BR.getPower());
						}
				}
		}
}
