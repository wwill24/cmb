package com.github.mikephil.charting.utils;

public final class FSize {
    public final float height;
    public final float width;

    public FSize(float f10, float f11) {
        this.width = f10;
        this.height = f11;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FSize)) {
            return false;
        }
        FSize fSize = (FSize) obj;
        if (this.width == fSize.width && this.height == fSize.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.width) ^ Float.floatToIntBits(this.height);
    }

    public String toString() {
        return this.width + "x" + this.height;
    }
}
