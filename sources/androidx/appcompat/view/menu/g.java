package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.core.view.y1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class g implements u0.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    private final Context f824a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f825b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f826c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f827d;

    /* renamed from: e  reason: collision with root package name */
    private a f828e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<i> f829f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<i> f830g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f831h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<i> f832i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<i> f833j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f834k;

    /* renamed from: l  reason: collision with root package name */
    private int f835l = 0;

    /* renamed from: m  reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f836m;

    /* renamed from: n  reason: collision with root package name */
    CharSequence f837n;

    /* renamed from: o  reason: collision with root package name */
    Drawable f838o;

    /* renamed from: p  reason: collision with root package name */
    View f839p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f840q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f841r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f842s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f843t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f844u = false;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<i> f845v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<m>> f846w = new CopyOnWriteArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private i f847x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f848y = false;

    /* renamed from: z  reason: collision with root package name */
    private boolean f849z;

    public interface a {
        boolean a(@NonNull g gVar, @NonNull MenuItem menuItem);

        void b(@NonNull g gVar);
    }

    public interface b {
        boolean b(i iVar);
    }

    public g(Context context) {
        this.f824a = context;
        this.f825b = context.getResources();
        this.f829f = new ArrayList<>();
        this.f830g = new ArrayList<>();
        this.f831h = true;
        this.f832i = new ArrayList<>();
        this.f833j = new ArrayList<>();
        this.f834k = true;
        b0(true);
    }

    private static int B(int i10) {
        int i11 = (-65536 & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = A;
            if (i11 < iArr.length) {
                return (i10 & 65535) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void N(int i10, boolean z10) {
        if (i10 >= 0 && i10 < this.f829f.size()) {
            this.f829f.remove(i10);
            if (z10) {
                K(true);
            }
        }
    }

    private void W(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources C = C();
        if (view != null) {
            this.f839p = view;
            this.f837n = null;
            this.f838o = null;
        } else {
            if (i10 > 0) {
                this.f837n = C.getText(i10);
            } else if (charSequence != null) {
                this.f837n = charSequence;
            }
            if (i11 > 0) {
                this.f838o = androidx.core.content.a.getDrawable(u(), i11);
            } else if (drawable != null) {
                this.f838o = drawable;
            }
            this.f839p = null;
        }
        K(false);
    }

    private void b0(boolean z10) {
        boolean z11 = true;
        if (!z10 || this.f825b.getConfiguration().keyboard == 1 || !y1.e(ViewConfiguration.get(this.f824a), this.f824a)) {
            z11 = false;
        }
        this.f827d = z11;
    }

    private i g(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new i(this, i10, i11, i12, i13, charSequence, i14);
    }

    private void i(boolean z10) {
        if (!this.f846w.isEmpty()) {
            d0();
            Iterator<WeakReference<m>> it = this.f846w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.f846w.remove(next);
                } else {
                    mVar.g(z10);
                }
            }
            c0();
        }
    }

    private boolean j(r rVar, m mVar) {
        boolean z10 = false;
        if (this.f846w.isEmpty()) {
            return false;
        }
        if (mVar != null) {
            z10 = mVar.f(rVar);
        }
        Iterator<WeakReference<m>> it = this.f846w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            m mVar2 = (m) next.get();
            if (mVar2 == null) {
                this.f846w.remove(next);
            } else if (!z10) {
                z10 = mVar2.f(rVar);
            }
        }
        return z10;
    }

    private static int n(ArrayList<i> arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.f843t;
    }

    /* access modifiers changed from: package-private */
    public Resources C() {
        return this.f825b;
    }

    public g D() {
        return this;
    }

    @NonNull
    public ArrayList<i> E() {
        if (!this.f831h) {
            return this.f830g;
        }
        this.f830g.clear();
        int size = this.f829f.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = this.f829f.get(i10);
            if (iVar.isVisible()) {
                this.f830g.add(iVar);
            }
        }
        this.f831h = false;
        this.f834k = true;
        return this.f830g;
    }

    public boolean F() {
        return this.f848y;
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return this.f826c;
    }

    public boolean H() {
        return this.f827d;
    }

    /* access modifiers changed from: package-private */
    public void I(i iVar) {
        this.f834k = true;
        K(true);
    }

    /* access modifiers changed from: package-private */
    public void J(i iVar) {
        this.f831h = true;
        K(true);
    }

    public void K(boolean z10) {
        if (!this.f840q) {
            if (z10) {
                this.f831h = true;
                this.f834k = true;
            }
            i(z10);
            return;
        }
        this.f841r = true;
        if (z10) {
            this.f842s = true;
        }
    }

    public boolean L(MenuItem menuItem, int i10) {
        return M(menuItem, (m) null, i10);
    }

    public boolean M(MenuItem menuItem, m mVar, int i10) {
        boolean z10;
        i iVar = (i) menuItem;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        boolean k10 = iVar.k();
        androidx.core.view.b a10 = iVar.a();
        if (a10 == null || !a10.a()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (iVar.j()) {
            k10 |= iVar.expandActionView();
            if (k10) {
                e(true);
            }
        } else if (iVar.hasSubMenu() || z10) {
            if ((i10 & 4) == 0) {
                e(false);
            }
            if (!iVar.hasSubMenu()) {
                iVar.x(new r(u(), this, iVar));
            }
            r rVar = (r) iVar.getSubMenu();
            if (z10) {
                a10.f(rVar);
            }
            k10 |= j(rVar, mVar);
            if (!k10) {
                e(true);
            }
        } else if ((i10 & 1) == 0) {
            e(true);
        }
        return k10;
    }

    public void O(m mVar) {
        Iterator<WeakReference<m>> it = this.f846w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            m mVar2 = (m) next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.f846w.remove(next);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(t());
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                MenuItem item = getItem(i10);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((r) item.getSubMenu()).P(bundle);
                }
            }
            int i11 = bundle.getInt("android:menu:expandedactionview");
            if (i11 > 0 && (findItem = findItem(i11)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.f828e = aVar;
    }

    public g S(int i10) {
        this.f835l = i10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void T(MenuItem menuItem) {
        boolean z10;
        int groupId = menuItem.getGroupId();
        int size = this.f829f.size();
        d0();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = this.f829f.get(i10);
            if (iVar.getGroupId() == groupId && iVar.m() && iVar.isCheckable()) {
                if (iVar == menuItem) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                iVar.s(z10);
            }
        }
        c0();
    }

    /* access modifiers changed from: protected */
    public g U(int i10) {
        W(0, (CharSequence) null, i10, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public g V(Drawable drawable) {
        W(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public g X(int i10) {
        W(i10, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public g Y(CharSequence charSequence) {
        W(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public g Z(View view) {
        W(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int B = B(i12);
        i g10 = g(i10, i11, i12, B, charSequence, this.f835l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f836m;
        if (contextMenuInfo != null) {
            g10.v(contextMenuInfo);
        }
        ArrayList<i> arrayList = this.f829f;
        arrayList.add(n(arrayList, B), g10);
        K(true);
        return g10;
    }

    public void a0(boolean z10) {
        this.f849z = z10;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        Intent intent2;
        int i15;
        PackageManager packageManager = this.f824a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i14 = queryIntentActivityOptions.size();
        } else {
            i14 = 0;
        }
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i16 = 0; i16 < i14; i16++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i16);
            int i17 = resolveInfo.specificIndex;
            if (i17 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i17];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent4 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && (i15 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i15] = intent4;
            }
        }
        return i14;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(m mVar) {
        c(mVar, this.f824a);
    }

    public void c(m mVar, Context context) {
        this.f846w.add(new WeakReference(mVar));
        mVar.j(context, this);
        this.f834k = true;
    }

    public void c0() {
        this.f840q = false;
        if (this.f841r) {
            this.f841r = false;
            K(this.f842s);
        }
    }

    public void clear() {
        i iVar = this.f847x;
        if (iVar != null) {
            f(iVar);
        }
        this.f829f.clear();
        K(true);
    }

    public void clearHeader() {
        this.f838o = null;
        this.f837n = null;
        this.f839p = null;
        K(false);
    }

    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f828e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (!this.f840q) {
            this.f840q = true;
            this.f841r = false;
            this.f842s = false;
        }
    }

    public final void e(boolean z10) {
        if (!this.f844u) {
            this.f844u = true;
            Iterator<WeakReference<m>> it = this.f846w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.f846w.remove(next);
                } else {
                    mVar.c(this, z10);
                }
            }
            this.f844u = false;
        }
    }

    public boolean f(i iVar) {
        boolean z10 = false;
        if (!this.f846w.isEmpty() && this.f847x == iVar) {
            d0();
            Iterator<WeakReference<m>> it = this.f846w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.f846w.remove(next);
                } else {
                    z10 = mVar.i(this, iVar);
                    if (z10) {
                        break;
                    }
                }
            }
            c0();
            if (z10) {
                this.f847x = null;
            }
        }
        return z10;
    }

    public MenuItem findItem(int i10) {
        MenuItem findItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.f829f.get(i11);
            if (iVar.getItemId() == i10) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.getSubMenu().findItem(i10)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public MenuItem getItem(int i10) {
        return this.f829f.get(i10);
    }

    /* access modifiers changed from: package-private */
    public boolean h(@NonNull g gVar, @NonNull MenuItem menuItem) {
        a aVar = this.f828e;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public boolean hasVisibleItems() {
        if (this.f849z) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f829f.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return p(i10, keyEvent) != null;
    }

    public boolean k(i iVar) {
        boolean z10 = false;
        if (this.f846w.isEmpty()) {
            return false;
        }
        d0();
        Iterator<WeakReference<m>> it = this.f846w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            m mVar = (m) next.get();
            if (mVar == null) {
                this.f846w.remove(next);
            } else {
                z10 = mVar.d(this, iVar);
                if (z10) {
                    break;
                }
            }
        }
        c0();
        if (z10) {
            this.f847x = iVar;
        }
        return z10;
    }

    public int l(int i10) {
        return m(i10, 0);
    }

    public int m(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (this.f829f.get(i11).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public int o(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f829f.get(i11).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public i p(int i10, KeyEvent keyEvent) {
        char c10;
        ArrayList<i> arrayList = this.f845v;
        arrayList.clear();
        q(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean G = G();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = arrayList.get(i11);
            if (G) {
                c10 = iVar.getAlphabeticShortcut();
            } else {
                c10 = iVar.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((c10 == cArr[0] && (metaState & 2) == 0) || ((c10 == cArr[2] && (metaState & 2) != 0) || (G && c10 == 8 && i10 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i10, int i11) {
        return L(findItem(i10), i11);
    }

    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        boolean z10;
        i p10 = p(i10, keyEvent);
        if (p10 != null) {
            z10 = L(p10, i11);
        } else {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            e(true);
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void q(List<i> list, int i10, KeyEvent keyEvent) {
        char c10;
        int i11;
        boolean z10;
        boolean G = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            int size = this.f829f.size();
            for (int i12 = 0; i12 < size; i12++) {
                i iVar = this.f829f.get(i12);
                if (iVar.hasSubMenu()) {
                    ((g) iVar.getSubMenu()).q(list, i10, keyEvent);
                }
                if (G) {
                    c10 = iVar.getAlphabeticShortcut();
                } else {
                    c10 = iVar.getNumericShortcut();
                }
                if (G) {
                    i11 = iVar.getAlphabeticModifiers();
                } else {
                    i11 = iVar.getNumericModifiers();
                }
                if ((modifiers & 69647) == (i11 & 69647)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10 && c10 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c10 == cArr[0] || c10 == cArr[2] || (G && c10 == 8 && i10 == 67)) && iVar.isEnabled()) {
                        list.add(iVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<i> E = E();
        if (this.f834k) {
            Iterator<WeakReference<m>> it = this.f846w.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.f846w.remove(next);
                } else {
                    z10 |= mVar.h();
                }
            }
            if (z10) {
                this.f832i.clear();
                this.f833j.clear();
                int size = E.size();
                for (int i10 = 0; i10 < size; i10++) {
                    i iVar = E.get(i10);
                    if (iVar.l()) {
                        this.f832i.add(iVar);
                    } else {
                        this.f833j.add(iVar);
                    }
                }
            } else {
                this.f832i.clear();
                this.f833j.clear();
                this.f833j.addAll(E());
            }
            this.f834k = false;
        }
    }

    public void removeGroup(int i10) {
        int l10 = l(i10);
        if (l10 >= 0) {
            int size = this.f829f.size() - l10;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || this.f829f.get(l10).getGroupId() != i10) {
                    K(true);
                } else {
                    N(l10, false);
                    i11 = i12;
                }
            }
            K(true);
        }
    }

    public void removeItem(int i10) {
        N(o(i10), true);
    }

    public ArrayList<i> s() {
        r();
        return this.f832i;
    }

    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.f829f.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.f829f.get(i11);
            if (iVar.getGroupId() == i10) {
                iVar.t(z11);
                iVar.setCheckable(z10);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z10) {
        this.f848y = z10;
    }

    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.f829f.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.f829f.get(i11);
            if (iVar.getGroupId() == i10) {
                iVar.setEnabled(z10);
            }
        }
    }

    public void setGroupVisible(int i10, boolean z10) {
        int size = this.f829f.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.f829f.get(i11);
            if (iVar.getGroupId() == i10 && iVar.y(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            K(true);
        }
    }

    public void setQwertyMode(boolean z10) {
        this.f826c = z10;
        K(false);
    }

    public int size() {
        return this.f829f.size();
    }

    /* access modifiers changed from: protected */
    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f824a;
    }

    public i v() {
        return this.f847x;
    }

    public Drawable w() {
        return this.f838o;
    }

    public CharSequence x() {
        return this.f837n;
    }

    public View y() {
        return this.f839p;
    }

    public ArrayList<i> z() {
        r();
        return this.f833j;
    }

    public MenuItem add(int i10) {
        return a(0, 0, 0, this.f825b.getString(i10));
    }

    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f825b.getString(i10));
    }

    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        i iVar = (i) a(i10, i11, i12, charSequence);
        r rVar = new r(this.f824a, this, iVar);
        iVar.x(rVar);
        return rVar;
    }

    public MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f825b.getString(i13));
    }

    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, (CharSequence) this.f825b.getString(i13));
    }
}
