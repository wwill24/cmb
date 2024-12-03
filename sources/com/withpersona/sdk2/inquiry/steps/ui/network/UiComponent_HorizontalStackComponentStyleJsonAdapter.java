package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackAlignmentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackAxisStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackChildSizesStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackGapStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackPaddingStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_HorizontalStackComponentStyleJsonAdapter extends h<UiComponent.HorizontalStackComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28098a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$HorizontalStackBackgroundColorStyle> f28099b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$HorizontalStackBorderWidthStyle> f28100c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$HorizontalStackBorderColorStyle> f28101d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$HorizontalStackBorderRadiusStyle> f28102e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$HorizontalStackPaddingStyle> f28103f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$HorizontalStackMarginStyle> f28104g;

    /* renamed from: h  reason: collision with root package name */
    private final h<AttributeStyles$HorizontalStackAxisStyle> f28105h;

    /* renamed from: i  reason: collision with root package name */
    private final h<AttributeStyles$HorizontalStackChildSizesStyle> f28106i;

    /* renamed from: j  reason: collision with root package name */
    private final h<AttributeStyles$HorizontalStackAlignmentStyle> f28107j;

    /* renamed from: k  reason: collision with root package name */
    private final h<AttributeStyles$HorizontalStackGapStyle> f28108k;

    public UiComponent_HorizontalStackComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("backgroundColor", "borderWidth", "borderColor", "borderRadius", "padding", "margin", "axis", "childSizes", "alignment", "gap");
        j.f(a10, "of(\"backgroundColor\", \"b…zes\", \"alignment\", \"gap\")");
        this.f28098a = a10;
        h<AttributeStyles$HorizontalStackBackgroundColorStyle> f10 = sVar.f(AttributeStyles$HorizontalStackBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f10, "moshi.adapter(AttributeS…\n      \"backgroundColor\")");
        this.f28099b = f10;
        h<AttributeStyles$HorizontalStackBorderWidthStyle> f11 = sVar.f(AttributeStyles$HorizontalStackBorderWidthStyle.class, n0.e(), "borderWidth");
        j.f(f11, "moshi.adapter(AttributeS…t(),\n      \"borderWidth\")");
        this.f28100c = f11;
        h<AttributeStyles$HorizontalStackBorderColorStyle> f12 = sVar.f(AttributeStyles$HorizontalStackBorderColorStyle.class, n0.e(), "borderColor");
        j.f(f12, "moshi.adapter(AttributeS…t(),\n      \"borderColor\")");
        this.f28101d = f12;
        h<AttributeStyles$HorizontalStackBorderRadiusStyle> f13 = sVar.f(AttributeStyles$HorizontalStackBorderRadiusStyle.class, n0.e(), "borderRadius");
        j.f(f13, "moshi.adapter(AttributeS…(),\n      \"borderRadius\")");
        this.f28102e = f13;
        h<AttributeStyles$HorizontalStackPaddingStyle> f14 = sVar.f(AttributeStyles$HorizontalStackPaddingStyle.class, n0.e(), "padding");
        j.f(f14, "moshi.adapter(AttributeS…a, emptySet(), \"padding\")");
        this.f28103f = f14;
        h<AttributeStyles$HorizontalStackMarginStyle> f15 = sVar.f(AttributeStyles$HorizontalStackMarginStyle.class, n0.e(), "margin");
        j.f(f15, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28104g = f15;
        h<AttributeStyles$HorizontalStackAxisStyle> f16 = sVar.f(AttributeStyles$HorizontalStackAxisStyle.class, n0.e(), "axis");
        j.f(f16, "moshi.adapter(AttributeS…java, emptySet(), \"axis\")");
        this.f28105h = f16;
        h<AttributeStyles$HorizontalStackChildSizesStyle> f17 = sVar.f(AttributeStyles$HorizontalStackChildSizesStyle.class, n0.e(), "childSizes");
        j.f(f17, "moshi.adapter(AttributeS…et(),\n      \"childSizes\")");
        this.f28106i = f17;
        h<AttributeStyles$HorizontalStackAlignmentStyle> f18 = sVar.f(AttributeStyles$HorizontalStackAlignmentStyle.class, n0.e(), "alignment");
        j.f(f18, "moshi.adapter(AttributeS…Set(),\n      \"alignment\")");
        this.f28107j = f18;
        h<AttributeStyles$HorizontalStackGapStyle> f19 = sVar.f(AttributeStyles$HorizontalStackGapStyle.class, n0.e(), "gap");
        j.f(f19, "moshi.adapter(AttributeS….java, emptySet(), \"gap\")");
        this.f28108k = f19;
    }

    /* renamed from: a */
    public UiComponent.HorizontalStackComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$HorizontalStackBackgroundColorStyle attributeStyles$HorizontalStackBackgroundColorStyle = null;
        AttributeStyles$HorizontalStackBorderWidthStyle attributeStyles$HorizontalStackBorderWidthStyle = null;
        AttributeStyles$HorizontalStackBorderColorStyle attributeStyles$HorizontalStackBorderColorStyle = null;
        AttributeStyles$HorizontalStackBorderRadiusStyle attributeStyles$HorizontalStackBorderRadiusStyle = null;
        AttributeStyles$HorizontalStackPaddingStyle attributeStyles$HorizontalStackPaddingStyle = null;
        AttributeStyles$HorizontalStackMarginStyle attributeStyles$HorizontalStackMarginStyle = null;
        AttributeStyles$HorizontalStackAxisStyle attributeStyles$HorizontalStackAxisStyle = null;
        AttributeStyles$HorizontalStackChildSizesStyle attributeStyles$HorizontalStackChildSizesStyle = null;
        AttributeStyles$HorizontalStackAlignmentStyle attributeStyles$HorizontalStackAlignmentStyle = null;
        AttributeStyles$HorizontalStackGapStyle attributeStyles$HorizontalStackGapStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28098a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$HorizontalStackBackgroundColorStyle = this.f28099b.fromJson(jsonReader);
                    break;
                case 1:
                    attributeStyles$HorizontalStackBorderWidthStyle = this.f28100c.fromJson(jsonReader);
                    break;
                case 2:
                    attributeStyles$HorizontalStackBorderColorStyle = this.f28101d.fromJson(jsonReader);
                    break;
                case 3:
                    attributeStyles$HorizontalStackBorderRadiusStyle = this.f28102e.fromJson(jsonReader);
                    break;
                case 4:
                    attributeStyles$HorizontalStackPaddingStyle = this.f28103f.fromJson(jsonReader);
                    break;
                case 5:
                    attributeStyles$HorizontalStackMarginStyle = this.f28104g.fromJson(jsonReader);
                    break;
                case 6:
                    attributeStyles$HorizontalStackAxisStyle = this.f28105h.fromJson(jsonReader);
                    break;
                case 7:
                    attributeStyles$HorizontalStackChildSizesStyle = this.f28106i.fromJson(jsonReader);
                    break;
                case 8:
                    attributeStyles$HorizontalStackAlignmentStyle = this.f28107j.fromJson(jsonReader);
                    break;
                case 9:
                    attributeStyles$HorizontalStackGapStyle = this.f28108k.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.HorizontalStackComponentStyle(attributeStyles$HorizontalStackBackgroundColorStyle, attributeStyles$HorizontalStackBorderWidthStyle, attributeStyles$HorizontalStackBorderColorStyle, attributeStyles$HorizontalStackBorderRadiusStyle, attributeStyles$HorizontalStackPaddingStyle, attributeStyles$HorizontalStackMarginStyle, attributeStyles$HorizontalStackAxisStyle, attributeStyles$HorizontalStackChildSizesStyle, attributeStyles$HorizontalStackAlignmentStyle, attributeStyles$HorizontalStackGapStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.HorizontalStackComponentStyle horizontalStackComponentStyle) {
        j.g(qVar, "writer");
        if (horizontalStackComponentStyle != null) {
            qVar.c();
            qVar.u("backgroundColor");
            this.f28099b.toJson(qVar, horizontalStackComponentStyle.f());
            qVar.u("borderWidth");
            this.f28100c.toJson(qVar, horizontalStackComponentStyle.l());
            qVar.u("borderColor");
            this.f28101d.toJson(qVar, horizontalStackComponentStyle.i());
            qVar.u("borderRadius");
            this.f28102e.toJson(qVar, horizontalStackComponentStyle.j());
            qVar.u("padding");
            this.f28103f.toJson(qVar, horizontalStackComponentStyle.t());
            qVar.u("margin");
            this.f28104g.toJson(qVar, horizontalStackComponentStyle.r());
            qVar.u("axis");
            this.f28105h.toJson(qVar, horizontalStackComponentStyle.d());
            qVar.u("childSizes");
            this.f28106i.toJson(qVar, horizontalStackComponentStyle.n());
            qVar.u("alignment");
            this.f28107j.toJson(qVar, horizontalStackComponentStyle.a());
            qVar.u("gap");
            this.f28108k.toJson(qVar, horizontalStackComponentStyle.p());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(63);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.HorizontalStackComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
