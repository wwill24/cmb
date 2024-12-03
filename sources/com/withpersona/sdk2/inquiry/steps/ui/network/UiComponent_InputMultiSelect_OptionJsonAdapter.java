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

public final class UiComponent_InputMultiSelect_OptionJsonAdapter extends h<UiComponent.InputMultiSelect.Option> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28188a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28189b;

    public UiComponent_InputMultiSelect_OptionJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("text", "value");
        j.f(a10, "of(\"text\", \"value\")");
        this.f28188a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "text");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"text\")");
        this.f28189b = f10;
    }

    /* renamed from: a */
    public UiComponent.InputMultiSelect.Option fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28188a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28189b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("text", "text", jsonReader);
                    j.f(x10, "unexpectedNull(\"text\", \"text\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1 && (str2 = this.f28189b.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("value__", "value", jsonReader);
                j.f(x11, "unexpectedNull(\"value__\"…         \"value\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("text", "text", jsonReader);
            j.f(o10, "missingProperty(\"text\", \"text\", reader)");
            throw o10;
        } else if (str2 != null) {
            return new UiComponent.InputMultiSelect.Option(str, str2);
        } else {
            JsonDataException o11 = c.o("value__", "value", jsonReader);
            j.f(o11, "missingProperty(\"value__\", \"value\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputMultiSelect.Option option) {
        j.g(qVar, "writer");
        if (option != null) {
            qVar.c();
            qVar.u("text");
            this.f28189b.toJson(qVar, option.a());
            qVar.u("value");
            this.f28189b.toJson(qVar, option.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputMultiSelect.Option");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
