package androidx.appcompat.widget;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.l;

public class v0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1456a;

    /* renamed from: b  reason: collision with root package name */
    private final g f1457b;

    /* renamed from: c  reason: collision with root package name */
    private final View f1458c;

    /* renamed from: d  reason: collision with root package name */
    final l f1459d;

    /* renamed from: e  reason: collision with root package name */
    d f1460e;

    /* renamed from: f  reason: collision with root package name */
    c f1461f;

    class a implements g.a {
        a() {
        }

        public boolean a(@NonNull g gVar, @NonNull MenuItem menuItem) {
            d dVar = v0.this.f1460e;
            if (dVar != null) {
                return dVar.onMenuItemClick(menuItem);
            }
            return false;
        }

        public void b(@NonNull g gVar) {
        }
    }

    class b implements PopupWindow.OnDismissListener {
        b() {
        }

        public void onDismiss() {
            v0 v0Var = v0.this;
            c cVar = v0Var.f1461f;
            if (cVar != null) {
                cVar.a(v0Var);
            }
        }
    }

    public interface c {
        void a(v0 v0Var);
    }

    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public v0(@NonNull Context context, @NonNull View view) {
        this(context, view, 0);
    }

    @NonNull
    public MenuInflater a() {
        return new androidx.appcompat.view.g(this.f1456a);
    }

    public void b(int i10) {
        a().inflate(i10, this.f1457b);
    }

    public void c(d dVar) {
        this.f1460e = dVar;
    }

    public void d() {
        this.f1459d.k();
    }

    public v0(@NonNull Context context, @NonNull View view, int i10) {
        this(context, view, i10, d.a.popupMenuStyle, 0);
    }

    public v0(@NonNull Context context, @NonNull View view, int i10, int i11, int i12) {
        this.f1456a = context;
        this.f1458c = view;
        g gVar = new g(context);
        this.f1457b = gVar;
        gVar.R(new a());
        l lVar = new l(context, gVar, view, false, i11, i12);
        this.f1459d = lVar;
        lVar.h(i10);
        lVar.i(new b());
    }
}
