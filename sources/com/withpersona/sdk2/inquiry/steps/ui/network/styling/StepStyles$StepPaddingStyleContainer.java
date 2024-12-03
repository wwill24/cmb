package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepPaddingStyleContainer implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepPaddingStyleContainer> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPSizeSet f28993a;

    public static final class a implements Parcelable.Creator<StepStyles$StepPaddingStyleContainer> {
        /* renamed from: a */
        public final StepStyles$StepPaddingStyleContainer createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepPaddingStyleContainer(parcel.readInt() == 0 ? null : StyleElements.DPSizeSet.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepPaddingStyleContainer[] newArray(int i10) {
            return new StepStyles$StepPaddingStyleContainer[i10];
        }
    }

    public StepStyles$StepPaddingStyleContainer(StyleElements.DPSizeSet dPSizeSet) {
        this.f28993a = dPSizeSet;
    }

    public final StyleElements.DPSizeSet a() {
        return this.f28993a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPSizeSet dPSizeSet = this.f28993a;
        if (dPSizeSet == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPSizeSet.writeToParcel(parcel, i10);
    }
}
