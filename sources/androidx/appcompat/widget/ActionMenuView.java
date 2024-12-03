package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements g.b, n {
    private m.a B;
    g.a C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    e H;

    /* renamed from: t  reason: collision with root package name */
    private g f996t;

    /* renamed from: w  reason: collision with root package name */
    private Context f997w;

    /* renamed from: x  reason: collision with root package name */
    private int f998x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f999y;

    /* renamed from: z  reason: collision with root package name */
    private ActionMenuPresenter f1000z;

    public interface a {
        boolean a();

        boolean b();
    }

    private static class b implements m.a {
        b() {
        }

        public void c(@NonNull g gVar, boolean z10) {
        }

        public boolean d(@NonNull g gVar) {
            return false;
        }
    }

    public static class c extends LinearLayoutCompat.a {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f1001a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f1002b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f1003c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f1004d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f1005e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1006f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f1001a = cVar.f1001a;
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f1001a = false;
        }
    }

    private class d implements g.a {
        d() {
        }

        public boolean a(@NonNull g gVar, @NonNull MenuItem menuItem) {
            e eVar = ActionMenuView.this.H;
            if (eVar == null || !eVar.onMenuItemClick(menuItem)) {
                return false;
            }
            return true;
        }

        public void b(@NonNull g gVar) {
            g.a aVar = ActionMenuView.this.C;
            if (aVar != null) {
                aVar.b(gVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    static int J(View view, int i10, int i11, int i12, int i13) {
        ActionMenuItemView actionMenuItemView;
        boolean z10;
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12) - i13, View.MeasureSpec.getMode(i12));
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView) view;
        } else {
            actionMenuItemView = null;
        }
        boolean z11 = true;
        if (actionMenuItemView == null || !actionMenuItemView.r()) {
            z10 = false;
        } else {
            z10 = true;
        }
        int i14 = 2;
        if (i11 <= 0 || (z10 && i11 < 2)) {
            i14 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i10, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i15 = measuredWidth / i10;
            if (measuredWidth % i10 != 0) {
                i15++;
            }
            if (!z10 || i15 >= 2) {
                i14 = i15;
            }
        }
        if (cVar.f1001a || !z10) {
            z11 = false;
        }
        cVar.f1004d = z11;
        cVar.f1002b = i14;
        view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, 1073741824), makeMeasureSpec);
        return i14;
    }

    private void K(int i10, int i11) {
        boolean z10;
        int i12;
        boolean z11;
        int i13;
        int i14;
        boolean z12;
        int i15;
        boolean z13;
        int i16;
        int i17;
        boolean z14;
        int i18;
        boolean z15;
        boolean z16;
        int i19;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i20 = size - paddingLeft;
        int i21 = this.F;
        int i22 = i20 / i21;
        int i23 = i20 % i21;
        if (i22 == 0) {
            setMeasuredDimension(i20, 0);
            return;
        }
        int i24 = i21 + (i23 / i22);
        int childCount = getChildCount();
        int i25 = 0;
        int i26 = 0;
        boolean z17 = false;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        long j10 = 0;
        while (i26 < childCount) {
            View childAt = getChildAt(i26);
            int i30 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z18 = childAt instanceof ActionMenuItemView;
                int i31 = i27 + 1;
                if (z18) {
                    int i32 = this.G;
                    i18 = i31;
                    z15 = false;
                    childAt.setPadding(i32, 0, i32, 0);
                } else {
                    i18 = i31;
                    z15 = false;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f1006f = z15;
                cVar.f1003c = z15 ? 1 : 0;
                cVar.f1002b = z15;
                cVar.f1004d = z15;
                cVar.leftMargin = z15;
                cVar.rightMargin = z15;
                if (!z18 || !((ActionMenuItemView) childAt).r()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                cVar.f1005e = z16;
                if (cVar.f1001a) {
                    i19 = 1;
                } else {
                    i19 = i22;
                }
                int J = J(childAt, i24, i19, childMeasureSpec, paddingTop);
                i28 = Math.max(i28, J);
                if (cVar.f1004d) {
                    i29++;
                }
                if (cVar.f1001a) {
                    z17 = true;
                }
                i22 -= J;
                i25 = Math.max(i25, childAt.getMeasuredHeight());
                if (J == 1) {
                    j10 |= (long) (1 << i26);
                    i25 = i25;
                } else {
                    int i33 = i25;
                }
                i27 = i18;
            }
            i26++;
            size2 = i30;
        }
        int i34 = size2;
        if (!z17 || i27 != 2) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean z19 = false;
        while (true) {
            if (i29 <= 0 || i22 <= 0) {
                i14 = mode;
                i12 = i20;
                z11 = z19;
                i13 = i25;
            } else {
                int i35 = Integer.MAX_VALUE;
                int i36 = 0;
                int i37 = 0;
                long j11 = 0;
                while (i37 < childCount) {
                    boolean z20 = z19;
                    c cVar2 = (c) getChildAt(i37).getLayoutParams();
                    int i38 = i25;
                    if (cVar2.f1004d) {
                        int i39 = cVar2.f1002b;
                        if (i39 < i35) {
                            j11 = 1 << i37;
                            i35 = i39;
                            i36 = 1;
                        } else if (i39 == i35) {
                            i36++;
                            j11 |= 1 << i37;
                        }
                    }
                    i37++;
                    i25 = i38;
                    z19 = z20;
                }
                z11 = z19;
                i13 = i25;
                j10 |= j11;
                if (i36 > i22) {
                    i14 = mode;
                    i12 = i20;
                    break;
                }
                int i40 = i35 + 1;
                int i41 = 0;
                while (i41 < childCount) {
                    View childAt2 = getChildAt(i41);
                    c cVar3 = (c) childAt2.getLayoutParams();
                    int i42 = i20;
                    int i43 = mode;
                    long j12 = (long) (1 << i41);
                    if ((j11 & j12) == 0) {
                        if (cVar3.f1002b == i40) {
                            j10 |= j12;
                        }
                        z14 = z10;
                    } else {
                        if (!z10 || !cVar3.f1005e || i22 != 1) {
                            z14 = z10;
                        } else {
                            int i44 = this.G;
                            z14 = z10;
                            childAt2.setPadding(i44 + i24, 0, i44, 0);
                        }
                        cVar3.f1002b++;
                        cVar3.f1006f = true;
                        i22--;
                    }
                    i41++;
                    mode = i43;
                    i20 = i42;
                    z10 = z14;
                }
                i25 = i13;
                z19 = true;
            }
        }
        if (z17 || i27 != 1) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (i22 <= 0 || j10 == 0 || (i22 >= i27 - 1 && !z12 && i28 <= 1)) {
            i15 = 0;
            z13 = z11;
        } else {
            float bitCount = (float) Long.bitCount(j10);
            if (!z12) {
                i15 = 0;
                if ((j10 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f1005e) {
                    bitCount -= 0.5f;
                }
                int i45 = childCount - 1;
                if ((j10 & ((long) (1 << i45))) != 0 && !((c) getChildAt(i45).getLayoutParams()).f1005e) {
                    bitCount -= 0.5f;
                }
            } else {
                i15 = 0;
            }
            if (bitCount > 0.0f) {
                i17 = (int) (((float) (i22 * i24)) / bitCount);
            } else {
                i17 = i15;
            }
            z13 = z11;
            for (int i46 = i15; i46 < childCount; i46++) {
                if ((j10 & ((long) (1 << i46))) != 0) {
                    View childAt3 = getChildAt(i46);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f1003c = i17;
                        cVar4.f1006f = true;
                        if (i46 == 0 && !cVar4.f1005e) {
                            cVar4.leftMargin = (-i17) / 2;
                        }
                        z13 = true;
                    } else if (cVar4.f1001a) {
                        cVar4.f1003c = i17;
                        cVar4.f1006f = true;
                        cVar4.rightMargin = (-i17) / 2;
                        z13 = true;
                    } else {
                        if (i46 != 0) {
                            cVar4.leftMargin = i17 / 2;
                        }
                        if (i46 != childCount - 1) {
                            cVar4.rightMargin = i17 / 2;
                        }
                    }
                }
            }
        }
        if (z13) {
            for (int i47 = i15; i47 < childCount; i47++) {
                View childAt4 = getChildAt(i47);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f1006f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f1002b * i24) + cVar5.f1003c, 1073741824), childMeasureSpec);
                }
            }
        }
        if (i14 != 1073741824) {
            i16 = i13;
        } else {
            i16 = i34;
        }
        setMeasuredDimension(i12, i16);
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public c k() {
        c cVar = new c(-2, -2);
        cVar.gravity = 16;
        return cVar;
    }

    /* renamed from: B */
    public c l(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public c m(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams == null) {
            return k();
        }
        if (layoutParams instanceof c) {
            cVar = new c((c) layoutParams);
        } else {
            cVar = new c(layoutParams);
        }
        if (cVar.gravity <= 0) {
            cVar.gravity = 16;
        }
        return cVar;
    }

    public c D() {
        c A = k();
        A.f1001a = true;
        return A;
    }

    /* access modifiers changed from: protected */
    public boolean E(int i10) {
        boolean z10 = false;
        if (i10 == 0) {
            return false;
        }
        View childAt = getChildAt(i10 - 1);
        View childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof a)) {
            z10 = false | ((a) childAt).a();
        }
        if (i10 <= 0 || !(childAt2 instanceof a)) {
            return z10;
        }
        return z10 | ((a) childAt2).b();
    }

    public boolean F() {
        ActionMenuPresenter actionMenuPresenter = this.f1000z;
        return actionMenuPresenter != null && actionMenuPresenter.B();
    }

    public boolean G() {
        ActionMenuPresenter actionMenuPresenter = this.f1000z;
        return actionMenuPresenter != null && actionMenuPresenter.D();
    }

    public boolean H() {
        ActionMenuPresenter actionMenuPresenter = this.f1000z;
        return actionMenuPresenter != null && actionMenuPresenter.E();
    }

    public boolean I() {
        return this.f999y;
    }

    public g L() {
        return this.f996t;
    }

    public void M(m.a aVar, g.a aVar2) {
        this.B = aVar;
        this.C = aVar2;
    }

    public boolean N() {
        ActionMenuPresenter actionMenuPresenter = this.f1000z;
        return actionMenuPresenter != null && actionMenuPresenter.K();
    }

    public void a(g gVar) {
        this.f996t = gVar;
    }

    public boolean b(i iVar) {
        return this.f996t.L(iVar, 0);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f996t == null) {
            Context context = getContext();
            g gVar = new g(context);
            this.f996t = gVar;
            gVar.R(new d());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f1000z = actionMenuPresenter;
            actionMenuPresenter.J(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f1000z;
            m.a aVar = this.B;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter2.e(aVar);
            this.f996t.c(this.f1000z, this.f997w);
            this.f1000z.H(this);
        }
        return this.f996t;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1000z.A();
    }

    public int getPopupTheme() {
        return this.f998x;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1000z;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.g(false);
            if (this.f1000z.E()) {
                this.f1000z.B();
                this.f1000z.K();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        if (!this.D) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i17 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i18 = i12 - i10;
        int paddingRight = (i18 - getPaddingRight()) - getPaddingLeft();
        boolean b10 = t1.b(this);
        int i19 = 0;
        int i20 = 0;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1001a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (E(i21)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b10) {
                        i15 = getPaddingLeft() + cVar.leftMargin;
                        i16 = i15 + measuredWidth;
                    } else {
                        i16 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i15 = i16 - measuredWidth;
                    }
                    int i22 = i17 - (measuredHeight / 2);
                    childAt.layout(i15, i22, i16, measuredHeight + i22);
                    paddingRight -= measuredWidth;
                    i19 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    E(i21);
                    i20++;
                }
            }
        }
        if (childCount == 1 && i19 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i23 = (i18 / 2) - (measuredWidth2 / 2);
            int i24 = i17 - (measuredHeight2 / 2);
            childAt2.layout(i23, i24, measuredWidth2 + i23, measuredHeight2 + i24);
            return;
        }
        int i25 = i20 - (i19 ^ 1);
        if (i25 > 0) {
            i14 = paddingRight / i25;
        } else {
            i14 = 0;
        }
        int max = Math.max(0, i14);
        if (b10) {
            int width = getWidth() - getPaddingRight();
            for (int i26 = 0; i26 < childCount; i26++) {
                View childAt3 = getChildAt(i26);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f1001a) {
                    int i27 = width - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i28 = i17 - (measuredHeight3 / 2);
                    childAt3.layout(i27 - measuredWidth3, i28, i27, measuredHeight3 + i28);
                    width = i27 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i29 = 0; i29 < childCount; i29++) {
            View childAt4 = getChildAt(i29);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f1001a) {
                int i30 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i31 = i17 - (measuredHeight4 / 2);
                childAt4.layout(i30, i31, i30 + measuredWidth4, measuredHeight4 + i31);
                paddingLeft = i30 + measuredWidth4 + cVar3.rightMargin + max;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        boolean z10;
        g gVar;
        boolean z11 = this.D;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.D = z10;
        if (z11 != z10) {
            this.E = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (!(!this.D || (gVar = this.f996t) == null || size == this.E)) {
            this.E = size;
            gVar.K(true);
        }
        int childCount = getChildCount();
        if (!this.D || childCount <= 0) {
            for (int i12 = 0; i12 < childCount; i12++) {
                c cVar = (c) getChildAt(i12).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i10, i11);
            return;
        }
        K(i10, i11);
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f1000z.G(z10);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.H = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1000z.I(drawable);
    }

    public void setOverflowReserved(boolean z10) {
        this.f999y = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.f998x != i10) {
            this.f998x = i10;
            if (i10 == 0) {
                this.f997w = getContext();
            } else {
                this.f997w = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1000z = actionMenuPresenter;
        actionMenuPresenter.H(this);
    }

    public void z() {
        ActionMenuPresenter actionMenuPresenter = this.f1000z;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.y();
        }
    }

    public ActionMenuView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.F = (int) (56.0f * f10);
        this.G = (int) (f10 * 4.0f);
        this.f997w = context;
        this.f998x = 0;
    }
}
