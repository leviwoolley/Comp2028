/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  RightMotorAsDcMotor.setDirection("REVERSE");
  LeftMotorAsDcMotor.setDirection("REVERSE");
  BillyMotorAsDcMotor.setPower(0.1);
  linearOpMode.waitForStart();
  LatchAsServo.setPosition(-10);
}

/**
 * Describe this function...
 */
function dashback() {
  RightMotorAsDcMotor.setDirection("FORWARD");
  RightMotorAsDcMotor.setDirection("FORWARD");
  LeftMotorAsDcMotor.setDualPower(2, RightMotorAsDcMotor, 2);
  linearOpMode.sleep(500);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
  RightMotorAsDcMotor.setDirection("REVERSE");
  RightMotorAsDcMotor.setDirection("REVERSE");
}

/**
 * Describe this function...
 */
function dash() {
  LeftMotorAsDcMotor.setDualPower(2, RightMotorAsDcMotor, 2);
  linearOpMode.sleep(500);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
}

/**
 * Describe this function...
 */
function lift_arm() {
  BillyMotorAsDcMotor.setPower(0.5);
  linearOpMode.sleep(500);
  BillyMotorAsDcMotor.setPower(0.1);
}

/**
 * Describe this function...
 */
function move_backwards() {
  RightMotorAsDcMotor.setDirection("FORWARD");
  LeftMotorAsDcMotor.setDirection("FORWARD");
  LeftMotorAsDcMotor.setDualPower(0.9, RightMotorAsDcMotor, 0.9);
  linearOpMode.sleep(500);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
  RightMotorAsDcMotor.setDirection("REVERSE");
  LeftMotorAsDcMotor.setDirection("REVERSE");
}

/**
 * Describe this function...
 */
function move_forward() {
  LeftMotorAsDcMotor.setDualPower(0.9, RightMotorAsDcMotor, 0.9);
  linearOpMode.sleep(250);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
}

/**
 * Describe this function...
 */
function lower_arm() {
  BillyMotorAsDcMotor.setDirection("REVERSE");
  BillyMotorAsDcMotor.setPower(0.1);
  linearOpMode.sleep(500);
  BillyMotorAsDcMotor.setDirection("FORWARD");
  BillyMotorAsDcMotor.setPower(0.1);
}

/**
 * Describe this function...
 */
function turn_right() {
  RightMotorAsDcMotor.setDirection("FORWARD");
  LeftMotorAsDcMotor.setDirection("FORWARD");
  LeftMotorAsDcMotor.setDualPower(0.9, RightMotorAsDcMotor, 0.9);
  linearOpMode.sleep(50);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
  LeftMotorAsDcMotor.setDirection("REVERSE");
  LeftMotorAsDcMotor.setDualPower(1, RightMotorAsDcMotor, 2);
  linearOpMode.sleep(700);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
  RightMotorAsDcMotor.setDirection("REVERSE");
  LeftMotorAsDcMotor.setDualPower(0.9, RightMotorAsDcMotor, 0.9);
  linearOpMode.sleep(125);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
}

/**
 * Describe this function...
 */
function turn_left() {
  RightMotorAsDcMotor.setDirection("FORWARD");
  LeftMotorAsDcMotor.setDirection("FORWARD");
  LeftMotorAsDcMotor.setDualPower(0.9, RightMotorAsDcMotor, 0.9);
  linearOpMode.sleep(50);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
  RightMotorAsDcMotor.setDirection("REVERSE");
  RightMotorAsDcMotor.setDualPower(1, LeftMotorAsDcMotor, 2);
  linearOpMode.sleep(550);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
  LeftMotorAsDcMotor.setDirection("REVERSE");
  LeftMotorAsDcMotor.setDualPower(0.9, RightMotorAsDcMotor, 0.9);
  linearOpMode.sleep(110);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
}

/**
 * Describe this function...
 */
function turn_around() {
  RightMotorAsDcMotor.setDirection("FORWARD");
  LeftMotorAsDcMotor.setDirection("FORWARD");
  LeftMotorAsDcMotor.setDualPower(0.9, RightMotorAsDcMotor, 0.9);
  linearOpMode.sleep(50);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
  LeftMotorAsDcMotor.setDirection("REVERSE");
  LeftMotorAsDcMotor.setDualPower(2, RightMotorAsDcMotor, 4);
  linearOpMode.sleep(1700);
  LeftMotorAsDcMotor.setDualPower(0, RightMotorAsDcMotor, 0);
  RightMotorAsDcMotor.setDirection("REVERSE");
}
