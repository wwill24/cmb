package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_HorizontalStackAxisStyleJsonAdapter extends h<AttributeStyles$HorizontalStackAxisStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28597a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.AxisContainer> f28598b;

    public AttributeStyles_HorizontalStackAxisStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28597a = a10;
        h<StyleElements.AxisContainer> f10 = sVar.f(StyleElements.AxisContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28598b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$HorizontalStackAxisStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.AxisContainer axisContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28597a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                axisContainer = this.f28598b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$HorizontalStackAxisStyle(axisContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$HorizontalStackAxisStyle attributeStyles$HorizontalStackAxisStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$HorizontalStackAxisStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28598b.toJson(qVar, attributeStyles$HorizontalStackAxisStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(62);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.HorizontalStackAxisStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
