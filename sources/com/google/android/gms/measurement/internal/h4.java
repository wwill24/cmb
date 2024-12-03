package com.google.android.gms.measurement.internal;

import oe.c;
import oe.d;

public final class h4 {

    /* renamed from: a  reason: collision with root package name */
    final u4 f39891a;

    h4(n9 n9Var) {
        this.f39891a = n9Var.b0();
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        try {
            c a10 = d.a(this.f39891a.c());
            if (a10 == null) {
                this.f39891a.d().v().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (a10.e("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e10) {
            this.f39891a.d().v().b("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }
}
