package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ClickableStackMarginStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ClickableStackMarginStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28369a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ClickableStackMarginStyle> {
        /* renamed from: a */
        public final AttributeStyles$ClickableStackMarginStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ClickableStackMarginStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ClickableStackMarginStyle[] newArray(int i10) {
            return new AttributeStyles$ClickableStackMarginStyle[i10];
        }
    }

    public AttributeStyles$ClickableStackMarginStyle(StyleElements.DPMeasurementSet dPMeasurementSet) {
        this.f28369a = dPMeasurementSet;
    }

    public final StyleElements.DPMeasurementSet a() {
        return this.f28369a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurementSet dPMeasurementSet = this.f28369a;
        if (dPMeasurementSet == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurementSet.writeToParcel(parcel, i10);
    }
}
