package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class TextBasedComponentStyle implements Parcelable {
    public static final Parcelable.Creator<TextBasedComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AttributeStyles$TextBasedMarginStyle f29218a;

    /* renamed from: b  reason: collision with root package name */
    private final AttributeStyles$TextBasedJustifyStyle f29219b;

    /* renamed from: c  reason: collision with root package name */
    private final AttributeStyles$TextBasedFontFamilyStyle f29220c;

    /* renamed from: d  reason: collision with root package name */
    private final AttributeStyles$TextBasedFontSizeStyle f29221d;

    /* renamed from: e  reason: collision with root package name */
    private final AttributeStyles$TextBasedFontWeightStyle f29222e;

    /* renamed from: f  reason: collision with root package name */
    private final AttributeStyles$TextBasedLetterSpacingStyle f29223f;

    /* renamed from: g  reason: collision with root package name */
    private final AttributeStyles$TextBasedLineHeightStyle f29224g;

    /* renamed from: h  reason: collision with root package name */
    private final AttributeStyles$TextBasedTextColorStyle f29225h;

    /* renamed from: j  reason: collision with root package name */
    private final AttributeStyles$TextBasedTextColorStyle f29226j;

    public static final class a implements Parcelable.Creator<TextBasedComponentStyle> {
        /* renamed from: a */
        public final TextBasedComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = null;
            AttributeStyles$TextBasedMarginStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedMarginStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$TextBasedJustifyStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedJustifyStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$TextBasedFontFamilyStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedFontFamilyStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$TextBasedFontSizeStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedFontSizeStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$TextBasedFontWeightStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedFontWeightStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$TextBasedLetterSpacingStyle createFromParcel6 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedLetterSpacingStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$TextBasedLineHeightStyle createFromParcel7 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedLineHeightStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$TextBasedTextColorStyle createFromParcel8 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedTextColorStyle.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                attributeStyles$TextBasedTextColorStyle = AttributeStyles$TextBasedTextColorStyle.CREATOR.createFromParcel(parcel);
            }
            return new TextBasedComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, attributeStyles$TextBasedTextColorStyle);
        }

        /* renamed from: b */
        public final TextBasedComponentStyle[] newArray(int i10) {
            return new TextBasedComponentStyle[i10];
        }
    }

    public TextBasedComponentStyle(AttributeStyles$TextBasedMarginStyle attributeStyles$TextBasedMarginStyle, AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle, AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle, AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle, AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle, AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle, AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle, AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle, AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle2) {
        this.f29218a = attributeStyles$TextBasedMarginStyle;
        this.f29219b = attributeStyles$TextBasedJustifyStyle;
        this.f29220c = attributeStyles$TextBasedFontFamilyStyle;
        this.f29221d = attributeStyles$TextBasedFontSizeStyle;
        this.f29222e = attributeStyles$TextBasedFontWeightStyle;
        this.f29223f = attributeStyles$TextBasedLetterSpacingStyle;
        this.f29224g = attributeStyles$TextBasedLineHeightStyle;
        this.f29225h = attributeStyles$TextBasedTextColorStyle;
        this.f29226j = attributeStyles$TextBasedTextColorStyle2;
    }

    public final AttributeStyles$TextBasedFontFamilyStyle a() {
        return this.f29220c;
    }

    public final String c() {
        StyleElements.FontName a10;
        AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = this.f29220c;
        if (attributeStyles$TextBasedFontFamilyStyle == null || (a10 = attributeStyles$TextBasedFontFamilyStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final AttributeStyles$TextBasedFontSizeStyle d() {
        return this.f29221d;
    }

    public int describeContents() {
        return 0;
    }

    public final Double e() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = this.f29221d;
        if (attributeStyles$TextBasedFontSizeStyle == null || (a10 = attributeStyles$TextBasedFontSizeStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final AttributeStyles$TextBasedFontWeightStyle f() {
        return this.f29222e;
    }

    public final StyleElements.FontWeight g() {
        StyleElements.FontWeightContainer a10;
        AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = this.f29222e;
        if (attributeStyles$TextBasedFontWeightStyle == null || (a10 = attributeStyles$TextBasedFontWeightStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StyleElements.PositionType h() {
        StyleElements.Position a10;
        AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = this.f29219b;
        if (attributeStyles$TextBasedJustifyStyle == null || (a10 = attributeStyles$TextBasedJustifyStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final AttributeStyles$TextBasedJustifyStyle i() {
        return this.f29219b;
    }

    public final AttributeStyles$TextBasedLetterSpacingStyle j() {
        return this.f29223f;
    }

    public final Double k() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = this.f29223f;
        if (attributeStyles$TextBasedLetterSpacingStyle == null || (a10 = attributeStyles$TextBasedLetterSpacingStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final AttributeStyles$TextBasedLineHeightStyle l() {
        return this.f29224g;
    }

    public final Double m() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = this.f29224g;
        if (attributeStyles$TextBasedLineHeightStyle == null || (a10 = attributeStyles$TextBasedLineHeightStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final AttributeStyles$TextBasedMarginStyle n() {
        return this.f29218a;
    }

    public final StyleElements.DPSizeSet o() {
        StyleElements.DPMeasurementSet a10;
        AttributeStyles$TextBasedMarginStyle attributeStyles$TextBasedMarginStyle = this.f29218a;
        if (attributeStyles$TextBasedMarginStyle == null || (a10 = attributeStyles$TextBasedMarginStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final AttributeStyles$TextBasedTextColorStyle p() {
        return this.f29225h;
    }

    public final AttributeStyles$TextBasedTextColorStyle q() {
        return this.f29226j;
    }

    public final String r() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = this.f29226j;
        if (attributeStyles$TextBasedTextColorStyle == null || (a10 = attributeStyles$TextBasedTextColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final String s() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = this.f29225h;
        if (attributeStyles$TextBasedTextColorStyle == null || (a10 = attributeStyles$TextBasedTextColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        AttributeStyles$TextBasedMarginStyle attributeStyles$TextBasedMarginStyle = this.f29218a;
        if (attributeStyles$TextBasedMarginStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$TextBasedMarginStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = this.f29219b;
        if (attributeStyles$TextBasedJustifyStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$TextBasedJustifyStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = this.f29220c;
        if (attributeStyles$TextBasedFontFamilyStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$TextBasedFontFamilyStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = this.f29221d;
        if (attributeStyles$TextBasedFontSizeStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$TextBasedFontSizeStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = this.f29222e;
        if (attributeStyles$TextBasedFontWeightStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$TextBasedFontWeightStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = this.f29223f;
        if (attributeStyles$TextBasedLetterSpacingStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$TextBasedLetterSpacingStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = this.f29224g;
        if (attributeStyles$TextBasedLineHeightStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$TextBasedLineHeightStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = this.f29225h;
        if (attributeStyles$TextBasedTextColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$TextBasedTextColorStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle2 = this.f29226j;
        if (attributeStyles$TextBasedTextColorStyle2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        attributeStyles$TextBasedTextColorStyle2.writeToParcel(parcel, i10);
    }
}
