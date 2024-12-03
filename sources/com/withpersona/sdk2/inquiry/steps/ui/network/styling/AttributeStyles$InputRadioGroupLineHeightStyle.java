package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputRadioGroupLineHeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputRadioGroupLineHeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28439a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28440b;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputRadioGroupLineHeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputRadioGroupLineHeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.DPMeasurement dPMeasurement = null;
            StyleElements.DPMeasurement createFromParcel = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                dPMeasurement = StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$InputRadioGroupLineHeightStyle(createFromParcel, dPMeasurement);
        }

        /* renamed from: b */
        public final AttributeStyles$InputRadioGroupLineHeightStyle[] newArray(int i10) {
            return new AttributeStyles$InputRadioGroupLineHeightStyle[i10];
        }
    }

    public AttributeStyles$InputRadioGroupLineHeightStyle(StyleElements.DPMeasurement dPMeasurement, StyleElements.DPMeasurement dPMeasurement2) {
        this.f28439a = dPMeasurement;
        this.f28440b = dPMeasurement2;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28439a;
    }

    public final StyleElements.DPMeasurement c() {
        return this.f28440b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28439a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement2 = this.f28440b;
        if (dPMeasurement2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement2.writeToParcel(parcel, i10);
    }
}
