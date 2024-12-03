package com.withpersona.sdk2.inquiry.governmentid.network;

import com.google.firebase.perf.util.Constants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CapturePageConfig_ManualCaptureConfigJsonAdapter extends h<CapturePageConfig.ManualCaptureConfig> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25821a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Boolean> f25822b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Long> f25823c;

    public CapturePageConfig_ManualCaptureConfigJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(Constants.ENABLE_DISABLE, "delayMs");
        j.f(a10, "of(\"isEnabled\", \"delayMs\")");
        this.f25821a = a10;
        h<Boolean> f10 = sVar.f(Boolean.class, n0.e(), Constants.ENABLE_DISABLE);
        j.f(f10, "moshi.adapter(Boolean::c… emptySet(), \"isEnabled\")");
        this.f25822b = f10;
        h<Long> f11 = sVar.f(Long.class, n0.e(), "delayMs");
        j.f(f11, "moshi.adapter(Long::clas…   emptySet(), \"delayMs\")");
        this.f25823c = f11;
    }

    /* renamed from: a */
    public CapturePageConfig.ManualCaptureConfig fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        Boolean bool = null;
        Long l10 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25821a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                bool = this.f25822b.fromJson(jsonReader);
            } else if (L == 1) {
                l10 = this.f25823c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new CapturePageConfig.ManualCaptureConfig(bool, l10);
    }

    /* renamed from: b */
    public void toJson(q qVar, CapturePageConfig.ManualCaptureConfig manualCaptureConfig) {
        j.g(qVar, "writer");
        if (manualCaptureConfig != null) {
            qVar.c();
            qVar.u(Constants.ENABLE_DISABLE);
            this.f25822b.toJson(qVar, manualCaptureConfig.c());
            qVar.u("delayMs");
            this.f25823c.toJson(qVar, manualCaptureConfig.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CapturePageConfig.ManualCaptureConfig");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
