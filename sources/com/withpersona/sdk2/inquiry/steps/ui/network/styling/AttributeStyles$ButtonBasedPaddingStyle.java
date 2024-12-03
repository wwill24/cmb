package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ButtonBasedPaddingStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ButtonBasedPaddingStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28358a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ButtonBasedPaddingStyle> {
        /* renamed from: a */
        public final AttributeStyles$ButtonBasedPaddingStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ButtonBasedPaddingStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ButtonBasedPaddingStyle[] newArray(int i10) {
            return new AttributeStyles$ButtonBasedPaddingStyle[i10];
        }
    }

    public AttributeStyles$ButtonBasedPaddingStyle(StyleElements.DPMeasurementSet dPMeasurementSet) {
        this.f28358a = dPMeasurementSet;
    }

    public final StyleElements.DPMeasurementSet a() {
        return this.f28358a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurementSet dPMeasurementSet = this.f28358a;
        if (dPMeasurementSet == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurementSet.writeToParcel(parcel, i10);
    }
}
