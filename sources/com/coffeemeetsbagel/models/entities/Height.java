package com.coffeemeetsbagel.models.entities;

import org.apache.commons.beanutils.PropertyUtils;

public final class Height {
    private final int heightCm;
    private final int heightFeet;
    private final int heightInches;

    public Height(int i10, int i11, int i12) {
        this.heightCm = i10;
        this.heightFeet = i11;
        this.heightInches = i12;
    }

    public static /* synthetic */ Height copy$default(Height height, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = height.heightCm;
        }
        if ((i13 & 2) != 0) {
            i11 = height.heightFeet;
        }
        if ((i13 & 4) != 0) {
            i12 = height.heightInches;
        }
        return height.copy(i10, i11, i12);
    }

    public final int component1() {
        return this.heightCm;
    }

    public final int component2() {
        return this.heightFeet;
    }

    public final int component3() {
        return this.heightInches;
    }

    public final Height copy(int i10, int i11, int i12) {
        return new Height(i10, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Height)) {
            return false;
        }
        Height height = (Height) obj;
        return this.heightCm == height.heightCm && this.heightFeet == height.heightFeet && this.heightInches == height.heightInches;
    }

    public final int getHeightCm() {
        return this.heightCm;
    }

    public final int getHeightFeet() {
        return this.heightFeet;
    }

    public final int getHeightInches() {
        return this.heightInches;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.heightCm) * 31) + Integer.hashCode(this.heightFeet)) * 31) + Integer.hashCode(this.heightInches);
    }

    public String toString() {
        return "Height(heightCm=" + this.heightCm + ", heightFeet=" + this.heightFeet + ", heightInches=" + this.heightInches + PropertyUtils.MAPPED_DELIM2;
    }
}
