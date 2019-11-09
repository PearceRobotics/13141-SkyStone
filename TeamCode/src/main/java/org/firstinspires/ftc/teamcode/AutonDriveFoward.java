package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name ="Drive FowardBlue", group = "Beginner Auton")
public class AutonDriveFoward extends LinearOpMode {
    //Declare variables/ objects
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private Servo ArmServo;
    private DcMotor motorLinearLiftLeft;
    private DcMotor motorLinearLiftRight;

    private ElapsedTime runtime = new ElapsedTime();
    double x = 5;

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
        ResetEncode();


                while (motorLeft.getCurrentPosition() > -1650) {
                    telemetry.addData("MotorLeftPos", motorLeft.getCurrentPosition());
                    telemetry.addData("MotorRightPos", motorRight.getCurrentPosition());
                    telemetry.update();
                    double error = motorLeft.getCurrentPosition() - motorRight.getCurrentPosition();
                    double modifier = error * .2;
                    ArcadeDrive(.5,modifier);
                }

                ArcadeDrive(0, 0);
                ArmServo.setPosition(1);
                sleep(2500);
                ResetEncode();
                //go backwards
                /*while (motorLeft.getCurrentPosition() < 1500) {
                    double error = motorLeft.getCurrentPosition() - motorRight.getCurrentPosition();
                    double modifier = error * .2;
                    ArcadeDrive(-.01,modifier);
                }
                ResetEncode();*/
                x = runtime.seconds();
                while (x+8  > runtime.seconds()) {
                    motorLeft.setPower(.3);
                    motorRight.setPower(.15);
                }//stop
                ArcadeDrive(0, 0);
                sleep(500);
                //arm up
                ArmServo.setPosition(0);
                sleep(1000);
                ResetEncode();


                /*while(motorLeft.getCurrentPosition()<250) {
                    double error = motorLeft.getCurrentPosition() - motorRight.getCurrentPosition();
                    double modifier = error * .2;
                    ArcadeDrive(-1, modifier);
                }*/
                //ResetEncode();
                //turn
               /* motorLeft.setTargetPosition(-1500);
                motorRight.setTargetPosition(1500);
                motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                while(motorLeft.isBusy())
                {
                //do nothing
                }
*/
       /* while (opModeIsActive() && runtime.seconds() < x) {
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
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .4) {
            motorLeft.setPower(-.85);
            motorRight.setPower(1);
        }
        x = x + .4;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .75) {
            driveForward(1);
        }
        x = x + .75;
        while (opModeIsActive() && runtime.seconds() > x && runtime.seconds() < x + .4) {
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
        */
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