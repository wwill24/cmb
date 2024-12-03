package com.google.android.gms.internal.mlkit_vision_face;

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

public final class zzok implements zzob {
    private Provider zza;
    private final Provider zzb;
    private final zznt zzc;

    public zzok(Context context, zznt zznt) {
        this.zzc = zznt;
        a aVar = a.f37964g;
        u.f(context);
        f g10 = u.c().g(aVar);
        if (aVar.a().contains(b.b(JsonPacketExtension.ELEMENT))) {
            this.zza = new Lazy(new zzoh(g10));
        }
        this.zzb = new Lazy(new zzoi(g10));
    }

    static c zzb(zznt zznt, zznr zznr) {
        int zza2 = zznt.zza();
        if (zznr.zza() != 0) {
            return c.d(zznr.zze(zza2, false));
        }
        return c.e(zznr.zze(zza2, false));
    }

    public final void zza(zznr zznr) {
        if (this.zzc.zza() == 0) {
            Provider provider = this.zza;
            if (provider != null) {
                ((e) provider.get()).b(zzb(this.zzc, zznr));
                return;
            }
            return;
        }
        ((e) this.zzb.get()).b(zzb(this.zzc, zznr));
    }
}
