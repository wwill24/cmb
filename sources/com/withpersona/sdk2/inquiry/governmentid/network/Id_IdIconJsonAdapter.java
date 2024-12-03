package com.withpersona.sdk2.inquiry.governmentid.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.governmentid.network.Id;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Id_IdIconJsonAdapter extends h<Id.IdIcon> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25872a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Id.IdLocalIcon> f25873b;

    public Id_IdIconJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("iconFallback");
        j.f(a10, "of(\"iconFallback\")");
        this.f25872a = a10;
        h<Id.IdLocalIcon> f10 = sVar.f(Id.IdLocalIcon.class, n0.e(), "iconFallback");
        j.f(f10, "moshi.adapter(Id.IdLocal…ptySet(), \"iconFallback\")");
        this.f25873b = f10;
    }

    /* renamed from: a */
    public Id.IdIcon fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        Id.IdLocalIcon idLocalIcon = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25872a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                idLocalIcon = this.f25873b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new Id.IdIcon(idLocalIcon);
    }

    /* renamed from: b */
    public void toJson(q qVar, Id.IdIcon idIcon) {
        j.g(qVar, "writer");
        if (idIcon != null) {
            qVar.c();
            qVar.u("iconFallback");
            this.f25873b.toJson(qVar, idIcon.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(31);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Id.IdIcon");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
