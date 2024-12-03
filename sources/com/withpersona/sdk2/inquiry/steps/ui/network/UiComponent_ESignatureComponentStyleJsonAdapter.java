package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedFontFamilyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedFontSizeStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedFontWeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedLetterSpacingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedLineHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectStrokeColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ESignatureBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ESignatureFillColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ESignaturePrimaryButtonStyles;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ESignatureSecondaryButtonStyles;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedJustifyStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_ESignatureComponentStyleJsonAdapter extends h<UiComponent.ESignatureComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28061a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$ESignaturePrimaryButtonStyles> f28062b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$ESignatureSecondaryButtonStyles> f28063c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$ESignatureFillColorStyle> f28064d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$ESignatureBackgroundColorStyle> f28065e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedFontFamilyStyle> f28066f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedFontSizeStyle> f28067g;

    /* renamed from: h  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedFontWeightStyle> f28068h;

    /* renamed from: i  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedLetterSpacingStyle> f28069i;

    /* renamed from: j  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedLineHeightStyle> f28070j;

    /* renamed from: k  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectTextColorStyle> f28071k;

    /* renamed from: l  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectBorderRadiusStyle> f28072l;

    /* renamed from: m  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectBorderWidthStyle> f28073m;

    /* renamed from: n  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectBorderColorStyle> f28074n;

    /* renamed from: o  reason: collision with root package name */
    private final h<AttributeStyles$InputMarginStyle> f28075o;

    /* renamed from: p  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedJustifyStyle> f28076p;

    /* renamed from: q  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectStrokeColorStyle> f28077q;

    public UiComponent_ESignatureComponentStyleJsonAdapter(s sVar) {
        s sVar2 = sVar;
        j.g(sVar2, "moshi");
        JsonReader.b a10 = JsonReader.b.a("buttonPrimaryStyle", "buttonSecondaryStyle", "fillColor", "backgroundColor", "fontFamily", "fontSize", "fontWeight", "letterSpacing", "lineHeight", "textColor", "borderRadius", "borderWidth", "borderColor", "margin", "justify", "strokeColor");
        j.f(a10, "of(\"buttonPrimaryStyle\",…\"justify\", \"strokeColor\")");
        this.f28061a = a10;
        h<AttributeStyles$ESignaturePrimaryButtonStyles> f10 = sVar2.f(AttributeStyles$ESignaturePrimaryButtonStyles.class, n0.e(), "buttonPrimaryStyle");
        j.f(f10, "moshi.adapter(AttributeS…    \"buttonPrimaryStyle\")");
        this.f28062b = f10;
        h<AttributeStyles$ESignatureSecondaryButtonStyles> f11 = sVar2.f(AttributeStyles$ESignatureSecondaryButtonStyles.class, n0.e(), "buttonSecondaryStyle");
        j.f(f11, "moshi.adapter(AttributeS…  \"buttonSecondaryStyle\")");
        this.f28063c = f11;
        h<AttributeStyles$ESignatureFillColorStyle> f12 = sVar2.f(AttributeStyles$ESignatureFillColorStyle.class, n0.e(), "fillColor");
        j.f(f12, "moshi.adapter(AttributeS… emptySet(), \"fillColor\")");
        this.f28064d = f12;
        h<AttributeStyles$ESignatureBackgroundColorStyle> f13 = sVar2.f(AttributeStyles$ESignatureBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f13, "moshi.adapter(AttributeS…\n      \"backgroundColor\")");
        this.f28065e = f13;
        h<AttributeStyles$ComplexTextBasedFontFamilyStyle> f14 = sVar2.f(AttributeStyles$ComplexTextBasedFontFamilyStyle.class, n0.e(), "fontFamily");
        j.f(f14, "moshi.adapter(AttributeS…et(),\n      \"fontFamily\")");
        this.f28066f = f14;
        h<AttributeStyles$ComplexTextBasedFontSizeStyle> f15 = sVar2.f(AttributeStyles$ComplexTextBasedFontSizeStyle.class, n0.e(), "fontSize");
        j.f(f15, "moshi.adapter(AttributeS…ySet(),\n      \"fontSize\")");
        this.f28067g = f15;
        h<AttributeStyles$ComplexTextBasedFontWeightStyle> f16 = sVar2.f(AttributeStyles$ComplexTextBasedFontWeightStyle.class, n0.e(), "fontWeight");
        j.f(f16, "moshi.adapter(AttributeS…et(),\n      \"fontWeight\")");
        this.f28068h = f16;
        h<AttributeStyles$ComplexTextBasedLetterSpacingStyle> f17 = sVar2.f(AttributeStyles$ComplexTextBasedLetterSpacingStyle.class, n0.e(), "letterSpacing");
        j.f(f17, "moshi.adapter(AttributeS…),\n      \"letterSpacing\")");
        this.f28069i = f17;
        h<AttributeStyles$ComplexTextBasedLineHeightStyle> f18 = sVar2.f(AttributeStyles$ComplexTextBasedLineHeightStyle.class, n0.e(), "lineHeight");
        j.f(f18, "moshi.adapter(AttributeS…et(),\n      \"lineHeight\")");
        this.f28070j = f18;
        h<AttributeStyles$DateSelectTextColorStyle> f19 = sVar2.f(AttributeStyles$DateSelectTextColorStyle.class, n0.e(), "textColor");
        j.f(f19, "moshi.adapter(AttributeS… emptySet(), \"textColor\")");
        this.f28071k = f19;
        h<AttributeStyles$DateSelectBorderRadiusStyle> f20 = sVar2.f(AttributeStyles$DateSelectBorderRadiusStyle.class, n0.e(), "borderRadius");
        j.f(f20, "moshi.adapter(AttributeS…(),\n      \"borderRadius\")");
        this.f28072l = f20;
        h<AttributeStyles$DateSelectBorderWidthStyle> f21 = sVar2.f(AttributeStyles$DateSelectBorderWidthStyle.class, n0.e(), "borderWidth");
        j.f(f21, "moshi.adapter(AttributeS…t(),\n      \"borderWidth\")");
        this.f28073m = f21;
        h<AttributeStyles$DateSelectBorderColorStyle> f22 = sVar2.f(AttributeStyles$DateSelectBorderColorStyle.class, n0.e(), "borderColor");
        j.f(f22, "moshi.adapter(AttributeS…t(),\n      \"borderColor\")");
        this.f28074n = f22;
        h<AttributeStyles$InputMarginStyle> f23 = sVar2.f(AttributeStyles$InputMarginStyle.class, n0.e(), "margin");
        j.f(f23, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28075o = f23;
        h<AttributeStyles$TextBasedJustifyStyle> f24 = sVar2.f(AttributeStyles$TextBasedJustifyStyle.class, n0.e(), "justify");
        j.f(f24, "moshi.adapter(AttributeS…a, emptySet(), \"justify\")");
        this.f28076p = f24;
        h<AttributeStyles$DateSelectStrokeColorStyle> f25 = sVar2.f(AttributeStyles$DateSelectStrokeColorStyle.class, n0.e(), "strokeColor");
        j.f(f25, "moshi.adapter(AttributeS…t(),\n      \"strokeColor\")");
        this.f28077q = f25;
    }

    /* renamed from: a */
    public UiComponent.ESignatureComponentStyle fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        AttributeStyles$ESignaturePrimaryButtonStyles attributeStyles$ESignaturePrimaryButtonStyles = null;
        AttributeStyles$ESignatureSecondaryButtonStyles attributeStyles$ESignatureSecondaryButtonStyles = null;
        AttributeStyles$ESignatureFillColorStyle attributeStyles$ESignatureFillColorStyle = null;
        AttributeStyles$ESignatureBackgroundColorStyle attributeStyles$ESignatureBackgroundColorStyle = null;
        AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = null;
        AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = null;
        AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = null;
        AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = null;
        AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = null;
        AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle = null;
        AttributeStyles$DateSelectBorderRadiusStyle attributeStyles$DateSelectBorderRadiusStyle = null;
        AttributeStyles$DateSelectBorderWidthStyle attributeStyles$DateSelectBorderWidthStyle = null;
        AttributeStyles$DateSelectBorderColorStyle attributeStyles$DateSelectBorderColorStyle = null;
        AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = null;
        AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = null;
        AttributeStyles$DateSelectStrokeColorStyle attributeStyles$DateSelectStrokeColorStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f28061a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$ESignaturePrimaryButtonStyles = this.f28062b.fromJson(jsonReader2);
                    break;
                case 1:
                    attributeStyles$ESignatureSecondaryButtonStyles = this.f28063c.fromJson(jsonReader2);
                    break;
                case 2:
                    attributeStyles$ESignatureFillColorStyle = this.f28064d.fromJson(jsonReader2);
                    break;
                case 3:
                    attributeStyles$ESignatureBackgroundColorStyle = this.f28065e.fromJson(jsonReader2);
                    break;
                case 4:
                    attributeStyles$ComplexTextBasedFontFamilyStyle = this.f28066f.fromJson(jsonReader2);
                    break;
                case 5:
                    attributeStyles$ComplexTextBasedFontSizeStyle = this.f28067g.fromJson(jsonReader2);
                    break;
                case 6:
                    attributeStyles$ComplexTextBasedFontWeightStyle = this.f28068h.fromJson(jsonReader2);
                    break;
                case 7:
                    attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f28069i.fromJson(jsonReader2);
                    break;
                case 8:
                    attributeStyles$ComplexTextBasedLineHeightStyle = this.f28070j.fromJson(jsonReader2);
                    break;
                case 9:
                    attributeStyles$DateSelectTextColorStyle = this.f28071k.fromJson(jsonReader2);
                    break;
                case 10:
                    attributeStyles$DateSelectBorderRadiusStyle = this.f28072l.fromJson(jsonReader2);
                    break;
                case 11:
                    attributeStyles$DateSelectBorderWidthStyle = this.f28073m.fromJson(jsonReader2);
                    break;
                case 12:
                    attributeStyles$DateSelectBorderColorStyle = this.f28074n.fromJson(jsonReader2);
                    break;
                case 13:
                    attributeStyles$InputMarginStyle = this.f28075o.fromJson(jsonReader2);
                    break;
                case 14:
                    attributeStyles$TextBasedJustifyStyle = this.f28076p.fromJson(jsonReader2);
                    break;
                case 15:
                    attributeStyles$DateSelectStrokeColorStyle = this.f28077q.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.ESignatureComponentStyle(attributeStyles$ESignaturePrimaryButtonStyles, attributeStyles$ESignatureSecondaryButtonStyles, attributeStyles$ESignatureFillColorStyle, attributeStyles$ESignatureBackgroundColorStyle, attributeStyles$ComplexTextBasedFontFamilyStyle, attributeStyles$ComplexTextBasedFontSizeStyle, attributeStyles$ComplexTextBasedFontWeightStyle, attributeStyles$ComplexTextBasedLetterSpacingStyle, attributeStyles$ComplexTextBasedLineHeightStyle, attributeStyles$DateSelectTextColorStyle, attributeStyles$DateSelectBorderRadiusStyle, attributeStyles$DateSelectBorderWidthStyle, attributeStyles$DateSelectBorderColorStyle, attributeStyles$InputMarginStyle, attributeStyles$TextBasedJustifyStyle, attributeStyles$DateSelectStrokeColorStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.ESignatureComponentStyle eSignatureComponentStyle) {
        j.g(qVar, "writer");
        if (eSignatureComponentStyle != null) {
            qVar.c();
            qVar.u("buttonPrimaryStyle");
            this.f28062b.toJson(qVar, eSignatureComponentStyle.f());
            qVar.u("buttonSecondaryStyle");
            this.f28063c.toJson(qVar, eSignatureComponentStyle.g());
            qVar.u("fillColor");
            this.f28064d.toJson(qVar, eSignatureComponentStyle.i());
            qVar.u("backgroundColor");
            this.f28065e.toJson(qVar, eSignatureComponentStyle.a());
            qVar.u("fontFamily");
            this.f28066f.toJson(qVar, eSignatureComponentStyle.j());
            qVar.u("fontSize");
            this.f28067g.toJson(qVar, eSignatureComponentStyle.k());
            qVar.u("fontWeight");
            this.f28068h.toJson(qVar, eSignatureComponentStyle.l());
            qVar.u("letterSpacing");
            this.f28069i.toJson(qVar, eSignatureComponentStyle.o());
            qVar.u("lineHeight");
            this.f28070j.toJson(qVar, eSignatureComponentStyle.p());
            qVar.u("textColor");
            this.f28071k.toJson(qVar, eSignatureComponentStyle.w());
            qVar.u("borderRadius");
            this.f28072l.toJson(qVar, eSignatureComponentStyle.d());
            qVar.u("borderWidth");
            this.f28073m.toJson(qVar, eSignatureComponentStyle.e());
            qVar.u("borderColor");
            this.f28074n.toJson(qVar, eSignatureComponentStyle.c());
            qVar.u("margin");
            this.f28075o.toJson(qVar, eSignatureComponentStyle.q());
            qVar.u("justify");
            this.f28076p.toJson(qVar, eSignatureComponentStyle.n());
            qVar.u("strokeColor");
            this.f28077q.toJson(qVar, eSignatureComponentStyle.t());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.ESignatureComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
