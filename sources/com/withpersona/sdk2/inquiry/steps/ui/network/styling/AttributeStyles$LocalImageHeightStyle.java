package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$LocalImageHeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$LocalImageHeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.Measurement f28474a;

    public static final class a implements Parcelable.Creator<AttributeStyles$LocalImageHeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$LocalImageHeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$LocalImageHeightStyle(parcel.readInt() == 0 ? null : StyleElements.Measurement.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$LocalImageHeightStyle[] newArray(int i10) {
            return new AttributeStyles$LocalImageHeightStyle[i10];
        }
    }

    public AttributeStyles$LocalImageHeightStyle(StyleElements.Measurement measurement) {
        this.f28474a = measurement;
    }

    public final StyleElements.Measurement a() {
        return this.f28474a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.Measurement measurement = this.f28474a;
        if (measurement == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        measurement.writeToParcel(parcel, i10);
    }
}
