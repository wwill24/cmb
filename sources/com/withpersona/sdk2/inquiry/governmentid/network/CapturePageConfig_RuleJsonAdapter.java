package com.withpersona.sdk2.inquiry.governmentid.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CapturePageConfig_RuleJsonAdapter extends h<CapturePageConfig.Rule> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25827a;

    /* renamed from: b  reason: collision with root package name */
    private final h<CapturePageConfig.RuleType> f25828b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Boolean> f25829c;

    public CapturePageConfig_RuleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("type", "isRequired");
        j.f(a10, "of(\"type\", \"isRequired\")");
        this.f25827a = a10;
        h<CapturePageConfig.RuleType> f10 = sVar.f(CapturePageConfig.RuleType.class, n0.e(), "type");
        j.f(f10, "moshi.adapter(CapturePag…java, emptySet(), \"type\")");
        this.f25828b = f10;
        h<Boolean> f11 = sVar.f(Boolean.class, n0.e(), "isRequired");
        j.f(f11, "moshi.adapter(Boolean::c…emptySet(), \"isRequired\")");
        this.f25829c = f11;
    }

    /* renamed from: a */
    public CapturePageConfig.Rule fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        CapturePageConfig.RuleType ruleType = null;
        Boolean bool = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25827a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                ruleType = this.f25828b.fromJson(jsonReader);
            } else if (L == 1) {
                bool = this.f25829c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new CapturePageConfig.Rule(ruleType, bool);
    }

    /* renamed from: b */
    public void toJson(q qVar, CapturePageConfig.Rule rule) {
        j.g(qVar, "writer");
        if (rule != null) {
            qVar.c();
            qVar.u("type");
            this.f25828b.toJson(qVar, rule.a());
            qVar.u("isRequired");
            this.f25829c.toJson(qVar, rule.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CapturePageConfig.Rule");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
