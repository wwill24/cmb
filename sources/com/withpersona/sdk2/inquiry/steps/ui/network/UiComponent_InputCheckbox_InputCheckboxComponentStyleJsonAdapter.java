package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedFontFamilyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedFontSizeStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedFontWeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedLetterSpacingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedLineHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedTextColorStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_InputCheckbox_InputCheckboxComponentStyleJsonAdapter extends h<UiComponent.InputCheckbox.InputCheckboxComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28133a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedFontFamilyStyle> f28134b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedFontSizeStyle> f28135c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedFontWeightStyle> f28136d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedLetterSpacingStyle> f28137e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedLineHeightStyle> f28138f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedTextColorStyle> f28139g;

    public UiComponent_InputCheckbox_InputCheckboxComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("fontFamily", "fontSize", "fontWeight", "letterSpacing", "lineHeight", "textColor", "textColorHighlight");
        j.f(a10, "of(\"fontFamily\", \"fontSi…r\", \"textColorHighlight\")");
        this.f28133a = a10;
        h<AttributeStyles$TextBasedFontFamilyStyle> f10 = sVar.f(AttributeStyles$TextBasedFontFamilyStyle.class, n0.e(), "fontFamily");
        j.f(f10, "moshi.adapter(AttributeS…emptySet(), \"fontFamily\")");
        this.f28134b = f10;
        h<AttributeStyles$TextBasedFontSizeStyle> f11 = sVar.f(AttributeStyles$TextBasedFontSizeStyle.class, n0.e(), "fontSize");
        j.f(f11, "moshi.adapter(AttributeS…, emptySet(), \"fontSize\")");
        this.f28135c = f11;
        h<AttributeStyles$TextBasedFontWeightStyle> f12 = sVar.f(AttributeStyles$TextBasedFontWeightStyle.class, n0.e(), "fontWeight");
        j.f(f12, "moshi.adapter(AttributeS…emptySet(), \"fontWeight\")");
        this.f28136d = f12;
        h<AttributeStyles$TextBasedLetterSpacingStyle> f13 = sVar.f(AttributeStyles$TextBasedLetterSpacingStyle.class, n0.e(), "letterSpacing");
        j.f(f13, "moshi.adapter(AttributeS…),\n      \"letterSpacing\")");
        this.f28137e = f13;
        h<AttributeStyles$TextBasedLineHeightStyle> f14 = sVar.f(AttributeStyles$TextBasedLineHeightStyle.class, n0.e(), "lineHeight");
        j.f(f14, "moshi.adapter(AttributeS…emptySet(), \"lineHeight\")");
        this.f28138f = f14;
        h<AttributeStyles$TextBasedTextColorStyle> f15 = sVar.f(AttributeStyles$TextBasedTextColorStyle.class, n0.e(), "textColor");
        j.f(f15, "moshi.adapter(AttributeS… emptySet(), \"textColor\")");
        this.f28139g = f15;
    }

    /* renamed from: a */
    public UiComponent.InputCheckbox.InputCheckboxComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = null;
        AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = null;
        AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = null;
        AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = null;
        AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = null;
        AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = null;
        AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle2 = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28133a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$TextBasedFontFamilyStyle = this.f28134b.fromJson(jsonReader);
                    break;
                case 1:
                    attributeStyles$TextBasedFontSizeStyle = this.f28135c.fromJson(jsonReader);
                    break;
                case 2:
                    attributeStyles$TextBasedFontWeightStyle = this.f28136d.fromJson(jsonReader);
                    break;
                case 3:
                    attributeStyles$TextBasedLetterSpacingStyle = this.f28137e.fromJson(jsonReader);
                    break;
                case 4:
                    attributeStyles$TextBasedLineHeightStyle = this.f28138f.fromJson(jsonReader);
                    break;
                case 5:
                    attributeStyles$TextBasedTextColorStyle = this.f28139g.fromJson(jsonReader);
                    break;
                case 6:
                    attributeStyles$TextBasedTextColorStyle2 = this.f28139g.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.InputCheckbox.InputCheckboxComponentStyle(attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, attributeStyles$TextBasedLineHeightStyle, attributeStyles$TextBasedTextColorStyle, attributeStyles$TextBasedTextColorStyle2);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputCheckbox.InputCheckboxComponentStyle inputCheckboxComponentStyle) {
        j.g(qVar, "writer");
        if (inputCheckboxComponentStyle != null) {
            qVar.c();
            qVar.u("fontFamily");
            this.f28134b.toJson(qVar, inputCheckboxComponentStyle.a());
            qVar.u("fontSize");
            this.f28135c.toJson(qVar, inputCheckboxComponentStyle.c());
            qVar.u("fontWeight");
            this.f28136d.toJson(qVar, inputCheckboxComponentStyle.d());
            qVar.u("letterSpacing");
            this.f28137e.toJson(qVar, inputCheckboxComponentStyle.e());
            qVar.u("lineHeight");
            this.f28138f.toJson(qVar, inputCheckboxComponentStyle.f());
            qVar.u("textColor");
            this.f28139g.toJson(qVar, inputCheckboxComponentStyle.h());
            qVar.u("textColorHighlight");
            this.f28139g.toJson(qVar, inputCheckboxComponentStyle.i());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(75);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputCheckbox.InputCheckboxComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
