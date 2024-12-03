package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import androidx.loader.app.a;
import ce.e;
import ce.v;
import com.google.android.gms.common.api.d;

final class b implements a.C0065a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignInHubActivity f38427a;

    /* synthetic */ b(SignInHubActivity signInHubActivity, v vVar) {
        this.f38427a = signInHubActivity;
    }

    public final /* bridge */ /* synthetic */ void K(androidx.loader.content.b bVar, Object obj) {
        Void voidR = (Void) obj;
        SignInHubActivity signInHubActivity = this.f38427a;
        signInHubActivity.setResult(signInHubActivity.f38425d, signInHubActivity.f38426e);
        this.f38427a.finish();
    }

    public final androidx.loader.content.b L(int i10, Bundle bundle) {
        return new e(this.f38427a, d.i());
    }

    public final void b0(androidx.loader.content.b bVar) {
    }
}
