package com.google.android.gms.internal.mlkit_vision_text_common;

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

public final class zzoo implements zzof {
    private Provider zza;
    private final Provider zzb;
    private final zznx zzc;

    public zzoo(Context context, zznx zznx) {
        this.zzc = zznx;
        a aVar = a.f37964g;
        u.f(context);
        f g10 = u.c().g(aVar);
        if (aVar.a().contains(b.b(JsonPacketExtension.ELEMENT))) {
            this.zza = new Lazy(new zzol(g10));
        }
        this.zzb = new Lazy(new zzom(g10));
    }

    static c zzb(zznx zznx, zznv zznv) {
        int zza2 = zznx.zza();
        if (zznv.zza() != 0) {
            return c.d(zznv.zze(zza2, false));
        }
        return c.e(zznv.zze(zza2, false));
    }

    public final void zza(zznv zznv) {
        if (this.zzc.zza() == 0) {
            Provider provider = this.zza;
            if (provider != null) {
                ((e) provider.get()).b(zzb(this.zzc, zznv));
                return;
            }
            return;
        }
        ((e) this.zzb.get()).b(zzb(this.zzc, zznv));
    }
}
