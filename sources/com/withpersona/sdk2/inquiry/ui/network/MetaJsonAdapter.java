package com.withpersona.sdk2.inquiry.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class MetaJsonAdapter extends h<Meta> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29440a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<Suggestion>> f29441b;

    public MetaJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("predictions");
        j.f(a10, "of(\"predictions\")");
        this.f29440a = a10;
        h<List<Suggestion>> f10 = sVar.f(w.j(List.class, Suggestion.class), n0.e(), "predictions");
        j.f(f10, "moshi.adapter(Types.newP…mptySet(), \"predictions\")");
        this.f29441b = f10;
    }

    /* renamed from: a */
    public Meta fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29440a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (list = this.f29441b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("predictions", "predictions", jsonReader);
                j.f(x10, "unexpectedNull(\"predicti…\", \"predictions\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (list != null) {
            return new Meta(list);
        }
        JsonDataException o10 = c.o("predictions", "predictions", jsonReader);
        j.f(o10, "missingProperty(\"predict…ons\",\n            reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, Meta meta) {
        j.g(qVar, "writer");
        if (meta != null) {
            qVar.c();
            qVar.u("predictions");
            this.f29441b.toJson(qVar, meta.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Meta");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
