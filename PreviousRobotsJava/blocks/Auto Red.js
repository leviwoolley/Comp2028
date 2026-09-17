/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  LeftMotorAsDcMotor.setDirection("REVERSE");
  RightMotorAsDcMotor.setDirection("REVERSE");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    BillyMotorAsDcMotor.setPower(1);
    linearOpMode.sleep(1000);
  }
}
