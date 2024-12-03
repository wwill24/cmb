package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$FooterBorderWidthStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$FooterBorderWidthStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28415a;

    public static final class a implements Parcelable.Creator<AttributeStyles$FooterBorderWidthStyle> {
        /* renamed from: a */
        public final AttributeStyles$FooterBorderWidthStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$FooterBorderWidthStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$FooterBorderWidthStyle[] newArray(int i10) {
            return new AttributeStyles$FooterBorderWidthStyle[i10];
        }
    }

    public AttributeStyles$FooterBorderWidthStyle(StyleElements.DPMeasurementSet dPMeasurementSet) {
        this.f28415a = dPMeasurementSet;
    }

    public final StyleElements.DPMeasurementSet a() {
        return this.f28415a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurementSet dPMeasurementSet = this.f28415a;
        if (dPMeasurementSet == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurementSet.writeToParcel(parcel, i10);
    }
}
