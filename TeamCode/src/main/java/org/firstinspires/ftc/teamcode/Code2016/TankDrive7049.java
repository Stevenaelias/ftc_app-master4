package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stevenelias on 10/26/16.
 */
@TeleOp(name = "TankDrive7049", group = "TeleOp")

public class TankDrive7049 extends OpMode {
    DcMotor rightfrontDrive;
    DcMotor leftfrontDrive;
    DcMotor rightbackDrive;
    DcMotor leftbackDrive;
    DcMotor sweeper;
    DcMotor conveyor;
    DcMotor shooterright;
    DcMotor shooterleft;

    Servo buttonleft;
    Servo buttonright;
    Servo shooterpusher;
    Servo blocker;


    @Override
    public void init() {



    rightfrontDrive = hardwareMap.dcMotor.get("rightfrontdrive");
    leftfrontDrive = hardwareMap.dcMotor.get("leftfrontdrive");
    rightbackDrive= hardwareMap.dcMotor.get("rightbackdrive");
    leftbackDrive= hardwareMap.dcMotor.get("leftbackdrive");
    sweeper = hardwareMap.dcMotor.get("sweeper");
    conveyor = hardwareMap.dcMotor.get("conveyor");
        shooterleft = hardwareMap.dcMotor.get("shooterleft");
        shooterright = hardwareMap.dcMotor.get("shooterright");

    buttonleft = hardwareMap.servo.get("buttonleft");
    buttonright = hardwareMap.servo.get("buttonright");
        shooterpusher = hardwareMap.servo.get("shooterpusher");
        blocker = hardwareMap.servo.get("blocker");






    rightfrontDrive.setDirection(DcMotor.Direction.REVERSE);
    rightbackDrive.setDirection(DcMotor.Direction.REVERSE);
        shooterright.setDirection(DcMotorSimple.Direction.REVERSE);



        buttonleft.setPosition(0.0);
        buttonright.setPosition(1.0);
        shooterpusher.setPosition(0.0);
        blocker.setPosition(1.0);



}



    @Override
    public void loop() {
        //if the left stick y value on the gamepad is less then O, set the drive powers to whatever left_stick_y is.
        rightbackDrive.setPower(-gamepad1.left_stick_y);
        rightfrontDrive.setPower(-gamepad1.left_stick_y);
        leftbackDrive.setPower(-gamepad1.right_stick_y);
        leftbackDrive.setPower(-gamepad1.right_stick_y);

        if (gamepad1.a){
            shooterleft.setPower(1.0);
            shooterright.setPower(1.0);
        }
        else if (gamepad1.b){
            shooterleft.setPower(0.0);
            shooterright.setPower(0.0);
        }
        if (gamepad1.right_bumper){
            shooterpusher.setPosition(1.0);
            if (shooterpusher.getPosition()==1.0){
                shooterpusher.setPosition(0.0);
                if (shooterpusher.getPosition()==0.0){
                    blocker.setPosition(0.7);
                    if (blocker.getPosition()==0.7){
                        blocker.setPosition(0.0);
                    }
                }
            }

        }

        if (gamepad1.a){
            shooterleft.setPower(1.0);
            shooterright.setPower(1.0);
        }
        else if (gamepad1.b){
            shooterleft.setPower(0.0);
            shooterright.setPower(0.0);
        }
        if (gamepad1.right_bumper){
            shooterpusher.setPosition(1.0);
            sleep(600);
            shooterpusher.setPosition(0.0);
            sleep(300);
            blocker.setPosition(0.7);
            sleep(750);
            blocker.setPosition(1.0);

        }




        if (gamepad2.dpad_up){
            conveyor.setPower(1.0);
        }
        else if (gamepad2.dpad_down){
            conveyor.setPower(-1.0);
        }
        else if (gamepad2.dpad_right){
            conveyor.setPower(0.0);
        }

        if (gamepad2.a){
            buttonleft.setPosition(0.6);
        }
        else {
            buttonleft.setPosition(0.0);
        }

        if (gamepad2.b){
            buttonright.setPosition(0.4);
        }
        else {
            buttonright.setPosition(1.0);
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



    }
    public void sleep(int millis){
        try {


            Thread.sleep(millis);
        }
        catch (InterruptedException e){

        }
    }
}
