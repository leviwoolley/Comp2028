var Speed;

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  linearOpMode.waitForStart();
  Speed = 1;
  BillyMotorAsDcMotor.setMode("RUN_WITHOUT_ENCODER");
  RightMotorAsDcMotor.setDirection("FORWARD");
  LeftMotorAsDcMotor.setDirection("FORWARD");
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      if (gamepad1.getLeftBumper()) {
        Speed = 0.2;
      } else {
        Speed = 1;
      }
      if (gamepad1.getA()) {
        SpinnyBoiAsDcMotor.setPower(-1);
      } else {
        SpinnyBoiAsDcMotor.setPower(0);
      }
      if (gamepad1.getB()) {
        SpinnyBoiAsDcMotor.setPower(1);
      } else {
        SpinnyBoiAsDcMotor.setPower(0);
      }
      if (gamepad2.getA()) {
        LatchAsServo.setPosition(90);
      }
      if (gamepad2.getB()) {
        LatchAsServo.setPosition(-30);
      }
      BucketAsServo.setPosition(BucketAsServo.getPosition() + gamepad2.getRightStickY() / 40);
      BillyMotorAsDcMotor.setPower(gamepad2.getLeftStickY() * 0.3 + 0.1);
      RightMotorAsDcMotor.setDualPower((gamepad1.getLeftStickY() + gamepad1.getLeftStickX()) * Speed, LeftMotorAsDcMotor, (gamepad1.getLeftStickY() - gamepad1.getLeftStickX()) * Speed);
      telemetry.update();
    }
  }
}
