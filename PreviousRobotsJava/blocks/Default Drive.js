// IDENTIFIERS_USED=blAsDcMotor,brAsDcMotor,bucketLeftAsCRServo,bucketRightAsCRServo,clawAsServo,clawExtendAsDcMotor,clawRotateAsServo,flAsDcMotor,frAsDcMotor,gamepad1,gamepad2,hangLeftAsServo,hangRightAsServo,liftLeftAsDcMotor,liftRightAsDcMotor

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  flAsDcMotor.setDirection("REVERSE");
  frAsDcMotor.setDirection("FORWARD");
  blAsDcMotor.setDirection("FORWARD");
  brAsDcMotor.setDirection("REVERSE");
  liftLeftAsDcMotor.setDirection("FORWARD");
  liftRightAsDcMotor.setDirection("REVERSE");
  clawExtendAsDcMotor.setDirection("REVERSE");
  bucketRightAsCRServo.setDirection("REVERSE");
  bucketLeftAsCRServo.setDirection("FORWARD");
  clawRotateAsServo.setDirection("FORWARD");
  clawAsServo.setDirection("FORWARD");
  hangLeftAsServo.setDirection("REVERSE");
  hangRightAsServo.setDirection("FORWARD");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      if (gamepad1.getLeftStickY() >= 0.1 && gamepad1.getLeftStickX() <= 0.5 && gamepad1.getLeftStickX() >= -0.5) {
        flAsDcMotor.setPower(gamepad1.getLeftStickY());
        frAsDcMotor.setPower(gamepad1.getLeftStickY());
        blAsDcMotor.setPower(gamepad1.getLeftStickY());
        brAsDcMotor.setPower(gamepad1.getLeftStickY());
      } else if (gamepad1.getLeftStickY() <= -0.1 && gamepad1.getLeftStickX() <= 0.5 && gamepad1.getLeftStickX() >= -0.5) {
        flAsDcMotor.setPower(gamepad1.getLeftStickY());
        frAsDcMotor.setPower(gamepad1.getLeftStickY());
        blAsDcMotor.setPower(gamepad1.getLeftStickY());
        brAsDcMotor.setPower(gamepad1.getLeftStickY());
      } else if (gamepad1.getLeftStickX() <= -0.1 && gamepad1.getLeftStickY() <= 0.5 && gamepad1.getLeftStickY() >= -0.5) {
        flAsDcMotor.setPower(-gamepad1.getLeftStickX());
        frAsDcMotor.setPower(gamepad1.getLeftStickX());
        blAsDcMotor.setPower(gamepad1.getLeftStickX());
        brAsDcMotor.setPower(-gamepad1.getLeftStickX());
      } else if (gamepad1.getLeftStickX() >= 0.1 && gamepad1.getLeftStickY() <= 0.5 && gamepad1.getLeftStickY() >= -0.5) {
        flAsDcMotor.setPower(-gamepad1.getLeftStickX());
        frAsDcMotor.setPower(gamepad1.getLeftStickX());
        blAsDcMotor.setPower(gamepad1.getLeftStickX());
        brAsDcMotor.setPower(-gamepad1.getLeftStickX());
      }
      if (gamepad1.getLeftTrigger() > 0.1) {
        flAsDcMotor.setPower(-gamepad1.getLeftTrigger());
        frAsDcMotor.setPower(gamepad1.getLeftTrigger());
        blAsDcMotor.setPower(-gamepad1.getLeftTrigger());
        brAsDcMotor.setPower(gamepad1.getLeftTrigger());
      } else if (gamepad1.getRightTrigger() > 0.1) {
        flAsDcMotor.setPower(gamepad1.getRightTrigger());
        frAsDcMotor.setPower(-gamepad1.getRightTrigger());
        blAsDcMotor.setPower(gamepad1.getRightTrigger());
        brAsDcMotor.setPower(-gamepad1.getRightTrigger());
      }
      if (gamepad1.getLeftBumper()) {
        flAsDcMotor.setPower(-0.25);
        frAsDcMotor.setPower(0.25);
        blAsDcMotor.setPower(-0.25);
        brAsDcMotor.setPower(0.25);
      } else if (gamepad1.getRightBumper()) {
        flAsDcMotor.setPower(0.25);
        frAsDcMotor.setPower(-0.25);
        blAsDcMotor.setPower(0.25);
        brAsDcMotor.setPower(-0.25);
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
      if (gamepad2.getB()) {
        clawAsServo.setPosition(0);
      }
      if (gamepad2.getA()) {
        clawAsServo.setPosition(270);
      }
      if (gamepad2.getX()) {
        clawRotateAsServo.setPosition(0);
      }
      if (gamepad2.getY()) {
        clawRotateAsServo.setPosition(270);
      }
      if (gamepad2.getRightBumper()) {
        clawExtendAsDcMotor.setPower(1);
      }
      if (gamepad2.getLeftBumper()) {
        clawExtendAsDcMotor.setPower(-1);
      }
      if (!gamepad2.getRightBumper() && !gamepad2.getLeftBumper()) {
        clawExtendAsDcMotor.setPower(0);
      }
      if (gamepad2.getPS()) {
        clawRotateAsServo.setPosition(270);
        clawExtendAsDcMotor.setPower(-1);
        linearOpMode.sleep(650);
        clawExtendAsDcMotor.setPower(0);
        linearOpMode.sleep(250);
        clawAsServo.setPosition(0);
        linearOpMode.sleep(250);
        clawExtendAsDcMotor.setPower(1);
        linearOpMode.sleep(250);
        clawExtendAsDcMotor.setPower(0);
        clawAsServo.setPosition(270);
      }
      if (gamepad2.getRightTrigger() > 0.1) {
        liftLeftAsDcMotor.setPower(gamepad2.getRightTrigger());
        liftRightAsDcMotor.setPower(gamepad2.getRightTrigger());
      } else if (gamepad2.getLeftTrigger() > 0.1) {
        liftLeftAsDcMotor.setPower(-gamepad2.getLeftTrigger());
        liftRightAsDcMotor.setPower(-gamepad2.getLeftTrigger());
      }
      if (gamepad2.getDpadUp()) {
        bucketRightAsCRServo.setPower(1);
        bucketLeftAsCRServo.setPower(1);
        linearOpMode.sleep(1000);
        bucketRightAsCRServo.setPower(-1);
        bucketLeftAsCRServo.setPower(-1);
        linearOpMode.sleep(775);
        bucketRightAsCRServo.setPower(0);
        bucketLeftAsCRServo.setPower(0);
      }
      if (gamepad2.getDpadDown()) {
        bucketLeftAsCRServo.setPower(-1);
        bucketLeftAsCRServo.setPower(-1);
      }
      if (gamepad2.getDpadRight()) {
        bucketLeftAsCRServo.setPower(1);
        bucketLeftAsCRServo.setPower(1);
      }
      if (!gamepad2.getDpadDown() && !gamepad2.getDpadUp()) {
        bucketLeftAsCRServo.setPower(0);
        bucketLeftAsCRServo.setPower(0);
      }
      if (gamepad2.getShare()) {
        hangLeftAsServo.setPosition(0);
        hangRightAsServo.setPosition(0);
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
      } else if (gamepad1.getLeftTrigger() < 0.1) {
        flAsDcMotor.setPower(0);
        frAsDcMotor.setPower(0);
        blAsDcMotor.setPower(0);
        brAsDcMotor.setPower(0);
      }
      if (gamepad2.getLeftTrigger() < 0.1) {
        liftLeftAsDcMotor.setPower(0);
        liftRightAsDcMotor.setPower(0);
      } else if (gamepad2.getRightTrigger() < 0.1) {
        liftLeftAsDcMotor.setPower(0);
        liftRightAsDcMotor.setPower(0);
      }
      if (gamepad2.getLeftBumper() == false) {
        clawExtendAsDcMotor.setPower(0);
      } else if (gamepad2.getRightBumper() == false) {
        clawExtendAsDcMotor.setPower(0);
      }
      telemetry.update();
    }
  }
}
