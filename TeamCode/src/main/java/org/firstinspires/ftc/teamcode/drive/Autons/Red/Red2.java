package org.firstinspires.ftc.teamcode.drive.Autons.Red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.drive.Autons.Vision.BoxPositionDetection;
import org.firstinspires.ftc.teamcode.drive.Robot;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

import static org.firstinspires.ftc.teamcode.drive.Autons.Vision.BoxPositionDetection.BoxDetection.*;
import static org.firstinspires.ftc.teamcode.drive.Autons.Vision.BoxPositionDetection.pipeline;
import static org.firstinspires.ftc.teamcode.drive.Robot.*;

@Autonomous(group = "A", name = "Red Right", preselectTeleOp = "Teleop")
public class Red2 extends LinearOpMode {

    Robot r = new Robot();

    public WebcamName webcamName;
    public OpenCvWebcam webcam;

    public enum ThisPosition {
        LEFT_POSITION,
        MIDDLE_POSITION,
        RIGHT_POSITION
    }

    public volatile ThisPosition WhatPosition = ThisPosition.MIDDLE_POSITION;

    boolean firstTime = true;
    boolean runFSM = false;

    @Override
    public void runOpMode() throws InterruptedException {

        r.telemetry = telemetry;
        r.init(hardwareMap);

        int cameraMonitorViewId = hardwareMap.appContext.getResources().
                getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");
        webcam = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId);
        webcam.setPipeline(pipeline);
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {

            @Override
            public void onOpened() {
                webcam.startStreaming(960, 720, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {
            }
        });

        xPos = 0.0;
        yPos = 0.0;
        thetaPos = 0.0; //ofc might want to change

        sleep(150);

        while (!opModeIsActive())
            updateBoxPosition();

        waitForStart();

        if (isStopRequested()) return;

        r.autonWaitTimer.reset();
        r.odoTimer.reset();
        r.webcam.stopStreaming();

        while (opModeIsActive()) {

            switch (WhatPosition) {
                case LEFT_POSITION:
                    switch (LeftRedState) {

                    }
                    break;

                case RIGHT_POSITION:
                    switch (RightRedState) {

                    }
                    break;

                case MIDDLE_POSITION:
                    switch (MiddleRedState) {

                    }
                    break;
            }

            r.updateAll();
//
//            telemetry.addData("x", r.getX());
//            telemetry.addData("y", r.getY());
//            telemetry.addData("heading", r.getTheta());
            telemetry.update();
        }
    }

    public void updateBoxPosition() {
        if (pipeline.position == null) {
            telemetry.addData("still working on it", "gimme a sec");
        } else if (pipeline.position == BoxPositionDetection.BoxPosition.RIGHT){
            telemetry.addData("Right Barcode, Top Level", "Waiting for start");
            WhatPosition = ThisPosition.RIGHT_POSITION;
        } else if (pipeline.position == BoxPositionDetection.BoxPosition.MIDDLE){
            telemetry.addData("Middle Barcode, Middle Level", "Waiting for start");
            WhatPosition = ThisPosition.MIDDLE_POSITION;
        } else if (pipeline.position == BoxPositionDetection.BoxPosition.LEFT){
            telemetry.addData("Left Barcode, Bottom Level", "Waiting for start");
            WhatPosition = ThisPosition.LEFT_POSITION;
        }
        telemetry.addData("average 1", avg1);
        telemetry.addData("average 2", avg2);
        telemetry.addData("average 3", avg3);
        telemetry.update();
        sleep(75);
    }
}
