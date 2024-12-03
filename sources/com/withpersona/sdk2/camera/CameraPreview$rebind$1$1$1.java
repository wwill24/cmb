package com.withpersona.sdk2.camera;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.l;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.j;

public final class CameraPreview$rebind$1$1$1 implements DefaultLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ExecutorService f14116a;

    CameraPreview$rebind$1$1$1(ExecutorService executorService) {
        this.f14116a = executorService;
    }

    public void onDestroy(l lVar) {
        j.g(lVar, "owner");
        this.f14116a.shutdown();
    }
}
