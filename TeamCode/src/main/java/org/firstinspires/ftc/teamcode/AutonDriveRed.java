package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name ="Drive FowardRed", group = "Beginner Auton")
public class AutonDriveRed extends LinearOpMode {
    //Declare variables/ objects
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private Servo ArmServo;
    private DcMotor motorLinearLiftLeft;
    private DcMotor motorLinearLiftRight;

    private ElapsedTime runtime = new ElapsedTime();
    double x = 0.8;

    @Override
    public void runOpMode() throws InterruptedException {
        motorLeft = hardwareMap.dcMotor.get("MotorLeft");
        motorRight = hardwareMap.dcMotor.get("MotorRight");
        ArmServo = hardwareMap.get(Servo.class, "ArmServo");
        motorLinearLiftLeft = hardwareMap.get(DcMotor.class, "LinearLiftLeft");
        motorLinearLiftRight = hardwareMap.get(DcMotor.class, "LinearLiftRight");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < x) {
            ArmServo.setPosition(0);
        }

        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1) {
            driveForward(1);
        }
        x = x + 1;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 0.7) {
            motorLeft.setPower(0);
            motorRight.setPower(0);
            ArmServo.setPosition(1);
        }
        x = x + .7;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .9) {
            motorLeft.setPower(0.85);
            motorRight.setPower(1);
        }
        x = x + .9;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .3) {
            ArmServo.setPosition(0);
            motorRight.setPower(0);
            motorLeft.setPower(0);
        }
        x = x + .3;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .43) {
            motorLeft.setPower(.85);
            motorRight.setPower(-1);
        }
        x = x + .4;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .75) {
            driveForward(1);
        }
        x = x + .75;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .55) {
            motorLeft.setPower(-.85);
            motorRight.setPower(1);
        }
        x = x + .4;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1.3) {
            driveForward(1);
        }
        x = x + 1.3;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .43) {
            motorRight.setPower(1);
            motorLeft.setPower(-.85);
        }
        x = x + .4;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .5) {
            driveForward(1);
        }
        x = x + .5;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .43) {
            motorLeft.setPower(-.85);
            motorRight.setPower(1);
        }
        x = x + .4;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1.3) {
            driveForward(1);
        }
        x = x + 1.3;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .5) {
            motorRight.setPower(1);
            motorLeft.setPower(1);
        }
        x = x + .5;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .5) {
            motorLeft.setPower(-.85);
            motorRight.setPower(1);
        }
        x=x+.3;
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1) {
        driveForward(1);
        }
        x=x+.8;
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