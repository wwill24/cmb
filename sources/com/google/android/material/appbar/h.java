package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.n0;

class h {

    /* renamed from: a  reason: collision with root package name */
    private final View f19118a;

    /* renamed from: b  reason: collision with root package name */
    private int f19119b;

    /* renamed from: c  reason: collision with root package name */
    private int f19120c;

    /* renamed from: d  reason: collision with root package name */
    private int f19121d;

    /* renamed from: e  reason: collision with root package name */
    private int f19122e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19123f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19124g = true;

    public h(View view) {
        this.f19118a = view;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View view = this.f19118a;
        n0.d0(view, this.f19121d - (view.getTop() - this.f19119b));
        View view2 = this.f19118a;
        n0.c0(view2, this.f19122e - (view2.getLeft() - this.f19120c));
    }

    public int b() {
        return this.f19119b;
    }

    public int c() {
        return this.f19121d;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f19119b = this.f19118a.getTop();
        this.f19120c = this.f19118a.getLeft();
    }

    public boolean e(int i10) {
        if (!this.f19124g || this.f19122e == i10) {
            return false;
        }
        this.f19122e = i10;
        a();
        return true;
    }

    public boolean f(int i10) {
        if (!this.f19123f || this.f19121d == i10) {
            return false;
        }
        this.f19121d = i10;
        a();
        return true;
    }
}
