package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepPrimaryButtonComponentStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepPrimaryButtonComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepSubmitButtonComponentStyleContainer f28994a;

    public static final class a implements Parcelable.Creator<StepStyles$StepPrimaryButtonComponentStyle> {
        /* renamed from: a */
        public final StepStyles$StepPrimaryButtonComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepPrimaryButtonComponentStyle(parcel.readInt() == 0 ? null : StepStyles$StepSubmitButtonComponentStyleContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepPrimaryButtonComponentStyle[] newArray(int i10) {
            return new StepStyles$StepPrimaryButtonComponentStyle[i10];
        }
    }

    public StepStyles$StepPrimaryButtonComponentStyle(StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer) {
        this.f28994a = stepStyles$StepSubmitButtonComponentStyleContainer;
    }

    public final StepStyles$StepSubmitButtonComponentStyleContainer a() {
        return this.f28994a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer = this.f28994a;
        if (stepStyles$StepSubmitButtonComponentStyleContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepSubmitButtonComponentStyleContainer.writeToParcel(parcel, i10);
    }
}
