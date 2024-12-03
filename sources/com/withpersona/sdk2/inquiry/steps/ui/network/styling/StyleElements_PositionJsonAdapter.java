package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StyleElements_PositionJsonAdapter extends h<StyleElements.Position> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29210a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.PositionType> f29211b;

    public StyleElements_PositionJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29210a = a10;
        h<StyleElements.PositionType> f10 = sVar.f(StyleElements.PositionType.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29211b = f10;
    }

    /* renamed from: a */
    public StyleElements.Position fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.PositionType positionType = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29210a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                positionType = this.f29211b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StyleElements.Position(positionType);
    }

    /* renamed from: b */
    public void toJson(q qVar, StyleElements.Position position) {
        j.g(qVar, "writer");
        if (position != null) {
            qVar.c();
            qVar.u("base");
            this.f29211b.toJson(qVar, position.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StyleElements.Position");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
