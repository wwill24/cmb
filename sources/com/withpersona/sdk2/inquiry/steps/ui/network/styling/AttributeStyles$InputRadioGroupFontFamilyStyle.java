package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputRadioGroupFontFamilyStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputRadioGroupFontFamilyStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.FontName f28431a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.FontName f28432b;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputRadioGroupFontFamilyStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputRadioGroupFontFamilyStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.FontName fontName = null;
            StyleElements.FontName createFromParcel = parcel.readInt() == 0 ? null : StyleElements.FontName.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                fontName = StyleElements.FontName.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$InputRadioGroupFontFamilyStyle(createFromParcel, fontName);
        }

        /* renamed from: b */
        public final AttributeStyles$InputRadioGroupFontFamilyStyle[] newArray(int i10) {
            return new AttributeStyles$InputRadioGroupFontFamilyStyle[i10];
        }
    }

    public AttributeStyles$InputRadioGroupFontFamilyStyle(StyleElements.FontName fontName, StyleElements.FontName fontName2) {
        this.f28431a = fontName;
        this.f28432b = fontName2;
    }

    public final StyleElements.FontName a() {
        return this.f28431a;
    }

    public final StyleElements.FontName c() {
        return this.f28432b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.FontName fontName = this.f28431a;
        if (fontName == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontName.writeToParcel(parcel, i10);
        }
        StyleElements.FontName fontName2 = this.f28432b;
        if (fontName2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        fontName2.writeToParcel(parcel, i10);
    }
}
