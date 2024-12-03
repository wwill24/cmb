package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.o f6707a;

    /* renamed from: b  reason: collision with root package name */
    private int f6708b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f6709c;

    class a extends t {
        a(RecyclerView.o oVar) {
            super(oVar, (a) null);
        }

        public int d(View view) {
            return this.f6707a.U(view) + ((RecyclerView.p) view.getLayoutParams()).rightMargin;
        }

        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f6707a.T(view) + pVar.leftMargin + pVar.rightMargin;
        }

        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f6707a.S(view) + pVar.topMargin + pVar.bottomMargin;
        }

        public int g(View view) {
            return this.f6707a.R(view) - ((RecyclerView.p) view.getLayoutParams()).leftMargin;
        }

        public int h() {
            return this.f6707a.p0();
        }

        public int i() {
            return this.f6707a.p0() - this.f6707a.g0();
        }

        public int j() {
            return this.f6707a.g0();
        }

        public int k() {
            return this.f6707a.q0();
        }

        public int l() {
            return this.f6707a.Y();
        }

        public int m() {
            return this.f6707a.f0();
        }

        public int n() {
            return (this.f6707a.p0() - this.f6707a.f0()) - this.f6707a.g0();
        }

        public int p(View view) {
            this.f6707a.o0(view, true, this.f6709c);
            return this.f6709c.right;
        }

        public int q(View view) {
            this.f6707a.o0(view, true, this.f6709c);
            return this.f6709c.left;
        }

        public void r(int i10) {
            this.f6707a.D0(i10);
        }
    }

    class b extends t {
        b(RecyclerView.o oVar) {
            super(oVar, (a) null);
        }

        public int d(View view) {
            return this.f6707a.P(view) + ((RecyclerView.p) view.getLayoutParams()).bottomMargin;
        }

        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f6707a.S(view) + pVar.topMargin + pVar.bottomMargin;
        }

        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f6707a.T(view) + pVar.leftMargin + pVar.rightMargin;
        }

        public int g(View view) {
            return this.f6707a.V(view) - ((RecyclerView.p) view.getLayoutParams()).topMargin;
        }

        public int h() {
            return this.f6707a.X();
        }

        public int i() {
            return this.f6707a.X() - this.f6707a.e0();
        }

        public int j() {
            return this.f6707a.e0();
        }

        public int k() {
            return this.f6707a.Y();
        }

        public int l() {
            return this.f6707a.q0();
        }

        public int m() {
            return this.f6707a.h0();
        }

        public int n() {
            return (this.f6707a.X() - this.f6707a.h0()) - this.f6707a.e0();
        }

        public int p(View view) {
            this.f6707a.o0(view, true, this.f6709c);
            return this.f6709c.bottom;
        }

        public int q(View view) {
            this.f6707a.o0(view, true, this.f6709c);
            return this.f6709c.top;
        }

        public void r(int i10) {
            this.f6707a.E0(i10);
        }
    }

    /* synthetic */ t(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static t a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static t b(RecyclerView.o oVar, int i10) {
        if (i10 == 0) {
            return a(oVar);
        }
        if (i10 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static t c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f6708b) {
            return 0;
        }
        return n() - this.f6708b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i10);

    public void s() {
        this.f6708b = n();
    }

    private t(RecyclerView.o oVar) {
        this.f6708b = Integer.MIN_VALUE;
        this.f6709c = new Rect();
        this.f6707a = oVar;
    }
}
