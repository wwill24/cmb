package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.e2;
import androidx.core.view.f2;
import androidx.core.view.g2;
import java.util.ArrayList;
import java.util.Iterator;

public class h {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<e2> f703a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private long f704b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f705c;

    /* renamed from: d  reason: collision with root package name */
    f2 f706d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f707e;

    /* renamed from: f  reason: collision with root package name */
    private final g2 f708f = new a();

    class a extends g2 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f709a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f710b = 0;

        a() {
        }

        public void b(View view) {
            int i10 = this.f710b + 1;
            this.f710b = i10;
            if (i10 == h.this.f703a.size()) {
                f2 f2Var = h.this.f706d;
                if (f2Var != null) {
                    f2Var.b((View) null);
                }
                d();
            }
        }

        public void c(View view) {
            if (!this.f709a) {
                this.f709a = true;
                f2 f2Var = h.this.f706d;
                if (f2Var != null) {
                    f2Var.c((View) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f710b = 0;
            this.f709a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f707e) {
            Iterator<e2> it = this.f703a.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.f707e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f707e = false;
    }

    public h c(e2 e2Var) {
        if (!this.f707e) {
            this.f703a.add(e2Var);
        }
        return this;
    }

    public h d(e2 e2Var, e2 e2Var2) {
        this.f703a.add(e2Var);
        e2Var2.j(e2Var.d());
        this.f703a.add(e2Var2);
        return this;
    }

    public h e(long j10) {
        if (!this.f707e) {
            this.f704b = j10;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f707e) {
            this.f705c = interpolator;
        }
        return this;
    }

    public h g(f2 f2Var) {
        if (!this.f707e) {
            this.f706d = f2Var;
        }
        return this;
    }

    public void h() {
        if (!this.f707e) {
            Iterator<e2> it = this.f703a.iterator();
            while (it.hasNext()) {
                e2 next = it.next();
                long j10 = this.f704b;
                if (j10 >= 0) {
                    next.f(j10);
                }
                Interpolator interpolator = this.f705c;
                if (interpolator != null) {
                    next.g(interpolator);
                }
                if (this.f706d != null) {
                    next.h(this.f708f);
                }
                next.l();
            }
            this.f707e = true;
        }
    }
}
