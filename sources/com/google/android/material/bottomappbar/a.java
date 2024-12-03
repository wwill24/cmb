package com.google.android.material.bottomappbar;

import android.view.View;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f19243a;

    public /* synthetic */ a(View view) {
        this.f19243a = view;
    }

    public final void run() {
        this.f19243a.requestLayout();
    }
}
