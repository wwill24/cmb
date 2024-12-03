package com.google.android.gms.common.api.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.n;

final class n1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f38695a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Feature f38696b;

    /* synthetic */ n1(b bVar, Feature feature, m1 m1Var) {
        this.f38695a = bVar;
        this.f38696b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof n1)) {
            n1 n1Var = (n1) obj;
            if (!n.b(this.f38695a, n1Var.f38695a) || !n.b(this.f38696b, n1Var.f38696b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return n.c(this.f38695a, this.f38696b);
    }

    public final String toString() {
        return n.d(this).a(SDKConstants.PARAM_KEY, this.f38695a).a("feature", this.f38696b).toString();
    }
}
