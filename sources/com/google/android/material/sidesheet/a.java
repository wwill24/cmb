package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import z0.c;

final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    final SideSheetBehavior<? extends View> f20061a;

    a(@NonNull SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f20061a = sideSheetBehavior;
    }

    private boolean i(@NonNull View view) {
        return view.getLeft() > (d() - c()) / 2;
    }

    private boolean j(float f10, float f11) {
        if (!d.a(f10, f11) || f11 <= ((float) this.f20061a.e0())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public float a(int i10) {
        float d10 = (float) d();
        return (d10 - ((float) i10)) / (d10 - ((float) c()));
    }

    /* access modifiers changed from: package-private */
    public int b(@NonNull View view, float f10, float f11) {
        if (f10 >= 0.0f) {
            if (k(view, f10)) {
                if (j(f10, f11) || i(view)) {
                    return 5;
                }
            } else if (f10 != 0.0f && d.a(f10, f11)) {
                return 5;
            } else {
                int left = view.getLeft();
                if (Math.abs(left - c()) >= Math.abs(left - d())) {
                    return 5;
                }
            }
        }
        return 3;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return Math.max(0, d() - this.f20061a.W());
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f20061a.d0();
    }

    /* access modifiers changed from: package-private */
    public <V extends View> int e(@NonNull V v10) {
        return v10.getLeft();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean g(View view, int i10, boolean z10) {
        int c02 = this.f20061a.c0(i10);
        c f02 = this.f20061a.f0();
        if (f02 == null || (!z10 ? !f02.H(view, c02, view.getTop()) : !f02.F(c02, view.getTop()))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        int d02 = this.f20061a.d0();
        if (i10 <= d02) {
            marginLayoutParams.rightMargin = d02 - i10;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean k(@NonNull View view, float f10) {
        if (Math.abs(((float) view.getRight()) + (f10 * this.f20061a.a0())) > this.f20061a.b0()) {
            return true;
        }
        return false;
    }
}
