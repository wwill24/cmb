package com.withpersona.sdk2.camera;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ImageLightCondition implements Parcelable {
    public static final Parcelable.Creator<ImageLightCondition> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final double f14133a;

    /* renamed from: b  reason: collision with root package name */
    private final double f14134b;

    /* renamed from: c  reason: collision with root package name */
    private final double f14135c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14136d;

    public static final class a implements Parcelable.Creator<ImageLightCondition> {
        /* renamed from: a */
        public final ImageLightCondition createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new ImageLightCondition(parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readInt());
        }

        /* renamed from: b */
        public final ImageLightCondition[] newArray(int i10) {
            return new ImageLightCondition[i10];
        }
    }

    public ImageLightCondition(double d10, double d11, double d12, int i10) {
        this.f14133a = d10;
        this.f14134b = d11;
        this.f14135c = d12;
        this.f14136d = i10;
    }

    public final double a() {
        return this.f14135c;
    }

    public final double c() {
        return this.f14133a;
    }

    public final double d() {
        return this.f14134b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageLightCondition)) {
            return false;
        }
        ImageLightCondition imageLightCondition = (ImageLightCondition) obj;
        return Double.compare(this.f14133a, imageLightCondition.f14133a) == 0 && Double.compare(this.f14134b, imageLightCondition.f14134b) == 0 && Double.compare(this.f14135c, imageLightCondition.f14135c) == 0 && this.f14136d == imageLightCondition.f14136d;
    }

    public int hashCode() {
        return (((((Double.hashCode(this.f14133a) * 31) + Double.hashCode(this.f14134b)) * 31) + Double.hashCode(this.f14135c)) * 31) + Integer.hashCode(this.f14136d);
    }

    public String toString() {
        return "ImageLightCondition(luminosity=" + this.f14133a + ", rmsContrast=" + this.f14134b + ", lowHighContrast=" + this.f14135c + ", sampleSize=" + this.f14136d + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeDouble(this.f14133a);
        parcel.writeDouble(this.f14134b);
        parcel.writeDouble(this.f14135c);
        parcel.writeInt(this.f14136d);
    }
}
