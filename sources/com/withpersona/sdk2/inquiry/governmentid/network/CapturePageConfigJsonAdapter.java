package com.withpersona.sdk2.inquiry.governmentid.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CapturePageConfigJsonAdapter extends h<CapturePageConfig> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25814a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f25815b;

    /* renamed from: c  reason: collision with root package name */
    private final h<CapturePageConfig.ManualCaptureConfig> f25816c;

    /* renamed from: d  reason: collision with root package name */
    private final h<CapturePageConfig.AutoCaptureConfig> f25817d;

    /* renamed from: e  reason: collision with root package name */
    private final h<CapturePageConfig.OverlayConfig> f25818e;

    public CapturePageConfigJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("side", "manualCaptureConfig", "autoCaptureConfig", "overlay");
        j.f(a10, "of(\"side\", \"manualCaptur…aptureConfig\", \"overlay\")");
        this.f25814a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "side");
        j.f(f10, "moshi.adapter(String::cl…      emptySet(), \"side\")");
        this.f25815b = f10;
        h<CapturePageConfig.ManualCaptureConfig> f11 = sVar.f(CapturePageConfig.ManualCaptureConfig.class, n0.e(), "manualCaptureConfig");
        j.f(f11, "moshi.adapter(CapturePag…   \"manualCaptureConfig\")");
        this.f25816c = f11;
        h<CapturePageConfig.AutoCaptureConfig> f12 = sVar.f(CapturePageConfig.AutoCaptureConfig.class, n0.e(), "autoCaptureConfig");
        j.f(f12, "moshi.adapter(CapturePag…     \"autoCaptureConfig\")");
        this.f25817d = f12;
        h<CapturePageConfig.OverlayConfig> f13 = sVar.f(CapturePageConfig.OverlayConfig.class, n0.e(), "overlay");
        j.f(f13, "moshi.adapter(CapturePag…a, emptySet(), \"overlay\")");
        this.f25818e = f13;
    }

    /* renamed from: a */
    public CapturePageConfig fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        CapturePageConfig.ManualCaptureConfig manualCaptureConfig = null;
        CapturePageConfig.AutoCaptureConfig autoCaptureConfig = null;
        CapturePageConfig.OverlayConfig overlayConfig = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25814a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f25815b.fromJson(jsonReader);
            } else if (L == 1) {
                manualCaptureConfig = this.f25816c.fromJson(jsonReader);
            } else if (L == 2) {
                autoCaptureConfig = this.f25817d.fromJson(jsonReader);
            } else if (L == 3) {
                overlayConfig = this.f25818e.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new CapturePageConfig(str, manualCaptureConfig, autoCaptureConfig, overlayConfig);
    }

    /* renamed from: b */
    public void toJson(q qVar, CapturePageConfig capturePageConfig) {
        j.g(qVar, "writer");
        if (capturePageConfig != null) {
            qVar.c();
            qVar.u("side");
            this.f25815b.toJson(qVar, capturePageConfig.e());
            qVar.u("manualCaptureConfig");
            this.f25816c.toJson(qVar, capturePageConfig.c());
            qVar.u("autoCaptureConfig");
            this.f25817d.toJson(qVar, capturePageConfig.a());
            qVar.u("overlay");
            this.f25818e.toJson(qVar, capturePageConfig.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(39);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CapturePageConfig");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
