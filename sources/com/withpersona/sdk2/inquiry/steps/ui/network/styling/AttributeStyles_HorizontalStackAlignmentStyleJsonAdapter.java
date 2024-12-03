package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_HorizontalStackAlignmentStyleJsonAdapter extends h<AttributeStyles$HorizontalStackAlignmentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28595a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.Position> f28596b;

    public AttributeStyles_HorizontalStackAlignmentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28595a = a10;
        h<StyleElements.Position> f10 = sVar.f(StyleElements.Position.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28596b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$HorizontalStackAlignmentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.Position position = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28595a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                position = this.f28596b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$HorizontalStackAlignmentStyle(position);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$HorizontalStackAlignmentStyle attributeStyles$HorizontalStackAlignmentStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$HorizontalStackAlignmentStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28596b.toJson(qVar, attributeStyles$HorizontalStackAlignmentStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(67);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.HorizontalStackAlignmentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
