package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.google.android.gms.common.api.a;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.o implements l.h, RecyclerView.y.b {
    int A;
    int B;
    private boolean C;
    SavedState D;
    final a E;
    private final b F;
    private int G;
    private int[] H;

    /* renamed from: s  reason: collision with root package name */
    int f6204s;

    /* renamed from: t  reason: collision with root package name */
    private c f6205t;

    /* renamed from: u  reason: collision with root package name */
    t f6206u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f6207v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f6208w;

    /* renamed from: x  reason: collision with root package name */
    boolean f6209x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f6210y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f6211z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f6212a;

        /* renamed from: b  reason: collision with root package name */
        int f6213b;

        /* renamed from: c  reason: collision with root package name */
        boolean f6214c;

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
        public boolean a() {
            return this.f6212a >= 0;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f6212a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f6212a);
            parcel.writeInt(this.f6213b);
            parcel.writeInt(this.f6214c ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f6212a = parcel.readInt();
            this.f6213b = parcel.readInt();
            this.f6214c = parcel.readInt() != 1 ? false : true;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.f6212a = savedState.f6212a;
            this.f6213b = savedState.f6213b;
            this.f6214c = savedState.f6214c;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        t f6215a;

        /* renamed from: b  reason: collision with root package name */
        int f6216b;

        /* renamed from: c  reason: collision with root package name */
        int f6217c;

        /* renamed from: d  reason: collision with root package name */
        boolean f6218d;

        /* renamed from: e  reason: collision with root package name */
        boolean f6219e;

        a() {
            e();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i10;
            if (this.f6218d) {
                i10 = this.f6215a.i();
            } else {
                i10 = this.f6215a.m();
            }
            this.f6217c = i10;
        }

        public void b(View view, int i10) {
            if (this.f6218d) {
                this.f6217c = this.f6215a.d(view) + this.f6215a.o();
            } else {
                this.f6217c = this.f6215a.g(view);
            }
            this.f6216b = i10;
        }

        public void c(View view, int i10) {
            int o10 = this.f6215a.o();
            if (o10 >= 0) {
                b(view, i10);
                return;
            }
            this.f6216b = i10;
            if (this.f6218d) {
                int i11 = (this.f6215a.i() - o10) - this.f6215a.d(view);
                this.f6217c = this.f6215a.i() - i11;
                if (i11 > 0) {
                    int e10 = this.f6217c - this.f6215a.e(view);
                    int m10 = this.f6215a.m();
                    int min = e10 - (m10 + Math.min(this.f6215a.g(view) - m10, 0));
                    if (min < 0) {
                        this.f6217c += Math.min(i11, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g10 = this.f6215a.g(view);
            int m11 = g10 - this.f6215a.m();
            this.f6217c = g10;
            if (m11 > 0) {
                int i12 = (this.f6215a.i() - Math.min(0, (this.f6215a.i() - o10) - this.f6215a.d(view))) - (g10 + this.f6215a.e(view));
                if (i12 < 0) {
                    this.f6217c -= Math.min(m11, -i12);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            if (pVar.c() || pVar.a() < 0 || pVar.a() >= zVar.b()) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f6216b = -1;
            this.f6217c = Integer.MIN_VALUE;
            this.f6218d = false;
            this.f6219e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f6216b + ", mCoordinate=" + this.f6217c + ", mLayoutFromEnd=" + this.f6218d + ", mValid=" + this.f6219e + '}';
        }
    }

    protected static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f6220a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6221b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6222c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6223d;

        protected b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f6220a = 0;
            this.f6221b = false;
            this.f6222c = false;
            this.f6223d = false;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f6224a = true;

        /* renamed from: b  reason: collision with root package name */
        int f6225b;

        /* renamed from: c  reason: collision with root package name */
        int f6226c;

        /* renamed from: d  reason: collision with root package name */
        int f6227d;

        /* renamed from: e  reason: collision with root package name */
        int f6228e;

        /* renamed from: f  reason: collision with root package name */
        int f6229f;

        /* renamed from: g  reason: collision with root package name */
        int f6230g;

        /* renamed from: h  reason: collision with root package name */
        int f6231h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f6232i = 0;

        /* renamed from: j  reason: collision with root package name */
        boolean f6233j = false;

        /* renamed from: k  reason: collision with root package name */
        int f6234k;

        /* renamed from: l  reason: collision with root package name */
        List<RecyclerView.d0> f6235l = null;

        /* renamed from: m  reason: collision with root package name */
        boolean f6236m;

        c() {
        }

        private View e() {
            int size = this.f6235l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.f6235l.get(i10).f6302a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f6227d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b((View) null);
        }

        public void b(View view) {
            View f10 = f(view);
            if (f10 == null) {
                this.f6227d = -1;
            } else {
                this.f6227d = ((RecyclerView.p) f10.getLayoutParams()).a();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(RecyclerView.z zVar) {
            int i10 = this.f6227d;
            return i10 >= 0 && i10 < zVar.b();
        }

        /* access modifiers changed from: package-private */
        public View d(RecyclerView.v vVar) {
            if (this.f6235l != null) {
                return e();
            }
            View o10 = vVar.o(this.f6227d);
            this.f6227d += this.f6228e;
            return o10;
        }

        public View f(View view) {
            int a10;
            int size = this.f6235l.size();
            View view2 = null;
            int i10 = a.e.API_PRIORITY_OTHER;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = this.f6235l.get(i11).f6302a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a10 = (pVar.a() - this.f6227d) * this.f6228e) >= 0 && a10 < i10) {
                    view2 = view3;
                    if (a10 == 0) {
                        break;
                    }
                    i10 = a10;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context) {
        this(context, 1, false);
    }

    private boolean E2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        View h22;
        boolean z10;
        boolean z11 = false;
        if (K() == 0) {
            return false;
        }
        View W = W();
        if (W == null || !aVar.d(W, zVar)) {
            boolean z12 = this.f6207v;
            boolean z13 = this.f6210y;
            if (z12 != z13 || (h22 = h2(vVar, zVar, aVar.f6218d, z13)) == null) {
                return false;
            }
            aVar.b(h22, i0(h22));
            if (!zVar.e() && M1()) {
                int g10 = this.f6206u.g(h22);
                int d10 = this.f6206u.d(h22);
                int m10 = this.f6206u.m();
                int i10 = this.f6206u.i();
                if (d10 > m10 || g10 >= m10) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (g10 >= i10 && d10 > i10) {
                    z11 = true;
                }
                if (z10 || z11) {
                    if (aVar.f6218d) {
                        m10 = i10;
                    }
                    aVar.f6217c = m10;
                }
            }
            return true;
        }
        aVar.c(W, i0(W));
        return true;
    }

    private boolean F2(RecyclerView.z zVar, a aVar) {
        int i10;
        boolean z10;
        int i11;
        boolean z11 = false;
        if (!zVar.e() && (i10 = this.A) != -1) {
            if (i10 < 0 || i10 >= zVar.b()) {
                this.A = -1;
                this.B = Integer.MIN_VALUE;
            } else {
                aVar.f6216b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    boolean z12 = this.D.f6214c;
                    aVar.f6218d = z12;
                    if (z12) {
                        aVar.f6217c = this.f6206u.i() - this.D.f6213b;
                    } else {
                        aVar.f6217c = this.f6206u.m() + this.D.f6213b;
                    }
                    return true;
                } else if (this.B == Integer.MIN_VALUE) {
                    View D2 = D(this.A);
                    if (D2 == null) {
                        if (K() > 0) {
                            if (this.A < i0(J(0))) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10 == this.f6209x) {
                                z11 = true;
                            }
                            aVar.f6218d = z11;
                        }
                        aVar.a();
                    } else if (this.f6206u.e(D2) > this.f6206u.n()) {
                        aVar.a();
                        return true;
                    } else if (this.f6206u.g(D2) - this.f6206u.m() < 0) {
                        aVar.f6217c = this.f6206u.m();
                        aVar.f6218d = false;
                        return true;
                    } else if (this.f6206u.i() - this.f6206u.d(D2) < 0) {
                        aVar.f6217c = this.f6206u.i();
                        aVar.f6218d = true;
                        return true;
                    } else {
                        if (aVar.f6218d) {
                            i11 = this.f6206u.d(D2) + this.f6206u.o();
                        } else {
                            i11 = this.f6206u.g(D2);
                        }
                        aVar.f6217c = i11;
                    }
                    return true;
                } else {
                    boolean z13 = this.f6209x;
                    aVar.f6218d = z13;
                    if (z13) {
                        aVar.f6217c = this.f6206u.i() - this.B;
                    } else {
                        aVar.f6217c = this.f6206u.m() + this.B;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void G2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        int i10;
        if (!F2(zVar, aVar) && !E2(vVar, zVar, aVar)) {
            aVar.a();
            if (this.f6210y) {
                i10 = zVar.b() - 1;
            } else {
                i10 = 0;
            }
            aVar.f6216b = i10;
        }
    }

    private void H2(int i10, int i11, boolean z10, RecyclerView.z zVar) {
        int i12;
        int i13;
        this.f6205t.f6236m = x2();
        this.f6205t.f6229f = i10;
        int[] iArr = this.H;
        boolean z11 = false;
        iArr[0] = 0;
        int i14 = 1;
        iArr[1] = 0;
        N1(zVar, iArr);
        int max = Math.max(0, this.H[0]);
        int max2 = Math.max(0, this.H[1]);
        if (i10 == 1) {
            z11 = true;
        }
        c cVar = this.f6205t;
        if (z11) {
            i12 = max2;
        } else {
            i12 = max;
        }
        cVar.f6231h = i12;
        if (!z11) {
            max = max2;
        }
        cVar.f6232i = max;
        if (z11) {
            cVar.f6231h = i12 + this.f6206u.j();
            View k22 = k2();
            c cVar2 = this.f6205t;
            if (this.f6209x) {
                i14 = -1;
            }
            cVar2.f6228e = i14;
            int i02 = i0(k22);
            c cVar3 = this.f6205t;
            cVar2.f6227d = i02 + cVar3.f6228e;
            cVar3.f6225b = this.f6206u.d(k22);
            i13 = this.f6206u.d(k22) - this.f6206u.i();
        } else {
            View l22 = l2();
            this.f6205t.f6231h += this.f6206u.m();
            c cVar4 = this.f6205t;
            if (!this.f6209x) {
                i14 = -1;
            }
            cVar4.f6228e = i14;
            int i03 = i0(l22);
            c cVar5 = this.f6205t;
            cVar4.f6227d = i03 + cVar5.f6228e;
            cVar5.f6225b = this.f6206u.g(l22);
            i13 = (-this.f6206u.g(l22)) + this.f6206u.m();
        }
        c cVar6 = this.f6205t;
        cVar6.f6226c = i11;
        if (z10) {
            cVar6.f6226c = i11 - i13;
        }
        cVar6.f6230g = i13;
    }

    private void I2(int i10, int i11) {
        int i12;
        this.f6205t.f6226c = this.f6206u.i() - i11;
        c cVar = this.f6205t;
        if (this.f6209x) {
            i12 = -1;
        } else {
            i12 = 1;
        }
        cVar.f6228e = i12;
        cVar.f6227d = i10;
        cVar.f6229f = 1;
        cVar.f6225b = i11;
        cVar.f6230g = Integer.MIN_VALUE;
    }

    private void J2(a aVar) {
        I2(aVar.f6216b, aVar.f6217c);
    }

    private void K2(int i10, int i11) {
        int i12;
        this.f6205t.f6226c = i11 - this.f6206u.m();
        c cVar = this.f6205t;
        cVar.f6227d = i10;
        if (this.f6209x) {
            i12 = 1;
        } else {
            i12 = -1;
        }
        cVar.f6228e = i12;
        cVar.f6229f = -1;
        cVar.f6225b = i11;
        cVar.f6230g = Integer.MIN_VALUE;
    }

    private void L2(a aVar) {
        K2(aVar.f6216b, aVar.f6217c);
    }

    private int P1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        U1();
        t tVar = this.f6206u;
        View Z1 = Z1(!this.f6211z, true);
        return w.a(zVar, tVar, Z1, Y1(!this.f6211z, true), this, this.f6211z);
    }

    private int Q1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        U1();
        t tVar = this.f6206u;
        View Z1 = Z1(!this.f6211z, true);
        return w.b(zVar, tVar, Z1, Y1(!this.f6211z, true), this, this.f6211z, this.f6209x);
    }

    private int R1(RecyclerView.z zVar) {
        if (K() == 0) {
            return 0;
        }
        U1();
        t tVar = this.f6206u;
        View Z1 = Z1(!this.f6211z, true);
        return w.c(zVar, tVar, Z1, Y1(!this.f6211z, true), this, this.f6211z);
    }

    private View X1() {
        return d2(0, K());
    }

    private View b2() {
        return d2(K() - 1, -1);
    }

    private View f2() {
        if (this.f6209x) {
            return X1();
        }
        return b2();
    }

    private View g2() {
        if (this.f6209x) {
            return b2();
        }
        return X1();
    }

    private int i2(int i10, RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int i11;
        int i12 = this.f6206u.i() - i10;
        if (i12 <= 0) {
            return 0;
        }
        int i13 = -z2(-i12, vVar, zVar);
        int i14 = i10 + i13;
        if (!z10 || (i11 = this.f6206u.i() - i14) <= 0) {
            return i13;
        }
        this.f6206u.r(i11);
        return i11 + i13;
    }

    private int j2(int i10, RecyclerView.v vVar, RecyclerView.z zVar, boolean z10) {
        int m10;
        int m11 = i10 - this.f6206u.m();
        if (m11 <= 0) {
            return 0;
        }
        int i11 = -z2(m11, vVar, zVar);
        int i12 = i10 + i11;
        if (!z10 || (m10 = i12 - this.f6206u.m()) <= 0) {
            return i11;
        }
        this.f6206u.r(-m10);
        return i11 - m10;
    }

    private View k2() {
        return J(this.f6209x ? 0 : K() - 1);
    }

    private View l2() {
        return J(this.f6209x ? K() - 1 : 0);
    }

    private void r2(RecyclerView.v vVar, RecyclerView.z zVar, int i10, int i11) {
        boolean z10;
        RecyclerView.v vVar2 = vVar;
        RecyclerView.z zVar2 = zVar;
        if (zVar.g() && K() != 0 && !zVar.e() && M1()) {
            List<RecyclerView.d0> k10 = vVar.k();
            int size = k10.size();
            int i02 = i0(J(0));
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                RecyclerView.d0 d0Var = k10.get(i14);
                if (!d0Var.E()) {
                    boolean z11 = true;
                    if (d0Var.u() < i02) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10 != this.f6209x) {
                        z11 = true;
                    }
                    if (z11) {
                        i12 += this.f6206u.e(d0Var.f6302a);
                    } else {
                        i13 += this.f6206u.e(d0Var.f6302a);
                    }
                }
            }
            this.f6205t.f6235l = k10;
            if (i12 > 0) {
                K2(i0(l2()), i10);
                c cVar = this.f6205t;
                cVar.f6231h = i12;
                cVar.f6226c = 0;
                cVar.a();
                V1(vVar2, this.f6205t, zVar2, false);
            }
            if (i13 > 0) {
                I2(i0(k2()), i11);
                c cVar2 = this.f6205t;
                cVar2.f6231h = i13;
                cVar2.f6226c = 0;
                cVar2.a();
                V1(vVar2, this.f6205t, zVar2, false);
            }
            this.f6205t.f6235l = null;
        }
    }

    private void t2(RecyclerView.v vVar, c cVar) {
        if (cVar.f6224a && !cVar.f6236m) {
            int i10 = cVar.f6230g;
            int i11 = cVar.f6232i;
            if (cVar.f6229f == -1) {
                v2(vVar, i10, i11);
            } else {
                w2(vVar, i10, i11);
            }
        }
    }

    private void u2(RecyclerView.v vVar, int i10, int i11) {
        if (i10 != i11) {
            if (i11 > i10) {
                for (int i12 = i11 - 1; i12 >= i10; i12--) {
                    o1(i12, vVar);
                }
                return;
            }
            while (i10 > i11) {
                o1(i10, vVar);
                i10--;
            }
        }
    }

    private void v2(RecyclerView.v vVar, int i10, int i11) {
        int K = K();
        if (i10 >= 0) {
            int h10 = (this.f6206u.h() - i10) + i11;
            if (this.f6209x) {
                for (int i12 = 0; i12 < K; i12++) {
                    View J = J(i12);
                    if (this.f6206u.g(J) < h10 || this.f6206u.q(J) < h10) {
                        u2(vVar, 0, i12);
                        return;
                    }
                }
                return;
            }
            int i13 = K - 1;
            for (int i14 = i13; i14 >= 0; i14--) {
                View J2 = J(i14);
                if (this.f6206u.g(J2) < h10 || this.f6206u.q(J2) < h10) {
                    u2(vVar, i13, i14);
                    return;
                }
            }
        }
    }

    private void w2(RecyclerView.v vVar, int i10, int i11) {
        if (i10 >= 0) {
            int i12 = i10 - i11;
            int K = K();
            if (this.f6209x) {
                int i13 = K - 1;
                for (int i14 = i13; i14 >= 0; i14--) {
                    View J = J(i14);
                    if (this.f6206u.d(J) > i12 || this.f6206u.p(J) > i12) {
                        u2(vVar, i13, i14);
                        return;
                    }
                }
                return;
            }
            for (int i15 = 0; i15 < K; i15++) {
                View J2 = J(i15);
                if (this.f6206u.d(J2) > i12 || this.f6206u.p(J2) > i12) {
                    u2(vVar, 0, i15);
                    return;
                }
            }
        }
    }

    private void y2() {
        if (this.f6204s == 1 || !o2()) {
            this.f6209x = this.f6208w;
        } else {
            this.f6209x = !this.f6208w;
        }
    }

    public void A2(int i10, int i11) {
        this.A = i10;
        this.B = i11;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.c();
        }
        u1();
    }

    public void B2(int i10) {
        if (i10 == 0 || i10 == 1) {
            h((String) null);
            if (i10 != this.f6204s || this.f6206u == null) {
                t b10 = t.b(this, i10);
                this.f6206u = b10;
                this.E.f6215a = b10;
                this.f6204s = i10;
                u1();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i10);
    }

    public void C2(boolean z10) {
        h((String) null);
        if (z10 != this.f6208w) {
            this.f6208w = z10;
            u1();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public View D(int i10) {
        int K = K();
        if (K == 0) {
            return null;
        }
        int i02 = i10 - i0(J(0));
        if (i02 >= 0 && i02 < K) {
            View J = J(i02);
            if (i0(J) == i10) {
                return J;
            }
        }
        return super.D(i10);
    }

    public void D2(boolean z10) {
        h((String) null);
        if (this.f6210y != z10) {
            this.f6210y = z10;
            u1();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public RecyclerView.p E() {
        return new RecyclerView.p(-2, -2);
    }

    /* access modifiers changed from: package-private */
    public boolean H1() {
        if (Y() == 1073741824 || q0() == 1073741824 || !r0()) {
            return false;
        }
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public void J0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.J0(recyclerView, vVar);
        if (this.C) {
            l1(vVar);
            vVar.c();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void J1(RecyclerView recyclerView, RecyclerView.z zVar, int i10) {
        p pVar = new p(recyclerView.getContext());
        pVar.p(i10);
        K1(pVar);
    }

    @SuppressLint({"UnknownNullness"})
    public View K0(View view, int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        int S1;
        View view2;
        View view3;
        y2();
        if (K() == 0 || (S1 = S1(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        U1();
        H2(S1, (int) (((float) this.f6206u.n()) * 0.33333334f), false, zVar);
        c cVar = this.f6205t;
        cVar.f6230g = Integer.MIN_VALUE;
        cVar.f6224a = false;
        V1(vVar, cVar, zVar, true);
        if (S1 == -1) {
            view2 = g2();
        } else {
            view2 = f2();
        }
        if (S1 == -1) {
            view3 = l2();
        } else {
            view3 = k2();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    @SuppressLint({"UnknownNullness"})
    public void L0(AccessibilityEvent accessibilityEvent) {
        super.L0(accessibilityEvent);
        if (K() > 0) {
            accessibilityEvent.setFromIndex(a2());
            accessibilityEvent.setToIndex(c2());
        }
    }

    public boolean M1() {
        return this.D == null && this.f6207v == this.f6210y;
    }

    /* access modifiers changed from: protected */
    public void N1(@NonNull RecyclerView.z zVar, @NonNull int[] iArr) {
        int i10;
        int m22 = m2(zVar);
        if (this.f6205t.f6229f == -1) {
            i10 = 0;
        } else {
            i10 = m22;
            m22 = 0;
        }
        iArr[0] = m22;
        iArr[1] = i10;
    }

    /* access modifiers changed from: package-private */
    public void O1(RecyclerView.z zVar, c cVar, RecyclerView.o.c cVar2) {
        int i10 = cVar.f6227d;
        if (i10 >= 0 && i10 < zVar.b()) {
            cVar2.a(i10, Math.max(0, cVar.f6230g));
        }
    }

    /* access modifiers changed from: package-private */
    public int S1(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 17) {
                    if (i10 != 33) {
                        if (i10 != 66) {
                            if (i10 != 130) {
                                return Integer.MIN_VALUE;
                            }
                            if (this.f6204s == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.f6204s == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.f6204s == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.f6204s == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.f6204s != 1 && o2()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.f6204s != 1 && o2()) {
            return 1;
        } else {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public c T1() {
        return new c();
    }

    /* access modifiers changed from: package-private */
    public void U1() {
        if (this.f6205t == null) {
            this.f6205t = T1();
        }
    }

    /* access modifiers changed from: package-private */
    public int V1(RecyclerView.v vVar, c cVar, RecyclerView.z zVar, boolean z10) {
        int i10 = cVar.f6226c;
        int i11 = cVar.f6230g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f6230g = i11 + i10;
            }
            t2(vVar, cVar);
        }
        int i12 = cVar.f6226c + cVar.f6231h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f6236m && i12 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            q2(vVar, zVar, cVar, bVar);
            if (!bVar.f6221b) {
                cVar.f6225b += bVar.f6220a * cVar.f6229f;
                if (!bVar.f6222c || cVar.f6235l != null || !zVar.e()) {
                    int i13 = cVar.f6226c;
                    int i14 = bVar.f6220a;
                    cVar.f6226c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = cVar.f6230g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + bVar.f6220a;
                    cVar.f6230g = i16;
                    int i17 = cVar.f6226c;
                    if (i17 < 0) {
                        cVar.f6230g = i16 + i17;
                    }
                    t2(vVar, cVar);
                }
                if (z10 && bVar.f6223d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f6226c;
    }

    public int W1() {
        View e22 = e2(0, K(), true, false);
        if (e22 == null) {
            return -1;
        }
        return i0(e22);
    }

    @SuppressLint({"UnknownNullness"})
    public void Y0(RecyclerView.v vVar, RecyclerView.z zVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        View D2;
        int i17;
        int i18;
        int i19 = -1;
        if (!(this.D == null && this.A == -1) && zVar.b() == 0) {
            l1(vVar);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.f6212a;
        }
        U1();
        this.f6205t.f6224a = false;
        y2();
        View W = W();
        a aVar = this.E;
        if (!aVar.f6219e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.f6218d = this.f6209x ^ this.f6210y;
            G2(vVar, zVar, aVar2);
            this.E.f6219e = true;
        } else if (W != null && (this.f6206u.g(W) >= this.f6206u.i() || this.f6206u.d(W) <= this.f6206u.m())) {
            this.E.c(W, i0(W));
        }
        c cVar = this.f6205t;
        if (cVar.f6234k >= 0) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        cVar.f6229f = i10;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        N1(zVar, iArr);
        int max = Math.max(0, this.H[0]) + this.f6206u.m();
        int max2 = Math.max(0, this.H[1]) + this.f6206u.j();
        if (!(!zVar.e() || (i16 = this.A) == -1 || this.B == Integer.MIN_VALUE || (D2 = D(i16)) == null)) {
            if (this.f6209x) {
                i17 = this.f6206u.i() - this.f6206u.d(D2);
                i18 = this.B;
            } else {
                i18 = this.f6206u.g(D2) - this.f6206u.m();
                i17 = this.B;
            }
            int i20 = i17 - i18;
            if (i20 > 0) {
                max += i20;
            } else {
                max2 -= i20;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.f6218d ? !this.f6209x : this.f6209x) {
            i19 = 1;
        }
        s2(vVar, zVar, aVar3, i19);
        x(vVar);
        this.f6205t.f6236m = x2();
        this.f6205t.f6233j = zVar.e();
        this.f6205t.f6232i = 0;
        a aVar4 = this.E;
        if (aVar4.f6218d) {
            L2(aVar4);
            c cVar2 = this.f6205t;
            cVar2.f6231h = max;
            V1(vVar, cVar2, zVar, false);
            c cVar3 = this.f6205t;
            i12 = cVar3.f6225b;
            int i21 = cVar3.f6227d;
            int i22 = cVar3.f6226c;
            if (i22 > 0) {
                max2 += i22;
            }
            J2(this.E);
            c cVar4 = this.f6205t;
            cVar4.f6231h = max2;
            cVar4.f6227d += cVar4.f6228e;
            V1(vVar, cVar4, zVar, false);
            c cVar5 = this.f6205t;
            i11 = cVar5.f6225b;
            int i23 = cVar5.f6226c;
            if (i23 > 0) {
                K2(i21, i12);
                c cVar6 = this.f6205t;
                cVar6.f6231h = i23;
                V1(vVar, cVar6, zVar, false);
                i12 = this.f6205t.f6225b;
            }
        } else {
            J2(aVar4);
            c cVar7 = this.f6205t;
            cVar7.f6231h = max2;
            V1(vVar, cVar7, zVar, false);
            c cVar8 = this.f6205t;
            i11 = cVar8.f6225b;
            int i24 = cVar8.f6227d;
            int i25 = cVar8.f6226c;
            if (i25 > 0) {
                max += i25;
            }
            L2(this.E);
            c cVar9 = this.f6205t;
            cVar9.f6231h = max;
            cVar9.f6227d += cVar9.f6228e;
            V1(vVar, cVar9, zVar, false);
            c cVar10 = this.f6205t;
            i12 = cVar10.f6225b;
            int i26 = cVar10.f6226c;
            if (i26 > 0) {
                I2(i24, i11);
                c cVar11 = this.f6205t;
                cVar11.f6231h = i26;
                V1(vVar, cVar11, zVar, false);
                i11 = this.f6205t.f6225b;
            }
        }
        if (K() > 0) {
            if (this.f6209x ^ this.f6210y) {
                int i27 = i2(i11, vVar, zVar, true);
                i14 = i12 + i27;
                i13 = i11 + i27;
                i15 = j2(i14, vVar, zVar, false);
            } else {
                int j22 = j2(i12, vVar, zVar, true);
                i14 = i12 + j22;
                i13 = i11 + j22;
                i15 = i2(i13, vVar, zVar, false);
            }
            i12 = i14 + i15;
            i11 = i13 + i15;
        }
        r2(vVar, zVar, i12, i11);
        if (!zVar.e()) {
            this.f6206u.s();
        } else {
            this.E.e();
        }
        this.f6207v = this.f6210y;
    }

    /* access modifiers changed from: package-private */
    public View Y1(boolean z10, boolean z11) {
        if (this.f6209x) {
            return e2(0, K(), z10, z11);
        }
        return e2(K() - 1, -1, z10, z11);
    }

    @SuppressLint({"UnknownNullness"})
    public void Z0(RecyclerView.z zVar) {
        super.Z0(zVar);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    /* access modifiers changed from: package-private */
    public View Z1(boolean z10, boolean z11) {
        if (this.f6209x) {
            return e2(K() - 1, -1, z10, z11);
        }
        return e2(0, K(), z10, z11);
    }

    @SuppressLint({"UnknownNullness"})
    public PointF a(int i10) {
        if (K() == 0) {
            return null;
        }
        boolean z10 = false;
        int i11 = 1;
        if (i10 < i0(J(0))) {
            z10 = true;
        }
        if (z10 != this.f6209x) {
            i11 = -1;
        }
        if (this.f6204s == 0) {
            return new PointF((float) i11, 0.0f);
        }
        return new PointF(0.0f, (float) i11);
    }

    public int a2() {
        View e22 = e2(0, K(), false, true);
        if (e22 == null) {
            return -1;
        }
        return i0(e22);
    }

    public void b(@NonNull View view, @NonNull View view2, int i10, int i11) {
        boolean z10;
        h("Cannot drop a view during a scroll or layout calculation");
        U1();
        y2();
        int i02 = i0(view);
        int i03 = i0(view2);
        if (i02 < i03) {
            z10 = true;
        } else {
            z10 = true;
        }
        if (this.f6209x) {
            if (z10) {
                A2(i03, this.f6206u.i() - (this.f6206u.g(view2) + this.f6206u.e(view)));
            } else {
                A2(i03, this.f6206u.i() - this.f6206u.d(view2));
            }
        } else if (z10) {
            A2(i03, this.f6206u.g(view2));
        } else {
            A2(i03, this.f6206u.d(view2) - this.f6206u.e(view));
        }
    }

    public int c2() {
        View e22 = e2(K() - 1, -1, false, true);
        if (e22 == null) {
            return -1;
        }
        return i0(e22);
    }

    @SuppressLint({"UnknownNullness"})
    public void d1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.D = savedState;
            if (this.A != -1) {
                savedState.c();
            }
            u1();
        }
    }

    /* access modifiers changed from: package-private */
    public View d2(int i10, int i11) {
        char c10;
        int i12;
        int i13;
        U1();
        if (i11 > i10) {
            c10 = 1;
        } else if (i11 < i10) {
            c10 = 65535;
        } else {
            c10 = 0;
        }
        if (c10 == 0) {
            return J(i10);
        }
        if (this.f6206u.g(J(i10)) < this.f6206u.m()) {
            i13 = 16644;
            i12 = 16388;
        } else {
            i13 = 4161;
            i12 = 4097;
        }
        if (this.f6204s == 0) {
            return this.f6339e.a(i10, i11, i13, i12);
        }
        return this.f6340f.a(i10, i11, i13, i12);
    }

    @SuppressLint({"UnknownNullness"})
    public Parcelable e1() {
        if (this.D != null) {
            return new SavedState(this.D);
        }
        SavedState savedState = new SavedState();
        if (K() > 0) {
            U1();
            boolean z10 = this.f6207v ^ this.f6209x;
            savedState.f6214c = z10;
            if (z10) {
                View k22 = k2();
                savedState.f6213b = this.f6206u.i() - this.f6206u.d(k22);
                savedState.f6212a = i0(k22);
            } else {
                View l22 = l2();
                savedState.f6212a = i0(l22);
                savedState.f6213b = this.f6206u.g(l22) - this.f6206u.m();
            }
        } else {
            savedState.c();
        }
        return savedState;
    }

    /* access modifiers changed from: package-private */
    public View e2(int i10, int i11, boolean z10, boolean z11) {
        int i12;
        U1();
        int i13 = 320;
        if (z10) {
            i12 = 24579;
        } else {
            i12 = 320;
        }
        if (!z11) {
            i13 = 0;
        }
        if (this.f6204s == 0) {
            return this.f6339e.a(i10, i11, i12, i13);
        }
        return this.f6340f.a(i10, i11, i12, i13);
    }

    @SuppressLint({"UnknownNullness"})
    public void h(String str) {
        if (this.D == null) {
            super.h(str);
        }
    }

    /* access modifiers changed from: package-private */
    public View h2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean z12;
        boolean z13;
        U1();
        int K = K();
        int i12 = -1;
        if (z11) {
            i11 = K() - 1;
            i10 = -1;
        } else {
            i12 = K;
            i11 = 0;
            i10 = 1;
        }
        int b10 = zVar.b();
        int m10 = this.f6206u.m();
        int i13 = this.f6206u.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i11 != i12) {
            View J = J(i11);
            int i02 = i0(J);
            int g10 = this.f6206u.g(J);
            int d10 = this.f6206u.d(J);
            if (i02 >= 0 && i02 < b10) {
                if (!((RecyclerView.p) J.getLayoutParams()).c()) {
                    if (d10 > m10 || g10 >= m10) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (g10 < i13 || d10 <= i13) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (!z12 && !z13) {
                        return J;
                    }
                    if (z10) {
                        if (!z13) {
                            if (view != null) {
                            }
                            view = J;
                        }
                    } else if (!z12) {
                        if (view != null) {
                        }
                        view = J;
                    }
                    view2 = J;
                } else if (view3 == null) {
                    view3 = J;
                }
            }
            i11 += i10;
        }
        if (view != null) {
            return view;
        }
        if (view2 != null) {
            return view2;
        }
        return view3;
    }

    public boolean l() {
        return this.f6204s == 0;
    }

    public boolean m() {
        return this.f6204s == 1;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int m2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.f6206u.n();
        }
        return 0;
    }

    public int n2() {
        return this.f6204s;
    }

    /* access modifiers changed from: protected */
    public boolean o2() {
        return a0() == 1;
    }

    @SuppressLint({"UnknownNullness"})
    public void p(int i10, int i11, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        int i12;
        if (this.f6204s != 0) {
            i10 = i11;
        }
        if (K() != 0 && i10 != 0) {
            U1();
            if (i10 > 0) {
                i12 = 1;
            } else {
                i12 = -1;
            }
            H2(i12, Math.abs(i10), true, zVar);
            O1(zVar, this.f6205t, cVar);
        }
    }

    public boolean p2() {
        return this.f6211z;
    }

    @SuppressLint({"UnknownNullness"})
    public void q(int i10, RecyclerView.o.c cVar) {
        boolean z10;
        int i11;
        SavedState savedState = this.D;
        int i12 = -1;
        if (savedState == null || !savedState.a()) {
            y2();
            z10 = this.f6209x;
            i11 = this.A;
            if (i11 == -1) {
                if (z10) {
                    i11 = i10 - 1;
                } else {
                    i11 = 0;
                }
            }
        } else {
            SavedState savedState2 = this.D;
            z10 = savedState2.f6214c;
            i11 = savedState2.f6212a;
        }
        if (!z10) {
            i12 = 1;
        }
        for (int i13 = 0; i13 < this.G && i11 >= 0 && i11 < i10; i13++) {
            cVar.a(i11, 0);
            i11 += i12;
        }
    }

    /* access modifiers changed from: package-private */
    public void q2(RecyclerView.v vVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z10;
        boolean z11;
        View d10 = cVar.d(vVar);
        if (d10 == null) {
            bVar.f6221b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) d10.getLayoutParams();
        if (cVar.f6235l == null) {
            boolean z12 = this.f6209x;
            if (cVar.f6229f == -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z12 == z11) {
                e(d10);
            } else {
                f(d10, 0);
            }
        } else {
            boolean z13 = this.f6209x;
            if (cVar.f6229f == -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z13 == z10) {
                c(d10);
            } else {
                d(d10, 0);
            }
        }
        B0(d10, 0, 0);
        bVar.f6220a = this.f6206u.e(d10);
        if (this.f6204s == 1) {
            if (o2()) {
                i14 = p0() - g0();
                i13 = i14 - this.f6206u.f(d10);
            } else {
                i13 = f0();
                i14 = this.f6206u.f(d10) + i13;
            }
            if (cVar.f6229f == -1) {
                int i15 = cVar.f6225b;
                i10 = i15;
                i11 = i14;
                i12 = i15 - bVar.f6220a;
            } else {
                int i16 = cVar.f6225b;
                i12 = i16;
                i11 = i14;
                i10 = bVar.f6220a + i16;
            }
        } else {
            int h02 = h0();
            int f10 = this.f6206u.f(d10) + h02;
            if (cVar.f6229f == -1) {
                int i17 = cVar.f6225b;
                i11 = i17;
                i12 = h02;
                i10 = f10;
                i13 = i17 - bVar.f6220a;
            } else {
                int i18 = cVar.f6225b;
                i12 = h02;
                i11 = bVar.f6220a + i18;
                i10 = f10;
                i13 = i18;
            }
        }
        A0(d10, i13, i12, i11, i10);
        if (pVar.c() || pVar.b()) {
            bVar.f6222c = true;
        }
        bVar.f6223d = d10.hasFocusable();
    }

    @SuppressLint({"UnknownNullness"})
    public int r(RecyclerView.z zVar) {
        return P1(zVar);
    }

    @SuppressLint({"UnknownNullness"})
    public int s(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    /* access modifiers changed from: package-private */
    public void s2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar, int i10) {
    }

    @SuppressLint({"UnknownNullness"})
    public int t(RecyclerView.z zVar) {
        return R1(zVar);
    }

    public boolean t0() {
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public int u(RecyclerView.z zVar) {
        return P1(zVar);
    }

    @SuppressLint({"UnknownNullness"})
    public int v(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @SuppressLint({"UnknownNullness"})
    public int w(RecyclerView.z zVar) {
        return R1(zVar);
    }

    @SuppressLint({"UnknownNullness"})
    public int x1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f6204s == 1) {
            return 0;
        }
        return z2(i10, vVar, zVar);
    }

    /* access modifiers changed from: package-private */
    public boolean x2() {
        if (this.f6206u.k() == 0 && this.f6206u.h() == 0) {
            return true;
        }
        return false;
    }

    public void y1(int i10) {
        this.A = i10;
        this.B = Integer.MIN_VALUE;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.c();
        }
        u1();
    }

    @SuppressLint({"UnknownNullness"})
    public int z1(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.f6204s == 0) {
            return 0;
        }
        return z2(i10, vVar, zVar);
    }

    /* access modifiers changed from: package-private */
    public int z2(int i10, RecyclerView.v vVar, RecyclerView.z zVar) {
        int i11;
        if (K() == 0 || i10 == 0) {
            return 0;
        }
        U1();
        this.f6205t.f6224a = true;
        if (i10 > 0) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        int abs = Math.abs(i10);
        H2(i11, abs, true, zVar);
        c cVar = this.f6205t;
        int V1 = cVar.f6230g + V1(vVar, cVar, zVar, false);
        if (V1 < 0) {
            return 0;
        }
        if (abs > V1) {
            i10 = i11 * V1;
        }
        this.f6206u.r(-i10);
        this.f6205t.f6234k = i10;
        return i10;
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context, int i10, boolean z10) {
        this.f6204s = 1;
        this.f6208w = false;
        this.f6209x = false;
        this.f6210y = false;
        this.f6211z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        B2(i10);
        C2(z10);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f6204s = 1;
        this.f6208w = false;
        this.f6209x = false;
        this.f6210y = false;
        this.f6211z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.o.d j02 = RecyclerView.o.j0(context, attributeSet, i10, i11);
        B2(j02.f6355a);
        C2(j02.f6357c);
        D2(j02.f6358d);
    }
}
