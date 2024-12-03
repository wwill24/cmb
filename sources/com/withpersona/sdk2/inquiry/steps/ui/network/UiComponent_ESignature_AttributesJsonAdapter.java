package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class UiComponent_ESignature_AttributesJsonAdapter extends h<UiComponent.ESignature.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28082a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28083b;

    /* renamed from: c  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28084c;

    public UiComponent_ESignature_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(FormField.ELEMENT, "label", "hidden", "disabled", "placeholder", "addSignatureText", "saveButtonText", "clearButtonText", "prefill");
        j.f(a10, "of(\"field\", \"label\", \"hi…arButtonText\", \"prefill\")");
        this.f28082a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), FormField.ELEMENT);
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"field\")");
        this.f28083b = f10;
        h<JsonLogicBoolean> f11 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f11, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28084c = f11;
    }

    /* renamed from: a */
    public UiComponent.ESignature.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28082a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f28083b.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.f28083b.fromJson(jsonReader);
                    break;
                case 2:
                    jsonLogicBoolean = this.f28084c.fromJson(jsonReader);
                    break;
                case 3:
                    jsonLogicBoolean2 = this.f28084c.fromJson(jsonReader);
                    break;
                case 4:
                    str3 = this.f28083b.fromJson(jsonReader);
                    break;
                case 5:
                    str4 = this.f28083b.fromJson(jsonReader);
                    break;
                case 6:
                    str5 = this.f28083b.fromJson(jsonReader);
                    break;
                case 7:
                    str6 = this.f28083b.fromJson(jsonReader);
                    break;
                case 8:
                    str7 = this.f28083b.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.ESignature.Attributes(str, str2, jsonLogicBoolean, jsonLogicBoolean2, str3, str4, str5, str6, str7);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.ESignature.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u(FormField.ELEMENT);
            this.f28083b.toJson(qVar, attributes.g());
            qVar.u("label");
            this.f28083b.toJson(qVar, attributes.h());
            qVar.u("hidden");
            this.f28084c.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28084c.toJson(qVar, attributes.d());
            qVar.u("placeholder");
            this.f28083b.toJson(qVar, attributes.i());
            qVar.u("addSignatureText");
            this.f28083b.toJson(qVar, attributes.e());
            qVar.u("saveButtonText");
            this.f28083b.toJson(qVar, attributes.k());
            qVar.u("clearButtonText");
            this.f28083b.toJson(qVar, attributes.f());
            qVar.u("prefill");
            this.f28083b.toJson(qVar, attributes.j());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.ESignature.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
