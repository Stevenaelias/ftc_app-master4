package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;

/**
 * Created by stevenelias on 9/19/16.
 */
public class ColorSensorTest2 extends LinearOpMode {
    //define variables
    DeviceInterfaceModule CDI;
    ColorSensor color;


    @Override
    public void runOpMode() throws InterruptedException {
        //find devices
        color = hardwareMap.colorSensor.get("color");
        CDI = hardwareMap.deviceInterfaceModule.get("CDI");

        color.enableLed(true);

//wait for the start button to be pressed
        waitForStart();

//if the red color value is greater than both the blue and green color values, turn on LED 1.

        while (opModeIsActive()) {
            if (color.red() > color.blue() && color.red() > color.green()) {
                CDI.setLED(1, true);
                CDI.setLED(0, false);

            }
        /*if the above isn't true, then if the blue color value is greater than both the
        red and green color values, turn on LED 0.
         */
            else if (color.blue() > color.red() && color.blue() > color.green()) {
                CDI.setLED(1, false);
                CDI.setLED(0, true);
            }
            //if none of the above are true, turn off both LEDs 1 and 0.
            else {
                CDI.setLED(1, false);
                CDI.setLED(0, false);

            }

        }
    }
}
