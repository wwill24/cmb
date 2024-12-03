package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ButtonBasedLineHeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ButtonBasedLineHeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28356a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ButtonBasedLineHeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$ButtonBasedLineHeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ButtonBasedLineHeightStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ButtonBasedLineHeightStyle[] newArray(int i10) {
            return new AttributeStyles$ButtonBasedLineHeightStyle[i10];
        }
    }

    public AttributeStyles$ButtonBasedLineHeightStyle(StyleElements.DPMeasurement dPMeasurement) {
        this.f28356a = dPMeasurement;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28356a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28356a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement.writeToParcel(parcel, i10);
    }
}
