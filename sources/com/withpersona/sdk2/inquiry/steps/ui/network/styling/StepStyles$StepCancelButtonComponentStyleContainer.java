package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepCancelButtonComponentStyleContainer implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepCancelButtonComponentStyleContainer> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final ButtonCancelComponentStyle f28991a;

    public static final class a implements Parcelable.Creator<StepStyles$StepCancelButtonComponentStyleContainer> {
        /* renamed from: a */
        public final StepStyles$StepCancelButtonComponentStyleContainer createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepCancelButtonComponentStyleContainer(parcel.readInt() == 0 ? null : ButtonCancelComponentStyle.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepCancelButtonComponentStyleContainer[] newArray(int i10) {
            return new StepStyles$StepCancelButtonComponentStyleContainer[i10];
        }
    }

    public StepStyles$StepCancelButtonComponentStyleContainer(ButtonCancelComponentStyle buttonCancelComponentStyle) {
        this.f28991a = buttonCancelComponentStyle;
    }

    public final ButtonCancelComponentStyle a() {
        return this.f28991a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        ButtonCancelComponentStyle buttonCancelComponentStyle = this.f28991a;
        if (buttonCancelComponentStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        buttonCancelComponentStyle.writeToParcel(parcel, i10);
    }
}
