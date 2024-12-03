package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final long f19514a;

    class a implements Parcelable.Creator<DateValidatorPointBackward> {
        a() {
        }

        @NonNull
        /* renamed from: a */
        public DateValidatorPointBackward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong(), (a) null);
        }

        @NonNull
        /* renamed from: b */
        public DateValidatorPointBackward[] newArray(int i10) {
            return new DateValidatorPointBackward[i10];
        }
    }

    /* synthetic */ DateValidatorPointBackward(long j10, a aVar) {
        this(j10);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateValidatorPointBackward)) {
            return false;
        }
        if (this.f19514a == ((DateValidatorPointBackward) obj).f19514a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f19514a)});
    }

    public boolean u0(long j10) {
        return j10 <= this.f19514a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeLong(this.f19514a);
    }

    private DateValidatorPointBackward(long j10) {
        this.f19514a = j10;
    }
}
