package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import net.bytebuddy.jar.asm.Opcodes;
import u0.b;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f745a;

    /* renamed from: b  reason: collision with root package name */
    private final int f746b;

    /* renamed from: c  reason: collision with root package name */
    private final int f747c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f748d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f749e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f750f;

    /* renamed from: g  reason: collision with root package name */
    private char f751g;

    /* renamed from: h  reason: collision with root package name */
    private int f752h = Opcodes.ACC_SYNTHETIC;

    /* renamed from: i  reason: collision with root package name */
    private char f753i;

    /* renamed from: j  reason: collision with root package name */
    private int f754j = Opcodes.ACC_SYNTHETIC;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f755k;

    /* renamed from: l  reason: collision with root package name */
    private Context f756l;

    /* renamed from: m  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f757m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f758n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f759o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f760p = null;

    /* renamed from: q  reason: collision with root package name */
    private PorterDuff.Mode f761q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f762r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f763s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f764t = 16;

    public a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f756l = context;
        this.f745a = i11;
        this.f746b = i10;
        this.f747c = i13;
        this.f748d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f755k;
        if (drawable == null) {
            return;
        }
        if (this.f762r || this.f763s) {
            Drawable r10 = androidx.core.graphics.drawable.a.r(drawable);
            this.f755k = r10;
            Drawable mutate = r10.mutate();
            this.f755k = mutate;
            if (this.f762r) {
                androidx.core.graphics.drawable.a.o(mutate, this.f760p);
            }
            if (this.f763s) {
                androidx.core.graphics.drawable.a.p(this.f755k, this.f761q);
            }
        }
    }

    public androidx.core.view.b a() {
        return null;
    }

    @NonNull
    public b b(androidx.core.view.b bVar) {
        throw new UnsupportedOperationException();
    }

    public boolean collapseActionView() {
        return false;
    }

    @NonNull
    /* renamed from: d */
    public b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    /* renamed from: e */
    public b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public boolean expandActionView() {
        return false;
    }

    @NonNull
    /* renamed from: f */
    public b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f754j;
    }

    public char getAlphabeticShortcut() {
        return this.f753i;
    }

    public CharSequence getContentDescription() {
        return this.f758n;
    }

    public int getGroupId() {
        return this.f746b;
    }

    public Drawable getIcon() {
        return this.f755k;
    }

    public ColorStateList getIconTintList() {
        return this.f760p;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f761q;
    }

    public Intent getIntent() {
        return this.f750f;
    }

    public int getItemId() {
        return this.f745a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f752h;
    }

    public char getNumericShortcut() {
        return this.f751g;
    }

    public int getOrder() {
        return this.f747c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f748d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f749e;
        return charSequence != null ? charSequence : this.f748d;
    }

    public CharSequence getTooltipText() {
        return this.f759o;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f764t & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f764t & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f764t & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f764t & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        this.f753i = Character.toLowerCase(c10);
        return this;
    }

    public MenuItem setCheckable(boolean z10) {
        this.f764t = z10 | (this.f764t & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z10) {
        this.f764t = (z10 ? 2 : 0) | (this.f764t & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z10) {
        this.f764t = (z10 ? 16 : 0) | (this.f764t & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f755k = drawable;
        c();
        return this;
    }

    @NonNull
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f760p = colorStateList;
        this.f762r = true;
        c();
        return this;
    }

    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f761q = mode;
        this.f763s = true;
        c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f750f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        this.f751g = c10;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f757m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.f751g = c10;
        this.f753i = Character.toLowerCase(c11);
        return this;
    }

    public void setShowAsAction(int i10) {
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f748d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f749e = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z10) {
        int i10 = 8;
        int i11 = this.f764t & 8;
        if (z10) {
            i10 = 0;
        }
        this.f764t = i11 | i10;
        return this;
    }

    @NonNull
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f753i = Character.toLowerCase(c10);
        this.f754j = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @NonNull
    public b setContentDescription(CharSequence charSequence) {
        this.f758n = charSequence;
        return this;
    }

    @NonNull
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f751g = c10;
        this.f752h = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    public MenuItem setTitle(int i10) {
        this.f748d = this.f756l.getResources().getString(i10);
        return this;
    }

    @NonNull
    public b setTooltipText(CharSequence charSequence) {
        this.f759o = charSequence;
        return this;
    }

    public MenuItem setIcon(int i10) {
        this.f755k = androidx.core.content.a.getDrawable(this.f756l, i10);
        c();
        return this;
    }

    @NonNull
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f751g = c10;
        this.f752h = KeyEvent.normalizeMetaState(i10);
        this.f753i = Character.toLowerCase(c11);
        this.f754j = KeyEvent.normalizeMetaState(i11);
        return this;
    }
}
