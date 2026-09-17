package	org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name	=	"_2021ManualControls2	(Blocks	to	Java)")
public	class	_2021ManualControls2	extends	LinearOpMode	{

		private	DcMotor	FR;
		private	DcMotor	FL;

		/**
			*	This	function	is	executed	when	this	Op	Mode	is	selected	from	the	Driver	Station.
			*/
		@Override
		public	void	runOpMode()	{
				FR	=	hardwareMap.get(DcMotor.class,	"FR");
				FL	=	hardwareMap.get(DcMotor.class,	"FL");

				waitForStart();
				if	(0	<	gamepad1.left_stick_y)	{
						FR.setPower(1);
				}	else	{
						FR.setPower(0);
				}
				if	(0	>	gamepad1.left_stick_y)	{
						FR.setPower(-1);
				}	else	{
						FR.setPower(0);
				}
				if	(0	<	gamepad1.right_stick_y)	{
						FL.setPower(1);
				}	else	{
						FL.setPower(0);
				}
				if	(0	>	gamepad1.right_stick_y)	{
						FL.setPower(-1);
				}	else	{
						FL.setPower(0);
				}
		}
}
