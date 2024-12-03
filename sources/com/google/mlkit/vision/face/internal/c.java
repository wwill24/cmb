package com.google.mlkit.vision.face.internal;

import androidx.annotation.NonNull;
import bh.e;
import ch.a;
import com.google.android.gms.common.internal.p;
import com.google.mlkit.common.sdkinternal.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final d f21545a;

    /* renamed from: b  reason: collision with root package name */
    private final d f21546b;

    c(d dVar, d dVar2) {
        this.f21545a = dVar;
        this.f21546b = dVar2;
    }

    @NonNull
    public final FaceDetectorImpl a(@NonNull e eVar) {
        p.l(eVar, "You must provide a valid FaceDetectorOptions.");
        return new FaceDetectorImpl((g) this.f21545a.get(eVar), this.f21546b, eVar, (a) null);
    }
}
