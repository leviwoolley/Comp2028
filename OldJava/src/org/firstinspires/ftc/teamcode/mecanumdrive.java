package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "mecanumdrive (Blocks to Java)")
public class mecanumdrive extends LinearOpMode {

  private DcMotor fl;
  private DcMotor fr;
  private DcMotor bl;
  private DcMotor br;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    fl = hardwareMap.get(DcMotor.class, "fl");
    fr = hardwareMap.get(DcMotor.class, "fr");
    bl = hardwareMap.get(DcMotor.class, "bl");
    br = hardwareMap.get(DcMotor.class, "br");

    // Put initialization blocks here.
    fl.setDirection(DcMotorSimple.Direction.REVERSE);
    fr.setDirection(DcMotorSimple.Direction.REVERSE);
    bl.setDirection(DcMotorSimple.Direction.FORWARD);
    br.setDirection(DcMotorSimple.Direction.REVERSE);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
    }
    while (opModeIsActive()) {
      // Put loop blocks here.
      if (gamepad1.left_stick_y >= 0.1) {
        fl.setPower(gamepad1.left_stick_y);
        fr.setPower(gamepad1.left_stick_y);
        bl.setPower(gamepad1.left_stick_y);
        br.setPower(gamepad1.left_stick_y);
      } else if (gamepad1.left_stick_y <= -0.1) {
        fl.setPower(gamepad1.left_stick_y);
        fr.setPower(gamepad1.left_stick_y);
        bl.setPower(gamepad1.left_stick_y);
        br.setPower(gamepad1.left_stick_y);
      } else if (gamepad1.left_stick_x <= -0.1) {
        fl.setPower(Math.abs(gamepad1.left_stick_x));
        fr.setPower(gamepad1.left_stick_x);
        bl.setPower(gamepad1.left_stick_x);
        br.setPower(Math.abs(gamepad1.left_stick_x));
      } else if (gamepad1.left_stick_x >= 0.1) {
        fl.setPower(-gamepad1.left_stick_x);
        fr.setPower(gamepad1.left_stick_x);
        bl.setPower(gamepad1.left_stick_x);
        br.setPower(-gamepad1.left_stick_x);
      }
      if (gamepad1.left_trigger > 0.1) {
        fl.setPower(gamepad1.left_trigger);
        fr.setPower(-gamepad1.left_trigger);
        bl.setPower(gamepad1.left_stick_x);
        br.setPower(-gamepad1.left_trigger);
      } else if (gamepad1.right_trigger > 0.1) {
        fl.setPower(-gamepad1.right_trigger);
        fr.setPower(gamepad1.right_trigger);
        bl.setPower(-gamepad1.right_trigger);
        br.setPower(gamepad1.right_trigger);
      }
      if (gamepad1.left_bumper) {
        fl.setPower(0.25);
        fr.setPower(-0.25);
        bl.setPower(0.25);
        br.setPower(-0.25);
      } else if (gamepad1.right_bumper) {
        fl.setPower(-0.25);
        fr.setPower(0.25);
        bl.setPower(-0.25);
        br.setPower(0.25);
      }
      if (gamepad1.right_stick_y >= 0.1) {
        fl.setPower(0.5 * gamepad1.right_stick_y);
        fr.setPower(0.5 * gamepad1.right_stick_y);
        bl.setPower(0.5 * gamepad1.right_stick_y);
        br.setPower(0.5 * gamepad1.right_stick_y);
      } else if (gamepad1.right_stick_y <= -0.1) {
        fl.setPower(0.5 * gamepad1.right_stick_y);
        fr.setPower(0.5 * gamepad1.right_stick_y);
        bl.setPower(0.5 * gamepad1.right_stick_y);
        br.setPower(0.5 * gamepad1.right_stick_y);
      } else if (gamepad1.right_stick_x <= -0.1) {
        fl.setPower(0.5 * Math.abs(gamepad1.right_stick_x));
        fr.setPower(0.5 * gamepad1.right_stick_x);
        bl.setPower(0.5 * gamepad1.right_stick_x);
        br.setPower(0.5 * Math.abs(gamepad1.right_stick_x));
      } else if (gamepad1.right_stick_x >= 0.1) {
        fl.setPower(0.5 * -gamepad1.right_stick_x);
        fr.setPower(0.5 * gamepad1.right_stick_x);
        bl.setPower(0.5 * gamepad1.right_stick_x);
        br.setPower(0.5 * -gamepad1.right_stick_x);
      }
      if (gamepad1.left_stick_y < 0.1 && gamepad1.left_stick_y > -0.1 && gamepad1.left_stick_x < 0.1 && gamepad1.left_stick_x > -0.1) {
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
      } else if (gamepad1.right_trigger < 0.1) {
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
      } else if (gamepad1.left_trigger > -0.1) {
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
      }
    }
    telemetry.update();
  }
}
