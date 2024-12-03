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

public final class UiComponent_SpacerJsonAdapter extends h<UiComponent.Spacer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28316a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28317b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.Spacer.Attributes> f28318c;

    /* renamed from: d  reason: collision with root package name */
    private final h<UiComponent.SpacerComponentStyle> f28319d;

    public UiComponent_SpacerJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles");
        j.f(a10, "of(\"name\", \"attributes\", \"styles\")");
        this.f28316a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28317b = f10;
        h<UiComponent.Spacer.Attributes> f11 = sVar.f(UiComponent.Spacer.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28318c = f11;
        h<UiComponent.SpacerComponentStyle> f12 = sVar.f(UiComponent.SpacerComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(UiComponen…va, emptySet(), \"styles\")");
        this.f28319d = f12;
    }

    /* renamed from: a */
    public UiComponent.Spacer fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        UiComponent.Spacer.Attributes attributes = null;
        UiComponent.SpacerComponentStyle spacerComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28316a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28317b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28318c.fromJson(jsonReader);
            } else if (L == 2) {
                spacerComponentStyle = this.f28319d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str != null) {
            return new UiComponent.Spacer(str, attributes, spacerComponentStyle);
        }
        JsonDataException o10 = c.o("name", "name", jsonReader);
        j.f(o10, "missingProperty(\"name\", \"name\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.Spacer spacer) {
        j.g(qVar, "writer");
        if (spacer != null) {
            qVar.c();
            qVar.u("name");
            this.f28317b.toJson(qVar, spacer.A());
            qVar.u("attributes");
            this.f28318c.toJson(qVar, spacer.z());
            qVar.u("styles");
            this.f28319d.toJson(qVar, spacer.E());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.Spacer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
