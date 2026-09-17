// IDENTIFIERS_USED=FLAsDcMotor,FRAsDcMotor,LifterAsDcMotor

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  FLAsDcMotor.setDirection("REVERSE");
  FRAsDcMotor.setDirection("REVERSE");
  linearOpMode.waitForStart();
  while (linearOpMode.opModeIsActive()) {
    FLAsDcMotor.setDualPower(1, FRAsDcMotor, 1);
  }
  LifterAsDcMotor.setDirection("REVERSE");
  LifterAsDcMotor.setDirection("FORWARD");
}
