package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_LocalImage_AttributesJsonAdapter extends h<UiComponent.LocalImage.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28277a;

    /* renamed from: b  reason: collision with root package name */
    private final h<UiComponent.LocalImage.Image> f28278b;

    public UiComponent_LocalImage_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("imageKey");
        j.f(a10, "of(\"imageKey\")");
        this.f28277a = a10;
        h<UiComponent.LocalImage.Image> f10 = sVar.f(UiComponent.LocalImage.Image.class, n0.e(), "imageKey");
        j.f(f10, "moshi.adapter(UiComponen…, emptySet(), \"imageKey\")");
        this.f28278b = f10;
    }

    /* renamed from: a */
    public UiComponent.LocalImage.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        UiComponent.LocalImage.Image image = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28277a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                image = this.f28278b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiComponent.LocalImage.Attributes(image);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.LocalImage.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("imageKey");
            this.f28278b.toJson(qVar, attributes.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.LocalImage.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
