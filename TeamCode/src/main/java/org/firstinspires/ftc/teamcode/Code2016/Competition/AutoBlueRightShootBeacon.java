package org.firstinspires.ftc.teamcode.Code2016.Competition;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by stevenelias on 11/17/16.
 */
@Autonomous(name = "AutoBlueRightShootBeacon", group = "Autonomous")
@Disabled
public class AutoBlueRightShootBeacon extends LinearOpMode {
    DcMotor rightfrontDrive;
    DcMotor rightbackDrive;
    DcMotor leftfrontDrive;
    DcMotor leftbackDrive;

    DcMotor sweeper;
    DcMotor conveyor;

    DcMotor shooterleft;
    DcMotor shooterright;

    Servo buttonleft;
    Servo buttonright;
    Servo blocker;
    Servo shooterpusher;

    OpticalDistanceSensor ODS;
    OpticalDistanceSensor Range;

    ColorSensor color;

    ModernRoboticsI2cGyro gyro;

    TouchSensor touch;

    boolean correctcolor;

    @Override
    public void runOpMode() throws InterruptedException {
        rightfrontDrive = hardwareMap.dcMotor.get("rightfrontdrive");
        leftfrontDrive = hardwareMap.dcMotor.get("leftfrontdrive");
        rightbackDrive = hardwareMap.dcMotor.get("rightbackdrive");
        leftbackDrive = hardwareMap.dcMotor.get("leftbackdrive");

        sweeper = hardwareMap.dcMotor.get("sweeper");
        conveyor = hardwareMap.dcMotor.get("conveyor");

        shooterleft = hardwareMap.dcMotor.get("shooterleft");
        shooterright = hardwareMap.dcMotor.get("shooterright");







        rightfrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightbackDrive.setDirection(DcMotor.Direction.REVERSE);
        shooterright.setDirection(DcMotor.Direction.REVERSE);



        buttonleft = hardwareMap.servo.get("buttonleft");
        buttonright = hardwareMap.servo.get("buttonright");
        shooterpusher = hardwareMap.servo.get("shooterpusher");
        blocker = hardwareMap.servo.get("blocker");

        ODS = hardwareMap.opticalDistanceSensor.get("ODS");
        Range = hardwareMap.opticalDistanceSensor.get("Range");
        gyro = hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");
        color = hardwareMap.colorSensor.get("color");
        touch = hardwareMap.touchSensor.get("touch");

        blocker.setPosition(1.0);
        shooterpusher.setPosition(0.0);
        buttonleft.setPosition(0.5244);
        buttonright.setPosition(0.5);

        gyro.calibrate();
        while (gyro.isCalibrating()){







        }
        telemetry.addLine("gyrocalibrated");
        telemetry.update();



        resetdriveencoders();


        waitForStart();
        gyro.resetZAxisIntegrator();
        sleep(1000);



        setdriveposition(850);
        runtoposition();

        drive(0.3);
        while (opModeIsActive() && rightbackDrive.isBusy() && leftbackDrive.isBusy()){

        }
        stopmotors();


        resetdriveencoders();
        runwithoutencoders();




        shooterleft.setPower(1.0);
        shooterright.setPower(1.0);
        stopmotors();

        sleep(1000);
        shooterpusher.setPosition(1.0);
        sleep(700);

        shooterpusher.setPosition(0.0);
        shooterleft.setPower(0.0);
        shooterright.setPower(0.0);

        sleep(250);

        blocker.setPosition(0.7);
        conveyor.setPower(0.5);
        sleep(1000);
        blocker.setPosition(1.0);

        shooterleft.setPower(1.0);
        shooterright.setPower(1.0);
        stopmotors();

        sleep(1000);
        shooterpusher.setPosition(1.0);
        sleep(700);

        shooterpusher.setPosition(0.0);
        shooterleft.setPower(0.0);
        shooterright.setPower(0.0);
        conveyor.setPower(0.0);

        runwithoutencoders();
        while(opModeIsActive() && gyro.getIntegratedZValue()>-33){
            turnright(0.2);
        }
        stopmotors();
        runwithoutencoders();
        while(opModeIsActive() && ODS.getLightDetected()<0.4){
            drive(0.2);
        }
        stopmotors();
        /*runwithoutencoders();
        drive(-0.2);
        sleep(100);
        stopmotors();
        resetdriveencoders();
        */

        runwithoutencoders();
        gyro.resetZAxisIntegrator();
        sleep(500);
        while (opModeIsActive() && gyro.getIntegratedZValue()>-39){
            turnright(0.2);
        }
        stopmotors();
        runwithoutencoders();
        while (opModeIsActive() && !touch.isPressed()){
            drive(0.1);
        }

        stopmotors();

        if (color.blue()>color.red() && color.blue() > color.green()){
            buttonright.setPosition(0.4);
            sleep(750);
            buttonright.setPosition(0.5);
            sleep(500);
            buttonright.setPosition(0.6);
            sleep(750);
            buttonright.setPosition(0.5);
        }
        else{
            buttonleft.setPosition(0.6);
            sleep(750);
            buttonleft.setPosition(0.5244);
            sleep(500);
            buttonleft.setPosition(0.4);
            sleep(750);
            buttonleft.setPosition(0.5244);
        }
        gyro.resetZAxisIntegrator();
        sleep(1000);

        runwithoutencoders();
        drive(-0.4);
        sleep(180);
        stopmotors();

        runwithoutencoders();

        while (opModeIsActive() && gyro.getIntegratedZValue()<76){
            turnleft(0.2);
        }
        stopmotors();
        runwithoutencoders();
        while (opModeIsActive() && ODS.getLightDetected()<0.4){
            drive(0.2);
        }
        stopmotors();

        runwithoutencoders();
        gyro.resetZAxisIntegrator();
        sleep(500);
        while (opModeIsActive() && gyro.getIntegratedZValue()>-77){
            turnright(0.2);
        }
        stopmotors();
        runwithoutencoders();
        while (opModeIsActive() && !touch.isPressed()){
            drive(0.1);
        }

        stopmotors();

        if (color.blue()>color.red() && color.blue() > color.green()){
            buttonright.setPosition(0.4);
            sleep(1000);
            buttonright.setPosition(0.5);
            sleep(500);
            buttonright.setPosition(0.6);
            sleep(1000);
            buttonright.setPosition(0.5);
        }
        else{
            buttonleft.setPosition(0.6);
            sleep(1000);
            buttonleft.setPosition(0.5244);
            sleep(500);
            buttonleft.setPosition(0.4);
            sleep(1000);
            buttonleft.setPosition(0.5244);
        }





    }
    public void runtoposition(){
        rightbackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightfrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftfrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftbackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void runwithoutencoders(){
        rightbackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightfrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftfrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftbackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    public void drive(double power){
        rightbackDrive.setPower(power);
        rightfrontDrive.setPower(power);
        leftfrontDrive.setPower(power);
        leftbackDrive.setPower(power);
    }
    public void stopmotors(){
        rightbackDrive.setPower(0.0);
        rightfrontDrive.setPower(0.0);
        leftfrontDrive.setPower(0.0);
        leftbackDrive.setPower(0.0);
    }
    public void resetdriveencoders(){
        rightbackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightfrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftfrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftbackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void setdriveposition(int position){
        rightbackDrive.setTargetPosition(position);
        rightfrontDrive.setTargetPosition(position);
        leftbackDrive.setTargetPosition(position);
        leftfrontDrive.setTargetPosition(position);
    }
    public void turnleft(double power){
        rightbackDrive.setPower(power);
        rightfrontDrive.setPower(power);
        leftfrontDrive.setPower(-power);
        leftbackDrive.setPower(-power);
    }
    public void turnright(double power){
        rightbackDrive.setPower(-power);
        rightfrontDrive.setPower(-power);
        leftfrontDrive.setPower(power);
        leftbackDrive.setPower(power);
    }
    public void brakemotors(){
        rightbackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightfrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftbackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftfrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

}
