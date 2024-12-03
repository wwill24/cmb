package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class f {

    /* renamed from: a  reason: collision with root package name */
    final b f6500a;

    /* renamed from: b  reason: collision with root package name */
    final a f6501b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f6502c = new ArrayList();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f6503a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f6504b;

        a() {
        }

        private void c() {
            if (this.f6504b == null) {
                this.f6504b = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            if (i10 >= 64) {
                a aVar = this.f6504b;
                if (aVar != null) {
                    aVar.a(i10 - 64);
                    return;
                }
                return;
            }
            this.f6503a &= ~(1 << i10);
        }

        /* access modifiers changed from: package-private */
        public int b(int i10) {
            a aVar = this.f6504b;
            if (aVar == null) {
                if (i10 >= 64) {
                    return Long.bitCount(this.f6503a);
                }
                return Long.bitCount(this.f6503a & ((1 << i10) - 1));
            } else if (i10 < 64) {
                return Long.bitCount(this.f6503a & ((1 << i10) - 1));
            } else {
                return aVar.b(i10 - 64) + Long.bitCount(this.f6503a);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i10) {
            if (i10 >= 64) {
                c();
                return this.f6504b.d(i10 - 64);
            } else if ((this.f6503a & (1 << i10)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, boolean z10) {
            boolean z11;
            if (i10 >= 64) {
                c();
                this.f6504b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f6503a;
            if ((Long.MIN_VALUE & j10) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            long j11 = (1 << i10) - 1;
            this.f6503a = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f6504b != null) {
                c();
                this.f6504b.e(0, z11);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean f(int i10) {
            boolean z10;
            if (i10 >= 64) {
                c();
                return this.f6504b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f6503a;
            if ((j11 & j10) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            long j12 = j11 & (~j10);
            this.f6503a = j12;
            long j13 = j10 - 1;
            this.f6503a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            a aVar = this.f6504b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f6504b.f(0);
            }
            return z10;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.f6503a = 0;
            a aVar = this.f6504b;
            if (aVar != null) {
                aVar.g();
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i10) {
            if (i10 >= 64) {
                c();
                this.f6504b.h(i10 - 64);
                return;
            }
            this.f6503a |= 1 << i10;
        }

        public String toString() {
            if (this.f6504b == null) {
                return Long.toBinaryString(this.f6503a);
            }
            return this.f6504b.toString() + "xx" + Long.toBinaryString(this.f6503a);
        }
    }

    interface b {
        View a(int i10);

        void b(View view);

        RecyclerView.d0 c(View view);

        void d(int i10);

        void e(View view, int i10);

        void f();

        int g(View view);

        int getChildCount();

        void h(View view);

        void i(int i10);

        void j(View view, int i10, ViewGroup.LayoutParams layoutParams);
    }

    f(b bVar) {
        this.f6500a = bVar;
    }

    private int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int childCount = this.f6500a.getChildCount();
        int i11 = i10;
        while (i11 < childCount) {
            int b10 = i10 - (i11 - this.f6501b.b(i11));
            if (b10 == 0) {
                while (this.f6501b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += b10;
        }
        return -1;
    }

    private void l(View view) {
        this.f6502c.add(view);
        this.f6500a.b(view);
    }

    private boolean t(View view) {
        if (!this.f6502c.remove(view)) {
            return false;
        }
        this.f6500a.h(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i10, boolean z10) {
        int i11;
        if (i10 < 0) {
            i11 = this.f6500a.getChildCount();
        } else {
            i11 = h(i10);
        }
        this.f6501b.e(i11, z10);
        if (z10) {
            l(view);
        }
        this.f6500a.e(view, i11);
    }

    /* access modifiers changed from: package-private */
    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    /* access modifiers changed from: package-private */
    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int i11;
        if (i10 < 0) {
            i11 = this.f6500a.getChildCount();
        } else {
            i11 = h(i10);
        }
        this.f6501b.e(i11, z10);
        if (z10) {
            l(view);
        }
        this.f6500a.j(view, i11, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void d(int i10) {
        int h10 = h(i10);
        this.f6501b.f(h10);
        this.f6500a.d(h10);
    }

    /* access modifiers changed from: package-private */
    public View e(int i10) {
        int size = this.f6502c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.f6502c.get(i11);
            RecyclerView.d0 c10 = this.f6500a.c(view);
            if (c10.u() == i10 && !c10.C() && !c10.E()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View f(int i10) {
        return this.f6500a.a(h(i10));
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f6500a.getChildCount() - this.f6502c.size();
    }

    /* access modifiers changed from: package-private */
    public View i(int i10) {
        return this.f6500a.a(i10);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f6500a.getChildCount();
    }

    /* access modifiers changed from: package-private */
    public void k(View view) {
        int g10 = this.f6500a.g(view);
        if (g10 >= 0) {
            this.f6501b.h(g10);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public int m(View view) {
        int g10 = this.f6500a.g(view);
        if (g10 != -1 && !this.f6501b.d(g10)) {
            return g10 - this.f6501b.b(g10);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f6502c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f6501b.g();
        for (int size = this.f6502c.size() - 1; size >= 0; size--) {
            this.f6500a.h(this.f6502c.get(size));
            this.f6502c.remove(size);
        }
        this.f6500a.f();
    }

    /* access modifiers changed from: package-private */
    public void p(View view) {
        int g10 = this.f6500a.g(view);
        if (g10 >= 0) {
            if (this.f6501b.f(g10)) {
                t(view);
            }
            this.f6500a.i(g10);
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int i10) {
        int h10 = h(i10);
        View a10 = this.f6500a.a(h10);
        if (a10 != null) {
            if (this.f6501b.f(h10)) {
                t(a10);
            }
            this.f6500a.i(h10);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r(View view) {
        int g10 = this.f6500a.g(view);
        if (g10 == -1) {
            t(view);
            return true;
        } else if (!this.f6501b.d(g10)) {
            return false;
        } else {
            this.f6501b.f(g10);
            t(view);
            this.f6500a.i(g10);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void s(View view) {
        int g10 = this.f6500a.g(view);
        if (g10 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f6501b.d(g10)) {
            this.f6501b.a(g10);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f6501b.toString() + ", hidden list:" + this.f6502c.size();
    }
}
