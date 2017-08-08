package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * Created by stevenelias on 10/26/16.
 */
@Autonomous(name = "GyroTest", group = "Autonomous")

public class GyroTest extends OpMode {

    GyroSensor gyro;
    @Override
    public void init() {

        gyro = hardwareMap.gyroSensor.get("gyro");
        gyro.calibrate();

    }

    @Override
    public void loop() {
        telemetry.addData("gyro", gyro.getHeading());
        telemetry.update();


    }
}
