package org.firstinspires.ftc.teamcode;

import	com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import	com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import	com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
public class TeleOp2026 extends LinearOpMode {

    private MechanumDrive mechanumDrive;
    private DcMotor rLaunch, lLaunch, transferMotor;

    private MechanumDrive.MotorStatus intake, transfer;

    @Override
    public void runOpMode() {

        rLaunch = this.hardwareMap.get(DcMotor.class, "rLauncher");
        lLaunch = this.hardwareMap.get(DcMotor.class, "lLauncher");
        transferMotor = this.hardwareMap.get(DcMotor.class, "transfer");

        intake = MechanumDrive.MotorStatus.OFF;
        transfer = MechanumDrive.MotorStatus.OFF;

        mechanumDrive = new MechanumDrive(this);

        mechanumDrive.initMotors(
                // Front left
                DcMotorSimple.Direction.REVERSE,
                // Front right
                DcMotorSimple.Direction.REVERSE,
                // Back left
                DcMotorSimple.Direction.FORWARD,
                // Back right
                DcMotorSimple.Direction.FORWARD
        );

        telemetry.addData("Status",	"Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            mechanumDrive.drivingLoop();

            try {
                if (gamepad1.rightBumperWasPressed()) {
                    intakeToggle();
                }
                if (gamepad1.leftBumperWasPressed()) {
                    transferToggle();
                }
            } catch (Exception e) {
                telemetry.addData("Unkown Exception for Intake&Transfer", e);
            }

            mechanumDrive.drivingTelemetry();

            telemetry.addData("Intake Direction", "enumf", intake);
            telemetry.addData("Tranfer Direction", "enumf", transfer);
        }
    }

    public void intakeToggle() {
        if (intake == MechanumDrive.MotorStatus.OFF) {
            intake = MechanumDrive.MotorStatus.FORWARD;
        }

        if (intake == MechanumDrive.MotorStatus.FORWARD) {
            intake = MechanumDrive.MotorStatus.OFF;
        }

        switch (intake) {
            case FORWARD -> {
                this.rLaunch.setPower(1);
                this.lLaunch.setPower(-1);
            }
            case OFF -> {
                this.rLaunch.setPower(0);
                this.lLaunch.setPower(0);
            }
        }
    }

    public void transferToggle() {
        if (transfer == MechanumDrive.MotorStatus.OFF) {
            transfer = MechanumDrive.MotorStatus.FORWARD;
        }

        if (transfer == MechanumDrive.MotorStatus.FORWARD) {
            transfer = MechanumDrive.MotorStatus.OFF;
        }

        switch (transfer) {
            case FORWARD -> {
                this.transferMotor.setPower(1);
            }
            case OFF -> {
                this.transferMotor.setPower(0);
            }
        }
    }
}
