package com.withpersona.sdk2.inquiry.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class PassportNfcReaderConfig implements Parcelable {
    public static final Parcelable.Creator<PassportNfcReaderConfig> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final MrzKey f27029a;

    /* renamed from: b  reason: collision with root package name */
    private final PassportNfcScanReadyPage f27030b;

    /* renamed from: c  reason: collision with root package name */
    private final PassportNfcScanCompletePage f27031c;

    /* renamed from: d  reason: collision with root package name */
    private final PassportNfcStrings f27032d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f27033e;

    public static final class a implements Parcelable.Creator<PassportNfcReaderConfig> {
        /* renamed from: a */
        public final PassportNfcReaderConfig createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PassportNfcReaderConfig(MrzKey.CREATOR.createFromParcel(parcel), PassportNfcScanReadyPage.CREATOR.createFromParcel(parcel), PassportNfcScanCompletePage.CREATOR.createFromParcel(parcel), PassportNfcStrings.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* renamed from: b */
        public final PassportNfcReaderConfig[] newArray(int i10) {
            return new PassportNfcReaderConfig[i10];
        }
    }

    public PassportNfcReaderConfig(MrzKey mrzKey, PassportNfcScanReadyPage passportNfcScanReadyPage, PassportNfcScanCompletePage passportNfcScanCompletePage, PassportNfcStrings passportNfcStrings, Integer num) {
        j.g(mrzKey, "mrzKey");
        j.g(passportNfcScanReadyPage, "scanReadyPage");
        j.g(passportNfcScanCompletePage, "scanCompletePage");
        j.g(passportNfcStrings, "passportNfcStrings");
        this.f27029a = mrzKey;
        this.f27030b = passportNfcScanReadyPage;
        this.f27031c = passportNfcScanCompletePage;
        this.f27032d = passportNfcStrings;
        this.f27033e = num;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassportNfcReaderConfig)) {
            return false;
        }
        PassportNfcReaderConfig passportNfcReaderConfig = (PassportNfcReaderConfig) obj;
        return j.b(this.f27029a, passportNfcReaderConfig.f27029a) && j.b(this.f27030b, passportNfcReaderConfig.f27030b) && j.b(this.f27031c, passportNfcReaderConfig.f27031c) && j.b(this.f27032d, passportNfcReaderConfig.f27032d) && j.b(this.f27033e, passportNfcReaderConfig.f27033e);
    }

    public int hashCode() {
        int hashCode = ((((((this.f27029a.hashCode() * 31) + this.f27030b.hashCode()) * 31) + this.f27031c.hashCode()) * 31) + this.f27032d.hashCode()) * 31;
        Integer num = this.f27033e;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "PassportNfcReaderConfig(mrzKey=" + this.f27029a + ", scanReadyPage=" + this.f27030b + ", scanCompletePage=" + this.f27031c + ", passportNfcStrings=" + this.f27032d + ", theme=" + this.f27033e + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        int i11;
        j.g(parcel, "out");
        this.f27029a.writeToParcel(parcel, i10);
        this.f27030b.writeToParcel(parcel, i10);
        this.f27031c.writeToParcel(parcel, i10);
        this.f27032d.writeToParcel(parcel, i10);
        Integer num = this.f27033e;
        if (num == null) {
            i11 = 0;
        } else {
            parcel.writeInt(1);
            i11 = num.intValue();
        }
        parcel.writeInt(i11);
    }
}
