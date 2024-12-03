package com.google.android.recaptcha.internal;

import java.util.TimerTask;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;

public final class zzal extends TimerTask {
    final /* synthetic */ zzao zza;

    public zzal(zzao zzao) {
        this.zza = zzao;
    }

    public final void run() {
        s1 unused = j.d(this.zza.zzd, (CoroutineContext) null, (CoroutineStart) null, new zzam(this.zza, (c) null), 3, (Object) null);
    }
}
