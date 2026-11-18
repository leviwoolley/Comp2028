package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "FinleyDipshitDrive")
public class FinleyDipshitDrive extends LinearOpMode {

    private DcMotor fL;
    private DcMotor fR;
    private DcMotor bL;
    private DcMotor bR;
    private DcMotor rLauncher;
    private DcMotor launcher2;
    private DcMotor lLauncher;
    private DcMotor transfer;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        fL = hardwareMap.get(DcMotor.class, "fL");
        fR = hardwareMap.get(DcMotor.class, "fR");
        bL = hardwareMap.get(DcMotor.class, "bL");
        bR = hardwareMap.get(DcMotor.class, "bR");
        rLauncher = hardwareMap.get(DcMotor.class, "rLauncher");
        launcher2 = hardwareMap.get(DcMotor.class, "launcher 2");
        lLauncher = hardwareMap.get(DcMotor.class, "lLauncher");
        transfer = hardwareMap.get(DcMotor.class, "transfer");

        // Put initialization blocks here.
        fL.setDirection(DcMotor.Direction.REVERSE);
        fR.setDirection(DcMotor.Direction.FORWARD);
        bL.setDirection(DcMotor.Direction.REVERSE);
        bR.setDirection(DcMotor.Direction.FORWARD);
        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                // Put loop blocks here.
                if (gamepad1.left_stick_y > 0.2) {
                    fL.setPower(-gamepad1.left_stick_y);
                    fR.setPower(-gamepad1.left_stick_y);
                    bL.setPower(gamepad1.left_stick_y);
                    bR.setPower(gamepad1.left_stick_y);
                } else if (gamepad1.left_stick_y < -0.2) {
                    fL.setPower(-gamepad1.left_stick_y);
                    fR.setPower(-gamepad1.left_stick_y);
                    bL.setPower(gamepad1.left_stick_y);
                    bR.setPower(gamepad1.left_stick_y);
                } else if (gamepad1.left_stick_x < -0.2) {
                    fL.setPower(-gamepad1.left_stick_x);
                    fR.setPower(gamepad1.left_stick_x);
                    bL.setPower(gamepad1.left_stick_x);
                    bR.setPower(-gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_x > 0.2) {
                    fL.setPower(-gamepad1.left_stick_x);
                    fR.setPower(gamepad1.left_stick_x);
                    bL.setPower(gamepad1.left_stick_x);
                    bR.setPower(-gamepad1.left_stick_x);
                } else if (gamepad1.right_stick_x > 0.2) {
                    fL.setPower(-gamepad1.right_stick_x);
                    fR.setPower(gamepad1.right_stick_x);
                    bL.setPower(-gamepad1.right_stick_x);
                    bR.setPower(gamepad1.right_stick_x);
                } else if (gamepad1.right_stick_x < -0.2) {
                    fL.setPower(-gamepad1.right_stick_x);
                    fR.setPower(gamepad1.right_stick_x);
                    bL.setPower(-gamepad1.right_stick_x);
                    bR.setPower(gamepad1.right_stick_x);
                } else {
                    fL.setPower(0);
                    fR.setPower(0);
                    bL.setPower(0);
                    bR.setPower(0);
                }
                if (gamepad1.left_trigger_pressed) {
                    rLauncher.setPower(1);
                    launcher2.setPower(-1);
                } else if (gamepad1.left_bumper) {
                    rLauncher.setPower(0);
                    launcher2.setPower(0);
                }
                if (gamepad1.right_trigger_pressed) {
                    lLauncher.setPower(1);
                } else if (gamepad1.right_bumper) {
                    lLauncher.setPower(0);
                }
                if (gamepad1.dpad_up) {
                    transfer.setPower(-1);
                } else if (gamepad1.dpad_down) {
                    transfer.setPower(0);
                }
            }
        }
    }
}