package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class x extends RecyclerView.l {

    /* renamed from: g  reason: collision with root package name */
    boolean f6717g = true;

    @SuppressLint({"UnknownNullness"})
    public abstract boolean A(RecyclerView.d0 d0Var);

    @SuppressLint({"UnknownNullness"})
    public final void B(RecyclerView.d0 d0Var) {
        J(d0Var);
        h(d0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void C(RecyclerView.d0 d0Var) {
        K(d0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void D(RecyclerView.d0 d0Var, boolean z10) {
        L(d0Var, z10);
        h(d0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void E(RecyclerView.d0 d0Var, boolean z10) {
        M(d0Var, z10);
    }

    @SuppressLint({"UnknownNullness"})
    public final void F(RecyclerView.d0 d0Var) {
        N(d0Var);
        h(d0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void G(RecyclerView.d0 d0Var) {
        O(d0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void H(RecyclerView.d0 d0Var) {
        P(d0Var);
        h(d0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public final void I(RecyclerView.d0 d0Var) {
        Q(d0Var);
    }

    @SuppressLint({"UnknownNullness"})
    public void J(RecyclerView.d0 d0Var) {
    }

    @SuppressLint({"UnknownNullness"})
    public void K(RecyclerView.d0 d0Var) {
    }

    @SuppressLint({"UnknownNullness"})
    public void L(RecyclerView.d0 d0Var, boolean z10) {
    }

    @SuppressLint({"UnknownNullness"})
    public void M(RecyclerView.d0 d0Var, boolean z10) {
    }

    @SuppressLint({"UnknownNullness"})
    public void N(RecyclerView.d0 d0Var) {
    }

    @SuppressLint({"UnknownNullness"})
    public void O(RecyclerView.d0 d0Var) {
    }

    @SuppressLint({"UnknownNullness"})
    public void P(RecyclerView.d0 d0Var) {
    }

    @SuppressLint({"UnknownNullness"})
    public void Q(RecyclerView.d0 d0Var) {
    }

    public boolean a(@NonNull RecyclerView.d0 d0Var, RecyclerView.l.c cVar, @NonNull RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        if (cVar == null || ((i10 = cVar.f6330a) == (i11 = cVar2.f6330a) && cVar.f6331b == cVar2.f6331b)) {
            return x(d0Var);
        }
        return z(d0Var, i10, cVar.f6331b, i11, cVar2.f6331b);
    }

    public boolean b(@NonNull RecyclerView.d0 d0Var, @NonNull RecyclerView.d0 d0Var2, @NonNull RecyclerView.l.c cVar, @NonNull RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f6330a;
        int i13 = cVar.f6331b;
        if (d0Var2.S()) {
            int i14 = cVar.f6330a;
            i10 = cVar.f6331b;
            i11 = i14;
        } else {
            i11 = cVar2.f6330a;
            i10 = cVar2.f6331b;
        }
        return y(d0Var, d0Var2, i12, i13, i11, i10);
    }

    public boolean c(@NonNull RecyclerView.d0 d0Var, @NonNull RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f6330a;
        int i13 = cVar.f6331b;
        View view = d0Var.f6302a;
        if (cVar2 == null) {
            i10 = view.getLeft();
        } else {
            i10 = cVar2.f6330a;
        }
        int i14 = i10;
        if (cVar2 == null) {
            i11 = view.getTop();
        } else {
            i11 = cVar2.f6331b;
        }
        int i15 = i11;
        if (d0Var.E() || (i12 == i14 && i13 == i15)) {
            return A(d0Var);
        }
        view.layout(i14, i15, view.getWidth() + i14, view.getHeight() + i15);
        return z(d0Var, i12, i13, i14, i15);
    }

    public boolean d(@NonNull RecyclerView.d0 d0Var, @NonNull RecyclerView.l.c cVar, @NonNull RecyclerView.l.c cVar2) {
        int i10 = cVar.f6330a;
        int i11 = cVar2.f6330a;
        if (i10 == i11 && cVar.f6331b == cVar2.f6331b) {
            F(d0Var);
            return false;
        }
        return z(d0Var, i10, cVar.f6331b, i11, cVar2.f6331b);
    }

    public boolean f(@NonNull RecyclerView.d0 d0Var) {
        return !this.f6717g || d0Var.C();
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean x(RecyclerView.d0 d0Var);

    @SuppressLint({"UnknownNullness"})
    public abstract boolean y(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13);

    @SuppressLint({"UnknownNullness"})
    public abstract boolean z(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13);
}
