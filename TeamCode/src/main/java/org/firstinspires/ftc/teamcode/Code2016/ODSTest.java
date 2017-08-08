package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * Created by stevenelias on 10/21/16.
 */
@Autonomous(name = "ODSTest", group = "Autonomous")

public class ODSTest extends OpMode {
    OpticalDistanceSensor ODS;
    @Override
    public void init() {
        ODS = hardwareMap.opticalDistanceSensor.get("ODS");
    }


    @Override
    public void loop() {
        telemetry.addData("raw", ODS.getRawLightDetected());
        telemetry.addData("normal", ODS.getLightDetected());

    }
}
