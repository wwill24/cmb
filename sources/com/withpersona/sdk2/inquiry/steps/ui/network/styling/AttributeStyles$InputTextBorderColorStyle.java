package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputTextBorderColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputTextBorderColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28468a;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputTextBorderColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputTextBorderColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$InputTextBorderColorStyle(parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$InputTextBorderColorStyle[] newArray(int i10) {
            return new AttributeStyles$InputTextBorderColorStyle[i10];
        }
    }

    public AttributeStyles$InputTextBorderColorStyle(StyleElements.ComplexElementColor complexElementColor) {
        this.f28468a = complexElementColor;
    }

    public final StyleElements.ComplexElementColor a() {
        return this.f28468a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ComplexElementColor complexElementColor = this.f28468a;
        if (complexElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        complexElementColor.writeToParcel(parcel, i10);
    }
}
