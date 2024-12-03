package com.withpersona.sdk2.inquiry.governmentid.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class PassportNfcConfig implements Parcelable {
    public static final Parcelable.Creator<PassportNfcConfig> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f25906a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f25907b;

    /* renamed from: c  reason: collision with root package name */
    private final PassportNfcOption f25908c;

    public enum PassportNfcOption {
        Required,
        Optional,
        RequiredIfSupported
    }

    public static final class a implements Parcelable.Creator<PassportNfcConfig> {
        /* renamed from: a */
        public final PassportNfcConfig createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportNfcConfig(parcel.readString(), parcel.readInt() != 0, PassportNfcOption.valueOf(parcel.readString()));
        }

        /* renamed from: b */
        public final PassportNfcConfig[] newArray(int i10) {
            return new PassportNfcConfig[i10];
        }
    }

    public PassportNfcConfig() {
        this((String) null, false, (PassportNfcOption) null, 7, (DefaultConstructorMarker) null);
    }

    public PassportNfcConfig(String str, boolean z10, PassportNfcOption passportNfcOption) {
        j.g(passportNfcOption, FormField.Required.ELEMENT);
        this.f25906a = str;
        this.f25907b = z10;
        this.f25908c = passportNfcOption;
    }

    public final String a() {
        return this.f25906a;
    }

    public final PassportNfcOption c() {
        return this.f25908c;
    }

    public final boolean d() {
        return this.f25907b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassportNfcConfig)) {
            return false;
        }
        PassportNfcConfig passportNfcConfig = (PassportNfcConfig) obj;
        return j.b(this.f25906a, passportNfcConfig.f25906a) && this.f25907b == passportNfcConfig.f25907b && this.f25908c == passportNfcConfig.f25908c;
    }

    public int hashCode() {
        String str = this.f25906a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z10 = this.f25907b;
        if (z10) {
            z10 = true;
        }
        return ((hashCode + (z10 ? 1 : 0)) * 31) + this.f25908c.hashCode();
    }

    public String toString() {
        return "PassportNfcConfig(fieldKeyNfcPassport=" + this.f25906a + ", skipMrzScanScreen=" + this.f25907b + ", required=" + this.f25908c + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f25906a);
        parcel.writeInt(this.f25907b ? 1 : 0);
        parcel.writeString(this.f25908c.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PassportNfcConfig(String str, boolean z10, PassportNfcOption passportNfcOption, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? PassportNfcOption.Optional : passportNfcOption);
    }
}
