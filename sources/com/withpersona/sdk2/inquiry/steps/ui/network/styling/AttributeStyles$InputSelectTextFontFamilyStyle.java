package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputSelectTextFontFamilyStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputSelectTextFontFamilyStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.FontName f28452a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.FontName f28453b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.FontName f28454c;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputSelectTextFontFamilyStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputSelectTextFontFamilyStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.FontName fontName = null;
            StyleElements.FontName createFromParcel = parcel.readInt() == 0 ? null : StyleElements.FontName.CREATOR.createFromParcel(parcel);
            StyleElements.FontName createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.FontName.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                fontName = StyleElements.FontName.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$InputSelectTextFontFamilyStyle(createFromParcel, createFromParcel2, fontName);
        }

        /* renamed from: b */
        public final AttributeStyles$InputSelectTextFontFamilyStyle[] newArray(int i10) {
            return new AttributeStyles$InputSelectTextFontFamilyStyle[i10];
        }
    }

    public AttributeStyles$InputSelectTextFontFamilyStyle(StyleElements.FontName fontName, StyleElements.FontName fontName2, StyleElements.FontName fontName3) {
        this.f28452a = fontName;
        this.f28453b = fontName2;
        this.f28454c = fontName3;
    }

    public final StyleElements.FontName a() {
        return this.f28452a;
    }

    public final StyleElements.FontName c() {
        return this.f28454c;
    }

    public final StyleElements.FontName d() {
        return this.f28453b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.FontName fontName = this.f28452a;
        if (fontName == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontName.writeToParcel(parcel, i10);
        }
        StyleElements.FontName fontName2 = this.f28453b;
        if (fontName2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontName2.writeToParcel(parcel, i10);
        }
        StyleElements.FontName fontName3 = this.f28454c;
        if (fontName3 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        fontName3.writeToParcel(parcel, i10);
    }
}
