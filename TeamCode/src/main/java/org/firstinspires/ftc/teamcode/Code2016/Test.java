package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by stevenelias on 10/29/16.
 */
@Autonomous(name = "TEST", group = "Autonomous")
public class Test extends OpMode {
    DcMotor rightfrontdrive;
    DcMotor leftfrontdrive;
    DcMotor rightbackdrive;
    DcMotor leftbackdrive;
    @Override
    public void init() {
        rightfrontdrive = hardwareMap.dcMotor.get("leftfrontdrive");
        leftfrontdrive = hardwareMap.dcMotor.get("rightfrontdrive");
        rightbackdrive = hardwareMap.dcMotor.get("leftbackdrive");
        leftbackdrive = hardwareMap.dcMotor.get("rightbackdrive");


    }

    @Override
    public void loop() {
        rightfrontdrive.setPower(-0.2);
        leftfrontdrive.setPower(0.2);
        rightbackdrive.setPower(-0.2);
        leftbackdrive.setPower(0.2);

    }
}
