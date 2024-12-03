package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;

public class d0 {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f4808a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f4809b;

    /* renamed from: c  reason: collision with root package name */
    private final View f4810c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4811d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f4812e;

    public d0(@NonNull View view) {
        this.f4810c = view;
    }

    private boolean g(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        ViewParent h10;
        int i15;
        int i16;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!l() || (h10 = h(i14)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f4810c.getLocationInWindow(iArr4);
            i16 = iArr4[0];
            i15 = iArr4[1];
        } else {
            i16 = 0;
            i15 = 0;
        }
        if (iArr2 == null) {
            int[] i17 = i();
            i17[0] = 0;
            i17[1] = 0;
            iArr3 = i17;
        } else {
            iArr3 = iArr2;
        }
        c2.d(h10, this.f4810c, i10, i11, i12, i13, i14, iArr3);
        if (iArr4 != null) {
            this.f4810c.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i16;
            iArr4[1] = iArr4[1] - i15;
        }
        return true;
    }

    private ViewParent h(int i10) {
        if (i10 == 0) {
            return this.f4808a;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f4809b;
    }

    private int[] i() {
        if (this.f4812e == null) {
            this.f4812e = new int[2];
        }
        return this.f4812e;
    }

    private void n(int i10, ViewParent viewParent) {
        if (i10 == 0) {
            this.f4808a = viewParent;
        } else if (i10 == 1) {
            this.f4809b = viewParent;
        }
    }

    public boolean a(float f10, float f11, boolean z10) {
        ViewParent h10;
        if (!l() || (h10 = h(0)) == null) {
            return false;
        }
        return c2.a(h10, this.f4810c, f10, f11, z10);
    }

    public boolean b(float f10, float f11) {
        ViewParent h10;
        if (!l() || (h10 = h(0)) == null) {
            return false;
        }
        return c2.b(h10, this.f4810c, f10, f11);
    }

    public boolean c(int i10, int i11, int[] iArr, int[] iArr2) {
        return d(i10, i11, iArr, iArr2, 0);
    }

    public boolean d(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        ViewParent h10;
        int i13;
        int i14;
        if (!l() || (h10 = h(i12)) == null) {
            return false;
        }
        if (i10 != 0 || i11 != 0) {
            if (iArr2 != null) {
                this.f4810c.getLocationInWindow(iArr2);
                i14 = iArr2[0];
                i13 = iArr2[1];
            } else {
                i14 = 0;
                i13 = 0;
            }
            if (iArr == null) {
                iArr = i();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            c2.c(h10, this.f4810c, i10, i11, iArr, i12);
            if (iArr2 != null) {
                this.f4810c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i14;
                iArr2[1] = iArr2[1] - i13;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public void e(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        g(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public boolean f(int i10, int i11, int i12, int i13, int[] iArr) {
        return g(i10, i11, i12, i13, iArr, 0, (int[]) null);
    }

    public boolean j() {
        return k(0);
    }

    public boolean k(int i10) {
        return h(i10) != null;
    }

    public boolean l() {
        return this.f4811d;
    }

    public void m(boolean z10) {
        if (this.f4811d) {
            n0.S0(this.f4810c);
        }
        this.f4811d = z10;
    }

    public boolean o(int i10) {
        return p(i10, 0);
    }

    public boolean p(int i10, int i11) {
        if (k(i11)) {
            return true;
        }
        if (!l()) {
            return false;
        }
        View view = this.f4810c;
        for (ViewParent parent = this.f4810c.getParent(); parent != null; parent = parent.getParent()) {
            if (c2.f(parent, view, this.f4810c, i10, i11)) {
                n(i11, parent);
                c2.e(parent, view, this.f4810c, i10, i11);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void q() {
        r(0);
    }

    public void r(int i10) {
        ViewParent h10 = h(i10);
        if (h10 != null) {
            c2.g(h10, this.f4810c, i10);
            n(i10, (ViewParent) null);
        }
    }
}
