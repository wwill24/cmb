package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzuu;
import com.google.android.gms.internal.gtm.zzuv;

public class zzuu<MessageType extends zzuv<MessageType, BuilderType>, BuilderType extends zzuu<MessageType, BuilderType>> extends zzut<MessageType, BuilderType> implements zzwl {
    protected zzuu(MessageType messagetype) {
        super(messagetype);
    }

    /* access modifiers changed from: protected */
    public final void zzF() {
        super.zzF();
        zzuv zzuv = (zzuv) this.zza;
        zzuv.zza = zzuv.zza.clone();
    }

    /* renamed from: zzH */
    public final MessageType zzD() {
        if (this.zzb) {
            return (zzuv) this.zza;
        }
        ((zzuv) this.zza).zza.zzg();
        return (zzuv) super.zzD();
    }
}
