package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class UiComponent_InputPhoneNumber_AttributesJsonAdapter extends h<UiComponent.InputPhoneNumber.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28203a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28204b;

    /* renamed from: c  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28205c;

    public UiComponent_InputPhoneNumber_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(FormField.ELEMENT, "prefill", "label", "placeholder", "hidden", "disabled");
        j.f(a10, "of(\"field\", \"prefill\", \"…r\", \"hidden\", \"disabled\")");
        this.f28203a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), FormField.ELEMENT);
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"field\")");
        this.f28204b = f10;
        h<JsonLogicBoolean> f11 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f11, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28205c = f11;
    }

    /* renamed from: a */
    public UiComponent.InputPhoneNumber.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28203a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f28204b.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.f28204b.fromJson(jsonReader);
                    break;
                case 2:
                    str3 = this.f28204b.fromJson(jsonReader);
                    break;
                case 3:
                    str4 = this.f28204b.fromJson(jsonReader);
                    break;
                case 4:
                    jsonLogicBoolean = this.f28205c.fromJson(jsonReader);
                    break;
                case 5:
                    jsonLogicBoolean2 = this.f28205c.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.InputPhoneNumber.Attributes(str, str2, str3, str4, jsonLogicBoolean, jsonLogicBoolean2);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputPhoneNumber.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u(FormField.ELEMENT);
            this.f28204b.toJson(qVar, attributes.g());
            qVar.u("prefill");
            this.f28204b.toJson(qVar, attributes.j());
            qVar.u("label");
            this.f28204b.toJson(qVar, attributes.h());
            qVar.u("placeholder");
            this.f28204b.toJson(qVar, attributes.i());
            qVar.u("hidden");
            this.f28205c.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28205c.toJson(qVar, attributes.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(61);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputPhoneNumber.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
