package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$HorizontalStackGapStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$HorizontalStackGapStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28426a;

    public static final class a implements Parcelable.Creator<AttributeStyles$HorizontalStackGapStyle> {
        /* renamed from: a */
        public final AttributeStyles$HorizontalStackGapStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$HorizontalStackGapStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$HorizontalStackGapStyle[] newArray(int i10) {
            return new AttributeStyles$HorizontalStackGapStyle[i10];
        }
    }

    public AttributeStyles$HorizontalStackGapStyle(StyleElements.DPMeasurement dPMeasurement) {
        this.f28426a = dPMeasurement;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28426a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28426a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement.writeToParcel(parcel, i10);
    }
}
