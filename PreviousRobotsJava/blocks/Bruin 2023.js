// IDENTIFIERS_USED=blAsDcMotor,brAsDcMotor,cSensorAsColorSensor,flAsDcMotor,frAsDcMotor

var CurrentColor;

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  flAsDcMotor.setDirection("REVERSE");
  frAsDcMotor.setDirection("REVERSE");
  blAsDcMotor.setDirection("FORWARD");
  brAsDcMotor.setDirection("REVERSE");
  cSensorAsColorSensor.enableLed(false);
  linearOpMode.sleep(500);
  cSensorAsColorSensor.enableLed(true);
  linearOpMode.waitForStart();
  flAsDcMotor.setDualPower(0.7, frAsDcMotor, 0.7);
  brAsDcMotor.setDualPower(0.7, blAsDcMotor, 0.7);
  linearOpMode.sleep(500);
  while (linearOpMode.opModeIsActive()) {
    CurrentColor = colorAccess.rgbToColor(cSensorAsColorSensor.getRed(), cSensorAsColorSensor.getGreen(), cSensorAsColorSensor.getBlue());
    if (colorAccess.getSaturation(CurrentColor) >= 0.6 && colorAccess.getHue(CurrentColor) > 135 && colorAccess.getHue(CurrentColor) < 105) {
      flAsDcMotor.setDualPower(0.7, frAsDcMotor, 0.7);
      linearOpMode.sleep(1000);
      flAsDcMotor.setDualPower(0, frAsDcMotor, 0.7);
      linearOpMode.sleep(500);
      flAsDcMotor.setDualPower(0.7, frAsDcMotor, 0.7);
      linearOpMode.sleep(700);
      cSensorAsColorSensor.enableLed(false);
    } else if (colorAccess.getSaturation(CurrentColor) >= 0.6 && colorAccess.getHue(CurrentColor) > 75 && colorAccess.getHue(CurrentColor) < 45) {
      flAsDcMotor.setDualPower(0.6, frAsDcMotor, 0.6);
      linearOpMode.sleep(2000);
      cSensorAsColorSensor.enableLed(false);
    } else {
      if (colorAccess.getSaturation(CurrentColor) >= 0.6 && colorAccess.getHue(CurrentColor) > 300 && colorAccess.getHue(CurrentColor) < 270) {
        flAsDcMotor.setDualPower(0.7, frAsDcMotor, 0.7);
        linearOpMode.sleep(1000);
        flAsDcMotor.setDualPower(1, frAsDcMotor, 0);
        linearOpMode.sleep(500);
        flAsDcMotor.setDualPower(0.7, frAsDcMotor, 0.7);
        linearOpMode.sleep(700);
        cSensorAsColorSensor.enableLed(false);
      }
    }
  }
}
