package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name ="Drive Foward", group = "Beginner Auton")
public class AutonDriveFoward extends LinearOpMode {
    //Declare variables/ objects
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private Servo ArmServo;
    private ElapsedTime runtime = new ElapsedTime();
    double x = 4.0;

    @Override
    public void runOpMode() throws InterruptedException {
        motorLeft = hardwareMap.dcMotor.get("MotorLeft");
        motorRight = hardwareMap.dcMotor.get("MotorRight");
        ArmServo = hardwareMap.get(Servo.class,"ArmServo");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        
        waitForStart();
        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < x) {
            driveForward(1.0);
        }
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() <   x + 0.7) {
            driveForward(0.0);
            motorRight.setPower(1);
            motorLeft.setPower(-.9);
        }
        x = x + 0.7;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1.0)
        {
            driveForward(1.0);
        }
        x = x + 1;
        while (opModeIsActive() && runtime.seconds() > x  && runtime.seconds() < x + 0.1) {
            driveForward(0.0);
            ArmServo.setPosition(1);
        }
        x = x + 0.1;
        while( opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1.8) {
            driveForward(-1.0);
        }
        x = x + 1.8;
        while( opModeIsActive() && runtime.seconds() > x && runtime.seconds()< x + 0.1) {
        ArmServo.setPosition(0);
        }

    }
        public void driveForward ( double power) {
            motorRight.setPower(-power);

            if (power - .1 <= 0) {
                motorLeft.setPower(-.1);
            } else{
                motorLeft.setPower(-(power-.1));
}
        }
    }