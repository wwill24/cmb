package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class t extends r {

    /* renamed from: c  reason: collision with root package name */
    private static final WeakReference f39185c = new WeakReference((Object) null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference f39186b = f39185c;

    t(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] W();

    /* access modifiers changed from: package-private */
    public final byte[] g() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f39186b.get();
            if (bArr == null) {
                bArr = W();
                this.f39186b = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
