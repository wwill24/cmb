package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class g<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    private h f19115a;

    /* renamed from: b  reason: collision with root package name */
    private int f19116b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f19117c = 0;

    public g() {
    }

    public int E() {
        h hVar = this.f19115a;
        if (hVar != null) {
            return hVar.c();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void F(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        coordinatorLayout.I(v10, i10);
    }

    public boolean G(int i10) {
        h hVar = this.f19115a;
        if (hVar != null) {
            return hVar.f(i10);
        }
        this.f19116b = i10;
        return false;
    }

    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        F(coordinatorLayout, v10, i10);
        if (this.f19115a == null) {
            this.f19115a = new h(v10);
        }
        this.f19115a.d();
        this.f19115a.a();
        int i11 = this.f19116b;
        if (i11 != 0) {
            this.f19115a.f(i11);
            this.f19116b = 0;
        }
        int i12 = this.f19117c;
        if (i12 == 0) {
            return true;
        }
        this.f19115a.e(i12);
        this.f19117c = 0;
        return true;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
