package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name ="Drive FowardNormal", group = "Beginner Auton")
public class AutonDriveFoward extends LinearOpMode {
    //Declare variables/ objects
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private Servo ArmServo;
    private DcMotor motorLinearLiftLeft;
    private DcMotor motorLinearLiftRight;

    private ElapsedTime runtime = new ElapsedTime();
    double x = 0.3;

    @Override
    public void runOpMode() throws InterruptedException {
        motorLeft = hardwareMap.dcMotor.get("MotorLeft");
        motorRight = hardwareMap.dcMotor.get("MotorRight");
        ArmServo = hardwareMap.get(Servo.class,"ArmServo");
        motorLinearLiftLeft = hardwareMap.get(DcMotor.class,"LinearLiftLeft");
        motorLinearLiftRight = hardwareMap.get(DcMotor.class,"LinearLiftRight");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        
        waitForStart();
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < x) {
            motorLinearLiftLeft.setPower(1);
            motorLinearLiftRight.setPower(-1);
        }

        while( opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 2)
        { driveForward(1);
        }
        x = x + 2;
        while( opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 0.3)
        {
            motorLeft.setPower(0);
            motorRight.setPower(0);
            motorLinearLiftLeft.setPower(-1);
            motorLinearLiftRight.setPower(1);
        }
        x = x + .3;
        while( opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 2){
            motorLeft.setPower(0.85);
            motorRight.setPower(1);
        }
        x = x + 2;
        while ( opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .3){
            motorLinearLiftLeft.setPower(1);
            motorLinearLiftRight.setPower(-1);
        }
        x = x + .3;
    }
        public void driveForward ( double power) {
            motorRight.setPower(-power);

            if (power - .1 <= 0) {
                motorLeft.setPower(-.15);
            } else{
                motorLeft.setPower(-(power-.15));
}
        }
    }