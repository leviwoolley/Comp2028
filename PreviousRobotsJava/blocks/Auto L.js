/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  RightMotorAsDcMotor.setDirection("REVERSE");
  LeftMotorAsDcMotor.setDirection("REVERSE");
  BillyMotorAsDcMotor.setDirection("REVERSE");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    RightMotorAsDcMotor.setDualPower(0.5, LeftMotorAsDcMotor, 0.5);
    BillyMotorAsDcMotor.setDualPower(-0.3, BillyMotorAsDcMotor, -0.3);
    linearOpMode.sleep(250);
    runOpmode2();
  }
}

/**
 * Describe this function...
 */
function runopmode3() {
  LeftMotorAsDcMotor.setDirection("REVERSE");
  RightMotorAsDcMotor.setDirection("REVERSE");
  BillyMotorAsDcMotor.setDirection("REVERSE");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    RightMotorAsDcMotor.setDualPower(1, LeftMotorAsDcMotor, 1);
    BillyMotorAsDcMotor.setDualPower(-0.1, BillyMotorAsDcMotor, -0.1);
    linearOpMode.sleep(2500);
  }
}

/**
 * Describe this function...
 */
function runOpmode2() {
  LeftMotorAsDcMotor.setDirection("FORWARD");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    RightMotorAsDcMotor.setDualPower(1, LeftMotorAsDcMotor, 1);
    linearOpMode.sleep(900);
    runopmode3();
  }
}
