// IDENTIFIERS_USED=blAsDcMotor,brAsDcMotor,flAsDcMotor,frAsDcMotor,gamepad1

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  flAsDcMotor.setDirection("FORWARD");
  frAsDcMotor.setDirection("FORWARD");
  blAsDcMotor.setDirection("FORWARD");
  brAsDcMotor.setDirection("FORWARD");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      if (gamepad1.getLeftStickY() >= 0.01) {
        flAsDcMotor.setPower(gamepad1.getLeftStickY());
        frAsDcMotor.setPower(gamepad1.getLeftStickY());
        blAsDcMotor.setPower(gamepad1.getLeftStickY());
        brAsDcMotor.setPower(gamepad1.getLeftStickY());
      }
      if (gamepad1.getLeftStickY() <= 0.01) {
        flAsDcMotor.setPower(gamepad1.getLeftStickY());
        frAsDcMotor.setPower(gamepad1.getLeftStickY());
        blAsDcMotor.setPower(gamepad1.getLeftStickY());
        brAsDcMotor.setPower(gamepad1.getLeftStickY());
      }
      if (gamepad1.getLeftStickX() <= 0.01) {
        flAsDcMotor.setPower(gamepad1.getLeftStickY());
        frAsDcMotor.setPower(gamepad1.getLeftStickY());
        blAsDcMotor.setPower(-gamepad1.getLeftStickY());
        brAsDcMotor.setPower(-gamepad1.getLeftStickY());
      }
      if (gamepad1.getLeftStickX() >= 0.01) {
        flAsDcMotor.setPower(-gamepad1.getLeftStickY());
        frAsDcMotor.setPower(-gamepad1.getLeftStickY());
        blAsDcMotor.setPower(gamepad1.getLeftStickY());
        brAsDcMotor.setPower(gamepad1.getLeftStickY());
      }
      if (gamepad1.getLeftTrigger() >= 0.01) {
        flAsDcMotor.setPower(gamepad1.getLeftStickY());
        frAsDcMotor.setPower(-gamepad1.getLeftStickY());
        blAsDcMotor.setPower(-gamepad1.getLeftStickY());
        brAsDcMotor.setPower(gamepad1.getLeftStickY());
      }
      if (gamepad1.getRightTrigger() >= 0.01) {
        flAsDcMotor.setPower(-gamepad1.getLeftStickY());
        frAsDcMotor.setPower(gamepad1.getLeftStickY());
        blAsDcMotor.setPower(gamepad1.getLeftStickY());
        brAsDcMotor.setPower(-gamepad1.getLeftStickY());
      }
      telemetry.update();
    }
  }
}
