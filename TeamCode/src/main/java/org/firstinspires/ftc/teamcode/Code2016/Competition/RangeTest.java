package org.firstinspires.ftc.teamcode.Code2016.Competition;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Created by stevenelias on 11/29/16.
 */
@Autonomous(name = "RangeTest", group = "Autonomous")
public class RangeTest extends OpMode {
    ModernRoboticsI2cRangeSensor Range;
    @Override
    public void init() {
        Range = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "Range");
    }

    @Override
    public void loop() {
        telemetry.addData("Distance", Range.getDistance(DistanceUnit.MM));
        telemetry.update();
    }
}
