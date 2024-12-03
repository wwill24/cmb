package com.withpersona.sdk2.inquiry.governmentid.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CapturePageConfig_OverlayConfigJsonAdapter extends h<CapturePageConfig.OverlayConfig> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25824a;

    /* renamed from: b  reason: collision with root package name */
    private final h<UiComponent.RemoteImage> f25825b;

    /* renamed from: c  reason: collision with root package name */
    private final h<CapturePageConfig.OverlayLocalIcon> f25826c;

    public CapturePageConfig_OverlayConfigJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("overlay", "overlayFallback");
        j.f(a10, "of(\"overlay\", \"overlayFallback\")");
        this.f25824a = a10;
        h<UiComponent.RemoteImage> f10 = sVar.f(UiComponent.RemoteImage.class, n0.e(), "overlay");
        j.f(f10, "moshi.adapter(UiComponen…a, emptySet(), \"overlay\")");
        this.f25825b = f10;
        h<CapturePageConfig.OverlayLocalIcon> f11 = sVar.f(CapturePageConfig.OverlayLocalIcon.class, n0.e(), "overlayFallback");
        j.f(f11, "moshi.adapter(CapturePag…Set(), \"overlayFallback\")");
        this.f25826c = f11;
    }

    /* renamed from: a */
    public CapturePageConfig.OverlayConfig fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        UiComponent.RemoteImage remoteImage = null;
        CapturePageConfig.OverlayLocalIcon overlayLocalIcon = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25824a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                remoteImage = this.f25825b.fromJson(jsonReader);
            } else if (L == 1) {
                overlayLocalIcon = this.f25826c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new CapturePageConfig.OverlayConfig(remoteImage, overlayLocalIcon);
    }

    /* renamed from: b */
    public void toJson(q qVar, CapturePageConfig.OverlayConfig overlayConfig) {
        j.g(qVar, "writer");
        if (overlayConfig != null) {
            qVar.c();
            qVar.u("overlay");
            this.f25825b.toJson(qVar, overlayConfig.a());
            qVar.u("overlayFallback");
            this.f25826c.toJson(qVar, overlayConfig.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CapturePageConfig.OverlayConfig");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
