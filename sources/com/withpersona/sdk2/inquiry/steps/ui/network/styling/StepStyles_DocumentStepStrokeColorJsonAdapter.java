package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_DocumentStepStrokeColorJsonAdapter extends h<StepStyles$DocumentStepStrokeColor> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29030a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f29031b;

    public StepStyles_DocumentStepStrokeColorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "imagePreviewPlusIcon", "imagePreviewXIcon");
        j.f(a10, "of(\"base\", \"imagePreview…     \"imagePreviewXIcon\")");
        this.f29030a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29031b = f10;
    }

    /* renamed from: a */
    public StepStyles$DocumentStepStrokeColor fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor2 = null;
        StyleElements.SimpleElementColor simpleElementColor3 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29030a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f29031b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor2 = this.f29031b.fromJson(jsonReader);
            } else if (L == 2) {
                simpleElementColor3 = this.f29031b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$DocumentStepStrokeColor(simpleElementColor, simpleElementColor2, simpleElementColor3);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$DocumentStepStrokeColor stepStyles$DocumentStepStrokeColor) {
        j.g(qVar, "writer");
        if (stepStyles$DocumentStepStrokeColor != null) {
            qVar.c();
            qVar.u("base");
            this.f29031b.toJson(qVar, stepStyles$DocumentStepStrokeColor.a());
            qVar.u("imagePreviewPlusIcon");
            this.f29031b.toJson(qVar, stepStyles$DocumentStepStrokeColor.c());
            qVar.u("imagePreviewXIcon");
            this.f29031b.toJson(qVar, stepStyles$DocumentStepStrokeColor.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(56);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.DocumentStepStrokeColor");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
