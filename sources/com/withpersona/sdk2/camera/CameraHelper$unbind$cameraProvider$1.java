package com.withpersona.sdk2.camera;

import androidx.camera.lifecycle.e;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import zf.a;

final class CameraHelper$unbind$cameraProvider$1 extends Lambda implements Function0<e> {
    final /* synthetic */ a<e> $future;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraHelper$unbind$cameraProvider$1(a<e> aVar) {
        super(0);
        this.$future = aVar;
    }

    /* renamed from: a */
    public final e invoke() {
        return this.$future.get();
    }
}
