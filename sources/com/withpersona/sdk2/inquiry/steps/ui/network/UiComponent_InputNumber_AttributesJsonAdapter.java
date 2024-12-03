package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class UiComponent_InputNumber_AttributesJsonAdapter extends h<UiComponent.InputNumber.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28194a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28195b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Number> f28196c;

    /* renamed from: d  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28197d;

    /* renamed from: e  reason: collision with root package name */
    private final h<Integer> f28198e;

    public UiComponent_InputNumber_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(FormField.ELEMENT, "prefill", "label", "placeholder", "hidden", "disabled", "precision");
        j.f(a10, "of(\"field\", \"prefill\", \"… \"disabled\", \"precision\")");
        this.f28194a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), FormField.ELEMENT);
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"field\")");
        this.f28195b = f10;
        h<Number> f11 = sVar.f(Number.class, n0.e(), "prefill");
        j.f(f11, "moshi.adapter(Number::cl…   emptySet(), \"prefill\")");
        this.f28196c = f11;
        h<JsonLogicBoolean> f12 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f12, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28197d = f12;
        h<Integer> f13 = sVar.f(Integer.class, n0.e(), "precision");
        j.f(f13, "moshi.adapter(Int::class… emptySet(), \"precision\")");
        this.f28198e = f13;
    }

    /* renamed from: a */
    public UiComponent.InputNumber.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        Number number = null;
        String str2 = null;
        String str3 = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        Integer num = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28194a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f28195b.fromJson(jsonReader);
                    break;
                case 1:
                    number = this.f28196c.fromJson(jsonReader);
                    break;
                case 2:
                    str2 = this.f28195b.fromJson(jsonReader);
                    break;
                case 3:
                    str3 = this.f28195b.fromJson(jsonReader);
                    break;
                case 4:
                    jsonLogicBoolean = this.f28197d.fromJson(jsonReader);
                    break;
                case 5:
                    jsonLogicBoolean2 = this.f28197d.fromJson(jsonReader);
                    break;
                case 6:
                    num = this.f28198e.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.InputNumber.Attributes(str, number, str2, str3, jsonLogicBoolean, jsonLogicBoolean2, num);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputNumber.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u(FormField.ELEMENT);
            this.f28195b.toJson(qVar, attributes.g());
            qVar.u("prefill");
            this.f28196c.toJson(qVar, attributes.k());
            qVar.u("label");
            this.f28195b.toJson(qVar, attributes.h());
            qVar.u("placeholder");
            this.f28195b.toJson(qVar, attributes.i());
            qVar.u("hidden");
            this.f28197d.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28197d.toJson(qVar, attributes.d());
            qVar.u("precision");
            this.f28198e.toJson(qVar, attributes.j());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(56);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputNumber.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
