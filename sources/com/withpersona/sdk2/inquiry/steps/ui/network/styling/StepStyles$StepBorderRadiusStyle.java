package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepBorderRadiusStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepBorderRadiusStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28990a;

    public static final class a implements Parcelable.Creator<StepStyles$StepBorderRadiusStyle> {
        /* renamed from: a */
        public final StepStyles$StepBorderRadiusStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepBorderRadiusStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepBorderRadiusStyle[] newArray(int i10) {
            return new StepStyles$StepBorderRadiusStyle[i10];
        }
    }

    public StepStyles$StepBorderRadiusStyle(StyleElements.DPMeasurement dPMeasurement) {
        this.f28990a = dPMeasurement;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28990a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28990a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement.writeToParcel(parcel, i10);
    }
}
