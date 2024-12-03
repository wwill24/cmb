package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;

final class g1 implements c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f38626a;

    g1(g gVar) {
        this.f38626a = gVar;
    }

    public final void onBackgroundStateChanged(boolean z10) {
        g gVar = this.f38626a;
        gVar.f38623p.sendMessage(gVar.f38623p.obtainMessage(1, Boolean.valueOf(z10)));
    }
}
