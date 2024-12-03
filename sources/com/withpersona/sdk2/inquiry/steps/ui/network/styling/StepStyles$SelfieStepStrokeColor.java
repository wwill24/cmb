package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$SelfieStepStrokeColor implements Parcelable {
    public static final Parcelable.Creator<StepStyles$SelfieStepStrokeColor> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28963a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28964b;

    public static final class a implements Parcelable.Creator<StepStyles$SelfieStepStrokeColor> {
        /* renamed from: a */
        public final StepStyles$SelfieStepStrokeColor createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.SimpleElementColor simpleElementColor = null;
            StyleElements.SimpleElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                simpleElementColor = StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$SelfieStepStrokeColor(createFromParcel, simpleElementColor);
        }

        /* renamed from: b */
        public final StepStyles$SelfieStepStrokeColor[] newArray(int i10) {
            return new StepStyles$SelfieStepStrokeColor[i10];
        }
    }

    public StepStyles$SelfieStepStrokeColor(StyleElements.SimpleElementColor simpleElementColor, StyleElements.SimpleElementColor simpleElementColor2) {
        this.f28963a = simpleElementColor;
        this.f28964b = simpleElementColor2;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28963a;
    }

    public final StyleElements.SimpleElementColor c() {
        return this.f28964b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28963a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor2 = this.f28964b;
        if (simpleElementColor2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor2.writeToParcel(parcel, i10);
    }
}
