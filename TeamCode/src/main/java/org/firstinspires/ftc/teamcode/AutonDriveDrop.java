package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name ="DriveDrop", group = "Beginner Auton")
public class AutonDriveDrop extends LinearOpMode {
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
    double x = .3 ;

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
            Foward();
        }
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1.4) {
        StrafeLeft();
        }
        x=x+1.4;
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 3){
            MotorLeftBack.setPower(0);
            MotorLeftFront.setPower(0);
            MotorRightBack.setPower(0);
            MotorRightFront.setPower(0);
        }
        x=x+3;
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 3){
            {
                ArmServo.setPosition(1);
            }
            x=x+3;
        }



    }
    public void StrafeLeft()
    {
        MotorRightBack.setPower(.80);
        MotorLeftBack.setPower(.70);
        MotorLeftFront.setPower(-.70);
        MotorRightFront.setPower(-.80);
    }
    public void StrafeRight()
    {
        MotorRightBack.setPower(-.20);
        MotorLeftBack.setPower(-.10);
        MotorLeftFront.setPower(.10);
        MotorRightFront.setPower(.20);

    }
    public void Foward()
    {
        MotorRightBack.setPower(-.9);
        MotorLeftBack.setPower(1);
        MotorLeftFront.setPower(1);
        MotorRightFront.setPower(-.9);
    }
    public void Backward(){
        MotorRightBack.setPower(.30);
        MotorLeftBack.setPower(-.25);
        MotorLeftFront.setPower(-.25);
        MotorRightFront.setPower(.30);
    }
    public void stops(){
        MotorLeftFront.setPower(0);
        MotorRightBack.setPower(0);
        MotorLeftBack.setPower(0);
        MotorRightFront.setPower(0);
    }
}


