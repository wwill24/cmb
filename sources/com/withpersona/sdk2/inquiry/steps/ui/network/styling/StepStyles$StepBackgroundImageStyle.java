package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepBackgroundImageStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepBackgroundImageStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepBackgroundImageStyleContainer f28988a;

    public static final class a implements Parcelable.Creator<StepStyles$StepBackgroundImageStyle> {
        /* renamed from: a */
        public final StepStyles$StepBackgroundImageStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepBackgroundImageStyle(parcel.readInt() == 0 ? null : StepStyles$StepBackgroundImageStyleContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepBackgroundImageStyle[] newArray(int i10) {
            return new StepStyles$StepBackgroundImageStyle[i10];
        }
    }

    public StepStyles$StepBackgroundImageStyle(StepStyles$StepBackgroundImageStyleContainer stepStyles$StepBackgroundImageStyleContainer) {
        this.f28988a = stepStyles$StepBackgroundImageStyleContainer;
    }

    public final StepStyles$StepBackgroundImageStyleContainer a() {
        return this.f28988a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepBackgroundImageStyleContainer stepStyles$StepBackgroundImageStyleContainer = this.f28988a;
        if (stepStyles$StepBackgroundImageStyleContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepBackgroundImageStyleContainer.writeToParcel(parcel, i10);
    }
}
