package com.withpersona.sdk2.camera.camera2;

import android.media.ImageReader;

public final /* synthetic */ class b implements ImageReader.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2Manager f14326a;

    public /* synthetic */ b(Camera2Manager camera2Manager) {
        this.f14326a = camera2Manager;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        Camera2Manager.F(this.f14326a, imageReader);
    }
}
