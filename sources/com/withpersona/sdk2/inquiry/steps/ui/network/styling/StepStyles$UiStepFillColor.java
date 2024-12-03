package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$UiStepFillColor implements Parcelable {
    public static final Parcelable.Creator<StepStyles$UiStepFillColor> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f29000a;

    public static final class a implements Parcelable.Creator<StepStyles$UiStepFillColor> {
        /* renamed from: a */
        public final StepStyles$UiStepFillColor createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$UiStepFillColor(parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$UiStepFillColor[] newArray(int i10) {
            return new StepStyles$UiStepFillColor[i10];
        }
    }

    public StepStyles$UiStepFillColor(StyleElements.SimpleElementColor simpleElementColor) {
        this.f29000a = simpleElementColor;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f29000a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f29000a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
