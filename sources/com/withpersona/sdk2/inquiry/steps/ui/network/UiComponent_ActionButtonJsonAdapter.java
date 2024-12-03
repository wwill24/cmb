package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonActionComponentStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_ActionButtonJsonAdapter extends h<UiComponent.ActionButton> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28005a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28006b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.Button.Attributes> f28007c;

    /* renamed from: d  reason: collision with root package name */
    private final h<ButtonActionComponentStyle> f28008d;

    public UiComponent_ActionButtonJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles");
        j.f(a10, "of(\"name\", \"attributes\", \"styles\")");
        this.f28005a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28006b = f10;
        h<UiComponent.Button.Attributes> f11 = sVar.f(UiComponent.Button.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28007c = f11;
        h<ButtonActionComponentStyle> f12 = sVar.f(ButtonActionComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(ButtonActi…va, emptySet(), \"styles\")");
        this.f28008d = f12;
    }

    /* renamed from: a */
    public UiComponent.ActionButton fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        UiComponent.Button.Attributes attributes = null;
        ButtonActionComponentStyle buttonActionComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28005a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28006b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28007c.fromJson(jsonReader);
            } else if (L == 2) {
                buttonActionComponentStyle = this.f28008d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str != null) {
            return new UiComponent.ActionButton(str, attributes, buttonActionComponentStyle);
        }
        JsonDataException o10 = c.o("name", "name", jsonReader);
        j.f(o10, "missingProperty(\"name\", \"name\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.ActionButton actionButton) {
        j.g(qVar, "writer");
        if (actionButton != null) {
            qVar.c();
            qVar.u("name");
            this.f28006b.toJson(qVar, actionButton.A());
            qVar.u("attributes");
            this.f28007c.toJson(qVar, actionButton.z());
            qVar.u("styles");
            this.f28008d.toJson(qVar, actionButton.D());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.ActionButton");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
