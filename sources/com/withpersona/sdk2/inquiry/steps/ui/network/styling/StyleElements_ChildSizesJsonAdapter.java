package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StyleElements_ChildSizesJsonAdapter extends h<StyleElements.ChildSizes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29198a;

    /* renamed from: b  reason: collision with root package name */
    private final h<int[]> f29199b;

    public StyleElements_ChildSizesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29198a = a10;
        h<int[]> f10 = sVar.f(int[].class, n0.e(), "base");
        j.f(f10, "moshi.adapter(IntArray::…      emptySet(), \"base\")");
        this.f29199b = f10;
    }

    /* renamed from: a */
    public StyleElements.ChildSizes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        int[] iArr = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29198a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                iArr = this.f29199b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StyleElements.ChildSizes(iArr);
    }

    /* renamed from: b */
    public void toJson(q qVar, StyleElements.ChildSizes childSizes) {
        j.g(qVar, "writer");
        if (childSizes != null) {
            qVar.c();
            qVar.u("base");
            this.f29199b.toJson(qVar, childSizes.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StyleElements.ChildSizes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
