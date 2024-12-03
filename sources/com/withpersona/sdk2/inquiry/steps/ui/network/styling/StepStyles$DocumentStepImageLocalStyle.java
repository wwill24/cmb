package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$DocumentStepImageLocalStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$DocumentStepImageLocalStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$DocumentStepImageLocalStyleContainer f28888a;

    public static final class a implements Parcelable.Creator<StepStyles$DocumentStepImageLocalStyle> {
        /* renamed from: a */
        public final StepStyles$DocumentStepImageLocalStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$DocumentStepImageLocalStyle(parcel.readInt() == 0 ? null : StepStyles$DocumentStepImageLocalStyleContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$DocumentStepImageLocalStyle[] newArray(int i10) {
            return new StepStyles$DocumentStepImageLocalStyle[i10];
        }
    }

    public StepStyles$DocumentStepImageLocalStyle(StepStyles$DocumentStepImageLocalStyleContainer stepStyles$DocumentStepImageLocalStyleContainer) {
        this.f28888a = stepStyles$DocumentStepImageLocalStyleContainer;
    }

    public final StepStyles$DocumentStepImageLocalStyleContainer a() {
        return this.f28888a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$DocumentStepImageLocalStyleContainer stepStyles$DocumentStepImageLocalStyleContainer = this.f28888a;
        if (stepStyles$DocumentStepImageLocalStyleContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$DocumentStepImageLocalStyleContainer.writeToParcel(parcel, i10);
    }
}
