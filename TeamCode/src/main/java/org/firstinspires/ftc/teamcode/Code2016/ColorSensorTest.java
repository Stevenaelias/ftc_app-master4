package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by stevenelias on 9/19/16.
 */
@Autonomous(name = "ColorSensorTest", group = "Autonomous")

public class ColorSensorTest extends OpMode {
    /* set variables */
    ColorSensor color;


    @Override
    public void init() {
        color = hardwareMap.colorSensor.get("color");
color.enableLed(false);
    }

    public void loop(){
        if (color.red() > color.blue() && color.red() > color.green()) {
            telemetry.addLine("red");
        }
        else if (color.blue() > color.red() && color.blue() > color.green()){
            telemetry.addLine("blue");
        }
    }
}