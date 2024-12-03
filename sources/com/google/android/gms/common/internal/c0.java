package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

final class c0 extends e0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f38966a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Fragment f38967b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f38968c;

    c0(Intent intent, Fragment fragment, int i10) {
        this.f38966a = intent;
        this.f38967b = fragment;
        this.f38968c = i10;
    }

    public final void a() {
        Intent intent = this.f38966a;
        if (intent != null) {
            this.f38967b.startActivityForResult(intent, this.f38968c);
        }
    }
}
