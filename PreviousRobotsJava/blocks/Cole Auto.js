// IDENTIFIERS_USED=BucketAsServo,LeftMotorAsDcMotor,RightMotorAsDcMotor

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  BucketAsServo.setDirection("REVERSE");
  LeftMotorAsDcMotor.setDirection("REVERSE");
  RightMotorAsDcMotor.setDirection("REVERSE");
  BucketAsServo.setPosition(0);
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    BucketAsServo.setPosition(0.8);
    LeftMotorAsDcMotor.setDualPower(0.5, RightMotorAsDcMotor, 0.5);
    linearOpMode.sleep(6200);
    runOpMode2();
  }
}

/**
 * Describe this function...
 */
function runOpmode3() {
  RightMotorAsDcMotor.setDirection("REVERSE");
  LeftMotorAsDcMotor.setDirection("REVERSE");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    LeftMotorAsDcMotor.setDualPower(0.5, RightMotorAsDcMotor, 0.5);
    linearOpMode.sleep(2000);
  }
}

/**
 * Describe this function...
 */
function runOpMode2() {
  LeftMotorAsDcMotor.setDirection("FORWARD");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    LeftMotorAsDcMotor.setDualPower(0.5, RightMotorAsDcMotor, 0.5);
    linearOpMode.sleep(850);
    runOpmode3();
  }
}
