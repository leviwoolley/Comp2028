// IDENTIFIERS_USED=blAsDcMotor,flAsDcMotor,frAsDcMotor

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  flAsDcMotor.setDirection("REVERSE");
  blAsDcMotor.setDirection("REVERSE");
  linearOpMode.waitForStart();
  flAsDcMotor.setDualPower(1, frAsDcMotor, 1);
  linearOpMode.sleep(1500);
  flAsDcMotor.setDualPower(1, frAsDcMotor, -1);
  linearOpMode.sleep(1000);
  flAsDcMotor.setDualPower(1, frAsDcMotor, 1);
  linearOpMode.sleep(900);
  flAsDcMotor.setDualPower(1, frAsDcMotor, -1);
  linearOpMode.sleep(100);
}
