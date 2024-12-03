package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StyleElements_SimpleElementColorJsonAdapter extends h<StyleElements.SimpleElementColor> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29212a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColorValue> f29213b;

    public StyleElements_SimpleElementColorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29212a = a10;
        h<StyleElements.SimpleElementColorValue> f10 = sVar.f(StyleElements.SimpleElementColorValue.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29213b = f10;
    }

    /* renamed from: a */
    public StyleElements.SimpleElementColor fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColorValue simpleElementColorValue = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29212a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColorValue = this.f29213b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StyleElements.SimpleElementColor(simpleElementColorValue);
    }

    /* renamed from: b */
    public void toJson(q qVar, StyleElements.SimpleElementColor simpleElementColor) {
        j.g(qVar, "writer");
        if (simpleElementColor != null) {
            qVar.c();
            qVar.u("base");
            this.f29213b.toJson(qVar, simpleElementColor.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StyleElements.SimpleElementColor");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
