package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ClickableStackPaddingStyleJsonAdapter extends h<AttributeStyles$ClickableStackPaddingStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28546a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurementSet> f28547b;

    public AttributeStyles_ClickableStackPaddingStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28546a = a10;
        h<StyleElements.DPMeasurementSet> f10 = sVar.f(StyleElements.DPMeasurementSet.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28547b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ClickableStackPaddingStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurementSet dPMeasurementSet = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28546a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurementSet = this.f28547b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ClickableStackPaddingStyle(dPMeasurementSet);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ClickableStackPaddingStyle attributeStyles$ClickableStackPaddingStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ClickableStackPaddingStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28547b.toJson(qVar, attributeStyles$ClickableStackPaddingStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ClickableStackPaddingStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
