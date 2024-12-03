package com.withpersona.sdk2.camera;

import androidx.camera.core.l0;
import androidx.camera.core.r;
import androidx.camera.view.PreviewView;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.functions.Function1;
import zf.a;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f14356a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f14357b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f14358c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ l0.a f14359d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f14360e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f14361f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CameraPreview f14362g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PreviewView f14363h;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ r f14364j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1 f14365k;

    public /* synthetic */ l(a aVar, int i10, boolean z10, l0.a aVar2, ExecutorService executorService, boolean z11, CameraPreview cameraPreview, PreviewView previewView, r rVar, Function1 function1) {
        this.f14356a = aVar;
        this.f14357b = i10;
        this.f14358c = z10;
        this.f14359d = aVar2;
        this.f14360e = executorService;
        this.f14361f = z11;
        this.f14362g = cameraPreview;
        this.f14363h = previewView;
        this.f14364j = rVar;
        this.f14365k = function1;
    }

    public final void run() {
        CameraPreview.h(this.f14356a, this.f14357b, this.f14358c, this.f14359d, this.f14360e, this.f14361f, this.f14362g, this.f14363h, this.f14364j, this.f14365k);
    }
}
