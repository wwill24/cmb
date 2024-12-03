package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepBackgroundImageStyleContainer implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepBackgroundImageStyleContainer> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StepStyles$StepBackgroundImageNameContainer f28989a;

    public static final class a implements Parcelable.Creator<StepStyles$StepBackgroundImageStyleContainer> {
        /* renamed from: a */
        public final StepStyles$StepBackgroundImageStyleContainer createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepBackgroundImageStyleContainer(parcel.readInt() == 0 ? null : StepStyles$StepBackgroundImageNameContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepBackgroundImageStyleContainer[] newArray(int i10) {
            return new StepStyles$StepBackgroundImageStyleContainer[i10];
        }
    }

    public StepStyles$StepBackgroundImageStyleContainer(StepStyles$StepBackgroundImageNameContainer stepStyles$StepBackgroundImageNameContainer) {
        this.f28989a = stepStyles$StepBackgroundImageNameContainer;
    }

    public final StepStyles$StepBackgroundImageNameContainer a() {
        return this.f28989a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StepStyles$StepBackgroundImageNameContainer stepStyles$StepBackgroundImageNameContainer = this.f28989a;
        if (stepStyles$StepBackgroundImageNameContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepBackgroundImageNameContainer.writeToParcel(parcel, i10);
    }
}
