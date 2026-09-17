// IDENTIFIERS_USED=armmototrAsDcMotor,gamepad2

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  armmototrAsDcMotor.setDirection("FORWARD");
  armmototrAsDcMotor.setMode("RUN_WITHOUT_ENCODER");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      if (gamepad2.getRightTrigger() > 0.01) {
        armmototrAsDcMotor.setPower(gamepad2.getRightTrigger());
      }
      if (gamepad2.getRightTrigger() <= 0.01) {
        armmototrAsDcMotor.setPower(0);
      }
      if (gamepad2.getLeftTrigger() > 0.01) {
        armmototrAsDcMotor.setPower(-gamepad2.getLeftTrigger());
      }
      if (gamepad2.getLeftTrigger() <= 0.01) {
        armmototrAsDcMotor.setPower(0);
      }
      telemetry.update();
    }
  }
}
