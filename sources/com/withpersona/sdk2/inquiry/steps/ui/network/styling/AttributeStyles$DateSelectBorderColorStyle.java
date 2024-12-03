package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$DateSelectBorderColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$DateSelectBorderColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28399a;

    public static final class a implements Parcelable.Creator<AttributeStyles$DateSelectBorderColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$DateSelectBorderColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$DateSelectBorderColorStyle(parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$DateSelectBorderColorStyle[] newArray(int i10) {
            return new AttributeStyles$DateSelectBorderColorStyle[i10];
        }
    }

    public AttributeStyles$DateSelectBorderColorStyle(StyleElements.ComplexElementColor complexElementColor) {
        this.f28399a = complexElementColor;
    }

    public final StyleElements.ComplexElementColor a() {
        return this.f28399a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ComplexElementColor complexElementColor = this.f28399a;
        if (complexElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        complexElementColor.writeToParcel(parcel, i10);
    }
}
