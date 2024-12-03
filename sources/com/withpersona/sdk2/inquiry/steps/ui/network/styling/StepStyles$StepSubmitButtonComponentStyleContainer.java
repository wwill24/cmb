package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepSubmitButtonComponentStyleContainer implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepSubmitButtonComponentStyleContainer> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final ButtonSubmitComponentStyle f28996a;

    public static final class a implements Parcelable.Creator<StepStyles$StepSubmitButtonComponentStyleContainer> {
        /* renamed from: a */
        public final StepStyles$StepSubmitButtonComponentStyleContainer createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepSubmitButtonComponentStyleContainer(parcel.readInt() == 0 ? null : ButtonSubmitComponentStyle.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final StepStyles$StepSubmitButtonComponentStyleContainer[] newArray(int i10) {
            return new StepStyles$StepSubmitButtonComponentStyleContainer[i10];
        }
    }

    public StepStyles$StepSubmitButtonComponentStyleContainer(ButtonSubmitComponentStyle buttonSubmitComponentStyle) {
        this.f28996a = buttonSubmitComponentStyle;
    }

    public final ButtonSubmitComponentStyle a() {
        return this.f28996a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        ButtonSubmitComponentStyle buttonSubmitComponentStyle = this.f28996a;
        if (buttonSubmitComponentStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        buttonSubmitComponentStyle.writeToParcel(parcel, i10);
    }
}
