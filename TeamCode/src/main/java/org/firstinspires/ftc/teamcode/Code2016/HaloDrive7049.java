package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stevenelias on 10/25/16.
 */
@TeleOp(name = "HaloDrive7049", group = "TeleOp")

public class HaloDrive7049 extends OpMode {
    // Define variables.
    DcMotor rightfrontDrive;
    DcMotor leftfrontDrive;
    DcMotor rightbackDrive;
    DcMotor leftbackDrive;

    Servo buttonleft;
    Servo buttonright;
    Servo shooterpusher;
    Servo blocker;


    DcMotor sweeper;
    DcMotor conveyor;

    DcMotor shooterleft;
    DcMotor shooterright;





    @Override
    public void init() {
        // Tell the program to search for a dcmotor called rightfrontdrive and set it equal to rightfrontdrive.
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




        buttonright.setPosition(0.5);
        buttonleft.setPosition(0.5);
        shooterpusher.setPosition(0.0);
        blocker.setPosition(1.0);




    }

    @Override
    public void loop() {


        if (gamepad1.left_stick_y != 0) {
            rightfrontDrive.setPower(-gamepad1.left_stick_y);
            rightbackDrive.setPower(-gamepad1.left_stick_y);
            leftfrontDrive.setPower(-gamepad1.left_stick_y);
            leftbackDrive.setPower(-gamepad1.left_stick_y);
        }




        else if (gamepad1.right_stick_x > 0) {
            rightfrontDrive.setPower(-gamepad1.right_stick_x);
            rightbackDrive.setPower(-gamepad1.right_stick_x);
            leftfrontDrive.setPower(gamepad1.right_stick_x);
            leftbackDrive.setPower(gamepad1.right_stick_x);

        }


        else if (gamepad1.right_stick_x < 0) {
            rightfrontDrive.setPower(-gamepad1.right_stick_x);
            rightbackDrive.setPower(-gamepad1.right_stick_x);
            leftfrontDrive.setPower(gamepad1.right_stick_x);
            leftbackDrive.setPower(gamepad1.right_stick_x);
        }
        else {


            rightfrontDrive.setPower(0.0);
            rightbackDrive.setPower(0.0);
            leftfrontDrive.setPower(0.0);
            leftbackDrive.setPower(0.0);
        }



        if (gamepad1.right_bumper){


         shooterleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            shooterright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            shooterleft.setPower(1.0);
            shooterright.setPower(1.0);

            sleep(1000);
            shooterpusher.setPosition(1.0);
            sleep(700);

            shooterpusher.setPosition(0.0);
            shooterleft.setPower(0.0);
            shooterright.setPower(0.0);
            }
        if (gamepad1.dpad_down){
            blocker.setPosition(1.0);
        }
        if (gamepad1.dpad_up){
            blocker.setPosition(0.7);
        }




        if (gamepad2.dpad_up){
            conveyor.setPower(0.5);
        }
        else if (gamepad2.dpad_down){
            conveyor.setPower(-0.5);
        }
        else if (gamepad2.dpad_right){
            conveyor.setPower(0.0);
        }


        if (gamepad2.left_trigger>0.5){
            sweeper.setPower(1.0);

        }
        else if (gamepad2.left_trigger<0.5 && gamepad2.right_trigger<0.5){
            sweeper.setPower(0.0);
        }
        else if (gamepad2.right_trigger>0.5){
            sweeper.setPower(-1.0);
        }
        if (gamepad2.a){
            buttonright.setPosition(0.6);
        }
        else if (gamepad2.b){
            buttonright.setPosition(0.4);
        }
        else{
            buttonright.setPosition(0.5);
        }
        if(gamepad2.x){
            buttonleft.setPosition(0.4);
        }
        else if (gamepad2.y){
            buttonleft.setPosition(0.6);
        }
        else{
            buttonleft.setPosition(0.5244);
        }





    }
    public void sleep(int millis){
        try {


            Thread.sleep(millis);
        }
        catch (InterruptedException e){

        }
    }
}
