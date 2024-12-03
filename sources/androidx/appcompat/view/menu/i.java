package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.n;
import androidx.core.view.b;
import d.h;
import net.bytebuddy.jar.asm.Opcodes;
import u0.b;

public final class i implements b {
    private View A;
    private androidx.core.view.b B;
    private MenuItem.OnActionExpandListener C;
    private boolean D = false;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    private final int f854a;

    /* renamed from: b  reason: collision with root package name */
    private final int f855b;

    /* renamed from: c  reason: collision with root package name */
    private final int f856c;

    /* renamed from: d  reason: collision with root package name */
    private final int f857d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f858e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f859f;

    /* renamed from: g  reason: collision with root package name */
    private Intent f860g;

    /* renamed from: h  reason: collision with root package name */
    private char f861h;

    /* renamed from: i  reason: collision with root package name */
    private int f862i = Opcodes.ACC_SYNTHETIC;

    /* renamed from: j  reason: collision with root package name */
    private char f863j;

    /* renamed from: k  reason: collision with root package name */
    private int f864k = Opcodes.ACC_SYNTHETIC;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f865l;

    /* renamed from: m  reason: collision with root package name */
    private int f866m = 0;

    /* renamed from: n  reason: collision with root package name */
    g f867n;

    /* renamed from: o  reason: collision with root package name */
    private r f868o;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f869p;

    /* renamed from: q  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f870q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f871r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f872s;

    /* renamed from: t  reason: collision with root package name */
    private ColorStateList f873t = null;

    /* renamed from: u  reason: collision with root package name */
    private PorterDuff.Mode f874u = null;

    /* renamed from: v  reason: collision with root package name */
    private boolean f875v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f876w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f877x = false;

    /* renamed from: y  reason: collision with root package name */
    private int f878y = 16;

    /* renamed from: z  reason: collision with root package name */
    private int f879z;

    class a implements b.C0047b {
        a() {
        }

        public void onActionProviderVisibilityChanged(boolean z10) {
            i iVar = i.this;
            iVar.f867n.J(iVar);
        }
    }

    i(g gVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f867n = gVar;
        this.f854a = i11;
        this.f855b = i10;
        this.f856c = i12;
        this.f857d = i13;
        this.f858e = charSequence;
        this.f879z = i14;
    }

