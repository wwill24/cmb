package com.google.android.gms.internal.p003firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjm  reason: invalid package */
final class zzjm extends zzog {
    zzjm(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zza(zzalp zzalp) throws GeneralSecurityException {
        zzus zzus = (zzus) zzalp;
        zzum zzb = zzus.zzb();
        zzuv zzf = zzb.zzf();
        int zzc = zzlj.zzc(zzf.zzd());
        byte[] zzq = zzus.zzg().zzq();
        byte[] zzq2 = zzus.zzh().zzq();
        ECParameterSpec zzi = zzym.zzi(zzc);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, zzq), new BigInteger(1, zzq2));
        zzmq.zzf(eCPoint, zzi.getCurve());
        ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(eCPoint, zzi);
        return new zzyj((ECPublicKey) ((KeyFactory) zzyv.zzg.zza("EC")).generatePublic(eCPublicKeySpec), zzf.zzf().zzq(), zzlj.zza(zzf.zze()), zzlj.zzd(zzb.zza()), new zzlk(zzb.zzb().zzd()));
    }
}
