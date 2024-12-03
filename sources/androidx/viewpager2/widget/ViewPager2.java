package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.k;
import androidx.core.view.accessibility.n;
import androidx.core.view.n0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u;
import net.bytebuddy.jar.asm.Opcodes;

public final class ViewPager2 extends ViewGroup {
    static boolean B = true;

    /* renamed from: a  reason: collision with root package name */
    private final Rect f7254a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private final Rect f7255b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private b f7256c = new b(3);

    /* renamed from: d  reason: collision with root package name */
    int f7257d;

    /* renamed from: e  reason: collision with root package name */
    boolean f7258e = false;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.i f7259f = new a();

    /* renamed from: g  reason: collision with root package name */
    private LinearLayoutManager f7260g;

    /* renamed from: h  reason: collision with root package name */
    private int f7261h = -1;

    /* renamed from: j  reason: collision with root package name */
    private Parcelable f7262j;

    /* renamed from: k  reason: collision with root package name */
    RecyclerView f7263k;

    /* renamed from: l  reason: collision with root package name */
    private u f7264l;

    /* renamed from: m  reason: collision with root package name */
    e f7265m;

    /* renamed from: n  reason: collision with root package name */
    private b f7266n;

    /* renamed from: p  reason: collision with root package name */
    private c f7267p;

    /* renamed from: q  reason: collision with root package name */
    private d f7268q;

    /* renamed from: t  reason: collision with root package name */
    private RecyclerView.l f7269t = null;

    /* renamed from: w  reason: collision with root package name */
    private boolean f7270w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f7271x = true;

    /* renamed from: y  reason: collision with root package name */
    private int f7272y = -1;

    /* renamed from: z  reason: collision with root package name */
    e f7273z;

