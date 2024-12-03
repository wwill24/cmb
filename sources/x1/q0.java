package x1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import x1.n;

public abstract class q0 extends n {
    private static final String[] R = {"android:visibility:visibility", "android:visibility:parent"};
    private int Q = 3;

    class a extends o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f18468a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f18469b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f18470c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f18468a = viewGroup;
            this.f18469b = view;
            this.f18470c = view2;
        }

        public void b(@NonNull n nVar) {
            if (this.f18469b.getParent() == null) {
                a0.a(this.f18468a).c(this.f18469b);
            } else {
                q0.this.cancel();
            }
        }

        public void d(@NonNull n nVar) {
            a0.a(this.f18468a).d(this.f18469b);
        }

        public void e(@NonNull n nVar) {
            this.f18470c.setTag(i.save_overlay_view, (Object) null);
            a0.a(this.f18468a).d(this.f18469b);
            nVar.W(this);
        }
    }

    private static class b extends AnimatorListenerAdapter implements n.f {

        /* renamed from: a  reason: collision with root package name */
        private final View f18472a;

        /* renamed from: b  reason: collision with root package name */
        private final int f18473b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f18474c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f18475d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f18476e;

        /* renamed from: f  reason: collision with root package name */
        boolean f18477f = false;

        b(View view, int i10, boolean z10) {
            this.f18472a = view;
            this.f18473b = i10;
            this.f18474c = (ViewGroup) view.getParent();
            this.f18475d = z10;
            g(true);
        }

        private void f() {
            if (!this.f18477f) {
                d0.h(this.f18472a, this.f18473b);
                ViewGroup viewGroup = this.f18474c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z10) {
            ViewGroup viewGroup;
            if (this.f18475d && this.f18476e != z10 && (viewGroup = this.f18474c) != null) {
                this.f18476e = z10;
                a0.c(viewGroup, z10);
            }
        }

        public void a(@NonNull n nVar) {
        }

        public void b(@NonNull n nVar) {
            g(true);
        }

        public void c(@NonNull n nVar) {
        }

        public void d(@NonNull n nVar) {
            g(false);
        }

        public void e(@NonNull n nVar) {
            f();
            nVar.W(this);
        }

        public void onAnimationCancel(Animator animator) {
            this.f18477f = true;
        }

        public void onAnimationEnd(Animator animator) {
            f();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f18477f) {
                d0.h(this.f18472a, this.f18473b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f18477f) {
                d0.h(this.f18472a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f18478a;

        /* renamed from: b  reason: collision with root package name */
        boolean f18479b;

        /* renamed from: c  reason: collision with root package name */
        int f18480c;

        /* renamed from: d  reason: collision with root package name */
        int f18481d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f18482e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f18483f;

        c() {
        }
    }

    private void l0(u uVar) {
        uVar.f18492a.put("android:visibility:visibility", Integer.valueOf(uVar.f18493b.getVisibility()));
        uVar.f18492a.put("android:visibility:parent", uVar.f18493b.getParent());
        int[] iArr = new int[2];
        uVar.f18493b.getLocationOnScreen(iArr);
        uVar.f18492a.put("android:visibility:screenLocation", iArr);
    }

    private c m0(u uVar, u uVar2) {
        c cVar = new c();
        cVar.f18478a = false;
        cVar.f18479b = false;
        if (uVar == null || !uVar.f18492a.containsKey("android:visibility:visibility")) {
            cVar.f18480c = -1;
            cVar.f18482e = null;
        } else {
            cVar.f18480c = ((Integer) uVar.f18492a.get("android:visibility:visibility")).intValue();
            cVar.f18482e = (ViewGroup) uVar.f18492a.get("android:visibility:parent");
        }
        if (uVar2 == null || !uVar2.f18492a.containsKey("android:visibility:visibility")) {
            cVar.f18481d = -1;
            cVar.f18483f = null;
        } else {
            cVar.f18481d = ((Integer) uVar2.f18492a.get("android:visibility:visibility")).intValue();
            cVar.f18483f = (ViewGroup) uVar2.f18492a.get("android:visibility:parent");
        }
        if (uVar != null && uVar2 != null) {
            int i10 = cVar.f18480c;
            int i11 = cVar.f18481d;
            if (i10 == i11 && cVar.f18482e == cVar.f18483f) {
                return cVar;
            }
            if (i10 != i11) {
                if (i10 == 0) {
                    cVar.f18479b = false;
                    cVar.f18478a = true;
                } else if (i11 == 0) {
                    cVar.f18479b = true;
                    cVar.f18478a = true;
                }
            } else if (cVar.f18483f == null) {
                cVar.f18479b = false;
                cVar.f18478a = true;
            } else if (cVar.f18482e == null) {
                cVar.f18479b = true;
                cVar.f18478a = true;
            }
        } else if (uVar == null && cVar.f18481d == 0) {
            cVar.f18479b = true;
            cVar.f18478a = true;
        } else if (uVar2 == null && cVar.f18480c == 0) {
            cVar.f18479b = false;
            cVar.f18478a = true;
        }
        return cVar;
    }

    public String[] I() {
        return R;
    }

    public boolean K(u uVar, u uVar2) {
        if (uVar == null && uVar2 == null) {
            return false;
        }
        if (uVar != null && uVar2 != null && uVar2.f18492a.containsKey("android:visibility:visibility") != uVar.f18492a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c m02 = m0(uVar, uVar2);
        if (!m02.f18478a) {
            return false;
        }
        if (m02.f18480c == 0 || m02.f18481d == 0) {
            return true;
        }
        return false;
    }

    public void h(@NonNull u uVar) {
        l0(uVar);
    }

    public void k(@NonNull u uVar) {
        l0(uVar);
    }

    public abstract Animator n0(ViewGroup viewGroup, View view, u uVar, u uVar2);

    public Animator o0(ViewGroup viewGroup, u uVar, int i10, u uVar2, int i11) {
        if ((this.Q & 1) != 1 || uVar2 == null) {
            return null;
        }
        if (uVar == null) {
            View view = (View) uVar2.f18493b.getParent();
            if (m0(y(view, false), J(view, false)).f18478a) {
                return null;
            }
        }
        return n0(viewGroup, uVar2.f18493b, uVar, uVar2);
    }

    public abstract Animator p0(ViewGroup viewGroup, View view, u uVar, u uVar2);

    public Animator q(@NonNull ViewGroup viewGroup, u uVar, u uVar2) {
        c m02 = m0(uVar, uVar2);
        if (!m02.f18478a) {
            return null;
        }
        if (m02.f18482e == null && m02.f18483f == null) {
            return null;
        }
        if (m02.f18479b) {
            return o0(viewGroup, uVar, m02.f18480c, uVar2, m02.f18481d);
        }
        return q0(viewGroup, uVar, m02.f18480c, uVar2, m02.f18481d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r0.C != false) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator q0(android.view.ViewGroup r18, x1.u r19, int r20, x1.u r21, int r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r21
            r4 = r22
            int r5 = r0.Q
            r6 = 2
            r5 = r5 & r6
            r7 = 0
            if (r5 == r6) goto L_0x0012
            return r7
        L_0x0012:
            if (r2 != 0) goto L_0x0015
            return r7
        L_0x0015:
            android.view.View r5 = r2.f18493b
            if (r3 == 0) goto L_0x001c
            android.view.View r8 = r3.f18493b
            goto L_0x001d
        L_0x001c:
            r8 = r7
        L_0x001d:
            int r9 = x1.i.save_overlay_view
            java.lang.Object r10 = r5.getTag(r9)
            android.view.View r10 = (android.view.View) r10
            r11 = 0
            r12 = 1
            if (r10 == 0) goto L_0x002d
            r8 = r7
            r13 = r12
            goto L_0x0095
        L_0x002d:
            if (r8 == 0) goto L_0x0040
            android.view.ViewParent r10 = r8.getParent()
            if (r10 != 0) goto L_0x0036
            goto L_0x0040
        L_0x0036:
            r10 = 4
            if (r4 != r10) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            if (r5 != r8) goto L_0x0045
        L_0x003c:
            r10 = r8
            r13 = r11
            r8 = r7
            goto L_0x0048
        L_0x0040:
            if (r8 == 0) goto L_0x0045
            r10 = r7
            r13 = r11
            goto L_0x0048
        L_0x0045:
            r8 = r7
            r10 = r8
            r13 = r12
        L_0x0048:
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            if (r13 != 0) goto L_0x0051
            goto L_0x008b
        L_0x0051:
            android.view.ViewParent r13 = r5.getParent()
            boolean r13 = r13 instanceof android.view.View
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            android.view.View r13 = (android.view.View) r13
            x1.u r14 = r0.J(r13, r12)
            x1.u r15 = r0.y(r13, r12)
            x1.q0$c r14 = r0.m0(r14, r15)
            boolean r14 = r14.f18478a
            if (r14 != 0) goto L_0x0074
            android.view.View r8 = x1.t.a(r1, r5, r13)
            goto L_0x008f
        L_0x0074:
            int r14 = r13.getId()
            android.view.ViewParent r13 = r13.getParent()
            if (r13 != 0) goto L_0x008f
            r13 = -1
            if (r14 == r13) goto L_0x008f
            android.view.View r13 = r1.findViewById(r14)
            if (r13 == 0) goto L_0x008f
            boolean r13 = r0.C
            if (r13 == 0) goto L_0x008f
        L_0x008b:
            r8 = r10
            r13 = r11
            r10 = r5
            goto L_0x0095
        L_0x008f:
            r13 = r11
            r16 = r10
            r10 = r8
            r8 = r16
        L_0x0095:
            if (r10 == 0) goto L_0x00e5
            if (r13 != 0) goto L_0x00c9
            java.util.Map<java.lang.String, java.lang.Object> r4 = r2.f18492a
            java.lang.String r7 = "android:visibility:screenLocation"
            java.lang.Object r4 = r4.get(r7)
            int[] r4 = (int[]) r4
            r7 = r4[r11]
            r4 = r4[r12]
            int[] r6 = new int[r6]
            r1.getLocationOnScreen(r6)
            r8 = r6[r11]
            int r7 = r7 - r8
            int r8 = r10.getLeft()
            int r7 = r7 - r8
            r10.offsetLeftAndRight(r7)
            r6 = r6[r12]
            int r4 = r4 - r6
            int r6 = r10.getTop()
            int r4 = r4 - r6
            r10.offsetTopAndBottom(r4)
            x1.y r4 = x1.a0.a(r18)
            r4.c(r10)
        L_0x00c9:
            android.animation.Animator r2 = r0.p0(r1, r10, r2, r3)
            if (r13 != 0) goto L_0x00e4
            if (r2 != 0) goto L_0x00d9
            x1.y r1 = x1.a0.a(r18)
            r1.d(r10)
            goto L_0x00e4
        L_0x00d9:
            r5.setTag(r9, r10)
            x1.q0$a r3 = new x1.q0$a
            r3.<init>(r1, r10, r5)
            r0.a(r3)
        L_0x00e4:
            return r2
        L_0x00e5:
            if (r8 == 0) goto L_0x0107
            int r5 = r8.getVisibility()
            x1.d0.h(r8, r11)
            android.animation.Animator r1 = r0.p0(r1, r8, r2, r3)
            if (r1 == 0) goto L_0x0103
            x1.q0$b r2 = new x1.q0$b
            r2.<init>(r8, r4, r12)
            r1.addListener(r2)
            x1.a.a(r1, r2)
            r0.a(r2)
            goto L_0x0106
        L_0x0103:
            x1.d0.h(r8, r5)
        L_0x0106:
            return r1
        L_0x0107:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.q0.q0(android.view.ViewGroup, x1.u, int, x1.u, int):android.animation.Animator");
    }

    public void r0(int i10) {
        if ((i10 & -4) == 0) {
            this.Q = i10;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}
