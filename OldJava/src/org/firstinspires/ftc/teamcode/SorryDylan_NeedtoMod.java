package	org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.hardware.CRServo;
import	com.qualcomm.robotcore.hardware.DcMotor;
import	com.qualcomm.robotcore.hardware.ServoController;

@TeleOp(name	=	"SorryDylan_NeedtoMod	(Blocks	to	Java)")
public	class	SorryDylan_NeedtoMod	extends	LinearOpMode	{

		private	DcMotor	fl;
		private	DcMotor	fr;
		private	DcMotor	bl;
		private	DcMotor	br;
		private	CRServo	Servoswivel;
		private	CRServo	servoclaw;
		private	DcMotor	ArmL;
		private	DcMotor	ArmR;
		private	DcMotor	hangL;
		private	DcMotor	hangR;
		private	ServoController	ControlHub_ServoController;

		/**
			*	This	function	is	executed	when	this	Op	Mode	is	selected	from	the	Driver	Station.
			*/
		@Override
		public	void	runOpMode()	{
				fl	=	hardwareMap.get(DcMotor.class,	"fl");
				fr	=	hardwareMap.get(DcMotor.class,	"fr");
				bl	=	hardwareMap.get(DcMotor.class,	"bl");
				br	=	hardwareMap.get(DcMotor.class,	"br");
				Servoswivel	=	hardwareMap.get(CRServo.class,	"Servoswivel");
				servoclaw	=	hardwareMap.get(CRServo.class,	"servoclaw");
				ArmL	=	hardwareMap.get(DcMotor.class,	"ArmL");
				ArmR	=	hardwareMap.get(DcMotor.class,	"ArmR");
				hangL	=	hardwareMap.get(DcMotor.class,	"hangL");
				hangR	=	hardwareMap.get(DcMotor.class,	"hangR");
				ControlHub_ServoController	=	hardwareMap.get(ServoController.class,	"Control	Hub");

				//	DO	NOT	TOUCH	THIS	PROGRAM!!!!!!!!!
				//	Put	initialization	blocks	here.
				fl.setDirection(DcMotor.Direction.REVERSE);
				fr.setDirection(DcMotor.Direction.FORWARD);
				bl.setDirection(DcMotor.Direction.FORWARD);
				br.setDirection(DcMotor.Direction.FORWARD);
				Servoswivel.setDirection(CRServo.Direction.FORWARD);
				servoclaw.setDirection(CRServo.Direction.FORWARD);
				ArmL.setDirection(DcMotor.Direction.FORWARD);
				ArmR.setDirection(DcMotor.Direction.REVERSE);
				hangL.setDirection(DcMotor.Direction.REVERSE);
				hangR.setDirection(DcMotor.Direction.FORWARD);
				waitForStart();
				if	(opModeIsActive())	{
						//	Put	run	blocks	here.
						while	(opModeIsActive())	{
								//	Put	loop	blocks	here.
								//	FORWARD	BACK
								if	(gamepad1.right_trigger	>	0.1)	{
										fl.setPower(gamepad1.right_trigger);
										fr.setPower(gamepad1.right_trigger);
										bl.setPower(gamepad1.right_trigger);
										br.setPower(gamepad1.right_trigger);
								}	else	if	(gamepad1.left_trigger	>	0.1)	{
										fl.setPower(-gamepad1.left_trigger);
										fr.setPower(-gamepad1.left_trigger);
										bl.setPower(-gamepad1.left_trigger);
										br.setPower(-gamepad1.left_trigger);
								}
								//	TURN
								if	(gamepad1.left_bumper)	{
										fl.setPower(1);
										fr.setPower(-1);
										bl.setPower(1);
										br.setPower(-1);
								}	else	if	(gamepad1.right_bumper)	{
										fl.setPower(-1);
										fr.setPower(1);
										bl.setPower(-1);
										br.setPower(1);
								}
								//	LEFT	RIGHT
								if	(gamepad1.left_stick_x	<=	-0.1	&&	gamepad1.left_stick_y	<=	0.5	&&	gamepad1.left_stick_y	>=	-0.5)	{
										fl.setPower(-gamepad1.left_stick_x);
										fr.setPower(gamepad1.left_stick_x);
										bl.setPower(gamepad1.left_stick_x);
										br.setPower(-gamepad1.left_stick_x);
								}	else	if	(gamepad1.left_stick_x	>=	0.1	&&	gamepad1.left_stick_y	<=	0.5	&&	gamepad1.left_stick_y	>=	-0.5)	{
										fl.setPower(-gamepad1.left_stick_x);
										fr.setPower(gamepad1.left_stick_x);
										bl.setPower(gamepad1.left_stick_x);
										br.setPower(-gamepad1.left_stick_x);
								}
								//	SLOW	LEFT	RIGHT
								if	(gamepad1.right_stick_x	<=	-0.1)	{
										fl.setPower(0.5	*	-gamepad1.right_stick_x);
										fr.setPower(0.5	*	gamepad1.right_stick_x);
										bl.setPower(0.5	*	gamepad1.right_stick_x);
										br.setPower(0.5	*	-gamepad1.right_stick_x);
								}	else	if	(gamepad1.right_stick_x	>=	0.1)	{
										fl.setPower(0.5	*	-gamepad1.right_stick_x);
										fr.setPower(0.5	*	gamepad1.right_stick_x);
										bl.setPower(0.5	*	gamepad1.right_stick_x);
										br.setPower(0.5	*	-gamepad1.right_stick_x);
								}
								//	ARM	UP	DOWN
								if	(gamepad2.right_trigger	>	0.5)	{
										ArmL.setPower(gamepad2.right_trigger);
										ArmR.setPower(gamepad2.right_trigger);
								}	else	if	(gamepad2.left_trigger	>	0.5)	{
										ArmL.setPower(-gamepad2.left_trigger);
										ArmR.setPower(-gamepad2.left_trigger);
								}	else	if	(gamepad2.left_trigger	<	0.5	&&	gamepad2.right_trigger	<	0.5)	{
										ArmL.setPower(0);
										ArmR.setPower(0);
								}
								//	HANG	UP	DOWN
								if	(gamepad2.right_bumper)	{
										hangL.setPower(1);
										hangR.setPower(1);
								}	else	if	(gamepad2.left_bumper)	{
										hangL.setPower(-1);
										hangR.setPower(-1);
								}	else	if	(!gamepad2.right_bumper)	{
										hangL.setPower(0);
										hangR.setPower(0);
								}	else	if	(!gamepad2.left_bumper)	{
										hangL.setPower(0);
										hangR.setPower(0);
								}	else	if	(gamepad2.y)	{
										while	(opModeIsActive())	{
												hangL.setPower(0.5);
												hangR.setPower(0.5);
												sleep(100);
												hangL.setPower(0);
												hangR.setPower(0);
												sleep(100);
										}
								}
								//	CLAW	SWIVEL
								if	(gamepad2.left_stick_y	>=	0.1)	{
										Servoswivel.setPower(-gamepad2.left_stick_y);
								}	else	if	(gamepad2.left_stick_y	<=	-0.1)	{
										Servoswivel.setPower(-gamepad2.left_stick_y);
								}	else	if	(gamepad2.left_stick_y	<	0.1	&&	gamepad2.left_stick_y	>	-0.1)	{
										Servoswivel.setPower(0.5);
								}
								//	CLAW	OPEN	CLOSE
								if	(gamepad2.a)	{
										servoclaw.setPower(1);
								}	else	if	(gamepad2.b)	{
										servoclaw.setPower(-1);
								}	else	if	(!gamepad2.a	&&	!gamepad2.b)	{
										servoclaw.setPower(0.55);
								}
								//	DEADZONES
								if	(gamepad1.left_stick_y	<	0.1	&&	gamepad1.left_stick_y	>	-0.1	&&	gamepad1.left_stick_x	<	0.1	&&	gamepad1.left_stick_x	>	-0.1)	{
										fl.setPower(0);
										fr.setPower(0);
										bl.setPower(0);
										br.setPower(0);
								}	else	if	(gamepad1.right_trigger	<	0.1)	{
										fl.setPower(0);
										fr.setPower(0);
										bl.setPower(0);
										br.setPower(0);
								}	else	if	(gamepad1.left_trigger	>	-0.1)	{
										fl.setPower(0);
										fr.setPower(0);
										bl.setPower(0);
										br.setPower(0);
								}
								telemetry.update();
						}
				}
		}
}
