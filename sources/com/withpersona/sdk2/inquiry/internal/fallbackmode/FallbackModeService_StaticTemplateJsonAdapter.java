package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class FallbackModeService_StaticTemplateJsonAdapter extends h<FallbackModeService.StaticTemplate> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26351a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<NextStep>> f26352b;

    public FallbackModeService_StaticTemplateJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("steps");
        j.f(a10, "of(\"steps\")");
        this.f26351a = a10;
        h<List<NextStep>> f10 = sVar.f(w.j(List.class, NextStep.class), n0.e(), "steps");
        j.f(f10, "moshi.adapter(Types.newP…mptySet(),\n      \"steps\")");
        this.f26352b = f10;
    }

    /* renamed from: a */
    public FallbackModeService.StaticTemplate fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26351a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (list = this.f26352b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("steps", "steps", jsonReader);
                j.f(x10, "unexpectedNull(\"steps\",\n…         \"steps\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (list != null) {
            return new FallbackModeService.StaticTemplate(list);
        }
        JsonDataException o10 = c.o("steps", "steps", jsonReader);
        j.f(o10, "missingProperty(\"steps\", \"steps\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, FallbackModeService.StaticTemplate staticTemplate) {
        j.g(qVar, "writer");
        if (staticTemplate != null) {
            qVar.c();
            qVar.u("steps");
            this.f26352b.toJson(qVar, staticTemplate.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(56);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FallbackModeService.StaticTemplate");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
