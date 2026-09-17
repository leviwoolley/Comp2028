// IDENTIFIERS_USED=blAsDcMotor,brAsDcMotor,flAsDcMotor,frAsDcMotor,gamepad1

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  flAsDcMotor.setDirection("FORWARD");
  frAsDcMotor.setDirection("REVERSE");
  blAsDcMotor.setDirection("REVERSE");
  brAsDcMotor.setDirection("FORWARD");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      if (gamepad1.getLeftStickY() >= 0.1) {
        flAsDcMotor.setPower(gamepad1.getLeftStickY());
        frAsDcMotor.setPower(gamepad1.getLeftStickY());
        blAsDcMotor.setPower(gamepad1.getLeftStickY());
        brAsDcMotor.setPower(gamepad1.getLeftStickY());
      } else if (gamepad1.getLeftStickY() <= -0.1) {
        flAsDcMotor.setPower(gamepad1.getLeftStickY());
        frAsDcMotor.setPower(gamepad1.getLeftStickY());
        blAsDcMotor.setPower(gamepad1.getLeftStickY());
        brAsDcMotor.setPower(gamepad1.getLeftStickY());
      } else if (gamepad1.getLeftStickX() <= -0.1) {
        flAsDcMotor.setPower(-gamepad1.getLeftStickX());
        frAsDcMotor.setPower(gamepad1.getLeftStickX());
        blAsDcMotor.setPower(gamepad1.getLeftStickX());
        brAsDcMotor.setPower(-gamepad1.getLeftStickX());
      } else if (gamepad1.getLeftStickX() >= 0.1) {
        flAsDcMotor.setPower(-gamepad1.getLeftStickX());
        frAsDcMotor.setPower(gamepad1.getLeftStickX());
        blAsDcMotor.setPower(gamepad1.getLeftStickX());
        brAsDcMotor.setPower(-gamepad1.getLeftStickX());
      }
      if (gamepad1.getLeftTrigger() > 0.1) {
        flAsDcMotor.setPower(gamepad1.getLeftTrigger());
        frAsDcMotor.setPower(-gamepad1.getLeftTrigger());
        blAsDcMotor.setPower(gamepad1.getLeftTrigger());
        brAsDcMotor.setPower(-gamepad1.getLeftTrigger());
      } else if (gamepad1.getRightTrigger() > 0.1) {
        flAsDcMotor.setPower(-gamepad1.getRightTrigger());
        frAsDcMotor.setPower(gamepad1.getRightTrigger());
        blAsDcMotor.setPower(-gamepad1.getRightTrigger());
        brAsDcMotor.setPower(gamepad1.getRightTrigger());
      }
      if (gamepad1.getLeftBumper()) {
        flAsDcMotor.setPower(0.25);
        frAsDcMotor.setPower(-0.25);
        blAsDcMotor.setPower(0.25);
        brAsDcMotor.setPower(-0.25);
      } else if (gamepad1.getRightBumper()) {
        flAsDcMotor.setPower(-0.25);
        frAsDcMotor.setPower(0.25);
        blAsDcMotor.setPower(-0.25);
        brAsDcMotor.setPower(0.25);
      }
      if (gamepad1.getRightStickY() >= 0.1) {
        flAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
        frAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
        blAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
        brAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
      } else if (gamepad1.getRightStickY() <= -0.1) {
        flAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
        frAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
        blAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
        brAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
      } else if (gamepad1.getRightStickX() <= -0.1) {
        flAsDcMotor.setPower(0.5 * -gamepad1.getRightStickX());
        frAsDcMotor.setPower(0.5 * gamepad1.getRightStickX());
        blAsDcMotor.setPower(0.5 * gamepad1.getRightStickX());
        brAsDcMotor.setPower(0.5 * -gamepad1.getRightStickX());
      } else if (gamepad1.getRightStickX() >= 0.1) {
        flAsDcMotor.setPower(0.5 * -gamepad1.getRightStickX());
        frAsDcMotor.setPower(0.5 * gamepad1.getRightStickX());
        blAsDcMotor.setPower(0.5 * gamepad1.getRightStickX());
        brAsDcMotor.setPower(0.5 * -gamepad1.getRightStickX());
      }
      if (gamepad1.getLeftStickY() < 0.1 && gamepad1.getLeftStickY() > -0.1 && gamepad1.getLeftStickX() < 0.1 && gamepad1.getLeftStickX() > -0.1) {
        flAsDcMotor.setPower(0);
        frAsDcMotor.setPower(0);
        blAsDcMotor.setPower(0);
        brAsDcMotor.setPower(0);
      } else if (gamepad1.getRightTrigger() < 0.1) {
        flAsDcMotor.setPower(0);
        frAsDcMotor.setPower(0);
        blAsDcMotor.setPower(0);
        brAsDcMotor.setPower(0);
      } else if (gamepad1.getLeftTrigger() > -0.1) {
        flAsDcMotor.setPower(0);
        frAsDcMotor.setPower(0);
        blAsDcMotor.setPower(0);
        brAsDcMotor.setPower(0);
      }
      telemetry.update();
    }
  }
}
