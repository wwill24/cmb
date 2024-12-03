package com.withpersona.sdk2.camera;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.l;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.j;

public final class CameraView$viewFactory$2$1$onViewAttachedToWindow$1$1 implements DefaultLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ExecutorService f14117a;

    public void onDestroy(l lVar) {
        j.g(lVar, "owner");
        this.f14117a.shutdown();
    }
}
