package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_CombinedStepImagePreview_AttributesJsonAdapter extends h<UiComponent.CombinedStepImagePreview.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28051a;

    public UiComponent_CombinedStepImagePreview_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(new String[0]);
        j.f(a10, "of()");
        this.f28051a = a10;
    }

    /* renamed from: a */
    public UiComponent.CombinedStepImagePreview.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        while (jsonReader.g()) {
            if (jsonReader.L(this.f28051a) == -1) {
                jsonReader.S();
                jsonReader.Y();
            }
        }
        jsonReader.e();
        return new UiComponent.CombinedStepImagePreview.Attributes();
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.CombinedStepImagePreview.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.CombinedStepImagePreview.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
