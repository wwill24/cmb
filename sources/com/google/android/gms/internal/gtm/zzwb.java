package com.google.android.gms.internal.gtm;

final class zzwb implements zzwi {
    private final zzwi[] zza;

    zzwb(zzwi... zzwiArr) {
        this.zza = zzwiArr;
    }

    public final zzwh zzb(Class<?> cls) {
        String str;
        zzwi[] zzwiArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            zzwi zzwi = zzwiArr[i10];
            if (zzwi.zzc(cls)) {
                return zzwi.zzb(cls);
            }
        }
        String name = cls.getName();
        if (name.length() != 0) {
            str = "No factory is available for message type: ".concat(name);
        } else {
            str = new String("No factory is available for message type: ");
        }
        throw new UnsupportedOperationException(str);
    }

    public final boolean zzc(Class<?> cls) {
        zzwi[] zzwiArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            if (zzwiArr[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
