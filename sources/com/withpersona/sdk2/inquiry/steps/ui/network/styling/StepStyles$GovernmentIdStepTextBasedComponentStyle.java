package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$GovernmentIdStepTextBasedComponentStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$GovernmentIdStepTextBasedComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f28950a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f28951b;

    /* renamed from: c  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f28952c;

    /* renamed from: d  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f28953d;

    public static final class a implements Parcelable.Creator<StepStyles$GovernmentIdStepTextBasedComponentStyle> {
        /* renamed from: a */
        public final StepStyles$GovernmentIdStepTextBasedComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = null;
            StepStyles$StepTextBasedComponentStyleContainer createFromParcel = parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            StepStyles$StepTextBasedComponentStyleContainer createFromParcel2 = parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            StepStyles$StepTextBasedComponentStyleContainer createFromParcel3 = parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                stepStyles$StepTextBasedComponentStyleContainer = StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$GovernmentIdStepTextBasedComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, stepStyles$StepTextBasedComponentStyleContainer);
        }

        /* renamed from: b */
        public final StepStyles$GovernmentIdStepTextBasedComponentStyle[] newArray(int i10) {
            return new StepStyles$GovernmentIdStepTextBasedComponentStyle[i10];
        }
    }

    public StepStyles$GovernmentIdStepTextBasedComponentStyle(StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer, StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2, StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer3, StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer4) {
        this.f28950a = stepStyles$StepTextBasedComponentStyleContainer;
        this.f28951b = stepStyles$StepTextBasedComponentStyleContainer2;
        this.f28952c = stepStyles$StepTextBasedComponentStyleContainer3;
        this.f28953d = stepStyles$StepTextBasedComponentStyleContainer4;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer a() {
        return this.f28950a;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer c() {
        return this.f28952c;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer d() {
        return this.f28953d;
    }

    public int describeContents() {
        return 0;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer e() {
        return this.f28951b;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = this.f28950a;
        if (stepStyles$StepTextBasedComponentStyleContainer == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepTextBasedComponentStyleContainer.writeToParcel(parcel, i10);
        }
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2 = this.f28951b;
        if (stepStyles$StepTextBasedComponentStyleContainer2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepTextBasedComponentStyleContainer2.writeToParcel(parcel, i10);
        }
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer3 = this.f28952c;
        if (stepStyles$StepTextBasedComponentStyleContainer3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepTextBasedComponentStyleContainer3.writeToParcel(parcel, i10);
        }
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer4 = this.f28953d;
        if (stepStyles$StepTextBasedComponentStyleContainer4 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepTextBasedComponentStyleContainer4.writeToParcel(parcel, i10);
    }
}
