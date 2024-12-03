package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import u0.c;

class s extends o implements SubMenu {

    /* renamed from: e  reason: collision with root package name */
    private final c f928e;

    s(Context context, c cVar) {
        super(context, cVar);
        this.f928e = cVar;
    }

    public void clearHeader() {
        this.f928e.clearHeader();
    }

    public MenuItem getItem() {
        return c(this.f928e.getItem());
    }

    public SubMenu setHeaderIcon(int i10) {
        this.f928e.setHeaderIcon(i10);
        return this;
    }

    public SubMenu setHeaderTitle(int i10) {
        this.f928e.setHeaderTitle(i10);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f928e.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i10) {
        this.f928e.setIcon(i10);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f928e.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f928e.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f928e.setIcon(drawable);
        return this;
    }
}
