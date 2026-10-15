package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "2026Teleop")
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

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            mechanumDrive.drivingLoop();


            if (gamepad1.rightBumperWasPressed()) {
                intakeToggleForward();
            }
            if (gamepad1.leftBumperWasPressed()) {
                transferToggle();
            }
            if (gamepad1.rightTriggerWasPressed()) {
                intakeToggleBackward();
            }


            mechanumDrive.drivingTelemetry();

            telemetry.addData("Intake Direction", intake);
            telemetry.addData("Transfer Direction", transfer);
            telemetry.update();
        }
    }

    public void intakeToggleForward() {
        switch (intake) {
            case FORWARD -> {
                intake = MechanumDrive.MotorStatus.OFF;
                this.rLaunch.setPower(0);
                this.lLaunch.setPower(0);
            }
            case OFF,BACKWARD -> {
                intake = MechanumDrive.MotorStatus.FORWARD;
                this.rLaunch.setPower(-0.5);
            }
        }

    }

    public void intakeToggleBackward() {
        switch (intake) {
            case BACKWARD -> {
                intake = MechanumDrive.MotorStatus.OFF;
                this.rLaunch.setPower(0);
                this.lLaunch.setPower(0);
            }
            case OFF,FORWARD -> {
                intake = MechanumDrive.MotorStatus.BACKWARD;
                this.rLaunch.setPower(0.5);
            }
        }

    }

    public void transferToggle() {
        switch (transfer) {
            case FORWARD -> {
                transfer = MechanumDrive.MotorStatus.OFF;
                this.transferMotor.setPower(-1);
            }
            case OFF -> {
                transfer = MechanumDrive.MotorStatus.FORWARD;
                this.transferMotor.setPower(0);
            }
            default -> {}
        }
    }
}
