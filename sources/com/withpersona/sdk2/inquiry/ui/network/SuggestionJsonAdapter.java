package com.withpersona.sdk2.inquiry.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class SuggestionJsonAdapter extends h<Suggestion> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29444a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f29445b;

    public SuggestionJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("id", "address");
        j.f(a10, "of(\"id\", \"address\")");
        this.f29444a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "id");
        j.f(f10, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.f29445b = f10;
    }

    /* renamed from: a */
    public Suggestion fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29444a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f29445b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("id", "id", jsonReader);
                    j.f(x10, "unexpectedNull(\"id\", \"id\", reader)");
                    throw x10;
                }
            } else if (L == 1 && (str2 = this.f29445b.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("address", "address", jsonReader);
                j.f(x11, "unexpectedNull(\"address\"…       \"address\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("id", "id", jsonReader);
            j.f(o10, "missingProperty(\"id\", \"id\", reader)");
            throw o10;
        } else if (str2 != null) {
            return new Suggestion(str, str2);
        } else {
            JsonDataException o11 = c.o("address", "address", jsonReader);
            j.f(o11, "missingProperty(\"address\", \"address\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, Suggestion suggestion) {
        j.g(qVar, "writer");
        if (suggestion != null) {
            qVar.c();
            qVar.u("id");
            this.f29445b.toJson(qVar, suggestion.c());
            qVar.u("address");
            this.f29445b.toJson(qVar, suggestion.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Suggestion");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
