package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text_common.zzog;
import com.google.android.gms.internal.mlkit_vision_text_common.zzor;
import com.google.mlkit.common.sdkinternal.e;
import com.google.mlkit.common.sdkinternal.i;
import dh.d;

public final class k extends e {

    /* renamed from: a  reason: collision with root package name */
    private final i f21596a;

    public k(i iVar) {
        this.f21596a = iVar;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        d dVar = (d) obj;
        zzog zzb = zzor.zzb(dVar.b());
        return new b(zzb, b.m(this.f21596a.b(), dVar, zzb), dVar);
    }
}
