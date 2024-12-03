package com.google.android.gms.internal.mlkit_common;

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

public final class zzpv implements zzpf {
    private Provider zza;
    private final Provider zzb;
    private final zzph zzc;

    public zzpv(Context context, zzph zzph) {
        this.zzc = zzph;
        a aVar = a.f37964g;
        u.f(context);
        f g10 = u.c().g(aVar);
        if (aVar.a().contains(b.b(JsonPacketExtension.ELEMENT))) {
            this.zza = new Lazy(new zzps(g10));
        }
        this.zzb = new Lazy(new zzpt(g10));
    }

    static c zzb(zzph zzph, zzpe zzpe) {
        return c.e(zzpe.zze(zzph.zza(), false));
    }

    public final void zza(zzpe zzpe) {
        if (this.zzc.zza() == 0) {
            Provider provider = this.zza;
            if (provider != null) {
                ((e) provider.get()).b(zzb(this.zzc, zzpe));
                return;
            }
            return;
        }
        ((e) this.zzb.get()).b(zzb(this.zzc, zzpe));
    }
}
