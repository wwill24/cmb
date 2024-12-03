package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    boolean A = false;
    private BitSet B;
    int C = -1;
    int D = Integer.MIN_VALUE;
    LazySpanLookup E = new LazySpanLookup();
    private int F = 2;
    private boolean G;
    private boolean H;
    private SavedState I;
    private int J;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private int[] O;
    private final Runnable P = new a();

    /* renamed from: s  reason: collision with root package name */
    private int f6411s = -1;

    /* renamed from: t  reason: collision with root package name */
    d[] f6412t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    t f6413u;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    t f6414v;

    /* renamed from: w  reason: collision with root package name */
    private int f6415w;

    /* renamed from: x  reason: collision with root package name */
    private int f6416x;
    @NonNull

    /* renamed from: y  reason: collision with root package name */
    private final o f6417y;

    /* renamed from: z  reason: collision with root package name */
    boolean f6418z = false;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f6425a;

        /* renamed from: b  reason: collision with root package name */
        int f6426b;

        /* renamed from: c  reason: collision with root package name */
        int f6427c;

        /* renamed from: d  reason: collision with root package name */
        int[] f6428d;

        /* renamed from: e  reason: collision with root package name */
        int f6429e;

        /* renamed from: f  reason: collision with root package name */
        int[] f6430f;

        /* renamed from: g  reason: collision with root package name */
        List<LazySpanLookup.FullSpanItem> f6431g;

        /* renamed from: h  reason: collision with root package name */
        boolean f6432h;

        /* renamed from: j  reason: collision with root package name */
        boolean f6433j;

        /* renamed from: k  reason: collision with root package name */
        boolean f6434k;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f6428d = null;
            this.f6427c = 0;
            this.f6425a = -1;
            this.f6426b = -1;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f6428d = null;
            this.f6427c = 0;
            this.f6429e = 0;
            this.f6430f = null;
            this.f6431g = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f6425a);
            parcel.writeInt(this.f6426b);
            parcel.writeInt(this.f6427c);
            if (this.f6427c > 0) {
                parcel.writeIntArray(this.f6428d);
            }
            parcel.writeInt(this.f6429e);
            if (this.f6429e > 0) {
                parcel.writeIntArray(this.f6430f);
            }
            parcel.writeInt(this.f6432h ? 1 : 0);
            parcel.writeInt(this.f6433j ? 1 : 0);
            parcel.writeInt(this.f6434k ? 1 : 0);
            parcel.writeList(this.f6431g);
        }

        SavedState(Parcel parcel) {
            this.f6425a = parcel.readInt();
            this.f6426b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f6427c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f6428d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f6429e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f6430f = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z10 = false;
            this.f6432h = parcel.readInt() == 1;
            this.f6433j = parcel.readInt() == 1;
            this.f6434k = parcel.readInt() == 1 ? true : z10;
            this.f6431g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f6427c = savedState.f6427c;
            this.f6425a = savedState.f6425a;
            this.f6426b = savedState.f6426b;
            this.f6428d = savedState.f6428d;
            this.f6429e = savedState.f6429e;
            this.f6430f = savedState.f6430f;
            this.f6432h = savedState.f6432h;
            this.f6433j = savedState.f6433j;
            this.f6434k = savedState.f6434k;
            this.f6431g = savedState.f6431g;
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.T1();
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        int f6436a;

        /* renamed from: b  reason: collision with root package name */
        int f6437b;

        /* renamed from: c  reason: collision with root package name */
        boolean f6438c;

        /* renamed from: d  reason: collision with root package name */
        boolean f6439d;

        /* renamed from: e  reason: collision with root package name */
        boolean f6440e;

        /* renamed from: f  reason: collision with root package name */
        int[] f6441f;

        b() {
            c();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i10;
            if (this.f6438c) {
                i10 = StaggeredGridLayoutManager.this.f6413u.i();
            } else {
                i10 = StaggeredGridLayoutManager.this.f6413u.m();
            }
            this.f6437b = i10;
        }

        /* access modifiers changed from: package-private */
        public void b(int i10) {
            if (this.f6438c) {
                this.f6437b = StaggeredGridLayoutManager.this.f6413u.i() - i10;
            } else {
                this.f6437b = StaggeredGridLayoutManager.this.f6413u.m() + i10;
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f6436a = -1;
            this.f6437b = Integer.MIN_VALUE;
            this.f6438c = false;
            this.f6439d = false;
            this.f6440e = false;
            int[] iArr = this.f6441f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(d[] dVarArr) {
            int length = dVarArr.length;
            int[] iArr = this.f6441f;
            if (iArr == null || iArr.length < length) {
                this.f6441f = new int[StaggeredGridLayoutManager.this.f6412t.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f6441f[i10] = dVarArr[i10].p(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        d f6443e;

        /* renamed from: f  reason: collision with root package name */
        boolean f6444f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean e() {
            return this.f6444f;
        }

        public void f(boolean z10) {
            this.f6444f = z10;
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class d {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f6445a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f6446b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f6447c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f6448d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f6449e;

        d(int i10) {
            this.f6449e = i10;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            c n10 = n(view);
            n10.f6443e = this;
            this.f6445a.add(view);
            this.f6447c = Integer.MIN_VALUE;
            if (this.f6445a.size() == 1) {
                this.f6446b = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f6448d += StaggeredGridLayoutManager.this.f6413u.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z10, int i10) {
            int i11;
            if (z10) {
                i11 = l(Integer.MIN_VALUE);
            } else {
                i11 = p(Integer.MIN_VALUE);
            }
            e();
            if (i11 != Integer.MIN_VALUE) {
                if (z10 && i11 < StaggeredGridLayoutManager.this.f6413u.i()) {
                    return;
                }
                if (z10 || i11 <= StaggeredGridLayoutManager.this.f6413u.m()) {
                    if (i10 != Integer.MIN_VALUE) {
                        i11 += i10;
                    }
                    this.f6447c = i11;
                    this.f6446b = i11;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            LazySpanLookup.FullSpanItem f10;
            ArrayList<View> arrayList = this.f6445a;
            View view = arrayList.get(arrayList.size() - 1);
            c n10 = n(view);
            this.f6447c = StaggeredGridLayoutManager.this.f6413u.d(view);
            if (n10.f6444f && (f10 = StaggeredGridLayoutManager.this.E.f(n10.a())) != null && f10.f6422b == 1) {
                this.f6447c += f10.a(this.f6449e);
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            LazySpanLookup.FullSpanItem f10;
            View view = this.f6445a.get(0);
            c n10 = n(view);
            this.f6446b = StaggeredGridLayoutManager.this.f6413u.g(view);
            if (n10.f6444f && (f10 = StaggeredGridLayoutManager.this.E.f(n10.a())) != null && f10.f6422b == -1) {
                this.f6446b -= f10.a(this.f6449e);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f6445a.clear();
            q();
            this.f6448d = 0;
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.f6418z) {
                return i(this.f6445a.size() - 1, -1, true);
            }
            return i(0, this.f6445a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.f6418z) {
                return i(0, this.f6445a.size(), true);
            }
            return i(this.f6445a.size() - 1, -1, true);
        }

        /* access modifiers changed from: package-private */
        public int h(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int i12;
            boolean z13;
            int m10 = StaggeredGridLayoutManager.this.f6413u.m();
            int i13 = StaggeredGridLayoutManager.this.f6413u.i();
            if (i11 > i10) {
                i12 = 1;
            } else {
                i12 = -1;
            }
            while (i10 != i11) {
                View view = this.f6445a.get(i10);
                int g10 = StaggeredGridLayoutManager.this.f6413u.g(view);
                int d10 = StaggeredGridLayoutManager.this.f6413u.d(view);
                boolean z14 = false;
                if (!z12 ? g10 >= i13 : g10 > i13) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (!z12 ? d10 > m10 : d10 >= m10) {
                    z14 = true;
                }
                if (z13 && z14) {
                    if (!z10 || !z11) {
                        if (z11) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                        if (g10 < m10 || d10 > i13) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                    } else if (g10 >= m10 && d10 <= i13) {
                        return StaggeredGridLayoutManager.this.i0(view);
                    }
                }
                i10 += i12;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int i(int i10, int i11, boolean z10) {
            return h(i10, i11, false, false, z10);
        }

        public int j() {
            return this.f6448d;
        }

        /* access modifiers changed from: package-private */
        public int k() {
            int i10 = this.f6447c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f6447c;
        }

        /* access modifiers changed from: package-private */
        public int l(int i10) {
            int i11 = this.f6447c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f6445a.size() == 0) {
                return i10;
            }
            c();
            return this.f6447c;
        }

        public View m(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f6445a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f6445a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f6418z && staggeredGridLayoutManager.i0(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f6418z && staggeredGridLayoutManager2.i0(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f6445a.size();
                int i12 = 0;
                while (i12 < size2) {
                    View view3 = this.f6445a.get(i12);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f6418z && staggeredGridLayoutManager3.i0(view3) <= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f6418z && staggeredGridLayoutManager4.i0(view3) >= i10) || !view3.hasFocusable()) {
                        break;
                    }
                    i12++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public c n(View view) {
            return (c) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public int o() {
            int i10 = this.f6446b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f6446b;
        }

        /* access modifiers changed from: package-private */
        public int p(int i10) {
            int i11 = this.f6446b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f6445a.size() == 0) {
                return i10;
            }
            d();
            return this.f6446b;
        }

        /* access modifiers changed from: package-private */
        public void q() {
            this.f6446b = Integer.MIN_VALUE;
            this.f6447c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void r(int i10) {
            int i11 = this.f6446b;
            if (i11 != Integer.MIN_VALUE) {
                this.f6446b = i11 + i10;
            }
            int i12 = this.f6447c;
            if (i12 != Integer.MIN_VALUE) {
                this.f6447c = i12 + i10;
            }
        }

        /* access modifiers changed from: package-private */
        public void s() {
            int size = this.f6445a.size();
            View remove = this.f6445a.remove(size - 1);
            c n10 = n(remove);
            n10.f6443e = null;
            if (n10.c() || n10.b()) {
                this.f6448d -= StaggeredGridLayoutManager.this.f6413u.e(remove);
            }
            if (size == 1) {
                this.f6446b = Integer.MIN_VALUE;
            }
            this.f6447c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void t() {
            View remove = this.f6445a.remove(0);
            c n10 = n(remove);
            n10.f6443e = null;
            if (this.f6445a.size() == 0) {
                this.f6447c = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f6448d -= StaggeredGridLayoutManager.this.f6413u.e(remove);
            }
            this.f6446b = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void u(View view) {
            c n10 = n(view);
            n10.f6443e = this;
            this.f6445a.add(0, view);
            this.f6446b = Integer.MIN_VALUE;
            if (this.f6445a.size() == 1) {
                this.f6447c = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f6448d += StaggeredGridLayoutManager.this.f6413u.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void v(int i10) {
            this.f6446b = i10;
            this.f6447c = i10;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.o.d j02 = RecyclerView.o.j0(context, attributeSet, i10, i11);
        I2(j02.f6355a);
        K2(j02.f6356b);
        J2(j02.f6357c);
        this.f6417y = new o();
        b2();
    }

    private void A2(View view) {
        for (int i10 = this.f6411s - 1; i10 >= 0; i10--) {
            this.f6412t[i10].u(view);
        }
    }

    private void B2(RecyclerView.v vVar, o oVar) {
        int i10;
        int i11;
        if (oVar.f6686a && !oVar.f6694i) {
            if (oVar.f6687b == 0) {
                if (oVar.f6690e == -1) {
                    C2(vVar, oVar.f6692g);
                } else {
                    D2(vVar, oVar.f6691f);
                }
            } else if (oVar.f6690e == -1) {
                int i12 = oVar.f6691f;
                int n22 = i12 - n2(i12);
                if (n22 < 0) {
                    i11 = oVar.f6692g;
                } else {
                    i11 = oVar.f6692g - Math.min(n22, oVar.f6687b);
                }
                C2(vVar, i11);
            } else {
                int o22 = o2(oVar.f6692g) - oVar.f6692g;
                if (o22 < 0) {
                    i10 = oVar.f6691f;
                } else {
                    i10 = Math.min(o22, oVar.f6687b) + oVar.f6691f;
                }
                D2(vVar, i10);
            }
        }
    }

    private void C2(RecyclerView.v vVar, int i10) {
        int K2 = K() - 1;
        while (K2 >= 0) {
            View J2 = J(K2);
            if (this.f6413u.g(J2) >= i10 && this.f6413u.q(J2) >= i10) {
                c cVar = (c) J2.getLayoutParams();
                if (cVar.f6444f) {
                    int i11 = 0;
                    while (i11 < this.f6411s) {
                        if (this.f6412t[i11].f6445a.size() != 1) {
                            i11++;
                        } else {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.f6411s; i12++) {
                        this.f6412t[i12].s();
                    }
                } else if (cVar.f6443e.f6445a.size() != 1) {
                    cVar.f6443e.s();
                } else {
                    return;
                }
                n1(J2, vVar);
                K2--;
            } else {
                return;
            }
        }
    }

    private void D2(RecyclerView.v vVar, int i10) {
        while (K() > 0) {
            View J2 = J(0);
            if (this.f6413u.d(J2) <= i10 && this.f6413u.p(J2) <= i10) {
                c cVar = (c) J2.getLayoutParams();
                if (cVar.f6444f) {
                    int i11 = 0;
                    while (i11 < this.f6411s) {
                        if (this.f6412t[i11].f6445a.size() != 1) {
                            i11++;
                        } else {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.f6411s; i12++) {
                        this.f6412t[i12].t();
                    }
                } else if (cVar.f6443e.f6445a.size() != 1) {
                    cVar.f6443e.t();
                } else {
                    return;
                }
                n1(J2, vVar);
            } else {
                return;
            }
        }
    }

    private void E2() {
        if (this.f6414v.k() != 1073741824) {
            float f10 = 0.0f;
            int K2 = K();
            for (int i10 = 0; i10 < K2; i10++) {
                View J2 = J(i10);
                float e10 = (float) this.f6414v.e(J2);
                if (e10 >= f10) {
                    if (((c) J2.getLayoutParams()).e()) {
                        e10 = (e10 * 1.0f) / ((float) this.f6411s);
                    }
                    f10 = Math.max(f10, e10);
                }
            }
            int i11 = this.f6416x;
            int round = Math.round(f10 * ((float) this.f6411s));
            if (this.f6414v.k() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f6414v.n());
            }
            Q2(round);
            if (this.f6416x != i11) {
                for (int i12 = 0; i12 < K2; i12++) {
                    View J3 = J(i12);
                    c cVar = (c) J3.getLayoutParams();
                    if (!cVar.f6444f) {
                        if (!u2() || this.f6415w != 1) {
                            int i13 = cVar.f6443e.f6449e;
                            int i14 = this.f6416x * i13;
                            int i15 = i13 * i11;
                            if (this.f6415w == 1) {
                                J3.offsetLeftAndRight(i14 - i15);
                            } else {
                                J3.offsetTopAndBottom(i14 - i15);
                            }
                        } else {
                            int i16 = this.f6411s;
                            int i17 = cVar.f6443e.f6449e;
                            J3.offsetLeftAndRight(((-((i16 - 1) - i17)) * this.f6416x) - ((-((i16 - 1) - i17)) * i11));
                        }
                    }
                }
            }
        }
    }

    private void F2() {
        if (this.f6415w == 1 || !u2()) {
            this.A = this.f6418z;
        } else {
            this.A = !this.f6418z;
        }
    }

    private void H2(int i10) {
        boolean z10;
        o oVar = this.f6417y;
        oVar.f6690e = i10;
        boolean z11 = this.A;
        int i11 = 1;
        if (i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z11 != z10) {
            i11 = -1;
        }
        oVar.f6689d = i11;
    }

    private void L2(int i10, int i11) {
        for (int i12 = 0; i12 < this.f6411s; i12++) {
            if (!this.f6412t[i12].f6445a.isEmpty()) {
                R2(this.f6412t[i12], i10, i11);
            }
        }
    }

    private boolean M2(RecyclerView.z zVar, b bVar) {
        int i10;
        if (this.G) {
            i10 = h2(zVar.b());
        } else {
            i10 = d2(zVar.b());
        }
        bVar.f6436a = i10;
        bVar.f6437b = Integer.MIN_VALUE;
        return true;
    }

    private void N1(View view) {
        for (int i10 = this.f6411s - 1; i10 >= 0; i10--) {
            this.f6412t[i10].a(view);
        }
    }

    private void O1(b bVar) {
        int i10;
        SavedState savedState = this.I;
        int i11 = savedState.f6427c;
        if (i11 > 0) {
            if (i11 == this.f6411s) {
                for (int i12 = 0; i12 < this.f6411s; i12++) {
                    this.f6412t[i12].e();
                    SavedState savedState2 = this.I;
                    int i13 = savedState2.f6428d[i12];
                    if (i13 != Integer.MIN_VALUE) {
                        if (savedState2.f6433j) {
                            i10 = this.f6413u.i();
                        } else {
                            i10 = this.f6413u.m();
                        }
                        i13 += i10;
                    }
                    this.f6412t[i12].v(i13);
                }
            } else {
                savedState.c();
                SavedState savedState3 = this.I;
                savedState3.f6425a = savedState3.f6426b;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.f6434k;
        J2(savedState4.f6432h);
        F2();
        SavedState savedState5 = this.I;
        int i14 = savedState5.f6425a;
        if (i14 != -1) {
            this.C = i14;
            bVar.f6438c = savedState5.f6433j;
        } else {
            bVar.f6438c = this.A;
        }
        if (savedState5.f6429e > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f6419a = savedState5.f6430f;
            lazySpanLookup.f6420b = savedState5.f6431g;
        }
    }

    private void P2(int i10, RecyclerView.z zVar) {
        int i11;
        int i12;
        int c10;
        boolean z10;
        o oVar = this.f6417y;
        boolean z11 = false;
        oVar.f6687b = 0;
        oVar.f6688c = i10;
        if (!y0() || (c10 = zVar.c()) == -1) {
            i12 = 0;
            i11 = 0;
        } else {
            boolean z12 = this.A;
            if (c10 < i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z12 == z10) {
                i12 = this.f6413u.n();
                i11 = 0;
            } else {
                i11 = this.f6413u.n();
                i12 = 0;
            }
        }
        if (N()) {
            this.f6417y.f6691f = this.f6413u.m() - i11;
            this.f6417y.f6692g = this.f6413u.i() + i12;
        } else {
            this.f6417y.f6692g = this.f6413u.h() + i12;
            this.f6417y.f6691f = -i11;
        }
        o oVar2 = this.f6417y;
        oVar2.f6693h = false;
        oVar2.f6686a = true;
        if (this.f6413u.k() == 0 && this.f6413u.h() == 0) {
            z11 = true;
        }
        oVar2.f6694i = z11;
    }

    private void R1(View view, c cVar, o oVar) {
        if (oVar.f6690e == 1) {
            if (cVar.f6444f) {
                N1(view);
            } else {
                cVar.f6443e.a(view);
            }
        } else if (cVar.f6444f) {
            A2(view);
        } else {
            cVar.f6443e.u(view);
        }
    }

    private void R2(d dVar, int i10, int i11) {
        int j10 = dVar.j();
        if (i10 == -1) {
            if (dVar.o() + j10 <= i11) {
                this.B.set(dVar.f6449e, false);
            }
        } else if (dVar.k() - j10 >= i11) {
            this.B.set(dVar.f6449e, false);
        }
    }

    private int S1(int i10) {
        boolean z10;
        if (K() != 0) {
            if (i10 < k2()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 != this.A) {
                return -1;
            }
            return 1;
        } else if (this.A) {
            return 1;
        } else {
            return -1;
        }
    }

    private int S2(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode);
        }
        return i10;
    }

    private boolean U1(d dVar) {
        if (this.A) {
            if (dVar.k() < this.f6413u.i()) {
                ArrayList<View> arrayList = dVar.f6445a;
                return !dVar.n(arrayList.get(arrayList.size() - 1)).f6444f;
            }
        } else if (dVar.o() > this.f6413u.m()) {
            return !dVar.n(dVar.f6445a.get(0)).f6444f;
        }
        return false;
    }

    private int V1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        return w.a(zVar, this.f6413u, f2(!this.N), e2(!this.N), this, this.N);
    }

    private int W1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        return w.b(zVar, this.f6413u, f2(!this.N), e2(!this.N), this, this.N, this.A);
    }

    private int X1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        return w.c(zVar, this.f6413u, f2(!this.N), e2(!this.N), this, this.N);
    }

    private int Y1(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 17) {
                    if (i10 != 33) {
                        if (i10 != 66) {
                            if (i10 != 130) {
                                return Integer.MIN_VALUE;
                            }
                            if (this.f6415w == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.f6415w == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.f6415w == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.f6415w == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.f6415w != 1 && u2()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.f6415w != 1 && u2()) {
            return 1;
        } else {
            return -1;
        }
    }

    private LazySpanLookup.FullSpanItem Z1(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f6423c = new int[this.f6411s];
        for (int i11 = 0; i11 < this.f6411s; i11++) {
            fullSpanItem.f6423c[i11] = i10 - this.f6412t[i11].l(i10);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem a2(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f6423c = new int[this.f6411s];
        for (int i11 = 0; i11 < this.f6411s; i11++) {
            fullSpanItem.f6423c[i11] = this.f6412t[i11].p(i10) - i10;
        }
        return fullSpanItem;
    }

    private void b2() {
        this.f6413u = t.b(this, this.f6415w);
        this.f6414v = t.b(this, 1 - this.f6415w);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v5 */
    private int c2(RecyclerView.v vVar, o oVar, RecyclerView.z zVar) {
        int i10;
        int i11;
        int i12;
        boolean z10;
        d dVar;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z11;
        int i17;
        int i18;
        boolean z12;
        int i19;
        int i20;
        RecyclerView.v vVar2 = vVar;
        o oVar2 = oVar;
        ? r92 = 0;
        this.B.set(0, this.f6411s, true);
        if (this.f6417y.f6694i) {
            if (oVar2.f6690e == 1) {
                i10 = a.e.API_PRIORITY_OTHER;
            } else {
                i10 = Integer.MIN_VALUE;
            }
        } else if (oVar2.f6690e == 1) {
            i10 = oVar2.f6692g + oVar2.f6687b;
        } else {
            i10 = oVar2.f6691f - oVar2.f6687b;
        }
        int i21 = i10;
        L2(oVar2.f6690e, i21);
        if (this.A) {
            i11 = this.f6413u.i();
        } else {
            i11 = this.f6413u.m();
        }
        int i22 = i11;
        boolean z13 = false;
        while (oVar.a(zVar) && (this.f6417y.f6694i || !this.B.isEmpty())) {
            View b10 = oVar2.b(vVar2);
            c cVar = (c) b10.getLayoutParams();
            int a10 = cVar.a();
            int g10 = this.E.g(a10);
            if (g10 == -1) {
                z10 = true;
            } else {
                z10 = r92;
            }
            if (z10) {
                if (cVar.f6444f) {
                    dVar = this.f6412t[r92];
                } else {
                    dVar = q2(oVar2);
                }
                this.E.n(a10, dVar);
            } else {
                dVar = this.f6412t[g10];
            }
            d dVar2 = dVar;
            cVar.f6443e = dVar2;
            if (oVar2.f6690e == 1) {
                e(b10);
            } else {
                f(b10, r92);
            }
            w2(b10, cVar, r92);
            if (oVar2.f6690e == 1) {
                if (cVar.f6444f) {
                    i20 = m2(i22);
                } else {
                    i20 = dVar2.l(i22);
                }
                int e10 = this.f6413u.e(b10) + i20;
                if (z10 && cVar.f6444f) {
                    LazySpanLookup.FullSpanItem Z1 = Z1(i20);
                    Z1.f6422b = -1;
                    Z1.f6421a = a10;
                    this.E.a(Z1);
                }
                i13 = e10;
                i14 = i20;
            } else {
                if (cVar.f6444f) {
                    i19 = p2(i22);
                } else {
                    i19 = dVar2.p(i22);
                }
                i14 = i19 - this.f6413u.e(b10);
                if (z10 && cVar.f6444f) {
                    LazySpanLookup.FullSpanItem a22 = a2(i19);
                    a22.f6422b = 1;
                    a22.f6421a = a10;
                    this.E.a(a22);
                }
                i13 = i19;
            }
            if (cVar.f6444f && oVar2.f6689d == -1) {
                if (z10) {
                    this.M = true;
                } else {
                    if (oVar2.f6690e == 1) {
                        z12 = P1();
                    } else {
                        z12 = Q1();
                    }
                    if (!z12) {
                        LazySpanLookup.FullSpanItem f10 = this.E.f(a10);
                        if (f10 != null) {
                            f10.f6424d = true;
                        }
                        this.M = true;
                    }
                }
            }
            R1(b10, cVar, oVar2);
            if (!u2() || this.f6415w != 1) {
                if (cVar.f6444f) {
                    i17 = this.f6414v.m();
                } else {
                    i17 = (dVar2.f6449e * this.f6416x) + this.f6414v.m();
                }
                i16 = i17;
                i15 = this.f6414v.e(b10) + i17;
            } else {
                if (cVar.f6444f) {
                    i18 = this.f6414v.i();
                } else {
                    i18 = this.f6414v.i() - (((this.f6411s - 1) - dVar2.f6449e) * this.f6416x);
                }
                i15 = i18;
                i16 = i18 - this.f6414v.e(b10);
            }
            if (this.f6415w == 1) {
                A0(b10, i16, i14, i15, i13);
            } else {
                A0(b10, i14, i16, i13, i15);
            }
            if (cVar.f6444f) {
                L2(this.f6417y.f6690e, i21);
            } else {
                R2(dVar2, this.f6417y.f6690e, i21);
            }
            B2(vVar2, this.f6417y);
            if (this.f6417y.f6693h && b10.hasFocusable()) {
                if (cVar.f6444f) {
                    this.B.clear();
                } else {
                    z11 = false;
                    this.B.set(dVar2.f6449e, false);
                    r92 = z11;
                    z13 = true;
                }
            }
            z11 = false;
            r92 = z11;
            z13 = true;
        }
        int i23 = r92;
        if (!z13) {
            B2(vVar2, this.f6417y);
        }
        if (this.f6417y.f6690e == -1) {
            i12 = this.f6413u.m() - p2(this.f6413u.m());
        } else {
            i12 = m2(this.f6413u.i()) - this.f6413u.i();
        }
        if (i12 > 0) {
            return Math.min(oVar2.f6687b, i12);
        }
        return i23;
    }

    private int d2(int i10) {
        int K2 = K();
        for (int i11 = 0; i11 < K2; i11++) {
            int i02 = i0(J(i11));
            if (i02 >= 0 && i02 < i10) {
                return i02;
            }
        }
        return 0;
    }

    private int h2(int i10) {
        for (int K2 = K() - 1; K2 >= 0; K2--) {
            int i02 = i0(J(K2));
            if (i02 >= 0 && i02 < i10) {
                return i02;
            }
        }
        return 0;
    }

    private void i2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int i10;
        int m22 = m2(Integer.MIN_VALUE);
        if (m22 != Integer.MIN_VALUE && (i10 = this.f6413u.i() - m22) > 0) {
            int i11 = i10 - (-G2(-i10, vVar, zVar));
            if (z10 && i11 > 0) {
                this.f6413u.r(i11);
            }
        }
    }

    private void j2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int m10;
        int p22 = p2(a.e.API_PRIORITY_OTHER);
        if (p22 != Integer.MAX_VALUE && (m10 = p22 - this.f6413u.m()) > 0) {
            int G2 = m10 - G2(m10, vVar, zVar);
            if (z10 && G2 > 0) {
                this.f6413u.r(-G2);
            }
        }
    }

    private int m2(int i10) {
        int l10 = this.f6412t[0].l(i10);
        for (int i11 = 1; i11 < this.f6411s; i11++) {
            int l11 = this.f6412t[i11].l(i10);
            if (l11 > l10) {
                l10 = l11;
            }
        }
        return l10;
    }

    private int n2(int i10) {
        int p10 = this.f6412t[0].p(i10);
        for (int i11 = 1; i11 < this.f6411s; i11++) {
            int p11 = this.f6412t[i11].p(i10);
            if (p11 > p10) {
                p10 = p11;
            }
        }
        return p10;
    }

    private int o2(int i10) {
        int l10 = this.f6412t[0].l(i10);
        for (int i11 = 1; i11 < this.f6411s; i11++) {
            int l11 = this.f6412t[i11].l(i10);
            if (l11 < l10) {
                l10 = l11;
            }
        }
        return l10;
    }

    private int p2(int i10) {
        int p10 = this.f6412t[0].p(i10);
        for (int i11 = 1; i11 < this.f6411s; i11++) {
            int p11 = this.f6412t[i11].p(i10);
            if (p11 < p10) {
                p10 = p11;
            }
        }
        return p10;
    }

    private d q2(o oVar) {
        int i10;
        int i11;
        int i12 = -1;
        if (y2(oVar.f6690e)) {
            i11 = this.f6411s - 1;
            i10 = -1;
        } else {
            i11 = 0;
            i12 = this.f6411s;
            i10 = 1;
        }
        d dVar = null;
        if (oVar.f6690e == 1) {
            int i13 = a.e.API_PRIORITY_OTHER;
            int m10 = this.f6413u.m();
            while (i11 != i12) {
                d dVar2 = this.f6412t[i11];
                int l10 = dVar2.l(m10);
                if (l10 < i13) {
                    dVar = dVar2;
                    i13 = l10;
                }
                i11 += i10;
            }
            return dVar;
        }
        int i14 = Integer.MIN_VALUE;
        int i15 = this.f6413u.i();
        while (i11 != i12) {
            d dVar3 = this.f6412t[i11];
            int p10 = dVar3.p(i15);
            if (p10 > i14) {
                dVar = dVar3;
                i14 = p10;
            }
            i11 += i10;
        }
        return dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L_0x0009
            int r0 = r6.l2()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.k2()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.E
            r7.j(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.k(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.j(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.A
            if (r7 == 0) goto L_0x004d
            int r7 = r6.k2()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.l2()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.u1()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.r2(int, int, int):void");
    }

    private void v2(View view, int i10, int i11, boolean z10) {
        boolean z11;
        k(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i12 = cVar.leftMargin;
        Rect rect = this.K;
        int S2 = S2(i10, i12 + rect.left, cVar.rightMargin + rect.right);
        int i13 = cVar.topMargin;
        Rect rect2 = this.K;
        int S22 = S2(i11, i13 + rect2.top, cVar.bottomMargin + rect2.bottom);
        if (z10) {
            z11 = I1(view, S2, S22, cVar);
        } else {
            z11 = G1(view, S2, S22, cVar);
        }
        if (z11) {
            view.measure(S2, S22);
        }
    }

    private void w2(View view, c cVar, boolean z10) {
        if (cVar.f6444f) {
            if (this.f6415w == 1) {
                v2(view, this.J, RecyclerView.o.L(X(), Y(), h0() + e0(), cVar.height, true), z10);
            } else {
                v2(view, RecyclerView.o.L(p0(), q0(), f0() + g0(), cVar.width, true), this.J, z10);
            }
        } else if (this.f6415w == 1) {
            v2(view, RecyclerView.o.L(this.f6416x, q0(), 0, cVar.width, false), RecyclerView.o.L(X(), Y(), h0() + e0(), cVar.height, true), z10);
        } else {
            v2(view, RecyclerView.o.L(p0(), q0(), f0() + g0(), cVar.width, true), RecyclerView.o.L(this.f6416x, Y(), 0, cVar.height, false), z10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (T1() != false) goto L_0x015b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.z r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r0 = r8.L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.I
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.C
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.b()
            if (r1 != 0) goto L_0x0018
            r8.l1(r9)
            r0.c()
            return
        L_0x0018:
            boolean r1 = r0.f6440e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.C
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.I
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = r3
            goto L_0x002a
        L_0x0029:
            r1 = r4
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 == 0) goto L_0x0037
            r8.O1(r0)
            goto L_0x003e
        L_0x0037:
            r8.F2()
            boolean r5 = r8.A
            r0.f6438c = r5
        L_0x003e:
            r8.O2(r10, r0)
            r0.f6440e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 != 0) goto L_0x0060
            int r5 = r8.C
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f6438c
            boolean r6 = r8.G
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.u2()
            boolean r6 = r8.H
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.E
            r5.b()
            r0.f6439d = r4
        L_0x0060:
            int r5 = r8.K()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 == 0) goto L_0x006e
            int r5 = r5.f6427c
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.f6439d
            if (r5 == 0) goto L_0x008e
            r1 = r3
        L_0x0073:
            int r5 = r8.f6411s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d[] r5 = r8.f6412t
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f6437b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d[] r6 = r8.f6412t
            r6 = r6[r1]
            r6.v(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.L
            int[] r1 = r1.f6441f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = r3
        L_0x0098:
            int r5 = r8.f6411s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d[] r5 = r8.f6412t
            r5 = r5[r1]
            r5.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r6 = r8.L
            int[] r6 = r6.f6441f
            r6 = r6[r1]
            r5.v(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = r3
        L_0x00b0:
            int r5 = r8.f6411s
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d[] r5 = r8.f6412t
            r5 = r5[r1]
            boolean r6 = r8.A
            int r7 = r0.f6437b
            r5.b(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d[] r5 = r8.f6412t
            r1.d(r5)
        L_0x00c9:
            r8.x(r9)
            androidx.recyclerview.widget.o r1 = r8.f6417y
            r1.f6686a = r3
            r8.M = r3
            androidx.recyclerview.widget.t r1 = r8.f6414v
            int r1 = r1.n()
            r8.Q2(r1)
            int r1 = r0.f6436a
            r8.P2(r1, r10)
            boolean r1 = r0.f6438c
            if (r1 == 0) goto L_0x00fc
            r8.H2(r2)
            androidx.recyclerview.widget.o r1 = r8.f6417y
            r8.c2(r9, r1, r10)
            r8.H2(r4)
            androidx.recyclerview.widget.o r1 = r8.f6417y
            int r2 = r0.f6436a
            int r5 = r1.f6689d
            int r2 = r2 + r5
            r1.f6688c = r2
            r8.c2(r9, r1, r10)
            goto L_0x0113
        L_0x00fc:
            r8.H2(r4)
            androidx.recyclerview.widget.o r1 = r8.f6417y
            r8.c2(r9, r1, r10)
            r8.H2(r2)
            androidx.recyclerview.widget.o r1 = r8.f6417y
            int r2 = r0.f6436a
            int r5 = r1.f6689d
            int r2 = r2 + r5
            r1.f6688c = r2
            r8.c2(r9, r1, r10)
        L_0x0113:
            r8.E2()
            int r1 = r8.K()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.A
            if (r1 == 0) goto L_0x0127
            r8.i2(r9, r10, r4)
            r8.j2(r9, r10, r3)
            goto L_0x012d
        L_0x0127:
            r8.j2(r9, r10, r4)
            r8.i2(r9, r10, r3)
        L_0x012d:
            if (r11 == 0) goto L_0x015a
            boolean r11 = r10.e()
            if (r11 != 0) goto L_0x015a
            int r11 = r8.F
            if (r11 == 0) goto L_0x014b
            int r11 = r8.K()
            if (r11 <= 0) goto L_0x014b
            boolean r11 = r8.M
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.s2()
            if (r11 == 0) goto L_0x014b
        L_0x0149:
            r11 = r4
            goto L_0x014c
        L_0x014b:
            r11 = r3
        L_0x014c:
            if (r11 == 0) goto L_0x015a
            java.lang.Runnable r11 = r8.P
            r8.p1(r11)
            boolean r11 = r8.T1()
            if (r11 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r4 = r3
        L_0x015b:
            boolean r11 = r10.e()
            if (r11 == 0) goto L_0x0166
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.L
            r11.c()
        L_0x0166:
            boolean r11 = r0.f6438c
            r8.G = r11
            boolean r11 = r8.u2()
            r8.H = r11
            if (r4 == 0) goto L_0x017a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.L
            r11.c()
            r8.x2(r9, r10, r3)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.x2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, boolean):void");
    }

    private boolean y2(int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        if (this.f6415w == 0) {
            if (i10 == -1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12 != this.A) {
                return true;
            }
            return false;
        }
        if (i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 == this.A) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 == u2()) {
            return true;
        }
        return false;
    }

    public void D0(int i10) {
        super.D0(i10);
        for (int i11 = 0; i11 < this.f6411s; i11++) {
            this.f6412t[i11].r(i10);
        }
    }

    public void D1(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        int f02 = f0() + g0();
        int h02 = h0() + e0();
        if (this.f6415w == 1) {
            i13 = RecyclerView.o.o(i11, rect.height() + h02, c0());
            i12 = RecyclerView.o.o(i10, (this.f6416x * this.f6411s) + f02, d0());
        } else {
            i12 = RecyclerView.o.o(i10, rect.width() + f02, d0());
            i13 = RecyclerView.o.o(i11, (this.f6416x * this.f6411s) + h02, c0());
        }
        C1(i12, i13);
    }

    public RecyclerView.p E() {
        if (this.f6415w == 0) {
            return new c(-2, -1);
        }
        return new c(-1, -2);
    }

    public void E0(int i10) {
        super.E0(i10);
        for (int i11 = 0; i11 < this.f6411s; i11++) {
            this.f6412t[i11].r(i10);
        }
    }

    public RecyclerView.p F(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public void F0(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.E.b();
        for (int i10 = 0; i10 < this.f6411s; i10++) {
            this.f6412t[i10].e();
        }
    }

    public RecyclerView.p G(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int G2(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (K() == 0 || i10 == 0) {
            return 0;
        }
        z2(i10, zVar);
        int c22 = c2(vVar, this.f6417y, zVar);
        if (this.f6417y.f6687b >= c22) {
            if (i10 < 0) {
                i10 = -c22;
            } else {
                i10 = c22;
            }
        }
        this.f6413u.r(-i10);
        this.G = this.A;
        o oVar = this.f6417y;
        oVar.f6687b = 0;
        B2(vVar, oVar);
        return i10;
    }

    public void I2(int i10) {
        if (i10 == 0 || i10 == 1) {
            h((String) null);
            if (i10 != this.f6415w) {
                this.f6415w = i10;
                t tVar = this.f6413u;
                this.f6413u = this.f6414v;
                this.f6414v = tVar;
                u1();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void J0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.J0(recyclerView, vVar);
        p1(this.P);
        for (int i10 = 0; i10 < this.f6411s; i10++) {
            this.f6412t[i10].e();
        }
        recyclerView.requestLayout();
    }

    public void J1(RecyclerView recyclerView, RecyclerView.z zVar, int i10) {
        p pVar = new p(recyclerView.getContext());
        pVar.p(i10);
        K1(pVar);
    }

    public void J2(boolean z10) {
        h((String) null);
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.f6432h == z10)) {
            savedState.f6432h = z10;
        }
        this.f6418z = z10;
        u1();
    }

    public View K0(View view, int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        View C2;
        int i11;
        boolean z10;
        boolean z11;
        int i12;
        int i13;
        int i14;
        View m10;
        if (K() == 0 || (C2 = C(view)) == null) {
            return null;
        }
        F2();
        int Y1 = Y1(i10);
        if (Y1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) C2.getLayoutParams();
        boolean z12 = cVar.f6444f;
        d dVar = cVar.f6443e;
        if (Y1 == 1) {
            i11 = l2();
        } else {
            i11 = k2();
        }
        P2(i11, zVar);
        H2(Y1);
        o oVar = this.f6417y;
        oVar.f6688c = oVar.f6689d + i11;
        oVar.f6687b = (int) (((float) this.f6413u.n()) * 0.33333334f);
        o oVar2 = this.f6417y;
        oVar2.f6693h = true;
        oVar2.f6686a = false;
        c2(vVar, oVar2, zVar);
        this.G = this.A;
        if (!z12 && (m10 = dVar.m(i11, Y1)) != null && m10 != C2) {
            return m10;
        }
        if (y2(Y1)) {
            for (int i15 = this.f6411s - 1; i15 >= 0; i15--) {
                View m11 = this.f6412t[i15].m(i11, Y1);
                if (m11 != null && m11 != C2) {
                    return m11;
                }
            }
        } else {
            for (int i16 = 0; i16 < this.f6411s; i16++) {
                View m12 = this.f6412t[i16].m(i11, Y1);
                if (m12 != null && m12 != C2) {
                    return m12;
                }
            }
        }
        boolean z13 = !this.f6418z;
        if (Y1 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z13 == z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z12) {
            if (z11) {
                i14 = dVar.f();
            } else {
                i14 = dVar.g();
            }
            View D2 = D(i14);
            if (!(D2 == null || D2 == C2)) {
                return D2;
            }
        }
        if (y2(Y1)) {
            for (int i17 = this.f6411s - 1; i17 >= 0; i17--) {
                if (i17 != dVar.f6449e) {
                    if (z11) {
                        i13 = this.f6412t[i17].f();
                    } else {
                        i13 = this.f6412t[i17].g();
                    }
                    View D3 = D(i13);
                    if (!(D3 == null || D3 == C2)) {
                        return D3;
                    }
                }
            }
        } else {
            for (int i18 = 0; i18 < this.f6411s; i18++) {
                if (z11) {
                    i12 = this.f6412t[i18].f();
                } else {
                    i12 = this.f6412t[i18].g();
                }
                View D4 = D(i12);
                if (D4 != null && D4 != C2) {
                    return D4;
                }
            }
        }
        return null;
    }

    public void K2(int i10) {
        h((String) null);
        if (i10 != this.f6411s) {
            t2();
            this.f6411s = i10;
            this.B = new BitSet(this.f6411s);
            this.f6412t = new d[this.f6411s];
            for (int i11 = 0; i11 < this.f6411s; i11++) {
                this.f6412t[i11] = new d(i11);
            }
            u1();
        }
    }

    public void L0(AccessibilityEvent accessibilityEvent) {
        super.L0(accessibilityEvent);
        if (K() > 0) {
            View f22 = f2(false);
            View e22 = e2(false);
            if (f22 != null && e22 != null) {
                int i02 = i0(f22);
                int i03 = i0(e22);
                if (i02 < i03) {
                    accessibilityEvent.setFromIndex(i02);
                    accessibilityEvent.setToIndex(i03);
                    return;
                }
                accessibilityEvent.setFromIndex(i03);
                accessibilityEvent.setToIndex(i02);
            }
        }
    }

    public boolean M1() {
        return this.I == null;
    }

    /* access modifiers changed from: package-private */
    public boolean N2(RecyclerView.z zVar, b bVar) {
        int i10;
        int i11;
        int i12;
        boolean z10 = false;
        if (!zVar.e() && (i10 = this.C) != -1) {
            if (i10 < 0 || i10 >= zVar.b()) {
                this.C = -1;
                this.D = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.I;
                if (savedState == null || savedState.f6425a == -1 || savedState.f6427c < 1) {
                    View D2 = D(this.C);
                    if (D2 != null) {
                        if (this.A) {
                            i11 = l2();
                        } else {
                            i11 = k2();
                        }
                        bVar.f6436a = i11;
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f6438c) {
                                bVar.f6437b = (this.f6413u.i() - this.D) - this.f6413u.d(D2);
                            } else {
                                bVar.f6437b = (this.f6413u.m() + this.D) - this.f6413u.g(D2);
                            }
                            return true;
                        } else if (this.f6413u.e(D2) > this.f6413u.n()) {
                            if (bVar.f6438c) {
                                i12 = this.f6413u.i();
                            } else {
                                i12 = this.f6413u.m();
                            }
                            bVar.f6437b = i12;
                            return true;
                        } else {
                            int g10 = this.f6413u.g(D2) - this.f6413u.m();
                            if (g10 < 0) {
                                bVar.f6437b = -g10;
                                return true;
                            }
                            int i13 = this.f6413u.i() - this.f6413u.d(D2);
                            if (i13 < 0) {
                                bVar.f6437b = i13;
                                return true;
                            }
                            bVar.f6437b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i14 = this.C;
                        bVar.f6436a = i14;
                        int i15 = this.D;
                        if (i15 == Integer.MIN_VALUE) {
                            if (S1(i14) == 1) {
                                z10 = true;
                            }
                            bVar.f6438c = z10;
                            bVar.a();
                        } else {
                            bVar.b(i15);
                        }
                        bVar.f6439d = true;
                    }
                } else {
                    bVar.f6437b = Integer.MIN_VALUE;
                    bVar.f6436a = this.C;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void O2(RecyclerView.z zVar, b bVar) {
        if (!N2(zVar, bVar) && !M2(zVar, bVar)) {
            bVar.a();
            bVar.f6436a = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean P1() {
        int l10 = this.f6412t[0].l(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f6411s; i10++) {
            if (this.f6412t[i10].l(Integer.MIN_VALUE) != l10) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean Q1() {
        int p10 = this.f6412t[0].p(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f6411s; i10++) {
            if (this.f6412t[i10].p(Integer.MIN_VALUE) != p10) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void Q2(int i10) {
        this.f6416x = i10 / this.f6411s;
        this.J = View.MeasureSpec.makeMeasureSpec(i10, this.f6414v.k());
    }

    public void S0(RecyclerView recyclerView, int i10, int i11) {
        r2(i10, i11, 1);
    }

    public void T0(RecyclerView recyclerView) {
        this.E.b();
        u1();
    }

    /* access modifiers changed from: package-private */
    public boolean T1() {
        int i10;
        int i11;
        int i12;
        if (K() == 0 || this.F == 0 || !s0()) {
            return false;
        }
        if (this.A) {
            i11 = l2();
            i10 = k2();
        } else {
            i11 = k2();
            i10 = l2();
        }
        if (i11 == 0 && s2() != null) {
            this.E.b();
            v1();
            u1();
            return true;
        } else if (!this.M) {
            return false;
        } else {
            if (this.A) {
                i12 = -1;
            } else {
                i12 = 1;
            }
            int i13 = i10 + 1;
            LazySpanLookup.FullSpanItem e10 = this.E.e(i11, i13, i12, true);
            if (e10 == null) {
                this.M = false;
                this.E.d(i13);
                return false;
            }
            LazySpanLookup.FullSpanItem e11 = this.E.e(i11, e10.f6421a, i12 * -1, true);
            if (e11 == null) {
                this.E.d(e10.f6421a);
            } else {
                this.E.d(e11.f6421a + 1);
            }
            v1();
            u1();
            return true;
        }
    }

    public void U0(RecyclerView recyclerView, int i10, int i11, int i12) {
        r2(i10, i11, 8);
    }

    public void V0(RecyclerView recyclerView, int i10, int i11) {
        r2(i10, i11, 2);
    }

    public void X0(RecyclerView recyclerView, int i10, int i11, Object obj) {
        r2(i10, i11, 4);
    }

    public void Y0(RecyclerView.v vVar, RecyclerView.z zVar) {
        x2(vVar, zVar, true);
    }

    public void Z0(RecyclerView.z zVar) {
        super.Z0(zVar);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    public PointF a(int i10) {
        int S1 = S1(i10);
        PointF pointF = new PointF();
        if (S1 == 0) {
            return null;
        }
        if (this.f6415w == 0) {
            pointF.x = (float) S1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) S1;
        }
        return pointF;
    }

    public void d1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.I = savedState;
            if (this.C != -1) {
                savedState.a();
                this.I.c();
            }
            u1();
        }
    }

    public Parcelable e1() {
        int i10;
        int i11;
        int i12;
        int[] iArr;
        if (this.I != null) {
            return new SavedState(this.I);
        }
        SavedState savedState = new SavedState();
        savedState.f6432h = this.f6418z;
        savedState.f6433j = this.G;
        savedState.f6434k = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f6419a) == null) {
            savedState.f6429e = 0;
        } else {
            savedState.f6430f = iArr;
            savedState.f6429e = iArr.length;
            savedState.f6431g = lazySpanLookup.f6420b;
        }
        if (K() > 0) {
            if (this.G) {
                i10 = l2();
            } else {
                i10 = k2();
            }
            savedState.f6425a = i10;
            savedState.f6426b = g2();
            int i13 = this.f6411s;
            savedState.f6427c = i13;
            savedState.f6428d = new int[i13];
            for (int i14 = 0; i14 < this.f6411s; i14++) {
                if (this.G) {
                    i11 = this.f6412t[i14].l(Integer.MIN_VALUE);
                    if (i11 != Integer.MIN_VALUE) {
                        i12 = this.f6413u.i();
                    } else {
                        savedState.f6428d[i14] = i11;
                    }
                } else {
                    i11 = this.f6412t[i14].p(Integer.MIN_VALUE);
                    if (i11 != Integer.MIN_VALUE) {
                        i12 = this.f6413u.m();
                    } else {
                        savedState.f6428d[i14] = i11;
                    }
                }
                i11 -= i12;
                savedState.f6428d[i14] = i11;
            }
        } else {
            savedState.f6425a = -1;
            savedState.f6426b = -1;
            savedState.f6427c = 0;
        }
        return savedState;
    }

    /* access modifiers changed from: package-private */
    public View e2(boolean z10) {
        int m10 = this.f6413u.m();
        int i10 = this.f6413u.i();
        View view = null;
        for (int K2 = K() - 1; K2 >= 0; K2--) {
            View J2 = J(K2);
            int g10 = this.f6413u.g(J2);
            int d10 = this.f6413u.d(J2);
            if (d10 > m10 && g10 < i10) {
                if (d10 <= i10 || !z10) {
                    return J2;
                }
                if (view == null) {
                    view = J2;
                }
            }
        }
        return view;
    }

    public void f1(int i10) {
        if (i10 == 0) {
            T1();
        }
    }

    /* access modifiers changed from: package-private */
    public View f2(boolean z10) {
        int m10 = this.f6413u.m();
        int i10 = this.f6413u.i();
        int K2 = K();
        View view = null;
        for (int i11 = 0; i11 < K2; i11++) {
            View J2 = J(i11);
            int g10 = this.f6413u.g(J2);
            if (this.f6413u.d(J2) > m10 && g10 < i10) {
                if (g10 >= m10 || !z10) {
                    return J2;
                }
                if (view == null) {
                    view = J2;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public int g2() {
        View view;
        if (this.A) {
            view = e2(true);
        } else {
            view = f2(true);
        }
        if (view == null) {
            return -1;
        }
        return i0(view);
    }

    public void h(String str) {
        if (this.I == null) {
            super.h(str);
        }
    }

    /* access modifiers changed from: package-private */
    public int k2() {
        if (K() == 0) {
            return 0;
        }
        return i0(J(0));
    }

    public boolean l() {
        return this.f6415w == 0;
    }

    /* access modifiers changed from: package-private */
    public int l2() {
        int K2 = K();
        if (K2 == 0) {
            return 0;
        }
        return i0(J(K2 - 1));
    }

    public boolean m() {
        return this.f6415w == 1;
    }

    public boolean n(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    public void p(int i10, int i11, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        int i12;
        int i13;
        if (this.f6415w != 0) {
            i10 = i11;
        }
        if (K() != 0 && i10 != 0) {
            z2(i10, zVar);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.f6411s) {
                this.O = new int[this.f6411s];
            }
            int i14 = 0;
            for (int i15 = 0; i15 < this.f6411s; i15++) {
                o oVar = this.f6417y;
                if (oVar.f6689d == -1) {
                    i13 = oVar.f6691f;
                    i12 = this.f6412t[i15].p(i13);
                } else {
                    i13 = this.f6412t[i15].l(oVar.f6692g);
                    i12 = this.f6417y.f6692g;
                }
                int i16 = i13 - i12;
                if (i16 >= 0) {
                    this.O[i14] = i16;
                    i14++;
                }
            }
            Arrays.sort(this.O, 0, i14);
            for (int i17 = 0; i17 < i14 && this.f6417y.a(zVar); i17++) {
                cVar.a(this.f6417y.f6688c, this.O[i17]);
                o oVar2 = this.f6417y;
                oVar2.f6688c += oVar2.f6689d;
            }
        }
    }

    public int r(RecyclerView.z zVar) {
        return V1(zVar);
    }

    public int s(RecyclerView.z zVar) {
        return W1(zVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View s2() {
        /*
            r12 = this;
            int r0 = r12.K()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f6411s
            r2.<init>(r3)
            int r3 = r12.f6411s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f6415w
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.u2()
            if (r3 == 0) goto L_0x0020
            r3 = r1
            goto L_0x0021
        L_0x0020:
            r3 = r5
        L_0x0021:
            boolean r6 = r12.A
            if (r6 == 0) goto L_0x0027
            r6 = r5
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = r1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.J(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f6443e
            int r9 = r9.f6449e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f6443e
            boolean r9 = r12.U1(r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f6443e
            int r9 = r9.f6449e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f6444f
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.J(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.t r10 = r12.f6413u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.t r11 = r12.f6413u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.t r10 = r12.f6413u
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.t r11 = r12.f6413u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = r1
            goto L_0x008b
        L_0x008a:
            r10 = r4
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r8 = r8.f6443e
            int r8 = r8.f6449e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r9.f6443e
            int r9 = r9.f6449e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = r1
            goto L_0x00a1
        L_0x00a0:
            r8 = r4
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = r1
            goto L_0x00a6
        L_0x00a5:
            r9 = r4
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.s2():android.view.View");
    }

    public int t(RecyclerView.z zVar) {
        return X1(zVar);
    }

    public boolean t0() {
        return this.F != 0;
    }

    public void t2() {
        this.E.b();
        u1();
    }

    public int u(RecyclerView.z zVar) {
        return V1(zVar);
    }

    /* access modifiers changed from: package-private */
    public boolean u2() {
        return a0() == 1;
    }

    public int v(RecyclerView.z zVar) {
        return W1(zVar);
    }

    public int w(RecyclerView.z zVar) {
        return X1(zVar);
    }

    public int x1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        return G2(i10, vVar, zVar);
    }

    public void y1(int i10) {
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.f6425a == i10)) {
            savedState.a();
        }
        this.C = i10;
        this.D = Integer.MIN_VALUE;
        u1();
    }

    public int z1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        return G2(i10, vVar, zVar);
    }

    /* access modifiers changed from: package-private */
    public void z2(int i10, RecyclerView.z zVar) {
        int i11;
        int i12;
        if (i10 > 0) {
            i12 = l2();
            i11 = 1;
        } else {
            i11 = -1;
            i12 = k2();
        }
        this.f6417y.f6686a = true;
        P2(i12, zVar);
        H2(i11);
        o oVar = this.f6417y;
        oVar.f6688c = i12 + oVar.f6689d;
        oVar.f6687b = Math.abs(i10);
    }

    static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f6419a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f6420b;

        LazySpanLookup() {
        }

        private int i(int i10) {
            if (this.f6420b == null) {
                return -1;
            }
            FullSpanItem f10 = f(i10);
            if (f10 != null) {
                this.f6420b.remove(f10);
            }
            int size = this.f6420b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                } else if (this.f6420b.get(i11).f6421a >= i10) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 == -1) {
                return -1;
            }
            this.f6420b.remove(i11);
            return this.f6420b.get(i11).f6421a;
        }

        private void l(int i10, int i11) {
            List<FullSpanItem> list = this.f6420b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f6420b.get(size);
                    int i12 = fullSpanItem.f6421a;
                    if (i12 >= i10) {
                        fullSpanItem.f6421a = i12 + i11;
                    }
                }
            }
        }

        private void m(int i10, int i11) {
            List<FullSpanItem> list = this.f6420b;
            if (list != null) {
                int i12 = i10 + i11;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f6420b.get(size);
                    int i13 = fullSpanItem.f6421a;
                    if (i13 >= i10) {
                        if (i13 < i12) {
                            this.f6420b.remove(size);
                        } else {
                            fullSpanItem.f6421a = i13 - i11;
                        }
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f6420b == null) {
                this.f6420b = new ArrayList();
            }
            int size = this.f6420b.size();
            for (int i10 = 0; i10 < size; i10++) {
                FullSpanItem fullSpanItem2 = this.f6420b.get(i10);
                if (fullSpanItem2.f6421a == fullSpanItem.f6421a) {
                    this.f6420b.remove(i10);
                }
                if (fullSpanItem2.f6421a >= fullSpanItem.f6421a) {
                    this.f6420b.add(i10, fullSpanItem);
                    return;
                }
            }
            this.f6420b.add(fullSpanItem);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f6419a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f6420b = null;
        }

        /* access modifiers changed from: package-private */
        public void c(int i10) {
            int[] iArr = this.f6419a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i10, 10) + 1)];
                this.f6419a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f6419a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f6419a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public int d(int i10) {
            List<FullSpanItem> list = this.f6420b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f6420b.get(size).f6421a >= i10) {
                        this.f6420b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public FullSpanItem e(int i10, int i11, int i12, boolean z10) {
            List<FullSpanItem> list = this.f6420b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                FullSpanItem fullSpanItem = this.f6420b.get(i13);
                int i14 = fullSpanItem.f6421a;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || fullSpanItem.f6422b == i12 || (z10 && fullSpanItem.f6424d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i10) {
            List<FullSpanItem> list = this.f6420b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f6420b.get(size);
                if (fullSpanItem.f6421a == i10) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int g(int i10) {
            int[] iArr = this.f6419a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        /* access modifiers changed from: package-private */
        public int h(int i10) {
            int[] iArr = this.f6419a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f6419a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f6419a.length;
            }
            int min = Math.min(i11 + 1, this.f6419a.length);
            Arrays.fill(this.f6419a, i10, min, -1);
            return min;
        }

        /* access modifiers changed from: package-private */
        public void j(int i10, int i11) {
            int[] iArr = this.f6419a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f6419a;
                System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
                Arrays.fill(this.f6419a, i10, i12, -1);
                l(i10, i11);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(int i10, int i11) {
            int[] iArr = this.f6419a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f6419a;
                System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
                int[] iArr3 = this.f6419a;
                Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
                m(i10, i11);
            }
        }

        /* access modifiers changed from: package-private */
        public void n(int i10, d dVar) {
            c(i10);
            this.f6419a[i10] = dVar.f6449e;
        }

        /* access modifiers changed from: package-private */
        public int o(int i10) {
            int length = this.f6419a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            int f6421a;

            /* renamed from: b  reason: collision with root package name */
            int f6422b;

            /* renamed from: c  reason: collision with root package name */
            int[] f6423c;

            /* renamed from: d  reason: collision with root package name */
            boolean f6424d;

            class a implements Parcelable.Creator<FullSpanItem> {
                a() {
                }

                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: b */
                public FullSpanItem[] newArray(int i10) {
                    return new FullSpanItem[i10];
                }
            }

            FullSpanItem(Parcel parcel) {
                this.f6421a = parcel.readInt();
                this.f6422b = parcel.readInt();
                this.f6424d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f6423c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            /* access modifiers changed from: package-private */
            public int a(int i10) {
                int[] iArr = this.f6423c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f6421a + ", mGapDir=" + this.f6422b + ", mHasUnwantedGapAfter=" + this.f6424d + ", mGapPerSpan=" + Arrays.toString(this.f6423c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f6421a);
                parcel.writeInt(this.f6422b);
                parcel.writeInt(this.f6424d ? 1 : 0);
                int[] iArr = this.f6423c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f6423c);
            }

            FullSpanItem() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i10, int i11) {
        this.f6415w = i11;
        K2(i10);
        this.f6417y = new o();
        b2();
    }
}
