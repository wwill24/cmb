package com.google.android.recaptcha.internal;

import java.util.HashMap;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import net.bytebuddy.jar.asm.Opcodes;

public final class zzbn {
    private final zzbm zza;
    private byte zzb = ((byte) j.m(new IntRange(1, Opcodes.LAND), Random.f32142a));
    private final HashMap zzc;

    public zzbn() {
        zzbm zzbm = new zzbm();
        this.zza = zzbm;
        HashMap hashMap = new HashMap();
        this.zzc = hashMap;
        zzbm.zze(Opcodes.LRETURN, hashMap);
    }

    public final byte zza() {
        return this.zzb;
    }

    public final zzbm zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zzd();
        this.zza.zze(Opcodes.LRETURN, this.zzc);
    }

    public final void zzd(byte b10) {
        this.zzb = b10;
    }

    public final void zze(int i10, Object obj) {
        this.zzc.put(1, obj);
    }
}
