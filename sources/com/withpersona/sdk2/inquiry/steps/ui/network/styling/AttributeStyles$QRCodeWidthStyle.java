package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$QRCodeWidthStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$QRCodeWidthStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.Measurement f28483a;

    public static final class a implements Parcelable.Creator<AttributeStyles$QRCodeWidthStyle> {
        /* renamed from: a */
        public final AttributeStyles$QRCodeWidthStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$QRCodeWidthStyle(parcel.readInt() == 0 ? null : StyleElements.Measurement.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$QRCodeWidthStyle[] newArray(int i10) {
            return new AttributeStyles$QRCodeWidthStyle[i10];
        }
    }

    public AttributeStyles$QRCodeWidthStyle(StyleElements.Measurement measurement) {
        this.f28483a = measurement;
    }

    public final StyleElements.Measurement a() {
        return this.f28483a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.Measurement measurement = this.f28483a;
        if (measurement == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        measurement.writeToParcel(parcel, i10);
    }
}
