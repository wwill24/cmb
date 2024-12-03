package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepBackgroundImageNameContainer implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepBackgroundImageNameContainer> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f28987a;

    public static final class a implements Parcelable.Creator<StepStyles$StepBackgroundImageNameContainer> {
        /* renamed from: a */
        public final StepStyles$StepBackgroundImageNameContainer createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new StepStyles$StepBackgroundImageNameContainer(parcel.readString());
        }

        /* renamed from: b */
        public final StepStyles$StepBackgroundImageNameContainer[] newArray(int i10) {
            return new StepStyles$StepBackgroundImageNameContainer[i10];
        }
    }

    public StepStyles$StepBackgroundImageNameContainer(String str) {
        this.f28987a = str;
    }

    public final String a() {
        return this.f28987a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f28987a);
    }
}
