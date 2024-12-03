package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackAlignmentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackAxisStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackChildSizesStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackGapStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackPaddingStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_ClickableStackComponentStyleJsonAdapter extends h<UiComponent.ClickableStackComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28023a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$ClickableStackBackgroundColorStyle> f28024b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$ClickableStackBorderWidthStyle> f28025c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$ClickableStackBorderColorStyle> f28026d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$ClickableStackBorderRadiusStyle> f28027e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$ClickableStackPaddingStyle> f28028f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$ClickableStackMarginStyle> f28029g;

    /* renamed from: h  reason: collision with root package name */
    private final h<AttributeStyles$ClickableStackAxisStyle> f28030h;

    /* renamed from: i  reason: collision with root package name */
    private final h<AttributeStyles$ClickableStackChildSizesStyle> f28031i;

    /* renamed from: j  reason: collision with root package name */
    private final h<AttributeStyles$ClickableStackAlignmentStyle> f28032j;

    /* renamed from: k  reason: collision with root package name */
    private final h<AttributeStyles$ClickableStackGapStyle> f28033k;

    public UiComponent_ClickableStackComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("backgroundColor", "borderWidth", "borderColor", "borderRadius", "padding", "margin", "axis", "childSizes", "alignment", "gap");
        j.f(a10, "of(\"backgroundColor\", \"b…zes\", \"alignment\", \"gap\")");
        this.f28023a = a10;
        h<AttributeStyles$ClickableStackBackgroundColorStyle> f10 = sVar.f(AttributeStyles$ClickableStackBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f10, "moshi.adapter(AttributeS…\n      \"backgroundColor\")");
        this.f28024b = f10;
        h<AttributeStyles$ClickableStackBorderWidthStyle> f11 = sVar.f(AttributeStyles$ClickableStackBorderWidthStyle.class, n0.e(), "borderWidth");
        j.f(f11, "moshi.adapter(AttributeS…t(),\n      \"borderWidth\")");
        this.f28025c = f11;
        h<AttributeStyles$ClickableStackBorderColorStyle> f12 = sVar.f(AttributeStyles$ClickableStackBorderColorStyle.class, n0.e(), "borderColor");
        j.f(f12, "moshi.adapter(AttributeS…t(),\n      \"borderColor\")");
        this.f28026d = f12;
        h<AttributeStyles$ClickableStackBorderRadiusStyle> f13 = sVar.f(AttributeStyles$ClickableStackBorderRadiusStyle.class, n0.e(), "borderRadius");
        j.f(f13, "moshi.adapter(AttributeS…(),\n      \"borderRadius\")");
        this.f28027e = f13;
        h<AttributeStyles$ClickableStackPaddingStyle> f14 = sVar.f(AttributeStyles$ClickableStackPaddingStyle.class, n0.e(), "padding");
        j.f(f14, "moshi.adapter(AttributeS…a, emptySet(), \"padding\")");
        this.f28028f = f14;
        h<AttributeStyles$ClickableStackMarginStyle> f15 = sVar.f(AttributeStyles$ClickableStackMarginStyle.class, n0.e(), "margin");
        j.f(f15, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28029g = f15;
        h<AttributeStyles$ClickableStackAxisStyle> f16 = sVar.f(AttributeStyles$ClickableStackAxisStyle.class, n0.e(), "axis");
        j.f(f16, "moshi.adapter(AttributeS…java, emptySet(), \"axis\")");
        this.f28030h = f16;
        h<AttributeStyles$ClickableStackChildSizesStyle> f17 = sVar.f(AttributeStyles$ClickableStackChildSizesStyle.class, n0.e(), "childSizes");
        j.f(f17, "moshi.adapter(AttributeS…et(),\n      \"childSizes\")");
        this.f28031i = f17;
        h<AttributeStyles$ClickableStackAlignmentStyle> f18 = sVar.f(AttributeStyles$ClickableStackAlignmentStyle.class, n0.e(), "alignment");
        j.f(f18, "moshi.adapter(AttributeS…Set(),\n      \"alignment\")");
        this.f28032j = f18;
        h<AttributeStyles$ClickableStackGapStyle> f19 = sVar.f(AttributeStyles$ClickableStackGapStyle.class, n0.e(), "gap");
        j.f(f19, "moshi.adapter(AttributeS….java, emptySet(), \"gap\")");
        this.f28033k = f19;
    }

    /* renamed from: a */
    public UiComponent.ClickableStackComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$ClickableStackBackgroundColorStyle attributeStyles$ClickableStackBackgroundColorStyle = null;
        AttributeStyles$ClickableStackBorderWidthStyle attributeStyles$ClickableStackBorderWidthStyle = null;
        AttributeStyles$ClickableStackBorderColorStyle attributeStyles$ClickableStackBorderColorStyle = null;
        AttributeStyles$ClickableStackBorderRadiusStyle attributeStyles$ClickableStackBorderRadiusStyle = null;
        AttributeStyles$ClickableStackPaddingStyle attributeStyles$ClickableStackPaddingStyle = null;
        AttributeStyles$ClickableStackMarginStyle attributeStyles$ClickableStackMarginStyle = null;
        AttributeStyles$ClickableStackAxisStyle attributeStyles$ClickableStackAxisStyle = null;
        AttributeStyles$ClickableStackChildSizesStyle attributeStyles$ClickableStackChildSizesStyle = null;
        AttributeStyles$ClickableStackAlignmentStyle attributeStyles$ClickableStackAlignmentStyle = null;
        AttributeStyles$ClickableStackGapStyle attributeStyles$ClickableStackGapStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28023a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$ClickableStackBackgroundColorStyle = this.f28024b.fromJson(jsonReader);
                    break;
                case 1:
                    attributeStyles$ClickableStackBorderWidthStyle = this.f28025c.fromJson(jsonReader);
                    break;
                case 2:
                    attributeStyles$ClickableStackBorderColorStyle = this.f28026d.fromJson(jsonReader);
                    break;
                case 3:
                    attributeStyles$ClickableStackBorderRadiusStyle = this.f28027e.fromJson(jsonReader);
                    break;
                case 4:
                    attributeStyles$ClickableStackPaddingStyle = this.f28028f.fromJson(jsonReader);
                    break;
                case 5:
                    attributeStyles$ClickableStackMarginStyle = this.f28029g.fromJson(jsonReader);
                    break;
                case 6:
                    attributeStyles$ClickableStackAxisStyle = this.f28030h.fromJson(jsonReader);
                    break;
                case 7:
                    attributeStyles$ClickableStackChildSizesStyle = this.f28031i.fromJson(jsonReader);
                    break;
                case 8:
                    attributeStyles$ClickableStackAlignmentStyle = this.f28032j.fromJson(jsonReader);
                    break;
                case 9:
                    attributeStyles$ClickableStackGapStyle = this.f28033k.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.ClickableStackComponentStyle(attributeStyles$ClickableStackBackgroundColorStyle, attributeStyles$ClickableStackBorderWidthStyle, attributeStyles$ClickableStackBorderColorStyle, attributeStyles$ClickableStackBorderRadiusStyle, attributeStyles$ClickableStackPaddingStyle, attributeStyles$ClickableStackMarginStyle, attributeStyles$ClickableStackAxisStyle, attributeStyles$ClickableStackChildSizesStyle, attributeStyles$ClickableStackAlignmentStyle, attributeStyles$ClickableStackGapStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.ClickableStackComponentStyle clickableStackComponentStyle) {
        j.g(qVar, "writer");
        if (clickableStackComponentStyle != null) {
            qVar.c();
            qVar.u("backgroundColor");
            this.f28024b.toJson(qVar, clickableStackComponentStyle.h());
            qVar.u("borderWidth");
            this.f28025c.toJson(qVar, clickableStackComponentStyle.n());
            qVar.u("borderColor");
            this.f28026d.toJson(qVar, clickableStackComponentStyle.k());
            qVar.u("borderRadius");
            this.f28027e.toJson(qVar, clickableStackComponentStyle.l());
            qVar.u("padding");
            this.f28028f.toJson(qVar, clickableStackComponentStyle.z());
            qVar.u("margin");
            this.f28029g.toJson(qVar, clickableStackComponentStyle.w());
            qVar.u("axis");
            this.f28030h.toJson(qVar, clickableStackComponentStyle.f());
            qVar.u("childSizes");
            this.f28031i.toJson(qVar, clickableStackComponentStyle.p());
            qVar.u("alignment");
            this.f28032j.toJson(qVar, clickableStackComponentStyle.d());
            qVar.u("gap");
            this.f28033k.toJson(qVar, clickableStackComponentStyle.t());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(62);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.ClickableStackComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
