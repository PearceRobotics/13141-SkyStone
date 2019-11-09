package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name ="DriveFowardBlue2", group = "Beginner Auton")
public class AutonDriveFowardBlueSeconds extends LinearOpMode {
    //Declare variables/ objects
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private Servo ArmServo;
    private DcMotor motorLinearLiftLeft;
    private DcMotor motorLinearLiftRight;

    private ElapsedTime runtime = new ElapsedTime();
    double x = .8;

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

        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .8) {
            driveForward(1);
        }
        x = x + .8;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 3) {
            motorLeft.setPower(0);
            motorRight.setPower(0);
            ArmServo.setPosition(1);
        }
        x = x + 3;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 3) {
            motorLeft.setPower(0.3);
            motorRight.setPower(.30);
        }
        x = x + 3;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1) {
            ArmServo.setPosition(0);
            motorRight.setPower(0);
            motorLeft.setPower(0);
        }
        x = x + 1;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .2) {
            motorLeft.setPower(.3);
            motorRight.setPower(.3);

            }
        x=x+.2;
            while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .4) {
            motorLeft.setPower(-.85);
            motorRight.setPower(1);
        }
        x = x + .4;        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .5) {
            driveForward(1);
        }
        x = x + .5;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .45) {
            motorLeft.setPower(.85);
            motorRight.setPower(-1);
        }
        x = x + .4;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + 1.3) {
            driveForward(1);
        }
        x = x + 1.3;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .4) {
            motorRight.setPower(-1);
            motorLeft.setPower(.85);
        }
        x = x + .4;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .5) {
            driveForward(1);
        }
        x = x + .5;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .4) {
            motorLeft.setPower(.85);
            motorRight.setPower(-1);
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
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .3) {
            motorLeft.setPower(.85);
            motorRight.setPower(-1);
        }
        x=x+.3;
        while(opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .8) {
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
        public void ArcadeDrive (double forward,double turnMod){
        motorLeft.setPower(-(forward - turnMod));
        motorRight.setPower(forward + turnMod);
        telemetry.addData("Forward",forward);
        telemetry.addData("TurnMod",turnMod);
        telemetry.update();
        }
        public void ResetEncode(){
            motorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }