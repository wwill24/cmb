package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$DocumentStepStrokeColor implements Parcelable {
    public static final Parcelable.Creator<StepStyles$DocumentStepStrokeColor> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28890a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28891b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28892c;

    public static final class a implements Parcelable.Creator<StepStyles$DocumentStepStrokeColor> {
        /* renamed from: a */
        public final StepStyles$DocumentStepStrokeColor createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.SimpleElementColor simpleElementColor = null;
            StyleElements.SimpleElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.SimpleElementColor createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                simpleElementColor = StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$DocumentStepStrokeColor(createFromParcel, createFromParcel2, simpleElementColor);
        }

        /* renamed from: b */
        public final StepStyles$DocumentStepStrokeColor[] newArray(int i10) {
            return new StepStyles$DocumentStepStrokeColor[i10];
        }
    }

    public StepStyles$DocumentStepStrokeColor(StyleElements.SimpleElementColor simpleElementColor, StyleElements.SimpleElementColor simpleElementColor2, StyleElements.SimpleElementColor simpleElementColor3) {
        this.f28890a = simpleElementColor;
        this.f28891b = simpleElementColor2;
        this.f28892c = simpleElementColor3;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28890a;
    }

    public final StyleElements.SimpleElementColor c() {
        return this.f28891b;
    }

    public final StyleElements.SimpleElementColor d() {
        return this.f28892c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28890a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor2 = this.f28891b;
        if (simpleElementColor2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor2.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor3 = this.f28892c;
        if (simpleElementColor3 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor3.writeToParcel(parcel, i10);
    }
}
