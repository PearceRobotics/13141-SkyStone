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
    double x = 1;

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
            ArmServo.setPosition(1);
        }

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