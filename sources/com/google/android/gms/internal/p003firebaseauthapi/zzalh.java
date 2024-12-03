package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalh  reason: invalid package */
final class zzalh implements zzamc {
    private static final zzaln zza = new zzalf();
    private final zzaln zzb;

    public zzalh() {
        zzaln zzaln;
        zzaln[] zzalnArr = new zzaln[2];
        zzalnArr[0] = zzakf.zza();
        try {
            zzaln = (zzaln) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzaln = zza;
        }
        zzalnArr[1] = zzaln;
        zzalg zzalg = new zzalg(zzalnArr);
        byte[] bArr = zzakq.zzd;
        this.zzb = zzalg;
    }

    private static boolean zzb(zzalm zzalm) {
        return zzalm.zzc() + -1 != 1;
    }

    public final zzamb zza(Class cls) {
        Class<zzakk> cls2 = zzakk.class;
        zzamd.zzr(cls);
        zzalm zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzalt.zzc(zzamd.zzn(), zzaka.zzb(), zzb2.zza());
            }
            return zzalt.zzc(zzamd.zzm(), zzaka.zza(), zzb2.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzals.zzl(cls, zzb2, zzalv.zzb(), zzald.zze(), zzamd.zzn(), zzaka.zzb(), zzall.zzb());
            }
            return zzals.zzl(cls, zzb2, zzalv.zzb(), zzald.zze(), zzamd.zzn(), (zzajy) null, zzall.zzb());
        } else if (zzb(zzb2)) {
            return zzals.zzl(cls, zzb2, zzalv.zza(), zzald.zzd(), zzamd.zzm(), zzaka.zza(), zzall.zza());
        } else {
            return zzals.zzl(cls, zzb2, zzalv.zza(), zzald.zzd(), zzamd.zzm(), (zzajy) null, zzall.zza());
        }
    }
}
