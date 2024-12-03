package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_DocumentStepFillColorJsonAdapter extends h<StepStyles$DocumentStepFillColor> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29024a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f29025b;

    public StepStyles_DocumentStepFillColorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "imagePreviewPlusIcon", "imagePreviewXIcon", "imagePreviewMainArea", "imagePreviewCropArea");
        j.f(a10, "of(\"base\", \"imagePreview…, \"imagePreviewCropArea\")");
        this.f29024a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29025b = f10;
    }

    /* renamed from: a */
    public StepStyles$DocumentStepFillColor fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor2 = null;
        StyleElements.SimpleElementColor simpleElementColor3 = null;
        StyleElements.SimpleElementColor simpleElementColor4 = null;
        StyleElements.SimpleElementColor simpleElementColor5 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29024a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f29025b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor2 = this.f29025b.fromJson(jsonReader);
            } else if (L == 2) {
                simpleElementColor3 = this.f29025b.fromJson(jsonReader);
            } else if (L == 3) {
                simpleElementColor4 = this.f29025b.fromJson(jsonReader);
            } else if (L == 4) {
                simpleElementColor5 = this.f29025b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$DocumentStepFillColor(simpleElementColor, simpleElementColor2, simpleElementColor3, simpleElementColor4, simpleElementColor5);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$DocumentStepFillColor stepStyles$DocumentStepFillColor) {
        j.g(qVar, "writer");
        if (stepStyles$DocumentStepFillColor != null) {
            qVar.c();
            qVar.u("base");
            this.f29025b.toJson(qVar, stepStyles$DocumentStepFillColor.a());
            qVar.u("imagePreviewPlusIcon");
            this.f29025b.toJson(qVar, stepStyles$DocumentStepFillColor.e());
            qVar.u("imagePreviewXIcon");
            this.f29025b.toJson(qVar, stepStyles$DocumentStepFillColor.f());
            qVar.u("imagePreviewMainArea");
            this.f29025b.toJson(qVar, stepStyles$DocumentStepFillColor.d());
            qVar.u("imagePreviewCropArea");
            this.f29025b.toJson(qVar, stepStyles$DocumentStepFillColor.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.DocumentStepFillColor");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
