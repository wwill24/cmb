package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ClickableStackBorderRadiusStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ClickableStackBorderRadiusStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28365a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ClickableStackBorderRadiusStyle> {
        /* renamed from: a */
        public final AttributeStyles$ClickableStackBorderRadiusStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ClickableStackBorderRadiusStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ClickableStackBorderRadiusStyle[] newArray(int i10) {
            return new AttributeStyles$ClickableStackBorderRadiusStyle[i10];
        }
    }

    public AttributeStyles$ClickableStackBorderRadiusStyle(StyleElements.DPMeasurement dPMeasurement) {
        this.f28365a = dPMeasurement;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28365a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28365a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement.writeToParcel(parcel, i10);
    }
}
