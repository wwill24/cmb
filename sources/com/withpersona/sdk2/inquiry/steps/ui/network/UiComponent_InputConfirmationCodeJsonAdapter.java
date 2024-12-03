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

public final class UiComponent_InputConfirmationCodeJsonAdapter extends h<UiComponent.InputConfirmationCode> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28140a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28141b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.InputTextBasedComponentStyle> f28142c;

    /* renamed from: d  reason: collision with root package name */
    private final h<UiComponent.InputConfirmationCode.Attributes> f28143d;

    public UiComponent_InputConfirmationCodeJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "styles", "attributes");
        j.f(a10, "of(\"name\", \"styles\", \"attributes\")");
        this.f28140a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28141b = f10;
        h<UiComponent.InputTextBasedComponentStyle> f11 = sVar.f(UiComponent.InputTextBasedComponentStyle.class, n0.e(), "styles");
        j.f(f11, "moshi.adapter(UiComponen…va, emptySet(), \"styles\")");
        this.f28142c = f11;
        h<UiComponent.InputConfirmationCode.Attributes> f12 = sVar.f(UiComponent.InputConfirmationCode.Attributes.class, n0.e(), "attributes");
        j.f(f12, "moshi.adapter(UiComponen…et(),\n      \"attributes\")");
        this.f28143d = f12;
    }

    /* renamed from: a */
    public UiComponent.InputConfirmationCode fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        UiComponent.InputTextBasedComponentStyle inputTextBasedComponentStyle = null;
        UiComponent.InputConfirmationCode.Attributes attributes = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28140a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28141b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                inputTextBasedComponentStyle = this.f28142c.fromJson(jsonReader);
            } else if (L == 2) {
                attributes = this.f28143d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str != null) {
            return new UiComponent.InputConfirmationCode(str, inputTextBasedComponentStyle, attributes);
        }
        JsonDataException o10 = c.o("name", "name", jsonReader);
        j.f(o10, "missingProperty(\"name\", \"name\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputConfirmationCode inputConfirmationCode) {
        j.g(qVar, "writer");
        if (inputConfirmationCode != null) {
            qVar.c();
            qVar.u("name");
            this.f28141b.toJson(qVar, inputConfirmationCode.A());
            qVar.u("styles");
            this.f28142c.toJson(qVar, inputConfirmationCode.F());
            qVar.u("attributes");
            this.f28143d.toJson(qVar, inputConfirmationCode.z());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputConfirmationCode");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
