package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stevenelias on 10/10/16.
 */
@TeleOp(name = "TankDriveTest", group = "TeleOp")
@Disabled

public class TankDriveTest extends OpMode {

    // I want to call one of the DcMotors rightDrive, and one of the servos clawLeft.
    DcMotor rightfrontDrive;
    DcMotor leftfrontDrive;
    DcMotor rightbackDrive;
    DcMotor leftbackDrive;
    DcMotor sweeper;
    DcMotor conveyor;

    Servo buttonleft;
    Servo buttonright;



    @Override
    public void init() {
        // Tell the program to search for a dcmotor called motor_1 and set it equal to rightDrive.
        rightfrontDrive = hardwareMap.dcMotor.get("rightfrontdrive");
        leftfrontDrive = hardwareMap.dcMotor.get("leftfrontdrive");
        rightbackDrive= hardwareMap.dcMotor.get("rightbackdrive");
        leftbackDrive= hardwareMap.dcMotor.get("leftbackdrive");
        sweeper = hardwareMap.dcMotor.get("sweeper");
        conveyor = hardwareMap.dcMotor.get("conveyor");

        buttonleft = hardwareMap.servo.get("buttonleft");
        buttonright = hardwareMap.servo.get("buttonright");




        rightfrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightbackDrive.setDirection(DcMotor.Direction.REVERSE);



    }

    @Override
    public void loop() {
        //if the left stick y value on the gamepad is less then O, set the drive powers to whatever left_stick_y is.
        rightbackDrive.setPower(-gamepad1.left_stick_y);
        rightfrontDrive.setPower(-gamepad1.left_stick_y);
        leftbackDrive.setPower(-gamepad1.right_stick_y);
        leftbackDrive.setPower(-gamepad1.right_stick_y);

/* If the statement above isn't true, then if the right stick x value is less then O, set the right motor power to reverse
        half power, and the left motor power to forward at half power. This will make the robot turn right.
        Note that DcMotor powers range from -1(reverse at full power) to 1(forward at full power).
        */

        /* If the statement above isn't true, then if the right stick x value is greater than 0, set the right motor to
        forward at half power, and the left motor to reverse at half power. This will make the robot turn left.
         */



        if (gamepad1.a) {
            buttonleft.setPosition(0.4);
        } else if (gamepad1.b) {
            buttonleft.setPosition(1.0);
        }
        if (gamepad1.x) {
            buttonright.setPosition(0.6);
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
