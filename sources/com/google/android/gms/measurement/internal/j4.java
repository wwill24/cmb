package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;
import java.util.concurrent.Callable;

public final /* synthetic */ class j4 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o4 f39953a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39954b;

    public /* synthetic */ j4(o4 o4Var, String str) {
        this.f39953a = o4Var;
        this.f39954b = str;
    }

    public final Object call() {
        return new zzn("internal.remoteConfig", new n4(this.f39953a, this.f39954b));
    }
}