    class a extends g {
        a() {
            super((a) null);
        }

        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f7258e = true;
            viewPager2.f7265m.l();
        }
    }

    class b extends i {
        b() {
        }

        public void a(int i10) {
            if (i10 == 0) {
                ViewPager2.this.o();
            }
        }

        public void c(int i10) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f7257d != i10) {
                viewPager2.f7257d = i10;
                viewPager2.f7273z.q();
            }
        }
    }

    class c extends i {
        c() {
        }

        public void c(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f7263k.requestFocus(2);
            }
        }
    }

    class d implements RecyclerView.q {
        d() {
        }

        public void b(@NonNull View view) {
        }

        public void d(@NonNull View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            if (pVar.width != -1 || pVar.height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }
    }

    private abstract class e {
        private e() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i10) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i10, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(RecyclerView.Adapter<?> adapter) {
        }

        /* access modifiers changed from: package-private */
        public void f(RecyclerView.Adapter<?> adapter) {
        }

        /* access modifiers changed from: package-private */
        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void h(@NonNull b bVar, @NonNull RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* access modifiers changed from: package-private */
        public void j(@NonNull androidx.core.view.accessibility.k kVar) {
        }

        /* access modifiers changed from: package-private */
        public boolean k(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean l(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void m() {
        }

        /* access modifiers changed from: package-private */
        public CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void o(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        /* access modifiers changed from: package-private */
        public void p() {
        }

        /* access modifiers changed from: package-private */
        public void q() {
        }

        /* access modifiers changed from: package-private */
        public void r() {
        }

        /* access modifiers changed from: package-private */
        public void s() {
        }

        /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this();
        }
    }

    class f extends e {
        f() {
            super(ViewPager2.this, (a) null);
        }

        public boolean b(int i10) {
            if ((i10 == 8192 || i10 == 4096) && !ViewPager2.this.e()) {
                return true;
            }
            return false;
        }

        public boolean d() {
            return true;
        }

        public void j(@NonNull androidx.core.view.accessibility.k kVar) {
            if (!ViewPager2.this.e()) {
                kVar.S(k.a.f4772r);
                kVar.S(k.a.f4771q);
                kVar.u0(false);
            }
        }

        public boolean k(int i10) {
            if (b(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class g extends RecyclerView.i {
        private g() {
        }

        public abstract void a();

        public final void b(int i10, int i11) {
            a();
        }

        public final void c(int i10, int i11, Object obj) {
            a();
        }

        public final void d(int i10, int i11) {
            a();
        }

        public final void e(int i10, int i11, int i12) {
            a();
        }

        public final void f(int i10, int i11) {
            a();
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    private class h extends LinearLayoutManager {
        h(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void N1(@NonNull RecyclerView.z zVar, @NonNull int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.N1(zVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        public void O0(@NonNull RecyclerView.v vVar, @NonNull RecyclerView.z zVar, @NonNull androidx.core.view.accessibility.k kVar) {
            super.O0(vVar, zVar, kVar);
            ViewPager2.this.f7273z.j(kVar);
        }

        public boolean i1(@NonNull RecyclerView.v vVar, @NonNull RecyclerView.z zVar, int i10, Bundle bundle) {
            if (ViewPager2.this.f7273z.b(i10)) {
                return ViewPager2.this.f7273z.k(i10);
            }
            return super.i1(vVar, zVar, i10, bundle);
        }

        public boolean t1(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z10, boolean z11) {
            return false;
        }
    }

    public static abstract class i {
        public void a(int i10) {
        }

        public void b(int i10, float f10, int i11) {
        }

        public void c(int i10) {
        }
    }

    class j extends e {

        /* renamed from: b  reason: collision with root package name */
        private final androidx.core.view.accessibility.n f7283b = new a();

        /* renamed from: c  reason: collision with root package name */
        private final androidx.core.view.accessibility.n f7284c = new b();

        /* renamed from: d  reason: collision with root package name */
        private RecyclerView.i f7285d;

        class a implements androidx.core.view.accessibility.n {
            a() {
            }

            public boolean a(@NonNull View view, n.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        class b implements androidx.core.view.accessibility.n {
            b() {
            }

            public boolean a(@NonNull View view, n.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        class c extends g {
            c() {
                super((a) null);
            }

            public void a() {
                j.this.w();
            }
        }

        j() {
            super(ViewPager2.this, (a) null);
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i10;
            int i11;
            if (ViewPager2.this.getAdapter() == null) {
                i11 = 0;
                i10 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i11 = ViewPager2.this.getAdapter().g();
                i10 = 0;
            } else {
                i10 = ViewPager2.this.getAdapter().g();
                i11 = 0;
            }
            androidx.core.view.accessibility.k.C0(accessibilityNodeInfo).c0(k.b.a(i11, i10, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int g10;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (g10 = adapter.g()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.f7257d > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (ViewPager2.this.f7257d < g10 - 1) {
                    accessibilityNodeInfo.addAction(Opcodes.ACC_SYNTHETIC);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }

        public boolean a() {
            return true;
        }

        public boolean c(int i10, Bundle bundle) {
            return i10 == 8192 || i10 == 4096;
        }

        public void e(RecyclerView.Adapter<?> adapter) {
            w();
            if (adapter != null) {
                adapter.D(this.f7285d);
            }
        }

        public void f(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.F(this.f7285d);
            }
        }

        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        public void h(@NonNull b bVar, @NonNull RecyclerView recyclerView) {
            n0.D0(recyclerView, 2);
            this.f7285d = new c();
            if (n0.z(ViewPager2.this) == 0) {
                n0.D0(ViewPager2.this, 1);
            }
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            u(accessibilityNodeInfo);
        }

        public boolean l(int i10, Bundle bundle) {
            int i11;
            if (c(i10, bundle)) {
                if (i10 == 8192) {
                    i11 = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    i11 = ViewPager2.this.getCurrentItem() + 1;
                }
                v(i11);
                return true;
            }
            throw new IllegalStateException();
        }

        public void m() {
            w();
        }

        public void o(@NonNull AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        public void p() {
            w();
        }

        public void q() {
            w();
        }

        public void r() {
            w();
        }

        public void s() {
            w();
        }

        /* access modifiers changed from: package-private */
        public void v(int i10) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i10, true);
            }
        }

        /* access modifiers changed from: package-private */
        public void w() {
            int g10;
            int i10;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i11 = 16908360;
            n0.m0(viewPager2, 16908360);
            n0.m0(viewPager2, 16908361);
            n0.m0(viewPager2, 16908358);
            n0.m0(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (g10 = ViewPager2.this.getAdapter().g()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean d10 = ViewPager2.this.d();
                    if (d10) {
                        i10 = 16908360;
                    } else {
                        i10 = 16908361;
                    }
                    if (d10) {
                        i11 = 16908361;
                    }
                    if (ViewPager2.this.f7257d < g10 - 1) {
                        n0.o0(viewPager2, new k.a(i10, (CharSequence) null), (CharSequence) null, this.f7283b);
                    }
                    if (ViewPager2.this.f7257d > 0) {
                        n0.o0(viewPager2, new k.a(i11, (CharSequence) null), (CharSequence) null, this.f7284c);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.f7257d < g10 - 1) {
                    n0.o0(viewPager2, new k.a(16908359, (CharSequence) null), (CharSequence) null, this.f7283b);
                }
                if (ViewPager2.this.f7257d > 0) {
                    n0.o0(viewPager2, new k.a(16908358, (CharSequence) null), (CharSequence) null, this.f7284c);
                }
            }
        }
    }

    public interface k {
        void a(@NonNull View view, float f10);
    }

    private class l extends u {
        l() {
        }

        public View f(RecyclerView.o oVar) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.f(oVar);
        }
    }

    private class m extends RecyclerView {
        m(@NonNull Context context) {
            super(context);
        }

        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f7273z.d()) {
                return ViewPager2.this.f7273z.n();
            }
            return super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f7257d);
            accessibilityEvent.setToIndex(ViewPager2.this.f7257d);
            ViewPager2.this.f7273z.o(accessibilityEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    private static class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f7291a;

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView f7292b;

        n(int i10, RecyclerView recyclerView) {
            this.f7291a = i10;
            this.f7292b = recyclerView;
        }

        public void run() {
            this.f7292b.B1(this.f7291a);
        }
    }

    public ViewPager2(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    private RecyclerView.q a() {
        return new d();
    }

    private void b(Context context, AttributeSet attributeSet) {
        e eVar;
        if (B) {
            eVar = new j();
        } else {
            eVar = new f();
        }
        this.f7273z = eVar;
        m mVar = new m(context);
        this.f7263k = mVar;
        mVar.setId(n0.k());
        this.f7263k.setDescendantFocusability(Opcodes.ACC_DEPRECATED);
        h hVar = new h(context);
        this.f7260g = hVar;
        this.f7263k.setLayoutManager(hVar);
        this.f7263k.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f7263k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f7263k.j(a());
        e eVar2 = new e(this);
        this.f7265m = eVar2;
        this.f7267p = new c(this, eVar2, this.f7263k);
        l lVar = new l();
        this.f7264l = lVar;
        lVar.b(this.f7263k);
        this.f7263k.l(this.f7265m);
        b bVar = new b(3);
        this.f7266n = bVar;
        this.f7265m.o(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f7266n.d(bVar2);
        this.f7266n.d(cVar);
        this.f7273z.h(this.f7266n, this.f7263k);
        this.f7266n.d(this.f7256c);
        d dVar = new d(this.f7260g);
        this.f7268q = dVar;
        this.f7266n.d(dVar);
        RecyclerView recyclerView = this.f7263k;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void f(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.D(this.f7259f);
        }
    }

    private void i() {
        RecyclerView.Adapter adapter;
        if (this.f7261h != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.f7262j;
            if (parcelable != null) {
                if (adapter instanceof androidx.viewpager2.adapter.b) {
                    ((androidx.viewpager2.adapter.b) adapter).b(parcelable);
                }
                this.f7262j = null;
            }
            int max = Math.max(0, Math.min(this.f7261h, adapter.g() - 1));
            this.f7257d = max;
            this.f7261h = -1;
            this.f7263k.s1(max);
            this.f7273z.m();
        }
    }

    private void l(Context context, AttributeSet attributeSet) {
        int[] iArr = a2.a.ViewPager2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(a2.a.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.F(this.f7259f);
        }
    }

    public boolean c() {
        return this.f7267p.a();
    }

    public boolean canScrollHorizontally(int i10) {
        return this.f7263k.canScrollHorizontally(i10);
    }

    public boolean canScrollVertically(int i10) {
        return this.f7263k.canScrollVertically(i10);
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f7260g.a0() == 1;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f7274a;
            sparseArray.put(this.f7263k.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f7271x;
    }

    public void g(@NonNull i iVar) {
        this.f7256c.d(iVar);
    }

    public CharSequence getAccessibilityClassName() {
        if (this.f7273z.a()) {
            return this.f7273z.g();
        }
        return super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f7263k.getAdapter();
    }

    public int getCurrentItem() {
        return this.f7257d;
    }

    public int getItemDecorationCount() {
        return this.f7263k.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f7272y;
    }

    public int getOrientation() {
        return this.f7260g.n2();
    }

    /* access modifiers changed from: package-private */
    public int getPageSize() {
        int i10;
        int i11;
        RecyclerView recyclerView = this.f7263k;
        if (getOrientation() == 0) {
            i10 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i11 = recyclerView.getPaddingRight();
        } else {
            i10 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i11 = recyclerView.getPaddingBottom();
        }
        return i10 - i11;
    }

    public int getScrollState() {
        return this.f7265m.h();
    }

    public void h() {
        if (this.f7268q.d() != null) {
            double g10 = this.f7265m.g();
            int i10 = (int) g10;
            float f10 = (float) (g10 - ((double) i10));
            this.f7268q.b(i10, f10, Math.round(((float) getPageSize()) * f10));
        }
    }

    public void j(int i10, boolean z10) {
        if (!c()) {
            k(i10, z10);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    /* access modifiers changed from: package-private */
    public void k(int i10, boolean z10) {
        int i11;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f7261h != -1) {
                this.f7261h = Math.max(i10, 0);
            }
        } else if (adapter.g() > 0) {
            int min = Math.min(Math.max(i10, 0), adapter.g() - 1);
            if (min != this.f7257d || !this.f7265m.j()) {
                int i12 = this.f7257d;
                if (min != i12 || !z10) {
                    double d10 = (double) i12;
                    this.f7257d = min;
                    this.f7273z.q();
                    if (!this.f7265m.j()) {
                        d10 = this.f7265m.g();
                    }
                    this.f7265m.m(min, z10);
                    if (!z10) {
                        this.f7263k.s1(min);
                        return;
                    }
                    double d11 = (double) min;
                    if (Math.abs(d11 - d10) > 3.0d) {
                        RecyclerView recyclerView = this.f7263k;
                        if (d11 > d10) {
                            i11 = min - 3;
                        } else {
                            i11 = min + 3;
                        }
                        recyclerView.s1(i11);
                        RecyclerView recyclerView2 = this.f7263k;
                        recyclerView2.post(new n(min, recyclerView2));
                        return;
                    }
                    this.f7263k.B1(min);
                }
            }
        }
    }

    public void n(@NonNull i iVar) {
        this.f7256c.e(iVar);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        u uVar = this.f7264l;
        if (uVar != null) {
            View f10 = uVar.f(this.f7260g);
            if (f10 != null) {
                int i02 = this.f7260g.i0(f10);
                if (i02 != this.f7257d && getScrollState() == 0) {
                    this.f7266n.c(i02);
                }
                this.f7258e = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f7273z.i(accessibilityNodeInfo);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f7263k.getMeasuredWidth();
        int measuredHeight = this.f7263k.getMeasuredHeight();
        this.f7254a.left = getPaddingLeft();
        this.f7254a.right = (i12 - i10) - getPaddingRight();
        this.f7254a.top = getPaddingTop();
        this.f7254a.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f7254a, this.f7255b);
        RecyclerView recyclerView = this.f7263k;
        Rect rect = this.f7255b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f7258e) {
            o();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        measureChild(this.f7263k, i10, i11);
        int measuredWidth = this.f7263k.getMeasuredWidth();
        int measuredHeight = this.f7263k.getMeasuredHeight();
        int measuredState = this.f7263k.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f7261h = savedState.f7275b;
        this.f7262j = savedState.f7276c;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7274a = this.f7263k.getId();
        int i10 = this.f7261h;
        if (i10 == -1) {
            i10 = this.f7257d;
        }
        savedState.f7275b = i10;
        Parcelable parcelable = this.f7262j;
        if (parcelable != null) {
            savedState.f7276c = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.f7263k.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.b) {
                savedState.f7276c = ((androidx.viewpager2.adapter.b) adapter).a();
            }
        }
        return savedState;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        if (this.f7273z.c(i10, bundle)) {
            return this.f7273z.l(i10, bundle);
        }
        return super.performAccessibilityAction(i10, bundle);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f7263k.getAdapter();
        this.f7273z.f(adapter2);
        m(adapter2);
        this.f7263k.setAdapter(adapter);
        this.f7257d = 0;
        i();
        this.f7273z.e(adapter);
        f(adapter);
    }

    public void setCurrentItem(int i10) {
        j(i10, true);
    }

    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.f7273z.p();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 >= 1 || i10 == -1) {
            this.f7272y = i10;
            this.f7263k.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i10) {
        this.f7260g.B2(i10);
        this.f7273z.r();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.f7270w) {
                this.f7269t = this.f7263k.getItemAnimator();
                this.f7270w = true;
            }
            this.f7263k.setItemAnimator((RecyclerView.l) null);
        } else if (this.f7270w) {
            this.f7263k.setItemAnimator(this.f7269t);
            this.f7269t = null;
            this.f7270w = false;
        }
        if (kVar != this.f7268q.d()) {
            this.f7268q.e(kVar);
            h();
        }
    }

    public void setUserInputEnabled(boolean z10) {
        this.f7271x = z10;
        this.f7273z.s();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f7274a;

        /* renamed from: b  reason: collision with root package name */
        int f7275b;

        /* renamed from: c  reason: collision with root package name */
        Parcelable f7276c;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
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

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f7274a = parcel.readInt();
            this.f7275b = parcel.readInt();
            this.f7276c = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f7274a);
            parcel.writeInt(this.f7275b);
            parcel.writeParcelable(this.f7276c, i10);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
