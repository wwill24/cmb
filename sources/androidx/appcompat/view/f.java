package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.collection.g;
import java.util.ArrayList;

public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f662a;

    /* renamed from: b  reason: collision with root package name */
    final b f663b;

    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f664a;

        /* renamed from: b  reason: collision with root package name */
        final Context f665b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f666c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final g<Menu, Menu> f667d = new g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f665b = context;
            this.f664a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f667d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f665b, (u0.a) menu);
            this.f667d.put(menu, oVar);
            return oVar;
        }

        public void a(b bVar) {
            this.f664a.onDestroyActionMode(e(bVar));
        }

        public boolean b(b bVar, Menu menu) {
            return this.f664a.onCreateActionMode(e(bVar), f(menu));
        }

        public boolean c(b bVar, MenuItem menuItem) {
            return this.f664a.onActionItemClicked(e(bVar), new j(this.f665b, (u0.b) menuItem));
        }

        public boolean d(b bVar, Menu menu) {
            return this.f664a.onPrepareActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f666c.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = this.f666c.get(i10);
                if (fVar != null && fVar.f663b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f665b, bVar);
            this.f666c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f662a = context;
        this.f663b = bVar;
    }

    public void finish() {
        this.f663b.c();
    }

    public View getCustomView() {
        return this.f663b.d();
    }

    public Menu getMenu() {
        return new o(this.f662a, (u0.a) this.f663b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.f663b.f();
    }

    public CharSequence getSubtitle() {
        return this.f663b.g();
    }

    public Object getTag() {
        return this.f663b.h();
    }

    public CharSequence getTitle() {
        return this.f663b.i();
    }

    public boolean getTitleOptionalHint() {
        return this.f663b.j();
    }

    public void invalidate() {
        this.f663b.k();
    }

    public boolean isTitleOptional() {
        return this.f663b.l();
    }

    public void setCustomView(View view) {
        this.f663b.m(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f663b.o(charSequence);
    }

    public void setTag(Object obj) {
        this.f663b.p(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f663b.r(charSequence);
    }

    public void setTitleOptionalHint(boolean z10) {
        this.f663b.s(z10);
    }

    public void setSubtitle(int i10) {
        this.f663b.n(i10);
    }

    public void setTitle(int i10) {
        this.f663b.q(i10);
    }
}
