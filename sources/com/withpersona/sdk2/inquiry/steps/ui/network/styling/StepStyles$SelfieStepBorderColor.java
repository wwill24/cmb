package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$SelfieStepBorderColor implements Parcelable {
    public static final Parcelable.Creator<StepStyles$SelfieStepBorderColor> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28956a;

    public static final class a implements Parcelable.Creator<StepStyles$SelfieStepBorderColor> {
        /* renamed from: a */
        public final StepStyles$SelfieStepBorderColor createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$SelfieStepBorderColor(parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$SelfieStepBorderColor[] newArray(int i10) {
            return new StepStyles$SelfieStepBorderColor[i10];
        }
    }

    public StepStyles$SelfieStepBorderColor(StyleElements.SimpleElementColor simpleElementColor) {
        this.f28956a = simpleElementColor;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28956a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28956a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
