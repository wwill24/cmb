package com.google.android.recaptcha.internal;

import android.webkit.WebView;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

public final class zzbc {
    /* access modifiers changed from: private */
    public final WebView zza;
    private final k0 zzb;

    public zzbc(WebView webView, k0 k0Var) {
        this.zza = webView;
        this.zzb = k0Var;
    }

    public final void zzb(String str, String... strArr) {
        s1 unused = j.d(this.zzb, (CoroutineContext) null, (CoroutineStart) null, new zzbb(strArr, this, str, (c) null), 3, (Object) null);
    }
}
