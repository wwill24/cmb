package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;

class c0 {

    /* renamed from: e  reason: collision with root package name */
    private static final c0 f38869e = new c0(true, 3, 1, (String) null, (Throwable) null);

    /* renamed from: a  reason: collision with root package name */
    final boolean f38870a;

    /* renamed from: b  reason: collision with root package name */
    final String f38871b;

    /* renamed from: c  reason: collision with root package name */
    final Throwable f38872c;

    /* renamed from: d  reason: collision with root package name */
    final int f38873d;

    private c0(boolean z10, int i10, int i11, String str, Throwable th2) {
        this.f38870a = z10;
        this.f38873d = i10;
        this.f38871b = str;
        this.f38872c = th2;
    }

    /* synthetic */ c0(boolean z10, int i10, int i11, String str, Throwable th2, b0 b0Var) {
        this(false, 1, 5, (String) null, (Throwable) null);
    }

    @Deprecated
    static c0 b() {
        return f38869e;
    }

    static c0 c(@NonNull String str) {
        return new c0(false, 1, 5, str, (Throwable) null);
    }

    static c0 d(@NonNull String str, @NonNull Throwable th2) {
        return new c0(false, 1, 5, str, th2);
    }

    static c0 f(int i10) {
        return new c0(true, i10, 1, (String) null, (Throwable) null);
    }

    static c0 g(int i10, int i11, @NonNull String str, Throwable th2) {
        return new c0(false, i10, i11, str, th2);
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.f38871b;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (!this.f38870a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.f38872c != null) {
                a();
            } else {
                a();
            }
        }
    }
}
