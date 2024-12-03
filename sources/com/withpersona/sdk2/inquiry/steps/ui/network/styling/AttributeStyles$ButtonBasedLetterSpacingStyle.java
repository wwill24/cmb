package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ButtonBasedLetterSpacingStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ButtonBasedLetterSpacingStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurement f28355a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ButtonBasedLetterSpacingStyle> {
        /* renamed from: a */
        public final AttributeStyles$ButtonBasedLetterSpacingStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ButtonBasedLetterSpacingStyle(parcel.readInt() == 0 ? null : StyleElements.DPMeasurement.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ButtonBasedLetterSpacingStyle[] newArray(int i10) {
            return new AttributeStyles$ButtonBasedLetterSpacingStyle[i10];
        }
    }

    public AttributeStyles$ButtonBasedLetterSpacingStyle(StyleElements.DPMeasurement dPMeasurement) {
        this.f28355a = dPMeasurement;
    }

    public final StyleElements.DPMeasurement a() {
        return this.f28355a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurement dPMeasurement = this.f28355a;
        if (dPMeasurement == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurement.writeToParcel(parcel, i10);
    }
}
