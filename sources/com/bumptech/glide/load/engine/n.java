package com.bumptech.glide.load.engine;

import i3.b;
import java.util.HashMap;
import java.util.Map;

final class n {

    /* renamed from: a  reason: collision with root package name */
    private final Map<b, i<?>> f9408a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<b, i<?>> f9409b = new HashMap();

    n() {
    }

    private Map<b, i<?>> b(boolean z10) {
        return z10 ? this.f9409b : this.f9408a;
    }

    /* access modifiers changed from: package-private */
    public i<?> a(b bVar, boolean z10) {
        return b(z10).get(bVar);
    }

    /* access modifiers changed from: package-private */
    public void c(b bVar, i<?> iVar) {
        b(iVar.p()).put(bVar, iVar);
    }

    /* access modifiers changed from: package-private */
    public void d(b bVar, i<?> iVar) {
        Map<b, i<?>> b10 = b(iVar.p());
        if (iVar.equals(b10.get(bVar))) {
            b10.remove(bVar);
        }
    }
}
