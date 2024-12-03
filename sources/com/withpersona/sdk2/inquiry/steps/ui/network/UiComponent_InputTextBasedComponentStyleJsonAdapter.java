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
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextStrokeColorStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_InputTextBasedComponentStyleJsonAdapter extends h<UiComponent.InputTextBasedComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28250a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$InputMarginStyle> f28251b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedFontFamilyStyle> f28252c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedFontSizeStyle> f28253d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedFontWeightStyle> f28254e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedLetterSpacingStyle> f28255f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedLineHeightStyle> f28256g;

    /* renamed from: h  reason: collision with root package name */
    private final h<AttributeStyles$ComplexTextBasedTextColorStyle> f28257h;

    /* renamed from: i  reason: collision with root package name */
    private final h<AttributeStyles$InputTextBorderRadiusStyle> f28258i;

    /* renamed from: j  reason: collision with root package name */
    private final h<AttributeStyles$InputTextBorderWidthStyle> f28259j;

    /* renamed from: k  reason: collision with root package name */
    private final h<AttributeStyles$InputTextBackgroundColorStyle> f28260k;

    /* renamed from: l  reason: collision with root package name */
    private final h<AttributeStyles$InputTextBorderColorStyle> f28261l;

    /* renamed from: m  reason: collision with root package name */
    private final h<AttributeStyles$InputTextStrokeColorStyle> f28262m;

    public UiComponent_InputTextBasedComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("margin", "fontFamily", "fontSize", "fontWeight", "letterSpacing", "lineHeight", "textColor", "borderRadius", "borderWidth", "backgroundColor", "borderColor", "strokeColor");
        j.f(a10, "of(\"margin\", \"fontFamily…derColor\", \"strokeColor\")");
        this.f28250a = a10;
        h<AttributeStyles$InputMarginStyle> f10 = sVar.f(AttributeStyles$InputMarginStyle.class, n0.e(), "margin");
        j.f(f10, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28251b = f10;
        h<AttributeStyles$ComplexTextBasedFontFamilyStyle> f11 = sVar.f(AttributeStyles$ComplexTextBasedFontFamilyStyle.class, n0.e(), "fontFamily");
        j.f(f11, "moshi.adapter(AttributeS…et(),\n      \"fontFamily\")");
        this.f28252c = f11;
        h<AttributeStyles$ComplexTextBasedFontSizeStyle> f12 = sVar.f(AttributeStyles$ComplexTextBasedFontSizeStyle.class, n0.e(), "fontSize");
        j.f(f12, "moshi.adapter(AttributeS…ySet(),\n      \"fontSize\")");
        this.f28253d = f12;
        h<AttributeStyles$ComplexTextBasedFontWeightStyle> f13 = sVar.f(AttributeStyles$ComplexTextBasedFontWeightStyle.class, n0.e(), "fontWeight");
        j.f(f13, "moshi.adapter(AttributeS…et(),\n      \"fontWeight\")");
        this.f28254e = f13;
        h<AttributeStyles$ComplexTextBasedLetterSpacingStyle> f14 = sVar.f(AttributeStyles$ComplexTextBasedLetterSpacingStyle.class, n0.e(), "letterSpacing");
        j.f(f14, "moshi.adapter(AttributeS…),\n      \"letterSpacing\")");
        this.f28255f = f14;
        h<AttributeStyles$ComplexTextBasedLineHeightStyle> f15 = sVar.f(AttributeStyles$ComplexTextBasedLineHeightStyle.class, n0.e(), "lineHeight");
        j.f(f15, "moshi.adapter(AttributeS…et(),\n      \"lineHeight\")");
        this.f28256g = f15;
        h<AttributeStyles$ComplexTextBasedTextColorStyle> f16 = sVar.f(AttributeStyles$ComplexTextBasedTextColorStyle.class, n0.e(), "textColor");
        j.f(f16, "moshi.adapter(AttributeS…Set(),\n      \"textColor\")");
        this.f28257h = f16;
        h<AttributeStyles$InputTextBorderRadiusStyle> f17 = sVar.f(AttributeStyles$InputTextBorderRadiusStyle.class, n0.e(), "borderRadius");
        j.f(f17, "moshi.adapter(AttributeS…(),\n      \"borderRadius\")");
        this.f28258i = f17;
        h<AttributeStyles$InputTextBorderWidthStyle> f18 = sVar.f(AttributeStyles$InputTextBorderWidthStyle.class, n0.e(), "borderWidth");
        j.f(f18, "moshi.adapter(AttributeS…t(),\n      \"borderWidth\")");
        this.f28259j = f18;
        h<AttributeStyles$InputTextBackgroundColorStyle> f19 = sVar.f(AttributeStyles$InputTextBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f19, "moshi.adapter(AttributeS…\n      \"backgroundColor\")");
        this.f28260k = f19;
        h<AttributeStyles$InputTextBorderColorStyle> f20 = sVar.f(AttributeStyles$InputTextBorderColorStyle.class, n0.e(), "borderColor");
        j.f(f20, "moshi.adapter(AttributeS…t(),\n      \"borderColor\")");
        this.f28261l = f20;
        h<AttributeStyles$InputTextStrokeColorStyle> f21 = sVar.f(AttributeStyles$InputTextStrokeColorStyle.class, n0.e(), "strokeColor");
        j.f(f21, "moshi.adapter(AttributeS…t(),\n      \"strokeColor\")");
        this.f28262m = f21;
    }

    /* renamed from: a */
    public UiComponent.InputTextBasedComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = null;
        AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = null;
        AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = null;
        AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = null;
        AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = null;
        AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = null;
        AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = null;
        AttributeStyles$InputTextBorderRadiusStyle attributeStyles$InputTextBorderRadiusStyle = null;
        AttributeStyles$InputTextBorderWidthStyle attributeStyles$InputTextBorderWidthStyle = null;
        AttributeStyles$InputTextBackgroundColorStyle attributeStyles$InputTextBackgroundColorStyle = null;
        AttributeStyles$InputTextBorderColorStyle attributeStyles$InputTextBorderColorStyle = null;
        AttributeStyles$InputTextStrokeColorStyle attributeStyles$InputTextStrokeColorStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28250a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$InputMarginStyle = this.f28251b.fromJson(jsonReader);
                    break;
                case 1:
                    attributeStyles$ComplexTextBasedFontFamilyStyle = this.f28252c.fromJson(jsonReader);
                    break;
                case 2:
                    attributeStyles$ComplexTextBasedFontSizeStyle = this.f28253d.fromJson(jsonReader);
                    break;
                case 3:
                    attributeStyles$ComplexTextBasedFontWeightStyle = this.f28254e.fromJson(jsonReader);
                    break;
                case 4:
                    attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f28255f.fromJson(jsonReader);
                    break;
                case 5:
                    attributeStyles$ComplexTextBasedLineHeightStyle = this.f28256g.fromJson(jsonReader);
                    break;
                case 6:
                    attributeStyles$ComplexTextBasedTextColorStyle = this.f28257h.fromJson(jsonReader);
                    break;
                case 7:
                    attributeStyles$InputTextBorderRadiusStyle = this.f28258i.fromJson(jsonReader);
                    break;
                case 8:
                    attributeStyles$InputTextBorderWidthStyle = this.f28259j.fromJson(jsonReader);
                    break;
                case 9:
                    attributeStyles$InputTextBackgroundColorStyle = this.f28260k.fromJson(jsonReader);
                    break;
                case 10:
                    attributeStyles$InputTextBorderColorStyle = this.f28261l.fromJson(jsonReader);
                    break;
                case 11:
                    attributeStyles$InputTextStrokeColorStyle = this.f28262m.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.InputTextBasedComponentStyle(attributeStyles$InputMarginStyle, attributeStyles$ComplexTextBasedFontFamilyStyle, attributeStyles$ComplexTextBasedFontSizeStyle, attributeStyles$ComplexTextBasedFontWeightStyle, attributeStyles$ComplexTextBasedLetterSpacingStyle, attributeStyles$ComplexTextBasedLineHeightStyle, attributeStyles$ComplexTextBasedTextColorStyle, attributeStyles$InputTextBorderRadiusStyle, attributeStyles$InputTextBorderWidthStyle, attributeStyles$InputTextBackgroundColorStyle, attributeStyles$InputTextBorderColorStyle, attributeStyles$InputTextStrokeColorStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputTextBasedComponentStyle inputTextBasedComponentStyle) {
        j.g(qVar, "writer");
        if (inputTextBasedComponentStyle != null) {
            qVar.c();
            qVar.u("margin");
            this.f28251b.toJson(qVar, inputTextBasedComponentStyle.Q());
            qVar.u("fontFamily");
            this.f28252c.toJson(qVar, inputTextBasedComponentStyle.D());
            qVar.u("fontSize");
            this.f28253d.toJson(qVar, inputTextBasedComponentStyle.E());
            qVar.u("fontWeight");
            this.f28254e.toJson(qVar, inputTextBasedComponentStyle.F());
            qVar.u("letterSpacing");
            this.f28255f.toJson(qVar, inputTextBasedComponentStyle.O());
            qVar.u("lineHeight");
            this.f28256g.toJson(qVar, inputTextBasedComponentStyle.P());
            qVar.u("textColor");
            this.f28257h.toJson(qVar, inputTextBasedComponentStyle.W());
            qVar.u("borderRadius");
            this.f28258i.toJson(qVar, inputTextBasedComponentStyle.i());
            qVar.u("borderWidth");
            this.f28259j.toJson(qVar, inputTextBasedComponentStyle.k());
            qVar.u("backgroundColor");
            this.f28260k.toJson(qVar, inputTextBasedComponentStyle.a());
            qVar.u("borderColor");
            this.f28261l.toJson(qVar, inputTextBasedComponentStyle.h());
            qVar.u("strokeColor");
            this.f28262m.toJson(qVar, inputTextBasedComponentStyle.V());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(62);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputTextBasedComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
