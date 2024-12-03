package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ComplexTextBasedLetterSpacingStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ComplexTextBasedLetterSpacingStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28384a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28385b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28386c;

    /* renamed from: d  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28387d;

    /* renamed from: e  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28388e;

    public static final class a implements Parcelable.Creator<AttributeStyles$ComplexTextBasedLetterSpacingStyle> {
        /* renamed from: a */
        public final AttributeStyles$ComplexTextBasedLetterSpacingStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.DPMeasurement dPMeasurement = null;
            StyleElements.DPMeasurement createFromParcel = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            StyleElements.DPMeasurement createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            StyleElements.DPMeasurement createFromParcel3 = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            StyleElements.DPMeasurement createFromParcel4 = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                dPMeasurement = StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$ComplexTextBasedLetterSpacingStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, dPMeasurement);
        }

        /* renamed from: b */
        public final AttributeStyles$ComplexTextBasedLetterSpacingStyle[] newArray(int i10) {
            return new AttributeStyles$ComplexTextBasedLetterSpacingStyle[i10];
        }
    }

    public AttributeStyles$ComplexTextBasedLetterSpacingStyle(StyleElements.DPMeasurement dPMeasurement, StyleElements.DPMeasurement dPMeasurement2, StyleElements.DPMeasurement dPMeasurement3, StyleElements.DPMeasurement dPMeasurement4, StyleElements.DPMeasurement dPMeasurement5) {
        this.f28384a = dPMeasurement;
        this.f28385b = dPMeasurement2;
        this.f28386c = dPMeasurement3;
        this.f28387d = dPMeasurement4;
        this.f28388e = dPMeasurement5;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28384a;
    }

    public final StyleElements.DPMeasurement c() {
        return this.f28388e;
    }

    public final StyleElements.DPMeasurement d() {
        return this.f28387d;
    }

    public int describeContents() {
        return 0;
    }

    public final StyleElements.DPMeasurement e() {
        return this.f28386c;
    }

    public final StyleElements.DPMeasurement f() {
        return this.f28385b;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28384a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement2 = this.f28385b;
        if (dPMeasurement2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement2.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement3 = this.f28386c;
        if (dPMeasurement3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement3.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement4 = this.f28387d;
        if (dPMeasurement4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement4.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement5 = this.f28388e;
        if (dPMeasurement5 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement5.writeToParcel(parcel, i10);
    }
}
