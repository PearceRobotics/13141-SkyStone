package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Teleop", group = "Teleop" )
public class TeleopMode extends OpMode
{
    //Declare motors and stuff

    private DcMotor motorLeft;
    private DcMotor motorRight;
    private DcMotor motorLinearLiftLeft;
    private DcMotor motorLinearLiftRight;
    @Override
    public void init(){
        motorLeft = hardwareMap.get(DcMotor.class,"MotorLeft");
        motorRight = hardwareMap.get(DcMotor.class,"MotorRight");
        motorLinearLiftLeft = hardwareMap.get(DcMotor.class,"LinearLiftLeft");
        motorLinearLiftRight = hardwareMap.get(DcMotor.class,"LinearLiftRight");
    }
    @Override
    public void loop() {
        motorLeft.setPower(gamepad1.left_stick_y);
        motorRight.setPower(-gamepad1.right_stick_y);
        if(gamepad1.left_bumper) {//up
            motorLinearLiftLeft.setPower(1);
            motorLinearLiftRight.setPower(-1);
        }
        else if(gamepad1.right_bumper) {//down
            motorLinearLiftLeft.setPower(-1);
            motorLinearLiftRight.setPower(1);
        }
        else {
            motorLinearLiftRight.setPower(0);
            motorLinearLiftLeft.setPower(0);
        }
    }
}
