package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ButtonCancelComponentStyleJsonAdapter extends h<ButtonCancelComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28757a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedPaddingStyle> f28758b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedMarginStyle> f28759c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedJustifyStyle> f28760d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedFontFamilyStyle> f28761e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedFontSizeStyle> f28762f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedFontWeightStyle> f28763g;

    /* renamed from: h  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedLetterSpacingStyle> f28764h;

    /* renamed from: i  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedLineHeightStyle> f28765i;

    /* renamed from: j  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedTextColorStyle> f28766j;

    /* renamed from: k  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedHeightStyle> f28767k;

    /* renamed from: l  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedWidthStyle> f28768l;

    /* renamed from: m  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedBackgroundColorStyle> f28769m;

    /* renamed from: n  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedBorderColorStyle> f28770n;

    /* renamed from: o  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedBorderRadiusStyle> f28771o;

    /* renamed from: p  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedBorderWidthStyle> f28772p;

    public ButtonCancelComponentStyleJsonAdapter(s sVar) {
        s sVar2 = sVar;
        j.g(sVar2, "moshi");
        JsonReader.b a10 = JsonReader.b.a("padding", "margin", "justify", "fontFamily", "fontSize", "fontWeight", "letterSpacing", "lineHeight", "textColor", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "backgroundColor", "borderColor", "borderRadius", "borderWidth");
        j.f(a10, "of(\"padding\", \"margin\", …erRadius\", \"borderWidth\")");
        this.f28757a = a10;
        h<AttributeStyles$ButtonBasedPaddingStyle> f10 = sVar2.f(AttributeStyles$ButtonBasedPaddingStyle.class, n0.e(), "padding");
        j.f(f10, "moshi.adapter(AttributeS…a, emptySet(), \"padding\")");
        this.f28758b = f10;
        h<AttributeStyles$ButtonBasedMarginStyle> f11 = sVar2.f(AttributeStyles$ButtonBasedMarginStyle.class, n0.e(), "margin");
        j.f(f11, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28759c = f11;
        h<AttributeStyles$ButtonBasedJustifyStyle> f12 = sVar2.f(AttributeStyles$ButtonBasedJustifyStyle.class, n0.e(), "justify");
        j.f(f12, "moshi.adapter(AttributeS…a, emptySet(), \"justify\")");
        this.f28760d = f12;
        h<AttributeStyles$ButtonBasedFontFamilyStyle> f13 = sVar2.f(AttributeStyles$ButtonBasedFontFamilyStyle.class, n0.e(), "fontFamily");
        j.f(f13, "moshi.adapter(AttributeS…et(),\n      \"fontFamily\")");
        this.f28761e = f13;
        h<AttributeStyles$ButtonBasedFontSizeStyle> f14 = sVar2.f(AttributeStyles$ButtonBasedFontSizeStyle.class, n0.e(), "fontSize");
        j.f(f14, "moshi.adapter(AttributeS…, emptySet(), \"fontSize\")");
        this.f28762f = f14;
        h<AttributeStyles$ButtonBasedFontWeightStyle> f15 = sVar2.f(AttributeStyles$ButtonBasedFontWeightStyle.class, n0.e(), "fontWeight");
        j.f(f15, "moshi.adapter(AttributeS…et(),\n      \"fontWeight\")");
        this.f28763g = f15;
        h<AttributeStyles$ButtonBasedLetterSpacingStyle> f16 = sVar2.f(AttributeStyles$ButtonBasedLetterSpacingStyle.class, n0.e(), "letterSpacing");
        j.f(f16, "moshi.adapter(AttributeS…),\n      \"letterSpacing\")");
        this.f28764h = f16;
        h<AttributeStyles$ButtonBasedLineHeightStyle> f17 = sVar2.f(AttributeStyles$ButtonBasedLineHeightStyle.class, n0.e(), "lineHeight");
        j.f(f17, "moshi.adapter(AttributeS…et(),\n      \"lineHeight\")");
        this.f28765i = f17;
        h<AttributeStyles$ButtonBasedTextColorStyle> f18 = sVar2.f(AttributeStyles$ButtonBasedTextColorStyle.class, n0.e(), "textColor");
        j.f(f18, "moshi.adapter(AttributeS… emptySet(), \"textColor\")");
        this.f28766j = f18;
        h<AttributeStyles$ButtonBasedHeightStyle> f19 = sVar2.f(AttributeStyles$ButtonBasedHeightStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        j.f(f19, "moshi.adapter(AttributeS…va, emptySet(), \"height\")");
        this.f28767k = f19;
        h<AttributeStyles$ButtonBasedWidthStyle> f20 = sVar2.f(AttributeStyles$ButtonBasedWidthStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        j.f(f20, "moshi.adapter(AttributeS…ava, emptySet(), \"width\")");
        this.f28768l = f20;
        h<AttributeStyles$ButtonBasedBackgroundColorStyle> f21 = sVar2.f(AttributeStyles$ButtonBasedBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f21, "moshi.adapter(AttributeS…\n      \"backgroundColor\")");
        this.f28769m = f21;
        h<AttributeStyles$ButtonBasedBorderColorStyle> f22 = sVar2.f(AttributeStyles$ButtonBasedBorderColorStyle.class, n0.e(), "borderColor");
        j.f(f22, "moshi.adapter(AttributeS…t(),\n      \"borderColor\")");
        this.f28770n = f22;
        h<AttributeStyles$ButtonBasedBorderRadiusStyle> f23 = sVar2.f(AttributeStyles$ButtonBasedBorderRadiusStyle.class, n0.e(), "borderRadius");
        j.f(f23, "moshi.adapter(AttributeS…(),\n      \"borderRadius\")");
        this.f28771o = f23;
        h<AttributeStyles$ButtonBasedBorderWidthStyle> f24 = sVar2.f(AttributeStyles$ButtonBasedBorderWidthStyle.class, n0.e(), "borderWidth");
        j.f(f24, "moshi.adapter(AttributeS…t(),\n      \"borderWidth\")");
        this.f28772p = f24;
    }

    /* renamed from: a */
    public ButtonCancelComponentStyle fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        AttributeStyles$ButtonBasedPaddingStyle attributeStyles$ButtonBasedPaddingStyle = null;
        AttributeStyles$ButtonBasedMarginStyle attributeStyles$ButtonBasedMarginStyle = null;
        AttributeStyles$ButtonBasedJustifyStyle attributeStyles$ButtonBasedJustifyStyle = null;
        AttributeStyles$ButtonBasedFontFamilyStyle attributeStyles$ButtonBasedFontFamilyStyle = null;
        AttributeStyles$ButtonBasedFontSizeStyle attributeStyles$ButtonBasedFontSizeStyle = null;
        AttributeStyles$ButtonBasedFontWeightStyle attributeStyles$ButtonBasedFontWeightStyle = null;
        AttributeStyles$ButtonBasedLetterSpacingStyle attributeStyles$ButtonBasedLetterSpacingStyle = null;
        AttributeStyles$ButtonBasedLineHeightStyle attributeStyles$ButtonBasedLineHeightStyle = null;
        AttributeStyles$ButtonBasedTextColorStyle attributeStyles$ButtonBasedTextColorStyle = null;
        AttributeStyles$ButtonBasedHeightStyle attributeStyles$ButtonBasedHeightStyle = null;
        AttributeStyles$ButtonBasedWidthStyle attributeStyles$ButtonBasedWidthStyle = null;
        AttributeStyles$ButtonBasedBackgroundColorStyle attributeStyles$ButtonBasedBackgroundColorStyle = null;
        AttributeStyles$ButtonBasedBorderColorStyle attributeStyles$ButtonBasedBorderColorStyle = null;
        AttributeStyles$ButtonBasedBorderRadiusStyle attributeStyles$ButtonBasedBorderRadiusStyle = null;
        AttributeStyles$ButtonBasedBorderWidthStyle attributeStyles$ButtonBasedBorderWidthStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f28757a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$ButtonBasedPaddingStyle = this.f28758b.fromJson(jsonReader2);
                    break;
                case 1:
                    attributeStyles$ButtonBasedMarginStyle = this.f28759c.fromJson(jsonReader2);
                    break;
                case 2:
                    attributeStyles$ButtonBasedJustifyStyle = this.f28760d.fromJson(jsonReader2);
                    break;
                case 3:
                    attributeStyles$ButtonBasedFontFamilyStyle = this.f28761e.fromJson(jsonReader2);
                    break;
                case 4:
                    attributeStyles$ButtonBasedFontSizeStyle = this.f28762f.fromJson(jsonReader2);
                    break;
                case 5:
                    attributeStyles$ButtonBasedFontWeightStyle = this.f28763g.fromJson(jsonReader2);
                    break;
                case 6:
                    attributeStyles$ButtonBasedLetterSpacingStyle = this.f28764h.fromJson(jsonReader2);
                    break;
                case 7:
                    attributeStyles$ButtonBasedLineHeightStyle = this.f28765i.fromJson(jsonReader2);
                    break;
                case 8:
                    attributeStyles$ButtonBasedTextColorStyle = this.f28766j.fromJson(jsonReader2);
                    break;
                case 9:
                    attributeStyles$ButtonBasedHeightStyle = this.f28767k.fromJson(jsonReader2);
                    break;
                case 10:
                    attributeStyles$ButtonBasedWidthStyle = this.f28768l.fromJson(jsonReader2);
                    break;
                case 11:
                    attributeStyles$ButtonBasedBackgroundColorStyle = this.f28769m.fromJson(jsonReader2);
                    break;
                case 12:
                    attributeStyles$ButtonBasedBorderColorStyle = this.f28770n.fromJson(jsonReader2);
                    break;
                case 13:
                    attributeStyles$ButtonBasedBorderRadiusStyle = this.f28771o.fromJson(jsonReader2);
                    break;
                case 14:
                    attributeStyles$ButtonBasedBorderWidthStyle = this.f28772p.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.e();
        return new ButtonCancelComponentStyle(attributeStyles$ButtonBasedPaddingStyle, attributeStyles$ButtonBasedMarginStyle, attributeStyles$ButtonBasedJustifyStyle, attributeStyles$ButtonBasedFontFamilyStyle, attributeStyles$ButtonBasedFontSizeStyle, attributeStyles$ButtonBasedFontWeightStyle, attributeStyles$ButtonBasedLetterSpacingStyle, attributeStyles$ButtonBasedLineHeightStyle, attributeStyles$ButtonBasedTextColorStyle, attributeStyles$ButtonBasedHeightStyle, attributeStyles$ButtonBasedWidthStyle, attributeStyles$ButtonBasedBackgroundColorStyle, attributeStyles$ButtonBasedBorderColorStyle, attributeStyles$ButtonBasedBorderRadiusStyle, attributeStyles$ButtonBasedBorderWidthStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, ButtonCancelComponentStyle buttonCancelComponentStyle) {
        j.g(qVar, "writer");
        if (buttonCancelComponentStyle != null) {
            qVar.c();
            qVar.u("padding");
            this.f28758b.toJson(qVar, buttonCancelComponentStyle.M());
            qVar.u("margin");
            this.f28759c.toJson(qVar, buttonCancelComponentStyle.L());
            qVar.u("justify");
            this.f28760d.toJson(qVar, buttonCancelComponentStyle.H());
            qVar.u("fontFamily");
            this.f28761e.toJson(qVar, buttonCancelComponentStyle.D());
            qVar.u("fontSize");
            this.f28762f.toJson(qVar, buttonCancelComponentStyle.E());
            qVar.u("fontWeight");
            this.f28763g.toJson(qVar, buttonCancelComponentStyle.F());
            qVar.u("letterSpacing");
            this.f28764h.toJson(qVar, buttonCancelComponentStyle.I());
            qVar.u("lineHeight");
            this.f28765i.toJson(qVar, buttonCancelComponentStyle.K());
            qVar.u("textColor");
            this.f28766j.toJson(qVar, buttonCancelComponentStyle.O());
            qVar.u(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            this.f28767k.toJson(qVar, buttonCancelComponentStyle.G());
            qVar.u(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            this.f28768l.toJson(qVar, buttonCancelComponentStyle.P());
            qVar.u("backgroundColor");
            this.f28769m.toJson(qVar, buttonCancelComponentStyle.x());
            qVar.u("borderColor");
            this.f28770n.toJson(qVar, buttonCancelComponentStyle.z());
            qVar.u("borderRadius");
            this.f28771o.toJson(qVar, buttonCancelComponentStyle.A());
            qVar.u("borderWidth");
            this.f28772p.toJson(qVar, buttonCancelComponentStyle.B());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ButtonCancelComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
