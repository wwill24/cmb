package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.core.view.e0;
import androidx.core.view.f0;
import androidx.core.view.g0;
import androidx.core.view.h0;
import androidx.core.view.k2;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements e0, f0 {
    static final String B;
    static final Class<?>[] C = {Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<c>>> D = new ThreadLocal<>();
    static final Comparator<View> E = new h();
    private static final androidx.core.util.e<Rect> F = new androidx.core.util.g(12);

    /* renamed from: a  reason: collision with root package name */
    private final List<View> f4339a;

    /* renamed from: b  reason: collision with root package name */
    private final a<View> f4340b;

    /* renamed from: c  reason: collision with root package name */
    private final List<View> f4341c;

    /* renamed from: d  reason: collision with root package name */
    private final List<View> f4342d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f4343e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f4344f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f4345g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4346h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4347j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f4348k;

    /* renamed from: l  reason: collision with root package name */
    private View f4349l;

    /* renamed from: m  reason: collision with root package name */
    private View f4350m;

    /* renamed from: n  reason: collision with root package name */
    private g f4351n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f4352p;

    /* renamed from: q  reason: collision with root package name */
    private k2 f4353q;

    /* renamed from: t  reason: collision with root package name */
    private boolean f4354t;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f4355w;

    /* renamed from: x  reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f4356x;

    /* renamed from: y  reason: collision with root package name */
    private h0 f4357y;

    /* renamed from: z  reason: collision with root package name */
    private final g0 f4358z;

    class a implements h0 {
        a() {
        }

        public k2 a(View view, k2 k2Var) {
            return CoordinatorLayout.this.W(k2Var);
        }
    }

    public interface b {
        @NonNull
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10, int i11) {
            if (i11 == 0) {
                return z(coordinatorLayout, v10, view, view2, i10);
            }
            return false;
        }

        @Deprecated
        public void B(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view) {
        }

        public void C(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10) {
            if (i10 == 0) {
                B(coordinatorLayout, v10, view);
            }
        }

        public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
            return d(coordinatorLayout, v10) > 0.0f;
        }

        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Rect rect) {
            return false;
        }

        public int c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
            return -16777216;
        }

        public float d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
            return 0.0f;
        }

        public boolean e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view) {
            return false;
        }

        @NonNull
        public k2 f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull k2 k2Var) {
            return k2Var;
        }

        public void g(@NonNull f fVar) {
        }

        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view) {
            return false;
        }

        public void i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view) {
        }

        public void j() {
        }

        public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
            return false;
        }

        public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10, int i11, int i12, int i13) {
            return false;
        }

        public boolean n(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, float f10, float f11, boolean z10) {
            return false;
        }

        public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, float f10, float f11) {
            return false;
        }

        @Deprecated
        public void p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, @NonNull int[] iArr) {
        }

        public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12) {
            if (i12 == 0) {
                p(coordinatorLayout, v10, view, i10, i11, iArr);
            }
        }

        @Deprecated
        public void r(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13) {
        }

        @Deprecated
        public void s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13, int i14) {
            if (i14 == 0) {
                r(coordinatorLayout, v10, view, i10, i11, i12, i13);
            }
        }

        public void t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
            s(coordinatorLayout, v10, view, i10, i11, i12, i13, i14);
        }

        @Deprecated
        public void u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10) {
        }

        public void v(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10, int i11) {
            if (i11 == 0) {
                u(coordinatorLayout, v10, view, view2, i10);
            }
        }

        public boolean w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Rect rect, boolean z10) {
            return false;
        }

        public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Parcelable parcelable) {
        }

        public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        Class<? extends c> value();
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f4356x;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.H(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f4356x;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.H(0);
            return true;
        }
    }

    static class h implements Comparator<View> {
        h() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float P = n0.P(view);
            float P2 = n0.P(view2);
            if (P > P2) {
                return -1;
            }
            if (P < P2) {
                return 1;
            }
            return 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.getName()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            B = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$h r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$h
            r0.<init>()
            E = r0
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            C = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            D = r0
            androidx.core.util.g r0 = new androidx.core.util.g
            r1 = 12
            r0.<init>(r1)
            F = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, s0.a.coordinatorLayoutStyle);
    }

    private boolean A(View view) {
        return this.f4340b.j(view);
    }

    private void C(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        Rect a10 = a();
        a10.set(getPaddingLeft() + fVar.leftMargin, getPaddingTop() + fVar.topMargin, (getWidth() - getPaddingRight()) - fVar.rightMargin, (getHeight() - getPaddingBottom()) - fVar.bottomMargin);
        if (this.f4353q != null && n0.y(this) && !n0.y(view)) {
            a10.left += this.f4353q.i();
            a10.top += this.f4353q.k();
            a10.right -= this.f4353q.j();
            a10.bottom -= this.f4353q.h();
        }
        Rect a11 = a();
        androidx.core.view.e.a(S(fVar.f4364c), view.getMeasuredWidth(), view.getMeasuredHeight(), a10, a11, i10);
        view.layout(a11.left, a11.top, a11.right, a11.bottom);
        O(a10);
        O(a11);
    }

    private void D(View view, View view2, int i10) {
        Rect a10 = a();
        Rect a11 = a();
        try {
            t(view2, a10);
            u(view, i10, a10, a11);
            view.layout(a11.left, a11.top, a11.right, a11.bottom);
        } finally {
            O(a10);
            O(a11);
        }
    }

    private void E(View view, int i10, int i11) {
        f fVar = (f) view.getLayoutParams();
        int b10 = androidx.core.view.e.b(T(fVar.f4364c), i11);
        int i12 = b10 & 7;
        int i13 = b10 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i11 == 1) {
            i10 = width - i10;
        }
        int w10 = w(i10) - measuredWidth;
        int i14 = 0;
        if (i12 == 1) {
            w10 += measuredWidth / 2;
        } else if (i12 == 5) {
            w10 += measuredWidth;
        }
        if (i13 == 16) {
            i14 = 0 + (measuredHeight / 2);
        } else if (i13 == 80) {
            i14 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + fVar.leftMargin, Math.min(w10, ((width - getPaddingRight()) - measuredWidth) - fVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + fVar.topMargin, Math.min(i14, ((height - getPaddingBottom()) - measuredHeight) - fVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void F(View view, Rect rect, int i10) {
        boolean z10;
        boolean z11;
        int width;
        int i11;
        int i12;
        int i13;
        int height;
        int i14;
        int i15;
        int i16;
        if (n0.W(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c f10 = fVar.f();
            Rect a10 = a();
            Rect a11 = a();
            a11.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f10 == null || !f10.b(this, view, a10)) {
                a10.set(a11);
            } else if (!a11.contains(a10)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a10.toShortString() + " | Bounds:" + a11.toShortString());
            }
            O(a11);
            if (a10.isEmpty()) {
                O(a10);
                return;
            }
            int b10 = androidx.core.view.e.b(fVar.f4369h, i10);
            boolean z12 = true;
            if ((b10 & 48) != 48 || (i15 = (a10.top - fVar.topMargin) - fVar.f4371j) >= (i16 = rect.top)) {
                z10 = false;
            } else {
                V(view, i16 - i15);
                z10 = true;
            }
            if ((b10 & 80) == 80 && (height = ((getHeight() - a10.bottom) - fVar.bottomMargin) + fVar.f4371j) < (i14 = rect.bottom)) {
                V(view, height - i14);
                z10 = true;
            }
            if (!z10) {
                V(view, 0);
            }
            if ((b10 & 3) != 3 || (i12 = (a10.left - fVar.leftMargin) - fVar.f4370i) >= (i13 = rect.left)) {
                z11 = false;
            } else {
                U(view, i13 - i12);
                z11 = true;
            }
            if ((b10 & 5) != 5 || (width = ((getWidth() - a10.right) - fVar.rightMargin) + fVar.f4370i) >= (i11 = rect.right)) {
                z12 = z11;
            } else {
                U(view, width - i11);
            }
            if (!z12) {
                U(view, 0);
            }
            O(a10);
        }
    }

    static c K(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = B;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = D;
            Map map = threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(C);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (c) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e10) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e10);
        }
    }

    private boolean L(MotionEvent motionEvent, int i10) {
        MotionEvent motionEvent2 = motionEvent;
        int i11 = i10;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f4341c;
        z(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z10 = false;
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view = list.get(i12);
            f fVar = (f) view.getLayoutParams();
            c f10 = fVar.f();
            if ((!z10 && !z11) || actionMasked == 0) {
                if (!z10 && f10 != null) {
                    if (i11 == 0) {
                        z10 = f10.k(this, view, motionEvent2);
                    } else if (i11 == 1) {
                        z10 = f10.D(this, view, motionEvent2);
                    }
                    if (z10) {
                        this.f4349l = view;
                    }
                }
                boolean c10 = fVar.c();
                boolean i13 = fVar.i(this, view);
                if (!i13 || c10) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (i13 && !z11) {
                    break;
                }
            } else if (f10 != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i11 == 0) {
                    f10.k(this, view, motionEvent3);
                } else if (i11 == 1) {
                    f10.D(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z10;
    }

    private void M() {
        this.f4339a.clear();
        this.f4340b.c();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            f y10 = y(childAt);
            y10.d(this, childAt);
            this.f4340b.b(childAt);
            for (int i11 = 0; i11 < childCount; i11++) {
                if (i11 != i10) {
                    View childAt2 = getChildAt(i11);
                    if (y10.b(this, childAt, childAt2)) {
                        if (!this.f4340b.d(childAt2)) {
                            this.f4340b.b(childAt2);
                        }
                        this.f4340b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f4339a.addAll(this.f4340b.i());
        Collections.reverse(this.f4339a);
    }

    private static void O(@NonNull Rect rect) {
        rect.setEmpty();
        F.a(rect);
    }

    private void Q(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            c f10 = ((f) childAt.getLayoutParams()).f();
            if (f10 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z10) {
                    f10.k(this, childAt, obtain);
                } else {
                    f10.D(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            ((f) getChildAt(i11).getLayoutParams()).m();
        }
        this.f4349l = null;
        this.f4346h = false;
    }

    private static int R(int i10) {
        if (i10 == 0) {
            return 17;
        }
        return i10;
    }

    private static int S(int i10) {
        if ((i10 & 7) == 0) {
            i10 |= 8388611;
        }
        return (i10 & 112) == 0 ? i10 | 48 : i10;
    }

    private static int T(int i10) {
        if (i10 == 0) {
            return 8388661;
        }
        return i10;
    }

    private void U(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        int i11 = fVar.f4370i;
        if (i11 != i10) {
            n0.c0(view, i10 - i11);
            fVar.f4370i = i10;
        }
    }

    private void V(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        int i11 = fVar.f4371j;
        if (i11 != i10) {
            n0.d0(view, i10 - i11);
            fVar.f4371j = i10;
        }
    }

    private void X() {
        if (n0.y(this)) {
            if (this.f4357y == null) {
                this.f4357y = new a();
            }
            n0.H0(this, this.f4357y);
            setSystemUiVisibility(1280);
            return;
        }
        n0.H0(this, (h0) null);
    }

    @NonNull
    private static Rect a() {
        Rect acquire = F.acquire();
        if (acquire == null) {
            return new Rect();
        }
        return acquire;
    }

    private static int c(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    private void d(f fVar, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + fVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - fVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + fVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - fVar.bottomMargin));
        rect.set(max, max2, i10 + max, i11 + max2);
    }

    private k2 e(k2 k2Var) {
        c f10;
        if (k2Var.n()) {
            return k2Var;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (n0.y(childAt) && (f10 = ((f) childAt.getLayoutParams()).f()) != null) {
                k2Var = f10.f(this, childAt, k2Var);
                if (k2Var.n()) {
                    break;
                }
            }
        }
        return k2Var;
    }

    private void v(View view, int i10, Rect rect, Rect rect2, f fVar, int i11, int i12) {
        int i13;
        int i14;
        int b10 = androidx.core.view.e.b(R(fVar.f4364c), i10);
        int b11 = androidx.core.view.e.b(S(fVar.f4365d), i10);
        int i15 = b10 & 7;
        int i16 = b10 & 112;
        int i17 = b11 & 7;
        int i18 = b11 & 112;
        if (i17 == 1) {
            i13 = rect.left + (rect.width() / 2);
        } else if (i17 != 5) {
            i13 = rect.left;
        } else {
            i13 = rect.right;
        }
        if (i18 == 16) {
            i14 = rect.top + (rect.height() / 2);
        } else if (i18 != 80) {
            i14 = rect.top;
        } else {
            i14 = rect.bottom;
        }
        if (i15 == 1) {
            i13 -= i11 / 2;
        } else if (i15 != 5) {
            i13 -= i11;
        }
        if (i16 == 16) {
            i14 -= i12 / 2;
        } else if (i16 != 80) {
            i14 -= i12;
        }
        rect2.set(i13, i14, i11 + i13, i12 + i14);
    }

    private int w(int i10) {
        int[] iArr = this.f4348k;
        if (iArr == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No keylines defined for ");
            sb2.append(this);
            sb2.append(" - attempted index lookup ");
            sb2.append(i10);
            return 0;
        } else if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Keyline index ");
            sb3.append(i10);
            sb3.append(" out of range for ");
            sb3.append(this);
            return 0;
        }
    }

    private void z(List<View> list) {
        int i10;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            if (isChildrenDrawingOrderEnabled) {
                i10 = getChildDrawingOrder(childCount, i11);
            } else {
                i10 = i11;
            }
            list.add(getChildAt(i10));
        }
        Comparator<View> comparator = E;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public boolean B(@NonNull View view, int i10, int i11) {
        Rect a10 = a();
        t(view, a10);
        try {
            return a10.contains(i10, i11);
        } finally {
            O(a10);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(View view, int i10) {
        c f10;
        View view2 = view;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f4372k != null) {
            Rect a10 = a();
            Rect a11 = a();
            Rect a12 = a();
            t(fVar.f4372k, a10);
            boolean z10 = false;
            q(view2, false, a11);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i11 = measuredHeight;
            v(view, i10, a10, a12, fVar, measuredWidth, measuredHeight);
            if (!(a12.left == a11.left && a12.top == a11.top)) {
                z10 = true;
            }
            d(fVar, a12, measuredWidth, i11);
            int i12 = a12.left - a11.left;
            int i13 = a12.top - a11.top;
            if (i12 != 0) {
                n0.c0(view2, i12);
            }
            if (i13 != 0) {
                n0.d0(view2, i13);
            }
            if (z10 && (f10 = fVar.f()) != null) {
                f10.h(this, view2, fVar.f4372k);
            }
            O(a10);
            O(a11);
            O(a12);
        }
    }

    /* access modifiers changed from: package-private */
    public final void H(int i10) {
        boolean z10;
        int i11 = i10;
        int B2 = n0.B(this);
        int size = this.f4339a.size();
        Rect a10 = a();
        Rect a11 = a();
        Rect a12 = a();
        for (int i12 = 0; i12 < size; i12++) {
            View view = this.f4339a.get(i12);
            f fVar = (f) view.getLayoutParams();
            if (i11 != 0 || view.getVisibility() != 8) {
                for (int i13 = 0; i13 < i12; i13++) {
                    if (fVar.f4373l == this.f4339a.get(i13)) {
                        G(view, B2);
                    }
                }
                q(view, true, a11);
                if (fVar.f4368g != 0 && !a11.isEmpty()) {
                    int b10 = androidx.core.view.e.b(fVar.f4368g, B2);
                    int i14 = b10 & 112;
                    if (i14 == 48) {
                        a10.top = Math.max(a10.top, a11.bottom);
                    } else if (i14 == 80) {
                        a10.bottom = Math.max(a10.bottom, getHeight() - a11.top);
                    }
                    int i15 = b10 & 7;
                    if (i15 == 3) {
                        a10.left = Math.max(a10.left, a11.right);
                    } else if (i15 == 5) {
                        a10.right = Math.max(a10.right, getWidth() - a11.left);
                    }
                }
                if (fVar.f4369h != 0 && view.getVisibility() == 0) {
                    F(view, a10, B2);
                }
                if (i11 != 2) {
                    x(view, a12);
                    if (!a12.equals(a11)) {
                        N(view, a11);
                    }
                }
                for (int i16 = i12 + 1; i16 < size; i16++) {
                    View view2 = this.f4339a.get(i16);
                    f fVar2 = (f) view2.getLayoutParams();
                    c f10 = fVar2.f();
                    if (f10 != null && f10.e(this, view2, view)) {
                        if (i11 != 0 || !fVar2.g()) {
                            if (i11 != 2) {
                                z10 = f10.h(this, view2, view);
                            } else {
                                f10.i(this, view2, view);
                                z10 = true;
                            }
                            if (i11 == 1) {
                                fVar2.p(z10);
                            }
                        } else {
                            fVar2.k();
                        }
                    }
                }
            }
        }
        O(a10);
        O(a11);
        O(a12);
    }

    public void I(@NonNull View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.a()) {
            View view2 = fVar.f4372k;
            if (view2 != null) {
                D(view, view2, i10);
                return;
            }
            int i11 = fVar.f4366e;
            if (i11 >= 0) {
                E(view, i11, i10);
            } else {
                C(view, i10);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    public void J(View view, int i10, int i11, int i12, int i13) {
        measureChildWithMargins(view, i10, i11, i12, i13);
    }

    /* access modifiers changed from: package-private */
    public void N(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    /* access modifiers changed from: package-private */
    public void P() {
        if (this.f4347j && this.f4351n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4351n);
        }
        this.f4352p = false;
    }

    /* access modifiers changed from: package-private */
    public final k2 W(k2 k2Var) {
        boolean z10;
        if (androidx.core.util.c.a(this.f4353q, k2Var)) {
            return k2Var;
        }
        this.f4353q = k2Var;
        boolean z11 = true;
        if (k2Var == null || k2Var.k() <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f4354t = z10;
        if (z10 || getBackground() != null) {
            z11 = false;
        }
        setWillNotDraw(z11);
        k2 e10 = e(k2Var);
        requestLayout();
        return e10;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f4347j) {
            if (this.f4351n == null) {
                this.f4351n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4351n);
        }
        this.f4352p = true;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f4362a;
        if (cVar != null) {
            float d10 = cVar.d(this, view);
            if (d10 > 0.0f) {
                if (this.f4343e == null) {
                    this.f4343e = new Paint();
                }
                this.f4343e.setColor(fVar.f4362a.c(this, view));
                this.f4343e.setAlpha(c(Math.round(d10 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f4343e);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f4355w;
        boolean z10 = false;
        if (drawable != null && drawable.isStateful()) {
            z10 = false | drawable.setState(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    public void f(@NonNull View view) {
        List g10 = this.f4340b.g(view);
        if (g10 != null && !g10.isEmpty()) {
            for (int i10 = 0; i10 < g10.size(); i10++) {
                View view2 = (View) g10.get(i10);
                c f10 = ((f) view2.getLayoutParams()).f();
                if (f10 != null) {
                    f10.h(this, view2, view);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            } else if (A(getChildAt(i10))) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (z10 == this.f4352p) {
            return;
        }
        if (z10) {
            b();
        } else {
            P();
        }
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        M();
        return Collections.unmodifiableList(this.f4339a);
    }

    public final k2 getLastWindowInsets() {
        return this.f4353q;
    }

    public int getNestedScrollAxes() {
        return this.f4358z.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f4355w;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    public void i(View view, View view2, int i10, int i11) {
        c f10;
        this.f4358z.c(view, view2, i10, i11);
        this.f4350m = view2;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i11) && (f10 = fVar.f()) != null) {
                f10.v(this, childAt, view, view2, i10, i11);
            }
        }
    }

    public void j(View view, int i10) {
        this.f4358z.d(view, i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i10)) {
                c f10 = fVar.f();
                if (f10 != null) {
                    f10.C(this, childAt, view, i10);
                }
                fVar.l(i10);
                fVar.k();
            }
        }
        this.f4350m = null;
    }

    public void k(View view, int i10, int i11, int[] iArr, int i12) {
        c f10;
        int i13;
        int i14;
        int childCount = getChildCount();
        boolean z10 = false;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() == 8) {
                int i18 = i12;
            } else {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i12) && (f10 = fVar.f()) != null) {
                    int[] iArr2 = this.f4344f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f10.q(this, childAt, view, i10, i11, iArr2, i12);
                    int[] iArr3 = this.f4344f;
                    if (i10 > 0) {
                        i13 = Math.max(i15, iArr3[0]);
                    } else {
                        i13 = Math.min(i15, iArr3[0]);
                    }
                    i15 = i13;
                    int[] iArr4 = this.f4344f;
                    if (i11 > 0) {
                        i14 = Math.max(i16, iArr4[1]);
                    } else {
                        i14 = Math.min(i16, iArr4[1]);
                    }
                    i16 = i14;
                    z10 = true;
                }
            }
        }
        iArr[0] = i15;
        iArr[1] = i16;
        if (z10) {
            H(1);
        }
    }

    /* renamed from: l */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public void m(@NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
        c f10;
        int i15;
        boolean z10;
        int i16;
        int childCount = getChildCount();
        boolean z11 = false;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i14) && (f10 = fVar.f()) != null) {
                    int[] iArr2 = this.f4344f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f10.t(this, childAt, view, i10, i11, i12, i13, i14, iArr2);
                    int[] iArr3 = this.f4344f;
                    if (i12 > 0) {
                        i15 = Math.max(i17, iArr3[0]);
                    } else {
                        i15 = Math.min(i17, iArr3[0]);
                    }
                    i17 = i15;
                    if (i13 > 0) {
                        z10 = true;
                        i16 = Math.max(i18, this.f4344f[1]);
                    } else {
                        z10 = true;
                        i16 = Math.min(i18, this.f4344f[1]);
                    }
                    i18 = i16;
                    z11 = z10;
                }
            }
        }
        iArr[0] = iArr[0] + i17;
        iArr[1] = iArr[1] + i18;
        if (z11) {
            H(1);
        }
    }

    public void n(View view, int i10, int i11, int i12, int i13, int i14) {
        m(view, i10, i11, i12, i13, 0, this.f4345g);
    }

    public boolean o(View view, View view2, int i10, int i11) {
        int i12 = i11;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c f10 = fVar.f();
                if (f10 != null) {
                    boolean A = f10.A(this, childAt, view, view2, i10, i11);
                    z10 |= A;
                    fVar.r(i12, A);
                } else {
                    fVar.r(i12, false);
                }
            }
        }
        return z10;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q(false);
        if (this.f4352p) {
            if (this.f4351n == null) {
                this.f4351n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4351n);
        }
        if (this.f4353q == null && n0.y(this)) {
            n0.p0(this);
        }
        this.f4347j = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q(false);
        if (this.f4352p && this.f4351n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4351n);
        }
        View view = this.f4350m;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f4347j = false;
    }

    public void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        if (this.f4354t && this.f4355w != null) {
            k2 k2Var = this.f4353q;
            if (k2Var != null) {
                i10 = k2Var.k();
            } else {
                i10 = 0;
            }
            if (i10 > 0) {
                this.f4355w.setBounds(0, 0, getWidth(), i10);
                this.f4355w.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Q(true);
        }
        boolean L = L(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            Q(true);
        }
        return L;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        c f10;
        int B2 = n0.B(this);
        int size = this.f4339a.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = this.f4339a.get(i14);
            if (view.getVisibility() != 8 && ((f10 = ((f) view.getLayoutParams()).f()) == null || !f10.l(this, view, B2))) {
                I(view, B2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011a, code lost:
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L_0x012a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.M()
            r30.g()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = androidx.core.view.n0.B(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = r2
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.view.k2 r3 = r7.f4353q
            if (r3 == 0) goto L_0x004b
            boolean r3 = androidx.core.view.n0.y(r30)
            if (r3 == 0) goto L_0x004b
            r19 = r2
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.f4339a
            int r6 = r2.size()
            r5 = r0
            r4 = r1
            r2 = 0
            r3 = 0
        L_0x0057:
            if (r3 >= r6) goto L_0x016f
            java.util.List<android.view.View> r0 = r7.f4339a
            java.lang.Object r0 = r0.get(r3)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0073
            r22 = r3
            r29 = r6
            r28 = r8
            goto L_0x0167
        L_0x0073:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r1
            int r0 = r1.f4366e
            if (r0 < 0) goto L_0x00ba
            if (r13 == 0) goto L_0x00ba
            int r0 = r7.w(r0)
            int r11 = r1.f4364c
            int r11 = T(r11)
            int r11 = androidx.core.view.e.b(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0097
            if (r12 == 0) goto L_0x009c
        L_0x0097:
            r2 = 5
            if (r11 != r2) goto L_0x00a8
            if (r12 == 0) goto L_0x00a8
        L_0x009c:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r11 = r0
            r21 = r2
            goto L_0x00bf
        L_0x00a8:
            if (r11 != r2) goto L_0x00ac
            if (r12 == 0) goto L_0x00b1
        L_0x00ac:
            r2 = 3
            if (r11 != r2) goto L_0x00bc
            if (r12 == 0) goto L_0x00bc
        L_0x00b1:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00bf
        L_0x00ba:
            r22 = r2
        L_0x00bc:
            r11 = 0
            r21 = r11
        L_0x00bf:
            if (r19 == 0) goto L_0x00f1
            boolean r0 = androidx.core.view.n0.y(r20)
            if (r0 != 0) goto L_0x00f1
            androidx.core.view.k2 r0 = r7.f4353q
            int r0 = r0.i()
            androidx.core.view.k2 r2 = r7.f4353q
            int r2 = r2.j()
            int r0 = r0 + r2
            androidx.core.view.k2 r2 = r7.f4353q
            int r2 = r2.k()
            androidx.core.view.k2 r11 = r7.f4353q
            int r11 = r11.h()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f5
        L_0x00f1:
            r11 = r31
            r23 = r32
        L_0x00f5:
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r0 = r1.f()
            if (r0 == 0) goto L_0x011d
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r22 = r3
            r3 = r11
            r27 = r4
            r4 = r21
            r28 = r8
            r8 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.m(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0137
            goto L_0x012a
        L_0x011d:
            r26 = r1
            r27 = r4
            r29 = r6
            r28 = r8
            r25 = r22
            r22 = r3
            r8 = r5
        L_0x012a:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.J(r1, r2, r3, r4, r5)
        L_0x0137:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r8, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r27
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r25
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r5 = r0
            r4 = r1
        L_0x0167:
            int r3 = r22 + 1
            r8 = r28
            r6 = r29
            goto L_0x0057
        L_0x016f:
            r11 = r2
            r1 = r4
            r8 = r5
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r2 = r31
            int r0 = android.view.View.resolveSizeAndState(r8, r2, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        c f12;
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f12 = fVar.f()) != null) {
                    z11 |= f12.n(this, childAt, view, f10, f11, z10);
                }
            }
        }
        if (z11) {
            H(1);
        }
        return z11;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        c f12;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f12 = fVar.f()) != null) {
                    z10 |= f12.o(this, childAt, view, f10, f11);
                }
            }
        }
        return z10;
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        k(view, i10, i11, iArr, 0);
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        n(view, i10, i11, i12, i13, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i10) {
        i(view, view2, i10, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.f4359c;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            c f10 = y(childAt).f();
            if (!(id2 == -1 || f10 == null || (parcelable2 = sparseArray.get(id2)) == null)) {
                f10.x(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable y10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            c f10 = ((f) childAt.getLayoutParams()).f();
            if (!(id2 == -1 || f10 == null || (y10 = f10.y(this, childAt)) == null)) {
                sparseArray.append(id2, y10);
            }
        }
        savedState.f4359c = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return o(view, view2, i10, 0);
    }

    public void onStopNestedScroll(View view) {
        j(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f4349l
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.L(r1, r4)
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x0015:
            r3 = r5
        L_0x0016:
            android.view.View r6 = r0.f4349l
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f()
            if (r6 == 0) goto L_0x002b
            android.view.View r7 = r0.f4349l
            boolean r6 = r6.D(r0, r7, r1)
            goto L_0x002c
        L_0x002b:
            r6 = r5
        L_0x002c:
            android.view.View r7 = r0.f4349l
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.Q(r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void q(View view, boolean z10, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            t(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @NonNull
    public List<View> r(@NonNull View view) {
        List<View> h10 = this.f4340b.h(view);
        this.f4342d.clear();
        if (h10 != null) {
            this.f4342d.addAll(h10);
        }
        return this.f4342d;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        c f10 = ((f) view.getLayoutParams()).f();
        if (f10 == null || !f10.w(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10 && !this.f4346h) {
            Q(false);
            this.f4346h = true;
        }
    }

    @NonNull
    public List<View> s(@NonNull View view) {
        List g10 = this.f4340b.g(view);
        this.f4342d.clear();
        if (g10 != null) {
            this.f4342d.addAll(g10);
        }
        return this.f4342d;
    }

    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        X();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f4356x = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.f4355w;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f4355w = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f4355w.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.f4355w, n0.B(this));
                Drawable drawable4 = this.f4355w;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable4.setVisible(z10, false);
                this.f4355w.setCallback(this);
            }
            n0.j0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(int i10) {
        setStatusBarBackground(i10 != 0 ? androidx.core.content.a.getDrawable(getContext(), i10) : null);
    }

    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.f4355w;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f4355w.setVisible(z10, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(View view, Rect rect) {
        b.a(this, view, rect);
    }

    /* access modifiers changed from: package-private */
    public void u(View view, int i10, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        v(view, i10, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4355w;
    }

    /* access modifiers changed from: package-private */
    public void x(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* access modifiers changed from: package-private */
    public f y(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f4363b) {
            if (view instanceof b) {
                fVar.o(((b) view).getBehavior());
                fVar.f4363b = true;
            } else {
                d dVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.o((c) dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Default behavior class ");
                        sb2.append(dVar.value().getName());
                        sb2.append(" could not be instantiated. Did you forget a default constructor?");
                    }
                }
                fVar.f4363b = true;
            }
        }
        return fVar;
    }

    public CoordinatorLayout(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray typedArray;
        this.f4339a = new ArrayList();
        this.f4340b = new a<>();
        this.f4341c = new ArrayList();
        this.f4342d = new ArrayList();
        this.f4344f = new int[2];
        this.f4345g = new int[2];
        this.f4358z = new g0(this);
        if (i10 == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, s0.c.CoordinatorLayout, 0, s0.b.Widget_Support_CoordinatorLayout);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, s0.c.CoordinatorLayout, i10, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i10 == 0) {
                saveAttributeDataForStyleable(context, s0.c.CoordinatorLayout, attributeSet, typedArray, 0, s0.b.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, s0.c.CoordinatorLayout, attributeSet, typedArray, i10, 0);
            }
        }
        int resourceId = typedArray.getResourceId(s0.c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f4348k = resources.getIntArray(resourceId);
            float f10 = resources.getDisplayMetrics().density;
            int length = this.f4348k.length;
            for (int i11 = 0; i11 < length; i11++) {
                int[] iArr = this.f4348k;
                iArr[i11] = (int) (((float) iArr[i11]) * f10);
            }
        }
        this.f4355w = typedArray.getDrawable(s0.c.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        X();
        super.setOnHierarchyChangeListener(new e());
        if (n0.z(this) == 0) {
            n0.D0(this, 1);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        SparseArray<Parcelable> f4359c;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f4359c = new SparseArray<>(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                this.f4359c.append(iArr[i10], readParcelableArray[i10]);
            }
        }

        public void writeToParcel(Parcel parcel, int i10) {
            int i11;
            super.writeToParcel(parcel, i10);
            SparseArray<Parcelable> sparseArray = this.f4359c;
            if (sparseArray != null) {
                i11 = sparseArray.size();
            } else {
                i11 = 0;
            }
            parcel.writeInt(i11);
            int[] iArr = new int[i11];
            Parcelable[] parcelableArr = new Parcelable[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                iArr[i12] = this.f4359c.keyAt(i12);
                parcelableArr[i12] = this.f4359c.valueAt(i12);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i10);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        c f4362a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4363b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f4364c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f4365d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f4366e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f4367f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f4368g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f4369h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f4370i;

        /* renamed from: j  reason: collision with root package name */
        int f4371j;

        /* renamed from: k  reason: collision with root package name */
        View f4372k;

        /* renamed from: l  reason: collision with root package name */
        View f4373l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f4374m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f4375n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f4376o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f4377p;

        /* renamed from: q  reason: collision with root package name */
        final Rect f4378q = new Rect();

        /* renamed from: r  reason: collision with root package name */
        Object f4379r;

        public f(int i10, int i11) {
            super(i10, i11);
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f4367f);
            this.f4372k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    ViewParent parent = findViewById.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f4373l = null;
                            this.f4372k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f4373l = findViewById;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f4373l = null;
                    this.f4372k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f4373l = null;
                this.f4372k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f4367f) + " to anchor view " + view);
            }
        }

        private boolean s(View view, int i10) {
            int b10 = androidx.core.view.e.b(((f) view.getLayoutParams()).f4368g, i10);
            if (b10 == 0 || (androidx.core.view.e.b(this.f4369h, i10) & b10) != b10) {
                return false;
            }
            return true;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f4372k.getId() != this.f4367f) {
                return false;
            }
            View view2 = this.f4372k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f4373l = null;
                    this.f4372k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f4373l = view2;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f4372k == null && this.f4367f != -1;
        }

        /* access modifiers changed from: package-private */
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            if (view2 == this.f4373l || s(view2, n0.B(coordinatorLayout)) || ((cVar = this.f4362a) != null && cVar.e(coordinatorLayout, view, view2))) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.f4362a == null) {
                this.f4374m = false;
            }
            return this.f4374m;
        }

        /* access modifiers changed from: package-private */
        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f4367f == -1) {
                this.f4373l = null;
                this.f4372k = null;
                return null;
            }
            if (this.f4372k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f4372k;
        }

        public int e() {
            return this.f4367f;
        }

        public c f() {
            return this.f4362a;
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            return this.f4377p;
        }

        /* access modifiers changed from: package-private */
        public Rect h() {
            return this.f4378q;
        }

        /* access modifiers changed from: package-private */
        public boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z10;
            boolean z11 = this.f4374m;
            if (z11) {
                return true;
            }
            c cVar = this.f4362a;
            if (cVar != null) {
                z10 = cVar.a(coordinatorLayout, view);
            } else {
                z10 = false;
            }
            boolean z12 = z10 | z11;
            this.f4374m = z12;
            return z12;
        }

        /* access modifiers changed from: package-private */
        public boolean j(int i10) {
            if (i10 == 0) {
                return this.f4375n;
            }
            if (i10 != 1) {
                return false;
            }
            return this.f4376o;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f4377p = false;
        }

        /* access modifiers changed from: package-private */
        public void l(int i10) {
            r(i10, false);
        }

        /* access modifiers changed from: package-private */
        public void m() {
            this.f4374m = false;
        }

        public void o(c cVar) {
            c cVar2 = this.f4362a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.j();
                }
                this.f4362a = cVar;
                this.f4379r = null;
                this.f4363b = true;
                if (cVar != null) {
                    cVar.g(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void p(boolean z10) {
            this.f4377p = z10;
        }

        /* access modifiers changed from: package-private */
        public void q(Rect rect) {
            this.f4378q.set(rect);
        }

        /* access modifiers changed from: package-private */
        public void r(int i10, boolean z10) {
            if (i10 == 0) {
                this.f4375n = z10;
            } else if (i10 == 1) {
                this.f4376o = z10;
            }
        }

        f(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s0.c.CoordinatorLayout_Layout);
            this.f4364c = obtainStyledAttributes.getInteger(s0.c.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f4367f = obtainStyledAttributes.getResourceId(s0.c.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f4365d = obtainStyledAttributes.getInteger(s0.c.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f4366e = obtainStyledAttributes.getInteger(s0.c.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f4368g = obtainStyledAttributes.getInt(s0.c.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f4369h = obtainStyledAttributes.getInt(s0.c.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i10 = s0.c.CoordinatorLayout_Layout_layout_behavior;
            boolean hasValue = obtainStyledAttributes.hasValue(i10);
            this.f4363b = hasValue;
            if (hasValue) {
                this.f4362a = CoordinatorLayout.K(context, attributeSet, obtainStyledAttributes.getString(i10));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.f4362a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(f fVar) {
            super(fVar);
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
