package com.google.android.gms.internal.p002authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import yd.b;

/* renamed from: com.google.android.gms.internal.auth-api.zbao  reason: invalid package */
public final class zbao extends c {
    private static final a.g zba;
    private static final a.C0480a zbb;
    private static final a zbc;
    private final String zbd = zbbb.zba();

    static {
        a.g gVar = new a.g();
        zba = gVar;
        zbal zbal = new zbal();
        zbb = zbal;
        zbc = new a("Auth.Api.Identity.CredentialSaving.API", zbal, gVar);
    }

    public zbao(@NonNull Activity activity, @NonNull b bVar) {
        super(activity, zbc, bVar, c.a.f38516c);
    }

    public final Status getStatusFromIntent(Intent intent) {
        if (intent == null) {
            return Status.f38502j;
        }
        Status status = (Status) fe.b.b(intent, "status", Status.CREATOR);
        if (status == null) {
            return Status.f38502j;
        }
        return status;
    }

    public final Task<SaveAccountLinkingTokenResult> saveAccountLinkingToken(@NonNull SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        p.k(saveAccountLinkingTokenRequest);
        SaveAccountLinkingTokenRequest.a m02 = SaveAccountLinkingTokenRequest.m0(saveAccountLinkingTokenRequest);
        m02.f(this.zbd);
        SaveAccountLinkingTokenRequest a10 = m02.a();
        return doRead(v.a().d(zbba.zbg).b(new zbaj(this, a10)).c(false).e(1535).a());
    }

    public final Task<SavePasswordResult> savePassword(@NonNull SavePasswordRequest savePasswordRequest) {
        p.k(savePasswordRequest);
        SavePasswordRequest.a c02 = SavePasswordRequest.c0(savePasswordRequest);
        c02.c(this.zbd);
        SavePasswordRequest a10 = c02.a();
        return doRead(v.a().d(zbba.zbe).b(new zbak(this, a10)).c(false).e(1536).a());
    }

    public zbao(@NonNull Context context, @NonNull b bVar) {
        super(context, zbc, bVar, c.a.f38516c);
    }
}
