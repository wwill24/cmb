package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzbx;
import com.google.android.gms.internal.play_billing.zzcb;

public class zzbx<MessageType extends zzcb<MessageType, BuilderType>, BuilderType extends zzbx<MessageType, BuilderType>> extends zzaj<MessageType, BuilderType> {
    protected zzcb zza;
    private final zzcb zzb;

    protected zzbx(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzs()) {
            this.zza = messagetype.zzh();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    /* renamed from: zzb */
    public final zzbx zza() {
        zzbx zzbx = (zzbx) this.zzb.zzt(5, (Object) null, (Object) null);
        zzbx.zza = zze();
        return zzbx;
    }

    public final MessageType zzc() {
        MessageType zzd = zze();
        if (zzd.zzr()) {
            return zzd;
        }
        throw new zzef(zzd);
    }

    /* renamed from: zzd */
    public MessageType zze() {
        if (!this.zza.zzs()) {
            return this.zza;
        }
        this.zza.zzm();
        return this.zza;
    }

    public final /* bridge */ /* synthetic */ zzdf zzf() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void zzg() {
        if (!this.zza.zzs()) {
            zzh();
        }
    }

    /* access modifiers changed from: protected */
    public void zzh() {
        zzcb zzh = this.zzb.zzh();
        zzdn.zza().zzb(zzh.getClass()).zzg(zzh, this.zza);
        this.zza = zzh;
    }
}
