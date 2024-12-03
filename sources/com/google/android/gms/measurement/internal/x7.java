package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import we.d;

final class x7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f40409a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f40410b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f40411c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzq f40412d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g8 f40413e;

    x7(g8 g8Var, AtomicReference atomicReference, String str, String str2, String str3, zzq zzq) {
        this.f40413e = g8Var;
        this.f40409a = atomicReference;
        this.f40410b = str2;
        this.f40411c = str3;
        this.f40412d = zzq;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f40409a) {
            try {
                g8 g8Var = this.f40413e;
                d H = g8Var.f39878d;
                if (H == null) {
                    g8Var.f40059a.d().r().d("(legacy) Failed to get conditional properties; not connected to service", (Object) null, this.f40410b, this.f40411c);
                    this.f40409a.set(Collections.emptyList());
                    this.f40409a.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    p.k(this.f40412d);
                    this.f40409a.set(H.Z(this.f40410b, this.f40411c, this.f40412d));
                } else {
                    this.f40409a.set(H.P((String) null, this.f40410b, this.f40411c));
                }
                this.f40413e.E();
                atomicReference = this.f40409a;
                atomicReference.notify();
            } catch (RemoteException e10) {
                try {
                    this.f40413e.f40059a.d().r().d("(legacy) Failed to get conditional properties; remote exception", (Object) null, this.f40410b, e10);
                    this.f40409a.set(Collections.emptyList());
                    atomicReference = this.f40409a;
                } catch (Throwable th2) {
                    this.f40409a.notify();
                    throw th2;
                }
            }
        }
    }
}
