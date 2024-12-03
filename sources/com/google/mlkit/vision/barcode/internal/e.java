package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import com.google.android.gms.common.d;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrw;
import com.google.mlkit.common.sdkinternal.i;
import vg.b;

public final class e extends com.google.mlkit.common.sdkinternal.e {

    /* renamed from: a  reason: collision with root package name */
    private final i f21486a;

    public e(i iVar) {
        this.f21486a = iVar;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        i iVar;
        b bVar = (b) obj;
        Context b10 = this.f21486a.b();
        zzrl zzb = zzrw.zzb(b.d());
        if (j.b(b10) || d.h().b(b10) >= 204500000) {
            iVar = new j(b10, bVar, zzb);
        } else {
            iVar = new k(b10, bVar, zzb);
        }
        return new h(this.f21486a, bVar, iVar, zzb);
    }
}
