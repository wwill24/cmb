package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepSecondaryButtonComponentStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepSecondaryButtonComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepCancelButtonComponentStyleContainer f28995a;

    public static final class a implements Parcelable.Creator<StepStyles$StepSecondaryButtonComponentStyle> {
        /* renamed from: a */
        public final StepStyles$StepSecondaryButtonComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepSecondaryButtonComponentStyle(parcel.readInt() == 0 ? null : StepStyles$StepCancelButtonComponentStyleContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepSecondaryButtonComponentStyle[] newArray(int i10) {
            return new StepStyles$StepSecondaryButtonComponentStyle[i10];
        }
    }

    public StepStyles$StepSecondaryButtonComponentStyle(StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer) {
        this.f28995a = stepStyles$StepCancelButtonComponentStyleContainer;
    }

    public final StepStyles$StepCancelButtonComponentStyleContainer a() {
        return this.f28995a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer = this.f28995a;
        if (stepStyles$StepCancelButtonComponentStyleContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepCancelButtonComponentStyleContainer.writeToParcel(parcel, i10);
    }
}
