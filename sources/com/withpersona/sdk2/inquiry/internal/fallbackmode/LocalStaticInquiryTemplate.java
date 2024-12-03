package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;

public final class LocalStaticInquiryTemplate implements StaticInquiryTemplate {
    public static final Parcelable.Creator<LocalStaticInquiryTemplate> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f26362a;

    public static final class a implements Parcelable.Creator<LocalStaticInquiryTemplate> {
        /* renamed from: a */
        public final LocalStaticInquiryTemplate createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new LocalStaticInquiryTemplate(parcel.readInt());
        }

        /* renamed from: b */
        public final LocalStaticInquiryTemplate[] newArray(int i10) {
            return new LocalStaticInquiryTemplate[i10];
        }
    }

    public LocalStaticInquiryTemplate(int i10) {
        this.f26362a = i10;
    }

    public final int a() {
        return this.f26362a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeInt(this.f26362a);
    }
}
