package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$DocumentStepTextBasedComponentStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$DocumentStepTextBasedComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f28908a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f28909b;

    /* renamed from: c  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f28910c;

    public static final class a implements Parcelable.Creator<StepStyles$DocumentStepTextBasedComponentStyle> {
        /* renamed from: a */
        public final StepStyles$DocumentStepTextBasedComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = null;
            StepStyles$StepTextBasedComponentStyleContainer createFromParcel = parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            StepStyles$StepTextBasedComponentStyleContainer createFromParcel2 = parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                stepStyles$StepTextBasedComponentStyleContainer = StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$DocumentStepTextBasedComponentStyle(createFromParcel, createFromParcel2, stepStyles$StepTextBasedComponentStyleContainer);
        }

        /* renamed from: b */
        public final StepStyles$DocumentStepTextBasedComponentStyle[] newArray(int i10) {
            return new StepStyles$DocumentStepTextBasedComponentStyle[i10];
        }
    }

    public StepStyles$DocumentStepTextBasedComponentStyle(StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer, StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2, StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer3) {
        this.f28908a = stepStyles$StepTextBasedComponentStyleContainer;
        this.f28909b = stepStyles$StepTextBasedComponentStyleContainer2;
        this.f28910c = stepStyles$StepTextBasedComponentStyleContainer3;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer a() {
        return this.f28908a;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer c() {
        return this.f28909b;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer d() {
        return this.f28910c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = this.f28908a;
        if (stepStyles$StepTextBasedComponentStyleContainer == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepTextBasedComponentStyleContainer.writeToParcel(parcel, i10);
        }
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2 = this.f28909b;
        if (stepStyles$StepTextBasedComponentStyleContainer2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepTextBasedComponentStyleContainer2.writeToParcel(parcel, i10);
        }
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer3 = this.f28910c;
        if (stepStyles$StepTextBasedComponentStyleContainer3 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepTextBasedComponentStyleContainer3.writeToParcel(parcel, i10);
    }
}
