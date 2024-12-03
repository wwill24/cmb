package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.k;
import androidx.core.view.accessibility.n;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import bf.j;
import bf.k;
import bf.l;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;
import net.bytebuddy.jar.asm.Opcodes;
import tf.g;
import z0.c;

public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: w  reason: collision with root package name */
    private static final int f20031w = j.side_sheet_accessibility_pane_title;

    /* renamed from: x  reason: collision with root package name */
    private static final int f20032x = k.Widget_Material3_SideSheet;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public c f20033a;

    /* renamed from: b  reason: collision with root package name */
    private float f20034b;

    /* renamed from: c  reason: collision with root package name */
    private g f20035c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f20036d;

    /* renamed from: e  reason: collision with root package name */
    private tf.k f20037e;

    /* renamed from: f  reason: collision with root package name */
    private final SideSheetBehavior<V>.defpackage.b f20038f = new b();

    /* renamed from: g  reason: collision with root package name */
    private float f20039g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f20040h = true;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f20041i = 5;

    /* renamed from: j  reason: collision with root package name */
    private int f20042j = 5;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public c f20043k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f20044l;

    /* renamed from: m  reason: collision with root package name */
    private float f20045m = 0.1f;

    /* renamed from: n  reason: collision with root package name */
    private int f20046n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f20047o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public WeakReference<V> f20048p;

    /* renamed from: q  reason: collision with root package name */
    private WeakReference<View> f20049q;

    /* renamed from: r  reason: collision with root package name */
    private int f20050r = -1;

    /* renamed from: s  reason: collision with root package name */
    private VelocityTracker f20051s;

    /* renamed from: t  reason: collision with root package name */
    private int f20052t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    private final Set<f> f20053u = new LinkedHashSet();

    /* renamed from: v  reason: collision with root package name */
    private final c.C0226c f20054v = new a();

    class a extends c.C0226c {
        a() {
        }

        public int a(@NonNull View view, int i10, int i11) {
            return v0.a.b(i10, SideSheetBehavior.this.Z(), SideSheetBehavior.this.f20047o);
        }

        public int b(@NonNull View view, int i10, int i11) {
            return view.getTop();
        }

        public int d(@NonNull View view) {
            return SideSheetBehavior.this.f20047o;
        }

        public void j(int i10) {
            if (i10 == 1 && SideSheetBehavior.this.f20040h) {
                SideSheetBehavior.this.s0(1);
            }
        }

        public void k(@NonNull View view, int i10, int i11, int i12, int i13) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View X = SideSheetBehavior.this.X();
            if (!(X == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) X.getLayoutParams()) == null)) {
                SideSheetBehavior.this.f20033a.h(marginLayoutParams, view.getLeft(), view.getRight());
                X.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.T(view, i10);
        }

        public void l(@NonNull View view, float f10, float f11) {
            int b10 = SideSheetBehavior.this.f20033a.b(view, f10, f11);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.w0(view, b10, sideSheetBehavior.v0());
        }

        public boolean m(@NonNull View view, int i10) {
            if (SideSheetBehavior.this.f20041i == 1 || SideSheetBehavior.this.f20048p == null || SideSheetBehavior.this.f20048p.get() != view) {
                return false;
            }
            return true;
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        private int f20057a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f20058b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f20059c = new e(this);

        b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f20058b = false;
            if (SideSheetBehavior.this.f20043k != null && SideSheetBehavior.this.f20043k.k(true)) {
                b(this.f20057a);
            } else if (SideSheetBehavior.this.f20041i == 2) {
                SideSheetBehavior.this.s0(this.f20057a);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i10) {
            if (SideSheetBehavior.this.f20048p != null && SideSheetBehavior.this.f20048p.get() != null) {
                this.f20057a = i10;
                if (!this.f20058b) {
                    n0.k0((View) SideSheetBehavior.this.f20048p.get(), this.f20059c);
                    this.f20058b = true;
                }
            }
        }
    }

    public SideSheetBehavior() {
    }

    private int O(int i10, V v10) {
        int i11 = this.f20041i;
        if (i11 == 1 || i11 == 2) {
            return i10 - this.f20033a.e(v10);
        }
        if (i11 == 3) {
            return 0;
        }
        if (i11 == 5) {
            return this.f20033a.d();
        }
        throw new IllegalStateException("Unexpected value: " + this.f20041i);
    }

    private float P(float f10, float f11) {
        return Math.abs(f10 - f11);
    }

    private void Q() {
        WeakReference<View> weakReference = this.f20049q;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f20049q = null;
    }

    private n R(int i10) {
        return new uf.a(this, i10);
    }

    private void S(@NonNull Context context) {
        if (this.f20037e != null) {
            g gVar = new g(this.f20037e);
            this.f20035c = gVar;
            gVar.Q(context);
            ColorStateList colorStateList = this.f20036d;
            if (colorStateList != null) {
                this.f20035c.b0(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.f20035c.setTint(typedValue.data);
        }
    }

    /* access modifiers changed from: private */
    public void T(@NonNull View view, int i10) {
        if (!this.f20053u.isEmpty()) {
            float a10 = this.f20033a.a(i10);
            for (f b10 : this.f20053u) {
                b10.b(view, a10);
            }
        }
    }

    private void U(View view) {
        if (n0.p(view) == null) {
            n0.v0(view, view.getResources().getString(f20031w));
        }
    }

    private int V(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    private int Y() {
        return 0;
    }

    private boolean g0(@NonNull MotionEvent motionEvent) {
        if (t0() && P((float) this.f20052t, motionEvent.getX()) > ((float) this.f20043k.u())) {
            return true;
        }
        return false;
    }

    private boolean h0(@NonNull V v10) {
        ViewParent parent = v10.getParent();
        if (parent == null || !parent.isLayoutRequested() || !n0.V(v10)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean i0(int i10, View view, n.a aVar) {
        r0(i10);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(int i10) {
        View view = (View) this.f20048p.get();
        if (view != null) {
            w0(view, i10, false);
        }
    }

    private void k0(@NonNull CoordinatorLayout coordinatorLayout) {
        int i10;
        View findViewById;
        if (this.f20049q == null && (i10 = this.f20050r) != -1 && (findViewById = coordinatorLayout.findViewById(i10)) != null) {
            this.f20049q = new WeakReference<>(findViewById);
        }
    }

    private void l0(V v10, k.a aVar, int i10) {
        n0.o0(v10, aVar, (CharSequence) null, R(i10));
    }

    private void m0() {
        VelocityTracker velocityTracker = this.f20051s;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f20051s = null;
        }
    }

    private void n0(@NonNull V v10, Runnable runnable) {
        if (h0(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void q0(int i10) {
        c cVar = this.f20033a;
        if (cVar != null && cVar.f() == i10) {
            return;
        }
        if (i10 == 0) {
            this.f20033a = new a(this);
            return;
        }
        throw new IllegalArgumentException("Invalid sheet edge position value: " + i10 + ". Must be " + 0);
    }

    private boolean t0() {
        return this.f20043k != null && (this.f20040h || this.f20041i == 1);
    }

    private boolean u0(@NonNull V v10) {
        return (v10.isShown() || n0.p(v10) != null) && this.f20040h;
    }

    /* access modifiers changed from: private */
    public void w0(View view, int i10, boolean z10) {
        if (this.f20033a.g(view, i10, z10)) {
            s0(2);
            this.f20038f.b(i10);
            return;
        }
        s0(i10);
    }

    private void x0() {
        View view;
        WeakReference<V> weakReference = this.f20048p;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            n0.m0(view, Opcodes.ASM4);
            n0.m0(view, 1048576);
            if (this.f20041i != 5) {
                l0(view, k.a.f4779y, 5);
            }
            if (this.f20041i != 3) {
                l0(view, k.a.f4777w, 3);
            }
        }
    }

    private void y0(@NonNull View view) {
        int i10;
        if (this.f20041i == 5) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        if (view.getVisibility() != i10) {
            view.setVisibility(i10);
        }
    }

    public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f20041i == 1 && actionMasked == 0) {
            return true;
        }
        if (t0()) {
            this.f20043k.z(motionEvent);
        }
        if (actionMasked == 0) {
            m0();
        }
        if (this.f20051s == null) {
            this.f20051s = VelocityTracker.obtain();
        }
        this.f20051s.addMovement(motionEvent);
        if (t0() && actionMasked == 2 && !this.f20044l && g0(motionEvent)) {
            this.f20043k.b(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f20044l;
    }

    /* access modifiers changed from: package-private */
    public int W() {
        return this.f20046n;
    }

    public View X() {
        WeakReference<View> weakReference = this.f20049q;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int Z() {
        return this.f20033a.c();
    }

    public float a0() {
        return this.f20045m;
    }

    /* access modifiers changed from: package-private */
    public float b0() {
        return 0.5f;
    }

    /* access modifiers changed from: package-private */
    public int c0(int i10) {
        if (i10 == 3) {
            return Z();
        }
        if (i10 == 5) {
            return this.f20033a.d();
        }
        throw new IllegalArgumentException("Invalid state to get outward edge offset: " + i10);
    }

    /* access modifiers changed from: package-private */
    public int d0() {
        return this.f20047o;
    }

    /* access modifiers changed from: package-private */
    public int e0() {
        return 500;
    }

    /* access modifiers changed from: package-private */
    public c f0() {
        return this.f20043k;
    }

    public void g(@NonNull CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.f20048p = null;
        this.f20043k = null;
    }

    public void j() {
        super.j();
        this.f20048p = null;
        this.f20043k = null;
    }

    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull MotionEvent motionEvent) {
        c cVar;
        if (!u0(v10)) {
            this.f20044l = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m0();
        }
        if (this.f20051s == null) {
            this.f20051s = VelocityTracker.obtain();
        }
        this.f20051s.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f20052t = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f20044l) {
            this.f20044l = false;
            return false;
        }
        if (this.f20044l || (cVar = this.f20043k) == null || !cVar.G(motionEvent)) {
            return false;
        }
        return true;
    }

    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        if (n0.y(coordinatorLayout) && !n0.y(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.f20048p == null) {
            this.f20048p = new WeakReference<>(v10);
            g gVar = this.f20035c;
            if (gVar != null) {
                n0.w0(v10, gVar);
                g gVar2 = this.f20035c;
                float f10 = this.f20039g;
                if (f10 == -1.0f) {
                    f10 = n0.w(v10);
                }
                gVar2.a0(f10);
            } else {
                ColorStateList colorStateList = this.f20036d;
                if (colorStateList != null) {
                    n0.x0(v10, colorStateList);
                }
            }
            y0(v10);
            x0();
            if (n0.z(v10) == 0) {
                n0.D0(v10, 1);
            }
            U(v10);
        }
        if (this.f20043k == null) {
            this.f20043k = c.m(coordinatorLayout, this.f20054v);
        }
        int e10 = this.f20033a.e(v10);
        coordinatorLayout.I(v10, i10);
        this.f20047o = coordinatorLayout.getWidth();
        this.f20046n = v10.getWidth();
        n0.c0(v10, O(e10, v10));
        k0(coordinatorLayout);
        for (b next : this.f20053u) {
            if (next instanceof f) {
                ((f) next).c(v10);
            }
        }
        return true;
    }

    public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(V(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, -1, marginLayoutParams.width), V(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, -1, marginLayoutParams.height));
        return true;
    }

    public void o0(int i10) {
        this.f20050r = i10;
        Q();
        WeakReference<V> weakReference = this.f20048p;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (i10 != -1 && n0.W(view)) {
                view.requestLayout();
            }
        }
    }

    public void p0(boolean z10) {
        this.f20040h = z10;
    }

    public void r0(int i10) {
        String str;
        if (i10 == 1 || i10 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            if (i10 == 1) {
                str = "DRAGGING";
            } else {
                str = "SETTLING";
            }
            sb2.append(str);
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        }
        WeakReference<V> weakReference = this.f20048p;
        if (weakReference == null || weakReference.get() == null) {
            s0(i10);
        } else {
            n0((View) this.f20048p.get(), new uf.b(this, i10));
        }
    }

    /* access modifiers changed from: package-private */
    public void s0(int i10) {
        View view;
        if (this.f20041i != i10) {
            this.f20041i = i10;
            if (i10 == 3 || i10 == 5) {
                this.f20042j = i10;
            }
            WeakReference<V> weakReference = this.f20048p;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                y0(view);
                for (f a10 : this.f20053u) {
                    a10.a(view, i10);
                }
                x0();
            }
        }
    }

    public boolean v0() {
        return true;
    }

    public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.a() != null) {
            super.x(coordinatorLayout, v10, savedState.a());
        }
        int i10 = savedState.f20055c;
        if (i10 == 1 || i10 == 2) {
            i10 = 5;
        }
        this.f20041i = i10;
        this.f20042j = i10;
    }

    @NonNull
    public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10) {
        return new SavedState(super.y(coordinatorLayout, v10), (SideSheetBehavior<?>) this);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        final int f20055c;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f20055c = parcel.readInt();
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f20055c);
        }

        public SavedState(Parcelable parcelable, @NonNull SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.f20055c = sideSheetBehavior.f20041i;
        }
    }

    public SideSheetBehavior(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.SideSheetBehavior_Layout);
        int i10 = l.SideSheetBehavior_Layout_backgroundTint;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.f20036d = qf.c.a(context, obtainStyledAttributes, i10);
        }
        if (obtainStyledAttributes.hasValue(l.SideSheetBehavior_Layout_shapeAppearance)) {
            this.f20037e = tf.k.e(context, attributeSet, 0, f20032x).m();
        }
        int i11 = l.SideSheetBehavior_Layout_coplanarSiblingViewId;
        if (obtainStyledAttributes.hasValue(i11)) {
            o0(obtainStyledAttributes.getResourceId(i11, -1));
        }
        S(context);
        this.f20039g = obtainStyledAttributes.getDimension(l.SideSheetBehavior_Layout_android_elevation, -1.0f);
        p0(obtainStyledAttributes.getBoolean(l.SideSheetBehavior_Layout_behavior_draggable, true));
        obtainStyledAttributes.recycle();
        q0(Y());
        this.f20034b = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
