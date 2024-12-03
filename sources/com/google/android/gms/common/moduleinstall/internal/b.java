package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import je.f;

final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private final k f39112a;

    public b(k kVar) {
        this.f39112a = kVar;
    }

    public final void i0(ModuleInstallStatusUpdate moduleInstallStatusUpdate) {
        this.f39112a.c(new a(this, moduleInstallStatusUpdate));
    }
}
