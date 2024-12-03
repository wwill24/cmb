package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import ce.b;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import ze.c;

public class a extends f<c> implements ye.f {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f40534e = 0;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f40535a = true;

    /* renamed from: b  reason: collision with root package name */
    private final e f40536b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f40537c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f40538d;

    public a(@NonNull Context context, @NonNull Looper looper, boolean z10, @NonNull e eVar, @NonNull Bundle bundle, @NonNull d.b bVar, @NonNull d.c cVar) {
        super(context, looper, 44, eVar, bVar, cVar);
        this.f40536b = eVar;
        this.f40537c = bundle;
        this.f40538d = eVar.i();
    }

    @NonNull
    public static Bundle e(@NonNull e eVar) {
        eVar.h();
        Integer i10 = eVar.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", eVar.a());
        if (i10 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i10.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    public final void a() {
        try {
            ((c) getService()).c(((Integer) p.k(this.f40538d)).intValue());
        } catch (RemoteException unused) {
        }
    }

    public final void b() {
        connect(new d.C0483d());
    }

    public final void c(c cVar) {
        GoogleSignInAccount googleSignInAccount;
        p.l(cVar, "Expecting a valid ISignInCallbacks");
        try {
            Account c10 = this.f40536b.c();
            if (com.google.android.gms.common.internal.d.DEFAULT_ACCOUNT.equals(c10.name)) {
                googleSignInAccount = b.b(getContext()).c();
            } else {
                googleSignInAccount = null;
            }
            ((c) getService()).g(new zai(1, new zat(c10, ((Integer) p.k(this.f40538d)).intValue(), googleSignInAccount)), cVar);
        } catch (RemoteException e10) {
            try {
                cVar.n(new zak(1, new ConnectionResult(8, (PendingIntent) null), (zav) null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e10);
            }
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final /* synthetic */ IInterface createServiceInterface(@NonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof c) {
            return (c) queryLocalInterface;
        }
        return new c(iBinder);
    }

    public final void d(@NonNull i iVar, boolean z10) {
        try {
            ((c) getService()).f(iVar, ((Integer) p.k(this.f40538d)).intValue(), z10);
        } catch (RemoteException unused) {
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.f40536b.f())) {
            this.f40537c.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f40536b.f());
        }
        return this.f40537c;
    }

    public final int getMinApkVersion() {
        return com.google.android.gms.common.e.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    public final boolean requiresSignIn() {
        return this.f40535a;
    }
}
