package com.withpersona.sdk2.inquiry.governmentid.live_hint;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;

public final class LowLightHint implements Hint {
    public static final Parcelable.Creator<LowLightHint> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public static final LowLightHint f25798a = new LowLightHint();

    public static final class a implements Parcelable.Creator<LowLightHint> {
        /* renamed from: a */
        public final LowLightHint createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            parcel.readInt();
            return LowLightHint.f25798a;
        }

        /* renamed from: b */
        public final LowLightHint[] newArray(int i10) {
            return new LowLightHint[i10];
        }
    }

    private LowLightHint() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeInt(1);
    }
}
