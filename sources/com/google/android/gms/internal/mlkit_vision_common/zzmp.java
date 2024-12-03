package com.google.android.gms.internal.mlkit_vision_common;

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

public final class zzmp implements zzmc {
    private Provider zza;
    private final Provider zzb;
    private final zzme zzc;

    public zzmp(Context context, zzme zzme) {
        this.zzc = zzme;
        a aVar = a.f37964g;
        u.f(context);
        f g10 = u.c().g(aVar);
        if (aVar.a().contains(b.b(JsonPacketExtension.ELEMENT))) {
            this.zza = new Lazy(new zzmm(g10));
        }
        this.zzb = new Lazy(new zzmn(g10));
    }

    static c zzb(zzme zzme, zzmb zzmb) {
        return c.e(zzmb.zzd(zzme.zza(), false));
    }

    public final void zza(zzmb zzmb) {
        if (this.zzc.zza() == 0) {
            Provider provider = this.zza;
            if (provider != null) {
                ((e) provider.get()).b(zzb(this.zzc, zzmb));
                return;
            }
            return;
        }
        ((e) this.zzb.get()).b(zzb(this.zzc, zzmb));
    }
}
