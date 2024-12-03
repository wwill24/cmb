package com.google.android.material.appbar;

import android.view.KeyEvent;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class d implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.BaseBehavior f19098a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f19099b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f19100c;

    public /* synthetic */ d(AppBarLayout.BaseBehavior baseBehavior, View view, AppBarLayout appBarLayout) {
        this.f19098a = baseBehavior;
        this.f19099b = view;
        this.f19100c = appBarLayout;
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        return this.f19098a.n0(this.f19099b, this.f19100c, view, i10, keyEvent);
    }
}
