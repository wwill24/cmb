package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$UiStepTextBasedComponentStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$UiStepTextBasedComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f29014a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f29015b;

    public static final class a implements Parcelable.Creator<StepStyles$UiStepTextBasedComponentStyle> {
        /* renamed from: a */
        public final StepStyles$UiStepTextBasedComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = null;
            StepStyles$StepTextBasedComponentStyleContainer createFromParcel = parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                stepStyles$StepTextBasedComponentStyleContainer = StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$UiStepTextBasedComponentStyle(createFromParcel, stepStyles$StepTextBasedComponentStyleContainer);
        }

        /* renamed from: b */
        public final StepStyles$UiStepTextBasedComponentStyle[] newArray(int i10) {
            return new StepStyles$UiStepTextBasedComponentStyle[i10];
        }
    }

    public StepStyles$UiStepTextBasedComponentStyle(StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer, StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2) {
        this.f29014a = stepStyles$StepTextBasedComponentStyleContainer;
        this.f29015b = stepStyles$StepTextBasedComponentStyleContainer2;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer a() {
        return this.f29014a;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer c() {
        return this.f29015b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = this.f29014a;
        if (stepStyles$StepTextBasedComponentStyleContainer == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepTextBasedComponentStyleContainer.writeToParcel(parcel, i10);
        }
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2 = this.f29015b;
        if (stepStyles$StepTextBasedComponentStyleContainer2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepTextBasedComponentStyleContainer2.writeToParcel(parcel, i10);
    }
}
