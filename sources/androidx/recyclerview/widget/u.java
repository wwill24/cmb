package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.a;

public class u extends y {

    /* renamed from: d  reason: collision with root package name */
    private t f6710d;

    /* renamed from: e  reason: collision with root package name */
    private t f6711e;

    class a extends p {
        a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void o(@NonNull View view, @NonNull RecyclerView.z zVar, @NonNull RecyclerView.y.a aVar) {
            u uVar = u.this;
            int[] c10 = uVar.c(uVar.f6718a.getLayoutManager(), view);
            int i10 = c10[0];
            int i11 = c10[1];
            int w10 = w(Math.max(Math.abs(i10), Math.abs(i11)));
            if (w10 > 0) {
                aVar.d(i10, i11, w10, this.f6696j);
            }
        }

        /* access modifiers changed from: protected */
        public float v(@NonNull DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }

        /* access modifiers changed from: protected */
        public int x(int i10) {
            return Math.min(100, super.x(i10));
        }
    }

    private int k(@NonNull View view, t tVar) {
        return (tVar.g(view) + (tVar.e(view) / 2)) - (tVar.m() + (tVar.n() / 2));
    }

    private View l(RecyclerView.o oVar, t tVar) {
        int K = oVar.K();
        View view = null;
        if (K == 0) {
            return null;
        }
        int m10 = tVar.m() + (tVar.n() / 2);
        int i10 = a.e.API_PRIORITY_OTHER;
        for (int i11 = 0; i11 < K; i11++) {
            View J = oVar.J(i11);
            int abs = Math.abs((tVar.g(J) + (tVar.e(J) / 2)) - m10);
            if (abs < i10) {
                view = J;
                i10 = abs;
            }
        }
        return view;
    }

    @NonNull
    private t m(@NonNull RecyclerView.o oVar) {
        t tVar = this.f6711e;
        if (tVar == null || tVar.f6707a != oVar) {
            this.f6711e = t.a(oVar);
        }
        return this.f6711e;
    }

    private t n(RecyclerView.o oVar) {
        if (oVar.m()) {
            return o(oVar);
        }
        if (oVar.l()) {
            return m(oVar);
        }
        return null;
    }

    @NonNull
    private t o(@NonNull RecyclerView.o oVar) {
        t tVar = this.f6710d;
        if (tVar == null || tVar.f6707a != oVar) {
            this.f6710d = t.c(oVar);
        }
        return this.f6710d;
    }

    private boolean p(RecyclerView.o oVar, int i10, int i11) {
        return oVar.l() ? i10 > 0 : i11 > 0;
    }

    private boolean q(RecyclerView.o oVar) {
        PointF a10;
        int Z = oVar.Z();
        if (!(oVar instanceof RecyclerView.y.b) || (a10 = ((RecyclerView.y.b) oVar).a(Z - 1)) == null) {
            return false;
        }
        if (a10.x < 0.0f || a10.y < 0.0f) {
            return true;
        }
        return false;
    }

    public int[] c(@NonNull RecyclerView.o oVar, @NonNull View view) {
        int[] iArr = new int[2];
        if (oVar.l()) {
            iArr[0] = k(view, m(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.m()) {
            iArr[1] = k(view, o(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.y d(@NonNull RecyclerView.o oVar) {
        if (!(oVar instanceof RecyclerView.y.b)) {
            return null;
        }
        return new a(this.f6718a.getContext());
    }

    @SuppressLint({"UnknownNullness"})
    public View f(RecyclerView.o oVar) {
        if (oVar.m()) {
            return l(oVar, o(oVar));
        }
        if (oVar.l()) {
            return l(oVar, m(oVar));
        }
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public int g(RecyclerView.o oVar, int i10, int i11) {
        t n10;
        int i12;
        int Z = oVar.Z();
        if (Z == 0 || (n10 = n(oVar)) == null) {
            return -1;
        }
        int i13 = Integer.MIN_VALUE;
        int i14 = a.e.API_PRIORITY_OTHER;
        int K = oVar.K();
        View view = null;
        View view2 = null;
        for (int i15 = 0; i15 < K; i15++) {
            View J = oVar.J(i15);
            if (J != null) {
                int k10 = k(J, n10);
                if (k10 <= 0 && k10 > i13) {
                    view2 = J;
                    i13 = k10;
                }
                if (k10 >= 0 && k10 < i14) {
                    view = J;
                    i14 = k10;
                }
            }
        }
        boolean p10 = p(oVar, i10, i11);
        if (p10 && view != null) {
            return oVar.i0(view);
        }
        if (!p10 && view2 != null) {
            return oVar.i0(view2);
        }
        if (p10) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int i02 = oVar.i0(view);
        if (q(oVar) == p10) {
            i12 = -1;
        } else {
            i12 = 1;
        }
        int i16 = i02 + i12;
        if (i16 < 0 || i16 >= Z) {
            return -1;
        }
        return i16;
    }
}
