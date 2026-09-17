// IDENTIFIERS_USED=blAsDcMotor,brAsDcMotor,flAsDcMotor,frAsDcMotor,gamepad1

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  blAsDcMotor.setDirection("FORWARD");
  brAsDcMotor.setDirection("FORWARD");
  flAsDcMotor.setDirection("FORWARD");
  frAsDcMotor.setDirection("FORWARD");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    if (Math.abs(gamepad1.getLeftStickX()) < gamepad1.getLeftStickY()) {
      blAsDcMotor.setPower(1);
    }
    while (linearOpMode.opModeIsActive()) {
      telemetry.update();
    }
  }
}
