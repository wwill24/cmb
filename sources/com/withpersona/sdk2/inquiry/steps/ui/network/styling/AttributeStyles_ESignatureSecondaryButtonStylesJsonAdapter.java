package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ESignatureSecondaryButtonStylesJsonAdapter extends h<AttributeStyles$ESignatureSecondaryButtonStyles> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28585a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$ESignatureSecondaryButtonStylesContainer> f28586b;

    public AttributeStyles_ESignatureSecondaryButtonStylesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("clearSignatureButton");
        j.f(a10, "of(\"clearSignatureButton\")");
        this.f28585a = a10;
        h<AttributeStyles$ESignatureSecondaryButtonStylesContainer> f10 = sVar.f(AttributeStyles$ESignatureSecondaryButtonStylesContainer.class, n0.e(), "clearSignatureButton");
        j.f(f10, "moshi.adapter(AttributeS…, \"clearSignatureButton\")");
        this.f28586b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ESignatureSecondaryButtonStyles fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$ESignatureSecondaryButtonStylesContainer attributeStyles$ESignatureSecondaryButtonStylesContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28585a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                attributeStyles$ESignatureSecondaryButtonStylesContainer = this.f28586b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ESignatureSecondaryButtonStyles(attributeStyles$ESignatureSecondaryButtonStylesContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ESignatureSecondaryButtonStyles attributeStyles$ESignatureSecondaryButtonStyles) {
        j.g(qVar, "writer");
        if (attributeStyles$ESignatureSecondaryButtonStyles != null) {
            qVar.c();
            qVar.u("clearSignatureButton");
            this.f28586b.toJson(qVar, attributeStyles$ESignatureSecondaryButtonStyles.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ESignatureSecondaryButtonStyles");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
