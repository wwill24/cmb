package com.google.android.recaptcha.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.x0;

public final class zzp {
    public static final zzp zza = new zzp();
    private static final k0 zzb = l0.b();
    private static final k0 zzc;
    private static final k0 zzd = l0.a(x0.b());

    static {
        k0 a10 = l0.a(s2.d("reCaptcha"));
        s1 unused = j.d(a10, (CoroutineContext) null, (CoroutineStart) null, new zzo((c) null), 3, (Object) null);
        zzc = a10;
    }

    private zzp() {
    }

    public static final k0 zza() {
        return zzd;
    }

    public static final k0 zzb() {
        return zzb;
    }

    public static final k0 zzc() {
        return zzc;
    }
}
