package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.k;
import androidx.core.view.accessibility.n;
import androidx.core.view.n0;
import z0.c;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    z0.c f19181a;

    /* renamed from: b  reason: collision with root package name */
    c f19182b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19183c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f19184d;

    /* renamed from: e  reason: collision with root package name */
    private float f19185e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19186f;

    /* renamed from: g  reason: collision with root package name */
    int f19187g = 2;

    /* renamed from: h  reason: collision with root package name */
    float f19188h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    float f19189i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    float f19190j = 0.5f;

    /* renamed from: k  reason: collision with root package name */
    private final c.C0226c f19191k = new a();

    class a extends c.C0226c {

        /* renamed from: a  reason: collision with root package name */
        private int f19192a;

        /* renamed from: b  reason: collision with root package name */
        private int f19193b = -1;

        a() {
        }

        private boolean n(@NonNull View view, float f10) {
            boolean z10;
            int i10 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
            if (i10 != 0) {
                if (n0.B(view) == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int i11 = SwipeDismissBehavior.this.f19187g;
                if (i11 == 2) {
                    return true;
                }
                if (i11 == 0) {
                    if (z10) {
                        if (f10 >= 0.0f) {
                            return false;
                        }
                    } else if (i10 <= 0) {
                        return false;
                    }
                    return true;
                } else if (i11 != 1) {
                    return false;
                } else {
                    if (z10) {
                        if (i10 <= 0) {
                            return false;
                        }
                    } else if (f10 >= 0.0f) {
                        return false;
                    }
                    return true;
                }
            } else {
                if (Math.abs(view.getLeft() - this.f19192a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f19188h)) {
                    return true;
                }
                return false;
            }
        }

        public int a(@NonNull View view, int i10, int i11) {
            boolean z10;
            int i12;
            int i13;
            int width;
            if (n0.B(view) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i14 = SwipeDismissBehavior.this.f19187g;
            if (i14 != 0) {
                if (i14 != 1) {
                    i12 = this.f19192a - view.getWidth();
                    i13 = view.getWidth() + this.f19192a;
                } else if (z10) {
                    i12 = this.f19192a;
                    width = view.getWidth();
                } else {
                    i12 = this.f19192a - view.getWidth();
                    i13 = this.f19192a;
                }
                return SwipeDismissBehavior.H(i12, i10, i13);
            } else if (z10) {
                i12 = this.f19192a - view.getWidth();
                i13 = this.f19192a;
                return SwipeDismissBehavior.H(i12, i10, i13);
            } else {
                i12 = this.f19192a;
                width = view.getWidth();
            }
            i13 = width + i12;
            return SwipeDismissBehavior.H(i12, i10, i13);
        }

        public int b(@NonNull View view, int i10, int i11) {
            return view.getTop();
        }

        public int d(@NonNull View view) {
            return view.getWidth();
        }

        public void i(@NonNull View view, int i10) {
            this.f19193b = i10;
            this.f19192a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                boolean unused = SwipeDismissBehavior.this.f19184d = true;
                parent.requestDisallowInterceptTouchEvent(true);
                boolean unused2 = SwipeDismissBehavior.this.f19184d = false;
            }
        }

        public void j(int i10) {
            c cVar = SwipeDismissBehavior.this.f19182b;
            if (cVar != null) {
                cVar.b(i10);
            }
        }

        public void k(@NonNull View view, int i10, int i11, int i12, int i13) {
            float width = ((float) view.getWidth()) * SwipeDismissBehavior.this.f19189i;
            float width2 = ((float) view.getWidth()) * SwipeDismissBehavior.this.f19190j;
            float abs = (float) Math.abs(i10 - this.f19192a);
            if (abs <= width) {
                view.setAlpha(1.0f);
            } else if (abs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.G(0.0f, 1.0f - SwipeDismissBehavior.J(width, width2, abs), 1.0f));
            }
        }

        public void l(@NonNull View view, float f10, float f11) {
            boolean z10;
            int i10;
            c cVar;
            int i11;
            this.f19193b = -1;
            int width = view.getWidth();
            if (n(view, f10)) {
                if (f10 < 0.0f || view.getLeft() < (i11 = this.f19192a)) {
                    i10 = this.f19192a - width;
                } else {
                    i10 = i11 + width;
                }
                z10 = true;
            } else {
                i10 = this.f19192a;
                z10 = false;
            }
            if (SwipeDismissBehavior.this.f19181a.F(i10, view.getTop())) {
                n0.k0(view, new d(view, z10));
            } else if (z10 && (cVar = SwipeDismissBehavior.this.f19182b) != null) {
                cVar.a(view);
            }
        }

        public boolean m(View view, int i10) {
            int i11 = this.f19193b;
            if ((i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.F(view)) {
                return true;
            }
            return false;
        }
    }

    class b implements n {
        b() {
        }

        public boolean a(@NonNull View view, n.a aVar) {
            boolean z10;
            boolean z11 = false;
            if (!SwipeDismissBehavior.this.F(view)) {
                return false;
            }
            if (n0.B(view) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i10 = SwipeDismissBehavior.this.f19187g;
            if ((i10 == 0 && z10) || (i10 == 1 && !z10)) {
                z11 = true;
            }
            int width = view.getWidth();
            if (z11) {
                width = -width;
            }
            n0.c0(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f19182b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(View view);

        void b(int i10);
    }

    private class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f19196a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f19197b;

        d(View view, boolean z10) {
            this.f19196a = view;
            this.f19197b = z10;
        }

        public void run() {
            c cVar;
            z0.c cVar2 = SwipeDismissBehavior.this.f19181a;
            if (cVar2 != null && cVar2.k(true)) {
                n0.k0(this.f19196a, this);
            } else if (this.f19197b && (cVar = SwipeDismissBehavior.this.f19182b) != null) {
                cVar.a(this.f19196a);
            }
        }
    }

    static float G(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    static int H(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    private void I(ViewGroup viewGroup) {
        z0.c cVar;
        if (this.f19181a == null) {
            if (this.f19186f) {
                cVar = z0.c.l(viewGroup, this.f19185e, this.f19191k);
            } else {
                cVar = z0.c.m(viewGroup, this.f19191k);
            }
            this.f19181a = cVar;
        }
    }

    static float J(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    private void O(View view) {
        n0.m0(view, 1048576);
        if (F(view)) {
            n0.o0(view, k.a.f4779y, (CharSequence) null, new b());
        }
    }

    public boolean D(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (this.f19181a == null) {
            return false;
        }
        if (this.f19184d && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f19181a.z(motionEvent);
        return true;
    }

    public boolean F(@NonNull View view) {
        return true;
    }

    public void K(float f10) {
        this.f19190j = G(0.0f, f10, 1.0f);
    }

    public void L(c cVar) {
        this.f19182b = cVar;
    }

    public void M(float f10) {
        this.f19189i = G(0.0f, f10, 1.0f);
    }

    public void N(int i10) {
        this.f19187g = i10;
    }

    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        boolean z10 = this.f19183c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z10 = coordinatorLayout.B(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f19183c = z10;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f19183c = false;
        }
        if (!z10) {
            return false;
        }
        I(coordinatorLayout);
        if (this.f19184d || !this.f19181a.G(motionEvent)) {
            return false;
        }
        return true;
    }

    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        boolean l10 = super.l(coordinatorLayout, v10, i10);
        if (n0.z(v10) == 0) {
            n0.D0(v10, 1);
            O(v10);
        }
        return l10;
    }
}
