package	org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.hardware.DcMotor;
import	com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name	=	"Teleop	(Blocks	to	Java)")
public	class	Teleop	extends	LinearOpMode	{

		private	DcMotor	_1;
		private	DcMotor	_2;

		/**
			*	This	function	is	executed	when	this	Op	Mode	is	selected	from	the	Driver	Station.
			*/
		@Override
		public	void	runOpMode()	{
				_1	=	hardwareMap.get(DcMotor.class,	"1");
				_2	=	hardwareMap.get(DcMotor.class,	"2");

				//	Put	initialization	blocks	here.
				_1.setTargetPosition(360);
		}
}
