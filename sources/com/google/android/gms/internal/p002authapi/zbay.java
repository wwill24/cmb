package com.google.android.gms.internal.p002authapi;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import fe.b;
import yd.e;

/* renamed from: com.google.android.gms.internal.auth-api.zbay  reason: invalid package */
public final class zbay extends c {
    private static final a.g zba;
    private static final a.C0480a zbb;
    private static final a zbc;
    private final String zbd = zbbb.zba();

    static {
        a.g gVar = new a.g();
        zba = gVar;
        zbat zbat = new zbat();
        zbb = zbat;
        zbc = new a("Auth.Api.Identity.SignIn.API", zbat, gVar);
    }

    public zbay(@NonNull Activity activity, @NonNull e eVar) {
        super(activity, zbc, eVar, c.a.f38516c);
    }

    public final Task<BeginSignInResult> beginSignIn(@NonNull BeginSignInRequest beginSignInRequest) {
        p.k(beginSignInRequest);
        BeginSignInRequest.a m02 = BeginSignInRequest.m0(beginSignInRequest);
        m02.f(this.zbd);
        BeginSignInRequest a10 = m02.a();
        return doRead(v.a().d(zbba.zba).b(new zbap(this, a10)).c(false).e(1553).a());
    }

    public final String getPhoneNumberFromIntent(Intent intent) throws ApiException {
        if (intent != null) {
            Status status = (Status) b.b(intent, "status", Status.CREATOR);
            if (status == null) {
                throw new ApiException(Status.f38504l);
            } else if (status.i0()) {
                String stringExtra = intent.getStringExtra("phone_number_hint_result");
                if (stringExtra != null) {
                    return stringExtra;
                }
                throw new ApiException(Status.f38502j);
            } else {
                throw new ApiException(status);
            }
        } else {
            throw new ApiException(Status.f38502j);
        }
    }

    public final Task<PendingIntent> getPhoneNumberHintIntent(@NonNull GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest) {
        p.k(getPhoneNumberHintIntentRequest);
        return doRead(v.a().d(zbba.zbh).b(new zbas(this, getPhoneNumberHintIntentRequest)).e(1653).a());
    }

    public final SignInCredential getSignInCredentialFromIntent(Intent intent) throws ApiException {
        if (intent != null) {
            Status status = (Status) b.b(intent, "status", Status.CREATOR);
            if (status == null) {
                throw new ApiException(Status.f38504l);
            } else if (status.i0()) {
                SignInCredential signInCredential = (SignInCredential) b.b(intent, "sign_in_credential", SignInCredential.CREATOR);
                if (signInCredential != null) {
                    return signInCredential;
                }
                throw new ApiException(Status.f38502j);
            } else {
                throw new ApiException(status);
            }
        } else {
            throw new ApiException(Status.f38502j);
        }
    }

    public final Task<PendingIntent> getSignInIntent(@NonNull GetSignInIntentRequest getSignInIntentRequest) {
        p.k(getSignInIntentRequest);
        GetSignInIntentRequest.a m02 = GetSignInIntentRequest.m0(getSignInIntentRequest);
        m02.f(this.zbd);
        GetSignInIntentRequest a10 = m02.a();
        return doRead(v.a().d(zbba.zbf).b(new zbaq(this, a10)).e(1555).a());
    }

    public final Task<Void> signOut() {
        getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
        for (d p10 : d.i()) {
            p10.p();
        }
        g.a();
        return doWrite(v.a().d(zbba.zbb).b(new zbar(this)).c(false).e(1554).a());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zba(GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest, zbaz zbaz, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zbai) zbaz.getService()).zbd(new zbax(this, taskCompletionSource), getPhoneNumberHintIntentRequest, this.zbd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zbb(zbaz zbaz, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zbai) zbaz.getService()).zbf(new zbav(this, taskCompletionSource), this.zbd);
    }

    public zbay(@NonNull Context context, @NonNull e eVar) {
        super(context, zbc, eVar, c.a.f38516c);
    }
}
