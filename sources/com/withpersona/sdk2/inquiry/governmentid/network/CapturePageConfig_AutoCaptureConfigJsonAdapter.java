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

public final class CapturePageConfig_AutoCaptureConfigJsonAdapter extends h<CapturePageConfig.AutoCaptureConfig> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25819a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<CapturePageConfig.RuleSet>> f25820b;

    public CapturePageConfig_AutoCaptureConfigJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("ruleSets");
        j.f(a10, "of(\"ruleSets\")");
        this.f25819a = a10;
        h<List<CapturePageConfig.RuleSet>> f10 = sVar.f(w.j(List.class, CapturePageConfig.RuleSet.class), n0.e(), "ruleSets");
        j.f(f10, "moshi.adapter(Types.newP…, emptySet(), \"ruleSets\")");
        this.f25820b = f10;
    }

    /* renamed from: a */
    public CapturePageConfig.AutoCaptureConfig fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25819a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                list = this.f25820b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new CapturePageConfig.AutoCaptureConfig(list);
    }

    /* renamed from: b */
    public void toJson(q qVar, CapturePageConfig.AutoCaptureConfig autoCaptureConfig) {
        j.g(qVar, "writer");
        if (autoCaptureConfig != null) {
            qVar.c();
            qVar.u("ruleSets");
            this.f25820b.toJson(qVar, autoCaptureConfig.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CapturePageConfig.AutoCaptureConfig");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
