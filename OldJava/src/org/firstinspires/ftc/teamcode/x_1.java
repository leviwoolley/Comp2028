package	org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.hardware.DcMotor;
import	com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name	=	"x_1	(Blocks	to	Java)")
public	class	x_1	extends	LinearOpMode	{

		private	DcMotor	bl;
		private	DcMotor	br;
		private	DcMotor	fl;
		private	DcMotor	fr;

		/**
			*	This	function	is	executed	when	this	Op	Mode	is	selected	from	the	Driver	Station.
			*/
		@Override
		public	void	runOpMode()	{
				bl	=	hardwareMap.get(DcMotor.class,	"bl");
				br	=	hardwareMap.get(DcMotor.class,	"br");
				fl	=	hardwareMap.get(DcMotor.class,	"fl");
				fr	=	hardwareMap.get(DcMotor.class,	"fr");

				//	Put	initialization	blocks	here.
				bl.setDirection(DcMotorSimple.Direction.FORWARD);
				br.setDirection(DcMotorSimple.Direction.FORWARD);
				fl.setDirection(DcMotorSimple.Direction.FORWARD);
				fr.setDirection(DcMotorSimple.Direction.FORWARD);
				waitForStart();
				if	(opModeIsActive())	{
						//	Put	run	blocks	here.
						if	(Math.abs(gamepad1.left_stick_x)	<	gamepad1.left_stick_y)	{
								bl.setPower(1);
						}
						while	(opModeIsActive())	{
								//	Put	loop	blocks	here.
								telemetry.update();
						}
				}
		}
}
