package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ComplexTextBasedTextColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ComplexTextBasedTextColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28393a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28394b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28395c;

    /* renamed from: d  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28396d;

    public static final class a implements Parcelable.Creator<AttributeStyles$ComplexTextBasedTextColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$ComplexTextBasedTextColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.ComplexElementColor complexElementColor = null;
            StyleElements.ComplexElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.ComplexElementColor createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.ComplexElementColor createFromParcel3 = parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                complexElementColor = StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$ComplexTextBasedTextColorStyle(createFromParcel, createFromParcel2, createFromParcel3, complexElementColor);
        }

        /* renamed from: b */
        public final AttributeStyles$ComplexTextBasedTextColorStyle[] newArray(int i10) {
            return new AttributeStyles$ComplexTextBasedTextColorStyle[i10];
        }
    }

    public AttributeStyles$ComplexTextBasedTextColorStyle(StyleElements.ComplexElementColor complexElementColor, StyleElements.ComplexElementColor complexElementColor2, StyleElements.ComplexElementColor complexElementColor3, StyleElements.ComplexElementColor complexElementColor4) {
        this.f28393a = complexElementColor;
        this.f28394b = complexElementColor2;
        this.f28395c = complexElementColor3;
        this.f28396d = complexElementColor4;
    }

    public final StyleElements.ComplexElementColor a() {
        return this.f28396d;
    }

    public final StyleElements.ComplexElementColor c() {
        return this.f28395c;
    }

    public final StyleElements.ComplexElementColor d() {
        return this.f28394b;
    }

    public int describeContents() {
        return 0;
    }

    public final StyleElements.ComplexElementColor e() {
        return this.f28393a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ComplexElementColor complexElementColor = this.f28393a;
        if (complexElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            complexElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.ComplexElementColor complexElementColor2 = this.f28394b;
        if (complexElementColor2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            complexElementColor2.writeToParcel(parcel, i10);
        }
        StyleElements.ComplexElementColor complexElementColor3 = this.f28395c;
        if (complexElementColor3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            complexElementColor3.writeToParcel(parcel, i10);
        }
        StyleElements.ComplexElementColor complexElementColor4 = this.f28396d;
        if (complexElementColor4 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        complexElementColor4.writeToParcel(parcel, i10);
    }
}
