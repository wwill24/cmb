package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public final class n1 {

    /* renamed from: f  reason: collision with root package name */
    private static final Uri f39027f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a  reason: collision with root package name */
    private final String f39028a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39029b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f39030c = null;

    /* renamed from: d  reason: collision with root package name */
    private final int f39031d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f39032e;

    public n1(String str, String str2, int i10, boolean z10) {
        p.g(str);
        this.f39028a = str;
        p.g(str2);
        this.f39029b = str2;
        this.f39031d = i10;
        this.f39032e = z10;
    }

    public final int a() {
        return this.f39031d;
    }

    public final ComponentName b() {
        return this.f39030c;
    }

    public final Intent c(Context context) {
        Bundle bundle;
        if (this.f39028a == null) {
            return new Intent().setComponent(this.f39030c);
        }
        Intent intent = null;
        if (this.f39032e) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.f39028a);
            try {
                bundle = context.getContentResolver().call(f39027f, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e10) {
                "Dynamic intent resolution failed: ".concat(e10.toString());
                bundle = null;
            }
            if (bundle != null) {
                intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
            }
            if (intent == null) {
                "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f39028a));
            }
        }
        if (intent != null) {
            return intent;
        }
        return new Intent(this.f39028a).setPackage(this.f39029b);
    }

    public final String d() {
        return this.f39029b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        if (!n.b(this.f39028a, n1Var.f39028a) || !n.b(this.f39029b, n1Var.f39029b) || !n.b(this.f39030c, n1Var.f39030c) || this.f39031d != n1Var.f39031d || this.f39032e != n1Var.f39032e) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(this.f39028a, this.f39029b, this.f39030c, Integer.valueOf(this.f39031d), Boolean.valueOf(this.f39032e));
    }

    public final String toString() {
        String str = this.f39028a;
        if (str != null) {
            return str;
        }
        p.k(this.f39030c);
        return this.f39030c.flattenToString();
    }
}
