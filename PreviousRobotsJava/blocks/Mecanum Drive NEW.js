// IDENTIFIERS_USED=armmototrAsDcMotor,blAsDcMotor,brAsDcMotor,clawservoAsCRServo,ControlHubAsServoController,flAsDcMotor,frAsDcMotor,gamepad1,gamepad2

var speed_multiplier;

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  frAsDcMotor.setDirection("REVERSE");
  brAsDcMotor.setDirection("REVERSE");
  blAsDcMotor.setDirection("FORWARD");
  flAsDcMotor.setDirection("FORWARD");
  armmototrAsDcMotor.setDirection("REVERSE");
  clawservoAsCRServo.setDirection("REVERSE");
  speed_multiplier = 2;
  ControlHubAsServoController.pwmDisable();
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      if (gamepad1.getRightTrigger() != 0) {
        frAsDcMotor.setPower(gamepad1.getRightTrigger());
        brAsDcMotor.setPower(gamepad1.getRightTrigger());
        blAsDcMotor.setPower(-1 * gamepad1.getRightTrigger());
        flAsDcMotor.setPower(-1 * gamepad1.getRightTrigger());
      } else if (gamepad1.getLeftTrigger() != 0) {
        frAsDcMotor.setPower(-1 * gamepad1.getLeftTrigger());
        brAsDcMotor.setPower(-1 * gamepad1.getLeftTrigger());
        flAsDcMotor.setPower(gamepad1.getLeftTrigger());
        blAsDcMotor.setPower(gamepad1.getLeftTrigger());
      } else {
        if (Math.abs(gamepad1.getLeftStickY()) > Math.abs(gamepad1.getLeftStickX())) {
          blAsDcMotor.setPower(gamepad1.getLeftStickY());
          flAsDcMotor.setPower(gamepad1.getLeftStickY());
          brAsDcMotor.setPower(gamepad1.getLeftStickY());
          frAsDcMotor.setPower(gamepad1.getLeftStickY());
        } else {
          brAsDcMotor.setPower(-1 * gamepad1.getLeftStickX());
          frAsDcMotor.setPower(gamepad1.getLeftStickX());
          blAsDcMotor.setPower(gamepad1.getLeftStickX());
          flAsDcMotor.setPower(-1 * gamepad1.getLeftStickX());
        }
      }
      if (Math.abs(gamepad1.getRightStickY()) > Math.abs(gamepad1.getRightStickX())) {
        blAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
        flAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
        brAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
        frAsDcMotor.setPower(0.5 * gamepad1.getRightStickY());
      } else {
        brAsDcMotor.setPower(0.5 * -1 * gamepad1.getRightStickX());
        frAsDcMotor.setPower(0.5 * gamepad1.getRightStickX());
        blAsDcMotor.setPower(0.5 * gamepad1.getRightStickX());
        flAsDcMotor.setPower(0.5 * -1 * gamepad1.getRightStickX());
      }
      if (gamepad1.getRightBumper()) {
        frAsDcMotor.setPower(-0.25);
        brAsDcMotor.setPower(-0.25);
        flAsDcMotor.setPower(0.25);
        blAsDcMotor.setPower(0.25);
      } else if (gamepad1.getLeftBumper()) {
        frAsDcMotor.setPower(0.25);
        brAsDcMotor.setPower(0.25);
        flAsDcMotor.setPower(-0.25);
        blAsDcMotor.setPower(-0.25);
      }
      if (gamepad2.getRightTrigger() > 0.01) {
        armmototrAsDcMotor.setPower(gamepad2.getRightTrigger());
        clawservoAsCRServo.setPower(gamepad2.getRightTrigger());
      } else if (gamepad2.getLeftTrigger() > 0.01) {
        armmototrAsDcMotor.setPower(-gamepad2.getLeftTrigger());
        clawservoAsCRServo.setPower(-gamepad2.getRightTrigger());
      } else if (gamepad2.getRightTrigger() <= 0.01) {
        armmototrAsDcMotor.setPower(gamepad2.getLeftTrigger());
      } else if (gamepad2.getLeftTrigger() <= 0.01) {
        armmototrAsDcMotor.setPower(0);
      }
      if (gamepad2.getA()) {
        clawservoAsCRServo.setPower(1);
      } else if (gamepad2.getB()) {
        clawservoAsCRServo.setPower(-1);
      }
      telemetry.update();
    }
  }
}
