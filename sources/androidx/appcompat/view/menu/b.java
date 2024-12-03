package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public abstract class b implements m {

    /* renamed from: a  reason: collision with root package name */
    protected Context f765a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f766b;

    /* renamed from: c  reason: collision with root package name */
    protected g f767c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f768d;

    /* renamed from: e  reason: collision with root package name */
    protected LayoutInflater f769e;

    /* renamed from: f  reason: collision with root package name */
    private m.a f770f;

    /* renamed from: g  reason: collision with root package name */
    private int f771g;

    /* renamed from: h  reason: collision with root package name */
    private int f772h;

    /* renamed from: j  reason: collision with root package name */
    protected n f773j;

    /* renamed from: k  reason: collision with root package name */
    private int f774k;

    public b(Context context, int i10, int i11) {
        this.f765a = context;
        this.f768d = LayoutInflater.from(context);
        this.f771g = i10;
        this.f772h = i11;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f773j).addView(view, i10);
    }

    public abstract void b(i iVar, n.a aVar);

    public void c(g gVar, boolean z10) {
        m.a aVar = this.f770f;
        if (aVar != null) {
            aVar.c(gVar, z10);
        }
    }

    public boolean d(g gVar, i iVar) {
        return false;
    }

    public void e(m.a aVar) {
        this.f770f = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(androidx.appcompat.view.menu.r r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.m$a r0 = r1.f770f
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.g r2 = r1.f767c
        L_0x0009:
            boolean r2 = r0.d(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.b.f(androidx.appcompat.view.menu.r):boolean");
    }

    public void g(boolean z10) {
        i iVar;
        ViewGroup viewGroup = (ViewGroup) this.f773j;
        if (viewGroup != null) {
            g gVar = this.f767c;
            int i10 = 0;
            if (gVar != null) {
                gVar.r();
                ArrayList<i> E = this.f767c.E();
                int size = E.size();
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    i iVar2 = E.get(i12);
                    if (q(i11, iVar2)) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (childAt instanceof n.a) {
                            iVar = ((n.a) childAt).getItemData();
                        } else {
                            iVar = null;
                        }
                        View n10 = n(iVar2, childAt, viewGroup);
                        if (iVar2 != iVar) {
                            n10.setPressed(false);
                            n10.jumpDrawablesToCurrentState();
                        }
                        if (n10 != childAt) {
                            a(n10, i11);
                        }
                        i11++;
                    }
                }
                i10 = i11;
            }
            while (i10 < viewGroup.getChildCount()) {
                if (!l(viewGroup, i10)) {
                    i10++;
                }
            }
        }
    }

    public boolean i(g gVar, i iVar) {
        return false;
    }

    public void j(Context context, g gVar) {
        this.f766b = context;
        this.f769e = LayoutInflater.from(context);
        this.f767c = gVar;
    }

    public n.a k(ViewGroup viewGroup) {
        return (n.a) this.f768d.inflate(this.f772h, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public boolean l(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public m.a m() {
        return this.f770f;
    }

    public View n(i iVar, View view, ViewGroup viewGroup) {
        n.a aVar;
        if (view instanceof n.a) {
            aVar = (n.a) view;
        } else {
            aVar = k(viewGroup);
        }
        b(iVar, aVar);
        return (View) aVar;
    }

    public n o(ViewGroup viewGroup) {
        if (this.f773j == null) {
            n nVar = (n) this.f768d.inflate(this.f771g, viewGroup, false);
            this.f773j = nVar;
            nVar.a(this.f767c);
            g(true);
        }
        return this.f773j;
    }

    public void p(int i10) {
        this.f774k = i10;
    }

    public abstract boolean q(int i10, i iVar);
}
