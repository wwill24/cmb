package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_SelfieStepStyleJsonAdapter extends h<StepStyles$SelfieStepStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29100a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$HeaderButtonColorStyle> f29101b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StepStyles$StepBackgroundColorStyle> f29102c;

    /* renamed from: d  reason: collision with root package name */
    private final h<StepStyles$StepBackgroundImageStyle> f29103d;

    /* renamed from: e  reason: collision with root package name */
    private final h<StepStyles$SelfieStepTitleComponentStyle> f29104e;

    /* renamed from: f  reason: collision with root package name */
    private final h<StepStyles$SelfieStepTextBasedComponentStyle> f29105f;

    /* renamed from: g  reason: collision with root package name */
    private final h<StepStyles$StepPrimaryButtonComponentStyle> f29106g;

    /* renamed from: h  reason: collision with root package name */
    private final h<StepStyles$StepSecondaryButtonComponentStyle> f29107h;

    /* renamed from: i  reason: collision with root package name */
    private final h<StepStyles$StepTextBasedComponentStyle> f29108i;

    /* renamed from: j  reason: collision with root package name */
    private final h<StepStyles$SelfieStepStrokeColor> f29109j;

    /* renamed from: k  reason: collision with root package name */
    private final h<StepStyles$SelfieStepBorderColor> f29110k;

    /* renamed from: l  reason: collision with root package name */
    private final h<StepStyles$SelfieStepBorderWidth> f29111l;

    /* renamed from: m  reason: collision with root package name */
    private final h<StepStyles$SelfieStepFillColor> f29112m;

    /* renamed from: n  reason: collision with root package name */
    private final h<StepStyles$SelfieStepImageLocalStyle> f29113n;

    /* renamed from: o  reason: collision with root package name */
    private final h<StepStyles$StepPaddingStyle> f29114o;

    /* renamed from: p  reason: collision with root package name */
    private final h<StepStyles$StepBorderRadiusStyle> f29115p;

    public StepStyles_SelfieStepStyleJsonAdapter(s sVar) {
        s sVar2 = sVar;
        j.g(sVar2, "moshi");
        JsonReader.b a10 = JsonReader.b.a("textColor", "backgroundColor", "backgroundImage", "titleStyle", "textStyle", "buttonPrimaryStyle", "buttonSecondaryStyle", "disclaimerStyle", "strokeColor", "borderColor", "borderWidth", "fillColor", "imageLocalStyle", "padding", "borderRadius");
        j.f(a10, "of(\"textColor\", \"backgro…padding\", \"borderRadius\")");
        this.f29100a = a10;
        h<AttributeStyles$HeaderButtonColorStyle> f10 = sVar2.f(AttributeStyles$HeaderButtonColorStyle.class, n0.e(), "headerButtonColor");
        j.f(f10, "moshi.adapter(AttributeS…     \"headerButtonColor\")");
        this.f29101b = f10;
        h<StepStyles$StepBackgroundColorStyle> f11 = sVar2.f(StepStyles$StepBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f11, "moshi.adapter(StepStyles…Set(), \"backgroundColor\")");
        this.f29102c = f11;
        h<StepStyles$StepBackgroundImageStyle> f12 = sVar2.f(StepStyles$StepBackgroundImageStyle.class, n0.e(), "backgroundImage");
        j.f(f12, "moshi.adapter(StepStyles…Set(), \"backgroundImage\")");
        this.f29103d = f12;
        h<StepStyles$SelfieStepTitleComponentStyle> f13 = sVar2.f(StepStyles$SelfieStepTitleComponentStyle.class, n0.e(), "titleStyle");
        j.f(f13, "moshi.adapter(StepStyles…emptySet(), \"titleStyle\")");
        this.f29104e = f13;
        h<StepStyles$SelfieStepTextBasedComponentStyle> f14 = sVar2.f(StepStyles$SelfieStepTextBasedComponentStyle.class, n0.e(), "textStyle");
        j.f(f14, "moshi.adapter(StepStyles…Set(),\n      \"textStyle\")");
        this.f29105f = f14;
        h<StepStyles$StepPrimaryButtonComponentStyle> f15 = sVar2.f(StepStyles$StepPrimaryButtonComponentStyle.class, n0.e(), "buttonPrimaryStyle");
        j.f(f15, "moshi.adapter(StepStyles…    \"buttonPrimaryStyle\")");
        this.f29106g = f15;
        h<StepStyles$StepSecondaryButtonComponentStyle> f16 = sVar2.f(StepStyles$StepSecondaryButtonComponentStyle.class, n0.e(), "buttonSecondaryStyle");
        j.f(f16, "moshi.adapter(StepStyles…  \"buttonSecondaryStyle\")");
        this.f29107h = f16;
        h<StepStyles$StepTextBasedComponentStyle> f17 = sVar2.f(StepStyles$StepTextBasedComponentStyle.class, n0.e(), "disclaimerStyle");
        j.f(f17, "moshi.adapter(StepStyles…\n      \"disclaimerStyle\")");
        this.f29108i = f17;
        h<StepStyles$SelfieStepStrokeColor> f18 = sVar2.f(StepStyles$SelfieStepStrokeColor.class, n0.e(), "strokeColor");
        j.f(f18, "moshi.adapter(StepStyles…mptySet(), \"strokeColor\")");
        this.f29109j = f18;
        h<StepStyles$SelfieStepBorderColor> f19 = sVar2.f(StepStyles$SelfieStepBorderColor.class, n0.e(), "borderColor");
        j.f(f19, "moshi.adapter(StepStyles…mptySet(), \"borderColor\")");
        this.f29110k = f19;
        h<StepStyles$SelfieStepBorderWidth> f20 = sVar2.f(StepStyles$SelfieStepBorderWidth.class, n0.e(), "borderWidth");
        j.f(f20, "moshi.adapter(StepStyles…mptySet(), \"borderWidth\")");
        this.f29111l = f20;
        h<StepStyles$SelfieStepFillColor> f21 = sVar2.f(StepStyles$SelfieStepFillColor.class, n0.e(), "fillColor");
        j.f(f21, "moshi.adapter(StepStyles… emptySet(), \"fillColor\")");
        this.f29112m = f21;
        h<StepStyles$SelfieStepImageLocalStyle> f22 = sVar2.f(StepStyles$SelfieStepImageLocalStyle.class, n0.e(), "imageLocalStyle");
        j.f(f22, "moshi.adapter(StepStyles…Set(), \"imageLocalStyle\")");
        this.f29113n = f22;
        h<StepStyles$StepPaddingStyle> f23 = sVar2.f(StepStyles$StepPaddingStyle.class, n0.e(), "padding");
        j.f(f23, "moshi.adapter(StepStyles…a, emptySet(), \"padding\")");
        this.f29114o = f23;
        h<StepStyles$StepBorderRadiusStyle> f24 = sVar2.f(StepStyles$StepBorderRadiusStyle.class, n0.e(), "borderRadius");
        j.f(f24, "moshi.adapter(StepStyles…ptySet(), \"borderRadius\")");
        this.f29115p = f24;
    }

    /* renamed from: a */
    public StepStyles$SelfieStepStyle fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = null;
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = null;
        StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle = null;
        StepStyles$SelfieStepTitleComponentStyle stepStyles$SelfieStepTitleComponentStyle = null;
        StepStyles$SelfieStepTextBasedComponentStyle stepStyles$SelfieStepTextBasedComponentStyle = null;
        StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle = null;
        StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle = null;
        StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle = null;
        StepStyles$SelfieStepStrokeColor stepStyles$SelfieStepStrokeColor = null;
        StepStyles$SelfieStepBorderColor stepStyles$SelfieStepBorderColor = null;
        StepStyles$SelfieStepBorderWidth stepStyles$SelfieStepBorderWidth = null;
        StepStyles$SelfieStepFillColor stepStyles$SelfieStepFillColor = null;
        StepStyles$SelfieStepImageLocalStyle stepStyles$SelfieStepImageLocalStyle = null;
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = null;
        StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f29100a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$HeaderButtonColorStyle = this.f29101b.fromJson(jsonReader2);
                    break;
                case 1:
                    stepStyles$StepBackgroundColorStyle = this.f29102c.fromJson(jsonReader2);
                    break;
                case 2:
                    stepStyles$StepBackgroundImageStyle = this.f29103d.fromJson(jsonReader2);
                    break;
                case 3:
                    stepStyles$SelfieStepTitleComponentStyle = this.f29104e.fromJson(jsonReader2);
                    break;
                case 4:
                    stepStyles$SelfieStepTextBasedComponentStyle = this.f29105f.fromJson(jsonReader2);
                    break;
                case 5:
                    stepStyles$StepPrimaryButtonComponentStyle = this.f29106g.fromJson(jsonReader2);
                    break;
                case 6:
                    stepStyles$StepSecondaryButtonComponentStyle = this.f29107h.fromJson(jsonReader2);
                    break;
                case 7:
                    stepStyles$StepTextBasedComponentStyle = this.f29108i.fromJson(jsonReader2);
                    break;
                case 8:
                    stepStyles$SelfieStepStrokeColor = this.f29109j.fromJson(jsonReader2);
                    break;
                case 9:
                    stepStyles$SelfieStepBorderColor = this.f29110k.fromJson(jsonReader2);
                    break;
                case 10:
                    stepStyles$SelfieStepBorderWidth = this.f29111l.fromJson(jsonReader2);
                    break;
                case 11:
                    stepStyles$SelfieStepFillColor = this.f29112m.fromJson(jsonReader2);
                    break;
                case 12:
                    stepStyles$SelfieStepImageLocalStyle = this.f29113n.fromJson(jsonReader2);
                    break;
                case 13:
                    stepStyles$StepPaddingStyle = this.f29114o.fromJson(jsonReader2);
                    break;
                case 14:
                    stepStyles$StepBorderRadiusStyle = this.f29115p.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.e();
        return new StepStyles$SelfieStepStyle(attributeStyles$HeaderButtonColorStyle, stepStyles$StepBackgroundColorStyle, stepStyles$StepBackgroundImageStyle, stepStyles$SelfieStepTitleComponentStyle, stepStyles$SelfieStepTextBasedComponentStyle, stepStyles$StepPrimaryButtonComponentStyle, stepStyles$StepSecondaryButtonComponentStyle, stepStyles$StepTextBasedComponentStyle, stepStyles$SelfieStepStrokeColor, stepStyles$SelfieStepBorderColor, stepStyles$SelfieStepBorderWidth, stepStyles$SelfieStepFillColor, stepStyles$SelfieStepImageLocalStyle, stepStyles$StepPaddingStyle, stepStyles$StepBorderRadiusStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle) {
        j.g(qVar, "writer");
        if (stepStyles$SelfieStepStyle != null) {
            qVar.c();
            qVar.u("textColor");
            this.f29101b.toJson(qVar, stepStyles$SelfieStepStyle.l());
            qVar.u("backgroundColor");
            this.f29102c.toJson(qVar, stepStyles$SelfieStepStyle.a());
            qVar.u("backgroundImage");
            this.f29103d.toJson(qVar, stepStyles$SelfieStepStyle.c());
            qVar.u("titleStyle");
            this.f29104e.toJson(qVar, stepStyles$SelfieStepStyle.A());
            qVar.u("textStyle");
            this.f29105f.toJson(qVar, stepStyles$SelfieStepStyle.z());
            qVar.u("buttonPrimaryStyle");
            this.f29106g.toJson(qVar, stepStyles$SelfieStepStyle.g());
            qVar.u("buttonSecondaryStyle");
            this.f29107h.toJson(qVar, stepStyles$SelfieStepStyle.h());
            qVar.u("disclaimerStyle");
            this.f29108i.toJson(qVar, stepStyles$SelfieStepStyle.i());
            qVar.u("strokeColor");
            this.f29109j.toJson(qVar, stepStyles$SelfieStepStyle.x());
            qVar.u("borderColor");
            this.f29110k.toJson(qVar, stepStyles$SelfieStepStyle.d());
            qVar.u("borderWidth");
            this.f29111l.toJson(qVar, stepStyles$SelfieStepStyle.f());
            qVar.u("fillColor");
            this.f29112m.toJson(qVar, stepStyles$SelfieStepStyle.k());
            qVar.u("imageLocalStyle");
            this.f29113n.toJson(qVar, stepStyles$SelfieStepStyle.n());
            qVar.u("padding");
            this.f29114o.toJson(qVar, stepStyles$SelfieStepStyle.o());
            qVar.u("borderRadius");
            this.f29115p.toJson(qVar, stepStyles$SelfieStepStyle.e());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.SelfieStepStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
