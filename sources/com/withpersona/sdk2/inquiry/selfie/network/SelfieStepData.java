package com.withpersona.sdk2.inquiry.selfie.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import com.withpersona.sdk2.inquiry.shared.data_collection.StepData;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class SelfieStepData implements StepData {
    public static final Parcelable.Creator<SelfieStepData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f27409a;

    /* renamed from: b  reason: collision with root package name */
    private final Selfie f27410b;

    /* renamed from: c  reason: collision with root package name */
    private final Selfie f27411c;

    /* renamed from: d  reason: collision with root package name */
    private final Selfie f27412d;

    public static final class a implements Parcelable.Creator<SelfieStepData> {
        /* renamed from: a */
        public final SelfieStepData createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new SelfieStepData(parcel.readString(), (Selfie) parcel.readParcelable(SelfieStepData.class.getClassLoader()), (Selfie) parcel.readParcelable(SelfieStepData.class.getClassLoader()), (Selfie) parcel.readParcelable(SelfieStepData.class.getClassLoader()));
        }

        /* renamed from: b */
        public final SelfieStepData[] newArray(int i10) {
            return new SelfieStepData[i10];
        }
    }

    public SelfieStepData(String str, Selfie selfie, Selfie selfie2, Selfie selfie3) {
        j.g(str, "stepName");
        this.f27409a = str;
        this.f27410b = selfie;
        this.f27411c = selfie2;
        this.f27412d = selfie3;
    }

    public final Selfie a() {
        return this.f27410b;
    }

    public String c() {
        return this.f27409a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelfieStepData)) {
            return false;
        }
        SelfieStepData selfieStepData = (SelfieStepData) obj;
        return j.b(c(), selfieStepData.c()) && j.b(this.f27410b, selfieStepData.f27410b) && j.b(this.f27411c, selfieStepData.f27411c) && j.b(this.f27412d, selfieStepData.f27412d);
    }

    public int hashCode() {
        int hashCode = c().hashCode() * 31;
        Selfie selfie = this.f27410b;
        int i10 = 0;
        int hashCode2 = (hashCode + (selfie == null ? 0 : selfie.hashCode())) * 31;
        Selfie selfie2 = this.f27411c;
        int hashCode3 = (hashCode2 + (selfie2 == null ? 0 : selfie2.hashCode())) * 31;
        Selfie selfie3 = this.f27412d;
        if (selfie3 != null) {
            i10 = selfie3.hashCode();
        }
        return hashCode3 + i10;
    }

    public String toString() {
        return "SelfieStepData(stepName=" + c() + ", centerCapture=" + this.f27410b + ", leftCapture=" + this.f27411c + ", rightCapture=" + this.f27412d + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f27409a);
        parcel.writeParcelable(this.f27410b, i10);
        parcel.writeParcelable(this.f27411c, i10);
        parcel.writeParcelable(this.f27412d, i10);
    }
}
