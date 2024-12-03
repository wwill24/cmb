package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.b;
import java.lang.reflect.Method;

public class j extends c implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    private final u0.b f881d;

    /* renamed from: e  reason: collision with root package name */
    private Method f882e;

    private class a extends androidx.core.view.b {

        /* renamed from: d  reason: collision with root package name */
        final ActionProvider f883d;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f883d = actionProvider;
        }

        public boolean a() {
            return this.f883d.hasSubMenu();
        }

        public View c() {
            return this.f883d.onCreateActionView();
        }

        public boolean e() {
            return this.f883d.onPerformDefaultAction();
        }

        public void f(SubMenu subMenu) {
            this.f883d.onPrepareSubMenu(j.this.d(subMenu));
        }
    }

    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: f  reason: collision with root package name */
        private b.C0047b f885f;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean b() {
            return this.f883d.isVisible();
        }

        public View d(MenuItem menuItem) {
            return this.f883d.onCreateActionView(menuItem);
        }

        public boolean g() {
            return this.f883d.overridesItemVisibility();
        }

        public void j(b.C0047b bVar) {
            b bVar2;
            this.f885f = bVar;
            ActionProvider actionProvider = this.f883d;
            if (bVar != null) {
                bVar2 = this;
            } else {
                bVar2 = null;
            }
            actionProvider.setVisibilityListener(bVar2);
        }

        public void onActionProviderVisibilityChanged(boolean z10) {
            b.C0047b bVar = this.f885f;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z10);
            }
        }
    }

    static class c extends FrameLayout implements androidx.appcompat.view.c {

        /* renamed from: a  reason: collision with root package name */
        final CollapsibleActionView f887a;

        c(View view) {
            super(view.getContext());
            this.f887a = (CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: package-private */
        public View a() {
            return (View) this.f887a;
        }

        public void onActionViewCollapsed() {
            this.f887a.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.f887a.onActionViewExpanded();
        }
    }

    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f888a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f888a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f888a.onMenuItemActionCollapse(j.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f888a.onMenuItemActionExpand(j.this.c(menuItem));
        }
    }

    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f890a;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f890a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f890a.onMenuItemClick(j.this.c(menuItem));
        }
    }

    public j(Context context, u0.b bVar) {
        super(context);
        if (bVar != null) {
            this.f881d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f881d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f881d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        androidx.core.view.b a10 = this.f881d.a();
        if (a10 instanceof a) {
            return ((a) a10).f883d;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f881d.getActionView();
        if (actionView instanceof c) {
            return ((c) actionView).a();
        }
        return actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f881d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f881d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f881d.getContentDescription();
    }

    public int getGroupId() {
        return this.f881d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f881d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f881d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f881d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f881d.getIntent();
    }

    public int getItemId() {
        return this.f881d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f881d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f881d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f881d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f881d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.f881d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f881d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f881d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f881d.getTooltipText();
    }

    public void h(boolean z10) {
        try {
            if (this.f882e == null) {
                this.f882e = this.f881d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f882e.invoke(this.f881d, new Object[]{Boolean.valueOf(z10)});
        } catch (Exception unused) {
        }
    }

    public boolean hasSubMenu() {
        return this.f881d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f881d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f881d.isCheckable();
    }

    public boolean isChecked() {
        return this.f881d.isChecked();
    }

    public boolean isEnabled() {
        return this.f881d.isEnabled();
    }

    public boolean isVisible() {
        return this.f881d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.f775a, actionProvider);
        u0.b bVar2 = this.f881d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.b(bVar);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f881d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        this.f881d.setAlphabeticShortcut(c10);
        return this;
    }

    public MenuItem setCheckable(boolean z10) {
        this.f881d.setCheckable(z10);
        return this;
    }

    public MenuItem setChecked(boolean z10) {
        this.f881d.setChecked(z10);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f881d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z10) {
        this.f881d.setEnabled(z10);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f881d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f881d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f881d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f881d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        this.f881d.setNumericShortcut(c10);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        d dVar;
        u0.b bVar = this.f881d;
        if (onActionExpandListener != null) {
            dVar = new d(onActionExpandListener);
        } else {
            dVar = null;
        }
        bVar.setOnActionExpandListener(dVar);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        e eVar;
        u0.b bVar = this.f881d;
        if (onMenuItemClickListener != null) {
            eVar = new e(onMenuItemClickListener);
        } else {
            eVar = null;
        }
        bVar.setOnMenuItemClickListener(eVar);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.f881d.setShortcut(c10, c11);
        return this;
    }

    public void setShowAsAction(int i10) {
        this.f881d.setShowAsAction(i10);
    }

    public MenuItem setShowAsActionFlags(int i10) {
        this.f881d.setShowAsActionFlags(i10);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f881d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f881d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f881d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z10) {
        return this.f881d.setVisible(z10);
    }

    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f881d.setAlphabeticShortcut(c10, i10);
        return this;
    }

    public MenuItem setIcon(int i10) {
        this.f881d.setIcon(i10);
        return this;
    }

    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f881d.setNumericShortcut(c10, i10);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f881d.setShortcut(c10, c11, i10, i11);
        return this;
    }

    public MenuItem setTitle(int i10) {
        this.f881d.setTitle(i10);
        return this;
    }

    public MenuItem setActionView(int i10) {
        this.f881d.setActionView(i10);
        View actionView = this.f881d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f881d.setActionView((View) new c(actionView));
        }
        return this;
    }
}
