package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.j;

final class d0 extends e0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f38971a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j f38972b;

    d0(Intent intent, j jVar, int i10) {
        this.f38971a = intent;
        this.f38972b = jVar;
    }

    public final void a() {
        Intent intent = this.f38971a;
        if (intent != null) {
            this.f38972b.startActivityForResult(intent, 2);
        }
    }
}
