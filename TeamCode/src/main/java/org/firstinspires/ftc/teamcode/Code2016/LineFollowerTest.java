package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * Created by stevenelias on 10/21/16.
 */

public class LineFollowerTest extends LinearOpMode {
    DcMotor rightfrontdrive;
    DcMotor rightbackdrive;
    DcMotor leftfrontdrive;
    DcMotor leftbackdrive;

    OpticalDistanceSensor ODS;
    double targetLight;

    @Override
    public void runOpMode() throws InterruptedException {

            while(ODS.getLightDetected()!=targetLight){
                rightfrontdrive.setPower(1.0);
                rightbackdrive.setPower(1.0);
                leftbackdrive.setPower(1.0);
                leftfrontdrive.setPower(1.0);

            }
        stopmotors();

        while(ODS.getLightDetected()==16){//get edge of line

        }



    }
    public void stopmotors(){
        rightfrontdrive.setPower(0.0);
        rightbackdrive.setPower(0.0);
        leftbackdrive.setPower(0.0);
        leftfrontdrive.setPower(0.0);
    }
}
