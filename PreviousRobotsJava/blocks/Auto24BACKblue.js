// IDENTIFIERS_USED=blAsDcMotor,brAsDcMotor,flAsDcMotor,frAsDcMotor

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  flAsDcMotor.setDirection("REVERSE");
  frAsDcMotor.setDirection("FORWARD");
  blAsDcMotor.setDirection("FORWARD");
  brAsDcMotor.setDirection("REVERSE");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    blAsDcMotor.setPower(-1);
    flAsDcMotor.setPower(1);
    brAsDcMotor.setPower(1);
    frAsDcMotor.setPower(-1);
    linearOpMode.sleep(100);
    flAsDcMotor.setPower(0);
    frAsDcMotor.setPower(0);
    blAsDcMotor.setPower(0);
    brAsDcMotor.setPower(0);
    linearOpMode.sleep(6000);
    flAsDcMotor.setPower(1);
    frAsDcMotor.setPower(1);
    blAsDcMotor.setPower(1);
    brAsDcMotor.setPower(1);
    linearOpMode.sleep(1500);
    flAsDcMotor.setPower(0);
    frAsDcMotor.setPower(0);
    blAsDcMotor.setPower(0);
    brAsDcMotor.setPower(0);
  }
}
