package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ComplexTextBasedLineHeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ComplexTextBasedLineHeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28389a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28390b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28391c;

    /* renamed from: d  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28392d;

    public static final class a implements Parcelable.Creator<AttributeStyles$ComplexTextBasedLineHeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$ComplexTextBasedLineHeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.DPMeasurement dPMeasurement = null;
            StyleElements.DPMeasurement createFromParcel = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            StyleElements.DPMeasurement createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            StyleElements.DPMeasurement createFromParcel3 = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                dPMeasurement = StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$ComplexTextBasedLineHeightStyle(createFromParcel, createFromParcel2, createFromParcel3, dPMeasurement);
        }

        /* renamed from: b */
        public final AttributeStyles$ComplexTextBasedLineHeightStyle[] newArray(int i10) {
            return new AttributeStyles$ComplexTextBasedLineHeightStyle[i10];
        }
    }

    public AttributeStyles$ComplexTextBasedLineHeightStyle(StyleElements.DPMeasurement dPMeasurement, StyleElements.DPMeasurement dPMeasurement2, StyleElements.DPMeasurement dPMeasurement3, StyleElements.DPMeasurement dPMeasurement4) {
        this.f28389a = dPMeasurement;
        this.f28390b = dPMeasurement2;
        this.f28391c = dPMeasurement3;
        this.f28392d = dPMeasurement4;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28392d;
    }

    public final StyleElements.DPMeasurement c() {
        return this.f28391c;
    }

    public final StyleElements.DPMeasurement d() {
        return this.f28390b;
    }

    public int describeContents() {
        return 0;
    }

    public final StyleElements.DPMeasurement e() {
        return this.f28389a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28389a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement2 = this.f28390b;
        if (dPMeasurement2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement2.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement3 = this.f28391c;
        if (dPMeasurement3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement3.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement4 = this.f28392d;
        if (dPMeasurement4 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement4.writeToParcel(parcel, i10);
    }
}
