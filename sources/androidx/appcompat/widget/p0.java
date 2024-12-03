package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.p;
import androidx.core.view.n0;
import androidx.core.widget.k;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.gms.common.api.a;
import d.j;
import java.lang.reflect.Method;

public class p0 implements p {
    private static Method N;
    private static Method O;
    private AdapterView.OnItemClickListener B;
    private AdapterView.OnItemSelectedListener C;
    final i D;
    private final h E;
    private final g F;
    private final e G;
    private Runnable H;
    final Handler I;
    private final Rect J;
    private Rect K;
    private boolean L;
    PopupWindow M;

    /* renamed from: a  reason: collision with root package name */
    private Context f1386a;

    /* renamed from: b  reason: collision with root package name */
    private ListAdapter f1387b;

    /* renamed from: c  reason: collision with root package name */
    m0 f1388c;

    /* renamed from: d  reason: collision with root package name */
    private int f1389d;

    /* renamed from: e  reason: collision with root package name */
    private int f1390e;

    /* renamed from: f  reason: collision with root package name */
    private int f1391f;

    /* renamed from: g  reason: collision with root package name */
    private int f1392g;

    /* renamed from: h  reason: collision with root package name */
    private int f1393h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1394j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1395k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1396l;

    /* renamed from: m  reason: collision with root package name */
    private int f1397m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1398n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1399p;

    /* renamed from: q  reason: collision with root package name */
    int f1400q;

    /* renamed from: t  reason: collision with root package name */
    private View f1401t;

    /* renamed from: w  reason: collision with root package name */
    private int f1402w;

    /* renamed from: x  reason: collision with root package name */
    private DataSetObserver f1403x;

    /* renamed from: y  reason: collision with root package name */
    private View f1404y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f1405z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            View t10 = p0.this.t();
            if (t10 != null && t10.getWindowToken() != null) {
                p0.this.a();
            }
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            m0 m0Var;
            if (i10 != -1 && (m0Var = p0.this.f1388c) != null) {
                m0Var.setListSelectionHidden(false);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    static class c {
        static int a(PopupWindow popupWindow, View view, int i10, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i10, z10);
        }
    }

    static class d {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    private class e implements Runnable {
        e() {
        }

        public void run() {
            p0.this.r();
        }
    }

    private class f extends DataSetObserver {
        f() {
        }

        public void onChanged() {
            if (p0.this.b()) {
                p0.this.a();
            }
        }

        public void onInvalidated() {
            p0.this.dismiss();
        }
    }

