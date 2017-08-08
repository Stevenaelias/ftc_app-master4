package org.firstinspires.ftc.teamcode.Code2016;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stevenelias on 10/20/16.
 */
@Autonomous(name = "StateMachineTest", group = "Autonomous")
@Disabled

public class StateTest extends OpMode {
    DcMotor rightfrontdrive;
    DcMotor rightbackdrive;
    DcMotor leftfrontdrive;
    DcMotor leftbackdrive;

    Servo buttonright;
    Servo buttonleft;

    ColorSensor color;

    boolean correctColor;

    private enum State{
        StateForward1,
        StateTurn1,
        StateForward2,
        StateTurn2,
        StateForward3,
        StateTurn3,
        ApproachBeacon,
        GetColor,
        GetSpace,
        MoveServo,
        PushBeacon,
        BackUp,
    }

     State currentState;


    @Override
    public void init() {
        rightfrontdrive = hardwareMap.dcMotor.get("rightfrontdrive");
        rightbackdrive = hardwareMap.dcMotor.get("rightbackdrive");
        leftfrontdrive = hardwareMap.dcMotor.get("leftfrontdrive");
        leftbackdrive = hardwareMap.dcMotor.get("leftbackdrive");

        buttonleft = hardwareMap.servo.get("buttonleft");
        buttonright = hardwareMap.servo.get("buttonright");

        color = hardwareMap.colorSensor.get("color");

        rightbackdrive.setDirection(DcMotor.Direction.REVERSE);
        rightfrontdrive.setDirection(DcMotor.Direction.REVERSE);

        rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        buttonright.setPosition(0.0);
        buttonleft.setPosition(1.0);

    }

