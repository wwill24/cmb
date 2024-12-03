package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.s0;
import androidx.appcompat.widget.t0;
import androidx.core.view.e;
import androidx.core.view.n0;
import d.g;
import java.util.ArrayList;
import java.util.List;

final class d extends k implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int I = g.abc_cascading_menu_item_layout;
    private int B;
    private boolean C;
    private boolean D;
    private m.a E;
    ViewTreeObserver F;
    private PopupWindow.OnDismissListener G;
    boolean H;

    /* renamed from: b  reason: collision with root package name */
    private final Context f778b;

    /* renamed from: c  reason: collision with root package name */
    private final int f779c;

    /* renamed from: d  reason: collision with root package name */
    private final int f780d;

    /* renamed from: e  reason: collision with root package name */
    private final int f781e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f782f;

    /* renamed from: g  reason: collision with root package name */
    final Handler f783g;

    /* renamed from: h  reason: collision with root package name */
    private final List<g> f784h = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    final List<C0013d> f785j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f786k = new a();

    /* renamed from: l  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f787l = new b();

    /* renamed from: m  reason: collision with root package name */
    private final s0 f788m = new c();

    /* renamed from: n  reason: collision with root package name */
    private int f789n = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f790p = 0;

    /* renamed from: q  reason: collision with root package name */
    private View f791q;

    /* renamed from: t  reason: collision with root package name */
    View f792t;

    /* renamed from: w  reason: collision with root package name */
    private int f793w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f794x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f795y;

    /* renamed from: z  reason: collision with root package name */
    private int f796z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (d.this.b() && d.this.f785j.size() > 0 && !d.this.f785j.get(0).f804a.B()) {
                View view = d.this.f792t;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                    return;
                }
                for (C0013d dVar : d.this.f785j) {
                    dVar.f804a.a();
                }
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.F;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.F = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.F.removeGlobalOnLayoutListener(dVar.f786k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements s0 {

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0013d f800a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MenuItem f801b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ g f802c;

            a(C0013d dVar, MenuItem menuItem, g gVar) {
                this.f800a = dVar;
                this.f801b = menuItem;
                this.f802c = gVar;
            }

            public void run() {
                C0013d dVar = this.f800a;
                if (dVar != null) {
                    d.this.H = true;
                    dVar.f805b.e(false);
                    d.this.H = false;
                }
                if (this.f801b.isEnabled() && this.f801b.hasSubMenu()) {
                    this.f802c.L(this.f801b, 4);
                }
            }
        }

        c() {
        }

        public void e(@NonNull g gVar, @NonNull MenuItem menuItem) {
            C0013d dVar = null;
            d.this.f783g.removeCallbacksAndMessages((Object) null);
            int size = d.this.f785j.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (gVar == d.this.f785j.get(i10).f805b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 != -1) {
                int i11 = i10 + 1;
                if (i11 < d.this.f785j.size()) {
                    dVar = d.this.f785j.get(i11);
                }
                d.this.f783g.postAtTime(new a(dVar, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
            }
        }

        public void o(@NonNull g gVar, @NonNull MenuItem menuItem) {
            d.this.f783g.removeCallbacksAndMessages(gVar);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.d$d  reason: collision with other inner class name */
    private static class C0013d {

        /* renamed from: a  reason: collision with root package name */
        public final t0 f804a;

        /* renamed from: b  reason: collision with root package name */
        public final g f805b;

        /* renamed from: c  reason: collision with root package name */
        public final int f806c;

        public C0013d(@NonNull t0 t0Var, @NonNull g gVar, int i10) {
            this.f804a = t0Var;
            this.f805b = gVar;
            this.f806c = i10;
        }

        public ListView a() {
            return this.f804a.p();
        }
    }

    public d(@NonNull Context context, @NonNull View view, int i10, int i11, boolean z10) {
        this.f778b = context;
        this.f791q = view;
        this.f780d = i10;
        this.f781e = i11;
        this.f782f = z10;
        this.C = false;
        this.f793w = D();
        Resources resources = context.getResources();
        this.f779c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.d.abc_config_prefDialogWidth));
        this.f783g = new Handler();
    }

    private int A(@NonNull g gVar) {
        int size = this.f785j.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (gVar == this.f785j.get(i10).f805b) {
                return i10;
            }
        }
        return -1;
    }

    private MenuItem B(@NonNull g gVar, @NonNull g gVar2) {
        int size = gVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = gVar.getItem(i10);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(@NonNull C0013d dVar, @NonNull g gVar) {
        int i10;
        f fVar;
        int firstVisiblePosition;
        MenuItem B2 = B(dVar.f805b, gVar);
        if (B2 == null) {
            return null;
        }
        ListView a10 = dVar.a();
        ListAdapter adapter = a10.getAdapter();
        int i11 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i10 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i10 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i11 >= count) {
                i11 = -1;
                break;
            } else if (B2 == fVar.getItem(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1 && (firstVisiblePosition = (i11 + i10) - a10.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a10.getChildCount()) {
            return a10.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return n0.B(this.f791q) == 1 ? 0 : 1;
    }

    private int E(int i10) {
        List<C0013d> list = this.f785j;
        ListView a10 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a10.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f792t.getWindowVisibleDisplayFrame(rect);
        if (this.f793w == 1) {
            if (iArr[0] + a10.getWidth() + i10 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i10 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private void F(@NonNull g gVar) {
        View view;
        C0013d dVar;
        boolean z10;
        int i10;
        int i11;
        int i12;
        LayoutInflater from = LayoutInflater.from(this.f778b);
        f fVar = new f(gVar, from, this.f782f, I);
        if (!b() && this.C) {
            fVar.d(true);
        } else if (b()) {
            fVar.d(k.x(gVar));
        }
        int n10 = k.n(fVar, (ViewGroup) null, this.f778b, this.f779c);
        t0 z11 = z();
        z11.n(fVar);
        z11.F(n10);
        z11.G(this.f790p);
        if (this.f785j.size() > 0) {
            List<C0013d> list = this.f785j;
            dVar = list.get(list.size() - 1);
            view = C(dVar, gVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            z11.V(false);
            z11.S((Object) null);
            int E2 = E(n10);
            if (E2 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f793w = E2;
            if (Build.VERSION.SDK_INT >= 26) {
                z11.D(view);
                i11 = 0;
                i10 = 0;
            } else {
                int[] iArr = new int[2];
                this.f791q.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f790p & 7) == 5) {
                    iArr[0] = iArr[0] + this.f791q.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i10 = iArr2[0] - iArr[0];
                i11 = iArr2[1] - iArr[1];
            }
            if ((this.f790p & 5) != 5) {
                if (z10) {
                    n10 = view.getWidth();
                }
                i12 = i10 - n10;
                z11.f(i12);
                z11.N(true);
                z11.j(i11);
            } else if (!z10) {
                n10 = view.getWidth();
                i12 = i10 - n10;
                z11.f(i12);
                z11.N(true);
                z11.j(i11);
            }
            i12 = i10 + n10;
            z11.f(i12);
            z11.N(true);
            z11.j(i11);
        } else {
            if (this.f794x) {
                z11.f(this.f796z);
            }
            if (this.f795y) {
                z11.j(this.B);
            }
            z11.H(m());
        }
        this.f785j.add(new C0013d(z11, gVar, this.f793w));
        z11.a();
        ListView p10 = z11.p();
        p10.setOnKeyListener(this);
        if (dVar == null && this.D && gVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.abc_popup_menu_header_item_layout, p10, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.x());
            p10.addHeaderView(frameLayout, (Object) null, false);
            z11.a();
        }
    }

    private t0 z() {
        t0 t0Var = new t0(this.f778b, (AttributeSet) null, this.f780d, this.f781e);
        t0Var.U(this.f788m);
        t0Var.L(this);
        t0Var.K(this);
        t0Var.D(this.f791q);
        t0Var.G(this.f790p);
        t0Var.J(true);
        t0Var.I(2);
        return t0Var;
    }

    public void a() {
        boolean z10;
        if (!b()) {
            for (g F2 : this.f784h) {
                F(F2);
            }
            this.f784h.clear();
            View view = this.f791q;
            this.f792t = view;
            if (view != null) {
                if (this.F == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.F = viewTreeObserver;
                if (z10) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f786k);
                }
                this.f792t.addOnAttachStateChangeListener(this.f787l);
            }
        }
    }

    public boolean b() {
        return this.f785j.size() > 0 && this.f785j.get(0).f804a.b();
    }

    public void c(g gVar, boolean z10) {
        int A = A(gVar);
        if (A >= 0) {
            int i10 = A + 1;
            if (i10 < this.f785j.size()) {
                this.f785j.get(i10).f805b.e(false);
            }
            C0013d remove = this.f785j.remove(A);
            remove.f805b.O(this);
            if (this.H) {
                remove.f804a.T((Object) null);
                remove.f804a.E(0);
            }
            remove.f804a.dismiss();
            int size = this.f785j.size();
            if (size > 0) {
                this.f793w = this.f785j.get(size - 1).f806c;
            } else {
                this.f793w = D();
            }
            if (size == 0) {
                dismiss();
                m.a aVar = this.E;
                if (aVar != null) {
                    aVar.c(gVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.F;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.F.removeGlobalOnLayoutListener(this.f786k);
                    }
                    this.F = null;
                }
                this.f792t.removeOnAttachStateChangeListener(this.f787l);
                this.G.onDismiss();
            } else if (z10) {
                this.f785j.get(0).f805b.e(false);
            }
        }
    }

    public void dismiss() {
        int size = this.f785j.size();
        if (size > 0) {
            C0013d[] dVarArr = (C0013d[]) this.f785j.toArray(new C0013d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                C0013d dVar = dVarArr[i10];
                if (dVar.f804a.b()) {
                    dVar.f804a.dismiss();
                }
            }
        }
    }

    public void e(m.a aVar) {
        this.E = aVar;
    }

    public boolean f(r rVar) {
        for (C0013d next : this.f785j) {
            if (rVar == next.f805b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        k(rVar);
        m.a aVar = this.E;
        if (aVar != null) {
            aVar.d(rVar);
        }
        return true;
    }

    public void g(boolean z10) {
        for (C0013d a10 : this.f785j) {
            k.y(a10.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean h() {
        return false;
    }

    public void k(g gVar) {
        gVar.c(this, this.f778b);
        if (b()) {
            F(gVar);
        } else {
            this.f784h.add(gVar);
        }
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return false;
    }

    public void o(@NonNull View view) {
        if (this.f791q != view) {
            this.f791q = view;
            this.f790p = e.b(this.f789n, n0.B(view));
        }
    }

    public void onDismiss() {
        C0013d dVar;
        int size = this.f785j.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f785j.get(i10);
            if (!dVar.f804a.b()) {
                break;
            }
            i10++;
        }
        if (dVar != null) {
            dVar.f805b.e(false);
        }
    }

    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public ListView p() {
        if (this.f785j.isEmpty()) {
            return null;
        }
        List<C0013d> list = this.f785j;
        return list.get(list.size() - 1).a();
    }

    public void r(boolean z10) {
        this.C = z10;
    }

    public void s(int i10) {
        if (this.f789n != i10) {
            this.f789n = i10;
            this.f790p = e.b(i10, n0.B(this.f791q));
        }
    }

    public void t(int i10) {
        this.f794x = true;
        this.f796z = i10;
    }

    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.G = onDismissListener;
    }

    public void v(boolean z10) {
        this.D = z10;
    }

    public void w(int i10) {
        this.f795y = true;
        this.B = i10;
    }
}
