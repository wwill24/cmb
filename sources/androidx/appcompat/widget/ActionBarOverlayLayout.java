package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.m;
import androidx.core.view.e0;
import androidx.core.view.f0;
import androidx.core.view.g0;
import androidx.core.view.k2;
import androidx.core.view.n0;
import com.google.android.gms.common.api.a;
import d.f;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements i0, e0, f0 {
    static final int[] M = {d.a.actionBarSize, 16842841};
    @NonNull
    private k2 B;
    @NonNull
    private k2 C;
    @NonNull
    private k2 D;
    @NonNull
    private k2 E;
    private d F;
    private OverScroller G;
    ViewPropertyAnimator H;
    final AnimatorListenerAdapter I;
    private final Runnable J;
    private final Runnable K;
    private final g0 L;

    /* renamed from: a  reason: collision with root package name */
    private int f953a;

    /* renamed from: b  reason: collision with root package name */
    private int f954b = 0;

    /* renamed from: c  reason: collision with root package name */
    private ContentFrameLayout f955c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarContainer f956d;

    /* renamed from: e  reason: collision with root package name */
    private j0 f957e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f958f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f959g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f960h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f961j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f962k;

    /* renamed from: l  reason: collision with root package name */
    boolean f963l;

    /* renamed from: m  reason: collision with root package name */
    private int f964m;

    /* renamed from: n  reason: collision with root package name */
    private int f965n;

    /* renamed from: p  reason: collision with root package name */
    private final Rect f966p = new Rect();

    /* renamed from: q  reason: collision with root package name */
    private final Rect f967q = new Rect();

    /* renamed from: t  reason: collision with root package name */
    private final Rect f968t = new Rect();

    /* renamed from: w  reason: collision with root package name */
    private final Rect f969w = new Rect();

    /* renamed from: x  reason: collision with root package name */
    private final Rect f970x = new Rect();

    /* renamed from: y  reason: collision with root package name */
    private final Rect f971y = new Rect();

    /* renamed from: z  reason: collision with root package name */
    private final Rect f972z = new Rect();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.H = null;
            actionBarOverlayLayout.f963l = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.H = null;
            actionBarOverlayLayout.f963l = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.H = actionBarOverlayLayout.f956d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.I);
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.H = actionBarOverlayLayout.f956d.animate().translationY((float) (-ActionBarOverlayLayout.this.f956d.getHeight())).setListener(ActionBarOverlayLayout.this.I);
        }
    }

    public interface d {
        void a();

        void b(int i10);

        void c();

        void d(boolean z10);

        void e();

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k2 k2Var = k2.f4836b;
        this.B = k2Var;
        this.C = k2Var;
        this.D = k2Var;
        this.E = k2Var;
        this.I = new a();
        this.J = new b();
        this.K = new c();
        v(context);
        this.L = new g0(this);
    }

    private void A() {
        u();
        this.J.run();
    }

    private boolean B(float f10) {
        this.G.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER);
        if (this.G.getFinalY() > this.f956d.getHeight()) {
            return true;
        }
        return false;
    }

    private void p() {
        u();
        this.K.run();
    }

    private boolean q(@NonNull View view, @NonNull Rect rect, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14;
        int i10;
        int i11;
        int i12;
        int i13;
        e eVar = (e) view.getLayoutParams();
        if (!z10 || eVar.leftMargin == (i13 = rect.left)) {
            z14 = false;
        } else {
            eVar.leftMargin = i13;
            z14 = true;
        }
        if (z11 && eVar.topMargin != (i12 = rect.top)) {
            eVar.topMargin = i12;
            z14 = true;
        }
        if (z13 && eVar.rightMargin != (i11 = rect.right)) {
            eVar.rightMargin = i11;
            z14 = true;
        }
        if (!z12 || eVar.bottomMargin == (i10 = rect.bottom)) {
            return z14;
        }
        eVar.bottomMargin = i10;
        return true;
    }

    private j0 t(View view) {
        if (view instanceof j0) {
            return (j0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        boolean z10;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(M);
        boolean z11 = false;
        this.f953a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f958f = drawable;
        if (drawable == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        setWillNotDraw(z10);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z11 = true;
        }
        this.f959g = z11;
        this.G = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.K, 600);
    }

    private void y() {
        u();
        postDelayed(this.J, 600);
    }

    public boolean a() {
        z();
        return this.f957e.a();
    }

    public boolean b() {
        z();
        return this.f957e.b();
    }

    public boolean c() {
        z();
        return this.f957e.c();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public void d(Menu menu, m.a aVar) {
        z();
        this.f957e.d(menu, aVar);
    }

    public void draw(Canvas canvas) {
        int i10;
        super.draw(canvas);
        if (this.f958f != null && !this.f959g) {
            if (this.f956d.getVisibility() == 0) {
                i10 = (int) (((float) this.f956d.getBottom()) + this.f956d.getTranslationY() + 0.5f);
            } else {
                i10 = 0;
            }
            this.f958f.setBounds(0, i10, getWidth(), this.f958f.getIntrinsicHeight() + i10);
            this.f958f.draw(canvas);
        }
    }

    public boolean e() {
        z();
        return this.f957e.e();
    }

    public void f() {
        z();
        this.f957e.f();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public boolean g() {
        z();
        return this.f957e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f956d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.L.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f957e.getTitle();
    }

    public void h(int i10) {
        z();
        if (i10 == 2) {
            this.f957e.o();
        } else if (i10 == 5) {
            this.f957e.y();
        } else if (i10 == 109) {
            setOverlayMode(true);
        }
    }

    public void i(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    public void j(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    public void k(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    public void l() {
        z();
        this.f957e.q();
    }

    public void m(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        n(view, i10, i11, i12, i13, i14);
    }

    public void n(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    public boolean o(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        z();
        k2 v10 = k2.v(windowInsets, this);
        boolean q10 = q(this.f956d, new Rect(v10.i(), v10.k(), v10.j(), v10.h()), true, true, false, true);
        n0.f(this, v10, this.f966p);
        Rect rect = this.f966p;
        k2 l10 = v10.l(rect.left, rect.top, rect.right, rect.bottom);
        this.B = l10;
        boolean z10 = true;
        if (!this.C.equals(l10)) {
            this.C = this.B;
            q10 = true;
        }
        if (!this.f967q.equals(this.f966p)) {
            this.f967q.set(this.f966p);
        } else {
            z10 = q10;
        }
        if (z10) {
            requestLayout();
        }
        return v10.a().c().b().t();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        n0.p0(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = eVar.leftMargin + paddingLeft;
                int i16 = eVar.topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        boolean z10;
        int i12;
        z();
        measureChildWithMargins(this.f956d, i10, 0, i11, 0);
        e eVar = (e) this.f956d.getLayoutParams();
        int max = Math.max(0, this.f956d.getMeasuredWidth() + eVar.leftMargin + eVar.rightMargin);
        int max2 = Math.max(0, this.f956d.getMeasuredHeight() + eVar.topMargin + eVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f956d.getMeasuredState());
        if ((n0.O(this) & 256) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i12 = this.f953a;
            if (this.f961j && this.f956d.getTabContainer() != null) {
                i12 += this.f953a;
            }
        } else {
            i12 = this.f956d.getVisibility() != 8 ? this.f956d.getMeasuredHeight() : 0;
        }
        this.f968t.set(this.f966p);
        k2 k2Var = this.B;
        this.D = k2Var;
        if (this.f960h || z10) {
            this.D = new k2.b(this.D).c(androidx.core.graphics.b.b(k2Var.i(), this.D.k() + i12, this.D.j(), this.D.h() + 0)).a();
        } else {
            Rect rect = this.f968t;
            rect.top += i12;
            rect.bottom += 0;
            this.D = k2Var.l(0, i12, 0, 0);
        }
        q(this.f955c, this.f968t, true, true, true, true);
        if (!this.E.equals(this.D)) {
            k2 k2Var2 = this.D;
            this.E = k2Var2;
            n0.g(this.f955c, k2Var2);
        }
        measureChildWithMargins(this.f955c, i10, 0, i11, 0);
        e eVar2 = (e) this.f955c.getLayoutParams();
        int max3 = Math.max(max, this.f955c.getMeasuredWidth() + eVar2.leftMargin + eVar2.rightMargin);
        int max4 = Math.max(max2, this.f955c.getMeasuredHeight() + eVar2.topMargin + eVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f955c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f962k || !z10) {
            return false;
        }
        if (B(f11)) {
            p();
        } else {
            A();
        }
        this.f963l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f964m + i11;
        this.f964m = i14;
        setActionBarHideOffset(i14);
    }

    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.L.b(view, view2, i10);
        this.f964m = getActionBarHideOffset();
        u();
        d dVar = this.F;
        if (dVar != null) {
            dVar.f();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f956d.getVisibility() != 0) {
            return false;
        }
        return this.f962k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f962k && !this.f963l) {
            if (this.f964m <= this.f956d.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.F;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i10) {
        boolean z10;
        super.onWindowSystemUiVisibilityChanged(i10);
        z();
        int i11 = this.f965n ^ i10;
        this.f965n = i10;
        boolean z11 = false;
        if ((i10 & 4) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((i10 & 256) != 0) {
            z11 = true;
        }
        d dVar = this.F;
        if (dVar != null) {
            dVar.d(!z11);
            if (z10 || !z11) {
                this.F.a();
            } else {
                this.F.e();
            }
        }
        if ((i11 & 256) != 0 && this.F != null) {
            n0.p0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f954b = i10;
        d dVar = this.F;
        if (dVar != null) {
            dVar.b(i10);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    /* renamed from: s */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i10) {
        u();
        this.f956d.setTranslationY((float) (-Math.max(0, Math.min(i10, this.f956d.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.F = dVar;
        if (getWindowToken() != null) {
            this.F.b(this.f954b);
            int i10 = this.f965n;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                n0.p0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f961j = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f962k) {
            this.f962k = z10;
            if (!z10) {
                u();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i10) {
        z();
        this.f957e.setIcon(i10);
    }

    public void setLogo(int i10) {
        z();
        this.f957e.t(i10);
    }

    public void setOverlayMode(boolean z10) {
        boolean z11;
        this.f960h = z10;
        if (!z10 || getContext().getApplicationInfo().targetSdkVersion >= 19) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.f959g = z11;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f957e.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f957e.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        removeCallbacks(this.J);
        removeCallbacks(this.K);
        ViewPropertyAnimator viewPropertyAnimator = this.H;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f960h;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        if (this.f955c == null) {
            this.f955c = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.f956d = (ActionBarContainer) findViewById(f.action_bar_container);
            this.f957e = t(findViewById(f.action_bar));
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f957e.setIcon(drawable);
    }
}
