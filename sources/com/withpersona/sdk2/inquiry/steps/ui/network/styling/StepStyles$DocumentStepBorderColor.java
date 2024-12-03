package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$DocumentStepBorderColor implements Parcelable {
    public static final Parcelable.Creator<StepStyles$DocumentStepBorderColor> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28879a;

    public static final class a implements Parcelable.Creator<StepStyles$DocumentStepBorderColor> {
        /* renamed from: a */
        public final StepStyles$DocumentStepBorderColor createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$DocumentStepBorderColor(parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$DocumentStepBorderColor[] newArray(int i10) {
            return new StepStyles$DocumentStepBorderColor[i10];
        }
    }

    public StepStyles$DocumentStepBorderColor(StyleElements.SimpleElementColor simpleElementColor) {
        this.f28879a = simpleElementColor;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28879a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28879a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
