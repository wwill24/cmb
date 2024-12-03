package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputSelectTextLetterSpacingStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputSelectTextLetterSpacingStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28461a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28462b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28463c;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputSelectTextLetterSpacingStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputSelectTextLetterSpacingStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.DPMeasurement dPMeasurement = null;
            StyleElements.DPMeasurement createFromParcel = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            StyleElements.DPMeasurement createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                dPMeasurement = StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$InputSelectTextLetterSpacingStyle(createFromParcel, createFromParcel2, dPMeasurement);
        }

        /* renamed from: b */
        public final AttributeStyles$InputSelectTextLetterSpacingStyle[] newArray(int i10) {
            return new AttributeStyles$InputSelectTextLetterSpacingStyle[i10];
        }
    }

    public AttributeStyles$InputSelectTextLetterSpacingStyle(StyleElements.DPMeasurement dPMeasurement, StyleElements.DPMeasurement dPMeasurement2, StyleElements.DPMeasurement dPMeasurement3) {
        this.f28461a = dPMeasurement;
        this.f28462b = dPMeasurement2;
        this.f28463c = dPMeasurement3;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28461a;
    }

    public final StyleElements.DPMeasurement c() {
        return this.f28463c;
    }

    public final StyleElements.DPMeasurement d() {
        return this.f28462b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28461a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement2 = this.f28462b;
        if (dPMeasurement2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurement2.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurement dPMeasurement3 = this.f28463c;
        if (dPMeasurement3 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement3.writeToParcel(parcel, i10);
    }
}
