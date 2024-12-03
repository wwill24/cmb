package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;

final class a implements k.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ModuleInstallStatusUpdate f39111a;

    a(b bVar, ModuleInstallStatusUpdate moduleInstallStatusUpdate) {
        this.f39111a = moduleInstallStatusUpdate;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((ie.a) obj).a(this.f39111a);
    }

    public final void onNotifyListenerFailed() {
    }
}
