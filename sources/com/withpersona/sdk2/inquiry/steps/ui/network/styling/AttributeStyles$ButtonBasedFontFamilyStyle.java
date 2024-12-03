package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ButtonBasedFontFamilyStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ButtonBasedFontFamilyStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.FontName f28350a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ButtonBasedFontFamilyStyle> {
        /* renamed from: a */
        public final AttributeStyles$ButtonBasedFontFamilyStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ButtonBasedFontFamilyStyle(parcel.readInt() == 0 ? null : StyleElements.FontName.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ButtonBasedFontFamilyStyle[] newArray(int i10) {
            return new AttributeStyles$ButtonBasedFontFamilyStyle[i10];
        }
    }

    public AttributeStyles$ButtonBasedFontFamilyStyle(StyleElements.FontName fontName) {
        this.f28350a = fontName;
    }

    public final StyleElements.FontName a() {
        return this.f28350a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.FontName fontName = this.f28350a;
        if (fontName == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        fontName.writeToParcel(parcel, i10);
    }
}
