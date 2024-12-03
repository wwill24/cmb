package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$GovernmentIdStepPrimaryButtonComponentStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$GovernmentIdStepPrimaryButtonComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepSubmitButtonComponentStyleContainer f28926a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$StepSubmitButtonComponentStyleContainer f28927b;

    public static final class a implements Parcelable.Creator<StepStyles$GovernmentIdStepPrimaryButtonComponentStyle> {
        /* renamed from: a */
        public final StepStyles$GovernmentIdStepPrimaryButtonComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer = null;
            StepStyles$StepSubmitButtonComponentStyleContainer createFromParcel = parcel.readInt() == 0 ? null : StepStyles$StepSubmitButtonComponentStyleContainer.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                stepStyles$StepSubmitButtonComponentStyleContainer = StepStyles$StepSubmitButtonComponentStyleContainer.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$GovernmentIdStepPrimaryButtonComponentStyle(createFromParcel, stepStyles$StepSubmitButtonComponentStyleContainer);
        }

        /* renamed from: b */
        public final StepStyles$GovernmentIdStepPrimaryButtonComponentStyle[] newArray(int i10) {
            return new StepStyles$GovernmentIdStepPrimaryButtonComponentStyle[i10];
        }
    }

    public StepStyles$GovernmentIdStepPrimaryButtonComponentStyle(StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer, StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer2) {
        this.f28926a = stepStyles$StepSubmitButtonComponentStyleContainer;
        this.f28927b = stepStyles$StepSubmitButtonComponentStyleContainer2;
    }

    public final StepStyles$StepSubmitButtonComponentStyleContainer a() {
        return this.f28926a;
    }

    public final StepStyles$StepSubmitButtonComponentStyleContainer c() {
        return this.f28927b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer = this.f28926a;
        if (stepStyles$StepSubmitButtonComponentStyleContainer == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepSubmitButtonComponentStyleContainer.writeToParcel(parcel, i10);
        }
        StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer2 = this.f28927b;
        if (stepStyles$StepSubmitButtonComponentStyleContainer2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepSubmitButtonComponentStyleContainer2.writeToParcel(parcel, i10);
    }
}
