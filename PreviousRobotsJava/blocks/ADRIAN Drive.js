// IDENTIFIERS_USED=_911simAsServo,ArmLAsDcMotor,ArmRAsDcMotor,blAsDcMotor,brAsDcMotor,flAsDcMotor,frAsDcMotor,gamepad1,gamepad2,hangLAsDcMotor,hangRAsDcMotor,servoclawAsCRServo,ServoswivelAsCRServo

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  flAsDcMotor.setDirection("REVERSE");
  frAsDcMotor.setDirection("FORWARD");
  blAsDcMotor.setDirection("FORWARD");
  brAsDcMotor.setDirection("REVERSE");
  ServoswivelAsCRServo.setDirection("FORWARD");
  servoclawAsCRServo.setDirection("FORWARD");
  _911simAsServo.setDirection("FORWARD");
  _911simAsServo.setDirection("REVERSE");
  ArmLAsDcMotor.setDirection("FORWARD");
  ArmRAsDcMotor.setDirection("REVERSE");
  hangLAsDcMotor.setDirection("REVERSE");
  hangRAsDcMotor.setDirection("FORWARD");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      if (gamepad1.getRightTrigger() > 0.1) {
        flAsDcMotor.setPower(gamepad1.getRightTrigger());
        frAsDcMotor.setPower(gamepad1.getRightTrigger());
        blAsDcMotor.setPower(gamepad1.getRightTrigger());
        brAsDcMotor.setPower(gamepad1.getRightTrigger());
      } else if (gamepad1.getLeftTrigger() > 0.1) {
        flAsDcMotor.setPower(-gamepad1.getLeftTrigger());
        frAsDcMotor.setPower(-gamepad1.getLeftTrigger());
        blAsDcMotor.setPower(-gamepad1.getLeftTrigger());
        brAsDcMotor.setPower(-gamepad1.getLeftTrigger());
      }
      if (gamepad1.getLeftBumper()) {
        flAsDcMotor.setPower(-1);
        frAsDcMotor.setPower(1);
        blAsDcMotor.setPower(1);
        brAsDcMotor.setPower(-1);
      } else if (gamepad1.getRightBumper()) {
        flAsDcMotor.setPower(1);
        frAsDcMotor.setPower(-1);
        blAsDcMotor.setPower(-1);
        brAsDcMotor.setPower(1);
      }
      if (gamepad1.getLeftStickX() <= -0.1 && gamepad1.getLeftStickY() <= 0.5 && gamepad1.getLeftStickY() >= -0.5) {
        flAsDcMotor.setPower(gamepad1.getLeftStickX());
        frAsDcMotor.setPower(-gamepad1.getLeftStickX());
        blAsDcMotor.setPower(gamepad1.getLeftStickX());
        brAsDcMotor.setPower(-gamepad1.getLeftStickX());
      } else if (gamepad1.getLeftStickX() >= 0.1 && gamepad1.getLeftStickY() <= 0.5 && gamepad1.getLeftStickY() >= -0.5) {
        flAsDcMotor.setPower(gamepad1.getLeftStickX());
        frAsDcMotor.setPower(-gamepad1.getLeftStickX());
        blAsDcMotor.setPower(gamepad1.getLeftStickX());
        brAsDcMotor.setPower(-gamepad1.getLeftStickX());
      }
      if (gamepad1.getRightStickX() <= -0.1) {
        flAsDcMotor.setPower(0.5 * gamepad1.getRightStickX());
        frAsDcMotor.setPower(0.5 * -gamepad1.getRightStickX());
        blAsDcMotor.setPower(0.5 * gamepad1.getRightStickX());
        brAsDcMotor.setPower(0.5 * -gamepad1.getRightStickX());
      } else if (gamepad1.getRightStickX() >= 0.1) {
        flAsDcMotor.setPower(0.5 * gamepad1.getRightStickX());
        frAsDcMotor.setPower(0.5 * -gamepad1.getRightStickX());
        blAsDcMotor.setPower(0.5 * gamepad1.getRightStickX());
        brAsDcMotor.setPower(0.5 * -gamepad1.getRightStickX());
      }
      if (gamepad2.getRightTrigger() > 0.5) {
        ArmLAsDcMotor.setPower(0.5 * gamepad2.getRightTrigger());
        ArmRAsDcMotor.setPower(0.5 * gamepad2.getRightTrigger());
      } else if (gamepad2.getLeftTrigger() > 0.5) {
        ArmLAsDcMotor.setPower(-(0.5 * gamepad2.getLeftTrigger()));
        ArmRAsDcMotor.setPower(-(0.5 * gamepad2.getLeftTrigger()));
      } else if (gamepad2.getLeftTrigger() < 0.5 && gamepad2.getRightTrigger() < 0.5) {
        ArmLAsDcMotor.setPower(0);
        ArmRAsDcMotor.setPower(0);
      }
      if (gamepad2.getRightBumper()) {
        hangLAsDcMotor.setPower(1);
        hangRAsDcMotor.setPower(1);
      } else if (gamepad2.getLeftBumper()) {
        hangLAsDcMotor.setPower(-1);
        hangRAsDcMotor.setPower(-1);
      } else if (!gamepad2.getLeftBumper()) {
        hangLAsDcMotor.setPower(0);
        hangRAsDcMotor.setPower(0);
      } else if (!gamepad2.getRightBumper()) {
        hangLAsDcMotor.setPower(0);
        hangRAsDcMotor.setPower(0);
      }
      if (gamepad2.getY()) {
        while (!gamepad2.getX()) {
          hangLAsDcMotor.setPower(-0.5);
          hangRAsDcMotor.setPower(-0.5);
          linearOpMode.sleep(100);
          hangLAsDcMotor.setPower(0);
          hangRAsDcMotor.setPower(0);
          linearOpMode.sleep(100);
        }
      }
      if (gamepad2.getLeftStickY() >= 0.1) {
        ServoswivelAsCRServo.setPower(-gamepad2.getLeftStickY());
      } else if (gamepad2.getLeftStickY() <= -0.1) {
        ServoswivelAsCRServo.setPower(-gamepad2.getLeftStickY());
      } else if (gamepad2.getLeftStickY() < 0.1 && gamepad2.getLeftStickY() > -0.1) {
        ServoswivelAsCRServo.setPower(0);
      }
      if (gamepad2.getA()) {
        servoclawAsCRServo.setPower(1);
      } else if (gamepad2.getB()) {
        servoclawAsCRServo.setPower(-1);
      } else if (!gamepad2.getA() && !gamepad2.getB()) {
        servoclawAsCRServo.setPower(0);
      }
      if (gamepad2.getDpadUp()) {
        _911simAsServo.setPosition(-360);
      } else if (gamepad2.getDpadDown()) {
        _911simAsServo.setPosition(360);
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
