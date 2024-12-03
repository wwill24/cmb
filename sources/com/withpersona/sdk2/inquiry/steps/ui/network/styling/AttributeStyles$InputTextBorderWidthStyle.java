package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputTextBorderWidthStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputTextBorderWidthStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28470a;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputTextBorderWidthStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputTextBorderWidthStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$InputTextBorderWidthStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$InputTextBorderWidthStyle[] newArray(int i10) {
            return new AttributeStyles$InputTextBorderWidthStyle[i10];
        }
    }

    public AttributeStyles$InputTextBorderWidthStyle(StyleElements.DPMeasurementSet dPMeasurementSet) {
        this.f28470a = dPMeasurementSet;
    }

    public final StyleElements.DPMeasurementSet a() {
        return this.f28470a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurementSet dPMeasurementSet = this.f28470a;
        if (dPMeasurementSet == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurementSet.writeToParcel(parcel, i10);
    }
}
