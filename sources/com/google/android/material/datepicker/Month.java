package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f19556a;

    /* renamed from: b  reason: collision with root package name */
    final int f19557b;

    /* renamed from: c  reason: collision with root package name */
    final int f19558c;

    /* renamed from: d  reason: collision with root package name */
    final int f19559d;

    /* renamed from: e  reason: collision with root package name */
    final int f19560e;

    /* renamed from: f  reason: collision with root package name */
    final long f19561f;

    /* renamed from: g  reason: collision with root package name */
    private String f19562g;

    class a implements Parcelable.Creator<Month> {
        a() {
        }

        @NonNull
        /* renamed from: a */
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.c(parcel.readInt(), parcel.readInt());
        }

        @NonNull
        /* renamed from: b */
        public Month[] newArray(int i10) {
            return new Month[i10];
        }
    }

    private Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar e10 = r.e(calendar);
        this.f19556a = e10;
        this.f19557b = e10.get(2);
        this.f19558c = e10.get(1);
        this.f19559d = e10.getMaximum(7);
        this.f19560e = e10.getActualMaximum(5);
        this.f19561f = e10.getTimeInMillis();
    }

    @NonNull
    static Month c(int i10, int i11) {
        Calendar l10 = r.l();
        l10.set(1, i10);
        l10.set(2, i11);
        return new Month(l10);
    }

    @NonNull
    static Month d(long j10) {
        Calendar l10 = r.l();
        l10.setTimeInMillis(j10);
        return new Month(l10);
    }

    @NonNull
    static Month e() {
        return new Month(r.j());
    }

    /* renamed from: a */
    public int compareTo(@NonNull Month month) {
        return this.f19556a.compareTo(month.f19556a);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.f19557b == month.f19557b && this.f19558c == month.f19558c) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int h(int i10) {
        int i11 = this.f19556a.get(7);
        if (i10 <= 0) {
            i10 = this.f19556a.getFirstDayOfWeek();
        }
        int i12 = i11 - i10;
        if (i12 < 0) {
            return i12 + this.f19559d;
        }
        return i12;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f19557b), Integer.valueOf(this.f19558c)});
    }

    /* access modifiers changed from: package-private */
    public long i(int i10) {
        Calendar e10 = r.e(this.f19556a);
        e10.set(5, i10);
        return e10.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    public int j(long j10) {
        Calendar e10 = r.e(this.f19556a);
        e10.setTimeInMillis(j10);
        return e10.get(5);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String k() {
        if (this.f19562g == null) {
            this.f19562g = g.l(this.f19556a.getTimeInMillis());
        }
        return this.f19562g;
    }

    /* access modifiers changed from: package-private */
    public long l() {
        return this.f19556a.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month o(int i10) {
        Calendar e10 = r.e(this.f19556a);
        e10.add(2, i10);
        return new Month(e10);
    }

    /* access modifiers changed from: package-private */
    public int p(@NonNull Month month) {
        if (this.f19556a instanceof GregorianCalendar) {
            return ((month.f19558c - this.f19558c) * 12) + (month.f19557b - this.f19557b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeInt(this.f19558c);
        parcel.writeInt(this.f19557b);
    }
}
