package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$UiStepAlignment implements Parcelable {
    public static final Parcelable.Creator<StepStyles$UiStepAlignment> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.Position f28999a;

    public static final class a implements Parcelable.Creator<StepStyles$UiStepAlignment> {
        /* renamed from: a */
        public final StepStyles$UiStepAlignment createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$UiStepAlignment(parcel.readInt() == 0 ? null : StyleElements.Position.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$UiStepAlignment[] newArray(int i10) {
            return new StepStyles$UiStepAlignment[i10];
        }
    }

    public StepStyles$UiStepAlignment(StyleElements.Position position) {
        this.f28999a = position;
    }

    public final StyleElements.Position a() {
        return this.f28999a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.Position position = this.f28999a;
        if (position == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        position.writeToParcel(parcel, i10);
    }
}
