package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$GovernmentIdStepRowHeight implements Parcelable {
    public static final Parcelable.Creator<StepStyles$GovernmentIdStepRowHeight> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28928a;

    public static final class a implements Parcelable.Creator<StepStyles$GovernmentIdStepRowHeight> {
        /* renamed from: a */
        public final StepStyles$GovernmentIdStepRowHeight createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$GovernmentIdStepRowHeight(parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$GovernmentIdStepRowHeight[] newArray(int i10) {
            return new StepStyles$GovernmentIdStepRowHeight[i10];
        }
    }

    public StepStyles$GovernmentIdStepRowHeight(StyleElements.DPMeasurement dPMeasurement) {
        this.f28928a = dPMeasurement;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28928a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28928a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement.writeToParcel(parcel, i10);
    }
}
