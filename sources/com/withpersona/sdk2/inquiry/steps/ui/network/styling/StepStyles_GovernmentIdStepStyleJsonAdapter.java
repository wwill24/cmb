package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_GovernmentIdStepStyleJsonAdapter extends h<StepStyles$GovernmentIdStepStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29068a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$HeaderButtonColorStyle> f29069b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StepStyles$StepBackgroundColorStyle> f29070c;

    /* renamed from: d  reason: collision with root package name */
    private final h<StepStyles$StepBackgroundImageStyle> f29071d;

    /* renamed from: e  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepTitleComponentStyle> f29072e;

    /* renamed from: f  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepTextBasedComponentStyle> f29073f;

    /* renamed from: g  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepPrimaryButtonComponentStyle> f29074g;

    /* renamed from: h  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepSecondaryButtonComponentStyle> f29075h;

    /* renamed from: i  reason: collision with root package name */
    private final h<StepStyles$StepTextBasedComponentStyle> f29076i;

    /* renamed from: j  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepRowHeight> f29077j;

    /* renamed from: k  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepStrokeColor> f29078k;

    /* renamed from: l  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepFillColor> f29079l;

    /* renamed from: m  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepBorderColor> f29080m;

    /* renamed from: n  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepBorderRadius> f29081n;

    /* renamed from: o  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepBorderWidth> f29082o;

    /* renamed from: p  reason: collision with root package name */
    private final h<StepStyles$StepPaddingStyle> f29083p;

    public StepStyles_GovernmentIdStepStyleJsonAdapter(s sVar) {
        s sVar2 = sVar;
        j.g(sVar2, "moshi");
        JsonReader.b a10 = JsonReader.b.a("textColor", "backgroundColor", "backgroundImage", "titleStyle", "textStyle", "buttonPrimaryStyle", "buttonSecondaryStyle", "disclaimerStyle", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "strokeColor", "fillColor", "borderColor", "borderRadius", "borderWidth", "padding");
        j.f(a10, "of(\"textColor\", \"backgro…\"borderWidth\", \"padding\")");
        this.f29068a = a10;
        h<AttributeStyles$HeaderButtonColorStyle> f10 = sVar2.f(AttributeStyles$HeaderButtonColorStyle.class, n0.e(), "headerButtonColor");
        j.f(f10, "moshi.adapter(AttributeS…     \"headerButtonColor\")");
        this.f29069b = f10;
        h<StepStyles$StepBackgroundColorStyle> f11 = sVar2.f(StepStyles$StepBackgroundColorStyle.class, n0.e(), "backgroundColor");
        j.f(f11, "moshi.adapter(StepStyles…Set(), \"backgroundColor\")");
        this.f29070c = f11;
        h<StepStyles$StepBackgroundImageStyle> f12 = sVar2.f(StepStyles$StepBackgroundImageStyle.class, n0.e(), "backgroundImage");
        j.f(f12, "moshi.adapter(StepStyles…Set(), \"backgroundImage\")");
        this.f29071d = f12;
        h<StepStyles$GovernmentIdStepTitleComponentStyle> f13 = sVar2.f(StepStyles$GovernmentIdStepTitleComponentStyle.class, n0.e(), "titleStyle");
        j.f(f13, "moshi.adapter(StepStyles…et(),\n      \"titleStyle\")");
        this.f29072e = f13;
        h<StepStyles$GovernmentIdStepTextBasedComponentStyle> f14 = sVar2.f(StepStyles$GovernmentIdStepTextBasedComponentStyle.class, n0.e(), "textStyle");
        j.f(f14, "moshi.adapter(StepStyles…Set(),\n      \"textStyle\")");
        this.f29073f = f14;
        h<StepStyles$GovernmentIdStepPrimaryButtonComponentStyle> f15 = sVar2.f(StepStyles$GovernmentIdStepPrimaryButtonComponentStyle.class, n0.e(), "buttonPrimaryStyle");
        j.f(f15, "moshi.adapter(StepStyles…    \"buttonPrimaryStyle\")");
        this.f29074g = f15;
        h<StepStyles$GovernmentIdStepSecondaryButtonComponentStyle> f16 = sVar2.f(StepStyles$GovernmentIdStepSecondaryButtonComponentStyle.class, n0.e(), "buttonSecondaryStyle");
        j.f(f16, "moshi.adapter(StepStyles…, \"buttonSecondaryStyle\")");
        this.f29075h = f16;
        h<StepStyles$StepTextBasedComponentStyle> f17 = sVar2.f(StepStyles$StepTextBasedComponentStyle.class, n0.e(), "disclaimerStyle");
        j.f(f17, "moshi.adapter(StepStyles…\n      \"disclaimerStyle\")");
        this.f29076i = f17;
        h<StepStyles$GovernmentIdStepRowHeight> f18 = sVar2.f(StepStyles$GovernmentIdStepRowHeight.class, n0.e(), ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        j.f(f18, "moshi.adapter(StepStyles…va, emptySet(), \"height\")");
        this.f29077j = f18;
        h<StepStyles$GovernmentIdStepStrokeColor> f19 = sVar2.f(StepStyles$GovernmentIdStepStrokeColor.class, n0.e(), "strokeColor");
        j.f(f19, "moshi.adapter(StepStyles…mptySet(), \"strokeColor\")");
        this.f29078k = f19;
        h<StepStyles$GovernmentIdStepFillColor> f20 = sVar2.f(StepStyles$GovernmentIdStepFillColor.class, n0.e(), "fillColor");
        j.f(f20, "moshi.adapter(StepStyles… emptySet(), \"fillColor\")");
        this.f29079l = f20;
        h<StepStyles$GovernmentIdStepBorderColor> f21 = sVar2.f(StepStyles$GovernmentIdStepBorderColor.class, n0.e(), "borderColor");
        j.f(f21, "moshi.adapter(StepStyles…mptySet(), \"borderColor\")");
        this.f29080m = f21;
        h<StepStyles$GovernmentIdStepBorderRadius> f22 = sVar2.f(StepStyles$GovernmentIdStepBorderRadius.class, n0.e(), "borderRadius");
        j.f(f22, "moshi.adapter(StepStyles…ptySet(), \"borderRadius\")");
        this.f29081n = f22;
        h<StepStyles$GovernmentIdStepBorderWidth> f23 = sVar2.f(StepStyles$GovernmentIdStepBorderWidth.class, n0.e(), "borderWidth");
        j.f(f23, "moshi.adapter(StepStyles…mptySet(), \"borderWidth\")");
        this.f29082o = f23;
        h<StepStyles$StepPaddingStyle> f24 = sVar2.f(StepStyles$StepPaddingStyle.class, n0.e(), "padding");
        j.f(f24, "moshi.adapter(StepStyles…a, emptySet(), \"padding\")");
        this.f29083p = f24;
    }

    /* renamed from: a */
    public StepStyles$GovernmentIdStepStyle fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = null;
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = null;
        StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle = null;
        StepStyles$GovernmentIdStepTitleComponentStyle stepStyles$GovernmentIdStepTitleComponentStyle = null;
        StepStyles$GovernmentIdStepTextBasedComponentStyle stepStyles$GovernmentIdStepTextBasedComponentStyle = null;
        StepStyles$GovernmentIdStepPrimaryButtonComponentStyle stepStyles$GovernmentIdStepPrimaryButtonComponentStyle = null;
        StepStyles$GovernmentIdStepSecondaryButtonComponentStyle stepStyles$GovernmentIdStepSecondaryButtonComponentStyle = null;
        StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle = null;
        StepStyles$GovernmentIdStepRowHeight stepStyles$GovernmentIdStepRowHeight = null;
        StepStyles$GovernmentIdStepStrokeColor stepStyles$GovernmentIdStepStrokeColor = null;
        StepStyles$GovernmentIdStepFillColor stepStyles$GovernmentIdStepFillColor = null;
        StepStyles$GovernmentIdStepBorderColor stepStyles$GovernmentIdStepBorderColor = null;
        StepStyles$GovernmentIdStepBorderRadius stepStyles$GovernmentIdStepBorderRadius = null;
        StepStyles$GovernmentIdStepBorderWidth stepStyles$GovernmentIdStepBorderWidth = null;
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f29068a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$HeaderButtonColorStyle = this.f29069b.fromJson(jsonReader2);
                    break;
                case 1:
                    stepStyles$StepBackgroundColorStyle = this.f29070c.fromJson(jsonReader2);
                    break;
                case 2:
                    stepStyles$StepBackgroundImageStyle = this.f29071d.fromJson(jsonReader2);
                    break;
                case 3:
                    stepStyles$GovernmentIdStepTitleComponentStyle = this.f29072e.fromJson(jsonReader2);
                    break;
                case 4:
                    stepStyles$GovernmentIdStepTextBasedComponentStyle = this.f29073f.fromJson(jsonReader2);
                    break;
                case 5:
                    stepStyles$GovernmentIdStepPrimaryButtonComponentStyle = this.f29074g.fromJson(jsonReader2);
                    break;
                case 6:
                    stepStyles$GovernmentIdStepSecondaryButtonComponentStyle = this.f29075h.fromJson(jsonReader2);
                    break;
                case 7:
                    stepStyles$StepTextBasedComponentStyle = this.f29076i.fromJson(jsonReader2);
                    break;
                case 8:
                    stepStyles$GovernmentIdStepRowHeight = this.f29077j.fromJson(jsonReader2);
                    break;
                case 9:
                    stepStyles$GovernmentIdStepStrokeColor = this.f29078k.fromJson(jsonReader2);
                    break;
                case 10:
                    stepStyles$GovernmentIdStepFillColor = this.f29079l.fromJson(jsonReader2);
                    break;
                case 11:
                    stepStyles$GovernmentIdStepBorderColor = this.f29080m.fromJson(jsonReader2);
                    break;
                case 12:
                    stepStyles$GovernmentIdStepBorderRadius = this.f29081n.fromJson(jsonReader2);
                    break;
                case 13:
                    stepStyles$GovernmentIdStepBorderWidth = this.f29082o.fromJson(jsonReader2);
                    break;
                case 14:
                    stepStyles$StepPaddingStyle = this.f29083p.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.e();
        return new StepStyles$GovernmentIdStepStyle(attributeStyles$HeaderButtonColorStyle, stepStyles$StepBackgroundColorStyle, stepStyles$StepBackgroundImageStyle, stepStyles$GovernmentIdStepTitleComponentStyle, stepStyles$GovernmentIdStepTextBasedComponentStyle, stepStyles$GovernmentIdStepPrimaryButtonComponentStyle, stepStyles$GovernmentIdStepSecondaryButtonComponentStyle, stepStyles$StepTextBasedComponentStyle, stepStyles$GovernmentIdStepRowHeight, stepStyles$GovernmentIdStepStrokeColor, stepStyles$GovernmentIdStepFillColor, stepStyles$GovernmentIdStepBorderColor, stepStyles$GovernmentIdStepBorderRadius, stepStyles$GovernmentIdStepBorderWidth, stepStyles$StepPaddingStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle) {
        j.g(qVar, "writer");
        if (stepStyles$GovernmentIdStepStyle != null) {
            qVar.c();
            qVar.u("textColor");
            this.f29069b.toJson(qVar, stepStyles$GovernmentIdStepStyle.F());
            qVar.u("backgroundColor");
            this.f29070c.toJson(qVar, stepStyles$GovernmentIdStepStyle.c());
            qVar.u("backgroundImage");
            this.f29071d.toJson(qVar, stepStyles$GovernmentIdStepStyle.d());
            qVar.u("titleStyle");
            this.f29072e.toJson(qVar, stepStyles$GovernmentIdStepStyle.P());
            qVar.u("textStyle");
            this.f29073f.toJson(qVar, stepStyles$GovernmentIdStepStyle.O());
            qVar.u("buttonPrimaryStyle");
            this.f29074g.toJson(qVar, stepStyles$GovernmentIdStepStyle.h());
            qVar.u("buttonSecondaryStyle");
            this.f29075h.toJson(qVar, stepStyles$GovernmentIdStepStyle.i());
            qVar.u("disclaimerStyle");
            this.f29076i.toJson(qVar, stepStyles$GovernmentIdStepStyle.m());
            qVar.u(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            this.f29077j.toJson(qVar, stepStyles$GovernmentIdStepStyle.H());
            qVar.u("strokeColor");
            this.f29078k.toJson(qVar, stepStyles$GovernmentIdStepStyle.L());
            qVar.u("fillColor");
            this.f29079l.toJson(qVar, stepStyles$GovernmentIdStepStyle.o());
            qVar.u("borderColor");
            this.f29080m.toJson(qVar, stepStyles$GovernmentIdStepStyle.e());
            qVar.u("borderRadius");
            this.f29081n.toJson(qVar, stepStyles$GovernmentIdStepStyle.f());
            qVar.u("borderWidth");
            this.f29082o.toJson(qVar, stepStyles$GovernmentIdStepStyle.g());
            qVar.u("padding");
            this.f29083p.toJson(qVar, stepStyles$GovernmentIdStepStyle.I());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.GovernmentIdStepStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
