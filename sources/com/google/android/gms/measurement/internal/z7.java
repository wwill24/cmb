package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import we.d;

final class z7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f40469a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f40470b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f40471c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzq f40472d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f40473e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ g8 f40474f;

    z7(g8 g8Var, AtomicReference atomicReference, String str, String str2, String str3, zzq zzq, boolean z10) {
        this.f40474f = g8Var;
        this.f40469a = atomicReference;
        this.f40470b = str2;
        this.f40471c = str3;
        this.f40472d = zzq;
        this.f40473e = z10;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f40469a) {
            try {
                g8 g8Var = this.f40474f;
                d H = g8Var.f39878d;
                if (H == null) {
                    g8Var.f40059a.d().r().d("(legacy) Failed to get user properties; not connected to service", (Object) null, this.f40470b, this.f40471c);
                    this.f40469a.set(Collections.emptyList());
                    this.f40469a.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    p.k(this.f40472d);
                    this.f40469a.set(H.z(this.f40470b, this.f40471c, this.f40473e, this.f40472d));
                } else {
                    this.f40469a.set(H.K((String) null, this.f40470b, this.f40471c, this.f40473e));
                }
                this.f40474f.E();
                atomicReference = this.f40469a;
                atomicReference.notify();
            } catch (RemoteException e10) {
                try {
                    this.f40474f.f40059a.d().r().d("(legacy) Failed to get user properties; remote exception", (Object) null, this.f40470b, e10);
                    this.f40469a.set(Collections.emptyList());
                    atomicReference = this.f40469a;
                } catch (Throwable th2) {
                    this.f40469a.notify();
                    throw th2;
                }
            }
        }
    }
}
