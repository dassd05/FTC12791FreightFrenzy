package org.firstinspires.ftc.teamcode.drive.Constants;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

import org.opencv.core.Point;

import java.util.*;

@Config
public class Constants {

    //TODO: servo positions
    public static double BOX_ROTATION_DOWN = 0.0;
    public static double BOX_ROTATION_UP = 0.0;
    public static double BOX_ROTATION_DEPLOY = 0.0;

    //TODO: min and max positions to avoid going too far
    public static double SLIDES_1_MAX = 0.0;
    public static double SLIDES_2_MAX = 0.0;
    public static double SLIDES_1_MIN = 0.0;
    public static double SLIDES_2_MIN = 0.0;

    public static double LINKAGE_1_MAX = 0.0;
    public static double LINKAGE_2_MAX = 0.0;
    public static double LINKAGE_1_MIN = 0.0;
    public static double LINKAGE_2_MIN = 0.0;

    //TODO: fix these adjustments as necessary
    public static double LINKAGE_ADJUSTMENT = .0005;
    public static double SLIDES_ADJUSTMENT = .05;

    public static double INTAKE_POWER = 0.75;

    public static PIDCoefficients pidConsts = new PIDCoefficients(0.0, 0.000, 0.0);
    public static PIDCoefficients pidConstsSlides = new PIDCoefficients(0.0045, 0.00000000, 0.0);
    //TODO: tune PID

    public static double WHEEL_RADIUS = 0.0;
    public static double TICKS_PER_REV = 0.0;
    public static double GEAR_RATIO = 0.0;

    public static double trackWidth = 0.0;

    public static double LEFT_WHEEL_MULTIPLIER = 0.0;
    public static double RIGHT_WHEEL_MULTIPLIER = 0.0;
    //TODO: tune odo constants

    //box detecting constants
    public static double THRESHOLD = 0.0;

    public static final Point REGION1_TOPLEFT_ANCHOR_POINT = new Point(500, 500);
    public static final Point REGION2_TOPLEFT_ANCHOR_POINT = new Point(750, 500);
    public static final Point REGION3_TOPLEFT_ANCHOR_POINT = new Point(1000, 500);


    public static final int REGION_WIDTH = 100;
    public static final int REGION_HEIGHT = 100;
    //TODO: fix all the box detecting constants
}
