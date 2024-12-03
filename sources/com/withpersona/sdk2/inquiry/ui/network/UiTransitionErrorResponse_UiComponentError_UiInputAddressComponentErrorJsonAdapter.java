package com.withpersona.sdk2.inquiry.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse;
import java.util.Map;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiTransitionErrorResponse_UiComponentError_UiInputAddressComponentErrorJsonAdapter extends h<UiTransitionErrorResponse.UiComponentError.UiInputAddressComponentError> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29494a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f29495b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Map<String, String>> f29496c;

    public UiTransitionErrorResponse_UiComponentError_UiInputAddressComponentErrorJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "type", "message");
        j.f(a10, "of(\"name\", \"type\", \"message\")");
        this.f29494a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f29495b = f10;
        h<Map<String, String>> f11 = sVar.f(w.j(Map.class, cls, cls), n0.e(), "message");
        j.f(f11, "moshi.adapter(Types.newP…), emptySet(), \"message\")");
        this.f29496c = f11;
    }

    /* renamed from: a */
    public UiTransitionErrorResponse.UiComponentError.UiInputAddressComponentError fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        Map map = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29494a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f29495b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                str2 = this.f29495b.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException x11 = c.x("type", "type", jsonReader);
                    j.f(x11, "unexpectedNull(\"type\", \"type\",\n            reader)");
                    throw x11;
                }
            } else if (L == 2 && (map = this.f29496c.fromJson(jsonReader)) == null) {
                JsonDataException x12 = c.x("message", "message", jsonReader);
                j.f(x12, "unexpectedNull(\"message\", \"message\", reader)");
                throw x12;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("name", "name", jsonReader);
            j.f(o10, "missingProperty(\"name\", \"name\", reader)");
            throw o10;
        } else if (str2 == null) {
            JsonDataException o11 = c.o("type", "type", jsonReader);
            j.f(o11, "missingProperty(\"type\", \"type\", reader)");
            throw o11;
        } else if (map != null) {
            return new UiTransitionErrorResponse.UiComponentError.UiInputAddressComponentError(str, str2, map);
        } else {
            JsonDataException o12 = c.o("message", "message", jsonReader);
            j.f(o12, "missingProperty(\"message\", \"message\", reader)");
            throw o12;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, UiTransitionErrorResponse.UiComponentError.UiInputAddressComponentError uiInputAddressComponentError) {
        j.g(qVar, "writer");
        if (uiInputAddressComponentError != null) {
            qVar.c();
            qVar.u("name");
            this.f29495b.toJson(qVar, uiInputAddressComponentError.a());
            qVar.u("type");
            this.f29495b.toJson(qVar, uiInputAddressComponentError.d());
            qVar.u("message");
            this.f29496c.toJson(qVar, uiInputAddressComponentError.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(93);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiTransitionErrorResponse.UiComponentError.UiInputAddressComponentError");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
