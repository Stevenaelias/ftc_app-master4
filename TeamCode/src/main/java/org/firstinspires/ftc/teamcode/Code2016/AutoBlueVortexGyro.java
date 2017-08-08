package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;
//hello

/**
 * Created by stevenelias on 10/21/16.
 */
@Autonomous(name = "AutoBlueVortexGyro", group = "Autonomous")
@Disabled
public class AutoBlueVortexGyro extends LinearOpMode {
    DcMotor rightfrontdrive;
    DcMotor rightbackdrive;
    DcMotor leftfrontdrive;
    DcMotor leftbackdrive;

    Servo buttonLeft;
    Servo buttonRight;

    ColorSensor color;

    GyroSensor gyro;

    boolean correctColor;

    //1120 ticks on andymark encoders
    @Override
    public void runOpMode() throws InterruptedException {
        rightfrontdrive = hardwareMap.dcMotor.get("rightfrontdrive");
        rightbackdrive = hardwareMap.dcMotor.get("rightbackdrive");
        leftfrontdrive = hardwareMap.dcMotor.get("leftfrontdrive");
        leftbackdrive = hardwareMap.dcMotor.get("leftbackdrive");

        buttonLeft = hardwareMap.servo.get("buttonleft");
        buttonRight = hardwareMap.servo.get("buttonright");

        color = hardwareMap.colorSensor.get("color");

        gyro = hardwareMap.gyroSensor.get("gyro");

        leftfrontdrive.setDirection(DcMotor.Direction.REVERSE);
        leftbackdrive.setDirection(DcMotor.Direction.REVERSE);

        buttonLeft.setPosition(1.0);
        buttonRight.setPosition(0.0);
        gyro.calibrate();

        waitForStart();

        resetDriveEncoders();

        rightfrontdrive.setTargetPosition(2673);
        rightbackdrive.setTargetPosition(2673);
        leftfrontdrive.setTargetPosition(2673);
        leftbackdrive.setTargetPosition(2673);

        runmotorsusingencoders();

        while (opModeIsActive() && rightbackdrive.getCurrentPosition() < 2673) {
            runfullpowerforward();
        }
        stopmotors();

        resetDriveEncoders();

        while (opModeIsActive() && gyro.getHeading() != 90){
            turnrightfullpower();
        }
        stopmotors();
        resetDriveEncoders();




        rightfrontdrive.setTargetPosition(2105);
        rightbackdrive.setTargetPosition(2105);
        leftfrontdrive.setTargetPosition(2105);
        leftbackdrive.setTargetPosition(2105);

        runmotorsusingencoders();

        while (opModeIsActive() && rightbackdrive.getCurrentPosition() < 2105) {
            runfullpowerforward();
        }
        stopmotors();
        resetDriveEncoders();

        while(opModeIsActive() && gyro.getHeading() != 0 ){
            turnleftfullpower();
        }
        stopmotors();
        resetDriveEncoders();

        //REMEASURE THIS!!!!
        rightfrontdrive.setTargetPosition(178);
        rightbackdrive.setTargetPosition(178);
        leftfrontdrive.setTargetPosition(178);
        leftbackdrive.setTargetPosition(178);

        runmotorsusingencoders();

        while (opModeIsActive() && rightbackdrive.getCurrentPosition() < 178) {
            runfullpowerforward();
        }
        stopmotors();
        resetDriveEncoders();

        while (opModeIsActive() && gyro.getHeading() != 90){
            turnrightfullpower();
        }
        stopmotors();
        resetDriveEncoders();


        rightfrontdrive.setTargetPosition(1069);
        rightbackdrive.setTargetPosition(1069);
        leftfrontdrive.setTargetPosition(1069);
        leftbackdrive.setTargetPosition(1069);

        runmotorsusingencoders();

        while (opModeIsActive() && rightbackdrive.getCurrentPosition() < 1069) {
            runfullpowerforward();
        }
        stopmotors();


        if (color.blue() > color.green() && color.blue() > color.red()) {
            correctColor = true;
        } else if (color.red() > color.blue() && color.red() > color.green()) {
            correctColor = false;
        }

        resetDriveEncoders();
/////////////////////////////////////////////////////
        rightfrontdrive.setTargetPosition(-351);
        rightbackdrive.setTargetPosition(-351);
        leftfrontdrive.setTargetPosition(-351);
        leftbackdrive.setTargetPosition(-351);

        runmotorsusingencoders();


        while (opModeIsActive() && rightfrontdrive.getCurrentPosition() > -351) {
            runfullpowerbackward();
        }
        stopmotors();


        if (correctColor && opModeIsActive()) {
            buttonRight.setPosition(0.5);
        }
        else if (!correctColor && opModeIsActive()) {
            buttonLeft.setPosition(0.5);
        }
        resetDriveEncoders();

        rightfrontdrive.setTargetPosition(500);
        rightbackdrive.setTargetPosition(500);
        leftfrontdrive.setTargetPosition(500);
        leftbackdrive.setTargetPosition(500);


        runmotorsusingencoders();

        while (opModeIsActive() && rightfrontdrive.getCurrentPosition() < 500) {
            runfullpowerforward();
        }

        stopmotors();

        resetDriveEncoders();

        rightfrontdrive.setTargetPosition(-351);
        rightbackdrive.setTargetPosition(-351);
        leftfrontdrive.setTargetPosition(-351);
        leftbackdrive.setTargetPosition(-351);

        runmotorsusingencoders();


        while (opModeIsActive() && rightfrontdrive.getCurrentPosition() > -351) {
            runfullpowerbackward();
        }
        stopmotors();
        resetDriveEncoders();



    }

    public void resetDriveEncoders() {
        rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void runmotorsusingencoders(){
        rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void runfullpowerforward(){
        rightfrontdrive.setPower(1.0);
        rightbackdrive.setPower(1.0);
        leftbackdrive.setPower(1.0);
        leftfrontdrive.setPower(1.0);
    }
    public void stopmotors(){
        rightfrontdrive.setPower(0.0);
        rightbackdrive.setPower(0.0);
        leftbackdrive.setPower(0.0);
        leftfrontdrive.setPower(0.0);
    }
    public void runfullpowerbackward(){
        rightfrontdrive.setPower(-1.0);
        rightbackdrive.setPower(-1.0);
        leftbackdrive.setPower(-1.0);
        leftfrontdrive.setPower(-1.0);
    }
    public void turnrightfullpower(){
        rightfrontdrive.setPower(-1.0);
        rightbackdrive.setPower(-1.0);
        leftbackdrive.setPower(1.0);
        leftfrontdrive.setPower(1.0);
    }
    public void turnleftfullpower(){
        rightfrontdrive.setPower(1.0);
        rightbackdrive.setPower(1.0);
        leftbackdrive.setPower(-1.0);
        leftfrontdrive.setPower(-1.0);
    }

}


