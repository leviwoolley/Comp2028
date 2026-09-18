package	org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name	=	"BETAx_1	(Blocks	to	Java)")
public	class	X1Beta	extends	LinearOpMode	{
				private	DcMotor	fl;
				private	DcMotor	fr;
				private	DcMotor	bl;
				private	DcMotor	br;
		/**
			*	This	function	is	executed	when	this	Op	Mode	is	selected	from	the	Driver	Station.
			*/
		@Override
		public	void	runOpMode()	{
				//	Put	initialization	blocks	here.
				waitForStart();
				if	(opModeIsActive())	{
						//	Put	run	blocks	here.
						while	(opModeIsActive())	{
								//	Put	loop	blocks	here.
								telemetry.update();
						}
				}
		}
}