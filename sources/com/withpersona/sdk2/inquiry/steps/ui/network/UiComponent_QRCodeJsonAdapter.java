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

public final class UiComponent_QRCodeJsonAdapter extends h<UiComponent.QRCode> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28291a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28292b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.QRCode.Attributes> f28293c;

    /* renamed from: d  reason: collision with root package name */
    private final h<UiComponent.QRCodeComponentStyle> f28294d;

    public UiComponent_QRCodeJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles");
        j.f(a10, "of(\"name\", \"attributes\", \"styles\")");
        this.f28291a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28292b = f10;
        h<UiComponent.QRCode.Attributes> f11 = sVar.f(UiComponent.QRCode.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28293c = f11;
        h<UiComponent.QRCodeComponentStyle> f12 = sVar.f(UiComponent.QRCodeComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(UiComponen…va, emptySet(), \"styles\")");
        this.f28294d = f12;
    }

    /* renamed from: a */
    public UiComponent.QRCode fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        UiComponent.QRCode.Attributes attributes = null;
        UiComponent.QRCodeComponentStyle qRCodeComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28291a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28292b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28293c.fromJson(jsonReader);
            } else if (L == 2) {
                qRCodeComponentStyle = this.f28294d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str != null) {
            return new UiComponent.QRCode(str, attributes, qRCodeComponentStyle);
        }
        JsonDataException o10 = c.o("name", "name", jsonReader);
        j.f(o10, "missingProperty(\"name\", \"name\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.QRCode qRCode) {
        j.g(qVar, "writer");
        if (qRCode != null) {
            qVar.c();
            qVar.u("name");
            this.f28292b.toJson(qVar, qRCode.A());
            qVar.u("attributes");
            this.f28293c.toJson(qVar, qRCode.z());
            qVar.u("styles");
            this.f28294d.toJson(qVar, qRCode.H());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.QRCode");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
