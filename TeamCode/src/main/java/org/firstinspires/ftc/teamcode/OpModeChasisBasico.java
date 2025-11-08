package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.json.JSONArray;

@TeleOp(name="Chasis Prueba 1", group="RobotInicial")
public class OpModeChasisBasico extends LinearOpMode {

    //Declarar variables//
    private ElapsedTime runtime = new ElapsedTime();
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
            double max;


            double axial   = -gamepad1.left_stick_y;
            double lateral =  gamepad1.left_stick_x;
            double yaw     =  gamepad1.right_stick_x;

            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            double frontLeftPower  = axial + lateral + yaw;
            double frontRightPower = axial - lateral - yaw;
            double backLeftPower   = axial - lateral + yaw;
            double backRightPower  = axial + lateral - yaw;

            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
            max = Math.max(max, Math.abs(backLeftPower));
            max = Math.max(max, Math.abs(backRightPower));

            if (max > 1.0) {
                frontLeftPower  /= max;
                frontRightPower /= max;
                backLeftPower   /= max;
                backRightPower  /= max;
            }

            // Send calculated power to wheels
            motorfrontleft.setPower(frontLeftPower);
            motorfrontright.setPower(frontRightPower);
            motorbackleft.setPower(backLeftPower);
            motorbackright.setPower(backRightPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Front left/Right", "%4.2f, %4.2f", frontLeftPower, frontRightPower);
            telemetry.addData("Back  left/Right", "%4.2f, %4.2f", backLeftPower, backRightPower);
            telemetry.update();
            //Chamba del robot//
            //float valorPalancaIzquierda = gamepad1.left_stick_y;//

        }
    }
}


