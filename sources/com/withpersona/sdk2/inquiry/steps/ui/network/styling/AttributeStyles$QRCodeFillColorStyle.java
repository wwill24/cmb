package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$QRCodeFillColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$QRCodeFillColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28479a;

    public static final class a implements Parcelable.Creator<AttributeStyles$QRCodeFillColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$QRCodeFillColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$QRCodeFillColorStyle(parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$QRCodeFillColorStyle[] newArray(int i10) {
            return new AttributeStyles$QRCodeFillColorStyle[i10];
        }
    }

    public AttributeStyles$QRCodeFillColorStyle(StyleElements.SimpleElementColor simpleElementColor) {
        this.f28479a = simpleElementColor;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28479a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28479a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
