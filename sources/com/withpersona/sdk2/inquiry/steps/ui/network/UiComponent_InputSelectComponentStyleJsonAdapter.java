package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectStrokeColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextFontFamilyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextFontSizeStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextFontWeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextLetterSpacingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextLineHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedJustifyStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_InputSelectComponentStyleJsonAdapter extends h<UiComponent.InputSelectComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28225a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$InputMarginStyle> f28226b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedJustifyStyle> f28227c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectTextFontFamilyStyle> f28228d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectTextFontSizeStyle> f28229e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectTextFontWeightStyle> f28230f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectTextLetterSpacingStyle> f28231g;

    /* renamed from: h  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectTextLineHeightStyle> f28232h;

    /* renamed from: i  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectTextColorStyle> f28233i;

    /* renamed from: j  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectBorderRadiusStyle> f28234j;

    /* renamed from: k  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectBorderWidthStyle> f28235k;

    /* renamed from: l  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectBackgroundColorStyle> f28236l;

    /* renamed from: m  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectBorderColorStyle> f28237m;

    /* renamed from: n  reason: collision with root package name */
    private final h<AttributeStyles$InputSelectStrokeColorStyle> f28238n;

    public UiComponent_InputSelectComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("margin", "justify", "fontFamily", "fontSize", "fontWeight", "letterSpacing", "lineHeight", "textColor", "borderRadius", "borderWidth", "backgroundColor", "borderColor", "strokeColor");
        j.f(a10, "of(\"margin\", \"justify\", …derColor\", \"strokeColor\")");
        this.f28225a = a10;
        h<AttributeStyles$InputMarginStyle> f10 = sVar.f(AttributeStyles$InputMarginStyle.class, n0.e(), "margin");
        j.f(f10, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28226b = f10;
        h<AttributeStyles$TextBasedJustifyStyle> f11 = sVar.f(AttributeStyles$TextBasedJustifyStyle.class, n0.e(), "justify");
        j.f(f11, "moshi.adapter(AttributeS…a, emptySet(), \"justify\")");
        this.f28227c = f11;
        h<AttributeStyles$InputSelectTextFontFamilyStyle> f12 = sVar.f(AttributeStyles$InputSelectTextFontFamilyStyle.class, n0.e(), "fontFamily");
        j.f(f12, "moshi.adapter(AttributeS…et(),\n      \"fontFamily\")");
        this.f28228d = f12;
        h<AttributeStyles$InputSelectTextFontSizeStyle> f13 = sVar.f(AttributeStyles$InputSelectTextFontSizeStyle.class, n0.e(), "fontSize");
        j.f(f13, "moshi.adapter(AttributeS…ySet(),\n      \"fontSize\")");
        this.f28229e = f13;
        h<AttributeStyles$InputSelectTextFontWeightStyle> f14 = sVar.f(AttributeStyles$InputSelectTextFontWeightStyle.class, n0.e(), "fontWeight");
        j.f(f14, "moshi.adapter(AttributeS…et(),\n      \"fontWeight\")");
        this.f28230f = f14;
        h<AttributeStyles$InputSelectTextLetterSpacingStyle> f15 = sVar.f(AttributeStyles$InputSelectTextLetterSpacingStyle.class, n0.e(), "letterSpacing");
        j.f(f15, "moshi.adapter(AttributeS…),\n      \"letterSpacing\")");
        this.f28231g = f15;
        h<AttributeStyles$InputSelectTextLineHeightStyle> f16 = sVar.f(AttributeStyles$InputSelectTextLineHeightStyle.class, n0.e(), "lineHeight");
        j.f(f16, "moshi.adapter(AttributeS…et(),\n      \"lineHeight\")");
        this.f28232h = f16;
        h<AttributeStyles$InputSelectTextColorStyle> f17 = sVar.f(AttributeStyles$InputSelectTextColorStyle.class, n0.e(), "textColor");
        j.f(f17, "moshi.adapter(AttributeS… emptySet(), \"textColor\")");
        this.f28233i = f17;
        h<AttributeStyles$InputSelectBorderRadiusStyle> f18 = sVar.f(AttributeStyles$InputSelectBorderRadiusStyle.class, n0.e(), "borderRadius");
        j.f(f18, "moshi.adapter(AttributeS…(),\n      \"borderRadius\")");
        this.f28234j = f18;
        h<AttributeStyles$InputSelectBorderWidthStyle> f19 = sVar.f(AttributeStyles$InputSelectBorderWidthStyle.class, n0.e(), "borderWidth");
        j.f(f19, "moshi.adapter(AttributeS…t(),\n      \"borderWidth\")");
        this.f28235k = f19;
        h<AttributeStyles$InputSelectBackgroundColorStyle> f20 = sVar.f(AttributeStyles$InputSelectBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f20, "moshi.adapter(AttributeS…\n      \"backgroundColor\")");
        this.f28236l = f20;
        h<AttributeStyles$InputSelectBorderColorStyle> f21 = sVar.f(AttributeStyles$InputSelectBorderColorStyle.class, n0.e(), "borderColor");
        j.f(f21, "moshi.adapter(AttributeS…t(),\n      \"borderColor\")");
        this.f28237m = f21;
        h<AttributeStyles$InputSelectStrokeColorStyle> f22 = sVar.f(AttributeStyles$InputSelectStrokeColorStyle.class, n0.e(), "strokeColor");
        j.f(f22, "moshi.adapter(AttributeS…t(),\n      \"strokeColor\")");
        this.f28238n = f22;
    }

    /* renamed from: a */
    public UiComponent.InputSelectComponentStyle fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = null;
        AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = null;
        AttributeStyles$InputSelectTextFontFamilyStyle attributeStyles$InputSelectTextFontFamilyStyle = null;
        AttributeStyles$InputSelectTextFontSizeStyle attributeStyles$InputSelectTextFontSizeStyle = null;
        AttributeStyles$InputSelectTextFontWeightStyle attributeStyles$InputSelectTextFontWeightStyle = null;
        AttributeStyles$InputSelectTextLetterSpacingStyle attributeStyles$InputSelectTextLetterSpacingStyle = null;
        AttributeStyles$InputSelectTextLineHeightStyle attributeStyles$InputSelectTextLineHeightStyle = null;
        AttributeStyles$InputSelectTextColorStyle attributeStyles$InputSelectTextColorStyle = null;
        AttributeStyles$InputSelectBorderRadiusStyle attributeStyles$InputSelectBorderRadiusStyle = null;
        AttributeStyles$InputSelectBorderWidthStyle attributeStyles$InputSelectBorderWidthStyle = null;
        AttributeStyles$InputSelectBackgroundColorStyle attributeStyles$InputSelectBackgroundColorStyle = null;
        AttributeStyles$InputSelectBorderColorStyle attributeStyles$InputSelectBorderColorStyle = null;
        AttributeStyles$InputSelectStrokeColorStyle attributeStyles$InputSelectStrokeColorStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f28225a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$InputMarginStyle = this.f28226b.fromJson(jsonReader2);
                    break;
                case 1:
                    attributeStyles$TextBasedJustifyStyle = this.f28227c.fromJson(jsonReader2);
                    break;
                case 2:
                    attributeStyles$InputSelectTextFontFamilyStyle = this.f28228d.fromJson(jsonReader2);
                    break;
                case 3:
                    attributeStyles$InputSelectTextFontSizeStyle = this.f28229e.fromJson(jsonReader2);
                    break;
                case 4:
                    attributeStyles$InputSelectTextFontWeightStyle = this.f28230f.fromJson(jsonReader2);
                    break;
                case 5:
                    attributeStyles$InputSelectTextLetterSpacingStyle = this.f28231g.fromJson(jsonReader2);
                    break;
                case 6:
                    attributeStyles$InputSelectTextLineHeightStyle = this.f28232h.fromJson(jsonReader2);
                    break;
                case 7:
                    attributeStyles$InputSelectTextColorStyle = this.f28233i.fromJson(jsonReader2);
                    break;
                case 8:
                    attributeStyles$InputSelectBorderRadiusStyle = this.f28234j.fromJson(jsonReader2);
                    break;
                case 9:
                    attributeStyles$InputSelectBorderWidthStyle = this.f28235k.fromJson(jsonReader2);
                    break;
                case 10:
                    attributeStyles$InputSelectBackgroundColorStyle = this.f28236l.fromJson(jsonReader2);
                    break;
                case 11:
                    attributeStyles$InputSelectBorderColorStyle = this.f28237m.fromJson(jsonReader2);
                    break;
                case 12:
                    attributeStyles$InputSelectStrokeColorStyle = this.f28238n.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.InputSelectComponentStyle(attributeStyles$InputMarginStyle, attributeStyles$TextBasedJustifyStyle, attributeStyles$InputSelectTextFontFamilyStyle, attributeStyles$InputSelectTextFontSizeStyle, attributeStyles$InputSelectTextFontWeightStyle, attributeStyles$InputSelectTextLetterSpacingStyle, attributeStyles$InputSelectTextLineHeightStyle, attributeStyles$InputSelectTextColorStyle, attributeStyles$InputSelectBorderRadiusStyle, attributeStyles$InputSelectBorderWidthStyle, attributeStyles$InputSelectBackgroundColorStyle, attributeStyles$InputSelectBorderColorStyle, attributeStyles$InputSelectStrokeColorStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputSelectComponentStyle inputSelectComponentStyle) {
        j.g(qVar, "writer");
        if (inputSelectComponentStyle != null) {
            qVar.c();
            qVar.u("margin");
            this.f28226b.toJson(qVar, inputSelectComponentStyle.t());
            qVar.u("justify");
            this.f28227c.toJson(qVar, inputSelectComponentStyle.p());
            qVar.u("fontFamily");
            this.f28228d.toJson(qVar, inputSelectComponentStyle.k());
            qVar.u("fontSize");
            this.f28229e.toJson(qVar, inputSelectComponentStyle.l());
            qVar.u("fontWeight");
            this.f28230f.toJson(qVar, inputSelectComponentStyle.m());
            qVar.u("letterSpacing");
            this.f28231g.toJson(qVar, inputSelectComponentStyle.r());
            qVar.u("lineHeight");
            this.f28232h.toJson(qVar, inputSelectComponentStyle.s());
            qVar.u("textColor");
            this.f28233i.toJson(qVar, inputSelectComponentStyle.x());
            qVar.u("borderRadius");
            this.f28234j.toJson(qVar, inputSelectComponentStyle.e());
            qVar.u("borderWidth");
            this.f28235k.toJson(qVar, inputSelectComponentStyle.g());
            qVar.u("backgroundColor");
            this.f28236l.toJson(qVar, inputSelectComponentStyle.a());
            qVar.u("borderColor");
            this.f28237m.toJson(qVar, inputSelectComponentStyle.c());
            qVar.u("strokeColor");
            this.f28238n.toJson(qVar, inputSelectComponentStyle.u());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputSelectComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
