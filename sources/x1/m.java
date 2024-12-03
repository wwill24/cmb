package x1;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.core.view.n0;

public class m extends q0 {
    private static final TimeInterpolator U = new DecelerateInterpolator();
    private static final TimeInterpolator V = new AccelerateInterpolator();
    private static final g W = new a();
    private static final g X = new b();
    private static final g Y = new c();
    private static final g Z = new d();

    /* renamed from: a0  reason: collision with root package name */
    private static final g f18428a0 = new e();

    /* renamed from: b0  reason: collision with root package name */
    private static final g f18429b0 = new f();
    private g S = f18429b0;
    private int T = 80;

    class a extends h {
        a() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    class b extends h {
        b() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            boolean z10 = true;
            if (n0.B(viewGroup) != 1) {
                z10 = false;
            }
            if (z10) {
                return view.getTranslationX() + ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    class c extends i {
        c() {
            super((a) null);
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    }

    class d extends h {
        d() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    class e extends h {
        e() {
            super((a) null);
        }

        public float b(ViewGroup viewGroup, View view) {
            boolean z10 = true;
            if (n0.B(viewGroup) != 1) {
                z10 = false;
            }
            if (z10) {
                return view.getTranslationX() - ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    class f extends i {
        f() {
            super((a) null);
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    }

    private interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    private static abstract class h implements g {
        private h() {
        }

        /* synthetic */ h(a aVar) {
            this();
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    private static abstract class i implements g {
        private i() {
        }

        /* synthetic */ i(a aVar) {
            this();
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public m(int i10) {
        s0(i10);
    }

    private void l0(u uVar) {
        int[] iArr = new int[2];
        uVar.f18493b.getLocationOnScreen(iArr);
        uVar.f18492a.put("android:slide:screenPosition", iArr);
    }

    public void h(@NonNull u uVar) {
        super.h(uVar);
        l0(uVar);
    }

    public void k(@NonNull u uVar) {
        super.k(uVar);
        l0(uVar);
    }

    public Animator n0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        if (uVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) uVar2.f18492a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return w.a(view, uVar2, iArr[0], iArr[1], this.S.b(viewGroup, view), this.S.a(viewGroup, view), translationX, translationY, U, this);
    }

    public Animator p0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        if (uVar == null) {
            return null;
        }
        int[] iArr = (int[]) uVar.f18492a.get("android:slide:screenPosition");
        return w.a(view, uVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.S.b(viewGroup, view), this.S.a(viewGroup, view), V, this);
    }

    public void s0(int i10) {
        if (i10 == 3) {
            this.S = W;
        } else if (i10 == 5) {
            this.S = Z;
        } else if (i10 == 48) {
            this.S = Y;
        } else if (i10 == 80) {
            this.S = f18429b0;
        } else if (i10 == 8388611) {
            this.S = X;
        } else if (i10 == 8388613) {
            this.S = f18428a0;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.T = i10;
        l lVar = new l();
        lVar.j(i10);
        h0(lVar);
    }
}
