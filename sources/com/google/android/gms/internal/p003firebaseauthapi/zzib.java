package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzib  reason: invalid package */
abstract class zzib {
    int[] zza;
    private final int zzb;

    public zzib(byte[] bArr, int i10) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zza = zzhx.zzd(bArr);
            this.zzb = i10;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public abstract int[] zzb(int[] iArr, int i10);

    /* access modifiers changed from: package-private */
    public final ByteBuffer zzc(byte[] bArr, int i10) {
        int[] zzb2 = zzb(zzhx.zzd(bArr), i10);
        int[] iArr = (int[]) zzb2.clone();
        zzhx.zzc(iArr);
        for (int i11 = 0; i11 < 16; i11++) {
            zzb2[i11] = zzb2[i11] + iArr[i11];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzb2, 0, 16);
        return order;
    }

    public final byte[] zzd(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length == zza()) {
            int remaining = byteBuffer.remaining();
            int i10 = remaining / 64;
            int i11 = 0;
            while (true) {
                int i12 = i10 + 1;
                if (i11 >= i12) {
                    return allocate.array();
                }
                ByteBuffer zzc = zzc(bArr, this.zzb + i11);
                if (i11 == i12 - 1) {
                    zzyf.zza(allocate, byteBuffer, zzc, remaining % 64);
                } else {
                    zzyf.zza(allocate, byteBuffer, zzc, 64);
                }
                i11++;
            }
        } else {
            int zza2 = zza();
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza2);
        }
    }
}
