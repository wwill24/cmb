package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class ButtonCombinedStepComponentStyle implements Parcelable, a {
    public static final Parcelable.Creator<ButtonCombinedStepComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedPaddingStyle f28773a;

    /* renamed from: b  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedMarginStyle f28774b;

    /* renamed from: c  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedJustifyStyle f28775c;

    /* renamed from: d  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedFontFamilyStyle f28776d;

    /* renamed from: e  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedFontSizeStyle f28777e;

    /* renamed from: f  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedFontWeightStyle f28778f;

    /* renamed from: g  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedLetterSpacingStyle f28779g;

    /* renamed from: h  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedLineHeightStyle f28780h;

    /* renamed from: j  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedTextColorStyle f28781j;

    /* renamed from: k  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedHeightStyle f28782k;

    /* renamed from: l  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedWidthStyle f28783l;

    /* renamed from: m  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedBackgroundColorStyle f28784m;

    /* renamed from: n  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedBorderColorStyle f28785n;

    /* renamed from: p  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedBorderRadiusStyle f28786p;

    /* renamed from: q  reason: collision with root package name */
    private final AttributeStyles$ButtonBasedBorderWidthStyle f28787q;

    public static final class a implements Parcelable.Creator<ButtonCombinedStepComponentStyle> {
        /* renamed from: a */
        public final ButtonCombinedStepComponentStyle createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            j.g(parcel2, "parcel");
            AttributeStyles$ButtonBasedBorderWidthStyle attributeStyles$ButtonBasedBorderWidthStyle = null;
            AttributeStyles$ButtonBasedPaddingStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedPaddingStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedMarginStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedMarginStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedJustifyStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedJustifyStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedFontFamilyStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedFontFamilyStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedFontSizeStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedFontSizeStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedFontWeightStyle createFromParcel6 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedFontWeightStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedLetterSpacingStyle createFromParcel7 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedLetterSpacingStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedLineHeightStyle createFromParcel8 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedLineHeightStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedTextColorStyle createFromParcel9 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedTextColorStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedHeightStyle createFromParcel10 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedHeightStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedWidthStyle createFromParcel11 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedWidthStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedBackgroundColorStyle createFromParcel12 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedBackgroundColorStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedBorderColorStyle createFromParcel13 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedBorderColorStyle.CREATOR.createFromParcel(parcel2);
            AttributeStyles$ButtonBasedBorderRadiusStyle createFromParcel14 = parcel.readInt() == 0 ? null : AttributeStyles$ButtonBasedBorderRadiusStyle.CREATOR.createFromParcel(parcel2);
            if (parcel.readInt() != 0) {
                attributeStyles$ButtonBasedBorderWidthStyle = AttributeStyles$ButtonBasedBorderWidthStyle.CREATOR.createFromParcel(parcel2);
            }
            return new ButtonCombinedStepComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, createFromParcel12, createFromParcel13, createFromParcel14, attributeStyles$ButtonBasedBorderWidthStyle);
        }

        /* renamed from: b */
        public final ButtonCombinedStepComponentStyle[] newArray(int i10) {
            return new ButtonCombinedStepComponentStyle[i10];
        }
    }

    public ButtonCombinedStepComponentStyle(AttributeStyles$ButtonBasedPaddingStyle attributeStyles$ButtonBasedPaddingStyle, AttributeStyles$ButtonBasedMarginStyle attributeStyles$ButtonBasedMarginStyle, AttributeStyles$ButtonBasedJustifyStyle attributeStyles$ButtonBasedJustifyStyle, AttributeStyles$ButtonBasedFontFamilyStyle attributeStyles$ButtonBasedFontFamilyStyle, AttributeStyles$ButtonBasedFontSizeStyle attributeStyles$ButtonBasedFontSizeStyle, AttributeStyles$ButtonBasedFontWeightStyle attributeStyles$ButtonBasedFontWeightStyle, AttributeStyles$ButtonBasedLetterSpacingStyle attributeStyles$ButtonBasedLetterSpacingStyle, AttributeStyles$ButtonBasedLineHeightStyle attributeStyles$ButtonBasedLineHeightStyle, AttributeStyles$ButtonBasedTextColorStyle attributeStyles$ButtonBasedTextColorStyle, AttributeStyles$ButtonBasedHeightStyle attributeStyles$ButtonBasedHeightStyle, AttributeStyles$ButtonBasedWidthStyle attributeStyles$ButtonBasedWidthStyle, AttributeStyles$ButtonBasedBackgroundColorStyle attributeStyles$ButtonBasedBackgroundColorStyle, AttributeStyles$ButtonBasedBorderColorStyle attributeStyles$ButtonBasedBorderColorStyle, AttributeStyles$ButtonBasedBorderRadiusStyle attributeStyles$ButtonBasedBorderRadiusStyle, AttributeStyles$ButtonBasedBorderWidthStyle attributeStyles$ButtonBasedBorderWidthStyle) {
        this.f28773a = attributeStyles$ButtonBasedPaddingStyle;
        this.f28774b = attributeStyles$ButtonBasedMarginStyle;
        this.f28775c = attributeStyles$ButtonBasedJustifyStyle;
        this.f28776d = attributeStyles$ButtonBasedFontFamilyStyle;
        this.f28777e = attributeStyles$ButtonBasedFontSizeStyle;
        this.f28778f = attributeStyles$ButtonBasedFontWeightStyle;
        this.f28779g = attributeStyles$ButtonBasedLetterSpacingStyle;
        this.f28780h = attributeStyles$ButtonBasedLineHeightStyle;
        this.f28781j = attributeStyles$ButtonBasedTextColorStyle;
        this.f28782k = attributeStyles$ButtonBasedHeightStyle;
        this.f28783l = attributeStyles$ButtonBasedWidthStyle;
        this.f28784m = attributeStyles$ButtonBasedBackgroundColorStyle;
        this.f28785n = attributeStyles$ButtonBasedBorderColorStyle;
        this.f28786p = attributeStyles$ButtonBasedBorderRadiusStyle;
        this.f28787q = attributeStyles$ButtonBasedBorderWidthStyle;
    }

    public final AttributeStyles$ButtonBasedBorderRadiusStyle A() {
        return this.f28786p;
    }

    public final AttributeStyles$ButtonBasedBorderWidthStyle B() {
        return this.f28787q;
    }

    public final AttributeStyles$ButtonBasedFontFamilyStyle D() {
        return this.f28776d;
    }

    public final AttributeStyles$ButtonBasedFontSizeStyle E() {
        return this.f28777e;
    }

    public final AttributeStyles$ButtonBasedFontWeightStyle F() {
        return this.f28778f;
    }

    public final AttributeStyles$ButtonBasedHeightStyle G() {
        return this.f28782k;
    }

    public final AttributeStyles$ButtonBasedJustifyStyle H() {
        return this.f28775c;
    }

    public final AttributeStyles$ButtonBasedLetterSpacingStyle I() {
        return this.f28779g;
    }

    public final AttributeStyles$ButtonBasedLineHeightStyle K() {
        return this.f28780h;
    }

    public final AttributeStyles$ButtonBasedMarginStyle L() {
        return this.f28774b;
    }

    public final AttributeStyles$ButtonBasedPaddingStyle M() {
        return this.f28773a;
    }

    public final AttributeStyles$ButtonBasedTextColorStyle O() {
        return this.f28781j;
    }

    public final AttributeStyles$ButtonBasedWidthStyle P() {
        return this.f28783l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.a()).a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a() {
        /*
            r1 = this;
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ButtonBasedBackgroundColorStyle r0 = r1.f28784m
            if (r0 == 0) goto L_0x0010
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r0 = r0.a()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.a()
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            java.lang.String r0 = "#D3D3D3"
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCombinedStepComponentStyle.a():java.lang.String");
    }

    public StyleElements.FontWeight c() {
        StyleElements.FontWeightContainer a10;
        AttributeStyles$ButtonBasedFontWeightStyle attributeStyles$ButtonBasedFontWeightStyle = this.f28778f;
        if (attributeStyles$ButtonBasedFontWeightStyle == null || (a10 = attributeStyles$ButtonBasedFontWeightStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public String d() {
        StyleElements.ComplexElementColor a10;
        AttributeStyles$ButtonBasedBorderColorStyle attributeStyles$ButtonBasedBorderColorStyle = this.f28785n;
        if (attributeStyles$ButtonBasedBorderColorStyle == null || (a10 = attributeStyles$ButtonBasedBorderColorStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public int describeContents() {
        return 0;
    }

    public Double e() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        AttributeStyles$ButtonBasedHeightStyle attributeStyles$ButtonBasedHeightStyle = this.f28782k;
        if (attributeStyles$ButtonBasedHeightStyle == null || (a10 = attributeStyles$ButtonBasedHeightStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public StyleElements.DPSizeSet f() {
        StyleElements.DPMeasurementSet a10;
        AttributeStyles$ButtonBasedMarginStyle attributeStyles$ButtonBasedMarginStyle = this.f28774b;
        if (attributeStyles$ButtonBasedMarginStyle == null || (a10 = attributeStyles$ButtonBasedMarginStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public Double g() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        AttributeStyles$ButtonBasedBorderRadiusStyle attributeStyles$ButtonBasedBorderRadiusStyle = this.f28786p;
        if (attributeStyles$ButtonBasedBorderRadiusStyle == null || (a10 = attributeStyles$ButtonBasedBorderRadiusStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public String h() {
        StyleElements.ComplexElementColor a10;
        AttributeStyles$ButtonBasedBackgroundColorStyle attributeStyles$ButtonBasedBackgroundColorStyle = this.f28784m;
        if (attributeStyles$ButtonBasedBackgroundColorStyle == null || (a10 = attributeStyles$ButtonBasedBackgroundColorStyle.a()) == null) {
            return null;
        }
        return a10.c();
    }

    public Double i() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        AttributeStyles$ButtonBasedLineHeightStyle attributeStyles$ButtonBasedLineHeightStyle = this.f28780h;
        if (attributeStyles$ButtonBasedLineHeightStyle == null || (a10 = attributeStyles$ButtonBasedLineHeightStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public Double j() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        AttributeStyles$ButtonBasedWidthStyle attributeStyles$ButtonBasedWidthStyle = this.f28783l;
        if (attributeStyles$ButtonBasedWidthStyle == null || (a10 = attributeStyles$ButtonBasedWidthStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public StyleElements.PositionType k() {
        StyleElements.Position a10;
        AttributeStyles$ButtonBasedJustifyStyle attributeStyles$ButtonBasedJustifyStyle = this.f28775c;
        if (attributeStyles$ButtonBasedJustifyStyle == null || (a10 = attributeStyles$ButtonBasedJustifyStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public Double l() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        AttributeStyles$ButtonBasedLetterSpacingStyle attributeStyles$ButtonBasedLetterSpacingStyle = this.f28779g;
        if (attributeStyles$ButtonBasedLetterSpacingStyle == null || (a10 = attributeStyles$ButtonBasedLetterSpacingStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.a()).d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m() {
        /*
            r1 = this;
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ButtonBasedBackgroundColorStyle r0 = r1.f28784m
            if (r0 == 0) goto L_0x0010
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r0 = r0.a()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.d()
            if (r0 != 0) goto L_0x0014
        L_0x0010:
            java.lang.String r0 = r1.h()
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCombinedStepComponentStyle.m():java.lang.String");
    }

    public String n() {
        StyleElements.ComplexElementColor a10;
        AttributeStyles$ButtonBasedTextColorStyle attributeStyles$ButtonBasedTextColorStyle = this.f28781j;
        if (attributeStyles$ButtonBasedTextColorStyle == null || (a10 = attributeStyles$ButtonBasedTextColorStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public Double o() {
        StyleElements.DPMeasurementSet a10;
        StyleElements.DPSizeSet a11;
        StyleElements.DPSize e10;
        AttributeStyles$ButtonBasedBorderWidthStyle attributeStyles$ButtonBasedBorderWidthStyle = this.f28787q;
        if (attributeStyles$ButtonBasedBorderWidthStyle == null || (a10 = attributeStyles$ButtonBasedBorderWidthStyle.a()) == null || (a11 = a10.a()) == null || (e10 = a11.e()) == null) {
            return null;
        }
        return e10.a();
    }

    public String p() {
        StyleElements.ComplexElementColor a10;
        AttributeStyles$ButtonBasedTextColorStyle attributeStyles$ButtonBasedTextColorStyle = this.f28781j;
        if (attributeStyles$ButtonBasedTextColorStyle == null || (a10 = attributeStyles$ButtonBasedTextColorStyle.a()) == null) {
            return null;
        }
        return a10.c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.a()).d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String q() {
        /*
            r1 = this;
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ButtonBasedBorderColorStyle r0 = r1.f28785n
            if (r0 == 0) goto L_0x0010
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r0 = r0.a()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.d()
            if (r0 != 0) goto L_0x0014
        L_0x0010:
            java.lang.String r0 = r1.t()
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCombinedStepComponentStyle.q():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.a()).d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String r() {
        /*
            r1 = this;
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ButtonBasedTextColorStyle r0 = r1.f28781j
            if (r0 == 0) goto L_0x0010
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r0 = r0.a()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.d()
            if (r0 != 0) goto L_0x0014
        L_0x0010:
            java.lang.String r0 = r1.p()
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCombinedStepComponentStyle.r():java.lang.String");
    }

    public Double s() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        AttributeStyles$ButtonBasedFontSizeStyle attributeStyles$ButtonBasedFontSizeStyle = this.f28777e;
        if (attributeStyles$ButtonBasedFontSizeStyle == null || (a10 = attributeStyles$ButtonBasedFontSizeStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public String t() {
        StyleElements.ComplexElementColor a10;
        AttributeStyles$ButtonBasedBorderColorStyle attributeStyles$ButtonBasedBorderColorStyle = this.f28785n;
        if (attributeStyles$ButtonBasedBorderColorStyle == null || (a10 = attributeStyles$ButtonBasedBorderColorStyle.a()) == null) {
            return null;
        }
        return a10.c();
    }

    public StyleElements.DPSizeSet u() {
        StyleElements.DPMeasurementSet a10;
        AttributeStyles$ButtonBasedPaddingStyle attributeStyles$ButtonBasedPaddingStyle = this.f28773a;
        if (attributeStyles$ButtonBasedPaddingStyle == null || (a10 = attributeStyles$ButtonBasedPaddingStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public String w() {
        StyleElements.FontName a10;
        AttributeStyles$ButtonBasedFontFamilyStyle attributeStyles$ButtonBasedFontFamilyStyle = this.f28776d;
        if (attributeStyles$ButtonBasedFontFamilyStyle == null || (a10 = attributeStyles$ButtonBasedFontFamilyStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        AttributeStyles$ButtonBasedPaddingStyle attributeStyles$ButtonBasedPaddingStyle = this.f28773a;
        if (attributeStyles$ButtonBasedPaddingStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedPaddingStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedMarginStyle attributeStyles$ButtonBasedMarginStyle = this.f28774b;
        if (attributeStyles$ButtonBasedMarginStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedMarginStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedJustifyStyle attributeStyles$ButtonBasedJustifyStyle = this.f28775c;
        if (attributeStyles$ButtonBasedJustifyStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedJustifyStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedFontFamilyStyle attributeStyles$ButtonBasedFontFamilyStyle = this.f28776d;
        if (attributeStyles$ButtonBasedFontFamilyStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedFontFamilyStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedFontSizeStyle attributeStyles$ButtonBasedFontSizeStyle = this.f28777e;
        if (attributeStyles$ButtonBasedFontSizeStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedFontSizeStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedFontWeightStyle attributeStyles$ButtonBasedFontWeightStyle = this.f28778f;
        if (attributeStyles$ButtonBasedFontWeightStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedFontWeightStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedLetterSpacingStyle attributeStyles$ButtonBasedLetterSpacingStyle = this.f28779g;
        if (attributeStyles$ButtonBasedLetterSpacingStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedLetterSpacingStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedLineHeightStyle attributeStyles$ButtonBasedLineHeightStyle = this.f28780h;
        if (attributeStyles$ButtonBasedLineHeightStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedLineHeightStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedTextColorStyle attributeStyles$ButtonBasedTextColorStyle = this.f28781j;
        if (attributeStyles$ButtonBasedTextColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedTextColorStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedHeightStyle attributeStyles$ButtonBasedHeightStyle = this.f28782k;
        if (attributeStyles$ButtonBasedHeightStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedHeightStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedWidthStyle attributeStyles$ButtonBasedWidthStyle = this.f28783l;
        if (attributeStyles$ButtonBasedWidthStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedWidthStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedBackgroundColorStyle attributeStyles$ButtonBasedBackgroundColorStyle = this.f28784m;
        if (attributeStyles$ButtonBasedBackgroundColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedBackgroundColorStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedBorderColorStyle attributeStyles$ButtonBasedBorderColorStyle = this.f28785n;
        if (attributeStyles$ButtonBasedBorderColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedBorderColorStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedBorderRadiusStyle attributeStyles$ButtonBasedBorderRadiusStyle = this.f28786p;
        if (attributeStyles$ButtonBasedBorderRadiusStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$ButtonBasedBorderRadiusStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$ButtonBasedBorderWidthStyle attributeStyles$ButtonBasedBorderWidthStyle = this.f28787q;
        if (attributeStyles$ButtonBasedBorderWidthStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        attributeStyles$ButtonBasedBorderWidthStyle.writeToParcel(parcel, i10);
    }

    public final AttributeStyles$ButtonBasedBackgroundColorStyle x() {
        return this.f28784m;
    }

    public final AttributeStyles$ButtonBasedBorderColorStyle z() {
        return this.f28785n;
    }
}
