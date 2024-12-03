package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_HorizontalStackPaddingStyleJsonAdapter extends h<AttributeStyles$HorizontalStackPaddingStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28613a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurementSet> f28614b;

    public AttributeStyles_HorizontalStackPaddingStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28613a = a10;
        h<StyleElements.DPMeasurementSet> f10 = sVar.f(StyleElements.DPMeasurementSet.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28614b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$HorizontalStackPaddingStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurementSet dPMeasurementSet = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28613a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurementSet = this.f28614b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$HorizontalStackPaddingStyle(dPMeasurementSet);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$HorizontalStackPaddingStyle attributeStyles$HorizontalStackPaddingStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$HorizontalStackPaddingStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28614b.toJson(qVar, attributeStyles$HorizontalStackPaddingStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(65);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.HorizontalStackPaddingStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
