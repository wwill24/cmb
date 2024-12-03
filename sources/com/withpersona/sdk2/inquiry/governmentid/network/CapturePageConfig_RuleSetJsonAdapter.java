package com.withpersona.sdk2.inquiry.governmentid.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CapturePageConfig_RuleSetJsonAdapter extends h<CapturePageConfig.RuleSet> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25830a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<CapturePageConfig.Rule>> f25831b;

    public CapturePageConfig_RuleSetJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("rules");
        j.f(a10, "of(\"rules\")");
        this.f25830a = a10;
        h<List<CapturePageConfig.Rule>> f10 = sVar.f(w.j(List.class, CapturePageConfig.Rule.class), n0.e(), "rules");
        j.f(f10, "moshi.adapter(Types.newP…va), emptySet(), \"rules\")");
        this.f25831b = f10;
    }

    /* renamed from: a */
    public CapturePageConfig.RuleSet fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25830a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                list = this.f25831b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new CapturePageConfig.RuleSet(list);
    }

    /* renamed from: b */
    public void toJson(q qVar, CapturePageConfig.RuleSet ruleSet) {
        j.g(qVar, "writer");
        if (ruleSet != null) {
            qVar.c();
            qVar.u("rules");
            this.f25831b.toJson(qVar, ruleSet.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CapturePageConfig.RuleSet");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
