package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face.zzoc;
import com.google.android.gms.internal.mlkit_vision_face.zzon;
import com.google.mlkit.common.sdkinternal.e;
import com.google.mlkit.common.sdkinternal.i;

public final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private final i f21547a;

    public d(i iVar) {
        this.f21547a = iVar;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        b bVar;
        bh.e eVar = (bh.e) obj;
        Context b10 = this.f21547a.b();
        zzoc zzb = zzon.zzb(h.b());
        if (a.b(b10) || com.google.android.gms.common.d.h().b(b10) >= 204500000) {
            bVar = new a(b10, eVar, zzb);
        } else {
            bVar = new j(b10, eVar, zzb);
        }
        return new g(zzon.zzb(h.b()), eVar, bVar);
    }
}
