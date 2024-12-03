package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.c;
import java.util.Arrays;
import java.util.Objects;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Month f19496a;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Month f19497b;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final DateValidator f19498c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Month f19499d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f19500e;

    /* renamed from: f  reason: collision with root package name */
    private final int f19501f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19502g;

    public interface DateValidator extends Parcelable {
        boolean u0(long j10);
    }

    class a implements Parcelable.Creator<CalendarConstraints> {
        a() {
        }

        @NonNull
        /* renamed from: a */
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt(), (a) null);
        }

        @NonNull
        /* renamed from: b */
        public CalendarConstraints[] newArray(int i10) {
            return new CalendarConstraints[i10];
        }
    }

    public static final class b {

        /* renamed from: f  reason: collision with root package name */
        static final long f19503f = r.a(Month.c(1900, 0).f19561f);

        /* renamed from: g  reason: collision with root package name */
        static final long f19504g = r.a(Month.c(2100, 11).f19561f);

        /* renamed from: a  reason: collision with root package name */
        private long f19505a = f19503f;

        /* renamed from: b  reason: collision with root package name */
        private long f19506b = f19504g;

        /* renamed from: c  reason: collision with root package name */
        private Long f19507c;

        /* renamed from: d  reason: collision with root package name */
        private int f19508d;

        /* renamed from: e  reason: collision with root package name */
        private DateValidator f19509e = DateValidatorPointForward.a(Long.MIN_VALUE);

        b(@NonNull CalendarConstraints calendarConstraints) {
            this.f19505a = calendarConstraints.f19496a.f19561f;
            this.f19506b = calendarConstraints.f19497b.f19561f;
            this.f19507c = Long.valueOf(calendarConstraints.f19499d.f19561f);
            this.f19508d = calendarConstraints.f19500e;
            this.f19509e = calendarConstraints.f19498c;
        }

        @NonNull
        public CalendarConstraints a() {
            Month month;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f19509e);
            Month d10 = Month.d(this.f19505a);
            Month d11 = Month.d(this.f19506b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l10 = this.f19507c;
            if (l10 == null) {
                month = null;
            } else {
                month = Month.d(l10.longValue());
            }
            return new CalendarConstraints(d10, d11, dateValidator, month, this.f19508d, (a) null);
        }

        @NonNull
        public b b(long j10) {
            this.f19507c = Long.valueOf(j10);
            return this;
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i10, a aVar) {
        this(month, month2, dateValidator, month3, i10);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (!this.f19496a.equals(calendarConstraints.f19496a) || !this.f19497b.equals(calendarConstraints.f19497b) || !c.a(this.f19499d, calendarConstraints.f19499d) || this.f19500e != calendarConstraints.f19500e || !this.f19498c.equals(calendarConstraints.f19498c)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public Month g(Month month) {
        if (month.compareTo(this.f19496a) < 0) {
            return this.f19496a;
        }
        if (month.compareTo(this.f19497b) > 0) {
            return this.f19497b;
        }
        return month;
    }

    public DateValidator h() {
        return this.f19498c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f19496a, this.f19497b, this.f19499d, Integer.valueOf(this.f19500e), this.f19498c});
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month i() {
        return this.f19497b;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f19500e;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f19502g;
    }

    /* access modifiers changed from: package-private */
    public Month l() {
        return this.f19499d;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month m() {
        return this.f19496a;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f19501f;
    }

    /* access modifiers changed from: package-private */
    public boolean o(long j10) {
        if (this.f19496a.i(1) <= j10) {
            Month month = this.f19497b;
            if (j10 <= month.i(month.f19560e)) {
                return true;
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f19496a, 0);
        parcel.writeParcelable(this.f19497b, 0);
        parcel.writeParcelable(this.f19499d, 0);
        parcel.writeParcelable(this.f19498c, 0);
        parcel.writeInt(this.f19500e);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, Month month3, int i10) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.f19496a = month;
        this.f19497b = month2;
        this.f19499d = month3;
        this.f19500e = i10;
        this.f19498c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        } else if (i10 < 0 || i10 > r.l().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        } else {
            this.f19502g = month.p(month2) + 1;
            this.f19501f = (month2.f19558c - month.f19558c) + 1;
        }
    }
}
