//
// Created by Shruti Joshi on 1/11/23.
//

#ifndef TEAMCODE_AUTONOMOUSTESTING_H
#define TEAMCODE_AUTONOMOUSTESTING_H



class AutonomousTesting {



/*public class MyFIRSTJavaOpMode extends LinearOpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor crane;
    Servo claw;
    BNO055IMU imu;

    @Override
    public void runOpMode() {
      motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
      motorRight = hardwareMap.get(DcMotor.class, "motorRight");
      crane = hardwareMap.get(DcMotor.class, "crane");
      claw = hardwareMap.get(Servo.class, "claw");
      imu = hardwareMap.get(BNO055IMU.class, "imu");
      // Put initialization blocks here
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      claw.setPosition(0.5);
      waitForStart();
      // Put run blocks here

      //move to cone and grab it
      motorLeft.setPower(0.25);
      motorRight.setPower(0.25);
      sleep(500);
      motorLeft.setPower(0);
      motorRight.setPower(0);
      claw.setPosition(0);
      //back out after getting cone
      motorLeft.setPower(-0.25);
      motorRight.setPower(-0.25);
      sleep(500);
      //turn to junction
      motorLeft.setPower(0.25);
      motorRight.setPower(-0.25);
      sleep(400);
      motorLeft.setPower(0);
      motorRight.setPower(0);
      motorLeft.setPower(0.25);
      motorRight.setPower(0.25);
      //drop cone
      sleep(245);
      motorLeft.setPower(0);
      motorRight.setPower(0);
      claw.setPosition(0.5);
      //back out
      motorLeft.setPower(-0.25);
      motorRight.setPower(-0.25);
      sleep(250);
      //turn out
      motorLeft.setPower(-0.25);
      motorRight.setPower(0.25);
      sleep(300);
      claw.setPosition(0);
      motorLeft.setPower(0);
      motorRight.setPower(0);
      // turning to adjust robot position
      motorLeft.setPower(0);
      motorRight.setPower(0.25);
      sleep(300);
      //moves ahead
      motorLeft.setPower(0.5);
      motorRight.setPower(0.5);
      sleep(575);
      //turns
      motorLeft.setPower(0.5);
      motorRight.setPower(-0.5);
      sleep(370);
      //forward and open clas
      motorLeft.setPower(0.25);
      motorRight.setPower(0.25);
      claw.setPosition(0.5);
      sleep(575);//575
      //grab the cone and back out

      motorLeft.setPower(0);
      motorRight.setPower(0);
      claw.setPosition(0);
      motorLeft.setPower(0.05);
      motorRight.setPower(0.05);
        //   sleep(100);
        //   claw.setPosition(0.5);
        //   claw.setPosition(0);

        //   motorLeft.setPower(-0.25);
        //   motorRight.setPower(-0.25);
        //   sleep(580);
      //turn around to get to terminal
      motorLeft.setPower(0.5);
      motorRight.setPower(-0.5);
      sleep(425);
      motorLeft.setPower(0.5);
      motorRight.setPower(0.5);
      sleep (550);

      //turn to terminal
      motorLeft.setPower(0);
      motorRight.setPower(0.5);
      sleep(550);

      //stop at terminal
      motorLeft.setPower(0);
      motorRight.setPower(0);



      //next steps:
      //problem is that it cant pick up cone from the stack so figure out how to
      //do that
    }
 */
}







};



#endif //TEAMCODE_AUTONOMOUSTESTING_H
