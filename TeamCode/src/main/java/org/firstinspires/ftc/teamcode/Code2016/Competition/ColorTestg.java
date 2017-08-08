package org.firstinspires.ftc.teamcode.Code2016.Competition;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by stevenelias on 12/5/16.
 */
@Autonomous(name = "colorTest", group = "Autonomous")
public class ColorTestg extends OpMode {




    ColorSensor color;



    @Override
    public void init() {



        color = hardwareMap.colorSensor.get("color");
     }



        @Override
        public void loop() {
            telemetry.addData("blue", color.blue());
            telemetry.update();
            telemetry.addData("red", color.red());
            telemetry.update();


        }
    }







