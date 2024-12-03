package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputSelectTextLineHeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputSelectTextLineHeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28464a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28465b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28466c;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputSelectTextLineHeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputSelectTextLineHeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.DPMeasurement dPMeasurement = null;
            StyleElements.DPMeasurement createFromParcel = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            StyleElements.DPMeasurement createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                dPMeasurement = StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$InputSelectTextLineHeightStyle(createFromParcel, createFromParcel2, dPMeasurement);
        }

        /* renamed from: b */
        public final AttributeStyles$InputSelectTextLineHeightStyle[] newArray(int i10) {
            return new AttributeStyles$InputSelectTextLineHeightStyle[i10];
        }
    }

    public AttributeStyles$InputSelectTextLineHeightStyle(StyleElements.DPMeasurement dPMeasurement, StyleElements.DPMeasurement dPMeasurement2, StyleElements.DPMeasurement dPMeasurement3) {
        this.f28464a = dPMeasurement;
        this.f28465b = dPMeasurement2;
        this.f28466c = dPMeasurement3;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28464a;
    }

    public final StyleElements.DPMeasurement c() {
        return this.f28466c;
    }

    public final StyleElements.DPMeasurement d() {
        return this.f28465b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28464a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement2 = this.f28465b;
        if (dPMeasurement2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement2.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement3 = this.f28466c;
        if (dPMeasurement3 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement3.writeToParcel(parcel, i10);
    }
}
