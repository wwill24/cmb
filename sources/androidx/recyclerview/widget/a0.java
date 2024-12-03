package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.e;
import androidx.collection.g;
import androidx.core.util.f;
import androidx.recyclerview.widget.RecyclerView;

class a0 {

    /* renamed from: a  reason: collision with root package name */
    final g<RecyclerView.d0, a> f6463a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    final e<RecyclerView.d0> f6464b = new e<>();

    static class a {

        /* renamed from: d  reason: collision with root package name */
        static androidx.core.util.e<a> f6465d = new f(20);

        /* renamed from: a  reason: collision with root package name */
        int f6466a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.l.c f6467b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.l.c f6468c;

        private a() {
        }

        static void a() {
            do {
            } while (f6465d.acquire() != null);
        }

        static a b() {
            a acquire = f6465d.acquire();
            if (acquire == null) {
                return new a();
            }
            return acquire;
        }

        static void c(a aVar) {
            aVar.f6466a = 0;
            aVar.f6467b = null;
            aVar.f6468c = null;
            f6465d.a(aVar);
        }
    }

    interface b {
        void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void b(RecyclerView.d0 d0Var);

        void c(RecyclerView.d0 d0Var, @NonNull RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.d0 d0Var, @NonNull RecyclerView.l.c cVar, @NonNull RecyclerView.l.c cVar2);
    }

    a0() {
    }

    private RecyclerView.l.c l(RecyclerView.d0 d0Var, int i10) {
        a n10;
        RecyclerView.l.c cVar;
        int f10 = this.f6463a.f(d0Var);
        if (f10 >= 0 && (n10 = this.f6463a.n(f10)) != null) {
            int i11 = n10.f6466a;
            if ((i11 & i10) != 0) {
                int i12 = (~i10) & i11;
                n10.f6466a = i12;
                if (i10 == 4) {
                    cVar = n10.f6467b;
                } else if (i10 == 8) {
                    cVar = n10.f6468c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i12 & 12) == 0) {
                    this.f6463a.l(f10);
                    a.c(n10);
                }
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f6463a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f6463a.put(d0Var, aVar);
        }
        aVar.f6466a |= 2;
        aVar.f6467b = cVar;
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.d0 d0Var) {
        a aVar = this.f6463a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f6463a.put(d0Var, aVar);
        }
        aVar.f6466a |= 1;
    }

    /* access modifiers changed from: package-private */
    public void c(long j10, RecyclerView.d0 d0Var) {
        this.f6464b.l(j10, d0Var);
    }

    /* access modifiers changed from: package-private */
    public void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f6463a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f6463a.put(d0Var, aVar);
        }
        aVar.f6468c = cVar;
        aVar.f6466a |= 8;
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f6463a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f6463a.put(d0Var, aVar);
        }
        aVar.f6467b = cVar;
        aVar.f6466a |= 4;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f6463a.clear();
        this.f6464b.a();
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.d0 g(long j10) {
        return this.f6464b.e(j10);
    }

    /* access modifiers changed from: package-private */
    public boolean h(RecyclerView.d0 d0Var) {
        a aVar = this.f6463a.get(d0Var);
        if (aVar == null || (aVar.f6466a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean i(RecyclerView.d0 d0Var) {
        a aVar = this.f6463a.get(d0Var);
        if (aVar == null || (aVar.f6466a & 4) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.l.c m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.l.c n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    /* access modifiers changed from: package-private */
    public void o(b bVar) {
        for (int size = this.f6463a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 j10 = this.f6463a.j(size);
            a l10 = this.f6463a.l(size);
            int i10 = l10.f6466a;
            if ((i10 & 3) == 3) {
                bVar.b(j10);
            } else if ((i10 & 1) != 0) {
                RecyclerView.l.c cVar = l10.f6467b;
                if (cVar == null) {
                    bVar.b(j10);
                } else {
                    bVar.c(j10, cVar, l10.f6468c);
                }
            } else if ((i10 & 14) == 14) {
                bVar.a(j10, l10.f6467b, l10.f6468c);
            } else if ((i10 & 12) == 12) {
                bVar.d(j10, l10.f6467b, l10.f6468c);
            } else if ((i10 & 4) != 0) {
                bVar.c(j10, l10.f6467b, (RecyclerView.l.c) null);
            } else if ((i10 & 8) != 0) {
                bVar.a(j10, l10.f6467b, l10.f6468c);
            }
            a.c(l10);
        }
    }

    /* access modifiers changed from: package-private */
    public void p(RecyclerView.d0 d0Var) {
        a aVar = this.f6463a.get(d0Var);
        if (aVar != null) {
            aVar.f6466a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void q(RecyclerView.d0 d0Var) {
        int q10 = this.f6464b.q() - 1;
        while (true) {
            if (q10 < 0) {
                break;
            } else if (d0Var == this.f6464b.r(q10)) {
                this.f6464b.p(q10);
                break;
            } else {
                q10--;
            }
        }
        a remove = this.f6463a.remove(d0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}
