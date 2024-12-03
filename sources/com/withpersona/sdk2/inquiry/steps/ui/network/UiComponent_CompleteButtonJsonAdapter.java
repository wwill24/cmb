package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCompleteComponentStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_CompleteButtonJsonAdapter extends h<UiComponent.CompleteButton> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28057a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28058b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.Button.Attributes> f28059c;

    /* renamed from: d  reason: collision with root package name */
    private final h<ButtonCompleteComponentStyle> f28060d;

    public UiComponent_CompleteButtonJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles");
        j.f(a10, "of(\"name\", \"attributes\", \"styles\")");
        this.f28057a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28058b = f10;
        h<UiComponent.Button.Attributes> f11 = sVar.f(UiComponent.Button.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28059c = f11;
        h<ButtonCompleteComponentStyle> f12 = sVar.f(ButtonCompleteComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(ButtonComp…va, emptySet(), \"styles\")");
        this.f28060d = f12;
    }

    /* renamed from: a */
    public UiComponent.CompleteButton fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        UiComponent.Button.Attributes attributes = null;
        ButtonCompleteComponentStyle buttonCompleteComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28057a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28058b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28059c.fromJson(jsonReader);
            } else if (L == 2) {
                buttonCompleteComponentStyle = this.f28060d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str != null) {
            return new UiComponent.CompleteButton(str, attributes, buttonCompleteComponentStyle);
        }
        JsonDataException o10 = c.o("name", "name", jsonReader);
        j.f(o10, "missingProperty(\"name\", \"name\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.CompleteButton completeButton) {
        j.g(qVar, "writer");
        if (completeButton != null) {
            qVar.c();
            qVar.u("name");
            this.f28058b.toJson(qVar, completeButton.A());
            qVar.u("attributes");
            this.f28059c.toJson(qVar, completeButton.z());
            qVar.u("styles");
            this.f28060d.toJson(qVar, completeButton.D());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.CompleteButton");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
