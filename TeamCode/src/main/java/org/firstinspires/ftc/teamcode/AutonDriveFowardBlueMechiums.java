package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name ="DriveFowardBlue2", group = "Beginner Auton")
public class AutonDriveFowardBlueMechiums extends LinearOpMode {
    //Declare variables/ objects
    private DcMotor MotorLeftFront;
    private DcMotor MotorRightFront;
    private DcMotor MotorLeftBack;
    private DcMotor MotorRightBack;
    private Servo ArmServo;
    private Servo ServoBack1;
    private Servo ServoBack2;
    //  private DcMotor motorLinearLiftLeft;
    // private DcMotor motorLinearLiftRight;
    private Servo CapstoneArm;

    private ElapsedTime runtime = new ElapsedTime();
    double x = 4;

    @Override
    public void runOpMode() throws InterruptedException {
        MotorLeftBack = hardwareMap.dcMotor.get("MotorLeftBack");
        MotorLeftFront = hardwareMap.dcMotor.get("MotorLeftFront");
        MotorRightBack = hardwareMap.dcMotor.get("MotorRightBack");
        MotorRightFront = hardwareMap.dcMotor.get("MotorRightFront");
        ArmServo = hardwareMap.get(Servo.class, "ArmServo");
        ServoBack1 = hardwareMap.get(Servo.class, "ServoBack1");
        ServoBack2 = hardwareMap.get(Servo.class, "ServoBack2");
        CapstoneArm = hardwareMap.get(Servo.class, "CapstoneArm");
        //  motorLinearLiftLeft = hardwareMap.get(DcMotor.class, "LinearLiftLeft");
        //   motorLinearLiftRight = hardwareMap.get(DcMotor.class, "LinearLiftRight");


        waitForStart();
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < x) {
            StrafeRight();
        }
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 3.5){
            Backward();
        }
        x=x+3;
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 4){
            ServoBack1.setPosition(1);
            ServoBack2.setPosition(0);
            stops();
        }
        x=x+4;
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 5){
            Foward();
        }
        x=x+5;
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 3.5){
            ServoBack1.setPosition(0);
            ServoBack2.setPosition(1);
            stops();
        }
        x=x+3.5;
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1){
            Foward();
        }
        x=x+1;
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1){
            stops();
        }
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 5){
            StrafeLeft();
        }
        stops();


    }
    public void StrafeLeft()
    {
        MotorRightBack.setPower(.15);
        MotorLeftBack.setPower(.15);
        MotorLeftFront.setPower(-.15);
        MotorRightFront.setPower(-.15);
    }
    public void StrafeRight()
    {
        MotorRightBack.setPower(-.15);
        MotorLeftBack.setPower(-.15);
        MotorLeftFront.setPower(.15);
        MotorRightFront.setPower(.15);

    }
    public void Foward()
    {
        MotorRightBack.setPower(-.3);
        MotorLeftBack.setPower(.3);
        MotorLeftFront.setPower(.3);
        MotorRightFront.setPower(-.3);
    }
    public void Backward(){
        MotorRightBack.setPower(.3);
        MotorLeftBack.setPower(-.3);
        MotorLeftFront.setPower(-.3);
        MotorRightFront.setPower(.3);
    }
    public void stops(){
        MotorLeftFront.setPower(0);
        MotorRightBack.setPower(0);
        MotorLeftBack.setPower(0);
        MotorRightFront.setPower(0);
    }
}

