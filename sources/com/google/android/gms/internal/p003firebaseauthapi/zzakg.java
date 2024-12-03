package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.internal.p003firebaseauthapi.zzakg;
import com.google.android.gms.internal.p003firebaseauthapi.zzakk;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakg  reason: invalid package */
public class zzakg<MessageType extends zzakk<MessageType, BuilderType>, BuilderType extends zzakg<MessageType, BuilderType>> extends zzaio<MessageType, BuilderType> {
    protected zzakk zza;
    private final zzakk zzb;

    protected zzakg(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzL()) {
            this.zza = messagetype.zzw();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzalx.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    public final /* synthetic */ zzalp zzM() {
        throw null;
    }

    /* renamed from: zzg */
    public final zzakg zzf() {
        zzakg zzakg = (zzakg) this.zzb.zzj(5, (Object) null, (Object) null);
        zzakg.zza = zzk();
        return zzakg;
    }

    public final zzakg zzh(zzakk zzakk) {
        if (!this.zzb.equals(zzakk)) {
            if (!this.zza.zzL()) {
                zzn();
            }
            zza(this.zza, zzakk);
        }
        return this;
    }

    public final MessageType zzi() {
        MessageType zzj = zzk();
        if (zzj.zzK()) {
            return zzj;
        }
        throw new zzamu(zzj);
    }

    /* renamed from: zzj */
    public MessageType zzk() {
        if (!this.zza.zzL()) {
            return this.zza;
        }
        this.zza.zzF();
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzm() {
        if (!this.zza.zzL()) {
            zzn();
        }
    }

    /* access modifiers changed from: protected */
    public void zzn() {
        zzakk zzw = this.zzb.zzw();
        zza(zzw, this.zza);
        this.zza = zzw;
    }
}
