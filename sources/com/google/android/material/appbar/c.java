package com.google.android.material.appbar;

import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class c implements View$OnUnhandledKeyEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f19095a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f19096b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f19097c;

    public /* synthetic */ c(AppBarLayout.BaseBehavior baseBehavior, View view, AppBarLayout appBarLayout) {
        this.f19095a = baseBehavior;
        this.f19096b = view;
        this.f19097c = appBarLayout;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.f19095a.m0(this.f19096b, this.f19097c, view, keyEvent);
    }
}
