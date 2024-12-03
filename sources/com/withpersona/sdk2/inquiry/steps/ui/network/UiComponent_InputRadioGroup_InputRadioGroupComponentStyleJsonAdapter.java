package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupFontFamilyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupFontSizeStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupFontWeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupLetterSpacingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupLineHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedTextColorStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_InputRadioGroup_InputRadioGroupComponentStyleJsonAdapter extends h<UiComponent.InputRadioGroup.InputRadioGroupComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28214a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedMarginStyle> f28215b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$InputRadioGroupFontFamilyStyle> f28216c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$InputRadioGroupFontSizeStyle> f28217d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$InputRadioGroupFontWeightStyle> f28218e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$InputRadioGroupLetterSpacingStyle> f28219f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$InputRadioGroupLineHeightStyle> f28220g;

    /* renamed from: h  reason: collision with root package name */
    private final h<AttributeStyles$InputRadioGroupTextColorStyle> f28221h;

    /* renamed from: i  reason: collision with root package name */
    private final h<AttributeStyles$TextBasedTextColorStyle> f28222i;

    public UiComponent_InputRadioGroup_InputRadioGroupComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("margin", "fontFamily", "fontSize", "fontWeight", "letterSpacing", "lineHeight", "textColor", "textColorHighlight");
        j.f(a10, "of(\"margin\", \"fontFamily…r\", \"textColorHighlight\")");
        this.f28214a = a10;
        h<AttributeStyles$TextBasedMarginStyle> f10 = sVar.f(AttributeStyles$TextBasedMarginStyle.class, n0.e(), "margin");
        j.f(f10, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28215b = f10;
        h<AttributeStyles$InputRadioGroupFontFamilyStyle> f11 = sVar.f(AttributeStyles$InputRadioGroupFontFamilyStyle.class, n0.e(), "fontFamily");
        j.f(f11, "moshi.adapter(AttributeS…et(),\n      \"fontFamily\")");
        this.f28216c = f11;
        h<AttributeStyles$InputRadioGroupFontSizeStyle> f12 = sVar.f(AttributeStyles$InputRadioGroupFontSizeStyle.class, n0.e(), "fontSize");
        j.f(f12, "moshi.adapter(AttributeS…ySet(),\n      \"fontSize\")");
        this.f28217d = f12;
        h<AttributeStyles$InputRadioGroupFontWeightStyle> f13 = sVar.f(AttributeStyles$InputRadioGroupFontWeightStyle.class, n0.e(), "fontWeight");
        j.f(f13, "moshi.adapter(AttributeS…et(),\n      \"fontWeight\")");
        this.f28218e = f13;
        h<AttributeStyles$InputRadioGroupLetterSpacingStyle> f14 = sVar.f(AttributeStyles$InputRadioGroupLetterSpacingStyle.class, n0.e(), "letterSpacing");
        j.f(f14, "moshi.adapter(AttributeS…),\n      \"letterSpacing\")");
        this.f28219f = f14;
        h<AttributeStyles$InputRadioGroupLineHeightStyle> f15 = sVar.f(AttributeStyles$InputRadioGroupLineHeightStyle.class, n0.e(), "lineHeight");
        j.f(f15, "moshi.adapter(AttributeS…et(),\n      \"lineHeight\")");
        this.f28220g = f15;
        h<AttributeStyles$InputRadioGroupTextColorStyle> f16 = sVar.f(AttributeStyles$InputRadioGroupTextColorStyle.class, n0.e(), "textColor");
        j.f(f16, "moshi.adapter(AttributeS…Set(),\n      \"textColor\")");
        this.f28221h = f16;
        h<AttributeStyles$TextBasedTextColorStyle> f17 = sVar.f(AttributeStyles$TextBasedTextColorStyle.class, n0.e(), "textColorHighlight");
        j.f(f17, "moshi.adapter(AttributeS…    \"textColorHighlight\")");
        this.f28222i = f17;
    }

    /* renamed from: a */
    public UiComponent.InputRadioGroup.InputRadioGroupComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$TextBasedMarginStyle attributeStyles$TextBasedMarginStyle = null;
        AttributeStyles$InputRadioGroupFontFamilyStyle attributeStyles$InputRadioGroupFontFamilyStyle = null;
        AttributeStyles$InputRadioGroupFontSizeStyle attributeStyles$InputRadioGroupFontSizeStyle = null;
        AttributeStyles$InputRadioGroupFontWeightStyle attributeStyles$InputRadioGroupFontWeightStyle = null;
        AttributeStyles$InputRadioGroupLetterSpacingStyle attributeStyles$InputRadioGroupLetterSpacingStyle = null;
        AttributeStyles$InputRadioGroupLineHeightStyle attributeStyles$InputRadioGroupLineHeightStyle = null;
        AttributeStyles$InputRadioGroupTextColorStyle attributeStyles$InputRadioGroupTextColorStyle = null;
        AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28214a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$TextBasedMarginStyle = this.f28215b.fromJson(jsonReader);
                    break;
                case 1:
                    attributeStyles$InputRadioGroupFontFamilyStyle = this.f28216c.fromJson(jsonReader);
                    break;
                case 2:
                    attributeStyles$InputRadioGroupFontSizeStyle = this.f28217d.fromJson(jsonReader);
                    break;
                case 3:
                    attributeStyles$InputRadioGroupFontWeightStyle = this.f28218e.fromJson(jsonReader);
                    break;
                case 4:
                    attributeStyles$InputRadioGroupLetterSpacingStyle = this.f28219f.fromJson(jsonReader);
                    break;
                case 5:
                    attributeStyles$InputRadioGroupLineHeightStyle = this.f28220g.fromJson(jsonReader);
                    break;
                case 6:
                    attributeStyles$InputRadioGroupTextColorStyle = this.f28221h.fromJson(jsonReader);
                    break;
                case 7:
                    attributeStyles$TextBasedTextColorStyle = this.f28222i.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.InputRadioGroup.InputRadioGroupComponentStyle(attributeStyles$TextBasedMarginStyle, attributeStyles$InputRadioGroupFontFamilyStyle, attributeStyles$InputRadioGroupFontSizeStyle, attributeStyles$InputRadioGroupFontWeightStyle, attributeStyles$InputRadioGroupLetterSpacingStyle, attributeStyles$InputRadioGroupLineHeightStyle, attributeStyles$InputRadioGroupTextColorStyle, attributeStyles$TextBasedTextColorStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputRadioGroup.InputRadioGroupComponentStyle inputRadioGroupComponentStyle) {
        j.g(qVar, "writer");
        if (inputRadioGroupComponentStyle != null) {
            qVar.c();
            qVar.u("margin");
            this.f28215b.toJson(qVar, inputRadioGroupComponentStyle.h());
            qVar.u("fontFamily");
            this.f28216c.toJson(qVar, inputRadioGroupComponentStyle.c());
            qVar.u("fontSize");
            this.f28217d.toJson(qVar, inputRadioGroupComponentStyle.d());
            qVar.u("fontWeight");
            this.f28218e.toJson(qVar, inputRadioGroupComponentStyle.e());
            qVar.u("letterSpacing");
            this.f28219f.toJson(qVar, inputRadioGroupComponentStyle.f());
            qVar.u("lineHeight");
            this.f28220g.toJson(qVar, inputRadioGroupComponentStyle.g());
            qVar.u("textColor");
            this.f28221h.toJson(qVar, inputRadioGroupComponentStyle.k());
            qVar.u("textColorHighlight");
            this.f28222i.toJson(qVar, inputRadioGroupComponentStyle.l());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(79);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputRadioGroup.InputRadioGroupComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
