package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$HorizontalStackPaddingStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$HorizontalStackPaddingStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28428a;

    public static final class a implements Parcelable.Creator<AttributeStyles$HorizontalStackPaddingStyle> {
        /* renamed from: a */
        public final AttributeStyles$HorizontalStackPaddingStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$HorizontalStackPaddingStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$HorizontalStackPaddingStyle[] newArray(int i10) {
            return new AttributeStyles$HorizontalStackPaddingStyle[i10];
        }
    }

    public AttributeStyles$HorizontalStackPaddingStyle(StyleElements.DPMeasurementSet dPMeasurementSet) {
        this.f28428a = dPMeasurementSet;
    }

    public final StyleElements.DPMeasurementSet a() {
        return this.f28428a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurementSet dPMeasurementSet = this.f28428a;
        if (dPMeasurementSet == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurementSet.writeToParcel(parcel, i10);
    }
}
