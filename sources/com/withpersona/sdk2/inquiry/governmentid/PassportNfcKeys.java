package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class PassportNfcKeys implements Parcelable {
    public static final Parcelable.Creator<PassportNfcKeys> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f25691a;

    /* renamed from: b  reason: collision with root package name */
    private final Date f25692b;

    /* renamed from: c  reason: collision with root package name */
    private final Date f25693c;

    public static final class a implements Parcelable.Creator<PassportNfcKeys> {
        /* renamed from: a */
        public final PassportNfcKeys createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportNfcKeys(parcel.readString(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable());
        }

        /* renamed from: b */
        public final PassportNfcKeys[] newArray(int i10) {
            return new PassportNfcKeys[i10];
        }
    }

    public PassportNfcKeys() {
        this((String) null, (Date) null, (Date) null, 7, (DefaultConstructorMarker) null);
    }

    public PassportNfcKeys(String str, Date date, Date date2) {
        j.g(str, "passportNumber");
        this.f25691a = str;
        this.f25692b = date;
        this.f25693c = date2;
    }

    public final Date a() {
        return this.f25693c;
    }

    public final Date c() {
        return this.f25692b;
    }

    public final String d() {
        return this.f25691a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassportNfcKeys)) {
            return false;
        }
        PassportNfcKeys passportNfcKeys = (PassportNfcKeys) obj;
        return j.b(this.f25691a, passportNfcKeys.f25691a) && j.b(this.f25692b, passportNfcKeys.f25692b) && j.b(this.f25693c, passportNfcKeys.f25693c);
    }

    public int hashCode() {
        int hashCode = this.f25691a.hashCode() * 31;
        Date date = this.f25692b;
        int i10 = 0;
        int hashCode2 = (hashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.f25693c;
        if (date2 != null) {
            i10 = date2.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "PassportNfcKeys(passportNumber=" + this.f25691a + ", expirationDate=" + this.f25692b + ", dateOfBirth=" + this.f25693c + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f25691a);
        parcel.writeSerializable(this.f25692b);
        parcel.writeSerializable(this.f25693c);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PassportNfcKeys(String str, Date date, Date date2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? null : date, (i10 & 4) != 0 ? null : date2);
    }
}
