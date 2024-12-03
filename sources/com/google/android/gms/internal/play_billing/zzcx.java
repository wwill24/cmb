package com.google.android.gms.internal.play_billing;

final class zzcx implements zzdq {
    private static final zzdd zza = new zzcv();
    private final zzdd zzb;

    public zzcx() {
        zzdd zzdd;
        zzdd[] zzddArr = new zzdd[2];
        zzddArr[0] = zzbw.zza();
        try {
            zzdd = (zzdd) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzdd = zza;
        }
        zzddArr[1] = zzdd;
        zzcw zzcw = new zzcw(zzddArr);
        byte[] bArr = zzcg.zzd;
        this.zzb = zzcw;
    }

    private static boolean zzb(zzdc zzdc) {
        return zzdc.zzc() == 1;
    }

    public final zzdp zza(Class cls) {
        Class<zzcb> cls2 = zzcb.class;
        zzdr.zzD(cls);
        zzdc zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzdj.zzc(zzdr.zzA(), zzbq.zzb(), zzb2.zza());
            }
            return zzdj.zzc(zzdr.zzy(), zzbq.zza(), zzb2.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzdi.zzl(cls, zzb2, zzdl.zzb(), zzct.zzd(), zzdr.zzA(), zzbq.zzb(), zzdb.zzb());
            }
            return zzdi.zzl(cls, zzb2, zzdl.zzb(), zzct.zzd(), zzdr.zzA(), (zzbo) null, zzdb.zzb());
        } else if (zzb(zzb2)) {
            return zzdi.zzl(cls, zzb2, zzdl.zza(), zzct.zzc(), zzdr.zzy(), zzbq.zza(), zzdb.zza());
        } else {
            return zzdi.zzl(cls, zzb2, zzdl.zza(), zzct.zzc(), zzdr.zzz(), (zzbo) null, zzdb.zza());
        }
    }
}
