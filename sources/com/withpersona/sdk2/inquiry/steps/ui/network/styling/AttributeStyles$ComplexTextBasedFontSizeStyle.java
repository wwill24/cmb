package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ComplexTextBasedFontSizeStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ComplexTextBasedFontSizeStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28376a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28377b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28378c;

    /* renamed from: d  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28379d;

    public static final class a implements Parcelable.Creator<AttributeStyles$ComplexTextBasedFontSizeStyle> {
        /* renamed from: a */
        public final AttributeStyles$ComplexTextBasedFontSizeStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.DPMeasurement dPMeasurement = null;
            StyleElements.DPMeasurement createFromParcel = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            StyleElements.DPMeasurement createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            StyleElements.DPMeasurement createFromParcel3 = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                dPMeasurement = StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$ComplexTextBasedFontSizeStyle(createFromParcel, createFromParcel2, createFromParcel3, dPMeasurement);
        }

        /* renamed from: b */
        public final AttributeStyles$ComplexTextBasedFontSizeStyle[] newArray(int i10) {
            return new AttributeStyles$ComplexTextBasedFontSizeStyle[i10];
        }
    }

    public AttributeStyles$ComplexTextBasedFontSizeStyle(StyleElements.DPMeasurement dPMeasurement, StyleElements.DPMeasurement dPMeasurement2, StyleElements.DPMeasurement dPMeasurement3, StyleElements.DPMeasurement dPMeasurement4) {
        this.f28376a = dPMeasurement;
        this.f28377b = dPMeasurement2;
        this.f28378c = dPMeasurement3;
        this.f28379d = dPMeasurement4;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28379d;
    }

    public final StyleElements.DPMeasurement c() {
        return this.f28378c;
    }

    public final StyleElements.DPMeasurement d() {
        return this.f28377b;
    }

    public int describeContents() {
        return 0;
    }

    public final StyleElements.DPMeasurement e() {
        return this.f28376a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28376a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement2 = this.f28377b;
        if (dPMeasurement2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement2.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement3 = this.f28378c;
        if (dPMeasurement3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement3.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement4 = this.f28379d;
        if (dPMeasurement4 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement4.writeToParcel(parcel, i10);
    }
}
