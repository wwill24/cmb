package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzuu;
import com.google.android.gms.internal.gtm.zzuv;

public abstract class zzuv<MessageType extends zzuv<MessageType, BuilderType>, BuilderType extends zzuu<MessageType, BuilderType>> extends zzuz<MessageType, BuilderType> implements zzwl {
    protected zzuo<zzuw> zza = zzuo.zzd();

    private final void zzc(zzux<MessageType, ?> zzux) {
        if (zzux.zza != ((zzuz) zzb(6, (Object) null, (Object) null))) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    /* access modifiers changed from: package-private */
    public final zzuo<zzuw> zzU() {
        if (this.zza.zzj()) {
            this.zza = this.zza.clone();
        }
        return this.zza;
    }

    public final <Type> Type zzV(zzuh<MessageType, Type> zzuh) {
        zzux zzux = (zzux) zzuh;
        zzc(zzux);
        Type zze = this.zza.zze(zzux.zzd);
        if (zze == null) {
            return zzux.zzb;
        }
        if (zzux.zzd.zzc.zza() != zzyf.ENUM) {
            return zze;
        }
        zzvc<?> zzvc = zzux.zzd.zza;
        return zzyl.zzc(((Integer) zze).intValue());
    }

    public final <Type> boolean zzW(zzuh<MessageType, Type> zzuh) {
        zzux zzux = (zzux) zzuh;
        zzc(zzux);
        zzuo<zzuw> zzuo = this.zza;
        if (zzuo.zza.get(zzux.zzd) != null) {
            return true;
        }
        return false;
    }
}
