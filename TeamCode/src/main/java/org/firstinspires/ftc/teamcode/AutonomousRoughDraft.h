//
// Created by Navnee Raval on 1/11/23.
//

#ifndef FTCROBOTCONTROLLER_WIP_22_23_AUTONOMOUSROUGHDRAFT_H
#define FTCROBOTCONTROLLER_WIP_22_23_AUTONOMOUSROUGHDRAFT_H



class AutonomousRoughDraft {

    DcMotor leftWheel;
    DcMotor rightWheel;

   public void runOpmode() {
       leftWheel = hardwareMap.dcMotor.get("left_wheel");
       rightWheel = hardwareMap.dcMotor.get("right_wheel");
       leftWheel.setDirection(DcMotor.Direction.REVERSE);

       waitForStart();

       leftWheel.setPower(1);
       rightWheel.setPower(1);

       sleep(1000);

       leftWheel.setPower(0);
       rightWheel.setPower(0);
    };



#endif //FTCROBOTCONTROLLER_WIP_22_23_AUTONOMOUSROUGHDRAFT_H
