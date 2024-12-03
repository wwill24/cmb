package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StyleElements_Size_PercentSizeJsonAdapter extends h<StyleElements.Size.PercentSize> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29216a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Double> f29217b;

    public StyleElements_Size_PercentSizeJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("percent");
        j.f(a10, "of(\"percent\")");
        this.f29216a = a10;
        h<Double> f10 = sVar.f(Double.TYPE, n0.e(), "percent");
        j.f(f10, "moshi.adapter(Double::cl…tySet(),\n      \"percent\")");
        this.f29217b = f10;
    }

    /* renamed from: a */
    public StyleElements.Size.PercentSize fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        Double d10 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29216a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (d10 = this.f29217b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("percent", "percent", jsonReader);
                j.f(x10, "unexpectedNull(\"percent\"…       \"percent\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (d10 != null) {
            return new StyleElements.Size.PercentSize(d10.doubleValue());
        }
        JsonDataException o10 = c.o("percent", "percent", jsonReader);
        j.f(o10, "missingProperty(\"percent\", \"percent\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, StyleElements.Size.PercentSize percentSize) {
        j.g(qVar, "writer");
        if (percentSize != null) {
            qVar.c();
            qVar.u("percent");
            this.f29217b.toJson(qVar, Double.valueOf(percentSize.a()));
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StyleElements.Size.PercentSize");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
