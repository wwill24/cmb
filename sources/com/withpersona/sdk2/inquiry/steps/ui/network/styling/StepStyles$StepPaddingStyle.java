package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepPaddingStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepPaddingStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepPaddingStyleContainer f28992a;

    public static final class a implements Parcelable.Creator<StepStyles$StepPaddingStyle> {
        /* renamed from: a */
        public final StepStyles$StepPaddingStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepPaddingStyle(parcel.readInt() == 0 ? null : StepStyles$StepPaddingStyleContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepPaddingStyle[] newArray(int i10) {
            return new StepStyles$StepPaddingStyle[i10];
        }
    }

    public StepStyles$StepPaddingStyle(StepStyles$StepPaddingStyleContainer stepStyles$StepPaddingStyleContainer) {
        this.f28992a = stepStyles$StepPaddingStyleContainer;
    }

    public final StepStyles$StepPaddingStyleContainer a() {
        return this.f28992a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepPaddingStyleContainer stepStyles$StepPaddingStyleContainer = this.f28992a;
        if (stepStyles$StepPaddingStyleContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepPaddingStyleContainer.writeToParcel(parcel, i10);
    }
}
