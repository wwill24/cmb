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

public final class UiComponent_InputNumberJsonAdapter extends h<UiComponent.InputNumber> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28190a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28191b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.InputNumber.Attributes> f28192c;

    /* renamed from: d  reason: collision with root package name */
    private final h<UiComponent.InputTextBasedComponentStyle> f28193d;

    public UiComponent_InputNumberJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles");
        j.f(a10, "of(\"name\", \"attributes\", \"styles\")");
        this.f28190a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28191b = f10;
        h<UiComponent.InputNumber.Attributes> f11 = sVar.f(UiComponent.InputNumber.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28192c = f11;
        h<UiComponent.InputTextBasedComponentStyle> f12 = sVar.f(UiComponent.InputTextBasedComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(UiComponen…va, emptySet(), \"styles\")");
        this.f28193d = f12;
    }

    /* renamed from: a */
    public UiComponent.InputNumber fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        UiComponent.InputNumber.Attributes attributes = null;
        UiComponent.InputTextBasedComponentStyle inputTextBasedComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28190a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28191b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28192c.fromJson(jsonReader);
            } else if (L == 2) {
                inputTextBasedComponentStyle = this.f28193d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str != null) {
            return new UiComponent.InputNumber(str, attributes, inputTextBasedComponentStyle);
        }
        JsonDataException o10 = c.o("name", "name", jsonReader);
        j.f(o10, "missingProperty(\"name\", \"name\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputNumber inputNumber) {
        j.g(qVar, "writer");
        if (inputNumber != null) {
            qVar.c();
            qVar.u("name");
            this.f28191b.toJson(qVar, inputNumber.A());
            qVar.u("attributes");
            this.f28192c.toJson(qVar, inputNumber.z());
            qVar.u("styles");
            this.f28193d.toJson(qVar, inputNumber.F());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputNumber");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
