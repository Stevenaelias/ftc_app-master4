package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stevenelias on 8/29/16.
 */
@TeleOp(name = "HaloDriveTest", group = "TeleOp")
@Disabled

// Tell the program that HaloDriveTest is an OpMode by writing "extends OpMode"
public class HaloDriveTest extends OpMode { // the program starts at this bracket

    // I want to call one of the DcMotors rightDrive, and one of the servos clawLeft.
    DcMotor rightfrontDrive;
    DcMotor leftfrontDrive;
    DcMotor rightbackDrive;
    DcMotor leftbackDrive;

    Servo buttonleft;
    Servo buttonright;


    DcMotor sweeper;
    DcMotor conveyor;



    @Override
    public void init() {
        // Tell the program to search for a dcmotor called motor_1 and set it equal to rightDrive.
        rightfrontDrive = hardwareMap.dcMotor.get("rightfrontdrive");
        leftfrontDrive = hardwareMap.dcMotor.get("leftfrontdrive");
        rightbackDrive = hardwareMap.dcMotor.get("rightbackdrive");
        leftbackDrive = hardwareMap.dcMotor.get("leftbackdrive");

        sweeper = hardwareMap.dcMotor.get("sweeper");
        conveyor = hardwareMap.dcMotor.get("conveyor");







        rightfrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightbackDrive.setDirection(DcMotor.Direction.REVERSE);



        buttonleft = hardwareMap.servo.get("buttonleft");
        buttonright = hardwareMap.servo.get("buttonright");

        buttonleft.setPosition(1.0);
        buttonright.setPosition(0.0);




    }

    @Override
    public void loop() {
        //if the left stick y value on the gamepad is less then O, set the drive powers to whatever left_stick_y is.
        if (gamepad1.left_stick_y != 0) {
            rightfrontDrive.setPower(gamepad1.left_stick_y);
            rightbackDrive.setPower(gamepad1.left_stick_y);
            leftfrontDrive.setPower(gamepad1.left_stick_y);
            leftbackDrive.setPower(gamepad1.left_stick_y);
        }



/* If the statement above isn't true, then if the right stick x value is less then O, set the right motor power to reverse
        half power, and the left motor power to forward at half power. This will make the robot turn right.
        Note that DcMotor powers range from -1(reverse at full power) to 1(forward at full power).
        */
        else if (gamepad1.right_stick_x > 0) {
            rightfrontDrive.setPower(gamepad1.right_stick_x);
            rightbackDrive.setPower(gamepad1.right_stick_x);
            leftfrontDrive.setPower(-gamepad1.right_stick_x);
            leftbackDrive.setPower(-gamepad1.right_stick_x);

        }
        /* If the statement above isn't true, then if the right stick x value is greater than 0, set the right motor to
        forward at half power, and the left motor to reverse at half power. This will make the robot turn left.
         */

        else if (gamepad1.right_stick_x < 0) {
            rightfrontDrive.setPower(gamepad1.right_stick_x);
            rightbackDrive.setPower(gamepad1.right_stick_x);
            leftfrontDrive.setPower(-gamepad1.right_stick_x);
            leftbackDrive.setPower(-gamepad1.right_stick_x);
        } else {
            /* Otherwise, if none of the three statements above are true, set the power on both motors to 0. This will make
            the robot sit still.
             */

            rightfrontDrive.setPower(0.0);
            rightbackDrive.setPower(0.0);
            leftfrontDrive.setPower(0.0);
            leftbackDrive.setPower(0.0);
        }
        if (gamepad1.a) {
            buttonleft.setPosition(0.0);
        } else if (gamepad1.b) {
            buttonleft.setPosition(1.0);
        }
        if (gamepad1.x) {
            buttonright.setPosition(1.0);
        } else if (gamepad1.y) {
            buttonright.setPosition(0.0);
        }

        if (gamepad1.right_bumper){
            sweeper.setPower(1.0);

        }
        else if (gamepad1.left_bumper){
            sweeper.setPower(0.0);
        }
        else if (gamepad1.dpad_right){
            sweeper.setPower(-1.0);
        }

        if (gamepad1.dpad_up){
            conveyor.setPower(1.0);
        }
        else if(gamepad1.dpad_down){
            conveyor.setPower(0.0);
        }




    }


}