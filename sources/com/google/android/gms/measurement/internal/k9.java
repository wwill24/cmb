package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class k9 implements s9 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n9 f39998a;

    k9(n9 n9Var) {
        this.f39998a = n9Var;
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            n9 n9Var = this.f39998a;
            if (n9Var.f40076l != null) {
                n9Var.f40076l.d().r().b("AppId not known when logging event", "_err");
                return;
            }
            return;
        }
        this.f39998a.f().z(new j9(this, str, "_err", bundle));
    }
}
