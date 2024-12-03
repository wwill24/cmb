package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$QRCodeStrokeColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$QRCodeStrokeColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28482a;

    public static final class a implements Parcelable.Creator<AttributeStyles$QRCodeStrokeColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$QRCodeStrokeColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$QRCodeStrokeColorStyle(parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$QRCodeStrokeColorStyle[] newArray(int i10) {
            return new AttributeStyles$QRCodeStrokeColorStyle[i10];
        }
    }

    public AttributeStyles$QRCodeStrokeColorStyle(StyleElements.SimpleElementColor simpleElementColor) {
        this.f28482a = simpleElementColor;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28482a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28482a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
