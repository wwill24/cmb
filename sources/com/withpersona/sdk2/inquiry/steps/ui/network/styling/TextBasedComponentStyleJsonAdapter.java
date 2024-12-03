package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class TextBasedComponentStyleJsonAdapter extends h<TextBasedComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29227a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedMarginStyle> f29228b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedJustifyStyle> f29229c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedFontFamilyStyle> f29230d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedFontSizeStyle> f29231e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedFontWeightStyle> f29232f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedLetterSpacingStyle> f29233g;

    /* renamed from: h  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedLineHeightStyle> f29234h;

    /* renamed from: i  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedTextColorStyle> f29235i;

    public TextBasedComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("margin", "justify", "fontFamily", "fontSize", "fontWeight", "letterSpacing", "lineHeight", "textColor", "textColorHighlight");
        j.f(a10, "of(\"margin\", \"justify\", …r\", \"textColorHighlight\")");
        this.f29227a = a10;
        h<AttributeStyles$TextBasedMarginStyle> f10 = sVar.f(AttributeStyles$TextBasedMarginStyle.class, n0.e(), "margin");
        j.f(f10, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f29228b = f10;
        h<AttributeStyles$TextBasedJustifyStyle> f11 = sVar.f(AttributeStyles$TextBasedJustifyStyle.class, n0.e(), "justify");
        j.f(f11, "moshi.adapter(AttributeS…a, emptySet(), \"justify\")");
        this.f29229c = f11;
        h<AttributeStyles$TextBasedFontFamilyStyle> f12 = sVar.f(AttributeStyles$TextBasedFontFamilyStyle.class, n0.e(), "fontFamily");
        j.f(f12, "moshi.adapter(AttributeS…emptySet(), \"fontFamily\")");
        this.f29230d = f12;
        h<AttributeStyles$TextBasedFontSizeStyle> f13 = sVar.f(AttributeStyles$TextBasedFontSizeStyle.class, n0.e(), "fontSize");
        j.f(f13, "moshi.adapter(AttributeS…, emptySet(), \"fontSize\")");
        this.f29231e = f13;
        h<AttributeStyles$TextBasedFontWeightStyle> f14 = sVar.f(AttributeStyles$TextBasedFontWeightStyle.class, n0.e(), "fontWeight");
        j.f(f14, "moshi.adapter(AttributeS…emptySet(), \"fontWeight\")");
        this.f29232f = f14;
        h<AttributeStyles$TextBasedLetterSpacingStyle> f15 = sVar.f(AttributeStyles$TextBasedLetterSpacingStyle.class, n0.e(), "letterSpacing");
        j.f(f15, "moshi.adapter(AttributeS…),\n      \"letterSpacing\")");
        this.f29233g = f15;
        h<AttributeStyles$TextBasedLineHeightStyle> f16 = sVar.f(AttributeStyles$TextBasedLineHeightStyle.class, n0.e(), "lineHeight");
        j.f(f16, "moshi.adapter(AttributeS…emptySet(), \"lineHeight\")");
        this.f29234h = f16;
        h<AttributeStyles$TextBasedTextColorStyle> f17 = sVar.f(AttributeStyles$TextBasedTextColorStyle.class, n0.e(), "textColor");
        j.f(f17, "moshi.adapter(AttributeS… emptySet(), \"textColor\")");
        this.f29235i = f17;
    }

    /* renamed from: a */
    public TextBasedComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$TextBasedMarginStyle attributeStyles$TextBasedMarginStyle = null;
        AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = null;
        AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = null;
        AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = null;
        AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = null;
        AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = null;
        AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = null;
        AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = null;
        AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle2 = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f29227a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$TextBasedMarginStyle = this.f29228b.fromJson(jsonReader);
                    break;
                case 1:
                    attributeStyles$TextBasedJustifyStyle = this.f29229c.fromJson(jsonReader);
                    break;
                case 2:
                    attributeStyles$TextBasedFontFamilyStyle = this.f29230d.fromJson(jsonReader);
                    break;
                case 3:
                    attributeStyles$TextBasedFontSizeStyle = this.f29231e.fromJson(jsonReader);
                    break;
                case 4:
                    attributeStyles$TextBasedFontWeightStyle = this.f29232f.fromJson(jsonReader);
                    break;
                case 5:
                    attributeStyles$TextBasedLetterSpacingStyle = this.f29233g.fromJson(jsonReader);
                    break;
                case 6:
                    attributeStyles$TextBasedLineHeightStyle = this.f29234h.fromJson(jsonReader);
                    break;
                case 7:
                    attributeStyles$TextBasedTextColorStyle = this.f29235i.fromJson(jsonReader);
                    break;
                case 8:
                    attributeStyles$TextBasedTextColorStyle2 = this.f29235i.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new TextBasedComponentStyle(attributeStyles$TextBasedMarginStyle, attributeStyles$TextBasedJustifyStyle, attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, attributeStyles$TextBasedLineHeightStyle, attributeStyles$TextBasedTextColorStyle, attributeStyles$TextBasedTextColorStyle2);
    }

    /* renamed from: b */
    public void toJson(q qVar, TextBasedComponentStyle textBasedComponentStyle) {
        j.g(qVar, "writer");
        if (textBasedComponentStyle != null) {
            qVar.c();
            qVar.u("margin");
            this.f29228b.toJson(qVar, textBasedComponentStyle.n());
            qVar.u("justify");
            this.f29229c.toJson(qVar, textBasedComponentStyle.i());
            qVar.u("fontFamily");
            this.f29230d.toJson(qVar, textBasedComponentStyle.a());
            qVar.u("fontSize");
            this.f29231e.toJson(qVar, textBasedComponentStyle.d());
            qVar.u("fontWeight");
            this.f29232f.toJson(qVar, textBasedComponentStyle.f());
            qVar.u("letterSpacing");
            this.f29233g.toJson(qVar, textBasedComponentStyle.j());
            qVar.u("lineHeight");
            this.f29234h.toJson(qVar, textBasedComponentStyle.l());
            qVar.u("textColor");
            this.f29235i.toJson(qVar, textBasedComponentStyle.p());
            qVar.u("textColorHighlight");
            this.f29235i.toJson(qVar, textBasedComponentStyle.q());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TextBasedComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
