package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.m;
import androidx.core.view.e;
import androidx.core.view.n0;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final Context f893a;

    /* renamed from: b  reason: collision with root package name */
    private final g f894b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f895c;

    /* renamed from: d  reason: collision with root package name */
    private final int f896d;

    /* renamed from: e  reason: collision with root package name */
    private final int f897e;

    /* renamed from: f  reason: collision with root package name */
    private View f898f;

    /* renamed from: g  reason: collision with root package name */
    private int f899g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f900h;

    /* renamed from: i  reason: collision with root package name */
    private m.a f901i;

    /* renamed from: j  reason: collision with root package name */
    private k f902j;

    /* renamed from: k  reason: collision with root package name */
    private PopupWindow.OnDismissListener f903k;

    /* renamed from: l  reason: collision with root package name */
    private final PopupWindow.OnDismissListener f904l;

    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        public void onDismiss() {
            l.this.e();
        }
    }

    static class b {
        static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public l(@NonNull Context context, @NonNull g gVar, @NonNull View view, boolean z10, int i10) {
        this(context, gVar, view, z10, i10, 0);
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.m, androidx.appcompat.view.menu.k] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.q] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.d] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.k a() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f893a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            androidx.appcompat.view.menu.l.b.a(r0, r1)
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f893a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = d.d.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x002e
            r0 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 == 0) goto L_0x0042
            androidx.appcompat.view.menu.d r0 = new androidx.appcompat.view.menu.d
            android.content.Context r2 = r14.f893a
            android.view.View r3 = r14.f898f
            int r4 = r14.f896d
            int r5 = r14.f897e
            boolean r6 = r14.f895c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0054
        L_0x0042:
            androidx.appcompat.view.menu.q r0 = new androidx.appcompat.view.menu.q
            android.content.Context r8 = r14.f893a
            androidx.appcompat.view.menu.g r9 = r14.f894b
            android.view.View r10 = r14.f898f
            int r11 = r14.f896d
            int r12 = r14.f897e
            boolean r13 = r14.f895c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x0054:
            androidx.appcompat.view.menu.g r1 = r14.f894b
            r0.k(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.f904l
            r0.u(r1)
            android.view.View r1 = r14.f898f
            r0.o(r1)
            androidx.appcompat.view.menu.m$a r1 = r14.f901i
            r0.e(r1)
            boolean r1 = r14.f900h
            r0.r(r1)
            int r1 = r14.f899g
            r0.s(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.l.a():androidx.appcompat.view.menu.k");
    }

    private void l(int i10, int i11, boolean z10, boolean z11) {
        k c10 = c();
        c10.v(z11);
        if (z10) {
            if ((e.b(this.f899g, n0.B(this.f898f)) & 7) == 5) {
                i10 -= this.f898f.getWidth();
            }
            c10.t(i10);
            c10.w(i11);
            int i12 = (int) ((this.f893a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c10.q(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        c10.a();
    }

    public void b() {
        if (d()) {
            this.f902j.dismiss();
        }
    }

    @NonNull
    public k c() {
        if (this.f902j == null) {
            this.f902j = a();
        }
        return this.f902j;
    }

    public boolean d() {
        k kVar = this.f902j;
        return kVar != null && kVar.b();
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.f902j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f903k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(@NonNull View view) {
        this.f898f = view;
    }

    public void g(boolean z10) {
        this.f900h = z10;
        k kVar = this.f902j;
        if (kVar != null) {
            kVar.r(z10);
        }
    }

    public void h(int i10) {
        this.f899g = i10;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f903k = onDismissListener;
    }

    public void j(m.a aVar) {
        this.f901i = aVar;
        k kVar = this.f902j;
        if (kVar != null) {
            kVar.e(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f898f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i10, int i11) {
        if (d()) {
            return true;
        }
        if (this.f898f == null) {
            return false;
        }
        l(i10, i11, true, true);
        return true;
    }

    public l(@NonNull Context context, @NonNull g gVar, @NonNull View view, boolean z10, int i10, int i11) {
        this.f899g = 8388611;
        this.f904l = new a();
        this.f893a = context;
        this.f894b = gVar;
        this.f898f = view;
        this.f895c = z10;
        this.f896d = i10;
        this.f897e = i11;
    }
}