    private class g implements AbsListView.OnScrollListener {
        g() {
        }

        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 == 1 && !p0.this.A() && p0.this.M.getContentView() != null) {
                p0 p0Var = p0.this;
                p0Var.I.removeCallbacks(p0Var.D);
                p0.this.D.run();
            }
        }
    }

    private class h implements View.OnTouchListener {
        h() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = p0.this.M) != null && popupWindow.isShowing() && x10 >= 0 && x10 < p0.this.M.getWidth() && y10 >= 0 && y10 < p0.this.M.getHeight()) {
                p0 p0Var = p0.this;
                p0Var.I.postDelayed(p0Var.D, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                p0 p0Var2 = p0.this;
                p0Var2.I.removeCallbacks(p0Var2.D);
                return false;
            }
        }
    }

    private class i implements Runnable {
        i() {
        }

        public void run() {
            m0 m0Var = p0.this.f1388c;
            if (m0Var != null && n0.V(m0Var) && p0.this.f1388c.getCount() > p0.this.f1388c.getChildCount()) {
                int childCount = p0.this.f1388c.getChildCount();
                p0 p0Var = p0.this;
                if (childCount <= p0Var.f1400q) {
                    p0Var.M.setInputMethodMode(2);
                    p0.this.a();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                N = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
            }
            try {
                O = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
            }
        }
    }

    public p0(@NonNull Context context) {
        this(context, (AttributeSet) null, d.a.listPopupWindowStyle);
    }

    private void C() {
        View view = this.f1401t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1401t);
            }
        }
    }

    private void O(boolean z10) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = N;
            if (method != null) {
                try {
                    method.invoke(this.M, new Object[]{Boolean.valueOf(z10)});
                } catch (Exception unused) {
                }
            }
        } else {
            d.b(this.M, z10);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.m0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.m0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.m0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int q() {
        /*
            r12 = this;
            androidx.appcompat.widget.m0 r0 = r12.f1388c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00b5
            android.content.Context r0 = r12.f1386a
            androidx.appcompat.widget.p0$a r5 = new androidx.appcompat.widget.p0$a
            r5.<init>()
            r12.H = r5
            boolean r5 = r12.L
            r5 = r5 ^ r3
            androidx.appcompat.widget.m0 r5 = r12.s(r0, r5)
            r12.f1388c = r5
            android.graphics.drawable.Drawable r6 = r12.f1405z
            if (r6 == 0) goto L_0x0022
            r5.setSelector(r6)
        L_0x0022:
            androidx.appcompat.widget.m0 r5 = r12.f1388c
            android.widget.ListAdapter r6 = r12.f1387b
            r5.setAdapter(r6)
            androidx.appcompat.widget.m0 r5 = r12.f1388c
            android.widget.AdapterView$OnItemClickListener r6 = r12.B
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.m0 r5 = r12.f1388c
            r5.setFocusable(r3)
            androidx.appcompat.widget.m0 r5 = r12.f1388c
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.m0 r5 = r12.f1388c
            androidx.appcompat.widget.p0$b r6 = new androidx.appcompat.widget.p0$b
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.m0 r5 = r12.f1388c
            androidx.appcompat.widget.p0$g r6 = r12.F
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.C
            if (r5 == 0) goto L_0x0054
            androidx.appcompat.widget.m0 r6 = r12.f1388c
            r6.setOnItemSelectedListener(r5)
        L_0x0054:
            androidx.appcompat.widget.m0 r5 = r12.f1388c
            android.view.View r6 = r12.f1401t
            if (r6 == 0) goto L_0x00ae
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.f1402w
            if (r8 == 0) goto L_0x0086
            if (r8 == r3) goto L_0x007f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.f1402w
            r0.append(r5)
            goto L_0x008c
        L_0x007f:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x008c
        L_0x0086:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x008c:
            int r0 = r12.f1390e
            if (r0 < 0) goto L_0x0092
            r5 = r1
            goto L_0x0094
        L_0x0092:
            r0 = r4
            r5 = r0
        L_0x0094:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00af
        L_0x00ae:
            r0 = r4
        L_0x00af:
            android.widget.PopupWindow r6 = r12.M
            r6.setContentView(r5)
            goto L_0x00d3
        L_0x00b5:
            android.widget.PopupWindow r0 = r12.M
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.f1401t
            if (r0 == 0) goto L_0x00d2
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00d3
        L_0x00d2:
            r0 = r4
        L_0x00d3:
            android.widget.PopupWindow r5 = r12.M
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00ef
            android.graphics.Rect r6 = r12.J
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.J
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.f1394j
            if (r7 != 0) goto L_0x00f5
            int r6 = -r6
            r12.f1392g = r6
            goto L_0x00f5
        L_0x00ef:
            android.graphics.Rect r5 = r12.J
            r5.setEmpty()
            r5 = r4
        L_0x00f5:
            android.widget.PopupWindow r6 = r12.M
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x00ff
            goto L_0x0100
        L_0x00ff:
            r3 = r4
        L_0x0100:
            android.view.View r4 = r12.t()
            int r6 = r12.f1392g
            int r3 = r12.u(r4, r6, r3)
            boolean r4 = r12.f1398n
            if (r4 != 0) goto L_0x0171
            int r4 = r12.f1389d
            if (r4 != r2) goto L_0x0113
            goto L_0x0171
        L_0x0113:
            int r4 = r12.f1390e
            r6 = -2
            if (r4 == r6) goto L_0x013a
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x0121
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x0152
        L_0x0121:
            android.content.Context r2 = r12.f1386a
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.J
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x0152
        L_0x013a:
            android.content.Context r2 = r12.f1386a
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.J
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x0152:
            r7 = r1
            androidx.appcompat.widget.m0 r6 = r12.f1388c
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.d(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x016f
            androidx.appcompat.widget.m0 r2 = r12.f1388c
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.m0 r3 = r12.f1388c
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x016f:
            int r1 = r1 + r0
            return r1
        L_0x0171:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.p0.q():int");
    }

    private int u(View view, int i10, boolean z10) {
        return c.a(this.M, view, i10, z10);
    }

    public boolean A() {
        return this.M.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.L;
    }

    public void D(View view) {
        this.f1404y = view;
    }

    public void E(int i10) {
        this.M.setAnimationStyle(i10);
    }

    public void F(int i10) {
        Drawable background = this.M.getBackground();
        if (background != null) {
            background.getPadding(this.J);
            Rect rect = this.J;
            this.f1390e = rect.left + rect.right + i10;
            return;
        }
        R(i10);
    }

    public void G(int i10) {
        this.f1397m = i10;
    }

    public void H(Rect rect) {
        this.K = rect != null ? new Rect(rect) : null;
    }

    public void I(int i10) {
        this.M.setInputMethodMode(i10);
    }

    public void J(boolean z10) {
        this.L = z10;
        this.M.setFocusable(z10);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.M.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void M(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.C = onItemSelectedListener;
    }

    public void N(boolean z10) {
        this.f1396l = true;
        this.f1395k = z10;
    }

    public void P(int i10) {
        this.f1402w = i10;
    }

    public void Q(int i10) {
        m0 m0Var = this.f1388c;
        if (b() && m0Var != null) {
            m0Var.setListSelectionHidden(false);
            m0Var.setSelection(i10);
            if (m0Var.getChoiceMode() != 0) {
                m0Var.setItemChecked(i10, true);
            }
        }
    }

    public void R(int i10) {
        this.f1390e = i10;
    }

    public void a() {
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        int q10 = q();
        boolean A = A();
        k.b(this.M, this.f1393h);
        boolean z11 = true;
        if (!this.M.isShowing()) {
            int i14 = this.f1390e;
            if (i14 == -1) {
                i14 = -1;
            } else if (i14 == -2) {
                i14 = t().getWidth();
            }
            int i15 = this.f1389d;
            if (i15 == -1) {
                q10 = -1;
            } else if (i15 != -2) {
                q10 = i15;
            }
            this.M.setWidth(i14);
            this.M.setHeight(q10);
            O(true);
            PopupWindow popupWindow = this.M;
            if (this.f1399p || this.f1398n) {
                z10 = false;
            } else {
                z10 = true;
            }
            popupWindow.setOutsideTouchable(z10);
            this.M.setTouchInterceptor(this.E);
            if (this.f1396l) {
                k.a(this.M, this.f1395k);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = O;
                if (method != null) {
                    try {
                        method.invoke(this.M, new Object[]{this.K});
                    } catch (Exception unused) {
                    }
                }
            } else {
                d.a(this.M, this.K);
            }
            k.c(this.M, t(), this.f1391f, this.f1392g, this.f1397m);
            this.f1388c.setSelection(-1);
            if (!this.L || this.f1388c.isInTouchMode()) {
                r();
            }
            if (!this.L) {
                this.I.post(this.G);
            }
        } else if (n0.V(t())) {
            int i16 = this.f1390e;
            if (i16 == -1) {
                i16 = -1;
            } else if (i16 == -2) {
                i16 = t().getWidth();
            }
            int i17 = this.f1389d;
            if (i17 == -1) {
                if (!A) {
                    q10 = -1;
                }
                if (A) {
                    PopupWindow popupWindow2 = this.M;
                    if (this.f1390e == -1) {
                        i13 = -1;
                    } else {
                        i13 = 0;
                    }
                    popupWindow2.setWidth(i13);
                    this.M.setHeight(0);
                } else {
                    PopupWindow popupWindow3 = this.M;
                    if (this.f1390e == -1) {
                        i12 = -1;
                    } else {
                        i12 = 0;
                    }
                    popupWindow3.setWidth(i12);
                    this.M.setHeight(-1);
                }
            } else if (i17 != -2) {
                q10 = i17;
            }
            PopupWindow popupWindow4 = this.M;
            if (this.f1399p || this.f1398n) {
                z11 = false;
            }
            popupWindow4.setOutsideTouchable(z11);
            PopupWindow popupWindow5 = this.M;
            View t10 = t();
            int i18 = this.f1391f;
            int i19 = this.f1392g;
            if (i16 < 0) {
                i10 = -1;
            } else {
                i10 = i16;
            }
            if (q10 < 0) {
                i11 = -1;
            } else {
                i11 = q10;
            }
            popupWindow5.update(t10, i18, i19, i10, i11);
        }
    }

    public boolean b() {
        return this.M.isShowing();
    }

    public void c(Drawable drawable) {
        this.M.setBackgroundDrawable(drawable);
    }

    public int d() {
        return this.f1391f;
    }

    public void dismiss() {
        this.M.dismiss();
        C();
        this.M.setContentView((View) null);
        this.f1388c = null;
        this.I.removeCallbacks(this.D);
    }

    public void f(int i10) {
        this.f1391f = i10;
    }

    public Drawable h() {
        return this.M.getBackground();
    }

    public void j(int i10) {
        this.f1392g = i10;
        this.f1394j = true;
    }

    public int m() {
        if (!this.f1394j) {
            return 0;
        }
        return this.f1392g;
    }

    public void n(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1403x;
        if (dataSetObserver == null) {
            this.f1403x = new f();
        } else {
            ListAdapter listAdapter2 = this.f1387b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1387b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1403x);
        }
        m0 m0Var = this.f1388c;
        if (m0Var != null) {
            m0Var.setAdapter(this.f1387b);
        }
    }

    public ListView p() {
        return this.f1388c;
    }

    public void r() {
        m0 m0Var = this.f1388c;
        if (m0Var != null) {
            m0Var.setListSelectionHidden(true);
            m0Var.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public m0 s(Context context, boolean z10) {
        return new m0(context, z10);
    }

    public View t() {
        return this.f1404y;
    }

    public Object v() {
        if (!b()) {
            return null;
        }
        return this.f1388c.getSelectedItem();
    }

    public long w() {
        if (!b()) {
            return Long.MIN_VALUE;
        }
        return this.f1388c.getSelectedItemId();
    }

    public int x() {
        if (!b()) {
            return -1;
        }
        return this.f1388c.getSelectedItemPosition();
    }

    public View y() {
        if (!b()) {
            return null;
        }
        return this.f1388c.getSelectedView();
    }

    public int z() {
        return this.f1390e;
    }

    public p0(@NonNull Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public p0(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f1389d = -2;
        this.f1390e = -2;
        this.f1393h = CloseCodes.PROTOCOL_ERROR;
        this.f1397m = 0;
        this.f1398n = false;
        this.f1399p = false;
        this.f1400q = a.e.API_PRIORITY_OTHER;
        this.f1402w = 0;
        this.D = new i();
        this.E = new h();
        this.F = new g();
        this.G = new e();
        this.J = new Rect();
        this.f1386a = context;
        this.I = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, i10, i11);
        this.f1391f = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1392g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1394j = true;
        }
        obtainStyledAttributes.recycle();
        p pVar = new p(context, attributeSet, i10, i11);
        this.M = pVar;
        pVar.setInputMethodMode(1);
    }
}
