package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Basic: Omni Linear OpMode", group="Linear OpMode")
@Disabled
public class BasicOmniOpMode_Linear extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor fL;
    private DcMotor bL;
    private DcMotor fR;
    private DcMotor bR;

    @Override
    public void runOpMode() {

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
        }
    }}
