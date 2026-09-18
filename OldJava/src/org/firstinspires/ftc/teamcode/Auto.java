package	org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.hardware.DcMotor;
import	com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name	=	"Auto	(Blocks	to	Java)")
public	class	Auto	extends	LinearOpMode	{

		private	DcMotor	FL;
		private	DcMotor	FR;

		/**
			*	This	function	is	executed	when	this	Op	Mode	is	selected	from	the	Driver	Station.
			*/
		@Override
		public	void	runOpMode()	{
				//	TODO:	Enter	the	type	for	variable	named	i
				long	i;

				FL	=	hardwareMap.get(DcMotor.class,	"FL");
				FR	=	hardwareMap.get(DcMotor.class,	"FR");

				//	Put	initialization	blocks	here.
				FL.setDirection(DcMotorSimple.Direction.REVERSE);
				FR.setDirection(DcMotorSimple.Direction.FORWARD);
				waitForStart();
				for	(i	=	1;	i	<=	10;	i++)	{
						for	(int	count	=	0;	count	<	10;	count++)	{
								FR.setTargetPosition(+180);
								FL.setTargetPosition(+180);	
						}
				}
				while	(opModeIsActive())	{
						//	Put	loop	blocks	here.
						telemetry.update();
				}
		}
}
