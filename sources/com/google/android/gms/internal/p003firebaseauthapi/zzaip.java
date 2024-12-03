package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.internal.p003firebaseauthapi.zzaio;
import com.google.android.gms.internal.p003firebaseauthapi.zzaip;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaip  reason: invalid package */
public abstract class zzaip<MessageType extends zzaip<MessageType, BuilderType>, BuilderType extends zzaio<MessageType, BuilderType>> implements zzalp {
    protected int zza = 0;

    /* access modifiers changed from: package-private */
    public int zzn(zzamb zzamb) {
        throw null;
    }

    public final zzajf zzo() {
        try {
            int zzs = zzs();
            zzajf zzajf = zzajf.zzb;
            byte[] bArr = new byte[zzs];
            zzajs zzC = zzajs.zzC(bArr, 0, zzs);
            zzJ(zzC);
            zzC.zzD();
            return new zzajc(bArr);
        } catch (IOException e10) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e10);
        }
    }

    public final void zzp(OutputStream outputStream) throws IOException {
        int zzs = zzs();
        int i10 = zzajs.zzf;
        if (zzs > 4096) {
            zzs = 4096;
        }
        zzajq zzajq = new zzajq(outputStream, zzs);
        zzJ(zzajq);
        zzajq.zzI();
    }

    public final byte[] zzq() {
        try {
            int zzs = zzs();
            byte[] bArr = new byte[zzs];
            zzajs zzC = zzajs.zzC(bArr, 0, zzs);
            zzJ(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e10) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e10);
        }
    }
}
