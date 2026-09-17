var tgtPower;

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      tgtPower = gamepad1.getLeftStickY();
      LeftMotorAsDcMotor.setPower(tgtPower);
      telemetry.addNumericData('Target Power', tgtPower);
      telemetry.addNumericData('Left Power', LeftMotorAsDcMotor.getPower());
      tgtPower = gamepad1.getRightStickY();
      RightMotorAsDcMotor.setPower(tgtPower);
      telemetry.addNumericData('Target Power', tgtPower);
      telemetry.addNumericData('Right Power', RightMotorAsDcMotor.getPower());
      BillyMotorAsDcMotor.setPower(1);
      BillyMotorAsDcMotor.setTargetPosition(0.35);
      tgtPower = -gamepad2.getLeftStickY();
      BillyMotorAsDcMotor.setPower(tgtPower);
      telemetry.addNumericData('Target Power', tgtPower);
      telemetry.addNumericData('Billy Power', BillyMotorAsDcMotor.getPower());
      telemetry.addNumericData('Billy Position', BillyMotorAsDcMotor.getTargetPosition());
      tgtPower = gamepad2.getRightStickY();
      SpinnyBoiAsDcMotor.setPower(tgtPower);
      telemetry.addNumericData('Target Power', tgtPower);
      telemetry.addNumericData('Spinny Boi Power', SpinnyBoiAsDcMotor.getPower());
      if (gamepad2.getDpadUp()) {
        BucketAsServo.setPosition(1);
      } else if (gamepad2.getDpadLeft()) {
        BucketAsServo.setPosition(0);
      } else if (gamepad2.getDpadDown()) {
        BucketAsServo.setPosition(-1);
      }
      if (gamepad2.getLeftBumper()) {
        LatchAsServo.setPosition(1);
      } else if (gamepad2.getRightBumper()) {
        LatchAsServo.setPosition(0);
      }
      telemetry.addNumericData('Bucket Power', BucketAsServo.getPosition());
      telemetry.addNumericData('Latch Power', LatchAsServo.getPosition());
      telemetry.update();
    }
  }
}
