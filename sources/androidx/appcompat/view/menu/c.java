package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.g;
import u0.b;

abstract class c {

    /* renamed from: a  reason: collision with root package name */
    final Context f775a;

    /* renamed from: b  reason: collision with root package name */
    private g<b, MenuItem> f776b;

    /* renamed from: c  reason: collision with root package name */
    private g<u0.c, SubMenu> f777c;

    c(Context context) {
        this.f775a = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f776b == null) {
            this.f776b = new g<>();
        }
        MenuItem menuItem2 = this.f776b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f775a, bVar);
        this.f776b.put(bVar, jVar);
        return jVar;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof u0.c)) {
            return subMenu;
        }
        u0.c cVar = (u0.c) subMenu;
        if (this.f777c == null) {
            this.f777c = new g<>();
        }
        SubMenu subMenu2 = this.f777c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f775a, cVar);
        this.f777c.put(cVar, sVar);
        return sVar;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        g<b, MenuItem> gVar = this.f776b;
        if (gVar != null) {
            gVar.clear();
        }
        g<u0.c, SubMenu> gVar2 = this.f777c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(int i10) {
        if (this.f776b != null) {
            int i11 = 0;
            while (i11 < this.f776b.size()) {
                if (this.f776b.j(i11).getGroupId() == i10) {
                    this.f776b.l(i11);
                    i11--;
                }
                i11++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(int i10) {
        if (this.f776b != null) {
            for (int i11 = 0; i11 < this.f776b.size(); i11++) {
                if (this.f776b.j(i11).getItemId() == i10) {
                    this.f776b.l(i11);
                    return;
                }
            }
        }
    }
}
