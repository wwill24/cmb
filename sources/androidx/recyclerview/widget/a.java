package androidx.recyclerview.widget;

import androidx.core.util.e;
import androidx.core.util.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import java.util.ArrayList;
import java.util.List;

final class a implements s.a {

    /* renamed from: a  reason: collision with root package name */
    private e<b> f6451a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f6452b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<b> f6453c;

    /* renamed from: d  reason: collision with root package name */
    final C0070a f6454d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f6455e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f6456f;

    /* renamed from: g  reason: collision with root package name */
    final s f6457g;

    /* renamed from: h  reason: collision with root package name */
    private int f6458h;

    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    interface C0070a {
        void a(int i10, int i11);

        void b(b bVar);

        void c(b bVar);

        void d(int i10, int i11);

        void e(int i10, int i11, Object obj);

        RecyclerView.d0 f(int i10);

        void g(int i10, int i11);

        void h(int i10, int i11);
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f6459a;

        /* renamed from: b  reason: collision with root package name */
        int f6460b;

        /* renamed from: c  reason: collision with root package name */
        Object f6461c;

        /* renamed from: d  reason: collision with root package name */
        int f6462d;

        b(int i10, int i11, int i12, Object obj) {
            this.f6459a = i10;
            this.f6460b = i11;
            this.f6462d = i12;
            this.f6461c = obj;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            int i10 = this.f6459a;
            return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f6459a;
            if (i10 != bVar.f6459a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f6462d - this.f6460b) == 1 && this.f6462d == bVar.f6460b && this.f6460b == bVar.f6462d) {
                return true;
            }
            if (this.f6462d != bVar.f6462d || this.f6460b != bVar.f6460b) {
                return false;
            }
            Object obj2 = this.f6461c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f6461c)) {
                    return false;
                }
            } else if (bVar.f6461c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f6459a * 31) + this.f6460b) * 31) + this.f6462d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f6460b + "c:" + this.f6462d + ",p:" + this.f6461c + "]";
        }
    }

    a(C0070a aVar) {
        this(aVar, false);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        char c10;
        boolean z10;
        boolean z11;
        int i10 = bVar.f6460b;
        int i11 = bVar.f6462d + i10;
        char c11 = 65535;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f6454d.f(i12) != null || h(i12)) {
                if (c11 == 0) {
                    k(a(2, i10, i13, (Object) null));
                    z11 = true;
                } else {
                    z11 = false;
                }
                c10 = 1;
            } else {
                if (c11 == 1) {
                    v(a(2, i10, i13, (Object) null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c11 = c10;
        }
        if (i13 != bVar.f6462d) {
            b(bVar);
            bVar = a(2, i10, i13, (Object) null);
        }
        if (c11 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i10 = bVar.f6460b;
        int i11 = bVar.f6462d + i10;
        int i12 = 0;
        boolean z10 = true;
        int i13 = i10;
        while (i10 < i11) {
            if (this.f6454d.f(i10) != null || h(i10)) {
                if (!z10) {
                    k(a(4, i13, i12, bVar.f6461c));
                    i13 = i10;
                    i12 = 0;
                }
                z10 = true;
            } else {
                if (z10) {
                    v(a(4, i13, i12, bVar.f6461c));
                    i13 = i10;
                    i12 = 0;
                }
                z10 = false;
            }
            i12++;
            i10++;
        }
        if (i12 != bVar.f6462d) {
            Object obj = bVar.f6461c;
            b(bVar);
            bVar = a(4, i13, i12, obj);
        }
        if (!z10) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private boolean h(int i10) {
        int size = this.f6453c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f6453c.get(i11);
            int i12 = bVar.f6459a;
            if (i12 == 8) {
                if (n(bVar.f6462d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f6460b;
                int i14 = bVar.f6462d + i13;
                while (i13 < i14) {
                    if (n(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i10;
        boolean z10;
        int i11 = bVar.f6459a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z11 = z(bVar.f6460b, i11);
        int i12 = bVar.f6460b;
        int i13 = bVar.f6459a;
        if (i13 == 2) {
            i10 = 0;
        } else if (i13 == 4) {
            i10 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f6462d; i15++) {
            int z12 = z(bVar.f6460b + (i10 * i15), bVar.f6459a);
            int i16 = bVar.f6459a;
            if (i16 == 2 ? z12 != z11 : !(i16 == 4 && z12 == z11 + 1)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                i14++;
            } else {
                b a10 = a(i16, z11, i14, bVar.f6461c);
                l(a10, i12);
                b(a10);
                if (bVar.f6459a == 4) {
                    i12 += i14;
                }
                i14 = 1;
                z11 = z12;
            }
        }
        Object obj = bVar.f6461c;
        b(bVar);
        if (i14 > 0) {
            b a11 = a(bVar.f6459a, z11, i14, obj);
            l(a11, i12);
            b(a11);
        }
    }

    private void v(b bVar) {
        this.f6453c.add(bVar);
        int i10 = bVar.f6459a;
        if (i10 == 1) {
            this.f6454d.g(bVar.f6460b, bVar.f6462d);
        } else if (i10 == 2) {
            this.f6454d.d(bVar.f6460b, bVar.f6462d);
        } else if (i10 == 4) {
            this.f6454d.e(bVar.f6460b, bVar.f6462d, bVar.f6461c);
        } else if (i10 == 8) {
            this.f6454d.a(bVar.f6460b, bVar.f6462d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f6453c.size() - 1; size >= 0; size--) {
            b bVar = this.f6453c.get(size);
            int i14 = bVar.f6459a;
            if (i14 == 8) {
                int i15 = bVar.f6460b;
                int i16 = bVar.f6462d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            bVar.f6460b = i15 + 1;
                            bVar.f6462d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f6460b = i15 - 1;
                            bVar.f6462d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f6462d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f6462d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f6460b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f6460b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f6460b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f6462d;
                    } else if (i14 == 2) {
                        i10 += bVar.f6462d;
                    }
                } else if (i11 == 1) {
                    bVar.f6460b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f6460b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f6453c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f6453c.get(size2);
            if (bVar2.f6459a == 8) {
                int i18 = bVar2.f6462d;
                if (i18 == bVar2.f6460b || i18 < 0) {
                    this.f6453c.remove(size2);
                    b(bVar2);
                }
            } else if (bVar2.f6462d <= 0) {
                this.f6453c.remove(size2);
                b(bVar2);
            }
        }
        return i10;
    }

    public b a(int i10, int i11, int i12, Object obj) {
        b acquire = this.f6451a.acquire();
        if (acquire == null) {
            return new b(i10, i11, i12, obj);
        }
        acquire.f6459a = i10;
        acquire.f6460b = i11;
        acquire.f6462d = i12;
        acquire.f6461c = obj;
        return acquire;
    }

    public void b(b bVar) {
        if (!this.f6456f) {
            bVar.f6461c = null;
            this.f6451a.a(bVar);
        }
    }

    public int e(int i10) {
        int size = this.f6452b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f6452b.get(i11);
            int i12 = bVar.f6459a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f6460b;
                    if (i13 <= i10) {
                        int i14 = bVar.f6462d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f6460b;
                    if (i15 == i10) {
                        i10 = bVar.f6462d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f6462d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f6460b <= i10) {
                i10 += bVar.f6462d;
            }
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        int size = this.f6453c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f6454d.c(this.f6453c.get(i10));
        }
        x(this.f6453c);
        this.f6458h = 0;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f6452b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f6452b.get(i10);
            int i11 = bVar.f6459a;
            if (i11 == 1) {
                this.f6454d.c(bVar);
                this.f6454d.g(bVar.f6460b, bVar.f6462d);
            } else if (i11 == 2) {
                this.f6454d.c(bVar);
                this.f6454d.h(bVar.f6460b, bVar.f6462d);
            } else if (i11 == 4) {
                this.f6454d.c(bVar);
                this.f6454d.e(bVar.f6460b, bVar.f6462d, bVar.f6461c);
            } else if (i11 == 8) {
                this.f6454d.c(bVar);
                this.f6454d.a(bVar.f6460b, bVar.f6462d);
            }
            Runnable runnable = this.f6455e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f6452b);
        this.f6458h = 0;
    }

    /* access modifiers changed from: package-private */
    public void l(b bVar, int i10) {
        this.f6454d.b(bVar);
        int i11 = bVar.f6459a;
        if (i11 == 2) {
            this.f6454d.h(i10, bVar.f6462d);
        } else if (i11 == 4) {
            this.f6454d.e(i10, bVar.f6462d, bVar.f6461c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    public int m(int i10) {
        return n(i10, 0);
    }

    /* access modifiers changed from: package-private */
    public int n(int i10, int i11) {
        int size = this.f6453c.size();
        while (i11 < size) {
            b bVar = this.f6453c.get(i11);
            int i12 = bVar.f6459a;
            if (i12 == 8) {
                int i13 = bVar.f6460b;
                if (i13 == i10) {
                    i10 = bVar.f6462d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f6462d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f6460b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f6462d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f6462d;
                }
            }
            i11++;
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public boolean o(int i10) {
        return (i10 & this.f6458h) != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f6452b.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return !this.f6453c.isEmpty() && !this.f6452b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean r(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f6452b.add(a(4, i10, i11, obj));
        this.f6458h |= 4;
        if (this.f6452b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean s(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f6452b.add(a(1, i10, i11, (Object) null));
        this.f6458h |= 1;
        if (this.f6452b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean t(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 == 1) {
            this.f6452b.add(a(8, i10, i11, (Object) null));
            this.f6458h |= 8;
            if (this.f6452b.size() == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: package-private */
    public boolean u(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f6452b.add(a(2, i10, i11, (Object) null));
        this.f6458h |= 2;
        if (this.f6452b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.f6457g.b(this.f6452b);
        int size = this.f6452b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f6452b.get(i10);
            int i11 = bVar.f6459a;
            if (i11 == 1) {
                c(bVar);
            } else if (i11 == 2) {
                f(bVar);
            } else if (i11 == 4) {
                g(bVar);
            } else if (i11 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f6455e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f6452b.clear();
    }

    /* access modifiers changed from: package-private */
    public void x(List<b> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            b(list.get(i10));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    public void y() {
        x(this.f6452b);
        x(this.f6453c);
        this.f6458h = 0;
    }

    a(C0070a aVar, boolean z10) {
        this.f6451a = new f(30);
        this.f6452b = new ArrayList<>();
        this.f6453c = new ArrayList<>();
        this.f6458h = 0;
        this.f6454d = aVar;
        this.f6456f = z10;
        this.f6457g = new s(this);
    }
}
