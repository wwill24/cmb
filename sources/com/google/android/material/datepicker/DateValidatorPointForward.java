package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final long f19515a;

    class a implements Parcelable.Creator<DateValidatorPointForward> {
        a() {
        }

        @NonNull
        /* renamed from: a */
        public DateValidatorPointForward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), (a) null);
        }

        @NonNull
        /* renamed from: b */
        public DateValidatorPointForward[] newArray(int i10) {
            return new DateValidatorPointForward[i10];
        }
    }

    /* synthetic */ DateValidatorPointForward(long j10, a aVar) {
        this(j10);
    }

    @NonNull
    public static DateValidatorPointForward a(long j10) {
        return new DateValidatorPointForward(j10);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateValidatorPointForward)) {
            return false;
        }
        if (this.f19515a == ((DateValidatorPointForward) obj).f19515a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f19515a)});
    }

    public boolean u0(long j10) {
        return j10 >= this.f19515a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeLong(this.f19515a);
    }

    private DateValidatorPointForward(long j10) {
        this.f19515a = j10;
    }
}
