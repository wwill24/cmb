package com.withpersona.sdk2.inquiry.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class MrzKey implements Parcelable {
    public static final Parcelable.Creator<MrzKey> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f27016a;

    /* renamed from: b  reason: collision with root package name */
    private final Date f27017b;

    /* renamed from: c  reason: collision with root package name */
    private final Date f27018c;

    public static final class a implements Parcelable.Creator<MrzKey> {
        /* renamed from: a */
        public final MrzKey createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new MrzKey(parcel.readString(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable());
        }

        /* renamed from: b */
        public final MrzKey[] newArray(int i10) {
            return new MrzKey[i10];
        }
    }

    public MrzKey(String str, Date date, Date date2) {
        j.g(str, "passportNumber");
        j.g(date, "expirationDate");
        j.g(date2, "dateOfBirth");
        this.f27016a = str;
        this.f27017b = date;
        this.f27018c = date2;
    }

    public final Date a() {
        return this.f27018c;
    }

    public final Date c() {
        return this.f27017b;
    }

    public final String d() {
        return this.f27016a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MrzKey)) {
            return false;
        }
        MrzKey mrzKey = (MrzKey) obj;
        return j.b(this.f27016a, mrzKey.f27016a) && j.b(this.f27017b, mrzKey.f27017b) && j.b(this.f27018c, mrzKey.f27018c);
    }

    public int hashCode() {
        return (((this.f27016a.hashCode() * 31) + this.f27017b.hashCode()) * 31) + this.f27018c.hashCode();
    }

    public String toString() {
        return "MrzKey(passportNumber=" + this.f27016a + ", expirationDate=" + this.f27017b + ", dateOfBirth=" + this.f27018c + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f27016a);
        parcel.writeSerializable(this.f27017b);
        parcel.writeSerializable(this.f27018c);
    }
}
