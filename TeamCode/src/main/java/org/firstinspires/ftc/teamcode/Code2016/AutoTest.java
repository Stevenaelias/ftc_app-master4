package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by stevenelias on 10/19/16.
 */
@Autonomous(name = "AutoTest", group = "Autonomous")
@Disabled
public class AutoTest extends LinearOpMode {


        DcMotor rightfrontdrive;




        double buttonLeftPosition;
        double buttonRightPosition;
        double leftTargetPower;
        double rightTargetPower;




        //1120 ticks on andymark encoders
        @Override
        public void runOpMode() throws InterruptedException {
            rightfrontdrive = hardwareMap.dcMotor.get("motor_1");






            rightfrontdrive.setDirection(DcMotor.Direction.REVERSE);




            int rightfrontdrivepos;



            rightfrontdrivepos = rightfrontdrive.getCurrentPosition();







            waitForStart();





            rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);




            rightfrontdrive.setTargetPosition(2673);


            rightfrontdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            while(rightfrontdrivepos!=rightfrontdrive.getTargetPosition()){
                rightfrontdrive.setPower(1.0);
                while(rightfrontdrivepos==rightfrontdrive.getTargetPosition()){
                    rightfrontdrive.setPower(0.0);
                }
            }











        }
    }

