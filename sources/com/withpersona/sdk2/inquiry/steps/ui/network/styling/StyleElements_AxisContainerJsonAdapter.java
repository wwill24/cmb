package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StyleElements_AxisContainerJsonAdapter extends h<StyleElements.AxisContainer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29196a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.Axis> f29197b;

    public StyleElements_AxisContainerJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29196a = a10;
        h<StyleElements.Axis> f10 = sVar.f(StyleElements.Axis.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29197b = f10;
    }

    /* renamed from: a */
    public StyleElements.AxisContainer fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.Axis axis = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29196a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                axis = this.f29197b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StyleElements.AxisContainer(axis);
    }

    /* renamed from: b */
    public void toJson(q qVar, StyleElements.AxisContainer axisContainer) {
        j.g(qVar, "writer");
        if (axisContainer != null) {
            qVar.c();
            qVar.u("base");
            this.f29197b.toJson(qVar, axisContainer.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(49);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StyleElements.AxisContainer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
