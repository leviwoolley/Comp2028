// package	org.firstinspires.ftc.teamcode;
// 
// import	com.qualcomm.hardware.bosch.BNO055IMU;
// import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import	com.qualcomm.robotcore.hardware.DcMotor;
// import	com.qualcomm.robotcore.hardware.DcMotorSimple;
// 
// @TeleOp(name	=	"Colorsensor	(Blocks	to	Java)")
// public	class	Colorsensor	extends	LinearOpMode	{
// 
// 		private	DcMotor	fr;
// 		private	DcMotor	br;
// 		private	DcMotor	bl;
// 		private	DcMotor	fl;
// 		private	DcMotor	pullarm;
// 		private	BNO055IMU	imu;
// 
// 		/**
// 			*	This	function	is	executed	when	this	Op	Mode	is	selected	from	the	Driver	Station.
// 			*/
// 		@Override
// 		public	void	runOpMode()	{
// 				int	speed_multiplier;
// 
// 				fr	=	hardwareMap.get(DcMotor.class,	"fr");
// 				br	=	hardwareMap.get(DcMotor.class,	"br");
// 				bl	=	hardwareMap.get(DcMotor.class,	"bl");
// 				fl	=	hardwareMap.get(DcMotor.class,	"fl");
// 				pullarm	=	hardwareMap.get(DcMootor.class,	"pullarm");
// 				imu	=	hardwareMap.get(BNO055IMU.class,	"imu");
// 
// 				//	Put	initialization	blocks	here.
// 				fr.setDirection(DcMotorSimple.Direction.FORWARD);
// 				br.setDirection(DcMotorSimple.Direction.REVERSE);
// 				bl.setDirection(DcMotorSimple.Direction.REVERSE);
// 				fl.setDirection(DcMotorSimple.Direction.FORWARD);
// 				pullarm.setDirection(DcMotorSimple.Direction.FORWARD);
// 				speed_multiplier	=	2;
// 				waitForStart();
// 				if	(opModeIsActive())	{
// 						//	Put	run	blocks	here.
// 						while	(opModeIsActive())	{
// 								//	Put	loop	blocks	here.
// 								if	(gamepad2.A	!=0)	{
// 										pullarm.setPower(gamepad1.A);
// 								}
// 								if	(gamepad1.right_trigger	!=	0)	{
// 										fr.setPower((-1	*	gamepad1.right_trigger)	/	speed_multiplier);
// 										br.setPower(gamepad1.right_trigger);
// 										fl.setPower(-1	*	gamepad1.right_trigger);
// 										bl.setPower(gamepad1.right_trigger);
// 								}	else	if	(gamepad1.left_trigger	!=	0)	{
// 										fr.setPower(gamepad1.left_trigger);
// 										br.setPower(-1	*	gamepad1.left_trigger);
// 										fl.setPower(gamepad1.left_trigger);
// 										bl.setPower(-1	*	gamepad1.left_trigger);
// 								}	else	{
// 										if	(Math.abs(gamepad1.left_stick_y)	>	Math.abs(gamepad1.left_stick_x))	{
// 												bl.setPower(gamepad1.left_stick_y);
// 												fl.setPower(gamepad1.left_stick_y);
// 												br.setPower(gamepad1.left_stick_y);
// 												fr.setPower(gamepad1.left_stick_y);
// 										}	else	{
// 												br.setPower(-1	*	gamepad1.left_stick_x);
// 												fr.setPower(gamepad1.left_stick_x);
// 												bl.setPower(gamepad1.left_stick_x);
// 												fl.setPower(-1	*	gamepad1.left_stick_x);
// 										}
// 										if	(gamepad1.dpad_right)	{
// 												speed_multiplier	+=	0.5;
// 										}
// 										if	(gamepad1.dpad_left)	{
// 												speed_multiplier	+=	-0.5;
// 										}
// 										if	(gamepad1.dpad_up)	{
// 												speed_multiplier	=	2;
// 										}
// 								}
// 								telemetry.update();
// 						}
// 				}
// 		}
// }