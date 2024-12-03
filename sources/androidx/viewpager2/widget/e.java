package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class e extends RecyclerView.t {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager2.i f7302a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f7303b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f7304c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayoutManager f7305d;

    /* renamed from: e  reason: collision with root package name */
    private int f7306e;

    /* renamed from: f  reason: collision with root package name */
    private int f7307f;

    /* renamed from: g  reason: collision with root package name */
    private a f7308g = new a();

    /* renamed from: h  reason: collision with root package name */
    private int f7309h;

    /* renamed from: i  reason: collision with root package name */
    private int f7310i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7311j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7312k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7313l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f7314m;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f7315a;

        /* renamed from: b  reason: collision with root package name */
        float f7316b;

        /* renamed from: c  reason: collision with root package name */
        int f7317c;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f7315a = -1;
            this.f7316b = 0.0f;
            this.f7317c = 0;
        }
    }

    e(@NonNull ViewPager2 viewPager2) {
        this.f7303b = viewPager2;
        RecyclerView recyclerView = viewPager2.f7263k;
        this.f7304c = recyclerView;
        this.f7305d = (LinearLayoutManager) recyclerView.getLayoutManager();
        n();
    }

    private void c(int i10, float f10, int i11) {
        ViewPager2.i iVar = this.f7302a;
        if (iVar != null) {
            iVar.b(i10, f10, i11);
        }
    }

    private void d(int i10) {
        ViewPager2.i iVar = this.f7302a;
        if (iVar != null) {
            iVar.c(i10);
        }
    }

    private void e(int i10) {
        if ((this.f7306e != 3 || this.f7307f != 0) && this.f7307f != i10) {
            this.f7307f = i10;
            ViewPager2.i iVar = this.f7302a;
            if (iVar != null) {
                iVar.a(i10);
            }
        }
    }

    private int f() {
        return this.f7305d.a2();
    }

    private boolean k() {
        int i10 = this.f7306e;
        return i10 == 1 || i10 == 4;
    }

    private void n() {
        this.f7306e = 0;
        this.f7307f = 0;
        this.f7308g.a();
        this.f7309h = -1;
        this.f7310i = -1;
        this.f7311j = false;
        this.f7312k = false;
        this.f7314m = false;
        this.f7313l = false;
    }

    private void p(boolean z10) {
        int i10;
        this.f7314m = z10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 1;
        }
        this.f7306e = i10;
        int i11 = this.f7310i;
        if (i11 != -1) {
            this.f7309h = i11;
            this.f7310i = -1;
        } else if (this.f7309h == -1) {
            this.f7309h = f();
        }
        e(1);
    }

    private void q() {
        boolean z10;
        int i10;
        float f10;
        a aVar = this.f7308g;
        int a22 = this.f7305d.a2();
        aVar.f7315a = a22;
        if (a22 == -1) {
            aVar.a();
            return;
        }
        View D = this.f7305d.D(a22);
        if (D == null) {
            aVar.a();
            return;
        }
        int b02 = this.f7305d.b0(D);
        int k02 = this.f7305d.k0(D);
        int n02 = this.f7305d.n0(D);
        int I = this.f7305d.I(D);
        ViewGroup.LayoutParams layoutParams = D.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            b02 += marginLayoutParams.leftMargin;
            k02 += marginLayoutParams.rightMargin;
            n02 += marginLayoutParams.topMargin;
            I += marginLayoutParams.bottomMargin;
        }
        int height = D.getHeight() + n02 + I;
        int width = D.getWidth() + b02 + k02;
        if (this.f7305d.n2() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = (D.getLeft() - b02) - this.f7304c.getPaddingLeft();
            if (this.f7303b.d()) {
                i10 = -i10;
            }
            height = width;
        } else {
            i10 = (D.getTop() - n02) - this.f7304c.getPaddingTop();
        }
        int i11 = -i10;
        aVar.f7317c = i11;
        if (i11 >= 0) {
            if (height == 0) {
                f10 = 0.0f;
            } else {
                f10 = ((float) i11) / ((float) height);
            }
            aVar.f7316b = f10;
        } else if (new a(this.f7305d).d()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(aVar.f7317c)}));
        }
    }

    public void a(@NonNull RecyclerView recyclerView, int i10) {
        boolean z10 = true;
        if (!(this.f7306e == 1 && this.f7307f == 1) && i10 == 1) {
            p(false);
        } else if (!k() || i10 != 2) {
            if (k() && i10 == 0) {
                q();
                if (!this.f7312k) {
                    int i11 = this.f7308g.f7315a;
                    if (i11 != -1) {
                        c(i11, 0.0f, 0);
                    }
                } else {
                    a aVar = this.f7308g;
                    if (aVar.f7317c == 0) {
                        int i12 = this.f7309h;
                        int i13 = aVar.f7315a;
                        if (i12 != i13) {
                            d(i13);
                        }
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    e(0);
                    n();
                }
            }
            if (this.f7306e == 2 && i10 == 0 && this.f7313l) {
                q();
                a aVar2 = this.f7308g;
                if (aVar2.f7317c == 0) {
                    int i14 = this.f7310i;
                    int i15 = aVar2.f7315a;
                    if (i14 != i15) {
                        if (i15 == -1) {
                            i15 = 0;
                        }
                        d(i15);
                    }
                    e(0);
                    n();
                }
            }
        } else if (this.f7312k) {
            e(2);
            this.f7311j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r5 == r3.f7303b.d()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f7312k = r4
            r3.q()
            boolean r0 = r3.f7311j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L_0x003d
            r3.f7311j = r2
            if (r6 > 0) goto L_0x0022
            if (r6 != 0) goto L_0x0020
            if (r5 >= 0) goto L_0x0016
            r5 = r4
            goto L_0x0017
        L_0x0016:
            r5 = r2
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f7303b
            boolean r6 = r6.d()
            if (r5 != r6) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r5 = r2
            goto L_0x0023
        L_0x0022:
            r5 = r4
        L_0x0023:
            if (r5 == 0) goto L_0x002f
            androidx.viewpager2.widget.e$a r5 = r3.f7308g
            int r6 = r5.f7317c
            if (r6 == 0) goto L_0x002f
            int r5 = r5.f7315a
            int r5 = r5 + r4
            goto L_0x0033
        L_0x002f:
            androidx.viewpager2.widget.e$a r5 = r3.f7308g
            int r5 = r5.f7315a
        L_0x0033:
            r3.f7310i = r5
            int r6 = r3.f7309h
            if (r6 == r5) goto L_0x004b
            r3.d(r5)
            goto L_0x004b
        L_0x003d:
            int r5 = r3.f7306e
            if (r5 != 0) goto L_0x004b
            androidx.viewpager2.widget.e$a r5 = r3.f7308g
            int r5 = r5.f7315a
            if (r5 != r1) goto L_0x0048
            r5 = r2
        L_0x0048:
            r3.d(r5)
        L_0x004b:
            androidx.viewpager2.widget.e$a r5 = r3.f7308g
            int r6 = r5.f7315a
            if (r6 != r1) goto L_0x0052
            r6 = r2
        L_0x0052:
            float r0 = r5.f7316b
            int r5 = r5.f7317c
            r3.c(r6, r0, r5)
            androidx.viewpager2.widget.e$a r5 = r3.f7308g
            int r6 = r5.f7315a
            int r0 = r3.f7310i
            if (r6 == r0) goto L_0x0063
            if (r0 != r1) goto L_0x0071
        L_0x0063:
            int r5 = r5.f7317c
            if (r5 != 0) goto L_0x0071
            int r5 = r3.f7307f
            if (r5 == r4) goto L_0x0071
            r3.e(r2)
            r3.n()
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public double g() {
        q();
        a aVar = this.f7308g;
        return ((double) aVar.f7315a) + ((double) aVar.f7316b);
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f7307f;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f7314m;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.f7307f == 0;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f7313l = true;
    }

    /* access modifiers changed from: package-private */
    public void m(int i10, boolean z10) {
        int i11;
        if (z10) {
            i11 = 2;
        } else {
            i11 = 3;
        }
        this.f7306e = i11;
        boolean z11 = false;
        this.f7314m = false;
        if (this.f7310i != i10) {
            z11 = true;
        }
        this.f7310i = i10;
        e(2);
        if (z11) {
            d(i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void o(ViewPager2.i iVar) {
        this.f7302a = iVar;
    }
}
