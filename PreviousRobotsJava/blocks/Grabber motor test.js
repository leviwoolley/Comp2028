// IDENTIFIERS_USED=gamepad2,grabberhandservoAsServo

var x;

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  grabberhandservoAsServo.setPosition(0);
  grabberhandservoAsServo.setDirection("REVERSE");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      x = grabberhandservoAsServo.getPosition();
      if (gamepad2.getDpadUp()) {
        grabberhandservoAsServo.setPosition(x + 0.005);
      } else if (gamepad2.getDpadDown()) {
        grabberhandservoAsServo.setPosition(x - 0.005);
      }
      telemetry.update();
    }
  }
}
