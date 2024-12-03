package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final d f19510c = new a();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final d f19511d = new b();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final d f19512a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final List<CalendarConstraints.DateValidator> f19513b;

    class a implements d {
        a() {
        }

        public boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j10) {
            for (CalendarConstraints.DateValidator next : list) {
                if (next != null && next.u0(j10)) {
                    return true;
                }
            }
            return false;
        }

        public int getId() {
            return 1;
        }
    }

    class b implements d {
        b() {
        }

        public boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j10) {
            for (CalendarConstraints.DateValidator next : list) {
                if (next != null && !next.u0(j10)) {
                    return false;
                }
            }
            return true;
        }

        public int getId() {
            return 2;
        }
    }

    class c implements Parcelable.Creator<CompositeDateValidator> {
        c() {
        }

        @NonNull
        /* renamed from: a */
        public CompositeDateValidator createFromParcel(@NonNull Parcel parcel) {
            d dVar;
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            if (readInt == 2) {
                dVar = CompositeDateValidator.f19511d;
            } else if (readInt == 1) {
                dVar = CompositeDateValidator.f19510c;
            } else {
                dVar = CompositeDateValidator.f19511d;
            }
            return new CompositeDateValidator((List) h.g(readArrayList), dVar, (a) null);
        }

        @NonNull
        /* renamed from: b */
        public CompositeDateValidator[] newArray(int i10) {
            return new CompositeDateValidator[i10];
        }
    }

    private interface d {
        boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j10);

        int getId();
    }

    /* synthetic */ CompositeDateValidator(List list, d dVar, a aVar) {
        this(list, dVar);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        if (!this.f19513b.equals(compositeDateValidator.f19513b) || this.f19512a.getId() != compositeDateValidator.f19512a.getId()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f19513b.hashCode();
    }

    public boolean u0(long j10) {
        return this.f19512a.a(this.f19513b, j10);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeList(this.f19513b);
        parcel.writeInt(this.f19512a.getId());
    }

    private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> list, d dVar) {
        this.f19513b = list;
        this.f19512a = dVar;
    }
}
