package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepTextBasedComponentStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepTextBasedComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyleContainer f28997a;

    public static final class a implements Parcelable.Creator<StepStyles$StepTextBasedComponentStyle> {
        /* renamed from: a */
        public final StepStyles$StepTextBasedComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepTextBasedComponentStyle(parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyleContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepTextBasedComponentStyle[] newArray(int i10) {
            return new StepStyles$StepTextBasedComponentStyle[i10];
        }
    }

    public StepStyles$StepTextBasedComponentStyle(StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer) {
        this.f28997a = stepStyles$StepTextBasedComponentStyleContainer;
    }

    public final StepStyles$StepTextBasedComponentStyleContainer a() {
        return this.f28997a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = this.f28997a;
        if (stepStyles$StepTextBasedComponentStyleContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepTextBasedComponentStyleContainer.writeToParcel(parcel, i10);
    }
}
