package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$SelfieStepFillColor implements Parcelable {
    public static final Parcelable.Creator<StepStyles$SelfieStepFillColor> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28958a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28959b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28960c;

    public static final class a implements Parcelable.Creator<StepStyles$SelfieStepFillColor> {
        /* renamed from: a */
        public final StepStyles$SelfieStepFillColor createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.SimpleElementColor simpleElementColor = null;
            StyleElements.SimpleElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.SimpleElementColor createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                simpleElementColor = StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$SelfieStepFillColor(createFromParcel, createFromParcel2, simpleElementColor);
        }

        /* renamed from: b */
        public final StepStyles$SelfieStepFillColor[] newArray(int i10) {
            return new StepStyles$SelfieStepFillColor[i10];
        }
    }

    public StepStyles$SelfieStepFillColor(StyleElements.SimpleElementColor simpleElementColor, StyleElements.SimpleElementColor simpleElementColor2, StyleElements.SimpleElementColor simpleElementColor3) {
        this.f28958a = simpleElementColor;
        this.f28959b = simpleElementColor2;
        this.f28960c = simpleElementColor3;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28958a;
    }

    public final StyleElements.SimpleElementColor c() {
        return this.f28960c;
    }

    public final StyleElements.SimpleElementColor d() {
        return this.f28959b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28958a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor2 = this.f28959b;
        if (simpleElementColor2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor2.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor3 = this.f28960c;
        if (simpleElementColor3 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor3.writeToParcel(parcel, i10);
    }
}
