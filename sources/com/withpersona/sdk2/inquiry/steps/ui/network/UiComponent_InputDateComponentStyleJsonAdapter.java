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
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectStrokeColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedJustifyStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_InputDateComponentStyleJsonAdapter extends h<UiComponent.InputDateComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28147a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedFontFamilyStyle> f28148b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedFontSizeStyle> f28149c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedFontWeightStyle> f28150d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedLetterSpacingStyle> f28151e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedLineHeightStyle> f28152f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectTextColorStyle> f28153g;

    /* renamed from: h  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectBorderRadiusStyle> f28154h;

    /* renamed from: i  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectBorderWidthStyle> f28155i;

    /* renamed from: j  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectBackgroundColorStyle> f28156j;

    /* renamed from: k  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectBorderColorStyle> f28157k;

    /* renamed from: l  reason: collision with root package name */
    private final h<AttributeStyles$InputMarginStyle> f28158l;

    /* renamed from: m  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedJustifyStyle> f28159m;

    /* renamed from: n  reason: collision with root package name */
    private final h<AttributeStyles$DateSelectStrokeColorStyle> f28160n;

    public UiComponent_InputDateComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("fontFamily", "fontSize", "fontWeight", "letterSpacing", "lineHeight", "textColor", "borderRadius", "borderWidth", "backgroundColor", "borderColor", "margin", "justify", "strokeColor");
        j.f(a10, "of(\"fontFamily\", \"fontSi…\"justify\", \"strokeColor\")");
        this.f28147a = a10;
        h<AttributeStyles$ComplexTextBasedFontFamilyStyle> f10 = sVar.f(AttributeStyles$ComplexTextBasedFontFamilyStyle.class, n0.e(), "fontFamily");
        j.f(f10, "moshi.adapter(AttributeS…et(),\n      \"fontFamily\")");
        this.f28148b = f10;
        h<AttributeStyles$ComplexTextBasedFontSizeStyle> f11 = sVar.f(AttributeStyles$ComplexTextBasedFontSizeStyle.class, n0.e(), "fontSize");
        j.f(f11, "moshi.adapter(AttributeS…ySet(),\n      \"fontSize\")");
        this.f28149c = f11;
        h<AttributeStyles$ComplexTextBasedFontWeightStyle> f12 = sVar.f(AttributeStyles$ComplexTextBasedFontWeightStyle.class, n0.e(), "fontWeight");
        j.f(f12, "moshi.adapter(AttributeS…et(),\n      \"fontWeight\")");
        this.f28150d = f12;
        h<AttributeStyles$ComplexTextBasedLetterSpacingStyle> f13 = sVar.f(AttributeStyles$ComplexTextBasedLetterSpacingStyle.class, n0.e(), "letterSpacing");
        j.f(f13, "moshi.adapter(AttributeS…),\n      \"letterSpacing\")");
        this.f28151e = f13;
        h<AttributeStyles$ComplexTextBasedLineHeightStyle> f14 = sVar.f(AttributeStyles$ComplexTextBasedLineHeightStyle.class, n0.e(), "lineHeight");
        j.f(f14, "moshi.adapter(AttributeS…et(),\n      \"lineHeight\")");
        this.f28152f = f14;
        h<AttributeStyles$DateSelectTextColorStyle> f15 = sVar.f(AttributeStyles$DateSelectTextColorStyle.class, n0.e(), "textColor");
        j.f(f15, "moshi.adapter(AttributeS… emptySet(), \"textColor\")");
        this.f28153g = f15;
        h<AttributeStyles$DateSelectBorderRadiusStyle> f16 = sVar.f(AttributeStyles$DateSelectBorderRadiusStyle.class, n0.e(), "borderRadius");
        j.f(f16, "moshi.adapter(AttributeS…(),\n      \"borderRadius\")");
        this.f28154h = f16;
        h<AttributeStyles$DateSelectBorderWidthStyle> f17 = sVar.f(AttributeStyles$DateSelectBorderWidthStyle.class, n0.e(), "borderWidth");
        j.f(f17, "moshi.adapter(AttributeS…t(),\n      \"borderWidth\")");
        this.f28155i = f17;
        h<AttributeStyles$DateSelectBackgroundColorStyle> f18 = sVar.f(AttributeStyles$DateSelectBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f18, "moshi.adapter(AttributeS…\n      \"backgroundColor\")");
        this.f28156j = f18;
        h<AttributeStyles$DateSelectBorderColorStyle> f19 = sVar.f(AttributeStyles$DateSelectBorderColorStyle.class, n0.e(), "borderColor");
        j.f(f19, "moshi.adapter(AttributeS…t(),\n      \"borderColor\")");
        this.f28157k = f19;
        h<AttributeStyles$InputMarginStyle> f20 = sVar.f(AttributeStyles$InputMarginStyle.class, n0.e(), "margin");
        j.f(f20, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28158l = f20;
        h<AttributeStyles$TextBasedJustifyStyle> f21 = sVar.f(AttributeStyles$TextBasedJustifyStyle.class, n0.e(), "justify");
        j.f(f21, "moshi.adapter(AttributeS…a, emptySet(), \"justify\")");
        this.f28159m = f21;
        h<AttributeStyles$DateSelectStrokeColorStyle> f22 = sVar.f(AttributeStyles$DateSelectStrokeColorStyle.class, n0.e(), "strokeColor");
        j.f(f22, "moshi.adapter(AttributeS…t(),\n      \"strokeColor\")");
        this.f28160n = f22;
    }

    /* renamed from: a */
    public UiComponent.InputDateComponentStyle fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = null;
        AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = null;
        AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = null;
        AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = null;
        AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = null;
        AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle = null;
        AttributeStyles$DateSelectBorderRadiusStyle attributeStyles$DateSelectBorderRadiusStyle = null;
        AttributeStyles$DateSelectBorderWidthStyle attributeStyles$DateSelectBorderWidthStyle = null;
        AttributeStyles$DateSelectBackgroundColorStyle attributeStyles$DateSelectBackgroundColorStyle = null;
        AttributeStyles$DateSelectBorderColorStyle attributeStyles$DateSelectBorderColorStyle = null;
        AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = null;
        AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = null;
        AttributeStyles$DateSelectStrokeColorStyle attributeStyles$DateSelectStrokeColorStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f28147a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$ComplexTextBasedFontFamilyStyle = this.f28148b.fromJson(jsonReader2);
                    break;
                case 1:
                    attributeStyles$ComplexTextBasedFontSizeStyle = this.f28149c.fromJson(jsonReader2);
                    break;
                case 2:
                    attributeStyles$ComplexTextBasedFontWeightStyle = this.f28150d.fromJson(jsonReader2);
                    break;
                case 3:
                    attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f28151e.fromJson(jsonReader2);
                    break;
                case 4:
                    attributeStyles$ComplexTextBasedLineHeightStyle = this.f28152f.fromJson(jsonReader2);
                    break;
                case 5:
                    attributeStyles$DateSelectTextColorStyle = this.f28153g.fromJson(jsonReader2);
                    break;
                case 6:
                    attributeStyles$DateSelectBorderRadiusStyle = this.f28154h.fromJson(jsonReader2);
                    break;
                case 7:
                    attributeStyles$DateSelectBorderWidthStyle = this.f28155i.fromJson(jsonReader2);
                    break;
                case 8:
                    attributeStyles$DateSelectBackgroundColorStyle = this.f28156j.fromJson(jsonReader2);
                    break;
                case 9:
                    attributeStyles$DateSelectBorderColorStyle = this.f28157k.fromJson(jsonReader2);
                    break;
                case 10:
                    attributeStyles$InputMarginStyle = this.f28158l.fromJson(jsonReader2);
                    break;
                case 11:
                    attributeStyles$TextBasedJustifyStyle = this.f28159m.fromJson(jsonReader2);
                    break;
                case 12:
                    attributeStyles$DateSelectStrokeColorStyle = this.f28160n.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.InputDateComponentStyle(attributeStyles$ComplexTextBasedFontFamilyStyle, attributeStyles$ComplexTextBasedFontSizeStyle, attributeStyles$ComplexTextBasedFontWeightStyle, attributeStyles$ComplexTextBasedLetterSpacingStyle, attributeStyles$ComplexTextBasedLineHeightStyle, attributeStyles$DateSelectTextColorStyle, attributeStyles$DateSelectBorderRadiusStyle, attributeStyles$DateSelectBorderWidthStyle, attributeStyles$DateSelectBackgroundColorStyle, attributeStyles$DateSelectBorderColorStyle, attributeStyles$InputMarginStyle, attributeStyles$TextBasedJustifyStyle, attributeStyles$DateSelectStrokeColorStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputDateComponentStyle inputDateComponentStyle) {
        j.g(qVar, "writer");
        if (inputDateComponentStyle != null) {
            qVar.c();
            qVar.u("fontFamily");
            this.f28148b.toJson(qVar, inputDateComponentStyle.f());
            qVar.u("fontSize");
            this.f28149c.toJson(qVar, inputDateComponentStyle.g());
            qVar.u("fontWeight");
            this.f28150d.toJson(qVar, inputDateComponentStyle.h());
            qVar.u("letterSpacing");
            this.f28151e.toJson(qVar, inputDateComponentStyle.l());
            qVar.u("lineHeight");
            this.f28152f.toJson(qVar, inputDateComponentStyle.m());
            qVar.u("textColor");
            this.f28153g.toJson(qVar, inputDateComponentStyle.p());
            qVar.u("borderRadius");
            this.f28154h.toJson(qVar, inputDateComponentStyle.d());
            qVar.u("borderWidth");
            this.f28155i.toJson(qVar, inputDateComponentStyle.e());
            qVar.u("backgroundColor");
            this.f28156j.toJson(qVar, inputDateComponentStyle.a());
            qVar.u("borderColor");
            this.f28157k.toJson(qVar, inputDateComponentStyle.c());
            qVar.u("margin");
            this.f28158l.toJson(qVar, inputDateComponentStyle.n());
            qVar.u("justify");
            this.f28159m.toJson(qVar, inputDateComponentStyle.k());
            qVar.u("strokeColor");
            this.f28160n.toJson(qVar, inputDateComponentStyle.o());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputDateComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
