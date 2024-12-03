package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepTextBasedComponentStyleContainer implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepTextBasedComponentStyleContainer> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final TextBasedComponentStyle f28998a;

    public static final class a implements Parcelable.Creator<StepStyles$StepTextBasedComponentStyleContainer> {
        /* renamed from: a */
        public final StepStyles$StepTextBasedComponentStyleContainer createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepTextBasedComponentStyleContainer(parcel.readInt() == 0 ? null : TextBasedComponentStyle.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepTextBasedComponentStyleContainer[] newArray(int i10) {
            return new StepStyles$StepTextBasedComponentStyleContainer[i10];
        }
    }

    public StepStyles$StepTextBasedComponentStyleContainer(TextBasedComponentStyle textBasedComponentStyle) {
        this.f28998a = textBasedComponentStyle;
    }

    public final TextBasedComponentStyle a() {
        return this.f28998a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        TextBasedComponentStyle textBasedComponentStyle = this.f28998a;
        if (textBasedComponentStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        textBasedComponentStyle.writeToParcel(parcel, i10);
    }
}
