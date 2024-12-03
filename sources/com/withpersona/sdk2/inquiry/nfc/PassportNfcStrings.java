package com.withpersona.sdk2.inquiry.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class PassportNfcStrings implements Parcelable {
    public static final Parcelable.Creator<PassportNfcStrings> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f27049a;

    /* renamed from: b  reason: collision with root package name */
    private final String f27050b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27051c;

    /* renamed from: d  reason: collision with root package name */
    private final String f27052d;

    /* renamed from: e  reason: collision with root package name */
    private final String f27053e;

    /* renamed from: f  reason: collision with root package name */
    private final String f27054f;

    /* renamed from: g  reason: collision with root package name */
    private final String f27055g;

    /* renamed from: h  reason: collision with root package name */
    private final String f27056h;

    /* renamed from: j  reason: collision with root package name */
    private final String f27057j;

    public static final class a implements Parcelable.Creator<PassportNfcStrings> {
        /* renamed from: a */
        public final PassportNfcStrings createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportNfcStrings(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final PassportNfcStrings[] newArray(int i10) {
            return new PassportNfcStrings[i10];
        }
    }

    public PassportNfcStrings(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        j.g(str, "enablePassportNfcText");
        j.g(str2, "enablePassportNfcConfirmButtonText");
        j.g(str3, "enablePassportNfcCancelButtonText");
        j.g(str4, "connectionLostText");
        j.g(str5, "connectionLostConfirmButtonText");
        j.g(str6, "authenticationErrorText");
        j.g(str7, "authenticationErrorConfirmButtonText");
        j.g(str8, "genericErrorText");
        j.g(str9, "genericErrorConfirmButtonText");
        this.f27049a = str;
        this.f27050b = str2;
        this.f27051c = str3;
        this.f27052d = str4;
        this.f27053e = str5;
        this.f27054f = str6;
        this.f27055g = str7;
        this.f27056h = str8;
        this.f27057j = str9;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassportNfcStrings)) {
            return false;
        }
        PassportNfcStrings passportNfcStrings = (PassportNfcStrings) obj;
        return j.b(this.f27049a, passportNfcStrings.f27049a) && j.b(this.f27050b, passportNfcStrings.f27050b) && j.b(this.f27051c, passportNfcStrings.f27051c) && j.b(this.f27052d, passportNfcStrings.f27052d) && j.b(this.f27053e, passportNfcStrings.f27053e) && j.b(this.f27054f, passportNfcStrings.f27054f) && j.b(this.f27055g, passportNfcStrings.f27055g) && j.b(this.f27056h, passportNfcStrings.f27056h) && j.b(this.f27057j, passportNfcStrings.f27057j);
    }

    public int hashCode() {
        return (((((((((((((((this.f27049a.hashCode() * 31) + this.f27050b.hashCode()) * 31) + this.f27051c.hashCode()) * 31) + this.f27052d.hashCode()) * 31) + this.f27053e.hashCode()) * 31) + this.f27054f.hashCode()) * 31) + this.f27055g.hashCode()) * 31) + this.f27056h.hashCode()) * 31) + this.f27057j.hashCode();
    }

    public String toString() {
        return "PassportNfcStrings(enablePassportNfcText=" + this.f27049a + ", enablePassportNfcConfirmButtonText=" + this.f27050b + ", enablePassportNfcCancelButtonText=" + this.f27051c + ", connectionLostText=" + this.f27052d + ", connectionLostConfirmButtonText=" + this.f27053e + ", authenticationErrorText=" + this.f27054f + ", authenticationErrorConfirmButtonText=" + this.f27055g + ", genericErrorText=" + this.f27056h + ", genericErrorConfirmButtonText=" + this.f27057j + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f27049a);
        parcel.writeString(this.f27050b);
        parcel.writeString(this.f27051c);
        parcel.writeString(this.f27052d);
        parcel.writeString(this.f27053e);
        parcel.writeString(this.f27054f);
        parcel.writeString(this.f27055g);
        parcel.writeString(this.f27056h);
        parcel.writeString(this.f27057j);
    }
}
