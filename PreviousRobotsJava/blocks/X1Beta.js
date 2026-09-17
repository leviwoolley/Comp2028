// IDENTIFIERS_USED=blAsDcMotor,brAsDcMotor,flAsDcMotor,frAsDcMotor

var ms, frac1, frac2, frac3, frac4, msa, _bl, _br, _fl, _fr, signal;

function mathRandomInt(a, b) {
  if (a > b) {
    // Swap a and b to ensure a is smaller.
    var c = a;
    a = b;
    b = c;
  }
  return Math.floor(Math.random() * (b - a + 1) + a);
}

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      calibf(0.74, 0.71, 1.05, 1.02);
      linearOpMode.sleep(6942);
      signal = mathRandomInt(1, 3);
      if (signal == 1) {
        fr(1040);
        stop2();
        br(150);
        stop2();
        left(1069);
        stop2();
      } else if (signal == 2) {
        fr(690);
        stop2();
      } else if (signal == 3) {
        fr(1040);
        stop2();
        br(150);
        stop2();
        right(1690);
        stop2();
      }
      telemetry.update();
      linearOpMode.sleep(6942);
    }
  }
}

/**
 * Describe this function...
 */
function fr(ms) {
  blAsDcMotor.setDirection("FORWARD");
  brAsDcMotor.setDirection("REVERSE");
  flAsDcMotor.setDirection("FORWARD");
  frAsDcMotor.setDirection("REVERSE");
  blAsDcMotor.setPower(_bl);
  brAsDcMotor.setPower(_br);
  flAsDcMotor.setPower(_fl);
  frAsDcMotor.setPower(_fr);
  linearOpMode.sleep(ms);
}

/**
 * Describe this function...
 */
function calibf(frac1, frac2, frac3, frac4) {
  _bl = frac1;
  _br = frac2;
  _fl = frac3;
  _fr = frac4;
}

/**
 * Describe this function...
 */
function br(ms) {
  blAsDcMotor.setDirection("REVERSE");
  brAsDcMotor.setDirection("FORWARD");
  flAsDcMotor.setDirection("REVERSE");
  frAsDcMotor.setDirection("FORWARD");
  blAsDcMotor.setPower(_bl);
  brAsDcMotor.setPower(_br);
  flAsDcMotor.setPower(_fl);
  frAsDcMotor.setPower(_fr);
  linearOpMode.sleep(ms);
}

/**
 * Describe this function...
 */
function left(msa) {
  blAsDcMotor.setDirection("REVERSE");
  brAsDcMotor.setDirection("REVERSE");
  flAsDcMotor.setDirection("FORWARD");
  frAsDcMotor.setDirection("FORWARD");
  blAsDcMotor.setPower(_bl);
  brAsDcMotor.setPower(_br);
  flAsDcMotor.setPower(_fl);
  frAsDcMotor.setPower(_fr);
  linearOpMode.sleep(msa);
}

/**
 * Describe this function...
 */
function right(msa) {
  blAsDcMotor.setDirection("FORWARD");
  brAsDcMotor.setDirection("FORWARD");
  flAsDcMotor.setDirection("REVERSE");
  frAsDcMotor.setDirection("REVERSE");
  blAsDcMotor.setPower(_bl);
  brAsDcMotor.setPower(_br);
  flAsDcMotor.setPower(_fl);
  frAsDcMotor.setPower(_fr);
  linearOpMode.sleep(msa);
}

/**
 * Describe this function...
 */
function stop2() {
  blAsDcMotor.setPower(0);
  brAsDcMotor.setPower(0);
  flAsDcMotor.setPower(0);
  frAsDcMotor.setPower(0);
  linearOpMode.sleep(1000);
}
