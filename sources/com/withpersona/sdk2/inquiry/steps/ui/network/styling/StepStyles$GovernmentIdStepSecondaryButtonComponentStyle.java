package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$GovernmentIdStepSecondaryButtonComponentStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$GovernmentIdStepSecondaryButtonComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepCancelButtonComponentStyleContainer f28929a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$StepCancelButtonComponentStyleContainer f28930b;

    public static final class a implements Parcelable.Creator<StepStyles$GovernmentIdStepSecondaryButtonComponentStyle> {
        /* renamed from: a */
        public final StepStyles$GovernmentIdStepSecondaryButtonComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer = null;
            StepStyles$StepCancelButtonComponentStyleContainer createFromParcel = parcel.readInt() == 0 ? null : StepStyles$StepCancelButtonComponentStyleContainer.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                stepStyles$StepCancelButtonComponentStyleContainer = StepStyles$StepCancelButtonComponentStyleContainer.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$GovernmentIdStepSecondaryButtonComponentStyle(createFromParcel, stepStyles$StepCancelButtonComponentStyleContainer);
        }

        /* renamed from: b */
        public final StepStyles$GovernmentIdStepSecondaryButtonComponentStyle[] newArray(int i10) {
            return new StepStyles$GovernmentIdStepSecondaryButtonComponentStyle[i10];
        }
    }

    public StepStyles$GovernmentIdStepSecondaryButtonComponentStyle(StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer, StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer2) {
        this.f28929a = stepStyles$StepCancelButtonComponentStyleContainer;
        this.f28930b = stepStyles$StepCancelButtonComponentStyleContainer2;
    }

    public final StepStyles$StepCancelButtonComponentStyleContainer a() {
        return this.f28929a;
    }

    public final StepStyles$StepCancelButtonComponentStyleContainer c() {
        return this.f28930b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer = this.f28929a;
        if (stepStyles$StepCancelButtonComponentStyleContainer == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepCancelButtonComponentStyleContainer.writeToParcel(parcel, i10);
        }
        StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer2 = this.f28930b;
        if (stepStyles$StepCancelButtonComponentStyleContainer2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepCancelButtonComponentStyleContainer2.writeToParcel(parcel, i10);
    }
}
