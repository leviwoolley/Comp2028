package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "_2021ManualOpmode (Blocks to Java)")
public class _2021ManualOpmode extends LinearOpMode {

  private DcMotor FL;
  private DcMotor FR;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    FL = hardwareMap.get(DcMotor.class, "FL");
    FR = hardwareMap.get(DcMotor.class, "FR");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        telemetry.update();
        if (0 < gamepad1.left_stick_y) {
          FL.setPower(1);
        } else {
          FL.setPower(0);
        }
        if (0 > gamepad1.left_stick_y) {
          FL.setPower(-1);
        } else {
          FL.setPower(0);
        }
        if (0 < gamepad1.right_stick_y) {
          FR.setPower(1);
        } else {
          FL.setPower(0);
        }
        if (0 > gamepad1.right_stick_x) {
          FR.setPower(-1);
        } else {
          FL.setPower(0);
        }
      }
    }
  }
}
