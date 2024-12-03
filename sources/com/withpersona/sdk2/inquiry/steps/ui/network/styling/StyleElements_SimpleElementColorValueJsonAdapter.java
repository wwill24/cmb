package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StyleElements_SimpleElementColorValueJsonAdapter extends h<StyleElements.SimpleElementColorValue> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29214a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f29215b;

    public StyleElements_SimpleElementColorValueJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("value");
        j.f(a10, "of(\"value\")");
        this.f29214a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "value");
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"value\")");
        this.f29215b = f10;
    }

    /* renamed from: a */
    public StyleElements.SimpleElementColorValue fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29214a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f29215b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StyleElements.SimpleElementColorValue(str);
    }

    /* renamed from: b */
    public void toJson(q qVar, StyleElements.SimpleElementColorValue simpleElementColorValue) {
        j.g(qVar, "writer");
        if (simpleElementColorValue != null) {
            qVar.c();
            qVar.u("value");
            this.f29215b.toJson(qVar, simpleElementColorValue.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StyleElements.SimpleElementColorValue");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
