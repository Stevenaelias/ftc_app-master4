package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by stevenelias on 10/6/16.
 */
@Autonomous(name = "EncoderTest", group = "Autonomous")
@Disabled
//set variables
public class EncoderTest extends LinearOpMode {
    DcMotor motor;


    @Override
    public void runOpMode() throws InterruptedException {
        //locate variables
        motor = hardwareMap.dcMotor.get("motor_1");

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        motor.setTargetPosition(1000);

        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motor.setPower(1.0);

        while (motor.isBusy()){

        }





    }
}