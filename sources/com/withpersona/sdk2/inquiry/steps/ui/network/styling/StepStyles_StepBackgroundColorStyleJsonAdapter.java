package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class StepStyles_StepBackgroundColorStyleJsonAdapter extends h<StepStyles$StepBackgroundColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29120a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f29121b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StyleElements.ComplexElementColor> f29122c;

    public StepStyles_StepBackgroundColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", FormField.Option.ELEMENT);
        j.f(a10, "of(\"base\", \"option\")");
        this.f29120a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29121b = f10;
        h<StyleElements.ComplexElementColor> f11 = sVar.f(StyleElements.ComplexElementColor.class, n0.e(), FormField.Option.ELEMENT);
        j.f(f11, "moshi.adapter(StyleEleme…va, emptySet(), \"option\")");
        this.f29122c = f11;
    }

    /* renamed from: a */
    public StepStyles$StepBackgroundColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.ComplexElementColor complexElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29120a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f29121b.fromJson(jsonReader);
            } else if (L == 1) {
                complexElementColor = this.f29122c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepBackgroundColorStyle(simpleElementColor, complexElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle) {
        j.g(qVar, "writer");
        if (stepStyles$StepBackgroundColorStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f29121b.toJson(qVar, stepStyles$StepBackgroundColorStyle.a());
            qVar.u(FormField.Option.ELEMENT);
            this.f29122c.toJson(qVar, stepStyles$StepBackgroundColorStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepBackgroundColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
