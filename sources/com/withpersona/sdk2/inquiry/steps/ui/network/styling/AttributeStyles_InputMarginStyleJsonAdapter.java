package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class AttributeStyles_InputMarginStyleJsonAdapter extends h<AttributeStyles$InputMarginStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28615a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurementSet> f28616b;

    public AttributeStyles_InputMarginStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", FormField.Option.ELEMENT);
        j.f(a10, "of(\"base\", \"option\")");
        this.f28615a = a10;
        h<StyleElements.DPMeasurementSet> f10 = sVar.f(StyleElements.DPMeasurementSet.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28616b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputMarginStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurementSet dPMeasurementSet = null;
        StyleElements.DPMeasurementSet dPMeasurementSet2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28615a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurementSet = this.f28616b.fromJson(jsonReader);
            } else if (L == 1) {
                dPMeasurementSet2 = this.f28616b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputMarginStyle(dPMeasurementSet, dPMeasurementSet2);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputMarginStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28616b.toJson(qVar, attributeStyles$InputMarginStyle.a());
            qVar.u(FormField.Option.ELEMENT);
            this.f28616b.toJson(qVar, attributeStyles$InputMarginStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputMarginStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
