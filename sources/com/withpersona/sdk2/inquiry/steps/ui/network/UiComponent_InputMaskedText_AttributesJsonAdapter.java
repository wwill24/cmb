package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class UiComponent_InputMaskedText_AttributesJsonAdapter extends h<UiComponent.InputMaskedText.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28174a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28175b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Boolean> f28176c;

    /* renamed from: d  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28177d;

    public UiComponent_InputMaskedText_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(FormField.ELEMENT, "prefill", "mask", "secure", "label", "placeholder", "hidden", "disabled");
        j.f(a10, "of(\"field\", \"prefill\", \"…r\", \"hidden\", \"disabled\")");
        this.f28174a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), FormField.ELEMENT);
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"field\")");
        this.f28175b = f10;
        h<Boolean> f11 = sVar.f(Boolean.class, n0.e(), "secure");
        j.f(f11, "moshi.adapter(Boolean::c…pe, emptySet(), \"secure\")");
        this.f28176c = f11;
        h<JsonLogicBoolean> f12 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f12, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28177d = f12;
    }

    /* renamed from: a */
    public UiComponent.InputMaskedText.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        Boolean bool = null;
        String str4 = null;
        String str5 = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28174a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f28175b.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.f28175b.fromJson(jsonReader);
                    break;
                case 2:
                    str3 = this.f28175b.fromJson(jsonReader);
                    break;
                case 3:
                    bool = this.f28176c.fromJson(jsonReader);
                    break;
                case 4:
                    str4 = this.f28175b.fromJson(jsonReader);
                    break;
                case 5:
                    str5 = this.f28175b.fromJson(jsonReader);
                    break;
                case 6:
                    jsonLogicBoolean = this.f28177d.fromJson(jsonReader);
                    break;
                case 7:
                    jsonLogicBoolean2 = this.f28177d.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.InputMaskedText.Attributes(str, str2, str3, bool, str4, str5, jsonLogicBoolean, jsonLogicBoolean2);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputMaskedText.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u(FormField.ELEMENT);
            this.f28175b.toJson(qVar, attributes.g());
            qVar.u("prefill");
            this.f28175b.toJson(qVar, attributes.k());
            qVar.u("mask");
            this.f28175b.toJson(qVar, attributes.i());
            qVar.u("secure");
            this.f28176c.toJson(qVar, attributes.l());
            qVar.u("label");
            this.f28175b.toJson(qVar, attributes.h());
            qVar.u("placeholder");
            this.f28175b.toJson(qVar, attributes.j());
            qVar.u("hidden");
            this.f28177d.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28177d.toJson(qVar, attributes.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputMaskedText.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
