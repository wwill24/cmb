package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$SelfieStepImageLocalStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$SelfieStepImageLocalStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$SelfieStepImageLocalStyleContainer f28961a;

    public static final class a implements Parcelable.Creator<StepStyles$SelfieStepImageLocalStyle> {
        /* renamed from: a */
        public final StepStyles$SelfieStepImageLocalStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$SelfieStepImageLocalStyle(parcel.readInt() == 0 ? null : StepStyles$SelfieStepImageLocalStyleContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$SelfieStepImageLocalStyle[] newArray(int i10) {
            return new StepStyles$SelfieStepImageLocalStyle[i10];
        }
    }

    public StepStyles$SelfieStepImageLocalStyle(StepStyles$SelfieStepImageLocalStyleContainer stepStyles$SelfieStepImageLocalStyleContainer) {
        this.f28961a = stepStyles$SelfieStepImageLocalStyleContainer;
    }

    public final StepStyles$SelfieStepImageLocalStyleContainer a() {
        return this.f28961a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$SelfieStepImageLocalStyleContainer stepStyles$SelfieStepImageLocalStyleContainer = this.f28961a;
        if (stepStyles$SelfieStepImageLocalStyleContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$SelfieStepImageLocalStyleContainer.writeToParcel(parcel, i10);
    }
}
