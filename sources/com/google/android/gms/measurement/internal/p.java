package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    final String f40122a;

    /* renamed from: b  reason: collision with root package name */
    final String f40123b;

    /* renamed from: c  reason: collision with root package name */
    final String f40124c;

    /* renamed from: d  reason: collision with root package name */
    final long f40125d;

    /* renamed from: e  reason: collision with root package name */
    final long f40126e;

    /* renamed from: f  reason: collision with root package name */
    final zzas f40127f;

    p(u4 u4Var, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        zzas zzas;
        com.google.android.gms.common.internal.p.g(str2);
        com.google.android.gms.common.internal.p.g(str3);
        this.f40122a = str2;
        this.f40123b = str3;
        this.f40124c = true == TextUtils.isEmpty(str) ? null : str;
        this.f40125d = j10;
        this.f40126e = j11;
        if (j11 != 0 && j11 > j10) {
            u4Var.d().w().b("Event created with reverse previous/current timestamps. appId", q3.z(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzas = new zzas(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    u4Var.d().r().a("Param name can't be null");
                    it.remove();
                } else {
                    Object o10 = u4Var.N().o(next, bundle2.get(next));
                    if (o10 == null) {
                        u4Var.d().w().b("Param value can't be null", u4Var.D().e(next));
                        it.remove();
                    } else {
                        u4Var.N().D(bundle2, next, o10);
                    }
                }
            }
            zzas = new zzas(bundle2);
        }
        this.f40127f = zzas;
    }

    /* access modifiers changed from: package-private */
    public final p a(u4 u4Var, long j10) {
        return new p(u4Var, this.f40124c, this.f40122a, this.f40123b, this.f40125d, j10, this.f40127f);
    }

    public final String toString() {
        String str = this.f40122a;
        String str2 = this.f40123b;
        String obj = this.f40127f.toString();
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + obj + "}";
    }

    private p(u4 u4Var, String str, String str2, String str3, long j10, long j11, zzas zzas) {
        com.google.android.gms.common.internal.p.g(str2);
        com.google.android.gms.common.internal.p.g(str3);
        com.google.android.gms.common.internal.p.k(zzas);
        this.f40122a = str2;
        this.f40123b = str3;
        this.f40124c = true == TextUtils.isEmpty(str) ? null : str;
        this.f40125d = j10;
        this.f40126e = j11;
        if (j11 != 0 && j11 > j10) {
            u4Var.d().w().c("Event created with reverse previous/current timestamps. appId, name", q3.z(str2), q3.z(str3));
        }
        this.f40127f = zzas;
    }
}
