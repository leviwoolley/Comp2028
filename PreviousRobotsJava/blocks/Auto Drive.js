// IDENTIFIERS_USED=blAsDcMotor,brAsDcMotor,flAsDcMotor,frAsDcMotor

/**
 * This function is executed when this OpMode is selected from the Driver Station.
 */
function runOpMode() {
  flAsDcMotor.setDirection("FORWARD");
  frAsDcMotor.setDirection("REVERSE");
  blAsDcMotor.setDirection("REVERSE");
  brAsDcMotor.setDirection("FORWARD");
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    linearOpMode.sleep(5000);
    flAsDcMotor.setPower(-1);
    frAsDcMotor.setPower(1);
    blAsDcMotor.setPower(1);
    brAsDcMotor.setPower(-1);
    linearOpMode.sleep(1500);
    flAsDcMotor.setPower(0);
    frAsDcMotor.setPower(0);
    blAsDcMotor.setPower(0);
    brAsDcMotor.setPower(0);
  }
}
