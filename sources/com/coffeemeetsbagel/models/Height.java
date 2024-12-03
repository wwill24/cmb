package com.coffeemeetsbagel.models;

import android.content.Context;

public class Height {
    public static final float CENTIMETRES_IN_INCH = 2.54f;
    public static final int CENTIMETRES_MAX = 272;
    public static final int CENTIMETRES_MIN = 122;
    public static final int DEFAULT_HEIGHT_CENTIMETRES = 168;
    public static final int DEFAULT_HEIGHT_FEET = 5;
    public static final int DEFAULT_HEIGHT_INCHES = 6;
    public static final int FEET_MAX = 8;
    public static final int FEET_MIN = 4;
    private static final float INCHES_IN_CENTIMETRE = 0.39370078f;
    public static final int INCHES_IN_FOOT = 12;
    public static final int INCHES_MAX = 11;
    public static final int INCHES_MIN = 0;
    private int mHeightCentimetres;
    private int mHeightFeet;
    private int mHeightInches;

    public Height(int i10, int i11) {
        this.mHeightCentimetres = convertToCentimetres(i10, i11);
        this.mHeightFeet = i10;
        this.mHeightInches = i11;
    }

    public static int convertToCentimetres(int i10, int i11) {
        return Math.round(((float) ((i10 * 12) + i11)) * 2.54f);
    }

    public static int convertToInches(int i10) {
        return Math.round(((float) i10) * INCHES_IN_CENTIMETRE);
    }

    public int getHeightCentimetres() {
        return this.mHeightCentimetres;
    }

    public int getHeightFeet() {
        return this.mHeightFeet;
    }

    public int getHeightInches() {
        return this.mHeightInches;
    }

    public String toStringImperial() {
        return String.valueOf(this.mHeightFeet) + "'" + String.valueOf(this.mHeightInches) + "\"";
    }

    public String toStringMetric(Context context) {
        return String.valueOf(this.mHeightCentimetres) + context.getResources().getString(R.string.centimeter_unit);
    }

    public Height(int i10) {
        this.mHeightCentimetres = i10;
        int convertToInches = convertToInches(i10);
        this.mHeightFeet = convertToInches / 12;
        this.mHeightInches = convertToInches % 12;
    }
}
