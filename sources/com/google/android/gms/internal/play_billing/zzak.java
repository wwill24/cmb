package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzaj;
import com.google.android.gms.internal.play_billing.zzak;
import java.io.IOException;

public abstract class zzak<MessageType extends zzak<MessageType, BuilderType>, BuilderType extends zzaj<MessageType, BuilderType>> implements zzdf {
    protected int zza = 0;

    /* access modifiers changed from: package-private */
    public int zza(zzdp zzdp) {
        throw null;
    }

    public final zzba zzb() {
        try {
            int zzd = zzd();
            zzba zzba = zzba.zzb;
            byte[] bArr = new byte[zzd];
            zzbi zzz = zzbi.zzz(bArr, 0, zzd);
            zzq(zzz);
            zzz.zzA();
            return new zzax(bArr);
        } catch (IOException e10) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e10);
        }
    }
}
