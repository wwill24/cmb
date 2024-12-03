package com.withpersona.sdk2.inquiry.governmentid.network;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class PassportNfcRequestArguments implements Parcelable {
    public static final Parcelable.Creator<PassportNfcRequestArguments> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f25874a;

    /* renamed from: b  reason: collision with root package name */
    private final File f25875b;

    /* renamed from: c  reason: collision with root package name */
    private final File f25876c;

    /* renamed from: d  reason: collision with root package name */
    private final File f25877d;

    public static final class a implements Parcelable.Creator<PassportNfcRequestArguments> {
        /* renamed from: a */
        public final PassportNfcRequestArguments createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportNfcRequestArguments(parcel.readString(), (File) parcel.readSerializable(), (File) parcel.readSerializable(), (File) parcel.readSerializable());
        }

        /* renamed from: b */
        public final PassportNfcRequestArguments[] newArray(int i10) {
            return new PassportNfcRequestArguments[i10];
        }
    }

    public PassportNfcRequestArguments(String str, File file, File file2, File file3) {
        j.g(str, "fieldKeyPassportNfc");
        j.g(file, "dg1File");
        j.g(file2, "dg2File");
        j.g(file3, "sodFile");
        this.f25874a = str;
        this.f25875b = file;
        this.f25876c = file2;
        this.f25877d = file3;
    }

    public final File a() {
        return this.f25875b;
    }

    public final File c() {
        return this.f25876c;
    }

    public final String d() {
        return this.f25874a;
    }

    public int describeContents() {
        return 0;
    }

    public final File e() {
        return this.f25877d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassportNfcRequestArguments)) {
            return false;
        }
        PassportNfcRequestArguments passportNfcRequestArguments = (PassportNfcRequestArguments) obj;
        return j.b(this.f25874a, passportNfcRequestArguments.f25874a) && j.b(this.f25875b, passportNfcRequestArguments.f25875b) && j.b(this.f25876c, passportNfcRequestArguments.f25876c) && j.b(this.f25877d, passportNfcRequestArguments.f25877d);
    }

    public int hashCode() {
        return (((((this.f25874a.hashCode() * 31) + this.f25875b.hashCode()) * 31) + this.f25876c.hashCode()) * 31) + this.f25877d.hashCode();
    }

    public String toString() {
        return "PassportNfcRequestArguments(fieldKeyPassportNfc=" + this.f25874a + ", dg1File=" + this.f25875b + ", dg2File=" + this.f25876c + ", sodFile=" + this.f25877d + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f25874a);
        parcel.writeSerializable(this.f25875b);
        parcel.writeSerializable(this.f25876c);
        parcel.writeSerializable(this.f25877d);
    }
}
