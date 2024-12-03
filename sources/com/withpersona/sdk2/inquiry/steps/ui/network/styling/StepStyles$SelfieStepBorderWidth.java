package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$SelfieStepBorderWidth implements Parcelable {
    public static final Parcelable.Creator<StepStyles$SelfieStepBorderWidth> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28957a;

    public static final class a implements Parcelable.Creator<StepStyles$SelfieStepBorderWidth> {
        /* renamed from: a */
        public final StepStyles$SelfieStepBorderWidth createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$SelfieStepBorderWidth(parcel.readInt() == 0 ? null : StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$SelfieStepBorderWidth[] newArray(int i10) {
            return new StepStyles$SelfieStepBorderWidth[i10];
        }
    }

    public StepStyles$SelfieStepBorderWidth(StyleElements.DPMeasurementSet dPMeasurementSet) {
        this.f28957a = dPMeasurementSet;
    }

    public final StyleElements.DPMeasurementSet a() {
        return this.f28957a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurementSet dPMeasurementSet = this.f28957a;
        if (dPMeasurementSet == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurementSet.writeToParcel(parcel, i10);
    }
}
