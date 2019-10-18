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
    private ElapsedTime runtime = new ElapsedTime();
    double x = 2.0;

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
        while( opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .5) {
            motorRight.setPower(1);
            motorLeft.setPower(-.9);
        }

        x = x + .5;
        while( opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 2)
        { driveForward(1);
        }
        x = x + 2;
        while( opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1)
        {
            driveForward(0);
            ArmServo.setPosition(1);
        }
        x = x + 1;
        while( opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 2){
            motorLeft.setPower(-0.9);
            motorRight.setPower(-1);
        }
        x = x + 2;
        while ( opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1){
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