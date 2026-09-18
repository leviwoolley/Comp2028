//	package	org.firstinspires.ftc.teamcode;
//	
//	import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//	import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//	import	com.qualcomm.robotcore.hardware.DcMotor;
//	
//	@TeleOp(name	=	"Trial14	(Blocks	to	Java)")
//	public	class	Trial14	extends	LinearOpMode	{
//	
//			private	DcMotor	BL;
//			private	DcMotor	FL;
//			private	DcMotor	FR;
//			private	DcMotor	BR;
//			private	DcMotor	CA;
//	
//			/**
//				*	This	function	is	executed	when	this	Op	Mode	is	selected	from	the	Driver	Station.
//				*/
//			@Override
//			public	void	runOpMode()	{
//					float	Left;
//					double	right;
//					double	Arm;
//	
//					BL	=	hardwareMap.get(DcMotor.class,	"BL");
//					FL	=	hardwareMap.get(DcMotor.class,	"FL");
//					FR	=	hardwareMap.get(DcMotor.class,	"FR");
//					BR	=	hardwareMap.get(DcMotor.class,	"BR");
//					CA	=	hardwareMap.get(DcMotor.class,	"CA");
//	
//					//	Put	initialization	blocks	here.
//					waitForStart();
//					if	(opModeIsActive())	{
//							//	Put	run	blocks	here.
//							while	(opModeIsActive())	{
//									//	Put	loop	blocks	here.
//									Left	=	gamepad1.left_stick_y;
//									right	=	-gamepad1.right_stick_y;
//									Arm	=	gamepad1.a;
//									BL.setPower(Left);
//									telemetry.addData("read	target	power",	Left);
//									telemetry.addData("Motor	power",	BL.getPower());
//									FL.setPower(Left);
//									telemetry.addData("read	target	power",	Left);
//									telemetry.addData("Motor	power",	FL.getPower());
//									telemetry.update();
//									FR.setPower(right);
//									telemetry.addData("read	target	power",	right);
//									telemetry.addData("Motor	power",	FR.getPower());
//									BR.setPower(right);
//									telemetry.addData("read	target	power",	right);
//									telemetry.addData("Motor	power",	BR.getPower());
//									CA.setPower(Arm);
//									telemetry.addData("read	target	power",	Arm);
//									telemetry.addData("Motor	power",	CA.getPower());
//							}
//					}
//			}
//	}
//	