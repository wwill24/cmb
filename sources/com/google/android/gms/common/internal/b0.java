package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class b0 extends e0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f38963a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f38964b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f38965c;

    b0(Intent intent, Activity activity, int i10) {
        this.f38963a = intent;
        this.f38964b = activity;
        this.f38965c = i10;
    }

    public final void a() {
        Intent intent = this.f38963a;
        if (intent != null) {
            this.f38964b.startActivityForResult(intent, this.f38965c);
        }
    }
}
