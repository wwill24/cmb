package com.google.android.gms.measurement.internal;

import java.util.HashMap;
import java.util.concurrent.Callable;

public final /* synthetic */ class i4 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o4 f39931a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39932b;

    public /* synthetic */ i4(o4 o4Var, String str) {
        this.f39931a = o4Var;
        this.f39932b = str;
    }

    public final Object call() {
        o4 o4Var = this.f39931a;
        String str = this.f39932b;
        q5 R = o4Var.f39651b.V().R(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("package_name", str);
        o4Var.f40059a.z().q();
        hashMap.put("gmp_version", 79000L);
        if (R != null) {
            String o02 = R.o0();
            if (o02 != null) {
                hashMap.put("app_version", o02);
            }
            hashMap.put("app_version_int", Long.valueOf(R.R()));
            hashMap.put("dynamite_version", Long.valueOf(R.a0()));
        }
        return hashMap;
    }
}
