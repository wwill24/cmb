package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.a;
import com.google.android.gms.auth.account.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.j;

public final class zzal implements b {
    /* access modifiers changed from: private */
    public static final Status zza = new Status(13);

    public final f<Object> addWorkAccount(d dVar, String str) {
        return dVar.h(new zzae(this, a.f38192a, dVar, str));
    }

    public final f<j> removeWorkAccount(d dVar, Account account) {
        return dVar.h(new zzag(this, a.f38192a, dVar, account));
    }

    public final void setWorkAuthenticatorEnabled(d dVar, boolean z10) {
        setWorkAuthenticatorEnabledWithResult(dVar, z10);
    }

    public final f<j> setWorkAuthenticatorEnabledWithResult(d dVar, boolean z10) {
        return dVar.h(new zzac(this, a.f38192a, dVar, z10));
    }
}
