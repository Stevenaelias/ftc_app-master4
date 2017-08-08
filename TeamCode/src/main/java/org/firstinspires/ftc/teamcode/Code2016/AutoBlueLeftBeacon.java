package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stevenelias on 10/17/16.
 */
@Autonomous(name = "AutoBlueLeftBeacon", group = "Autonomous")
@Disabled

public class AutoBlueLeftBeacon extends LinearOpMode {
    DcMotor rightfrontdrive;
    DcMotor rightbackdrive;
    DcMotor leftfrontdrive;
    DcMotor leftbackdrive;

    Servo buttonLeft;
    Servo buttonRight;

    ColorSensor color;

    boolean correctColor;

    @Override
    public void runOpMode() throws InterruptedException {

        rightfrontdrive = hardwareMap.dcMotor.get("motor_1");
        rightbackdrive = hardwareMap.dcMotor.get("motor_2");
        leftfrontdrive = hardwareMap.dcMotor.get("motor_3");
        leftbackdrive = hardwareMap.dcMotor.get("motor_4");

        buttonLeft = hardwareMap.servo.get("servo_1");
        buttonRight = hardwareMap.servo.get("servo_2");

        color = hardwareMap.colorSensor.get("color");

        rightfrontdrive.setDirection(DcMotor.Direction.REVERSE);
        rightbackdrive.setDirection(DcMotor.Direction.REVERSE);

        buttonLeft.setPosition(1.0);
        buttonRight.setPosition(0.0);

        correctColor = true;




    }
}
