package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import cd.b;
import cd.c;
import cd.e;
import cd.f;
import com.google.android.datatransport.cct.a;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;
import ed.u;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;

public final class zzrt implements zzrb {
    private Provider zza;
    private final Provider zzb;
    private final zzrd zzc;

    public zzrt(Context context, zzrd zzrd) {
        this.zzc = zzrd;
        a aVar = a.f37964g;
        u.f(context);
        f g10 = u.c().g(aVar);
        if (aVar.a().contains(b.b(JsonPacketExtension.ELEMENT))) {
            this.zza = new Lazy(new zzrq(g10));
        }
        this.zzb = new Lazy(new zzrr(g10));
    }

    static c zzb(zzrd zzrd, zzra zzra) {
        int zza2 = zzrd.zza();
        if (zzra.zza() != 0) {
            return c.d(zzra.zze(zza2, false));
        }
        return c.e(zzra.zze(zza2, false));
    }

    public final void zza(zzra zzra) {
        if (this.zzc.zza() == 0) {
            Provider provider = this.zza;
            if (provider != null) {
                ((e) provider.get()).b(zzb(this.zzc, zzra));
                return;
            }
            return;
        }
        ((e) this.zzb.get()).b(zzb(this.zzc, zzra));
    }
}
