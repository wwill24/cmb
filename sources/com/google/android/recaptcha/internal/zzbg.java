package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.List;
import kotlin.jvm.internal.j;

public final class zzbg extends zzbd {
    private final zzbf zza;
    private final String zzb;

    public zzbg(zzbf zzbf, String str, Object obj) {
        super(obj);
        this.zza = zzbf;
        this.zzb = str;
    }

    public final boolean zza(Object obj, Method method, Object[] objArr) {
        List list;
        if (!j.b(method.getName(), this.zzb)) {
            return false;
        }
        zzbf zzbf = this.zza;
        if (objArr == null || (list = k.e(objArr)) == null) {
            list = q.j();
        }
        zzbf.zzb(list);
        return true;
    }
}
