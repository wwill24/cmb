package com.withpersona.sdk2.inquiry.governmentid.nfc;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class PassportNfcData implements Parcelable {
    public static final Parcelable.Creator<PassportNfcData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Uri f25927a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f25928b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f25929c;

    public static final class a implements Parcelable.Creator<PassportNfcData> {
        /* renamed from: a */
        public final PassportNfcData createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportNfcData((Uri) parcel.readParcelable(PassportNfcData.class.getClassLoader()), (Uri) parcel.readParcelable(PassportNfcData.class.getClassLoader()), (Uri) parcel.readParcelable(PassportNfcData.class.getClassLoader()));
        }

        /* renamed from: b */
        public final PassportNfcData[] newArray(int i10) {
            return new PassportNfcData[i10];
        }
    }

    public PassportNfcData(Uri uri, Uri uri2, Uri uri3) {
        j.g(uri, "dg1Uri");
        j.g(uri2, "dg2Uri");
        j.g(uri3, "sodUri");
        this.f25927a = uri;
        this.f25928b = uri2;
        this.f25929c = uri3;
    }

    public final Uri a() {
        return this.f25927a;
    }

    public final Uri c() {
        return this.f25928b;
    }

    public final Uri d() {
        return this.f25929c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassportNfcData)) {
            return false;
        }
        PassportNfcData passportNfcData = (PassportNfcData) obj;
        return j.b(this.f25927a, passportNfcData.f25927a) && j.b(this.f25928b, passportNfcData.f25928b) && j.b(this.f25929c, passportNfcData.f25929c);
    }

    public int hashCode() {
        return (((this.f25927a.hashCode() * 31) + this.f25928b.hashCode()) * 31) + this.f25929c.hashCode();
    }

    public String toString() {
        return "PassportNfcData(dg1Uri=" + this.f25927a + ", dg2Uri=" + this.f25928b + ", sodUri=" + this.f25929c + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeParcelable(this.f25927a, i10);
        parcel.writeParcelable(this.f25928b, i10);
        parcel.writeParcelable(this.f25929c, i10);
    }
}
