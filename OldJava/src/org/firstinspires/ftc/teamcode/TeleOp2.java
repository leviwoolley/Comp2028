/*
Copyright	2021	FIRST	Tech	Challenge	Team	Bruins

Permission	is	hereby	granted,	free	of	charge,	to	any	person	obtaining	a	copy	of	this	software	and
associated	documentation	files	(the	"Software"),	to	deal	in	the	Software	without	restriction,
including	without	limitation	the	rights	to	use,	copy,	modify,	merge,	publish,	distribute,
sublicense,	and/or	sell	copies	of	the	Software,	and	to	permit	persons	to	whom	the	Software	is
furnished	to	do	so,	subject	to	the	following	conditions:

The	above	copyright	notice	and	this	permission	notice	shall	be	included	in	all	copies	or	substantial
portions	of	the	Software.

THE	SOFTWARE	IS	PROVIDED	"AS	IS",	WITHOUT	WARRANTY	OF	ANY	KIND,	EXPRESS	OR	IMPLIED,	INCLUDING	BUT
NOT	LIMITED	TO	THE	WARRANTIES	OF	MERCHANTABILITY,	FITNESS	FOR	A	PARTICULAR	PURPOSE	AND
NONINFRINGEMENT.	IN	NO	EVENT	SHALL	THE	AUTHORS	OR	COPYRIGHT	HOLDERS	BE	LIABLE	FOR	ANY	CLAIM,
DAMAGES	OR	OTHER	LIABILITY,	WHETHER	IN	AN	ACTION	OF	CONTRACT,	TORT	OR	OTHERWISE,	ARISING	FROM,
OUT	OF	OR	IN	CONNECTION	WITH	THE	SOFTWARE	OR	THE	USE	OR	OTHER	DEALINGS	IN	THE	SOFTWARE.
*/
package	org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.hardware.Servo;
import	com.qualcomm.robotcore.hardware.Blinker;
import	com.qualcomm.robotcore.hardware.Gyroscope;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.eventloop.opmode.Disabled;
import	com.qualcomm.robotcore.hardware.DcMotor;
import	com.qualcomm.robotcore.hardware.DcMotorSimple;
import	com.qualcomm.robotcore.util.ElapsedTime;

/**
	*	This	file	contains	an	minimal	example	of	a	Linear	"OpMode".	An	OpMode	is	a	'program'	that	runs	in	either
	*	the	autonomous	or	the	teleop	period	of	an	FTC	match.	The	names	of	OpModes	appear	on	the	menu
	*	of	the	FTC	Driver	Station.	When	an	selection	is	made	from	the	menu,	the	corresponding	OpMode
	*	class	is	instantiated	on	the	Robot	Controller	and	executed.
	*
	*	This	particular	OpMode	just	executes	a	basic	Tank	Drive	Teleop	for	a	PushBot
	*	It	includes	all	the	skeletal	structure	that	all	linear	OpModes	contain.
	*
	*	Remove	a	@Disabled	the	on	the	next	line	or	two	(if	present)	to	add	this	opmode	to	the	Driver	Station	OpMode	list,
	*	or	add	a	@Disabled	annotation	to	prevent	this	OpMode	from	being	added	to	the	Driver	Station
	*/
@TeleOp

public	class	TeleOp2	extends	LinearOpMode	{
				private	DcMotor	billyMotor;
				private	Blinker	control_Hub;
				private	DcMotor	leftMotor;
				private	DcMotor	rightMotor;
				private	DcMotor	spinnyBoi;
				private	Servo	latch;
				private	Servo	bucketTip;
				private	Gyroscope	imu;


				@Override
				public	void	runOpMode()	{
								billyMotor	=	hardwareMap.get(DcMotor.class,	"BillyMotor");
								control_Hub	=	hardwareMap.get(Blinker.class,	"Control	Hub");
								leftMotor	=	hardwareMap.get(DcMotor.class,	"LeftMotor");
								rightMotor	=	hardwareMap.get(DcMotor.class,	"RightMotor");
								spinnyBoi	=	hardwareMap.get(DcMotor.class,	"SpinnyBoi");
								latch	=	hardwareMap.get(Servo.class,	"latch");
								bucketTip	=	hardwareMap.get(Servo.class,	"bucketTip");
								imu	=	hardwareMap.get(Gyroscope.class,	"imu");

								telemetry.addData("Status",	"Initialized");
								telemetry.update();
								//	Wait	for	the	game	to	start	(driver	presses	PLAY)
								waitForStart();

								//	run	until	the	end	of	the	match	(driver	presses	STOP)
								double	tgtPower	=	0;
								
								while	(opModeIsActive())	{
												tgtPower	=	-this.gamepad1.left_stick_y;
												
												//Left	Motor	Program
												leftMotor.setPower(tgtPower);
												
												telemetry.addData("Target	Power",	tgtPower);
												
												telemetry.addData("Motor	Power",	leftMotor.getPower());
												
												//Right	Motor	Program
												tgtPower	=	this.gamepad1.right_stick_y;
												
												rightMotor.setPower(tgtPower);
												
												telemetry.addData("Target	Power",	tgtPower);
												
												telemetry.addData("Motor	Power",	rightMotor.getPower());
												
												//Bill	Motor	Program
												
												if(gamepad1.a)	{
																billyMotor.setPower(0);
												}	else	if	(gamepad1.b)	{
																billyMotor.setPower(0.50);
												}	else	if	(gamepad1.x)	{
																billyMotor.setPower(0.25);
												}	else	if(gamepad1.y)	{
																billyMotor.setTargetPosition(-1);
												}
												
												telemetry.addData("Motor	Power",	billyMotor.getPower());
												//Spinnyboi	Motor	Program
												tgtPower	=	-this.gamepad2.right_stick_y;
												
												spinnyBoi.setPower(tgtPower);
												
												telemetry.addData("Target	Power",	tgtPower);
												
												telemetry.addData("Motor	Power",	spinnyBoi.getPower());
												
												telemetry.addData("Status",	"Running");
												
												//latch	Servo	Program
												if(gamepad2.a)	{
																latch.setPosition(0);
												}	else	if	(gamepad2.b)	{
																latch.setPosition(0.5);
												}
												telemetry.addData("Servo	Position",	latch.getPosition());
												//bucketTip	Servo	Program
												if(gamepad2.x)	{
																bucketTip.setPosition(0);
												
												}	else	if	(gamepad2.y)	{
																bucketTip.setPosition(0.5);
												}
												telemetry.addData("Servo	Position",	bucketTip.getPosition());
												telemetry.update();

								}
				}
}
