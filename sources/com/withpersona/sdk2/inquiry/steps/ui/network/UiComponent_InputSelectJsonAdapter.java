package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_InputSelectJsonAdapter extends h<UiComponent.InputSelect> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28239a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28240b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.InputSelect.Attributes> f28241c;

    /* renamed from: d  reason: collision with root package name */
    private final h<UiComponent.InputSelectComponentStyle> f28242d;

    /* renamed from: e  reason: collision with root package name */
    private final h<List<String>> f28243e;

    public UiComponent_InputSelectJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles", "selectedTexts");
        j.f(a10, "of(\"name\", \"attributes\",…\",\n      \"selectedTexts\")");
        this.f28239a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28240b = f10;
        h<UiComponent.InputSelect.Attributes> f11 = sVar.f(UiComponent.InputSelect.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28241c = f11;
        h<UiComponent.InputSelectComponentStyle> f12 = sVar.f(UiComponent.InputSelectComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(UiComponen…va, emptySet(), \"styles\")");
        this.f28242d = f12;
        h<List<String>> f13 = sVar.f(w.j(List.class, cls), n0.e(), "selectedTexts");
        j.f(f13, "moshi.adapter(Types.newP…),\n      \"selectedTexts\")");
        this.f28243e = f13;
    }

    /* renamed from: a */
    public UiComponent.InputSelect fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        UiComponent.InputSelect.Attributes attributes = null;
        UiComponent.InputSelectComponentStyle inputSelectComponentStyle = null;
        List<String> list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28239a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28240b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28241c.fromJson(jsonReader);
            } else if (L == 2) {
                inputSelectComponentStyle = this.f28242d.fromJson(jsonReader);
            } else if (L == 3 && (list = this.f28243e.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("selectedTexts", "selectedTexts", jsonReader);
                j.f(x11, "unexpectedNull(\"selected… \"selectedTexts\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str != null) {
            UiComponent.InputSelect inputSelect = new UiComponent.InputSelect(str, attributes, inputSelectComponentStyle);
            if (list == null) {
                list = inputSelect.t();
            }
            inputSelect.F(list);
            return inputSelect;
        }
        JsonDataException o10 = c.o("name", "name", jsonReader);
        j.f(o10, "missingProperty(\"name\", \"name\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputSelect inputSelect) {
        j.g(qVar, "writer");
        if (inputSelect != null) {
            qVar.c();
            qVar.u("name");
            this.f28240b.toJson(qVar, inputSelect.A());
            qVar.u("attributes");
            this.f28241c.toJson(qVar, inputSelect.z());
            qVar.u("styles");
            this.f28242d.toJson(qVar, inputSelect.b());
            qVar.u("selectedTexts");
            this.f28243e.toJson(qVar, inputSelect.t());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputSelect");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
