package com.withpersona.sdk2.camera;

import androidx.camera.core.l0;
import androidx.camera.core.r;
import androidx.camera.view.PreviewView;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreviewView f14349a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f14350b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l0.a f14351c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f14352d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CameraPreview f14353e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ r f14354f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1 f14355g;

    public /* synthetic */ k(PreviewView previewView, boolean z10, l0.a aVar, boolean z11, CameraPreview cameraPreview, r rVar, Function1 function1) {
        this.f14349a = previewView;
        this.f14350b = z10;
        this.f14351c = aVar;
        this.f14352d = z11;
        this.f14353e = cameraPreview;
        this.f14354f = rVar;
        this.f14355g = function1;
    }

    public final void run() {
        CameraPreview.g(this.f14349a, this.f14350b, this.f14351c, this.f14352d, this.f14353e, this.f14354f, this.f14355g);
    }
}
