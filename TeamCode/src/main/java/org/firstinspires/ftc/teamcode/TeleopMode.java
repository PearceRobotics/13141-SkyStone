package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "Teleop", group = "Teleop" )
public class TeleopMode extends OpMode
{
    //Declare motors and stuff

    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor motorLinearLiftLeft;
    private DcMotor motorLinearLiftRight;
    private Servo ArmServo;
    @Override
    public void init(){
        motorLeft = hardwareMap.get(DcMotor.class,"MotorLeft");
        motorRight = hardwareMap.get(DcMotor.class,"MotorRight");
        motorLinearLiftLeft = hardwareMap.get(DcMotor.class,"LinearLiftLeft");
        motorLinearLiftRight = hardwareMap.get(DcMotor.class,"LinearLiftRight");
        ArmServo = hardwareMap.get(Servo.class,"ArmServo");
    }
    @Override
    public void loop() {
        motorLeft.setPower(-gamepad1.left_stick_y);
        motorRight.setPower(gamepad1.right_stick_y);
        if(gamepad1.left_bumper) {
            motorLinearLiftLeft.setPower(1);
            motorLinearLiftRight.setPower(-1);
        }
        else if(gamepad1.right_bumper) {
            motorLinearLiftLeft.setPower(-1);
            motorLinearLiftRight.setPower(1);
        }
        else {
            motorLinearLiftRight.setPower(0);
            motorLinearLiftLeft.setPower(0);
        }
        if(gamepad1.x){
            ArmServo.setPosition(1);
            telemetry.addData("working", 1);
        }
        else if(gamepad1.y){
            ArmServo.setPosition(0);
            telemetry.addData("working", 1);
        }
    }
}



//