var lifter, push, FL, servo, FR;

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
  }
  while (linearOpMode.opModeIsActive()) {
    if (gamepad2.getDpadUp()) {
      lifter = -1;
    } else if (gamepad2.getDpadDown()) {
      lifter = 1;
    } else {
      lifter = 0;
    }
    if (gamepad2.getX()) {
      push = -1;
    } else if (gamepad2.getY()) {
      push = 1;
    } else {
      push = 0;
    }
    if (gamepad2.getA()) {
      TheClawAsServo.setPosition(0);
      servo = 0;
    } else if (gamepad2.getB()) {
      TheClawAsServo.setPosition(45);
      servo = 45;
    }
    FL = gamepad1.getLeftStickY();
    FR = -gamepad1.getRightStickY();
    FLAsDcMotor.setPower(FL);
    FRAsDcMotor.setPower(FR);
    LifterAsDcMotor.setPower(lifter);
    ExtendAsDcMotor.setPower(push);
    telemetry.addNumericData('Lifter', lifter);
    telemetry.addNumericData('FR', FR);
    telemetry.addNumericData('FL', FL);
    telemetry.addNumericData('Extender', push);
    telemetry.addNumericData('Servo', servo);
    telemetry.update();
  }
}
