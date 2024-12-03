package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$SelfieStepImageLocalStyleContainer implements Parcelable {
    public static final Parcelable.Creator<StepStyles$SelfieStepImageLocalStyleContainer> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final LocalImageComponentStyle f28962a;

    public static final class a implements Parcelable.Creator<StepStyles$SelfieStepImageLocalStyleContainer> {
        /* renamed from: a */
        public final StepStyles$SelfieStepImageLocalStyleContainer createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$SelfieStepImageLocalStyleContainer(parcel.readInt() == 0 ? null : LocalImageComponentStyle.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$SelfieStepImageLocalStyleContainer[] newArray(int i10) {
            return new StepStyles$SelfieStepImageLocalStyleContainer[i10];
        }
    }

    public StepStyles$SelfieStepImageLocalStyleContainer(LocalImageComponentStyle localImageComponentStyle) {
        this.f28962a = localImageComponentStyle;
    }

    public final LocalImageComponentStyle a() {
        return this.f28962a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        LocalImageComponentStyle localImageComponentStyle = this.f28962a;
        if (localImageComponentStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        localImageComponentStyle.writeToParcel(parcel, i10);
    }
}
