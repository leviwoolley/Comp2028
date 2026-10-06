// https://www.ctrlaltftc.com/introduction-to-open-loop-control
// Future Auto 

package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.ExposureControl;
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.GainControl;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagClusterDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class RobotAutoDriveToAprilTagOmni extends LinearOpMode
{

    private double kP, kI, kD;

    private double reference, derivative;

    private int integralSum;
    private int lastError;

    private ElapsedTime timer = new ElapsedTime;
    
    @Override 
    public void runOpMode() {

        while (opModeIsActive()) {

            float encoder;

            derivative = (error-lastError) / timer.seconds();

            integralSum += (error * timer.seconds());



        }

    }
    
}
