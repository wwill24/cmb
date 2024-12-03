package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.camera.CameraPreview;
import com.withpersona.sdk2.camera.GovernmentIdFeed;
import fj.d;
import fk.a;

public final class p implements d<GovernmentIdCameraScreenViewFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final a<GovernmentIdFeed> f26006a;

    /* renamed from: b  reason: collision with root package name */
    private final a<CameraPreview> f26007b;

    public p(a<GovernmentIdFeed> aVar, a<CameraPreview> aVar2) {
        this.f26006a = aVar;
        this.f26007b = aVar2;
    }

    public static p a(a<GovernmentIdFeed> aVar, a<CameraPreview> aVar2) {
        return new p(aVar, aVar2);
    }

    public static GovernmentIdCameraScreenViewFactory c(GovernmentIdFeed governmentIdFeed, CameraPreview cameraPreview) {
        return new GovernmentIdCameraScreenViewFactory(governmentIdFeed, cameraPreview);
    }

    /* renamed from: b */
    public GovernmentIdCameraScreenViewFactory get() {
        return c(this.f26006a.get(), this.f26007b.get());
    }
}
