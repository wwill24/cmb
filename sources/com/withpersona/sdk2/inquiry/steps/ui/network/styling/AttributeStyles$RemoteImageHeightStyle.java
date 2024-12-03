package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$RemoteImageHeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$RemoteImageHeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.Measurement f28484a;

    public static final class a implements Parcelable.Creator<AttributeStyles$RemoteImageHeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$RemoteImageHeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$RemoteImageHeightStyle(parcel.readInt() == 0 ? null : StyleElements.Measurement.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$RemoteImageHeightStyle[] newArray(int i10) {
            return new AttributeStyles$RemoteImageHeightStyle[i10];
        }
    }

    public AttributeStyles$RemoteImageHeightStyle(StyleElements.Measurement measurement) {
        this.f28484a = measurement;
    }

    public final StyleElements.Measurement a() {
        return this.f28484a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.Measurement measurement = this.f28484a;
        if (measurement == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        measurement.writeToParcel(parcel, i10);
    }
}
