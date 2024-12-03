package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$RemoteImageMarginStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$RemoteImageMarginStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28486a;

    public static final class a implements Parcelable.Creator<AttributeStyles$RemoteImageMarginStyle> {
        /* renamed from: a */
        public final AttributeStyles$RemoteImageMarginStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$RemoteImageMarginStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$RemoteImageMarginStyle[] newArray(int i10) {
            return new AttributeStyles$RemoteImageMarginStyle[i10];
        }
    }

    public AttributeStyles$RemoteImageMarginStyle(StyleElements.DPMeasurementSet dPMeasurementSet) {
        this.f28486a = dPMeasurementSet;
    }

    public final StyleElements.DPMeasurementSet a() {
        return this.f28486a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurementSet dPMeasurementSet = this.f28486a;
        if (dPMeasurementSet == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurementSet.writeToParcel(parcel, i10);
    }
}
