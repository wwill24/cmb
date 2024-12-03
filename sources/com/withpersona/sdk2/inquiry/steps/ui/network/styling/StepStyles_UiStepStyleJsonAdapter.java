package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_UiStepStyleJsonAdapter extends h<StepStyles$UiStepStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29153a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$HeaderButtonColorStyle> f29154b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StepStyles$StepBackgroundColorStyle> f29155c;

    /* renamed from: d  reason: collision with root package name */
    private final h<StepStyles$StepBackgroundImageStyle> f29156d;

    /* renamed from: e  reason: collision with root package name */
    private final h<StepStyles$UiStepTitleComponentStyle> f29157e;

    /* renamed from: f  reason: collision with root package name */
    private final h<StepStyles$UiStepTextBasedComponentStyle> f29158f;

    /* renamed from: g  reason: collision with root package name */
    private final h<StepStyles$StepPrimaryButtonComponentStyle> f29159g;

    /* renamed from: h  reason: collision with root package name */
    private final h<StepStyles$StepSecondaryButtonComponentStyle> f29160h;

    /* renamed from: i  reason: collision with root package name */
    private final h<StepStyles$UiStepStrokeColor> f29161i;

    /* renamed from: j  reason: collision with root package name */
    private final h<StepStyles$UiStepFillColor> f29162j;

    /* renamed from: k  reason: collision with root package name */
    private final h<StepStyles$UiStepAlignment> f29163k;

    /* renamed from: l  reason: collision with root package name */
    private final h<StepStyles$StepPaddingStyle> f29164l;

    /* renamed from: m  reason: collision with root package name */
    private final h<StepStyles$StepBorderRadiusStyle> f29165m;

    public StepStyles_UiStepStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("textColor", "backgroundColor", "backgroundImage", "titleStyle", "textStyle", "buttonPrimaryStyle", "buttonSecondaryStyle", "strokeColor", "fillColor", "alignment", "padding", "borderRadius");
        j.f(a10, "of(\"textColor\", \"backgro…padding\", \"borderRadius\")");
        this.f29153a = a10;
        h<AttributeStyles$HeaderButtonColorStyle> f10 = sVar.f(AttributeStyles$HeaderButtonColorStyle.class, n0.e(), "headerButtonColor");
        j.f(f10, "moshi.adapter(AttributeS…     \"headerButtonColor\")");
        this.f29154b = f10;
        h<StepStyles$StepBackgroundColorStyle> f11 = sVar.f(StepStyles$StepBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f11, "moshi.adapter(StepStyles…Set(), \"backgroundColor\")");
        this.f29155c = f11;
        h<StepStyles$StepBackgroundImageStyle> f12 = sVar.f(StepStyles$StepBackgroundImageStyle.class, n0.e(), "backgroundImage");
        j.f(f12, "moshi.adapter(StepStyles…Set(), \"backgroundImage\")");
        this.f29156d = f12;
        h<StepStyles$UiStepTitleComponentStyle> f13 = sVar.f(StepStyles$UiStepTitleComponentStyle.class, n0.e(), "titleStyle");
        j.f(f13, "moshi.adapter(StepStyles…emptySet(), \"titleStyle\")");
        this.f29157e = f13;
        h<StepStyles$UiStepTextBasedComponentStyle> f14 = sVar.f(StepStyles$UiStepTextBasedComponentStyle.class, n0.e(), "textStyle");
        j.f(f14, "moshi.adapter(StepStyles… emptySet(), \"textStyle\")");
        this.f29158f = f14;
        h<StepStyles$StepPrimaryButtonComponentStyle> f15 = sVar.f(StepStyles$StepPrimaryButtonComponentStyle.class, n0.e(), "buttonPrimaryStyle");
        j.f(f15, "moshi.adapter(StepStyles…    \"buttonPrimaryStyle\")");
        this.f29159g = f15;
        h<StepStyles$StepSecondaryButtonComponentStyle> f16 = sVar.f(StepStyles$StepSecondaryButtonComponentStyle.class, n0.e(), "buttonSecondaryStyle");
        j.f(f16, "moshi.adapter(StepStyles…  \"buttonSecondaryStyle\")");
        this.f29160h = f16;
        h<StepStyles$UiStepStrokeColor> f17 = sVar.f(StepStyles$UiStepStrokeColor.class, n0.e(), "strokeColor");
        j.f(f17, "moshi.adapter(StepStyles…mptySet(), \"strokeColor\")");
        this.f29161i = f17;
        h<StepStyles$UiStepFillColor> f18 = sVar.f(StepStyles$UiStepFillColor.class, n0.e(), "fillColor");
        j.f(f18, "moshi.adapter(StepStyles… emptySet(), \"fillColor\")");
        this.f29162j = f18;
        h<StepStyles$UiStepAlignment> f19 = sVar.f(StepStyles$UiStepAlignment.class, n0.e(), "alignment");
        j.f(f19, "moshi.adapter(StepStyles… emptySet(), \"alignment\")");
        this.f29163k = f19;
        h<StepStyles$StepPaddingStyle> f20 = sVar.f(StepStyles$StepPaddingStyle.class, n0.e(), "padding");
        j.f(f20, "moshi.adapter(StepStyles…a, emptySet(), \"padding\")");
        this.f29164l = f20;
        h<StepStyles$StepBorderRadiusStyle> f21 = sVar.f(StepStyles$StepBorderRadiusStyle.class, n0.e(), "borderRadius");
        j.f(f21, "moshi.adapter(StepStyles…ptySet(), \"borderRadius\")");
        this.f29165m = f21;
    }

    /* renamed from: a */
    public StepStyles$UiStepStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = null;
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = null;
        StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle = null;
        StepStyles$UiStepTitleComponentStyle stepStyles$UiStepTitleComponentStyle = null;
        StepStyles$UiStepTextBasedComponentStyle stepStyles$UiStepTextBasedComponentStyle = null;
        StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle = null;
        StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle = null;
        StepStyles$UiStepStrokeColor stepStyles$UiStepStrokeColor = null;
        StepStyles$UiStepFillColor stepStyles$UiStepFillColor = null;
        StepStyles$UiStepAlignment stepStyles$UiStepAlignment = null;
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = null;
        StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f29153a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$HeaderButtonColorStyle = this.f29154b.fromJson(jsonReader);
                    break;
                case 1:
                    stepStyles$StepBackgroundColorStyle = this.f29155c.fromJson(jsonReader);
                    break;
                case 2:
                    stepStyles$StepBackgroundImageStyle = this.f29156d.fromJson(jsonReader);
                    break;
                case 3:
                    stepStyles$UiStepTitleComponentStyle = this.f29157e.fromJson(jsonReader);
                    break;
                case 4:
                    stepStyles$UiStepTextBasedComponentStyle = this.f29158f.fromJson(jsonReader);
                    break;
                case 5:
                    stepStyles$StepPrimaryButtonComponentStyle = this.f29159g.fromJson(jsonReader);
                    break;
                case 6:
                    stepStyles$StepSecondaryButtonComponentStyle = this.f29160h.fromJson(jsonReader);
                    break;
                case 7:
                    stepStyles$UiStepStrokeColor = this.f29161i.fromJson(jsonReader);
                    break;
                case 8:
                    stepStyles$UiStepFillColor = this.f29162j.fromJson(jsonReader);
                    break;
                case 9:
                    stepStyles$UiStepAlignment = this.f29163k.fromJson(jsonReader);
                    break;
                case 10:
                    stepStyles$StepPaddingStyle = this.f29164l.fromJson(jsonReader);
                    break;
                case 11:
                    stepStyles$StepBorderRadiusStyle = this.f29165m.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new StepStyles$UiStepStyle(attributeStyles$HeaderButtonColorStyle, stepStyles$StepBackgroundColorStyle, stepStyles$StepBackgroundImageStyle, stepStyles$UiStepTitleComponentStyle, stepStyles$UiStepTextBasedComponentStyle, stepStyles$StepPrimaryButtonComponentStyle, stepStyles$StepSecondaryButtonComponentStyle, stepStyles$UiStepStrokeColor, stepStyles$UiStepFillColor, stepStyles$UiStepAlignment, stepStyles$StepPaddingStyle, stepStyles$StepBorderRadiusStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$UiStepStyle stepStyles$UiStepStyle) {
        j.g(qVar, "writer");
        if (stepStyles$UiStepStyle != null) {
            qVar.c();
            qVar.u("textColor");
            this.f29154b.toJson(qVar, stepStyles$UiStepStyle.i());
            qVar.u("backgroundColor");
            this.f29155c.toJson(qVar, stepStyles$UiStepStyle.c());
            qVar.u("backgroundImage");
            this.f29156d.toJson(qVar, stepStyles$UiStepStyle.d());
            qVar.u("titleStyle");
            this.f29157e.toJson(qVar, stepStyles$UiStepStyle.n());
            qVar.u("textStyle");
            this.f29158f.toJson(qVar, stepStyles$UiStepStyle.m());
            qVar.u("buttonPrimaryStyle");
            this.f29159g.toJson(qVar, stepStyles$UiStepStyle.f());
            qVar.u("buttonSecondaryStyle");
            this.f29160h.toJson(qVar, stepStyles$UiStepStyle.g());
            qVar.u("strokeColor");
            this.f29161i.toJson(qVar, stepStyles$UiStepStyle.l());
            qVar.u("fillColor");
            this.f29162j.toJson(qVar, stepStyles$UiStepStyle.h());
            qVar.u("alignment");
            this.f29163k.toJson(qVar, stepStyles$UiStepStyle.a());
            qVar.u("padding");
            this.f29164l.toJson(qVar, stepStyles$UiStepStyle.j());
            qVar.u("borderRadius");
            this.f29165m.toJson(qVar, stepStyles$UiStepStyle.e());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.UiStepStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
