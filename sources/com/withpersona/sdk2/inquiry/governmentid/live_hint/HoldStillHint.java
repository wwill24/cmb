package com.withpersona.sdk2.inquiry.governmentid.live_hint;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;

public final class HoldStillHint implements Hint {
    public static final Parcelable.Creator<HoldStillHint> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public static final HoldStillHint f25797a = new HoldStillHint();

    public static final class a implements Parcelable.Creator<HoldStillHint> {
        /* renamed from: a */
        public final HoldStillHint createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            parcel.readInt();
            return HoldStillHint.f25797a;
        }

        /* renamed from: b */
        public final HoldStillHint[] newArray(int i10) {
            return new HoldStillHint[i10];
        }
    }

    private HoldStillHint() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeInt(1);
    }
}
