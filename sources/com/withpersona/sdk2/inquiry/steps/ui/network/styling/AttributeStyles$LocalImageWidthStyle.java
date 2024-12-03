package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$LocalImageWidthStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$LocalImageWidthStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.Measurement f28478a;

    public static final class a implements Parcelable.Creator<AttributeStyles$LocalImageWidthStyle> {
        /* renamed from: a */
        public final AttributeStyles$LocalImageWidthStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$LocalImageWidthStyle(parcel.readInt() == 0 ? null : StyleElements.Measurement.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$LocalImageWidthStyle[] newArray(int i10) {
            return new AttributeStyles$LocalImageWidthStyle[i10];
        }
    }

    public AttributeStyles$LocalImageWidthStyle(StyleElements.Measurement measurement) {
        this.f28478a = measurement;
    }

    public final StyleElements.Measurement a() {
        return this.f28478a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.Measurement measurement = this.f28478a;
        if (measurement == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        measurement.writeToParcel(parcel, i10);
    }
}
