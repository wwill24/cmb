package com.google.android.gms.measurement.internal;

import java.util.Map;

public final /* synthetic */ class v6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w6 f40360a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f40361b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f40362c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ byte[] f40363d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Map f40364e;

    public /* synthetic */ v6(w6 w6Var, int i10, Exception exc, byte[] bArr, Map map) {
        this.f40360a = w6Var;
        this.f40361b = i10;
        this.f40362c = exc;
        this.f40363d = bArr;
        this.f40364e = map;
    }

    public final void run() {
        this.f40360a.a(this.f40361b, this.f40362c, this.f40363d, this.f40364e);
    }
}
