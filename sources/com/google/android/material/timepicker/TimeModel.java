package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final b f20426a;

    /* renamed from: b  reason: collision with root package name */
    private final b f20427b;

    /* renamed from: c  reason: collision with root package name */
    final int f20428c;

    /* renamed from: d  reason: collision with root package name */
    int f20429d;

    /* renamed from: e  reason: collision with root package name */
    int f20430e;

    /* renamed from: f  reason: collision with root package name */
    int f20431f;

    /* renamed from: g  reason: collision with root package name */
    int f20432g;

    class a implements Parcelable.Creator<TimeModel> {
        a() {
        }

        /* renamed from: a */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        /* renamed from: b */
        public TimeModel[] newArray(int i10) {
            return new TimeModel[i10];
        }
    }

    public TimeModel() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return c(resources, charSequence, "%02d");
    }

    public static String c(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(charSequence)))});
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int d(int i10) {
        return i10 >= 12 ? 1 : 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.f20429d == timeModel.f20429d && this.f20430e == timeModel.f20430e && this.f20428c == timeModel.f20428c && this.f20431f == timeModel.f20431f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20428c), Integer.valueOf(this.f20429d), Integer.valueOf(this.f20430e), Integer.valueOf(this.f20431f)});
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f20429d);
        parcel.writeInt(this.f20430e);
        parcel.writeInt(this.f20431f);
        parcel.writeInt(this.f20428c);
    }

    public TimeModel(int i10) {
        this(0, 0, 10, i10);
    }

    public TimeModel(int i10, int i11, int i12, int i13) {
        this.f20429d = i10;
        this.f20430e = i11;
        this.f20431f = i12;
        this.f20428c = i13;
        this.f20432g = d(i10);
        this.f20426a = new b(59);
        this.f20427b = new b(i13 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
