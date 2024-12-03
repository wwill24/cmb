package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import java.util.Map;
import we.f;

final class t3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final s3 f40270a;

    /* renamed from: b  reason: collision with root package name */
    private final int f40271b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f40272c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f40273d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40274e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f40275f;

    /* synthetic */ t3(String str, s3 s3Var, int i10, Throwable th2, byte[] bArr, Map map, f fVar) {
        p.k(s3Var);
        this.f40270a = s3Var;
        this.f40271b = i10;
        this.f40272c = th2;
        this.f40273d = bArr;
        this.f40274e = str;
        this.f40275f = map;
    }

    public final void run() {
        this.f40270a.a(this.f40274e, this.f40271b, this.f40272c, this.f40273d, this.f40275f);
    }
}
