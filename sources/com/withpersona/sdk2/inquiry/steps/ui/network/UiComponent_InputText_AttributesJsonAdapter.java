package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class UiComponent_InputText_AttributesJsonAdapter extends h<UiComponent.InputText.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28267a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28268b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.InputText.InputType> f28269c;

    /* renamed from: d  reason: collision with root package name */
    private final h<UiComponent.InputText.AutofillHint> f28270d;

    /* renamed from: e  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28271e;

    public UiComponent_InputText_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(FormField.ELEMENT, "prefill", "label", "placeholder", "inputType", "autofillHint", "hidden", "disabled");
        j.f(a10, "of(\"field\", \"prefill\", \"…t\", \"hidden\", \"disabled\")");
        this.f28267a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), FormField.ELEMENT);
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"field\")");
        this.f28268b = f10;
        h<UiComponent.InputText.InputType> f11 = sVar.f(UiComponent.InputText.InputType.class, n0.e(), "inputType");
        j.f(f11, "moshi.adapter(UiComponen… emptySet(), \"inputType\")");
        this.f28269c = f11;
        h<UiComponent.InputText.AutofillHint> f12 = sVar.f(UiComponent.InputText.AutofillHint.class, n0.e(), "autofillHint");
        j.f(f12, "moshi.adapter(UiComponen…ptySet(), \"autofillHint\")");
        this.f28270d = f12;
        h<JsonLogicBoolean> f13 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f13, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28271e = f13;
    }

    /* renamed from: a */
    public UiComponent.InputText.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        UiComponent.InputText.InputType inputType = null;
        UiComponent.InputText.AutofillHint autofillHint = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28267a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f28268b.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.f28268b.fromJson(jsonReader);
                    break;
                case 2:
                    str3 = this.f28268b.fromJson(jsonReader);
                    break;
                case 3:
                    str4 = this.f28268b.fromJson(jsonReader);
                    break;
                case 4:
                    inputType = this.f28269c.fromJson(jsonReader);
                    if (inputType != null) {
                        break;
                    } else {
                        JsonDataException x10 = c.x("inputType", "inputType", jsonReader);
                        j.f(x10, "unexpectedNull(\"inputTyp…     \"inputType\", reader)");
                        throw x10;
                    }
                case 5:
                    autofillHint = this.f28270d.fromJson(jsonReader);
                    break;
                case 6:
                    jsonLogicBoolean = this.f28271e.fromJson(jsonReader);
                    break;
                case 7:
                    jsonLogicBoolean2 = this.f28271e.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        if (inputType != null) {
            return new UiComponent.InputText.Attributes(str, str2, str3, str4, inputType, autofillHint, jsonLogicBoolean, jsonLogicBoolean2);
        }
        JsonDataException o10 = c.o("inputType", "inputType", jsonReader);
        j.f(o10, "missingProperty(\"inputType\", \"inputType\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputText.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u(FormField.ELEMENT);
            this.f28268b.toJson(qVar, attributes.h());
            qVar.u("prefill");
            this.f28268b.toJson(qVar, attributes.l());
            qVar.u("label");
            this.f28268b.toJson(qVar, attributes.j());
            qVar.u("placeholder");
            this.f28268b.toJson(qVar, attributes.k());
            qVar.u("inputType");
            this.f28269c.toJson(qVar, attributes.i());
            qVar.u("autofillHint");
            this.f28270d.toJson(qVar, attributes.g());
            qVar.u("hidden");
            this.f28271e.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28271e.toJson(qVar, attributes.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputText.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
