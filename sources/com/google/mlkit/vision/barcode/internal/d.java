package com.google.mlkit.vision.barcode.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrw;
import vg.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final e f21484a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.mlkit.common.sdkinternal.d f21485b;

    d(e eVar, com.google.mlkit.common.sdkinternal.d dVar) {
        this.f21484a = eVar;
        this.f21485b = dVar;
    }

    public final BarcodeScannerImpl a(@NonNull b bVar) {
        return new BarcodeScannerImpl(bVar, (h) this.f21484a.get(bVar), this.f21485b.a(bVar.b()), zzrw.zzb(b.d()));
    }
}
