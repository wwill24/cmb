package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.camera.CameraPreview;
import com.withpersona.sdk2.camera.SelfieDirectionFeed;
import fj.d;
import fk.a;

public final class n implements d<SelfieCameraScreenViewFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CameraPreview> f27407a;

    /* renamed from: b  reason: collision with root package name */
    private final a<SelfieDirectionFeed> f27408b;

    public n(a<CameraPreview> aVar, a<SelfieDirectionFeed> aVar2) {
        this.f27407a = aVar;
        this.f27408b = aVar2;
    }

    public static n a(a<CameraPreview> aVar, a<SelfieDirectionFeed> aVar2) {
        return new n(aVar, aVar2);
    }

    public static SelfieCameraScreenViewFactory c(CameraPreview cameraPreview, SelfieDirectionFeed selfieDirectionFeed) {
        return new SelfieCameraScreenViewFactory(cameraPreview, selfieDirectionFeed);
    }

    /* renamed from: b */
    public SelfieCameraScreenViewFactory get() {
        return c(this.f27407a.get(), this.f27408b.get());
    }
}
