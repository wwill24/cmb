package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean I = false;
    int J = -1;
    int[] K;
    View[] L;
    final SparseIntArray M = new SparseIntArray();
    final SparseIntArray N = new SparseIntArray();
    c O = new a();
    final Rect P = new Rect();
    private boolean Q;

    public static final class a extends c {
        public int e(int i10, int i11) {
            return i10 % i11;
        }

        public int f(int i10) {
            return 1;
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f6200a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f6201b = new SparseIntArray();

        /* renamed from: c  reason: collision with root package name */
        private boolean f6202c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6203d = false;

        static int a(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 < 0 || i13 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i13);
        }

        /* access modifiers changed from: package-private */
        public int b(int i10, int i11) {
            if (!this.f6203d) {
                return d(i10, i11);
            }
            int i12 = this.f6201b.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int d10 = d(i10, i11);
            this.f6201b.put(i10, d10);
            return d10;
        }

        /* access modifiers changed from: package-private */
        public int c(int i10, int i11) {
            if (!this.f6202c) {
                return e(i10, i11);
            }
            int i12 = this.f6200a.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int e10 = e(i10, i11);
            this.f6200a.put(i10, e10);
            return e10;
        }

        public int d(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int a10;
            if (!this.f6203d || (a10 = a(this.f6201b, i10)) == -1) {
                i14 = 0;
                i13 = 0;
                i12 = 0;
            } else {
                i14 = this.f6201b.get(a10);
                i13 = a10 + 1;
                i12 = c(a10, i11) + f(a10);
                if (i12 == i11) {
                    i14++;
                    i12 = 0;
                }
            }
            int f10 = f(i10);
            while (i13 < i10) {
                int f11 = f(i13);
                int i15 = i12 + f11;
                if (i15 == i11) {
                    i14++;
                    i15 = 0;
                } else if (i15 > i11) {
                    i14++;
                    i15 = f11;
                }
                i13++;
            }
            if (i12 + f10 > i11) {
                return i14 + 1;
            }
            return i14;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.f6202c
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.f6200a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.f6200a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = r1
                r3 = r2
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = r1
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.e(int, int):int");
        }

        public abstract int f(int i10);

        public void g() {
            this.f6201b.clear();
        }

        public void h() {
            this.f6200a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        d3(RecyclerView.o.j0(context, attributeSet, i10, i11).f6356b);
    }

    private void M2(RecyclerView.v vVar, RecyclerView.z zVar, int i10, boolean z10) {
        int i11;
        int i12;
        int i13 = 0;
        int i14 = -1;
        if (z10) {
            i11 = 1;
            i14 = i10;
            i12 = 0;
        } else {
            i12 = i10 - 1;
            i11 = -1;
        }
        while (i12 != i14) {
            View view = this.L[i12];
            b bVar = (b) view.getLayoutParams();
            int Z2 = Z2(vVar, zVar, i0(view));
            bVar.f6199f = Z2;
            bVar.f6198e = i13;
            i13 += Z2;
            i12 += i11;
        }
    }

    private void N2() {
        int K2 = K();
        for (int i10 = 0; i10 < K2; i10++) {
            b bVar = (b) J(i10).getLayoutParams();
            int a10 = bVar.a();
            this.M.put(a10, bVar.f());
            this.N.put(a10, bVar.e());
        }
    }

    private void O2(int i10) {
        this.K = P2(this.K, this.J, i10);
    }

    static int[] P2(int[] iArr, int i10, int i11) {
        int i12;
        if (!(iArr != null && iArr.length == i10 + 1 && iArr[iArr.length - 1] == i11)) {
            iArr = new int[(i10 + 1)];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    private void Q2() {
        this.M.clear();
        this.N.clear();
    }

    private int R2(RecyclerView.z zVar) {
        int i10;
        if (!(K() == 0 || zVar.b() == 0)) {
            U1();
            boolean p22 = p2();
            View Z1 = Z1(!p22, true);
            View Y1 = Y1(!p22, true);
            if (!(Z1 == null || Y1 == null)) {
                int b10 = this.O.b(i0(Z1), this.J);
                int b11 = this.O.b(i0(Y1), this.J);
                int min = Math.min(b10, b11);
                int max = Math.max(b10, b11);
                int b12 = this.O.b(zVar.b() - 1, this.J) + 1;
                if (this.f6209x) {
                    i10 = Math.max(0, (b12 - max) - 1);
                } else {
                    i10 = Math.max(0, min);
                }
                if (!p22) {
                    return i10;
                }
                return Math.round((((float) i10) * (((float) Math.abs(this.f6206u.d(Y1) - this.f6206u.g(Z1))) / ((float) ((this.O.b(i0(Y1), this.J) - this.O.b(i0(Z1), this.J)) + 1)))) + ((float) (this.f6206u.m() - this.f6206u.g(Z1))));
            }
        }
        return 0;
    }

    private int S2(RecyclerView.z zVar) {
        if (!(K() == 0 || zVar.b() == 0)) {
            U1();
            View Z1 = Z1(!p2(), true);
            View Y1 = Y1(!p2(), true);
            if (!(Z1 == null || Y1 == null)) {
                if (!p2()) {
                    return this.O.b(zVar.b() - 1, this.J) + 1;
                }
                int d10 = this.f6206u.d(Y1) - this.f6206u.g(Z1);
                int b10 = this.O.b(i0(Z1), this.J);
                return (int) ((((float) d10) / ((float) ((this.O.b(i0(Y1), this.J) - b10) + 1))) * ((float) (this.O.b(zVar.b() - 1, this.J) + 1)));
            }
        }
        return 0;
    }

    private void T2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i10) {
        boolean z10;
        if (i10 == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int Y2 = Y2(vVar, zVar, aVar.f6216b);
        if (z10) {
            while (Y2 > 0) {
                int i11 = aVar.f6216b;
                if (i11 > 0) {
                    int i12 = i11 - 1;
                    aVar.f6216b = i12;
                    Y2 = Y2(vVar, zVar, i12);
                } else {
                    return;
                }
            }
            return;
        }
        int b10 = zVar.b() - 1;
        int i13 = aVar.f6216b;
        while (i13 < b10) {
            int i14 = i13 + 1;
            int Y22 = Y2(vVar, zVar, i14);
            if (Y22 <= Y2) {
                break;
            }
            i13 = i14;
            Y2 = Y22;
        }
        aVar.f6216b = i13;
    }

    private void U2() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    private int X2(RecyclerView.v vVar, RecyclerView.z zVar, int i10) {
        if (!zVar.e()) {
            return this.O.b(i10, this.J);
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.O.b(f10, this.J);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find span size for pre layout position. ");
        sb2.append(i10);
        return 0;
    }

    private int Y2(RecyclerView.v vVar, RecyclerView.z zVar, int i10) {
        if (!zVar.e()) {
            return this.O.c(i10, this.J);
        }
        int i11 = this.N.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.O.c(f10, this.J);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb2.append(i10);
        return 0;
    }

    private int Z2(RecyclerView.v vVar, RecyclerView.z zVar, int i10) {
        if (!zVar.e()) {
            return this.O.f(i10);
        }
        int i11 = this.M.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.O.f(f10);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb2.append(i10);
        return 1;
    }

    private void a3(float f10, int i10) {
        O2(Math.max(Math.round(f10 * ((float) this.J)), i10));
    }

    private void b3(View view, int i10, boolean z10) {
        int i11;
        int i12;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f6360b;
        int i13 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i14 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int V2 = V2(bVar.f6198e, bVar.f6199f);
        if (this.f6204s == 1) {
            i11 = RecyclerView.o.L(V2, i10, i14, bVar.width, false);
            i12 = RecyclerView.o.L(this.f6206u.n(), Y(), i13, bVar.height, true);
        } else {
            int L2 = RecyclerView.o.L(V2, i10, i13, bVar.height, false);
            int L3 = RecyclerView.o.L(this.f6206u.n(), q0(), i14, bVar.width, true);
            i12 = L2;
            i11 = L3;
        }
        c3(view, i11, i12, z10);
    }

    private void c3(View view, int i10, int i11, boolean z10) {
        boolean z11;
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z10) {
            z11 = I1(view, i10, i11, pVar);
        } else {
            z11 = G1(view, i10, i11, pVar);
        }
        if (z11) {
            view.measure(i10, i11);
        }
    }

    private void f3() {
        int i10;
        int i11;
        if (n2() == 1) {
            i11 = p0() - g0();
            i10 = f0();
        } else {
            i11 = X() - e0();
            i10 = h0();
        }
        O2(i11 - i10);
    }

    public void D1(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        if (this.K == null) {
            super.D1(rect, i10, i11);
        }
        int f02 = f0() + g0();
        int h02 = h0() + e0();
        if (this.f6204s == 1) {
            i13 = RecyclerView.o.o(i11, rect.height() + h02, c0());
            int[] iArr = this.K;
            i12 = RecyclerView.o.o(i10, iArr[iArr.length - 1] + f02, d0());
        } else {
            i12 = RecyclerView.o.o(i10, rect.width() + f02, d0());
            int[] iArr2 = this.K;
            i13 = RecyclerView.o.o(i11, iArr2[iArr2.length - 1] + h02, c0());
        }
        C1(i12, i13);
    }

    public void D2(boolean z10) {
        if (!z10) {
            super.D2(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public RecyclerView.p E() {
        if (this.f6204s == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    public RecyclerView.p F(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public RecyclerView.p G(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == r7) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View K0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.z r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.C(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r5 = (androidx.recyclerview.widget.GridLayoutManager.b) r5
            int r6 = r5.f6198e
            int r5 = r5.f6199f
            int r5 = r5 + r6
            android.view.View r7 = super.K0(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.S1(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = r9
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.f6209x
            if (r7 == r10) goto L_0x0032
            r7 = r9
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.K()
            int r7 = r7 - r9
            r11 = r10
            r12 = r11
            goto L_0x0045
        L_0x003e:
            int r7 = r23.K()
            r11 = r7
            r12 = r9
            r7 = 0
        L_0x0045:
            int r13 = r0.f6204s
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.o2()
            if (r13 == 0) goto L_0x0051
            r13 = r9
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.X2(r1, r2, r7)
            r15 = r10
            r16 = r15
            r8 = 0
            r17 = 0
            r10 = r7
            r7 = r4
        L_0x005e:
            if (r10 == r11) goto L_0x0149
            int r9 = r0.X2(r1, r2, r10)
            android.view.View r1 = r0.J(r10)
            if (r1 != r3) goto L_0x006c
            goto L_0x0149
        L_0x006c:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0086
            if (r9 == r14) goto L_0x0086
            if (r4 == 0) goto L_0x0078
            goto L_0x0149
        L_0x0078:
            r18 = r3
            r21 = r7
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
            goto L_0x0135
        L_0x0086:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r9 = (androidx.recyclerview.widget.GridLayoutManager.b) r9
            int r2 = r9.f6198e
            r18 = r3
            int r3 = r9.f6199f
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009e
            if (r2 != r6) goto L_0x009e
            if (r3 != r5) goto L_0x009e
            return r1
        L_0x009e:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a6
            if (r4 == 0) goto L_0x00ae
        L_0x00a6:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00ba
            if (r7 != 0) goto L_0x00ba
        L_0x00ae:
            r21 = r7
        L_0x00b0:
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
        L_0x00b8:
            r11 = 1
            goto L_0x0105
        L_0x00ba:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d9
            if (r7 <= r8) goto L_0x00cf
        L_0x00ce:
            goto L_0x00b0
        L_0x00cf:
            if (r7 != r8) goto L_0x00fc
            if (r2 <= r15) goto L_0x00d5
            r7 = 1
            goto L_0x00d6
        L_0x00d5:
            r7 = 0
        L_0x00d6:
            if (r13 != r7) goto L_0x00fc
            goto L_0x00ce
        L_0x00d9:
            if (r4 != 0) goto L_0x00fc
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.z0(r1, r8, r11)
            if (r22 == 0) goto L_0x0100
            r8 = r17
            if (r7 <= r8) goto L_0x00ee
            r7 = r16
            goto L_0x0105
        L_0x00ee:
            if (r7 != r8) goto L_0x00f9
            r7 = r16
            if (r2 <= r7) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            if (r13 != r11) goto L_0x0104
            goto L_0x00b8
        L_0x00f9:
            r7 = r16
            goto L_0x0104
        L_0x00fc:
            r19 = r8
            r20 = r11
        L_0x0100:
            r7 = r16
            r8 = r17
        L_0x0104:
            r11 = 0
        L_0x0105:
            if (r11 == 0) goto L_0x0135
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0123
            int r4 = r9.f6198e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x013d
        L_0x0123:
            int r7 = r9.f6198e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x013d
        L_0x0135:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x013d:
            int r10 = r10 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005e
        L_0x0149:
            r21 = r7
            if (r4 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r4 = r21
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.K0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z):android.view.View");
    }

    public boolean M1() {
        return this.D == null && !this.I;
    }

    public int O(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f6204s == 1) {
            return this.J;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return X2(vVar, zVar, zVar.b() - 1) + 1;
    }

    public void O0(@NonNull RecyclerView.v vVar, @NonNull RecyclerView.z zVar, @NonNull k kVar) {
        super.O0(vVar, zVar, kVar);
        kVar.a0(GridView.class.getName());
    }

    /* access modifiers changed from: package-private */
    public void O1(RecyclerView.z zVar, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i10 = this.J;
        for (int i11 = 0; i11 < this.J && cVar.c(zVar) && i10 > 0; i11++) {
            int i12 = cVar.f6227d;
            cVar2.a(i12, Math.max(0, cVar.f6230g));
            i10 -= this.O.f(i12);
            cVar.f6227d += cVar.f6228e;
        }
    }

    public void Q0(RecyclerView.v vVar, RecyclerView.z zVar, View view, k kVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.P0(view, kVar);
            return;
        }
        b bVar = (b) layoutParams;
        int X2 = X2(vVar, zVar, bVar.a());
        if (this.f6204s == 0) {
            kVar.d0(k.c.a(bVar.e(), bVar.f(), X2, 1, false, false));
            return;
        }
        kVar.d0(k.c.a(X2, 1, bVar.e(), bVar.f(), false, false));
    }

    public void S0(RecyclerView recyclerView, int i10, int i11) {
        this.O.h();
        this.O.g();
    }

    public void T0(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    public void U0(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.O.h();
        this.O.g();
    }

    public void V0(RecyclerView recyclerView, int i10, int i11) {
        this.O.h();
        this.O.g();
    }

    /* access modifiers changed from: package-private */
    public int V2(int i10, int i11) {
        if (this.f6204s != 1 || !o2()) {
            int[] iArr = this.K;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.K;
        int i12 = this.J;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    public int W2() {
        return this.J;
    }

    public void X0(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.O.h();
        this.O.g();
    }

    public void Y0(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (zVar.e()) {
            N2();
        }
        super.Y0(vVar, zVar);
        Q2();
    }

    public void Z0(RecyclerView.z zVar) {
        super.Z0(zVar);
        this.I = false;
    }

    public void d3(int i10) {
        if (i10 != this.J) {
            this.I = true;
            if (i10 >= 1) {
                this.J = i10;
                this.O.h();
                u1();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    public void e3(c cVar) {
        this.O = cVar;
    }

    /* access modifiers changed from: package-private */
    public View h2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10, boolean z11) {
        int i10;
        int K2 = K();
        int i11 = -1;
        int i12 = 1;
        if (z11) {
            i10 = K() - 1;
            i12 = -1;
        } else {
            i11 = K2;
            i10 = 0;
        }
        int b10 = zVar.b();
        U1();
        int m10 = this.f6206u.m();
        int i13 = this.f6206u.i();
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View J2 = J(i10);
            int i02 = i0(J2);
            if (i02 >= 0 && i02 < b10 && Y2(vVar, zVar, i02) == 0) {
                if (((RecyclerView.p) J2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = J2;
                    }
                } else if (this.f6206u.g(J2) < i13 && this.f6206u.d(J2) >= m10) {
                    return J2;
                } else {
                    if (view == null) {
                        view = J2;
                    }
                }
            }
            i10 += i12;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    public int l0(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f6204s == 0) {
            return this.J;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return X2(vVar, zVar, zVar.b() - 1) + 1;
    }

    public boolean n(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    /* access modifiers changed from: package-private */
    public void q2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        boolean z10;
        int i10;
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        View d10;
        RecyclerView.v vVar2 = vVar;
        RecyclerView.z zVar2 = zVar;
        LinearLayoutManager.c cVar2 = cVar;
        LinearLayoutManager.b bVar2 = bVar;
        int l10 = this.f6206u.l();
        boolean z12 = false;
        if (l10 != 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (K() > 0) {
            i10 = this.K[this.J];
        } else {
            i10 = 0;
        }
        if (z10) {
            f3();
        }
        if (cVar2.f6228e == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i21 = this.J;
        if (!z11) {
            i21 = Y2(vVar2, zVar2, cVar2.f6227d) + Z2(vVar2, zVar2, cVar2.f6227d);
        }
        int i22 = 0;
        while (i22 < this.J && cVar2.c(zVar2) && i21 > 0) {
            int i23 = cVar2.f6227d;
            int Z2 = Z2(vVar2, zVar2, i23);
            if (Z2 <= this.J) {
                i21 -= Z2;
                if (i21 < 0 || (d10 = cVar2.d(vVar2)) == null) {
                    break;
                }
                this.L[i22] = d10;
                i22++;
            } else {
                throw new IllegalArgumentException("Item at position " + i23 + " requires " + Z2 + " spans but GridLayoutManager has only " + this.J + " spans.");
            }
        }
        if (i22 == 0) {
            bVar2.f6221b = true;
            return;
        }
        float f10 = 0.0f;
        M2(vVar2, zVar2, i22, z11);
        int i24 = 0;
        int i25 = 0;
        while (i24 < i22) {
            View view = this.L[i24];
            if (cVar2.f6235l == null) {
                if (z11) {
                    e(view);
                } else {
                    f(view, z12);
                }
            } else if (z11) {
                c(view);
            } else {
                d(view, z12 ? 1 : 0);
            }
            k(view, this.P);
            b3(view, l10, z12);
            int e10 = this.f6206u.e(view);
            if (e10 > i25) {
                i25 = e10;
            }
            float f11 = (((float) this.f6206u.f(view)) * 1.0f) / ((float) ((b) view.getLayoutParams()).f6199f);
            if (f11 > f10) {
                f10 = f11;
            }
            i24++;
            z12 = false;
        }
        if (z10) {
            a3(f10, i10);
            i25 = 0;
            for (int i26 = 0; i26 < i22; i26++) {
                View view2 = this.L[i26];
                b3(view2, 1073741824, true);
                int e11 = this.f6206u.e(view2);
                if (e11 > i25) {
                    i25 = e11;
                }
            }
        }
        for (int i27 = 0; i27 < i22; i27++) {
            View view3 = this.L[i27];
            if (this.f6206u.e(view3) != i25) {
                b bVar3 = (b) view3.getLayoutParams();
                Rect rect = bVar3.f6360b;
                int i28 = rect.top + rect.bottom + bVar3.topMargin + bVar3.bottomMargin;
                int i29 = rect.left + rect.right + bVar3.leftMargin + bVar3.rightMargin;
                int V2 = V2(bVar3.f6198e, bVar3.f6199f);
                if (this.f6204s == 1) {
                    i20 = RecyclerView.o.L(V2, 1073741824, i29, bVar3.width, false);
                    i19 = View.MeasureSpec.makeMeasureSpec(i25 - i28, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i25 - i29, 1073741824);
                    i19 = RecyclerView.o.L(V2, 1073741824, i28, bVar3.height, false);
                    i20 = makeMeasureSpec;
                }
                c3(view3, i20, i19, true);
            }
        }
        int i30 = 0;
        bVar2.f6220a = i25;
        if (this.f6204s == 1) {
            if (cVar2.f6229f == -1) {
                i14 = cVar2.f6225b;
                i11 = i14 - i25;
            } else {
                int i31 = cVar2.f6225b;
                i11 = i31;
                i14 = i25 + i31;
            }
            i13 = 0;
            i12 = 0;
        } else if (cVar2.f6229f == -1) {
            int i32 = cVar2.f6225b;
            i12 = i32 - i25;
            i11 = 0;
            i13 = i32;
            i14 = 0;
        } else {
            int i33 = cVar2.f6225b;
            i13 = i25 + i33;
            i12 = i33;
            i14 = 0;
            i11 = 0;
        }
        while (i30 < i22) {
            View view4 = this.L[i30];
            b bVar4 = (b) view4.getLayoutParams();
            if (this.f6204s == 1) {
                if (o2()) {
                    int f02 = f0() + this.K[this.J - bVar4.f6198e];
                    i18 = i14;
                    i17 = f02;
                    i16 = f02 - this.f6206u.f(view4);
                } else {
                    int f03 = f0() + this.K[bVar4.f6198e];
                    i18 = i14;
                    i16 = f03;
                    i17 = this.f6206u.f(view4) + f03;
                }
                i15 = i11;
            } else {
                int h02 = h0() + this.K[bVar4.f6198e];
                i15 = h02;
                i17 = i13;
                i16 = i12;
                i18 = this.f6206u.f(view4) + h02;
            }
            A0(view4, i16, i15, i17, i18);
            if (bVar4.c() || bVar4.b()) {
                bVar2.f6222c = true;
            }
            bVar2.f6223d |= view4.hasFocusable();
            i30++;
            i14 = i18;
            i13 = i17;
            i12 = i16;
            i11 = i15;
        }
        Arrays.fill(this.L, (Object) null);
    }

    public int s(RecyclerView.z zVar) {
        if (this.Q) {
            return R2(zVar);
        }
        return super.s(zVar);
    }

    /* access modifiers changed from: package-private */
    public void s2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i10) {
        super.s2(vVar, zVar, aVar, i10);
        f3();
        if (zVar.b() > 0 && !zVar.e()) {
            T2(vVar, zVar, aVar, i10);
        }
        U2();
    }

    public int t(RecyclerView.z zVar) {
        if (this.Q) {
            return S2(zVar);
        }
        return super.t(zVar);
    }

    public int v(RecyclerView.z zVar) {
        if (this.Q) {
            return R2(zVar);
        }
        return super.v(zVar);
    }

    public int w(RecyclerView.z zVar) {
        if (this.Q) {
            return S2(zVar);
        }
        return super.w(zVar);
    }

    public int x1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        f3();
        U2();
        return super.x1(i10, vVar, zVar);
    }

    public int z1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        f3();
        U2();
        return super.z1(i10, vVar, zVar);
    }

    public static class b extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        int f6198e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f6199f = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int e() {
            return this.f6198e;
        }

        public int f() {
            return this.f6199f;
        }

        public b(int i10, int i11) {
            super(i10, i11);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        d3(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        d3(i10);
    }
}
