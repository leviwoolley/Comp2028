package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "_2021ManualOpmode2 (Blocks to Java)")
public class _2021ManualOpmode2 extends LinearOpMode {

  private DcMotor FL;
  private DcMotor FR;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    float FL2;
    float FR2;

    FL = hardwareMap.get(DcMotor.class, "FL");
    FR = hardwareMap.get(DcMotor.class, "FR");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        FL2 = gamepad1.left_stick_y;
        FR2 = -gamepad1.right_stick_x;
        FL.setPower(FL2);
        FR.setPower(FR2);
        telemetry.update();
      }
    }
  }
}
