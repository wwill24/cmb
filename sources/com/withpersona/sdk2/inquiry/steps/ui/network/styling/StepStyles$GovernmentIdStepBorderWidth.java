package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$GovernmentIdStepBorderWidth implements Parcelable {
    public static final Parcelable.Creator<StepStyles$GovernmentIdStepBorderWidth> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28920a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28921b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28922c;

    public static final class a implements Parcelable.Creator<StepStyles$GovernmentIdStepBorderWidth> {
        /* renamed from: a */
        public final StepStyles$GovernmentIdStepBorderWidth createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.DPMeasurementSet dPMeasurementSet = null;
            StyleElements.DPMeasurementSet createFromParcel = parcel.readInt() == 0 ? null : StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel);
            StyleElements.DPMeasurementSet createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                dPMeasurementSet = StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$GovernmentIdStepBorderWidth(createFromParcel, createFromParcel2, dPMeasurementSet);
        }

        /* renamed from: b */
        public final StepStyles$GovernmentIdStepBorderWidth[] newArray(int i10) {
            return new StepStyles$GovernmentIdStepBorderWidth[i10];
        }
    }

    public StepStyles$GovernmentIdStepBorderWidth(StyleElements.DPMeasurementSet dPMeasurementSet, StyleElements.DPMeasurementSet dPMeasurementSet2, StyleElements.DPMeasurementSet dPMeasurementSet3) {
        this.f28920a = dPMeasurementSet;
        this.f28921b = dPMeasurementSet2;
        this.f28922c = dPMeasurementSet3;
    }

    public final StyleElements.DPMeasurementSet a() {
        return this.f28921b;
    }

    public final StyleElements.DPMeasurementSet c() {
        return this.f28922c;
    }

    public final StyleElements.DPMeasurementSet d() {
        return this.f28920a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurementSet dPMeasurementSet = this.f28920a;
        if (dPMeasurementSet == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurementSet.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurementSet dPMeasurementSet2 = this.f28921b;
        if (dPMeasurementSet2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurementSet2.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurementSet dPMeasurementSet3 = this.f28922c;
        if (dPMeasurementSet3 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurementSet3.writeToParcel(parcel, i10);
    }
}
