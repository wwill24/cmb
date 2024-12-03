package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ButtonBasedJustifyStyleJsonAdapter extends h<AttributeStyles$ButtonBasedJustifyStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28514a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.Position> f28515b;

    public AttributeStyles_ButtonBasedJustifyStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28514a = a10;
        h<StyleElements.Position> f10 = sVar.f(StyleElements.Position.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28515b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ButtonBasedJustifyStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.Position position = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28514a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                position = this.f28515b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ButtonBasedJustifyStyle(position);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ButtonBasedJustifyStyle attributeStyles$ButtonBasedJustifyStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ButtonBasedJustifyStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28515b.toJson(qVar, attributeStyles$ButtonBasedJustifyStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(61);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ButtonBasedJustifyStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
