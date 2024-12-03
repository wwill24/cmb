package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class UiComponent_InputCheckbox_AttributesJsonAdapter extends h<UiComponent.InputCheckbox.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28129a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28130b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Boolean> f28131c;

    /* renamed from: d  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28132d;

    public UiComponent_InputCheckbox_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(FormField.ELEMENT, "prefill", "label", "hidden", "disabled");
        j.f(a10, "of(\"field\", \"prefill\", \"…    \"hidden\", \"disabled\")");
        this.f28129a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), FormField.ELEMENT);
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"field\")");
        this.f28130b = f10;
        h<Boolean> f11 = sVar.f(Boolean.class, n0.e(), "prefill");
        j.f(f11, "moshi.adapter(Boolean::c…e, emptySet(), \"prefill\")");
        this.f28131c = f11;
        h<JsonLogicBoolean> f12 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f12, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28132d = f12;
    }

    /* renamed from: a */
    public UiComponent.InputCheckbox.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        Boolean bool = null;
        String str2 = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28129a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28130b.fromJson(jsonReader);
            } else if (L == 1) {
                bool = this.f28131c.fromJson(jsonReader);
            } else if (L == 2) {
                str2 = this.f28130b.fromJson(jsonReader);
            } else if (L == 3) {
                jsonLogicBoolean = this.f28132d.fromJson(jsonReader);
            } else if (L == 4) {
                jsonLogicBoolean2 = this.f28132d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiComponent.InputCheckbox.Attributes(str, bool, str2, jsonLogicBoolean, jsonLogicBoolean2);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputCheckbox.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u(FormField.ELEMENT);
            this.f28130b.toJson(qVar, attributes.g());
            qVar.u("prefill");
            this.f28131c.toJson(qVar, attributes.i());
            qVar.u("label");
            this.f28130b.toJson(qVar, attributes.h());
            qVar.u("hidden");
            this.f28132d.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28132d.toJson(qVar, attributes.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputCheckbox.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
