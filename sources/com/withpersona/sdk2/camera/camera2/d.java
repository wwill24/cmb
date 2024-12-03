package com.withpersona.sdk2.camera.camera2;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14328a;

    /* renamed from: b  reason: collision with root package name */
    private final f f14329b;

    /* renamed from: c  reason: collision with root package name */
    private final Camera2PreviewView f14330c;

    /* renamed from: d  reason: collision with root package name */
    private final a f14331d;

    public d(Context context, f fVar, Camera2PreviewView camera2PreviewView, a aVar) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(fVar, "cameraChoice");
        j.g(camera2PreviewView, "previewView");
        j.g(aVar, "analyzer");
        this.f14328a = context;
        this.f14329b = fVar;
        this.f14330c = camera2PreviewView;
        this.f14331d = aVar;
    }

    public final Camera2Manager a() {
        return new Camera2Manager(this.f14328a, this.f14329b, this.f14330c, this.f14331d);
    }
}
