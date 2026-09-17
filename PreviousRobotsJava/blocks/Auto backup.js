// IDENTIFIERS_USED=armmototrAsDcMotor

var _7BelapsedTimeVariable_7D, _7BvectorVariable_7D;

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    armmototrAsDcMotor.setPower(0.5);
  }
}
