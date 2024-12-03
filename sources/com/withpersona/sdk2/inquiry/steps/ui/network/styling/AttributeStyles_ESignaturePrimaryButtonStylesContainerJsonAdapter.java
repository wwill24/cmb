package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ESignaturePrimaryButtonStylesContainerJsonAdapter extends h<AttributeStyles$ESignaturePrimaryButtonStylesContainer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28579a;

    /* renamed from: b  reason: collision with root package name */
    private final h<ButtonSubmitComponentStyle> f28580b;

    public AttributeStyles_ESignaturePrimaryButtonStylesContainerJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28579a = a10;
        h<ButtonSubmitComponentStyle> f10 = sVar.f(ButtonSubmitComponentStyle.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(ButtonSubm…java, emptySet(), \"base\")");
        this.f28580b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ESignaturePrimaryButtonStylesContainer fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        ButtonSubmitComponentStyle buttonSubmitComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28579a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                buttonSubmitComponentStyle = this.f28580b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ESignaturePrimaryButtonStylesContainer(buttonSubmitComponentStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ESignaturePrimaryButtonStylesContainer attributeStyles$ESignaturePrimaryButtonStylesContainer) {
        j.g(qVar, "writer");
        if (attributeStyles$ESignaturePrimaryButtonStylesContainer != null) {
            qVar.c();
            qVar.u("base");
            this.f28580b.toJson(qVar, attributeStyles$ESignaturePrimaryButtonStylesContainer.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(76);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ESignaturePrimaryButtonStylesContainer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
