


        package org.firstinspires.ftc.teamcode;
        /* Copyright (c) 2017 FIRST. All rights reserved.
         *
         * Redistribution and use in source and binary forms, with or without modification,
         * are permitted (subject to the limitations in the disclaimer below) provided that
         * the following conditions are met:
         *
         * Redistributions of source code must retain the above copyright notice, this list
         * of conditions and the following disclaimer.
         *
         * Redistributions in binary form must reproduce the above copyright notice, this
         * list of conditions and the following disclaimer in the documentation and/or
         * other materials provided with the distribution.
         *
         * Neither the name of FIRST nor the names of its contributors may be used to endorse or
         * promote products derived from this software without specific prior written permission.
         *
         * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
         * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
         * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
         * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
         * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
         * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
         * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
         * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
         * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
         * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
         * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
         */


        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotorEx;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.hardware.Servo;
        import com.qualcomm.robotcore.util.ElapsedTime;

        /**
         * This file contains an example of an iterative (Non-Linear) "OpMode".
         * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
         * The names of OpModes appear on the menu of the FTC Driver Station.
         * When an selection is made from the menu, the corresponding OpMode
         * class is instantiated on the Robot Controller and executed.
         * <p>
         * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
         * It includes all the skeletal structure that all iterative OpModes contain.
         * <p>
         * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
         * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
         */
        /*
            @Autonomous = this is for Autonomous mode
            @TeleOp = this is for User Controlled mode
            name = the name that will display on the Driver Hub
            group = allows you to group OpModes
         */
        @TeleOp(name = "(boooo7)", group = "d")
        //@Disabled  This way it will run on the robot
        public class testarm extends OpMode {
            // Declare OpMode members.`a
            private ElapsedTime runtime = new ElapsedTime();  //timer

            /*
            Declare motors to type DcMotorEx
            Documentation:
            https://ftctechnh.github.io/ftc_app/doc/javadoc/com/qualcomm/robotcore/hardware/DcMotorEx.html
             */

            //Touch Sensors
            //private DigitalChannel intakeSensor;


            private DcMotorEx wheelFL;
            private DcMotorEx wheelFR;
            private DcMotorEx wheelBL;
            private DcMotorEx wheelBR;
            private DcMotorEx armBase;

            //   private Servo contServo;
            float leftY, rightY;




            //Servos
            private Servo clawGrip;

            //Variables

            // private boolean isGrabbing = false;

            private double speedMod;
            private double previousRunTime;
            //   private double inputDelayInSeconds = .5;
            //  private boolean rumbleLevel = true;
            //  private boolean gripperToggle = false;
            private double rotation = 0;


            /*
             * Code to run ONCE when the driver hits INIT
             */
            @Override
            public void init() {
                telemetry.addData("Status", "Initialized");


                // Initialize the hardware variables. Note that the strings used here as parameters
                // to 'get' must correspond to the names assigned during the robot configuration
                // step (using the FTC Robot Controller app on the phone).

                //Motors
                wheelFL = hardwareMap.get(DcMotorEx.class, "wheelFL");
                wheelFR = hardwareMap.get(DcMotorEx.class, "wheelFR");
                wheelBL = hardwareMap.get(DcMotorEx.class, "wheelBL");
                wheelBR = hardwareMap.get(DcMotorEx.class, "wheelBR");

                armBase = hardwareMap.get(DcMotorEx.class, "armBase");

                //Touch Sensors
                //intakeSensor = hardwareMap.get(DigitalChannel.class, "intakeTouchSensor");

                //Distance Sensors
        //        backDistanceSensor = hardwareMap.get(Rev2mDistanceSensor.class, "distanceBack");
        //        sideDistanceSensor = hardwareMap.get(Rev2mDistanceSensor.class, "distanceSide");

                //Servos


                clawGrip = hardwareMap.get(Servo.class, "clawGrip");

                /*
                    Set up motors so they run without the encoders
                    This way they run freely.  They won't go to a specific position or count the number of rotations
                    It will now run with range from -1.0 to 1.0
        // Name of the motor; what it does:
                    See Documentation for other encoder modes
                    https://docs.revrobotics.com/rev-control-system/programming/using-encoder-feedback
                 */

                //Motor Encoders
                //Wheels
                wheelFL.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                wheelFR.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                wheelBL.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                wheelBR.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

                // Most robots need the motor on one side to be reversed to drive forward
                // Reverse the motor that runs backwards when connected directly to the battery
                wheelFL.setDirection(DcMotorSimple.Direction.REVERSE);
                wheelFR.setDirection(DcMotorSimple.Direction.FORWARD);
                wheelBL.setDirection(DcMotorSimple.Direction.REVERSE);
                wheelBR.setDirection(DcMotorSimple.Direction.REVERSE);
                ;
                armBase.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

                armBase.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

                // Tell the driver that initialization is complete.
                telemetry.addData("Status", "Initialized");


            }

            /*
             * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
             */
            @Override
            public void init_loop() {
            }

            /*
             * Code to run ONCE when the driver hits PLAY
             */
            @Override
            public void start() {
                runtime.reset();
                previousRunTime = getRuntime();


            }

            /*
             * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
             */
            @Override
            public void loop() {
        // runs until turned off
                //   wheelTesting();
                // precisionControl();
                drivingControl();
        //        somthing();
                armslide();
                claw();
                //runencoder();
            }

            public void wheelTesting() {
                wheelFL.setPower(1);
                wheelFR.setPower(1);
                wheelBL.setPower(1);
                wheelBR.setPower(1);


            }


            public void drivingControl() {

                //gets controller input
                double r = Math.hypot(gamepad1.left_stick_y, gamepad1.left_stick_x);

                //make calculations based upon the input
                double robotAngle = Math.atan2(gamepad1.left_stick_x, gamepad1.left_stick_y) - Math.PI / 4;
                double rightX = gamepad1.right_stick_x;
                rotation += 1 * rightX;
                final double v1 = r * Math.cos(robotAngle) - rightX;
                final double v2 = r * Math.sin(robotAngle) + rightX;
                final double v3 = r * Math.sin(robotAngle) - rightX;
                final double v4 = (r * Math.cos(robotAngle)) * 1.25 + rightX;


                //change the power for each wheel
                wheelFL.setPower(-v1);
                wheelFR.setPower(v2);
                wheelBL.setPower(-v3);
                wheelBR.setPower(v4);
            }


            //public void runencoder(){

            //     DcMotorEx wheelFl = hardwareMap.get(DcMotorEx.class, "wheelFL");
            // wheelFl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // This will turn the motor at 200 ticks per second
            //  double motorVelocity = 200;
            //   wheelFl.setVelocity(motorVelocity);
            //wheel FR
            //  DcMotorEx wheelFR = hardwareMap.get(DcMotorEx.class, "wheelFR");
            //  wheelFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            // This will turn the motor at 200 ticks per second
            //   wheelFR.setVelocity(motorVelocity);
            // wheel BL
            //   DcMotorEx wheelBL = hardwareMap.get(DcMotorEx.class, "wheelBL");
            //    wheelBL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //     wheelBL.setVelocity(motorVelocity);
            // wheel BR
            //      DcMotorEx wheelBR = hardwareMap.get(DcMotorEx.class, "wheelBR");
            //   wheelBR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //  wheelBR.setVelocity(motorVelocity);
            //  }
            //  private void arm() {


            //  }



            public void armslide() {






                    int ArmTarget = 0;



                    // run until the end of the match (driver presses STOP)
                        //MECHANISM CODE

                        if (gamepad1.a) {
                            ArmTarget = 0; //On the ground for starting and intaking
                        }
                        else if (gamepad1.x) {
                            ArmTarget = 120; //Low level on the goal
                        }
                        else if (gamepad1.y) {
                            ArmTarget = 260; //Mid level on the goal
                        }
                        else if (gamepad1.b) {
                            ArmTarget = 410; //High level on the goal
                        }
                        else if (gamepad1.right_bumper) {
                            ArmTarget = 1420; //High level on the goal scoring backwards
                        }
                        else if (gamepad1.left_bumper) {
                            ArmTarget = 1570; //Mid level on the goal scoring backwards
                        }

                        //stuff for arm position control
                        armBase.setTargetPosition(ArmTarget);
                        armBase.setPower(1);

                        telemetry.addData("Arm Position", armBase.getCurrentPosition());
                        telemetry.update();
                    }






            public void claw() {

                if (gamepad2.left_trigger > 0) { //tune this value where u need it

                    clawGrip.setPosition(0);
                }
                if (gamepad2.right_trigger > 0) {
                    clawGrip.setPosition(0.5); //tune this value where u need it
                }


            }
        }


