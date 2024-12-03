package com.google.android.gms.auth.api.signin;

import android.content.Context;
import androidx.annotation.NonNull;
import be.e;
import ce.m;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import vd.a;

public class b extends c<GoogleSignInOptions> {

    /* renamed from: a  reason: collision with root package name */
    private static final f f38414a = new f((e) null);

    /* renamed from: b  reason: collision with root package name */
    static int f38415b = 1;

    b(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, a.f42080c, googleSignInOptions, (t) new com.google.android.gms.common.api.internal.a());
    }

    private final synchronized int e() {
        int i10;
        i10 = f38415b;
        if (i10 == 1) {
            Context applicationContext = getApplicationContext();
            com.google.android.gms.common.c p10 = com.google.android.gms.common.c.p();
            int j10 = p10.j(applicationContext, com.google.android.gms.common.e.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (j10 == 0) {
                f38415b = 4;
                i10 = 4;
            } else if (p10.d(applicationContext, j10, (String) null) != null || DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                f38415b = 2;
                i10 = 2;
            } else {
                f38415b = 3;
                i10 = 3;
            }
        }
        return i10;
    }

    @NonNull
    public Task<Void> d() {
        boolean z10;
        d asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        if (e() == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        return o.b(m.b(asGoogleApiClient, applicationContext, z10));
    }

    @NonNull
    public Task<Void> signOut() {
        boolean z10;
        d asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        if (e() == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        return o.b(m.c(asGoogleApiClient, applicationContext, z10));
    }
}
