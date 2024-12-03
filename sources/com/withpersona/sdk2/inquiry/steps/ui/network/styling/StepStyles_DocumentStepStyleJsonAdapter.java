package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_DocumentStepStyleJsonAdapter extends h<StepStyles$DocumentStepStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29032a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$HeaderButtonColorStyle> f29033b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StepStyles$StepBackgroundColorStyle> f29034c;

    /* renamed from: d  reason: collision with root package name */
    private final h<StepStyles$StepBackgroundImageStyle> f29035d;

    /* renamed from: e  reason: collision with root package name */
    private final h<StepStyles$DocumentStepTitleComponentStyle> f29036e;

    /* renamed from: f  reason: collision with root package name */
    private final h<StepStyles$DocumentStepTextBasedComponentStyle> f29037f;

    /* renamed from: g  reason: collision with root package name */
    private final h<StepStyles$StepTextBasedComponentStyle> f29038g;

    /* renamed from: h  reason: collision with root package name */
    private final h<StepStyles$StepPrimaryButtonComponentStyle> f29039h;

    /* renamed from: i  reason: collision with root package name */
    private final h<StepStyles$StepSecondaryButtonComponentStyle> f29040i;

    /* renamed from: j  reason: collision with root package name */
    private final h<StepStyles$DocumentStepStrokeColor> f29041j;

    /* renamed from: k  reason: collision with root package name */
    private final h<StepStyles$DocumentStepFillColor> f29042k;

    /* renamed from: l  reason: collision with root package name */
    private final h<StepStyles$DocumentStepBorderColor> f29043l;

    /* renamed from: m  reason: collision with root package name */
    private final h<StepStyles$DocumentStepBorderRadius> f29044m;

    /* renamed from: n  reason: collision with root package name */
    private final h<StepStyles$DocumentStepBorderWidth> f29045n;

    /* renamed from: o  reason: collision with root package name */
    private final h<StepStyles$DocumentStepImageLocalStyle> f29046o;

    /* renamed from: p  reason: collision with root package name */
    private final h<StepStyles$StepPaddingStyle> f29047p;

    public StepStyles_DocumentStepStyleJsonAdapter(s sVar) {
        s sVar2 = sVar;
        j.g(sVar2, "moshi");
        JsonReader.b a10 = JsonReader.b.a("textColor", "backgroundColor", "backgroundImage", "titleStyle", "textStyle", "disclaimerStyle", "buttonPrimaryStyle", "buttonSecondaryStyle", "strokeColor", "fillColor", "borderColor", "borderRadius", "borderWidth", "imageLocalStyle", "padding");
        j.f(a10, "of(\"textColor\", \"backgro…geLocalStyle\", \"padding\")");
        this.f29032a = a10;
        h<AttributeStyles$HeaderButtonColorStyle> f10 = sVar2.f(AttributeStyles$HeaderButtonColorStyle.class, n0.e(), "headerButtonColor");
        j.f(f10, "moshi.adapter(AttributeS…     \"headerButtonColor\")");
        this.f29033b = f10;
        h<StepStyles$StepBackgroundColorStyle> f11 = sVar2.f(StepStyles$StepBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f11, "moshi.adapter(StepStyles…Set(), \"backgroundColor\")");
        this.f29034c = f11;
        h<StepStyles$StepBackgroundImageStyle> f12 = sVar2.f(StepStyles$StepBackgroundImageStyle.class, n0.e(), "backgroundImage");
        j.f(f12, "moshi.adapter(StepStyles…Set(), \"backgroundImage\")");
        this.f29035d = f12;
        h<StepStyles$DocumentStepTitleComponentStyle> f13 = sVar2.f(StepStyles$DocumentStepTitleComponentStyle.class, n0.e(), "titleStyle");
        j.f(f13, "moshi.adapter(StepStyles…et(),\n      \"titleStyle\")");
        this.f29036e = f13;
        h<StepStyles$DocumentStepTextBasedComponentStyle> f14 = sVar2.f(StepStyles$DocumentStepTextBasedComponentStyle.class, n0.e(), "textStyle");
        j.f(f14, "moshi.adapter(StepStyles…Set(),\n      \"textStyle\")");
        this.f29037f = f14;
        h<StepStyles$StepTextBasedComponentStyle> f15 = sVar2.f(StepStyles$StepTextBasedComponentStyle.class, n0.e(), "disclaimerStyle");
        j.f(f15, "moshi.adapter(StepStyles…\n      \"disclaimerStyle\")");
        this.f29038g = f15;
        h<StepStyles$StepPrimaryButtonComponentStyle> f16 = sVar2.f(StepStyles$StepPrimaryButtonComponentStyle.class, n0.e(), "buttonPrimaryStyle");
        j.f(f16, "moshi.adapter(StepStyles…    \"buttonPrimaryStyle\")");
        this.f29039h = f16;
        h<StepStyles$StepSecondaryButtonComponentStyle> f17 = sVar2.f(StepStyles$StepSecondaryButtonComponentStyle.class, n0.e(), "buttonSecondaryStyle");
        j.f(f17, "moshi.adapter(StepStyles…  \"buttonSecondaryStyle\")");
        this.f29040i = f17;
        h<StepStyles$DocumentStepStrokeColor> f18 = sVar2.f(StepStyles$DocumentStepStrokeColor.class, n0.e(), "strokeColor");
        j.f(f18, "moshi.adapter(StepStyles…mptySet(), \"strokeColor\")");
        this.f29041j = f18;
        h<StepStyles$DocumentStepFillColor> f19 = sVar2.f(StepStyles$DocumentStepFillColor.class, n0.e(), "fillColor");
        j.f(f19, "moshi.adapter(StepStyles… emptySet(), \"fillColor\")");
        this.f29042k = f19;
        h<StepStyles$DocumentStepBorderColor> f20 = sVar2.f(StepStyles$DocumentStepBorderColor.class, n0.e(), "borderColor");
        j.f(f20, "moshi.adapter(StepStyles…mptySet(), \"borderColor\")");
        this.f29043l = f20;
        h<StepStyles$DocumentStepBorderRadius> f21 = sVar2.f(StepStyles$DocumentStepBorderRadius.class, n0.e(), "borderRadius");
        j.f(f21, "moshi.adapter(StepStyles…ptySet(), \"borderRadius\")");
        this.f29044m = f21;
        h<StepStyles$DocumentStepBorderWidth> f22 = sVar2.f(StepStyles$DocumentStepBorderWidth.class, n0.e(), "borderWidth");
        j.f(f22, "moshi.adapter(StepStyles…mptySet(), \"borderWidth\")");
        this.f29045n = f22;
        h<StepStyles$DocumentStepImageLocalStyle> f23 = sVar2.f(StepStyles$DocumentStepImageLocalStyle.class, n0.e(), "imageLocalStyle");
        j.f(f23, "moshi.adapter(StepStyles…\n      \"imageLocalStyle\")");
        this.f29046o = f23;
        h<StepStyles$StepPaddingStyle> f24 = sVar2.f(StepStyles$StepPaddingStyle.class, n0.e(), "padding");
        j.f(f24, "moshi.adapter(StepStyles…a, emptySet(), \"padding\")");
        this.f29047p = f24;
    }

    /* renamed from: a */
    public StepStyles$DocumentStepStyle fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = null;
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = null;
        StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle = null;
        StepStyles$DocumentStepTitleComponentStyle stepStyles$DocumentStepTitleComponentStyle = null;
        StepStyles$DocumentStepTextBasedComponentStyle stepStyles$DocumentStepTextBasedComponentStyle = null;
        StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle = null;
        StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle = null;
        StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle = null;
        StepStyles$DocumentStepStrokeColor stepStyles$DocumentStepStrokeColor = null;
        StepStyles$DocumentStepFillColor stepStyles$DocumentStepFillColor = null;
        StepStyles$DocumentStepBorderColor stepStyles$DocumentStepBorderColor = null;
        StepStyles$DocumentStepBorderRadius stepStyles$DocumentStepBorderRadius = null;
        StepStyles$DocumentStepBorderWidth stepStyles$DocumentStepBorderWidth = null;
        StepStyles$DocumentStepImageLocalStyle stepStyles$DocumentStepImageLocalStyle = null;
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f29032a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$HeaderButtonColorStyle = this.f29033b.fromJson(jsonReader2);
                    break;
                case 1:
                    stepStyles$StepBackgroundColorStyle = this.f29034c.fromJson(jsonReader2);
                    break;
                case 2:
                    stepStyles$StepBackgroundImageStyle = this.f29035d.fromJson(jsonReader2);
                    break;
                case 3:
                    stepStyles$DocumentStepTitleComponentStyle = this.f29036e.fromJson(jsonReader2);
                    break;
                case 4:
                    stepStyles$DocumentStepTextBasedComponentStyle = this.f29037f.fromJson(jsonReader2);
                    break;
                case 5:
                    stepStyles$StepTextBasedComponentStyle = this.f29038g.fromJson(jsonReader2);
                    break;
                case 6:
                    stepStyles$StepPrimaryButtonComponentStyle = this.f29039h.fromJson(jsonReader2);
                    break;
                case 7:
                    stepStyles$StepSecondaryButtonComponentStyle = this.f29040i.fromJson(jsonReader2);
                    break;
                case 8:
                    stepStyles$DocumentStepStrokeColor = this.f29041j.fromJson(jsonReader2);
                    break;
                case 9:
                    stepStyles$DocumentStepFillColor = this.f29042k.fromJson(jsonReader2);
                    break;
                case 10:
                    stepStyles$DocumentStepBorderColor = this.f29043l.fromJson(jsonReader2);
                    break;
                case 11:
                    stepStyles$DocumentStepBorderRadius = this.f29044m.fromJson(jsonReader2);
                    break;
                case 12:
                    stepStyles$DocumentStepBorderWidth = this.f29045n.fromJson(jsonReader2);
                    break;
                case 13:
                    stepStyles$DocumentStepImageLocalStyle = this.f29046o.fromJson(jsonReader2);
                    break;
                case 14:
                    stepStyles$StepPaddingStyle = this.f29047p.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.e();
        return new StepStyles$DocumentStepStyle(attributeStyles$HeaderButtonColorStyle, stepStyles$StepBackgroundColorStyle, stepStyles$StepBackgroundImageStyle, stepStyles$DocumentStepTitleComponentStyle, stepStyles$DocumentStepTextBasedComponentStyle, stepStyles$StepTextBasedComponentStyle, stepStyles$StepPrimaryButtonComponentStyle, stepStyles$StepSecondaryButtonComponentStyle, stepStyles$DocumentStepStrokeColor, stepStyles$DocumentStepFillColor, stepStyles$DocumentStepBorderColor, stepStyles$DocumentStepBorderRadius, stepStyles$DocumentStepBorderWidth, stepStyles$DocumentStepImageLocalStyle, stepStyles$StepPaddingStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle) {
        j.g(qVar, "writer");
        if (stepStyles$DocumentStepStyle != null) {
            qVar.c();
            qVar.u("textColor");
            this.f29033b.toJson(qVar, stepStyles$DocumentStepStyle.l());
            qVar.u("backgroundColor");
            this.f29034c.toJson(qVar, stepStyles$DocumentStepStyle.a());
            qVar.u("backgroundImage");
            this.f29035d.toJson(qVar, stepStyles$DocumentStepStyle.c());
            qVar.u("titleStyle");
            this.f29036e.toJson(qVar, stepStyles$DocumentStepStyle.E());
            qVar.u("textStyle");
            this.f29037f.toJson(qVar, stepStyles$DocumentStepStyle.D());
            qVar.u("disclaimerStyle");
            this.f29038g.toJson(qVar, stepStyles$DocumentStepStyle.i());
            qVar.u("buttonPrimaryStyle");
            this.f29039h.toJson(qVar, stepStyles$DocumentStepStyle.g());
            qVar.u("buttonSecondaryStyle");
            this.f29040i.toJson(qVar, stepStyles$DocumentStepStyle.h());
            qVar.u("strokeColor");
            this.f29041j.toJson(qVar, stepStyles$DocumentStepStyle.B());
            qVar.u("fillColor");
            this.f29042k.toJson(qVar, stepStyles$DocumentStepStyle.k());
            qVar.u("borderColor");
            this.f29043l.toJson(qVar, stepStyles$DocumentStepStyle.d());
            qVar.u("borderRadius");
            this.f29044m.toJson(qVar, stepStyles$DocumentStepStyle.e());
            qVar.u("borderWidth");
            this.f29045n.toJson(qVar, stepStyles$DocumentStepStyle.f());
            qVar.u("imageLocalStyle");
            this.f29046o.toJson(qVar, stepStyles$DocumentStepStyle.n());
            qVar.u("padding");
            this.f29047p.toJson(qVar, stepStyles$DocumentStepStyle.A());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.DocumentStepStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
