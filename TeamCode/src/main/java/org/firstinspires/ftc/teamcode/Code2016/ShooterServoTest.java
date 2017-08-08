package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
//hellos
/**
 * Created by stevenelias on 10/23/16.
 */
@TeleOp(name = "ShooterServoTest", group = "TeleOp")
@Disabled
public class ShooterServoTest extends OpMode {
    Servo servo;
    @Override
    public void init() {
        servo= hardwareMap.servo.get("servo");
        servo.setPosition(0.0);


    }

    @Override
    public void loop() {
        if(gamepad1.a){
            servo.setPosition(1.0);
        }
        else if(gamepad1.b){
            servo.setPosition(0.0);
        }

    }
}
