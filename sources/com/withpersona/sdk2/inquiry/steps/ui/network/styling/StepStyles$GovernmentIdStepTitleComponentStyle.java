package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$GovernmentIdStepTitleComponentStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$GovernmentIdStepTitleComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f28954a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f28955b;

    public static final class a implements Parcelable.Creator<StepStyles$GovernmentIdStepTitleComponentStyle> {
        /* renamed from: a */
        public final StepStyles$GovernmentIdStepTitleComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = null;
            StepStyles$StepTextBasedComponentStyleContainer createFromParcel = parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                stepStyles$StepTextBasedComponentStyleContainer = StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$GovernmentIdStepTitleComponentStyle(createFromParcel, stepStyles$StepTextBasedComponentStyleContainer);
        }

        /* renamed from: b */
        public final StepStyles$GovernmentIdStepTitleComponentStyle[] newArray(int i10) {
            return new StepStyles$GovernmentIdStepTitleComponentStyle[i10];
        }
    }

    public StepStyles$GovernmentIdStepTitleComponentStyle(StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer, StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2) {
        this.f28954a = stepStyles$StepTextBasedComponentStyleContainer;
        this.f28955b = stepStyles$StepTextBasedComponentStyleContainer2;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer a() {
        return this.f28954a;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer c() {
        return this.f28955b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = this.f28954a;
        if (stepStyles$StepTextBasedComponentStyleContainer == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepTextBasedComponentStyleContainer.writeToParcel(parcel, i10);
        }
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2 = this.f28955b;
        if (stepStyles$StepTextBasedComponentStyleContainer2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepTextBasedComponentStyleContainer2.writeToParcel(parcel, i10);
    }
}
