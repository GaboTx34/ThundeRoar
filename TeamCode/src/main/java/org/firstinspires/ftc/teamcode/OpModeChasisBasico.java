package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Chasis Prueba 1", group="RobotInicial")
public class OpModeChasisBasico extends LinearOpMode {

    //Declarar variables//
    DcMotor motorfrontleft;
    DcMotor motorfrontright;
    DcMotor motorbackleft;
    DcMotor motorbackright;



    @Override
    public void runOpMode() {
        motorfrontleft = hardwareMap.dcMotor.get("mfl");
        motorfrontright = hardwareMap.dcMotor.get("mfr");
        motorbackleft = hardwareMap.dcMotor.get("mbl");
        motorbackright = hardwareMap.dcMotor.get("mbr");

        motorfrontleft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorfrontright.setDirection(DcMotorSimple.Direction.FORWARD);
        motorbackleft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorbackright.setDirection(DcMotorSimple.Direction.FORWARD);

        motorfrontleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorfrontright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbackleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbackright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        while (opModeIsActive()){

            //Chamba del robot//
            float valorPalancaIzquierda = gamepad1.left_stick_y;

        }

    }
}
