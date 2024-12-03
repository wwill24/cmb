package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ComplexTextBasedFontFamilyStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ComplexTextBasedFontFamilyStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.FontName f28371a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.FontName f28372b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.FontName f28373c;

    /* renamed from: d  reason: collision with root package name */
    private final StyleElements.FontName f28374d;

    /* renamed from: e  reason: collision with root package name */
    private final StyleElements.FontName f28375e;

    public static final class a implements Parcelable.Creator<AttributeStyles$ComplexTextBasedFontFamilyStyle> {
        /* renamed from: a */
        public final AttributeStyles$ComplexTextBasedFontFamilyStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.FontName fontName = null;
            StyleElements.FontName createFromParcel = parcel.readInt() == 0 ? null : StyleElements.FontName.CREATOR.createFromParcel(parcel);
            StyleElements.FontName createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.FontName.CREATOR.createFromParcel(parcel);
            StyleElements.FontName createFromParcel3 = parcel.readInt() == 0 ? null : StyleElements.FontName.CREATOR.createFromParcel(parcel);
            StyleElements.FontName createFromParcel4 = parcel.readInt() == 0 ? null : StyleElements.FontName.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                fontName = StyleElements.FontName.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$ComplexTextBasedFontFamilyStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, fontName);
        }

        /* renamed from: b */
        public final AttributeStyles$ComplexTextBasedFontFamilyStyle[] newArray(int i10) {
            return new AttributeStyles$ComplexTextBasedFontFamilyStyle[i10];
        }
    }

    public AttributeStyles$ComplexTextBasedFontFamilyStyle(StyleElements.FontName fontName, StyleElements.FontName fontName2, StyleElements.FontName fontName3, StyleElements.FontName fontName4, StyleElements.FontName fontName5) {
        this.f28371a = fontName;
        this.f28372b = fontName2;
        this.f28373c = fontName3;
        this.f28374d = fontName4;
        this.f28375e = fontName5;
    }

    public final StyleElements.FontName a() {
        return this.f28371a;
    }

    public final StyleElements.FontName c() {
        return this.f28375e;
    }

    public final StyleElements.FontName d() {
        return this.f28374d;
    }

    public int describeContents() {
        return 0;
    }

    public final StyleElements.FontName e() {
        return this.f28373c;
    }

    public final StyleElements.FontName f() {
        return this.f28372b;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.FontName fontName = this.f28371a;
        if (fontName == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontName.writeToParcel(parcel, i10);
        }
        StyleElements.FontName fontName2 = this.f28372b;
        if (fontName2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontName2.writeToParcel(parcel, i10);
        }
        StyleElements.FontName fontName3 = this.f28373c;
        if (fontName3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontName3.writeToParcel(parcel, i10);
        }
        StyleElements.FontName fontName4 = this.f28374d;
        if (fontName4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontName4.writeToParcel(parcel, i10);
        }
        StyleElements.FontName fontName5 = this.f28375e;
        if (fontName5 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        fontName5.writeToParcel(parcel, i10);
    }
}
