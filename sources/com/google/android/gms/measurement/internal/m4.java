package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;

final class m4 implements zzr {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o4 f40031a;

    m4(o4 o4Var) {
        this.f40031a = o4Var;
    }

    public final void zza(int i10, String str, List list, boolean z10, boolean z11) {
        o3 o3Var;
        int i11 = i10 - 1;
        if (i11 == 0) {
            o3Var = this.f40031a.f40059a.d().q();
        } else if (i11 != 1) {
            if (i11 == 3) {
                o3Var = this.f40031a.f40059a.d().v();
            } else if (i11 != 4) {
                o3Var = this.f40031a.f40059a.d().u();
            } else if (z10) {
                o3Var = this.f40031a.f40059a.d().y();
            } else if (!z11) {
                o3Var = this.f40031a.f40059a.d().x();
            } else {
                o3Var = this.f40031a.f40059a.d().w();
            }
        } else if (z10) {
            o3Var = this.f40031a.f40059a.d().t();
        } else if (!z11) {
            o3Var = this.f40031a.f40059a.d().s();
        } else {
            o3Var = this.f40031a.f40059a.d().r();
        }
        int size = list.size();
        if (size == 1) {
            o3Var.b(str, list.get(0));
        } else if (size == 2) {
            o3Var.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            o3Var.a(str);
        } else {
            o3Var.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
