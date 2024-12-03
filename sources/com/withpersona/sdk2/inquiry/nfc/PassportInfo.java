package com.withpersona.sdk2.inquiry.nfc;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class PassportInfo implements Parcelable {
    public static final Parcelable.Creator<PassportInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f27019a;

    /* renamed from: b  reason: collision with root package name */
    private final Date f27020b;

    /* renamed from: c  reason: collision with root package name */
    private final Date f27021c;

    /* renamed from: d  reason: collision with root package name */
    private final String f27022d;

    /* renamed from: e  reason: collision with root package name */
    private final String f27023e;

    /* renamed from: f  reason: collision with root package name */
    private final String f27024f;

    /* renamed from: g  reason: collision with root package name */
    private final String f27025g;

    /* renamed from: h  reason: collision with root package name */
    private final String f27026h;

    /* renamed from: j  reason: collision with root package name */
    private final String f27027j;

    /* renamed from: k  reason: collision with root package name */
    private final Uri f27028k;

    public static final class a implements Parcelable.Creator<PassportInfo> {
        /* renamed from: a */
        public final PassportInfo createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportInfo(parcel.readString(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Uri) parcel.readParcelable(PassportInfo.class.getClassLoader()));
        }

        /* renamed from: b */
        public final PassportInfo[] newArray(int i10) {
            return new PassportInfo[i10];
        }
    }

    public PassportInfo(String str, Date date, Date date2, String str2, String str3, String str4, String str5, String str6, String str7, Uri uri) {
        j.g(str, "passportNumber");
        j.g(str2, "firstName");
        j.g(str3, "lastName");
        j.g(str5, "issuingAuthority");
        j.g(str6, "nationality");
        j.g(uri, "imagePreview");
        this.f27019a = str;
        this.f27020b = date;
        this.f27021c = date2;
        this.f27022d = str2;
        this.f27023e = str3;
        this.f27024f = str4;
        this.f27025g = str5;
        this.f27026h = str6;
        this.f27027j = str7;
        this.f27028k = uri;
    }

    public final Date a() {
        return this.f27020b;
    }

    public final Date c() {
        return this.f27021c;
    }

    public final String d() {
        return this.f27022d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f27024f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassportInfo)) {
            return false;
        }
        PassportInfo passportInfo = (PassportInfo) obj;
        return j.b(this.f27019a, passportInfo.f27019a) && j.b(this.f27020b, passportInfo.f27020b) && j.b(this.f27021c, passportInfo.f27021c) && j.b(this.f27022d, passportInfo.f27022d) && j.b(this.f27023e, passportInfo.f27023e) && j.b(this.f27024f, passportInfo.f27024f) && j.b(this.f27025g, passportInfo.f27025g) && j.b(this.f27026h, passportInfo.f27026h) && j.b(this.f27027j, passportInfo.f27027j) && j.b(this.f27028k, passportInfo.f27028k);
    }

    public final Uri f() {
        return this.f27028k;
    }

    public final String g() {
        return this.f27025g;
    }

    public final String h() {
        return this.f27023e;
    }

    public int hashCode() {
        int hashCode = this.f27019a.hashCode() * 31;
        Date date = this.f27020b;
        int i10 = 0;
        int hashCode2 = (hashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.f27021c;
        int hashCode3 = (((((hashCode2 + (date2 == null ? 0 : date2.hashCode())) * 31) + this.f27022d.hashCode()) * 31) + this.f27023e.hashCode()) * 31;
        String str = this.f27024f;
        int hashCode4 = (((((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.f27025g.hashCode()) * 31) + this.f27026h.hashCode()) * 31;
        String str2 = this.f27027j;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return ((hashCode4 + i10) * 31) + this.f27028k.hashCode();
    }

    public final String i() {
        return this.f27026h;
    }

    public final String j() {
        return this.f27019a;
    }

    public final String k() {
        return this.f27027j;
    }

    public String toString() {
        return "PassportInfo(passportNumber=" + this.f27019a + ", dob=" + this.f27020b + ", exp=" + this.f27021c + ", firstName=" + this.f27022d + ", lastName=" + this.f27023e + ", gender=" + this.f27024f + ", issuingAuthority=" + this.f27025g + ", nationality=" + this.f27026h + ", residenceAddress=" + this.f27027j + ", imagePreview=" + this.f27028k + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f27019a);
        parcel.writeSerializable(this.f27020b);
        parcel.writeSerializable(this.f27021c);
        parcel.writeString(this.f27022d);
        parcel.writeString(this.f27023e);
        parcel.writeString(this.f27024f);
        parcel.writeString(this.f27025g);
        parcel.writeString(this.f27026h);
        parcel.writeString(this.f27027j);
        parcel.writeParcelable(this.f27028k, i10);
    }
}
