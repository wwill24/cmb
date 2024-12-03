package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcScanCompletePage;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcScanReadyPage;
import kotlin.jvm.internal.j;

public final class GovernmentIdPages implements Parcelable {
    public static final Parcelable.Creator<GovernmentIdPages> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final PassportNfcStartPage f25367a;

    /* renamed from: b  reason: collision with root package name */
    private final PassportNfcVerifyDetailsPage f25368b;

    /* renamed from: c  reason: collision with root package name */
    private final PassportNfcScanPage f25369c;

    /* renamed from: d  reason: collision with root package name */
    private final PassportNfcPromptPage f25370d;

    /* renamed from: e  reason: collision with root package name */
    private final PassportNfcScanReadyPage f25371e;

    /* renamed from: f  reason: collision with root package name */
    private final PassportNfcScanCompletePage f25372f;

    /* renamed from: g  reason: collision with root package name */
    private final PassportNfcConfirmDetailsPage f25373g;

    /* renamed from: h  reason: collision with root package name */
    private final PassportNfcNfcNotSupportedPage f25374h;

    /* renamed from: j  reason: collision with root package name */
    private final PassportNfcModuleMissingPage f25375j;

    public static final class a implements Parcelable.Creator<GovernmentIdPages> {
        /* renamed from: a */
        public final GovernmentIdPages createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            PassportNfcModuleMissingPage passportNfcModuleMissingPage = null;
            PassportNfcStartPage createFromParcel = parcel.readInt() == 0 ? null : PassportNfcStartPage.CREATOR.createFromParcel(parcel);
            PassportNfcVerifyDetailsPage createFromParcel2 = parcel.readInt() == 0 ? null : PassportNfcVerifyDetailsPage.CREATOR.createFromParcel(parcel);
            PassportNfcScanPage createFromParcel3 = parcel.readInt() == 0 ? null : PassportNfcScanPage.CREATOR.createFromParcel(parcel);
            PassportNfcPromptPage createFromParcel4 = parcel.readInt() == 0 ? null : PassportNfcPromptPage.CREATOR.createFromParcel(parcel);
            PassportNfcScanReadyPage passportNfcScanReadyPage = (PassportNfcScanReadyPage) parcel.readParcelable(GovernmentIdPages.class.getClassLoader());
            PassportNfcScanCompletePage passportNfcScanCompletePage = (PassportNfcScanCompletePage) parcel.readParcelable(GovernmentIdPages.class.getClassLoader());
            PassportNfcConfirmDetailsPage createFromParcel5 = parcel.readInt() == 0 ? null : PassportNfcConfirmDetailsPage.CREATOR.createFromParcel(parcel);
            PassportNfcNfcNotSupportedPage createFromParcel6 = parcel.readInt() == 0 ? null : PassportNfcNfcNotSupportedPage.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                passportNfcModuleMissingPage = PassportNfcModuleMissingPage.CREATOR.createFromParcel(parcel);
            }
            return new GovernmentIdPages(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, passportNfcScanReadyPage, passportNfcScanCompletePage, createFromParcel5, createFromParcel6, passportNfcModuleMissingPage);
        }

        /* renamed from: b */
        public final GovernmentIdPages[] newArray(int i10) {
            return new GovernmentIdPages[i10];
        }
    }

    public GovernmentIdPages(PassportNfcStartPage passportNfcStartPage, PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage, PassportNfcScanPage passportNfcScanPage, PassportNfcPromptPage passportNfcPromptPage, PassportNfcScanReadyPage passportNfcScanReadyPage, PassportNfcScanCompletePage passportNfcScanCompletePage, PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage, PassportNfcNfcNotSupportedPage passportNfcNfcNotSupportedPage, PassportNfcModuleMissingPage passportNfcModuleMissingPage) {
        this.f25367a = passportNfcStartPage;
        this.f25368b = passportNfcVerifyDetailsPage;
        this.f25369c = passportNfcScanPage;
        this.f25370d = passportNfcPromptPage;
        this.f25371e = passportNfcScanReadyPage;
        this.f25372f = passportNfcScanCompletePage;
        this.f25373g = passportNfcConfirmDetailsPage;
        this.f25374h = passportNfcNfcNotSupportedPage;
        this.f25375j = passportNfcModuleMissingPage;
    }

    public final PassportNfcConfirmDetailsPage a() {
        return this.f25373g;
    }

    public final PassportNfcModuleMissingPage c() {
        return this.f25375j;
    }

    public final PassportNfcNfcNotSupportedPage d() {
        return this.f25374h;
    }

    public int describeContents() {
        return 0;
    }

    public final PassportNfcPromptPage e() {
        return this.f25370d;
    }

    public final PassportNfcScanCompletePage f() {
        return this.f25372f;
    }

    public final PassportNfcScanPage g() {
        return this.f25369c;
    }

    public final PassportNfcScanReadyPage h() {
        return this.f25371e;
    }

    public final PassportNfcStartPage i() {
        return this.f25367a;
    }

    public final PassportNfcVerifyDetailsPage j() {
        return this.f25368b;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        PassportNfcStartPage passportNfcStartPage = this.f25367a;
        if (passportNfcStartPage == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            passportNfcStartPage.writeToParcel(parcel, i10);
        }
        PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage = this.f25368b;
        if (passportNfcVerifyDetailsPage == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            passportNfcVerifyDetailsPage.writeToParcel(parcel, i10);
        }
        PassportNfcScanPage passportNfcScanPage = this.f25369c;
        if (passportNfcScanPage == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            passportNfcScanPage.writeToParcel(parcel, i10);
        }
        PassportNfcPromptPage passportNfcPromptPage = this.f25370d;
        if (passportNfcPromptPage == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            passportNfcPromptPage.writeToParcel(parcel, i10);
        }
        parcel.writeParcelable(this.f25371e, i10);
        parcel.writeParcelable(this.f25372f, i10);
        PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage = this.f25373g;
        if (passportNfcConfirmDetailsPage == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            passportNfcConfirmDetailsPage.writeToParcel(parcel, i10);
        }
        PassportNfcNfcNotSupportedPage passportNfcNfcNotSupportedPage = this.f25374h;
        if (passportNfcNfcNotSupportedPage == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            passportNfcNfcNotSupportedPage.writeToParcel(parcel, i10);
        }
        PassportNfcModuleMissingPage passportNfcModuleMissingPage = this.f25375j;
        if (passportNfcModuleMissingPage == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        passportNfcModuleMissingPage.writeToParcel(parcel, i10);
    }
}
