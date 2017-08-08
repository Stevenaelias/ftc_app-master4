package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stevenelias on 10/22/16.
 */
@Autonomous(name = "BeaconTest", group = "Autonomous")
@Disabled
public class BeaconTest extends LinearOpMode {
    DcMotor rightfrontdrive;
    DcMotor rightbackdrive;
    DcMotor leftfrontdrive;
    DcMotor leftbackdrive;

    Servo buttonLeft;
    Servo buttonRight;

    ColorSensor color;

    OpticalDistanceSensor ODS;

    boolean correctColor;

    double lightThreashold;
    @Override
    public void runOpMode() throws InterruptedException {
        rightfrontdrive = hardwareMap.dcMotor.get("leftfrontdrive");
        rightbackdrive = hardwareMap.dcMotor.get("leftbackdrive");
        leftfrontdrive = hardwareMap.dcMotor.get("rightfrontdrive");
        leftbackdrive = hardwareMap.dcMotor.get("rightbackdrive");

        buttonLeft = hardwareMap.servo.get("buttonleft");
        buttonRight = hardwareMap.servo.get("buttonright");

        color = hardwareMap.colorSensor.get("color");

        ODS = hardwareMap.opticalDistanceSensor.get("ODS");

        rightfrontdrive.setDirection(DcMotor.Direction.REVERSE);
        rightbackdrive.setDirection(DcMotor.Direction.REVERSE);

        buttonLeft.setPosition(1.0);
        buttonRight.setPosition(0.0);

        correctColor = true;

        lightThreashold = 0.98;

        resetDriveEncoders();
        waitForStart();

        runmotorsusingencoders();


        leftfrontdrive.setTargetPosition(900);
        leftbackdrive.setTargetPosition(900);

        while (opModeIsActive() && leftbackdrive.getCurrentPosition()<900) {
            leftbackdrive.setPower(0.5);
            leftfrontdrive.setPower(0.5);


        }
        stopmotors();

        resetDriveEncoders();
        telemetry.addData("2", 2);
        telemetry.update();



runmotorsusingencoders();
        while(ODS.getLightDetected() < lightThreashold && opModeIsActive()) {
            rightbackdrive.setPower(.3);
            rightfrontdrive.setPower(.3);
            leftbackdrive.setPower(.3);
            leftfrontdrive.setPower(.3);

        }
        stopmotors();

        resetDriveEncoders();
telemetry.addData("4", 4);
        telemetry.update();
        runmotorsusingencoders();


        rightfrontdrive.setTargetPosition(-1200);
        rightbackdrive.setTargetPosition(-1200);

        while (opModeIsActive() && rightbackdrive.getCurrentPosition()>-1200){
            rightbackdrive.setPower(-0.5);
            rightfrontdrive.setPower(-0.5);
            idle();
            telemetry.addData("5", 5);
            telemetry.update();

        }
        stopmotors();
        resetDriveEncoders();
        telemetry.addData("6", 6);
        telemetry.update();






    }
    public void resetDriveEncoders() {
        rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void runmotorsusingencoders() {
        rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void runfullpowerforward(double power) {
        rightfrontdrive.setPower(power);
        rightbackdrive.setPower(power);
        leftbackdrive.setPower(power);
        leftfrontdrive.setPower(power);
    }

    public void stopmotors() {
        rightfrontdrive.setPower(0.0);
        rightbackdrive.setPower(0.0);
        leftbackdrive.setPower(0.0);
        leftfrontdrive.setPower(0.0);
    }

    public void runfullpowerbackward() {
        rightfrontdrive.setPower(-0.5);
        rightbackdrive.setPower(-0.5);
        leftbackdrive.setPower(-0.5);
        leftfrontdrive.setPower(-0.5);
    }

}


