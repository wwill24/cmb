package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.a0;
import androidx.core.view.i;
import androidx.core.view.l;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import com.mparticle.kits.MPSideloadedKit;
import d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Toolbar extends ViewGroup implements i {
    private int B;
    private int C;
    private int D;
    private CharSequence E;
    private CharSequence F;
    private ColorStateList G;
    private ColorStateList H;
    private boolean I;
    private boolean J;
    private final ArrayList<View> K;
    private final ArrayList<View> L;
    private final int[] M;
    final l N;
    private ArrayList<MenuItem> O;
    h P;
    private final ActionMenuView.e Q;
    private l1 R;
    private ActionMenuPresenter S;
    private f T;
    private m.a U;
    g.a V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    ActionMenuView f1147a;

    /* renamed from: a0  reason: collision with root package name */
    private OnBackInvokedCallback f1148a0;

    /* renamed from: b  reason: collision with root package name */
    private TextView f1149b;

    /* renamed from: b0  reason: collision with root package name */
    private OnBackInvokedDispatcher f1150b0;

    /* renamed from: c  reason: collision with root package name */
    private TextView f1151c;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f1152c0;

    /* renamed from: d  reason: collision with root package name */
    private ImageButton f1153d;

    /* renamed from: d0  reason: collision with root package name */
    private final Runnable f1154d0;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f1155e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f1156f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f1157g;

    /* renamed from: h  reason: collision with root package name */
    ImageButton f1158h;

    /* renamed from: j  reason: collision with root package name */
    View f1159j;

    /* renamed from: k  reason: collision with root package name */
    private Context f1160k;

    /* renamed from: l  reason: collision with root package name */
    private int f1161l;

    /* renamed from: m  reason: collision with root package name */
    private int f1162m;

    /* renamed from: n  reason: collision with root package name */
    private int f1163n;

    /* renamed from: p  reason: collision with root package name */
    int f1164p;

    /* renamed from: q  reason: collision with root package name */
    private int f1165q;

    /* renamed from: t  reason: collision with root package name */
    private int f1166t;

    /* renamed from: w  reason: collision with root package name */
    private int f1167w;

    /* renamed from: x  reason: collision with root package name */
    private int f1168x;

    /* renamed from: y  reason: collision with root package name */
    private int f1169y;

    /* renamed from: z  reason: collision with root package name */
    private y0 f1170z;

    class a implements ActionMenuView.e {
        a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.N.j(menuItem)) {
                return true;
            }
            h hVar = Toolbar.this.P;
            if (hVar != null) {
                return hVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            Toolbar.this.R();
        }
    }

    class c implements g.a {
        c() {
        }

        public boolean a(@NonNull androidx.appcompat.view.menu.g gVar, @NonNull MenuItem menuItem) {
            g.a aVar = Toolbar.this.V;
            if (aVar == null || !aVar.a(gVar, menuItem)) {
                return false;
            }
            return true;
        }

        public void b(@NonNull androidx.appcompat.view.menu.g gVar) {
            if (!Toolbar.this.f1147a.H()) {
                Toolbar.this.N.k(gVar);
            }
            g.a aVar = Toolbar.this.V;
            if (aVar != null) {
                aVar.b(gVar);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    static class e {
        static OnBackInvokedDispatcher a(@NonNull View view) {
            return view.findOnBackInvokedDispatcher();
        }

        @NonNull
        static OnBackInvokedCallback b(@NonNull Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new k1(runnable);
        }

        static void c(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(MPSideloadedKit.MIN_SIDELOADED_KIT, (OnBackInvokedCallback) obj2);
        }

        static void d(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class f implements m {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.view.menu.g f1177a;

        /* renamed from: b  reason: collision with root package name */
        androidx.appcompat.view.menu.i f1178b;

        f() {
        }

        public void c(androidx.appcompat.view.menu.g gVar, boolean z10) {
        }

        public boolean d(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f1158h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1158h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1158h);
            }
            Toolbar.this.f1159j = iVar.getActionView();
            this.f1178b = iVar;
            ViewParent parent2 = Toolbar.this.f1159j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1159j);
                }
                g m10 = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                m10.f538a = 8388611 | (toolbar4.f1164p & 112);
                m10.f1180b = 2;
                toolbar4.f1159j.setLayoutParams(m10);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1159j);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            iVar.r(true);
            View view = Toolbar.this.f1159j;
            if (view instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) view).onActionViewExpanded();
            }
            Toolbar.this.S();
            return true;
        }

        public boolean f(r rVar) {
            return false;
        }

        public void g(boolean z10) {
            if (this.f1178b != null) {
                androidx.appcompat.view.menu.g gVar = this.f1177a;
                boolean z11 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            break;
                        } else if (this.f1177a.getItem(i10) == this.f1178b) {
                            z11 = true;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z11) {
                    i(this.f1177a, this.f1178b);
                }
            }
        }

        public boolean h() {
            return false;
        }

        public boolean i(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            View view = Toolbar.this.f1159j;
            if (view instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1159j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1158h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1159j = null;
            toolbar3.a();
            this.f1178b = null;
            Toolbar.this.requestLayout();
            iVar.r(false);
            Toolbar.this.S();
            return true;
        }

        public void j(Context context, androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.i iVar;
            androidx.appcompat.view.menu.g gVar2 = this.f1177a;
            if (!(gVar2 == null || (iVar = this.f1178b) == null)) {
                gVar2.f(iVar);
            }
            this.f1177a = gVar;
        }
    }

    public interface h {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.toolbarStyle);
    }

    private int C(View view, int i10, int[] iArr, int i11) {
        g gVar = (g) view.getLayoutParams();
        int i12 = gVar.leftMargin - iArr[0];
        int max = i10 + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        int q10 = q(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q10, max + measuredWidth, view.getMeasuredHeight() + q10);
        return max + measuredWidth + gVar.rightMargin;
    }

    private int D(View view, int i10, int[] iArr, int i11) {
        g gVar = (g) view.getLayoutParams();
        int i12 = gVar.rightMargin - iArr[1];
        int max = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int q10 = q(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q10, max, view.getMeasuredHeight() + q10);
        return max - (measuredWidth + gVar.leftMargin);
    }

    private int E(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i14) + Math.max(0, i15);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + max + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void F(View view, int i10, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i14 >= 0) {
            if (mode != 0) {
                i14 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i14);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void G() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.N.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.O = currentMenuItems2;
    }

    private void H() {
        removeCallbacks(this.f1154d0);
        post(this.f1154d0);
    }

    private boolean P() {
        if (!this.W) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (Q(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean Q(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i10) {
        boolean z10;
        if (n0.B(this) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int childCount = getChildCount();
        int b10 = androidx.core.view.e.b(i10, n0.B(this));
        list.clear();
        if (z10) {
            for (int i11 = childCount - 1; i11 >= 0; i11--) {
                View childAt = getChildAt(i11);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f1180b == 0 && Q(childAt) && p(gVar.f538a) == b10) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f1180b == 0 && Q(childAt2) && p(gVar2.f538a) == b10) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z10) {
        g gVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            gVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            gVar = generateLayoutParams(layoutParams);
        } else {
            gVar = (g) layoutParams;
        }
        gVar.f1180b = 1;
        if (!z10 || this.f1159j == null) {
            addView(view, gVar);
            return;
        }
        view.setLayoutParams(gVar);
        this.L.add(view);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    private void h() {
        if (this.f1170z == null) {
            this.f1170z = new y0();
        }
    }

    private void i() {
        if (this.f1155e == null) {
            this.f1155e = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.f1147a.L() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.f1147a.getMenu();
            if (this.T == null) {
                this.T = new f();
            }
            this.f1147a.setExpandedActionViewsExclusive(true);
            gVar.c(this.T, this.f1160k);
            S();
        }
    }

    private void k() {
        if (this.f1147a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1147a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1161l);
            this.f1147a.setOnMenuItemClickListener(this.Q);
            this.f1147a.M(this.U, new c());
            g m10 = generateDefaultLayoutParams();
            m10.f538a = 8388613 | (this.f1164p & 112);
            this.f1147a.setLayoutParams(m10);
            c(this.f1147a, false);
        }
    }

    private void l() {
        if (this.f1153d == null) {
            this.f1153d = new m(getContext(), (AttributeSet) null, d.a.toolbarNavigationButtonStyle);
            g m10 = generateDefaultLayoutParams();
            m10.f538a = 8388611 | (this.f1164p & 112);
            this.f1153d.setLayoutParams(m10);
        }
    }

    private int p(int i10) {
        int B2 = n0.B(this);
        int b10 = androidx.core.view.e.b(i10, B2) & 7;
        if (b10 == 1 || b10 == 3 || b10 == 5) {
            return b10;
        }
        if (B2 == 1) {
            return 5;
        }
        return 3;
    }

    private int q(View view, int i10) {
        int i11;
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i10 > 0) {
            i11 = (measuredHeight - i10) / 2;
        } else {
            i11 = 0;
        }
        int r10 = r(gVar.f538a);
        if (r10 == 48) {
            return getPaddingTop() - i11;
        }
        if (r10 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - gVar.bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i12 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i13 = gVar.topMargin;
        if (i12 < i13) {
            i12 = i13;
        } else {
            int i14 = (((height - paddingBottom) - measuredHeight) - i12) - paddingTop;
            int i15 = gVar.bottomMargin;
            if (i14 < i15) {
                i12 = Math.max(0, i12 - (i15 - i14));
            }
        }
        return paddingTop + i12;
    }

    private int r(int i10) {
        int i11 = i10 & 112;
        return (i11 == 16 || i11 == 48 || i11 == 80) ? i11 : this.D & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.view.h.b(marginLayoutParams) + androidx.core.view.h.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            View view = list.get(i12);
            g gVar = (g) view.getLayoutParams();
            int i14 = gVar.leftMargin - i10;
            int i15 = gVar.rightMargin - i11;
            int max = Math.max(0, i14);
            int max2 = Math.max(0, i15);
            int max3 = Math.max(0, -i14);
            int max4 = Math.max(0, -i15);
            i13 += max + view.getMeasuredWidth() + max2;
            i12++;
            i11 = max4;
            i10 = max3;
        }
        return i13;
    }

    private boolean z(View view) {
        return view.getParent() == this || this.L.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f1147a;
        return actionMenuView != null && actionMenuView.G();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f1147a;
        return actionMenuView != null && actionMenuView.H();
    }

    /* access modifiers changed from: package-private */
    public void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((g) childAt.getLayoutParams()).f1180b == 2 || childAt == this.f1147a)) {
                removeViewAt(childCount);
                this.L.add(childAt);
            }
        }
    }

    public void J(int i10, int i11) {
        h();
        this.f1170z.e(i10, i11);
    }

    public void K(int i10, int i11) {
        h();
        this.f1170z.g(i10, i11);
    }

    public void L(androidx.appcompat.view.menu.g gVar, ActionMenuPresenter actionMenuPresenter) {
        if (gVar != null || this.f1147a != null) {
            k();
            androidx.appcompat.view.menu.g L2 = this.f1147a.L();
            if (L2 != gVar) {
                if (L2 != null) {
                    L2.O(this.S);
                    L2.O(this.T);
                }
                if (this.T == null) {
                    this.T = new f();
                }
                actionMenuPresenter.G(true);
                if (gVar != null) {
                    gVar.c(actionMenuPresenter, this.f1160k);
                    gVar.c(this.T, this.f1160k);
                } else {
                    actionMenuPresenter.j(this.f1160k, (androidx.appcompat.view.menu.g) null);
                    this.T.j(this.f1160k, (androidx.appcompat.view.menu.g) null);
                    actionMenuPresenter.g(true);
                    this.T.g(true);
                }
                this.f1147a.setPopupTheme(this.f1161l);
                this.f1147a.setPresenter(actionMenuPresenter);
                this.S = actionMenuPresenter;
                S();
            }
        }
    }

    public void M(m.a aVar, g.a aVar2) {
        this.U = aVar;
        this.V = aVar2;
        ActionMenuView actionMenuView = this.f1147a;
        if (actionMenuView != null) {
            actionMenuView.M(aVar, aVar2);
        }
    }

    public void N(Context context, int i10) {
        this.f1163n = i10;
        TextView textView = this.f1151c;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public void O(Context context, int i10) {
        this.f1162m = i10;
        TextView textView = this.f1149b;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public boolean R() {
        ActionMenuView actionMenuView = this.f1147a;
        return actionMenuView != null && actionMenuView.N();
    }

    /* access modifiers changed from: package-private */
    public void S() {
        boolean z10;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a10 = e.a(this);
            if (!v() || a10 == null || !n0.V(this) || !this.f1152c0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && this.f1150b0 == null) {
                if (this.f1148a0 == null) {
                    this.f1148a0 = e.b(new j1(this));
                }
                e.c(a10, this.f1148a0);
                this.f1150b0 = a10;
            } else if (!z10 && (onBackInvokedDispatcher = this.f1150b0) != null) {
                e.d(onBackInvokedDispatcher, this.f1148a0);
                this.f1150b0 = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (int size = this.L.size() - 1; size >= 0; size--) {
            addView(this.L.get(size));
        }
        this.L.clear();
    }

    public void addMenuProvider(@NonNull a0 a0Var) {
        this.N.c(a0Var);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f1147a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.f1147a
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.I()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.d():boolean");
    }

    public void e() {
        androidx.appcompat.view.menu.i iVar;
        f fVar = this.T;
        if (fVar == null) {
            iVar = null;
        } else {
            iVar = fVar.f1178b;
        }
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f1147a;
        if (actionMenuView != null) {
            actionMenuView.z();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f1158h == null) {
            m mVar = new m(getContext(), (AttributeSet) null, d.a.toolbarNavigationButtonStyle);
            this.f1158h = mVar;
            mVar.setImageDrawable(this.f1156f);
            this.f1158h.setContentDescription(this.f1157g);
            g m10 = generateDefaultLayoutParams();
            m10.f538a = 8388611 | (this.f1164p & 112);
            m10.f1180b = 2;
            this.f1158h.setLayoutParams(m10);
            this.f1158h.setOnClickListener(new d());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1158h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1158h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        y0 y0Var = this.f1170z;
        if (y0Var != null) {
            return y0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.C;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        y0 y0Var = this.f1170z;
        if (y0Var != null) {
            return y0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        y0 y0Var = this.f1170z;
        if (y0Var != null) {
            return y0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        y0 y0Var = this.f1170z;
        if (y0Var != null) {
            return y0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.B;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean z10;
        androidx.appcompat.view.menu.g L2;
        ActionMenuView actionMenuView = this.f1147a;
        if (actionMenuView == null || (L2 = actionMenuView.L()) == null || !L2.hasVisibleItems()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return Math.max(getContentInsetEnd(), Math.max(this.C, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (n0.B(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (n0.B(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.B, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1155e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1155e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f1147a.getMenu();
    }

    /* access modifiers changed from: package-private */
    public View getNavButtonView() {
        return this.f1153d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1153d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1153d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.S;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f1147a.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.f1160k;
    }

    public int getPopupTheme() {
        return this.f1161l;
    }

    public CharSequence getSubtitle() {
        return this.F;
    }

    /* access modifiers changed from: package-private */
    public final TextView getSubtitleTextView() {
        return this.f1151c;
    }

    public CharSequence getTitle() {
        return this.E;
    }

    public int getTitleMarginBottom() {
        return this.f1169y;
    }

    public int getTitleMarginEnd() {
        return this.f1167w;
    }

    public int getTitleMarginStart() {
        return this.f1166t;
    }

    public int getTitleMarginTop() {
        return this.f1168x;
    }

    /* access modifiers changed from: package-private */
    public final TextView getTitleTextView() {
        return this.f1149b;
    }

    public j0 getWrapper() {
        if (this.R == null) {
            this.R = new l1(this, true);
        }
        return this.R;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    /* renamed from: n */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof g) {
            return new g((g) layoutParams);
        }
        if (layoutParams instanceof a.C0012a) {
            return new g((a.C0012a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new g((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new g(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        S();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1154d0);
        S();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.J = false;
        }
        if (!this.J) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.J = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.J = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x029f A[LOOP:0: B:101:0x029d->B:102:0x029f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c1 A[LOOP:1: B:104:0x02bf->B:105:0x02c1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02fa A[LOOP:2: B:112:0x02f8->B:113:0x02fa, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = androidx.core.view.n0.B(r19)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = r2
            goto L_0x000d
        L_0x000c:
            r1 = r3
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.M
            r11[r2] = r3
            r11[r3] = r3
            int r12 = androidx.core.view.n0.C(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = r3
        L_0x003b:
            android.widget.ImageButton r13 = r0.f1153d
            boolean r13 = r0.Q(r13)
            if (r13 == 0) goto L_0x0055
            if (r1 == 0) goto L_0x004e
            android.widget.ImageButton r13 = r0.f1153d
            int r13 = r0.D(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0057
        L_0x004e:
            android.widget.ImageButton r13 = r0.f1153d
            int r13 = r0.C(r13, r6, r11, r12)
            goto L_0x0056
        L_0x0055:
            r13 = r6
        L_0x0056:
            r14 = r10
        L_0x0057:
            android.widget.ImageButton r15 = r0.f1158h
            boolean r15 = r0.Q(r15)
            if (r15 == 0) goto L_0x006e
            if (r1 == 0) goto L_0x0068
            android.widget.ImageButton r15 = r0.f1158h
            int r14 = r0.D(r15, r14, r11, r12)
            goto L_0x006e
        L_0x0068:
            android.widget.ImageButton r15 = r0.f1158h
            int r13 = r0.C(r15, r13, r11, r12)
        L_0x006e:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1147a
            boolean r15 = r0.Q(r15)
            if (r15 == 0) goto L_0x0085
            if (r1 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1147a
            int r13 = r0.C(r15, r13, r11, r12)
            goto L_0x0085
        L_0x007f:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1147a
            int r14 = r0.D(r15, r14, r11, r12)
        L_0x0085:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r2 = r15 - r13
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r14
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.f1159j
            boolean r13 = r0.Q(r13)
            if (r13 == 0) goto L_0x00c2
            if (r1 == 0) goto L_0x00bc
            android.view.View r13 = r0.f1159j
            int r10 = r0.D(r13, r10, r11, r12)
            goto L_0x00c2
        L_0x00bc:
            android.view.View r13 = r0.f1159j
            int r2 = r0.C(r13, r2, r11, r12)
        L_0x00c2:
            android.widget.ImageView r13 = r0.f1155e
            boolean r13 = r0.Q(r13)
            if (r13 == 0) goto L_0x00d9
            if (r1 == 0) goto L_0x00d3
            android.widget.ImageView r13 = r0.f1155e
            int r10 = r0.D(r13, r10, r11, r12)
            goto L_0x00d9
        L_0x00d3:
            android.widget.ImageView r13 = r0.f1155e
            int r2 = r0.C(r13, r2, r11, r12)
        L_0x00d9:
            android.widget.TextView r13 = r0.f1149b
            boolean r13 = r0.Q(r13)
            android.widget.TextView r14 = r0.f1151c
            boolean r14 = r0.Q(r14)
            if (r13 == 0) goto L_0x0100
            android.widget.TextView r15 = r0.f1149b
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$g r15 = (androidx.appcompat.widget.Toolbar.g) r15
            int r3 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.f1149b
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r7 = r15.bottomMargin
            int r3 = r3 + r7
            r7 = 0
            int r3 = r3 + r7
            goto L_0x0103
        L_0x0100:
            r23 = r7
            r3 = 0
        L_0x0103:
            if (r14 == 0) goto L_0x011d
            android.widget.TextView r7 = r0.f1151c
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$g r7 = (androidx.appcompat.widget.Toolbar.g) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.f1151c
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r3 = r3 + r15
            goto L_0x011f
        L_0x011d:
            r16 = r4
        L_0x011f:
            if (r13 != 0) goto L_0x012b
            if (r14 == 0) goto L_0x0124
            goto L_0x012b
        L_0x0124:
            r18 = r6
            r22 = r12
        L_0x0128:
            r1 = 0
            goto L_0x0290
        L_0x012b:
            if (r13 == 0) goto L_0x0130
            android.widget.TextView r4 = r0.f1149b
            goto L_0x0132
        L_0x0130:
            android.widget.TextView r4 = r0.f1151c
        L_0x0132:
            if (r14 == 0) goto L_0x0137
            android.widget.TextView r7 = r0.f1151c
            goto L_0x0139
        L_0x0137:
            android.widget.TextView r7 = r0.f1149b
        L_0x0139:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$g r4 = (androidx.appcompat.widget.Toolbar.g) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$g r7 = (androidx.appcompat.widget.Toolbar.g) r7
            if (r13 == 0) goto L_0x014f
            android.widget.TextView r15 = r0.f1149b
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x0159
        L_0x014f:
            if (r14 == 0) goto L_0x015c
            android.widget.TextView r15 = r0.f1151c
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x015c
        L_0x0159:
            r17 = 1
            goto L_0x015e
        L_0x015c:
            r17 = 0
        L_0x015e:
            int r15 = r0.D
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x01a6
            r6 = 80
            if (r15 == r6) goto L_0x0198
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r3
            int r6 = r6 / 2
            int r15 = r4.topMargin
            r22 = r12
            int r12 = r0.f1168x
            r24 = r2
            int r2 = r15 + r12
            if (r6 >= r2) goto L_0x0181
            int r6 = r15 + r12
            goto L_0x0196
        L_0x0181:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.f1169y
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x0196
            int r2 = r7.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x0196:
            int r8 = r8 + r6
            goto L_0x01b5
        L_0x0198:
            r24 = r2
            r22 = r12
            int r5 = r5 - r9
            int r2 = r7.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.f1169y
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01b5
        L_0x01a6:
            r24 = r2
            r22 = r12
            int r2 = r19.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.f1168x
            int r8 = r2 + r3
        L_0x01b5:
            if (r1 == 0) goto L_0x0227
            if (r17 == 0) goto L_0x01bc
            int r1 = r0.f1166t
            goto L_0x01bd
        L_0x01bc:
            r1 = 0
        L_0x01bd:
            r2 = 1
            r3 = r11[r2]
            int r1 = r1 - r3
            r3 = 0
            int r4 = java.lang.Math.max(r3, r1)
            int r10 = r10 - r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r2] = r1
            if (r13 == 0) goto L_0x01f4
            android.widget.TextView r1 = r0.f1149b
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$g r1 = (androidx.appcompat.widget.Toolbar.g) r1
            android.widget.TextView r2 = r0.f1149b
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.f1149b
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f1149b
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.f1167w
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01f5
        L_0x01f4:
            r2 = r10
        L_0x01f5:
            if (r14 == 0) goto L_0x021b
            android.widget.TextView r1 = r0.f1151c
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$g r1 = (androidx.appcompat.widget.Toolbar.g) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            android.widget.TextView r1 = r0.f1151c
            int r1 = r1.getMeasuredWidth()
            int r1 = r10 - r1
            android.widget.TextView r3 = r0.f1151c
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f1151c
            r4.layout(r1, r8, r10, r3)
            int r1 = r0.f1167w
            int r1 = r10 - r1
            goto L_0x021c
        L_0x021b:
            r1 = r10
        L_0x021c:
            if (r17 == 0) goto L_0x0223
            int r1 = java.lang.Math.min(r2, r1)
            r10 = r1
        L_0x0223:
            r2 = r24
            goto L_0x0128
        L_0x0227:
            if (r17 == 0) goto L_0x022d
            int r7 = r0.f1166t
            r1 = 0
            goto L_0x022f
        L_0x022d:
            r1 = 0
            r7 = 0
        L_0x022f:
            r2 = r11[r1]
            int r7 = r7 - r2
            int r2 = java.lang.Math.max(r1, r7)
            int r2 = r24 + r2
            int r3 = -r7
            int r3 = java.lang.Math.max(r1, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x0264
            android.widget.TextView r3 = r0.f1149b
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$g r3 = (androidx.appcompat.widget.Toolbar.g) r3
            android.widget.TextView r4 = r0.f1149b
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r2
            android.widget.TextView r5 = r0.f1149b
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f1149b
            r6.layout(r2, r8, r4, r5)
            int r6 = r0.f1167w
            int r4 = r4 + r6
            int r3 = r3.bottomMargin
            int r8 = r5 + r3
            goto L_0x0265
        L_0x0264:
            r4 = r2
        L_0x0265:
            if (r14 == 0) goto L_0x0289
            android.widget.TextView r3 = r0.f1151c
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$g r3 = (androidx.appcompat.widget.Toolbar.g) r3
            int r3 = r3.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.f1151c
            int r3 = r3.getMeasuredWidth()
            int r3 = r3 + r2
            android.widget.TextView r5 = r0.f1151c
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f1151c
            r6.layout(r2, r8, r3, r5)
            int r5 = r0.f1167w
            int r3 = r3 + r5
            goto L_0x028a
        L_0x0289:
            r3 = r2
        L_0x028a:
            if (r17 == 0) goto L_0x0290
            int r2 = java.lang.Math.max(r4, r3)
        L_0x0290:
            java.util.ArrayList<android.view.View> r3 = r0.K
            r4 = 3
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.K
            int r3 = r3.size()
            r7 = r1
        L_0x029d:
            if (r7 >= r3) goto L_0x02b0
            java.util.ArrayList<android.view.View> r4 = r0.K
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r2 = r0.C(r4, r2, r11, r12)
            int r7 = r7 + 1
            goto L_0x029d
        L_0x02b0:
            r12 = r22
            java.util.ArrayList<android.view.View> r3 = r0.K
            r4 = 5
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.K
            int r3 = r3.size()
            r7 = r1
        L_0x02bf:
            if (r7 >= r3) goto L_0x02d0
            java.util.ArrayList<android.view.View> r4 = r0.K
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.D(r4, r10, r11, r12)
            int r7 = r7 + 1
            goto L_0x02bf
        L_0x02d0:
            java.util.ArrayList<android.view.View> r3 = r0.K
            r4 = 1
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.K
            int r3 = r0.u(r3, r11)
            int r4 = r16 - r18
            int r4 = r4 - r23
            int r4 = r4 / 2
            int r6 = r18 + r4
            int r4 = r3 / 2
            int r6 = r6 - r4
            int r3 = r3 + r6
            if (r6 >= r2) goto L_0x02eb
            goto L_0x02f2
        L_0x02eb:
            if (r3 <= r10) goto L_0x02f1
            int r3 = r3 - r10
            int r2 = r6 - r3
            goto L_0x02f2
        L_0x02f1:
            r2 = r6
        L_0x02f2:
            java.util.ArrayList<android.view.View> r3 = r0.K
            int r3 = r3.size()
        L_0x02f8:
            if (r1 >= r3) goto L_0x0309
            java.util.ArrayList<android.view.View> r4 = r0.K
            java.lang.Object r4 = r4.get(r1)
            android.view.View r4 = (android.view.View) r4
            int r2 = r0.C(r4, r2, r11, r12)
            int r1 = r1 + 1
            goto L_0x02f8
        L_0x0309:
            java.util.ArrayList<android.view.View> r1 = r0.K
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int[] iArr = this.M;
        char b10 = t1.b(this);
        int i19 = 0;
        char c10 = b10 ^ 1;
        if (Q(this.f1153d)) {
            F(this.f1153d, i10, 0, i11, 0, this.f1165q);
            i14 = this.f1153d.getMeasuredWidth() + s(this.f1153d);
            i13 = Math.max(0, this.f1153d.getMeasuredHeight() + t(this.f1153d));
            i12 = View.combineMeasuredStates(0, this.f1153d.getMeasuredState());
        } else {
            i14 = 0;
            i13 = 0;
            i12 = 0;
        }
        if (Q(this.f1158h)) {
            F(this.f1158h, i10, 0, i11, 0, this.f1165q);
            i14 = this.f1158h.getMeasuredWidth() + s(this.f1158h);
            i13 = Math.max(i13, this.f1158h.getMeasuredHeight() + t(this.f1158h));
            i12 = View.combineMeasuredStates(i12, this.f1158h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i14);
        iArr[b10] = Math.max(0, currentContentInsetStart - i14);
        if (Q(this.f1147a)) {
            F(this.f1147a, i10, max, i11, 0, this.f1165q);
            i15 = this.f1147a.getMeasuredWidth() + s(this.f1147a);
            i13 = Math.max(i13, this.f1147a.getMeasuredHeight() + t(this.f1147a));
            i12 = View.combineMeasuredStates(i12, this.f1147a.getMeasuredState());
        } else {
            i15 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i15);
        iArr[c10] = Math.max(0, currentContentInsetEnd - i15);
        if (Q(this.f1159j)) {
            max2 += E(this.f1159j, i10, max2, i11, 0, iArr);
            i13 = Math.max(i13, this.f1159j.getMeasuredHeight() + t(this.f1159j));
            i12 = View.combineMeasuredStates(i12, this.f1159j.getMeasuredState());
        }
        if (Q(this.f1155e)) {
            max2 += E(this.f1155e, i10, max2, i11, 0, iArr);
            i13 = Math.max(i13, this.f1155e.getMeasuredHeight() + t(this.f1155e));
            i12 = View.combineMeasuredStates(i12, this.f1155e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (((g) childAt.getLayoutParams()).f1180b == 0 && Q(childAt)) {
                max2 += E(childAt, i10, max2, i11, 0, iArr);
                i13 = Math.max(i13, childAt.getMeasuredHeight() + t(childAt));
                i12 = View.combineMeasuredStates(i12, childAt.getMeasuredState());
            }
        }
        int i21 = this.f1168x + this.f1169y;
        int i22 = this.f1166t + this.f1167w;
        if (Q(this.f1149b)) {
            E(this.f1149b, i10, max2 + i22, i11, i21, iArr);
            int measuredWidth = this.f1149b.getMeasuredWidth() + s(this.f1149b);
            i16 = this.f1149b.getMeasuredHeight() + t(this.f1149b);
            i18 = View.combineMeasuredStates(i12, this.f1149b.getMeasuredState());
            i17 = measuredWidth;
        } else {
            i16 = 0;
            i18 = i12;
            i17 = 0;
        }
        if (Q(this.f1151c)) {
            i17 = Math.max(i17, E(this.f1151c, i10, max2 + i22, i11, i16 + i21, iArr));
            i16 += this.f1151c.getMeasuredHeight() + t(this.f1151c);
            i18 = View.combineMeasuredStates(i18, this.f1151c.getMeasuredState());
        } else {
            int i23 = i18;
        }
        int max3 = Math.max(i13, i16);
        int paddingLeft = max2 + i17 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, -16777216 & i18);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, i18 << 16);
        if (!P()) {
            i19 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i19);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        androidx.appcompat.view.menu.g gVar;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f1147a;
        if (actionMenuView != null) {
            gVar = actionMenuView.L();
        } else {
            gVar = null;
        }
        int i10 = savedState.f1171c;
        if (!(i10 == 0 || this.T == null || gVar == null || (findItem = gVar.findItem(i10)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.f1172d) {
            H();
        }
    }

    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        h();
        y0 y0Var = this.f1170z;
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        y0Var.f(z10);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.i iVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.T;
        if (!(fVar == null || (iVar = fVar.f1178b) == null)) {
            savedState.f1171c = iVar.getItemId();
        }
        savedState.f1172d = B();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.I = false;
        }
        if (!this.I) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.I = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.I = false;
        }
        return true;
    }

    public void removeMenuProvider(@NonNull a0 a0Var) {
        this.N.l(a0Var);
    }

    public void setBackInvokedCallbackEnabled(boolean z10) {
        if (this.f1152c0 != z10) {
            this.f1152c0 = z10;
            S();
        }
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(e.a.b(getContext(), i10));
    }

    public void setCollapsible(boolean z10) {
        this.W = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.C) {
            this.C = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.B) {
            this.B = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i10) {
        setLogo(e.a.b(getContext(), i10));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(e.a.b(getContext(), i10));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f1153d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
        this.P = hVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f1147a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f1161l != i10) {
            this.f1161l = i10;
            if (i10 == 0) {
                this.f1160k = getContext();
            } else {
                this.f1160k = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleMarginBottom(int i10) {
        this.f1169y = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.f1167w = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.f1166t = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.f1168x = i10;
        requestLayout();
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public boolean v() {
        f fVar = this.T;
        return (fVar == null || fVar.f1178b == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f1147a;
        return actionMenuView != null && actionMenuView.F();
    }

    public void x(int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    public void y() {
        Iterator<MenuItem> it = this.O.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(it.next().getItemId());
        }
        G();
    }

    public static class g extends a.C0012a {

        /* renamed from: b  reason: collision with root package name */
        int f1180b = 0;

        public g(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(int i10, int i11) {
            super(i10, i11);
            this.f538a = 8388627;
        }

        public g(g gVar) {
            super((a.C0012a) gVar);
            this.f1180b = gVar.f1180b;
        }

        public g(a.C0012a aVar) {
            super(aVar);
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            a(marginLayoutParams);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public Toolbar(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.D = 8388627;
        this.K = new ArrayList<>();
        this.L = new ArrayList<>();
        this.M = new int[2];
        this.N = new l(new i1(this));
        this.O = new ArrayList<>();
        this.Q = new a();
        this.f1154d0 = new b();
        Context context2 = getContext();
        int[] iArr = j.Toolbar;
        h1 v10 = h1.v(context2, attributeSet, iArr, i10, 0);
        n0.q0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        this.f1162m = v10.n(j.Toolbar_titleTextAppearance, 0);
        this.f1163n = v10.n(j.Toolbar_subtitleTextAppearance, 0);
        this.D = v10.l(j.Toolbar_android_gravity, this.D);
        this.f1164p = v10.l(j.Toolbar_buttonGravity, 48);
        int e10 = v10.e(j.Toolbar_titleMargin, 0);
        int i11 = j.Toolbar_titleMargins;
        e10 = v10.s(i11) ? v10.e(i11, e10) : e10;
        this.f1169y = e10;
        this.f1168x = e10;
        this.f1167w = e10;
        this.f1166t = e10;
        int e11 = v10.e(j.Toolbar_titleMarginStart, -1);
        if (e11 >= 0) {
            this.f1166t = e11;
        }
        int e12 = v10.e(j.Toolbar_titleMarginEnd, -1);
        if (e12 >= 0) {
            this.f1167w = e12;
        }
        int e13 = v10.e(j.Toolbar_titleMarginTop, -1);
        if (e13 >= 0) {
            this.f1168x = e13;
        }
        int e14 = v10.e(j.Toolbar_titleMarginBottom, -1);
        if (e14 >= 0) {
            this.f1169y = e14;
        }
        this.f1165q = v10.f(j.Toolbar_maxButtonHeight, -1);
        int e15 = v10.e(j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int e16 = v10.e(j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int f10 = v10.f(j.Toolbar_contentInsetLeft, 0);
        int f11 = v10.f(j.Toolbar_contentInsetRight, 0);
        h();
        this.f1170z.e(f10, f11);
        if (!(e15 == Integer.MIN_VALUE && e16 == Integer.MIN_VALUE)) {
            this.f1170z.g(e15, e16);
        }
        this.B = v10.e(j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.C = v10.e(j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1156f = v10.g(j.Toolbar_collapseIcon);
        this.f1157g = v10.p(j.Toolbar_collapseContentDescription);
        CharSequence p10 = v10.p(j.Toolbar_title);
        if (!TextUtils.isEmpty(p10)) {
            setTitle(p10);
        }
        CharSequence p11 = v10.p(j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(p11)) {
            setSubtitle(p11);
        }
        this.f1160k = getContext();
        setPopupTheme(v10.n(j.Toolbar_popupTheme, 0));
        Drawable g10 = v10.g(j.Toolbar_navigationIcon);
        if (g10 != null) {
            setNavigationIcon(g10);
        }
        CharSequence p12 = v10.p(j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(p12)) {
            setNavigationContentDescription(p12);
        }
        Drawable g11 = v10.g(j.Toolbar_logo);
        if (g11 != null) {
            setLogo(g11);
        }
        CharSequence p13 = v10.p(j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(p13)) {
            setLogoDescription(p13);
        }
        int i12 = j.Toolbar_titleTextColor;
        if (v10.s(i12)) {
            setTitleTextColor(v10.c(i12));
        }
        int i13 = j.Toolbar_subtitleTextColor;
        if (v10.s(i13)) {
            setSubtitleTextColor(v10.c(i13));
        }
        int i14 = j.Toolbar_menu;
        if (v10.s(i14)) {
            x(v10.n(i14, 0));
        }
        v10.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f1158h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f1158h.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f1158h;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f1156f);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f1155e)) {
                c(this.f1155e, true);
            }
        } else {
            ImageView imageView = this.f1155e;
            if (imageView != null && z(imageView)) {
                removeView(this.f1155e);
                this.L.remove(this.f1155e);
            }
        }
        ImageView imageView2 = this.f1155e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f1155e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f1153d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            n1.a(this.f1153d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.f1153d)) {
                c(this.f1153d, true);
            }
        } else {
            ImageButton imageButton = this.f1153d;
            if (imageButton != null && z(imageButton)) {
                removeView(this.f1153d);
                this.L.remove(this.f1153d);
            }
        }
        ImageButton imageButton2 = this.f1153d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1151c == null) {
                Context context = getContext();
                d0 d0Var = new d0(context);
                this.f1151c = d0Var;
                d0Var.setSingleLine();
                this.f1151c.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f1163n;
                if (i10 != 0) {
                    this.f1151c.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.H;
                if (colorStateList != null) {
                    this.f1151c.setTextColor(colorStateList);
                }
            }
            if (!z(this.f1151c)) {
                c(this.f1151c, true);
            }
        } else {
            TextView textView = this.f1151c;
            if (textView != null && z(textView)) {
                removeView(this.f1151c);
                this.L.remove(this.f1151c);
            }
        }
        TextView textView2 = this.f1151c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.F = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.H = colorStateList;
        TextView textView = this.f1151c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1149b == null) {
                Context context = getContext();
                d0 d0Var = new d0(context);
                this.f1149b = d0Var;
                d0Var.setSingleLine();
                this.f1149b.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f1162m;
                if (i10 != 0) {
                    this.f1149b.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.G;
                if (colorStateList != null) {
                    this.f1149b.setTextColor(colorStateList);
                }
            }
            if (!z(this.f1149b)) {
                c(this.f1149b, true);
            }
        } else {
            TextView textView = this.f1149b;
            if (textView != null && z(textView)) {
                removeView(this.f1149b);
                this.L.remove(this.f1149b);
            }
        }
        TextView textView2 = this.f1149b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.E = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.G = colorStateList;
        TextView textView = this.f1149b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f1171c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1172d;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            this.f1171c = parcel.readInt();
            this.f1172d = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f1171c);
            parcel.writeInt(this.f1172d ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
