package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TeleopMechiums", group = "Teleop" )
public class TeleopModeMechiums extends OpMode
{
    //Declare motors and stuff

    private DcMotor MotorLeftBack;
    private DcMotor MotorRightBack;
    private DcMotor MotorLeftFront;
    private DcMotor MotorRightFront;
    private DcMotor motorLinearLiftLeft;
    private DcMotor motorLinearLiftRight;
    private Servo ArmServo;
    private Servo ServoBack1;
    private Servo ServoBack2;
    private Servo CapstoneArm;
    @Override
    public void init(){
        MotorLeftFront = hardwareMap.get(DcMotor.class,"MotorLeftFront");
        MotorRightFront = hardwareMap.get(DcMotor.class,"MotorRightFront");
        MotorLeftBack = hardwareMap.get(DcMotor.class, "MotorLeftBack");
        MotorRightBack = hardwareMap.get(DcMotor.class, "MotorRightBack");
        motorLinearLiftLeft = hardwareMap.get(DcMotor.class,"LinearLiftLeft");
        motorLinearLiftRight = hardwareMap.get(DcMotor.class,"LinearLiftRight");
        ArmServo = hardwareMap.get(Servo.class,"ArmServo");
       ServoBack1 = hardwareMap.get(Servo.class,"ServoBack1");
       ServoBack2 = hardwareMap.get(Servo.class,"ServoBack2");
       CapstoneArm = hardwareMap.get(Servo.class,"CapstoneArm");
    }
    @Override
    public void loop() {
        MotorLeftBack.setPower(-gamepad1.left_stick_y);
        MotorLeftFront.setPower(-gamepad1.left_stick_y);
        MotorRightBack.setPower(gamepad1.left_stick_y);
        MotorRightFront.setPower(gamepad1.left_stick_y);

        MotorLeftBack.setPower(gamepad1.right_stick_x);
        MotorLeftFront.setPower(gamepad1.right_stick_x);
        MotorRightBack.setPower(gamepad1.right_stick_x);
        MotorRightFront.setPower(gamepad1.right_stick_x);

        if(gamepad1.left_bumper) {
            motorLinearLiftLeft.setPower(1);
            motorLinearLiftRight.setPower(-1);
        }
        else if(gamepad1.right_bumper) {
            //motorLinearLiftLeft.setPower(-1);
            //motorLinearLiftRight.setPower(1);
        }
        else if(gamepad1.right_trigger > 0.1){
                MotorRightBack.setPower(-.8);
                MotorLeftBack.setPower(-1);
                MotorLeftFront.setPower(1);
                MotorRightFront.setPower(.8);
            }
            else if(gamepad1.left_trigger > 0.1) {
                MotorRightBack.setPower(.8);
                MotorLeftBack.setPower(1);
                MotorLeftFront.setPower(-1);
                MotorRightFront.setPower(-.8);
            }
            else {
           // motorLinearLiftRight.setPower(0);
           // motorLinearLiftLeft.setPower(0);
        }
        if(gamepad1.x){
            ArmServo.setPosition(1);
            telemetry.addData("working", 1);
        }
        else if(gamepad1.y){
            ArmServo.setPosition(0);
            telemetry.addData("working", 1);
        }
        if(gamepad1.a) {
            ServoBack1.setPosition(1);
           ServoBack2.setPosition(0);
        }
        if(gamepad1.b){
           ServoBack1.setPosition(0);
            ServoBack2.setPosition(1);
        }
        if(gamepad1.dpad_down)
        {
            CapstoneArm.setPosition(1);
        }
        if (gamepad1.dpad_up){
            CapstoneArm.setPosition(0);
        }

    }
}



//