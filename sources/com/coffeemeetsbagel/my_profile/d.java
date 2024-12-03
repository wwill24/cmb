package com.coffeemeetsbagel.my_profile;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import lc.a;

public class d extends l.e {

    /* renamed from: d  reason: collision with root package name */
    private final j f34741d;

    public d(j jVar) {
        this.f34741d = jVar;
    }

    public void A(RecyclerView.d0 d0Var, int i10) {
        super.A(d0Var, i10);
        if (i10 == 2) {
            a.b(d0Var.f6302a, 1.15f);
        } else if (i10 == 0) {
            this.f34741d.P();
        }
    }

    public void B(RecyclerView.d0 d0Var, int i10) {
    }

    public void c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        super.c(recyclerView, d0Var);
        a.a(d0Var.f6302a);
    }

    public int k(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        int i10;
        if (d0Var.q() >= this.f34741d.J().size()) {
            i10 = 0;
        } else {
            i10 = 15;
        }
        return l.e.t(i10, 0);
    }

    public boolean q() {
        return false;
    }

    public boolean r() {
        return true;
    }

    public boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        int q10 = d0Var.q();
        int q11 = d0Var2.q();
        int size = this.f34741d.J().size();
        if (q10 >= size || q11 >= size) {
            return true;
        }
        return this.f34741d.Q(q10, q11);
    }
}
