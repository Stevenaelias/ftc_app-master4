package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by stevenelias on 8/30/16.
 */
@TeleOp(name = "ArcadeDriveTest", group = "TeleOp")

// Tell the program that HaloDriveTest is an OpMode by writing "extends OpMode"
public class ArcadeDriveTest extends OpMode {
    // I want to call one of the DcMotors rightDrive, and one of the servos clawLeft.
    DcMotor rightfrontDrive;
    DcMotor leftfrontDrive;
    DcMotor rightbackDrive;
    DcMotor leftbackDrive;
    DcMotor sweeper;



    @Override
    public void init() {
        // Tell the program to search for a dcmotor called motor_1 and set it equal to rightDrive.
        rightfrontDrive = hardwareMap.dcMotor.get("motor_1");
        leftfrontDrive = hardwareMap.dcMotor.get("motor_2");
        rightbackDrive= hardwareMap.dcMotor.get("motor_3");
        leftbackDrive= hardwareMap.dcMotor.get("motor_4");
        sweeper = hardwareMap.dcMotor.get("motor_5");


        rightfrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightbackDrive.setDirection(DcMotor.Direction.REVERSE);



    }

    @Override
    public void loop() {
        //if the left stick y value on the gamepad is less then O, set the drive powers to whatever left_stick_y is.
        if (gamepad1.left_stick_y > 0) {
            rightfrontDrive.setPower(-gamepad1.left_stick_y);
            rightbackDrive.setPower(-gamepad1.left_stick_y);
            leftfrontDrive.setPower(-gamepad1.left_stick_y);
            leftbackDrive.setPower(-gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_y < 0) {
            rightbackDrive.setPower(-gamepad1.left_stick_y);
            rightfrontDrive.setPower(-gamepad1.left_stick_y);
            leftbackDrive.setPower(-gamepad1.left_stick_y);
            leftfrontDrive.setPower(-gamepad1.left_stick_y);

        }

/* If the statement above isn't true, then if the right stick x value is less then O, set the right motor power to reverse
        half power, and the left motor power to forward at half power. This will make the robot turn right.
        Note that DcMotor powers range from -1(reverse at full power) to 1(forward at full power).
        */
        else if (gamepad1.left_stick_x < 0) {
            rightfrontDrive.setPower(1.0);
            rightbackDrive.setPower(1.0);
            leftfrontDrive.setPower(-1.0);
            leftbackDrive.setPower(-1.0);

        }
        /* If the statement above isn't true, then if the right stick x value is greater than 0, set the right motor to
        forward at half power, and the left motor to reverse at half power. This will make the robot turn left.
         */

        else if (gamepad1.left_stick_x > 0) {
            rightfrontDrive.setPower(-1.0);
            rightbackDrive.setPower(-1.0);
            leftfrontDrive.setPower(1.0);
            leftbackDrive.setPower(1.0);
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
            sweeper.setPower(-1.0);

        }
        if (gamepad1.b) {
            sweeper.setPower(1.0);

        }
        if (gamepad1.right_bumper) {
            sweeper.setPower(0.0);
        }
    }
}
