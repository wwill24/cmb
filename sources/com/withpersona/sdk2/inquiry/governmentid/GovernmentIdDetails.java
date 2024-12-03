package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class GovernmentIdDetails implements Parcelable {
    public static final Parcelable.Creator<GovernmentIdDetails> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Date f25357a;

    /* renamed from: b  reason: collision with root package name */
    private final Date f25358b;

    public static final class a implements Parcelable.Creator<GovernmentIdDetails> {
        /* renamed from: a */
        public final GovernmentIdDetails createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new GovernmentIdDetails((Date) parcel.readSerializable(), (Date) parcel.readSerializable());
        }

        /* renamed from: b */
        public final GovernmentIdDetails[] newArray(int i10) {
            return new GovernmentIdDetails[i10];
        }
    }

    public GovernmentIdDetails(Date date, Date date2) {
        this.f25357a = date;
        this.f25358b = date2;
    }

    public final Date a() {
        return this.f25357a;
    }

    public final Date c() {
        return this.f25358b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GovernmentIdDetails)) {
            return false;
        }
        GovernmentIdDetails governmentIdDetails = (GovernmentIdDetails) obj;
        return j.b(this.f25357a, governmentIdDetails.f25357a) && j.b(this.f25358b, governmentIdDetails.f25358b);
    }

    public int hashCode() {
        Date date = this.f25357a;
        int i10 = 0;
        int hashCode = (date == null ? 0 : date.hashCode()) * 31;
        Date date2 = this.f25358b;
        if (date2 != null) {
            i10 = date2.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return "GovernmentIdDetails(dateOfBirth=" + this.f25357a + ", expirationDate=" + this.f25358b + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeSerializable(this.f25357a);
        parcel.writeSerializable(this.f25358b);
    }
}