    private static void d(StringBuilder sb2, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f877x && (this.f875v || this.f876w)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (this.f875v) {
                androidx.core.graphics.drawable.a.o(drawable, this.f873t);
            }
            if (this.f876w) {
                androidx.core.graphics.drawable.a.p(drawable, this.f874u);
            }
            this.f877x = false;
        }
        return drawable;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.f867n.H() && g() != 0;
    }

    public boolean B() {
        return (this.f879z & 4) == 4;
    }

    public androidx.core.view.b a() {
        return this.B;
    }

    @NonNull
    public u0.b b(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.A = null;
        this.B = bVar;
        this.f867n.K(true);
        androidx.core.view.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.j(new a());
        }
        return this;
    }

    public void c() {
        this.f867n.I(this);
    }

    public boolean collapseActionView() {
        if ((this.f879z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f867n.f(this);
        }
        return false;
    }

    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f867n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f857d;
    }

    /* access modifiers changed from: package-private */
    public char g() {
        return this.f867n.G() ? this.f863j : this.f861h;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View d10 = bVar.d(this);
        this.A = d10;
        return d10;
    }

    public int getAlphabeticModifiers() {
        return this.f864k;
    }

    public char getAlphabeticShortcut() {
        return this.f863j;
    }

    public CharSequence getContentDescription() {
        return this.f871r;
    }

    public int getGroupId() {
        return this.f855b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f865l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f866m == 0) {
            return null;
        }
        Drawable b10 = e.a.b(this.f867n.u(), this.f866m);
        this.f866m = 0;
        this.f865l = b10;
        return e(b10);
    }

    public ColorStateList getIconTintList() {
        return this.f873t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f874u;
    }

    public Intent getIntent() {
        return this.f860g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f854a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.f862i;
    }

    public char getNumericShortcut() {
        return this.f861h;
    }

    public int getOrder() {
        return this.f856c;
    }

    public SubMenu getSubMenu() {
        return this.f868o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f858e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f859f;
        return charSequence != null ? charSequence : this.f858e;
    }

    public CharSequence getTooltipText() {
        return this.f872s;
    }

    /* access modifiers changed from: package-private */
    public String h() {
        int i10;
        char g10 = g();
        if (g10 == 0) {
            return "";
        }
        Resources resources = this.f867n.u().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f867n.u()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(h.abc_prepend_shortcut_label));
        }
        if (this.f867n.G()) {
            i10 = this.f864k;
        } else {
            i10 = this.f862i;
        }
        d(sb2, i10, 65536, resources.getString(h.abc_menu_meta_shortcut_label));
        d(sb2, i10, Opcodes.ACC_SYNTHETIC, resources.getString(h.abc_menu_ctrl_shortcut_label));
        d(sb2, i10, 2, resources.getString(h.abc_menu_alt_shortcut_label));
        d(sb2, i10, 1, resources.getString(h.abc_menu_shift_shortcut_label));
        d(sb2, i10, 4, resources.getString(h.abc_menu_sym_shortcut_label));
        d(sb2, i10, 8, resources.getString(h.abc_menu_function_shortcut_label));
        if (g10 == 8) {
            sb2.append(resources.getString(h.abc_menu_delete_shortcut_label));
        } else if (g10 == 10) {
            sb2.append(resources.getString(h.abc_menu_enter_shortcut_label));
        } else if (g10 != ' ') {
            sb2.append(g10);
        } else {
            sb2.append(resources.getString(h.abc_menu_space_shortcut_label));
        }
        return sb2.toString();
    }

    public boolean hasSubMenu() {
        return this.f868o != null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence i(n.a aVar) {
        if (aVar == null || !aVar.d()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.f878y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f878y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f878y & 16) != 0;
    }

    public boolean isVisible() {
        androidx.core.view.b bVar = this.B;
        if (bVar == null || !bVar.g()) {
            if ((this.f878y & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.f878y & 8) != 0 || !this.B.b()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean j() {
        androidx.core.view.b bVar;
        if ((this.f879z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.d(this);
        }
        if (this.A != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f870q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.f867n;
        if (gVar.h(gVar, this)) {
            return true;
        }
        Runnable runnable = this.f869p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f860g != null) {
            try {
                this.f867n.u().startActivity(this.f860g);
                return true;
            } catch (ActivityNotFoundException unused) {
            }
        }
        androidx.core.view.b bVar = this.B;
        if (bVar == null || !bVar.e()) {
            return false;
        }
        return true;
    }

    public boolean l() {
        return (this.f878y & 32) == 32;
    }

    public boolean m() {
        return (this.f878y & 4) != 0;
    }

    public boolean n() {
        return (this.f879z & 1) == 1;
    }

    public boolean o() {
        return (this.f879z & 2) == 2;
    }

    @NonNull
    /* renamed from: p */
    public u0.b setActionView(int i10) {
        Context u10 = this.f867n.u();
        setActionView(LayoutInflater.from(u10).inflate(i10, new LinearLayout(u10), false));
        return this;
    }

    @NonNull
    /* renamed from: q */
    public u0.b setActionView(View view) {
        int i10;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i10 = this.f854a) > 0) {
            view.setId(i10);
        }
        this.f867n.I(this);
        return this;
    }

    public void r(boolean z10) {
        this.D = z10;
        this.f867n.K(false);
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z10) {
        int i10;
        int i11 = this.f878y;
        int i12 = i11 & -3;
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        int i13 = i10 | i12;
        this.f878y = i13;
        if (i11 != i13) {
            this.f867n.K(false);
        }
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f863j == c10) {
            return this;
        }
        this.f863j = Character.toLowerCase(c10);
        this.f867n.K(false);
        return this;
    }

    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f878y;
        boolean z11 = z10 | (i10 & true);
        this.f878y = z11 ? 1 : 0;
        if (i10 != z11) {
            this.f867n.K(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z10) {
        if ((this.f878y & 4) != 0) {
            this.f867n.T(this);
        } else {
            s(z10);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f878y |= 16;
        } else {
            this.f878y &= -17;
        }
        this.f867n.K(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f866m = 0;
        this.f865l = drawable;
        this.f877x = true;
        this.f867n.K(false);
        return this;
    }

    @NonNull
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f873t = colorStateList;
        this.f875v = true;
        this.f877x = true;
        this.f867n.K(false);
        return this;
    }

    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f874u = mode;
        this.f876w = true;
        this.f877x = true;
        this.f867n.K(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f860g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        if (this.f861h == c10) {
            return this;
        }
        this.f861h = c10;
        this.f867n.K(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f870q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.f861h = c10;
        this.f863j = Character.toLowerCase(c11);
        this.f867n.K(false);
        return this;
    }

    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 == 0 || i11 == 1 || i11 == 2) {
            this.f879z = i10;
            this.f867n.I(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f858e = charSequence;
        this.f867n.K(false);
        r rVar = this.f868o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f859f = charSequence;
        this.f867n.K(false);
        return this;
    }

    public MenuItem setVisible(boolean z10) {
        if (y(z10)) {
            this.f867n.J(this);
        }
        return this;
    }

    public void t(boolean z10) {
        this.f878y = (z10 ? 4 : 0) | (this.f878y & -5);
    }

    public String toString() {
        CharSequence charSequence = this.f858e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z10) {
        if (z10) {
            this.f878y |= 32;
        } else {
            this.f878y &= -33;
        }
    }

    /* access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @NonNull
    /* renamed from: w */
    public u0.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public void x(r rVar) {
        this.f868o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    /* access modifiers changed from: package-private */
    public boolean y(boolean z10) {
        int i10;
        int i11 = this.f878y;
        int i12 = i11 & -9;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        int i13 = i10 | i12;
        this.f878y = i13;
        if (i11 != i13) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return this.f867n.A();
    }

    @NonNull
    public u0.b setContentDescription(CharSequence charSequence) {
        this.f871r = charSequence;
        this.f867n.K(false);
        return this;
    }

    @NonNull
    public u0.b setTooltipText(CharSequence charSequence) {
        this.f872s = charSequence;
        this.f867n.K(false);
        return this;
    }

    @NonNull
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f863j == c10 && this.f864k == i10) {
            return this;
        }
        this.f863j = Character.toLowerCase(c10);
        this.f864k = KeyEvent.normalizeMetaState(i10);
        this.f867n.K(false);
        return this;
    }

    @NonNull
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f861h == c10 && this.f862i == i10) {
            return this;
        }
        this.f861h = c10;
        this.f862i = KeyEvent.normalizeMetaState(i10);
        this.f867n.K(false);
        return this;
    }

    @NonNull
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f861h = c10;
        this.f862i = KeyEvent.normalizeMetaState(i10);
        this.f863j = Character.toLowerCase(c11);
        this.f864k = KeyEvent.normalizeMetaState(i11);
        this.f867n.K(false);
        return this;
    }

    public MenuItem setIcon(int i10) {
        this.f865l = null;
        this.f866m = i10;
        this.f877x = true;
        this.f867n.K(false);
        return this;
    }

    public MenuItem setTitle(int i10) {
        return setTitle((CharSequence) this.f867n.u().getString(i10));
    }
}
