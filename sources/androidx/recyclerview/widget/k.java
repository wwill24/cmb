package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.os.m;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class k implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    static final ThreadLocal<k> f6616e = new ThreadLocal<>();

    /* renamed from: f  reason: collision with root package name */
    static Comparator<c> f6617f = new a();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<RecyclerView> f6618a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    long f6619b;

    /* renamed from: c  reason: collision with root package name */
    long f6620c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<c> f6621d = new ArrayList<>();

    class a implements Comparator<c> {
        a() {
        }

        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            boolean z10;
            boolean z11;
            RecyclerView recyclerView = cVar.f6629d;
            if (recyclerView == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (cVar2.f6629d == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 == z11) {
                boolean z12 = cVar.f6626a;
                if (z12 == cVar2.f6626a) {
                    int i10 = cVar2.f6627b - cVar.f6627b;
                    if (i10 != 0) {
                        return i10;
                    }
                    int i11 = cVar.f6628c - cVar2.f6628c;
                    if (i11 != 0) {
                        return i11;
                    }
                    return 0;
                } else if (z12) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (recyclerView == null) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    @SuppressLint({"VisibleForTests"})
    static class b implements RecyclerView.o.c {

        /* renamed from: a  reason: collision with root package name */
        int f6622a;

        /* renamed from: b  reason: collision with root package name */
        int f6623b;

        /* renamed from: c  reason: collision with root package name */
        int[] f6624c;

        /* renamed from: d  reason: collision with root package name */
        int f6625d;

        b() {
        }

        public void a(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i11 >= 0) {
                int i12 = this.f6625d * 2;
                int[] iArr = this.f6624c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f6624c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i12 >= iArr.length) {
                    int[] iArr3 = new int[(i12 * 2)];
                    this.f6624c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f6624c;
                iArr4[i12] = i10;
                iArr4[i12 + 1] = i11;
                this.f6625d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f6624c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f6625d = 0;
        }

        /* access modifiers changed from: package-private */
        public void c(RecyclerView recyclerView, boolean z10) {
            this.f6625d = 0;
            int[] iArr = this.f6624c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f6265p;
            if (recyclerView.f6262n != null && oVar != null && oVar.v0()) {
                if (z10) {
                    if (!recyclerView.f6245e.p()) {
                        oVar.q(recyclerView.f6262n.g(), this);
                    }
                } else if (!recyclerView.t0()) {
                    oVar.p(this.f6622a, this.f6623b, recyclerView.f6268q0, this);
                }
                int i10 = this.f6625d;
                if (i10 > oVar.f6347m) {
                    oVar.f6347m = i10;
                    oVar.f6348n = z10;
                    recyclerView.f6241c.P();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i10) {
            if (this.f6624c != null) {
                int i11 = this.f6625d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f6624c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, int i11) {
            this.f6622a = i10;
            this.f6623b = i11;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6626a;

        /* renamed from: b  reason: collision with root package name */
        public int f6627b;

        /* renamed from: c  reason: collision with root package name */
        public int f6628c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f6629d;

        /* renamed from: e  reason: collision with root package name */
        public int f6630e;

        c() {
        }

        public void a() {
            this.f6626a = false;
            this.f6627b = 0;
            this.f6628c = 0;
            this.f6629d = null;
            this.f6630e = 0;
        }
    }

    k() {
    }

    private void b() {
        c cVar;
        boolean z10;
        int size = this.f6618a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = this.f6618a.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f6266p0.c(recyclerView, false);
                i10 += recyclerView.f6266p0.f6625d;
            }
        }
        this.f6621d.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = this.f6618a.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f6266p0;
                int abs = Math.abs(bVar.f6622a) + Math.abs(bVar.f6623b);
                for (int i14 = 0; i14 < bVar.f6625d * 2; i14 += 2) {
                    if (i12 >= this.f6621d.size()) {
                        cVar = new c();
                        this.f6621d.add(cVar);
                    } else {
                        cVar = this.f6621d.get(i12);
                    }
                    int[] iArr = bVar.f6624c;
                    int i15 = iArr[i14 + 1];
                    if (i15 <= abs) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    cVar.f6626a = z10;
                    cVar.f6627b = abs;
                    cVar.f6628c = i15;
                    cVar.f6629d = recyclerView2;
                    cVar.f6630e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f6621d, f6617f);
    }

    private void c(c cVar, long j10) {
        long j11;
        if (cVar.f6626a) {
            j11 = Long.MAX_VALUE;
        } else {
            j11 = j10;
        }
        RecyclerView.d0 i10 = i(cVar.f6629d, cVar.f6630e, j11);
        if (i10 != null && i10.f6303b != null && i10.B() && !i10.C()) {
            h(i10.f6303b.get(), j10);
        }
    }

    private void d(long j10) {
        int i10 = 0;
        while (i10 < this.f6621d.size()) {
            c cVar = this.f6621d.get(i10);
            if (cVar.f6629d != null) {
                c(cVar, j10);
                cVar.a();
                i10++;
            } else {
                return;
            }
        }
    }

    static boolean e(RecyclerView recyclerView, int i10) {
        int j10 = recyclerView.f6247f.j();
        for (int i11 = 0; i11 < j10; i11++) {
            RecyclerView.d0 l02 = RecyclerView.l0(recyclerView.f6247f.i(i11));
            if (l02.f6304c == i10 && !l02.C()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j10) {
        if (recyclerView != null) {
            if (recyclerView.M && recyclerView.f6247f.j() != 0) {
                recyclerView.e1();
            }
            b bVar = recyclerView.f6266p0;
            bVar.c(recyclerView, true);
            if (bVar.f6625d != 0) {
                try {
                    m.a("RV Nested Prefetch");
                    recyclerView.f6268q0.f(recyclerView.f6262n);
                    for (int i10 = 0; i10 < bVar.f6625d * 2; i10 += 2) {
                        i(recyclerView, bVar.f6624c[i10], j10);
                    }
                } finally {
                    m.b();
                }
            }
        }
    }

    private RecyclerView.d0 i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f6241c;
        try {
            recyclerView.O0();
            RecyclerView.d0 N = vVar.N(i10, false, j10);
            if (N != null) {
                if (!N.B() || N.C()) {
                    vVar.a(N, false);
                } else {
                    vVar.G(N.f6302a);
                }
            }
            return N;
        } finally {
            recyclerView.Q0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f6618a.add(recyclerView);
    }

    /* access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f6619b == 0) {
            this.f6619b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f6266p0.e(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public void g(long j10) {
        b();
        d(j10);
    }

    public void j(RecyclerView recyclerView) {
        this.f6618a.remove(recyclerView);
    }

    public void run() {
        try {
            m.a("RV Prefetch");
            if (!this.f6618a.isEmpty()) {
                int size = this.f6618a.size();
                long j10 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = this.f6618a.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j10 = Math.max(recyclerView.getDrawingTime(), j10);
                    }
                }
                if (j10 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j10) + this.f6620c);
                    this.f6619b = 0;
                    m.b();
                }
            }
        } finally {
            this.f6619b = 0;
            m.b();
        }
    }
}
