package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "_2021ManualOpmode6 (Blocks to Java)")
public class _2021ManualOpmode6 extends LinearOpMode {

  private DcMotor FL;
  private DcMotor FR;
  private DcMotor Lifter;
  private DcMotor Extender;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    int lifter;
    float FL2;
    float FR2;
    float exstention;

    FL = hardwareMap.get(DcMotor.class, "FL");
    FR = hardwareMap.get(DcMotor.class, "FR");
    Lifter = hardwareMap.get(DcMotor.class, "Lifter");
    Extender = hardwareMap.get(DcMotor.class, "Extender");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
    }
    while (opModeIsActive()) {
      if (gamepad2.dpad_up) {
        lifter = -1;
      } else if (gamepad2.dpad_down) {
        lifter = 1;
      } else {
        lifter = 0;
      }
      FL2 = gamepad1.left_stick_y;
      FR2 = -gamepad1.right_stick_y;
      exstention = gamepad2.right_trigger;
      exstention = -gamepad2.left_trigger;
      FL.setPower(FL2);
      FR.setPower(FR2);
      Lifter.setPower(lifter);
      Extender.setPower(exstention);
      telemetry.addData("Lifter", lifter);
      telemetry.addData("FR", FR2);
      telemetry.addData("FL", FL2);
      telemetry.addData("Exstender", exstention);
      telemetry.update();
    }
  }
}
