package org.firstinspires.ftc.teamcode.Code2016.Competition;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stevenelias on 10/29/16.
 */
@Autonomous(name = "AutoRedVortexBeaconPark", group = "Autonomous")
@Disabled
public class AutoRedVortexBeaconPark extends LinearOpMode {
    DcMotor rightfrontdrive;
    DcMotor leftfrontdrive;
    DcMotor rightbackdrive;
    DcMotor leftbackdrive;

    Servo buttonleft;
    Servo buttonright;
    Servo shooterpusher;
    Servo blocker;


    DcMotor sweeper;
    DcMotor conveyor;

    DcMotor shooterleft;
    DcMotor shooterright;

    ColorSensor color;
    GyroSensor gyro;
    OpticalDistanceSensor ODS;


    @Override
    public void runOpMode() throws InterruptedException {
        rightfrontdrive = hardwareMap.dcMotor.get("leftfrontdrive");
        leftfrontdrive = hardwareMap.dcMotor.get("rightfrontdrive");
        rightbackdrive = hardwareMap.dcMotor.get("leftbackdrive");
        leftbackdrive = hardwareMap.dcMotor.get("rightbackdrive");

        sweeper = hardwareMap.dcMotor.get("shooterleft");
        conveyor = hardwareMap.dcMotor.get("shooterright");




        rightfrontdrive.setDirection(DcMotor.Direction.REVERSE);
        rightbackdrive.setDirection(DcMotor.Direction.REVERSE);




        color = hardwareMap.colorSensor.get("color");
        gyro = hardwareMap.gyroSensor.get("gyro");
        ODS = hardwareMap.opticalDistanceSensor.get("ODS");



        buttonleft = hardwareMap.servo.get("buttonleft");
        buttonright = hardwareMap.servo.get("buttonright");
        shooterpusher = hardwareMap.servo.get("shooterpusher");
        blocker = hardwareMap.servo.get("blocker");

        boolean correctcolor;


        buttonleft.setPosition(0.0);
        buttonright.setPosition(1.0);
        shooterpusher.setPosition(0.0);
        blocker.setPosition(1.0);

        gyro.calibrate();
        while (gyro.isCalibrating()){
            telemetry.addData("gyroiscalibrating", gyro.isCalibrating());
            telemetry.update();
        }
        resetDriveEncoders();



        waitForStart();


        runmotorsusingencoders();
        while (opModeIsActive() && gyro.getHeading()>327 || opModeIsActive() && gyro.getHeading() == 0){
            rightbackdrive.setPower(0.2);
            rightfrontdrive.setPower(0.2);
        }
        stopmotors();
        resetDriveEncoders();




        runwithoutencoders();
        while (opModeIsActive() && ODS.getLightDetected()<0.89){
            leftbackdrive.setPower(0.2);
            leftfrontdrive.setPower(0.2);
            rightbackdrive.setPower(0.2);
            rightfrontdrive.setPower(0.2);
        }
        stopmotors();

        resetDriveEncoders();

        runwithoutencoders();
        while(opModeIsActive() && gyro.getHeading()>275){
            leftbackdrive.setPower(-0.2);
            leftfrontdrive.setPower(-0.2);
        }
        stopmotors();
        resetDriveEncoders();
        runmotorsusingencoders();

        leftbackdrive.setTargetPosition(355);
        leftfrontdrive.setTargetPosition(355);
        rightbackdrive.setTargetPosition(355);
        rightfrontdrive.setTargetPosition(355);

        while (opModeIsActive() && rightbackdrive.getCurrentPosition() < 355){
            drive(0.2);
        }
        stopmotors();
        resetDriveEncoders();

        if (color.red()>color.green() && color.red()>color.blue()){
            correctcolor = true;
        }
        else {
            correctcolor = false;
        }
        runwithoutencoders();

        drive(-0.2);
        sleep(1000);

        stopmotors();
        resetDriveEncoders();



        if (correctcolor){
            buttonright.setPosition(0.3);
            runwithoutencoders();
            while (gyro.getHeading()>275){
                rightbackdrive.setPower(0.2);
                rightfrontdrive.setPower(0.2);
            }
            stopmotors();
            resetDriveEncoders();
        }
        else if (!correctcolor){
            buttonleft.setPosition(0.6);
            runwithoutencoders();
            while (gyro.getHeading()>278){
                rightbackdrive.setPower(0.2);
                rightfrontdrive.setPower(0.2);
            }
            stopmotors();
            resetDriveEncoders();
        }



        runwithoutencoders();

        drive(0.2);

        sleep(1250);

        stopmotors();
        resetDriveEncoders();

        runmotorsusingencoders();
        rightbackdrive.setTargetPosition(-300);
        rightfrontdrive.setTargetPosition(-300);
        leftfrontdrive.setTargetPosition(-300);
        leftbackdrive.setTargetPosition(-300);

        while (rightbackdrive.getCurrentPosition()>-300){
            drive(-0.2);
        }
        stopmotors();
        resetDriveEncoders();

        runwithoutencoders();
        while (gyro.getHeading()>250){
            leftbackdrive.setPower(-0.2);
            leftfrontdrive.setPower(-0.2);
        }
        stopmotors();
        resetDriveEncoders();

        runwithoutencoders();

        while (opModeIsActive() && ODS.getLightDetected()<0.4){
            drive(-0.2);
        }
        stopmotors();
        resetDriveEncoders();
        runwithoutencoders();
        while (opModeIsActive() && gyro.getHeading() > 220){
            rightbackdrive.setPower(0.2);
            rightfrontdrive.setPower(0.2);
        }
        stopmotors();
        resetDriveEncoders();

        runwithoutencoders();

        drive(0.4);
        sleep(3250);
        stopmotors();
        resetDriveEncoders();

        conveyor.setPower(1.0);
        sweeper.setPower(-1.0);
        sleep(10000);












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

    public void drive(double power) {
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
    public void turnright(double power){
        rightfrontdrive.setPower(-power);
        rightbackdrive.setPower(-power);
        leftbackdrive.setPower(power);
        leftfrontdrive.setPower(power);
    }
    public void turnleft(double power){
        rightfrontdrive.setPower(power);
        rightbackdrive.setPower(power);
        leftbackdrive.setPower(-power);
        leftfrontdrive.setPower(-power);
    }
    public void runwithoutencoders(){
        leftbackdrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftfrontdrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightfrontdrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightbackdrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