    @Override
    public void loop() {


        switch (currentState) {

            case StateForward1:
                rightfrontdrive.setTargetPosition(2673);
                rightbackdrive.setTargetPosition(2673);
                leftfrontdrive.setTargetPosition(2673);
                leftbackdrive.setTargetPosition(2673);

                rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                rightfrontdrive.setPower(1.0);
                rightbackdrive.setPower(1.0);
                leftbackdrive.setPower(1.0);
                leftfrontdrive.setPower(1.0);

                while (rightfrontdrive.getCurrentPosition()<2673){
                    rightfrontdrive.setPower(1.0);
                    rightbackdrive.setPower(1.0);
                    leftbackdrive.setPower(1.0);
                    leftfrontdrive.setPower(1.0);
                }
                if (rightfrontdrive.getCurrentPosition()>=2673) {
                    rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    currentState = State.StateTurn1;
                }


                break;

            case StateTurn1:

                rightfrontdrive.setTargetPosition(-1680);
                rightbackdrive.setTargetPosition(-1680);
                leftfrontdrive.setTargetPosition(1680);
                leftbackdrive.setTargetPosition(1680);

                rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                rightfrontdrive.setPower(-1.0);
                rightbackdrive.setPower(-1.0);
                leftbackdrive.setPower(1.0);
                leftfrontdrive.setPower(1.0);

                while (rightbackdrive.getCurrentPosition()>-1680 && leftbackdrive.getCurrentPosition()<1680){
                    rightfrontdrive.setPower(-1.0);
                    rightbackdrive.setPower(-1.0);
                    leftbackdrive.setPower(1.0);
                    leftfrontdrive.setPower(1.0);
                }
                if (rightbackdrive.getCurrentPosition()<=-1680 && leftbackdrive.getCurrentPosition()==1680){
                    rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    currentState = State.StateForward2;
                }
                break;

            case StateForward2:
                rightfrontdrive.setTargetPosition(2105);
                rightbackdrive.setTargetPosition(2105);
                leftfrontdrive.setTargetPosition(2105);
                leftbackdrive.setTargetPosition(2105);

                rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                rightfrontdrive.setPower(1.0);
                rightbackdrive.setPower(1.0);
                leftbackdrive.setPower(1.0);
                leftfrontdrive.setPower(1.0);

                while (rightbackdrive.getCurrentPosition()<2105){
                    rightfrontdrive.setPower(1.0);
                    rightbackdrive.setPower(1.0);
                    leftbackdrive.setPower(1.0);
                    leftfrontdrive.setPower(1.0);
                }
                if (rightbackdrive.getCurrentPosition()>=2105){
                    rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    currentState = State.StateTurn2;
                }
                break;

            case StateTurn2:
                rightfrontdrive.setTargetPosition(1680);
                rightbackdrive.setTargetPosition(1680);
                leftfrontdrive.setTargetPosition(-1680);
                leftbackdrive.setTargetPosition(-1680);

                rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                rightfrontdrive.setPower(1.0);
                rightbackdrive.setPower(1.0);
                leftbackdrive.setPower(-1.0);
                leftfrontdrive.setPower(-1.0);

                while (rightbackdrive.getCurrentPosition()<1680 && leftbackdrive.getCurrentPosition()>-1680){
                    rightfrontdrive.setPower(1.0);
                    rightbackdrive.setPower(1.0);
                    leftbackdrive.setPower(-1.0);
                    leftfrontdrive.setPower(-1.0);
                }
                if (rightbackdrive.getCurrentPosition()>=1680 && leftbackdrive.getCurrentPosition()<=-1680){
                    rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    currentState = State.StateForward3;
                }
                break;

            case StateForward3:
                rightfrontdrive.setTargetPosition(178);
                rightbackdrive.setTargetPosition(178);
                leftfrontdrive.setTargetPosition(178);
                leftbackdrive.setTargetPosition(178);

                rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                rightfrontdrive.setPower(1.0);
                rightbackdrive.setPower(1.0);
                leftbackdrive.setPower(1.0);
                leftfrontdrive.setPower(1.0);

                while (rightbackdrive.getCurrentPosition()<178){
                    rightfrontdrive.setPower(1.0);
                    rightbackdrive.setPower(1.0);
                    leftbackdrive.setPower(1.0);
                    leftfrontdrive.setPower(1.0);
                }
                if (rightbackdrive.getCurrentPosition()>=178){
                    rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    currentState = State.StateTurn3;
                }
                break;
            case StateTurn3:
                //WATCH FOR THIS ONE!!!!!!

                rightfrontdrive.setTargetPosition(0);
                rightbackdrive.setTargetPosition(0);
                leftfrontdrive.setTargetPosition(1680);
                leftbackdrive.setTargetPosition(1680);

                rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                rightfrontdrive.setPower(0.0);
                rightbackdrive.setPower(0.0);
                leftbackdrive.setPower(1.0);
                leftfrontdrive.setPower(1.0);

                while (leftbackdrive.getCurrentPosition() <1680){
                    rightfrontdrive.setPower(0.0);
                    rightbackdrive.setPower(0.0);
                    leftbackdrive.setPower(1.0);
                    leftfrontdrive.setPower(1.0);
                }
                if (leftbackdrive.getCurrentPosition()>=1680){
                    rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    currentState= State.ApproachBeacon;
                }
                break;

            case ApproachBeacon:
                rightfrontdrive.setTargetPosition(1069);
                rightbackdrive.setTargetPosition(1069);
                leftfrontdrive.setTargetPosition(1069);
                leftbackdrive.setTargetPosition(1069);

                rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                rightfrontdrive.setPower(1.0);
                rightbackdrive.setPower(1.0);
                leftbackdrive.setPower(1.0);
                leftfrontdrive.setPower(1.0);

                while (rightbackdrive.getCurrentPosition()<1069){
                    rightfrontdrive.setPower(1.0);
                    rightbackdrive.setPower(1.0);
                    leftbackdrive.setPower(1.0);
                    leftfrontdrive.setPower(1.0);
                }
                if (rightbackdrive.getCurrentPosition()>=1069){
                    rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    currentState= State.GetColor;
                }
                break;

            case GetColor:
                if (color.blue() > color.green() && color.blue() > color.red()) {
                    correctColor = true;
                    currentState= State.GetSpace;

                }
                else if (color.red() > color.blue() && color.red() > color.green()) {
                    correctColor = false;
                    currentState= State.GetSpace;
                }
                break;

            case GetSpace:
                rightfrontdrive.setTargetPosition(-351);
                rightbackdrive.setTargetPosition(-351);
                leftfrontdrive.setTargetPosition(-351);
                leftbackdrive.setTargetPosition(-351);

                rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                rightfrontdrive.setPower(-1.0);
                rightbackdrive.setPower(-1.0);
                leftbackdrive.setPower(-1.0);
                leftfrontdrive.setPower(-1.0);

                while (rightbackdrive.getCurrentPosition()>-351){
                    rightfrontdrive.setPower(-1.0);
                    rightbackdrive.setPower(-1.0);
                    leftbackdrive.setPower(-1.0);
                    leftfrontdrive.setPower(-1.0);
                }
                if (rightbackdrive.getCurrentPosition()<=-351){
                    rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    currentState= State.MoveServo;
                }
                break;

            case MoveServo:
                if (correctColor) {
                    buttonright.setPosition(0.5);
                    currentState= State.PushBeacon;

                }
                else if (!correctColor) {
                    buttonleft.setPosition(0.5);
                    currentState= State.PushBeacon;

                }
                break;

            case PushBeacon:
                rightfrontdrive.setTargetPosition(351);
                rightbackdrive.setTargetPosition(351);
                leftfrontdrive.setTargetPosition(351);
                leftbackdrive.setTargetPosition(351);

                rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                rightfrontdrive.setPower(1.0);
                rightbackdrive.setPower(1.0);
                leftbackdrive.setPower(1.0);
                leftfrontdrive.setPower(1.0);

                while (rightbackdrive.getCurrentPosition()<351){
                    rightfrontdrive.setPower(1.0);
                    rightbackdrive.setPower(1.0);
                    leftbackdrive.setPower(1.0);
                    leftfrontdrive.setPower(1.0);
                }
                if (rightfrontdrive.getCurrentPosition()>=351){
                    rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    currentState= State.BackUp;
                }
                break;

            case BackUp:
                rightfrontdrive.setTargetPosition(-445);
                rightbackdrive.setTargetPosition(-445);
                leftfrontdrive.setTargetPosition(-445);
                leftbackdrive.setTargetPosition(-445);

                rightfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                rightbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftfrontdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                leftbackdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                rightfrontdrive.setPower(-1.0);
                rightbackdrive.setPower(-1.0);
                leftbackdrive.setPower(-1.0);
                leftfrontdrive.setPower(-1.0);

                while (rightfrontdrive.getCurrentPosition()>-445){
                    rightfrontdrive.setPower(-1.0);
                    rightbackdrive.setPower(-1.0);
                    leftbackdrive.setPower(-1.0);
                    leftfrontdrive.setPower(-1.0);
                }
                if (rightfrontdrive.getCurrentPosition()<=-445){
                    rightbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftfrontdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftbackdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    buttonleft.setPosition(1.0);
                    buttonright.setPosition(0.0);
                } break;











        }



    }
}
