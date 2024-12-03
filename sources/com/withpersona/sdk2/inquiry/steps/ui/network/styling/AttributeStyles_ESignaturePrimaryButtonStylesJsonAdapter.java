package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ESignaturePrimaryButtonStylesJsonAdapter extends h<AttributeStyles$ESignaturePrimaryButtonStyles> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28581a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$ESignaturePrimaryButtonStylesContainer> f28582b;

    public AttributeStyles_ESignaturePrimaryButtonStylesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("saveSignatureButton");
        j.f(a10, "of(\"saveSignatureButton\")");
        this.f28581a = a10;
        h<AttributeStyles$ESignaturePrimaryButtonStylesContainer> f10 = sVar.f(AttributeStyles$ESignaturePrimaryButtonStylesContainer.class, n0.e(), "saveSignatureButton");
        j.f(f10, "moshi.adapter(AttributeS…   \"saveSignatureButton\")");
        this.f28582b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ESignaturePrimaryButtonStyles fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$ESignaturePrimaryButtonStylesContainer attributeStyles$ESignaturePrimaryButtonStylesContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28581a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                attributeStyles$ESignaturePrimaryButtonStylesContainer = this.f28582b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ESignaturePrimaryButtonStyles(attributeStyles$ESignaturePrimaryButtonStylesContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ESignaturePrimaryButtonStyles attributeStyles$ESignaturePrimaryButtonStyles) {
        j.g(qVar, "writer");
        if (attributeStyles$ESignaturePrimaryButtonStyles != null) {
            qVar.c();
            qVar.u("saveSignatureButton");
            this.f28582b.toJson(qVar, attributeStyles$ESignaturePrimaryButtonStyles.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(67);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ESignaturePrimaryButtonStyles");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
