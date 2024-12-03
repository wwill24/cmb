package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ButtonActionComponentStyleJsonAdapter extends h<ButtonActionComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28726a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedPaddingStyle> f28727b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedMarginStyle> f28728c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedJustifyStyle> f28729d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedFontFamilyStyle> f28730e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedFontSizeStyle> f28731f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedFontWeightStyle> f28732g;

    /* renamed from: h  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedLetterSpacingStyle> f28733h;

    /* renamed from: i  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedLineHeightStyle> f28734i;

    /* renamed from: j  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedTextColorStyle> f28735j;

    /* renamed from: k  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedHeightStyle> f28736k;

    /* renamed from: l  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedWidthStyle> f28737l;

    /* renamed from: m  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedBackgroundColorStyle> f28738m;

    /* renamed from: n  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedBorderColorStyle> f28739n;

    /* renamed from: o  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedBorderRadiusStyle> f28740o;

    /* renamed from: p  reason: collision with root package name */
    private final h<AttributeStyles$ButtonBasedBorderWidthStyle> f28741p;

    public ButtonActionComponentStyleJsonAdapter(s sVar) {
        s sVar2 = sVar;
        j.g(sVar2, "moshi");
        JsonReader.b a10 = JsonReader.b.a("padding", "margin", "justify", "fontFamily", "fontSize", "fontWeight", "letterSpacing", "lineHeight", "textColor", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "backgroundColor", "borderColor", "borderRadius", "borderWidth");
        j.f(a10, "of(\"padding\", \"margin\", …erRadius\", \"borderWidth\")");
        this.f28726a = a10;
        h<AttributeStyles$ButtonBasedPaddingStyle> f10 = sVar2.f(AttributeStyles$ButtonBasedPaddingStyle.class, n0.e(), "padding");
        j.f(f10, "moshi.adapter(AttributeS…a, emptySet(), \"padding\")");
        this.f28727b = f10;
        h<AttributeStyles$ButtonBasedMarginStyle> f11 = sVar2.f(AttributeStyles$ButtonBasedMarginStyle.class, n0.e(), "margin");
        j.f(f11, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28728c = f11;
        h<AttributeStyles$ButtonBasedJustifyStyle> f12 = sVar2.f(AttributeStyles$ButtonBasedJustifyStyle.class, n0.e(), "justify");
        j.f(f12, "moshi.adapter(AttributeS…a, emptySet(), \"justify\")");
        this.f28729d = f12;
        h<AttributeStyles$ButtonBasedFontFamilyStyle> f13 = sVar2.f(AttributeStyles$ButtonBasedFontFamilyStyle.class, n0.e(), "fontFamily");
        j.f(f13, "moshi.adapter(AttributeS…et(),\n      \"fontFamily\")");
        this.f28730e = f13;
        h<AttributeStyles$ButtonBasedFontSizeStyle> f14 = sVar2.f(AttributeStyles$ButtonBasedFontSizeStyle.class, n0.e(), "fontSize");
        j.f(f14, "moshi.adapter(AttributeS…, emptySet(), \"fontSize\")");
        this.f28731f = f14;
        h<AttributeStyles$ButtonBasedFontWeightStyle> f15 = sVar2.f(AttributeStyles$ButtonBasedFontWeightStyle.class, n0.e(), "fontWeight");
        j.f(f15, "moshi.adapter(AttributeS…et(),\n      \"fontWeight\")");
        this.f28732g = f15;
        h<AttributeStyles$ButtonBasedLetterSpacingStyle> f16 = sVar2.f(AttributeStyles$ButtonBasedLetterSpacingStyle.class, n0.e(), "letterSpacing");
        j.f(f16, "moshi.adapter(AttributeS…),\n      \"letterSpacing\")");
        this.f28733h = f16;
        h<AttributeStyles$ButtonBasedLineHeightStyle> f17 = sVar2.f(AttributeStyles$ButtonBasedLineHeightStyle.class, n0.e(), "lineHeight");
        j.f(f17, "moshi.adapter(AttributeS…et(),\n      \"lineHeight\")");
        this.f28734i = f17;
        h<AttributeStyles$ButtonBasedTextColorStyle> f18 = sVar2.f(AttributeStyles$ButtonBasedTextColorStyle.class, n0.e(), "textColor");
        j.f(f18, "moshi.adapter(AttributeS… emptySet(), \"textColor\")");
        this.f28735j = f18;
        h<AttributeStyles$ButtonBasedHeightStyle> f19 = sVar2.f(AttributeStyles$ButtonBasedHeightStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        j.f(f19, "moshi.adapter(AttributeS…va, emptySet(), \"height\")");
        this.f28736k = f19;
        h<AttributeStyles$ButtonBasedWidthStyle> f20 = sVar2.f(AttributeStyles$ButtonBasedWidthStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        j.f(f20, "moshi.adapter(AttributeS…ava, emptySet(), \"width\")");
        this.f28737l = f20;
        h<AttributeStyles$ButtonBasedBackgroundColorStyle> f21 = sVar2.f(AttributeStyles$ButtonBasedBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f21, "moshi.adapter(AttributeS…\n      \"backgroundColor\")");
        this.f28738m = f21;
        h<AttributeStyles$ButtonBasedBorderColorStyle> f22 = sVar2.f(AttributeStyles$ButtonBasedBorderColorStyle.class, n0.e(), "borderColor");
        j.f(f22, "moshi.adapter(AttributeS…t(),\n      \"borderColor\")");
        this.f28739n = f22;
        h<AttributeStyles$ButtonBasedBorderRadiusStyle> f23 = sVar2.f(AttributeStyles$ButtonBasedBorderRadiusStyle.class, n0.e(), "borderRadius");
        j.f(f23, "moshi.adapter(AttributeS…(),\n      \"borderRadius\")");
        this.f28740o = f23;
        h<AttributeStyles$ButtonBasedBorderWidthStyle> f24 = sVar2.f(AttributeStyles$ButtonBasedBorderWidthStyle.class, n0.e(), "borderWidth");
        j.f(f24, "moshi.adapter(AttributeS…t(),\n      \"borderWidth\")");
        this.f28741p = f24;
    }

    /* renamed from: a */
    public ButtonActionComponentStyle fromJson(JsonReader jsonReader) {
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
            switch (jsonReader2.L(this.f28726a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$ButtonBasedPaddingStyle = this.f28727b.fromJson(jsonReader2);
                    break;
                case 1:
                    attributeStyles$ButtonBasedMarginStyle = this.f28728c.fromJson(jsonReader2);
                    break;
                case 2:
                    attributeStyles$ButtonBasedJustifyStyle = this.f28729d.fromJson(jsonReader2);
                    break;
                case 3:
                    attributeStyles$ButtonBasedFontFamilyStyle = this.f28730e.fromJson(jsonReader2);
                    break;
                case 4:
                    attributeStyles$ButtonBasedFontSizeStyle = this.f28731f.fromJson(jsonReader2);
                    break;
                case 5:
                    attributeStyles$ButtonBasedFontWeightStyle = this.f28732g.fromJson(jsonReader2);
                    break;
                case 6:
                    attributeStyles$ButtonBasedLetterSpacingStyle = this.f28733h.fromJson(jsonReader2);
                    break;
                case 7:
                    attributeStyles$ButtonBasedLineHeightStyle = this.f28734i.fromJson(jsonReader2);
                    break;
                case 8:
                    attributeStyles$ButtonBasedTextColorStyle = this.f28735j.fromJson(jsonReader2);
                    break;
                case 9:
                    attributeStyles$ButtonBasedHeightStyle = this.f28736k.fromJson(jsonReader2);
                    break;
                case 10:
                    attributeStyles$ButtonBasedWidthStyle = this.f28737l.fromJson(jsonReader2);
                    break;
                case 11:
                    attributeStyles$ButtonBasedBackgroundColorStyle = this.f28738m.fromJson(jsonReader2);
                    break;
                case 12:
                    attributeStyles$ButtonBasedBorderColorStyle = this.f28739n.fromJson(jsonReader2);
                    break;
                case 13:
                    attributeStyles$ButtonBasedBorderRadiusStyle = this.f28740o.fromJson(jsonReader2);
                    break;
                case 14:
                    attributeStyles$ButtonBasedBorderWidthStyle = this.f28741p.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.e();
        return new ButtonActionComponentStyle(attributeStyles$ButtonBasedPaddingStyle, attributeStyles$ButtonBasedMarginStyle, attributeStyles$ButtonBasedJustifyStyle, attributeStyles$ButtonBasedFontFamilyStyle, attributeStyles$ButtonBasedFontSizeStyle, attributeStyles$ButtonBasedFontWeightStyle, attributeStyles$ButtonBasedLetterSpacingStyle, attributeStyles$ButtonBasedLineHeightStyle, attributeStyles$ButtonBasedTextColorStyle, attributeStyles$ButtonBasedHeightStyle, attributeStyles$ButtonBasedWidthStyle, attributeStyles$ButtonBasedBackgroundColorStyle, attributeStyles$ButtonBasedBorderColorStyle, attributeStyles$ButtonBasedBorderRadiusStyle, attributeStyles$ButtonBasedBorderWidthStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, ButtonActionComponentStyle buttonActionComponentStyle) {
        j.g(qVar, "writer");
        if (buttonActionComponentStyle != null) {
            qVar.c();
            qVar.u("padding");
            this.f28727b.toJson(qVar, buttonActionComponentStyle.M());
            qVar.u("margin");
            this.f28728c.toJson(qVar, buttonActionComponentStyle.L());
            qVar.u("justify");
            this.f28729d.toJson(qVar, buttonActionComponentStyle.H());
            qVar.u("fontFamily");
            this.f28730e.toJson(qVar, buttonActionComponentStyle.D());
            qVar.u("fontSize");
            this.f28731f.toJson(qVar, buttonActionComponentStyle.E());
            qVar.u("fontWeight");
            this.f28732g.toJson(qVar, buttonActionComponentStyle.F());
            qVar.u("letterSpacing");
            this.f28733h.toJson(qVar, buttonActionComponentStyle.I());
            qVar.u("lineHeight");
            this.f28734i.toJson(qVar, buttonActionComponentStyle.K());
            qVar.u("textColor");
            this.f28735j.toJson(qVar, buttonActionComponentStyle.O());
            qVar.u(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            this.f28736k.toJson(qVar, buttonActionComponentStyle.G());
            qVar.u(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            this.f28737l.toJson(qVar, buttonActionComponentStyle.P());
            qVar.u("backgroundColor");
            this.f28738m.toJson(qVar, buttonActionComponentStyle.x());
            qVar.u("borderColor");
            this.f28739n.toJson(qVar, buttonActionComponentStyle.z());
            qVar.u("borderRadius");
            this.f28740o.toJson(qVar, buttonActionComponentStyle.A());
            qVar.u("borderWidth");
            this.f28741p.toJson(qVar, buttonActionComponentStyle.B());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ButtonActionComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
