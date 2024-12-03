package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.r;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.b;
import java.util.ArrayList;

class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements b.a {
    private boolean B;
    private boolean C;
    private int D;
    private final SparseBooleanArray E = new SparseBooleanArray();
    e F;
    a G;
    c H;
    private b I;
    final f J = new f();
    int K;

    /* renamed from: l  reason: collision with root package name */
    d f976l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f977m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f978n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f979p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f980q;

    /* renamed from: t  reason: collision with root package name */
    private int f981t;

    /* renamed from: w  reason: collision with root package name */
    private int f982w;

    /* renamed from: x  reason: collision with root package name */
    private int f983x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f984y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f985z;

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f986a;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f986a);
        }

        SavedState(Parcel parcel) {
            this.f986a = parcel.readInt();
        }
    }

    private class a extends l {
        public a(Context context, r rVar, View view) {
            super(context, rVar, view, false, d.a.actionOverflowMenuStyle);
            if (!((i) rVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f976l;
                f(view2 == null ? (View) ActionMenuPresenter.this.f773j : view2);
            }
            j(ActionMenuPresenter.this.J);
        }

        /* access modifiers changed from: protected */
        public void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.G = null;
            actionMenuPresenter.K = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        public p a() {
            a aVar = ActionMenuPresenter.this.G;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    private class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private e f989a;

        public c(e eVar) {
            this.f989a = eVar;
        }

        public void run() {
            if (ActionMenuPresenter.this.f767c != null) {
                ActionMenuPresenter.this.f767c.d();
            }
            View view = (View) ActionMenuPresenter.this.f773j;
            if (!(view == null || view.getWindowToken() == null || !this.f989a.m())) {
                ActionMenuPresenter.this.F = this.f989a;
            }
            ActionMenuPresenter.this.H = null;
        }
    }

    private class d extends AppCompatImageView implements ActionMenuView.a {

        class a extends o0 {

            /* renamed from: k  reason: collision with root package name */
            final /* synthetic */ ActionMenuPresenter f992k;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f992k = actionMenuPresenter;
            }

            public p b() {
                e eVar = ActionMenuPresenter.this.F;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            public boolean c() {
                ActionMenuPresenter.this.K();
                return true;
            }

            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.H != null) {
                    return false;
                }
                actionMenuPresenter.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, (AttributeSet) null, d.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            n1.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.K();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    private class e extends l {
        public e(Context context, g gVar, View view, boolean z10) {
            super(context, gVar, view, z10, d.a.actionOverflowMenuStyle);
            h(8388613);
            j(ActionMenuPresenter.this.J);
        }

        /* access modifiers changed from: protected */
        public void e() {
            if (ActionMenuPresenter.this.f767c != null) {
                ActionMenuPresenter.this.f767c.close();
            }
            ActionMenuPresenter.this.F = null;
            super.e();
        }
    }

    private class f implements m.a {
        f() {
        }

        public void c(@NonNull g gVar, boolean z10) {
            if (gVar instanceof r) {
                gVar.D().e(false);
            }
            m.a m10 = ActionMenuPresenter.this.m();
            if (m10 != null) {
                m10.c(gVar, z10);
            }
        }

        public boolean d(@NonNull g gVar) {
            if (gVar == ActionMenuPresenter.this.f767c) {
                return false;
            }
            ActionMenuPresenter.this.K = ((r) gVar).getItem().getItemId();
            m.a m10 = ActionMenuPresenter.this.m();
            if (m10 != null) {
                return m10.d(gVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, d.g.abc_action_menu_layout, d.g.abc_action_menu_item_layout);
    }

    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f773j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.f976l;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f978n) {
            return this.f977m;
        }
        return null;
    }

    public boolean B() {
        n nVar;
        c cVar = this.H;
        if (cVar == null || (nVar = this.f773j) == null) {
            e eVar = this.F;
            if (eVar == null) {
                return false;
            }
            eVar.b();
            return true;
        }
        ((View) nVar).removeCallbacks(cVar);
        this.H = null;
        return true;
    }

    public boolean C() {
        a aVar = this.G;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.H != null || E();
    }

    public boolean E() {
        e eVar = this.F;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.f984y) {
            this.f983x = androidx.appcompat.view.a.b(this.f766b).d();
        }
        g gVar = this.f767c;
        if (gVar != null) {
            gVar.K(true);
        }
    }

    public void G(boolean z10) {
        this.C = z10;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f773j = actionMenuView;
        actionMenuView.a(this.f767c);
    }

    public void I(Drawable drawable) {
        d dVar = this.f976l;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.f978n = true;
        this.f977m = drawable;
    }

    public void J(boolean z10) {
        this.f979p = z10;
        this.f980q = true;
    }

    public boolean K() {
        g gVar;
        if (!this.f979p || E() || (gVar = this.f767c) == null || this.f773j == null || this.H != null || gVar.z().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f766b, this.f767c, this.f976l, true));
        this.H = cVar;
        ((View) this.f773j).post(cVar);
        return true;
    }

    public void b(i iVar, n.a aVar) {
        aVar.c(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f773j);
        if (this.I == null) {
            this.I = new b();
        }
        actionMenuItemView.setPopupCallback(this.I);
    }

    public void c(g gVar, boolean z10) {
        y();
        super.c(gVar, z10);
    }

    public boolean f(r rVar) {
        boolean z10 = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        r rVar2 = rVar;
        while (rVar2.e0() != this.f767c) {
            rVar2 = (r) rVar2.e0();
        }
        View z11 = z(rVar2.getItem());
        if (z11 == null) {
            return false;
        }
        this.K = rVar.getItem().getItemId();
        int size = rVar.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        a aVar = new a(this.f766b, rVar, z11);
        this.G = aVar;
        aVar.g(z10);
        this.G.k();
        super.f(rVar);
        return true;
    }

    public void g(boolean z10) {
        ArrayList<i> arrayList;
        n nVar;
        super.g(z10);
        ((View) this.f773j).requestLayout();
        g gVar = this.f767c;
        boolean z11 = false;
        if (gVar != null) {
            ArrayList<i> s10 = gVar.s();
            int size = s10.size();
            for (int i10 = 0; i10 < size; i10++) {
                androidx.core.view.b a10 = s10.get(i10).a();
                if (a10 != null) {
                    a10.i(this);
                }
            }
        }
        g gVar2 = this.f767c;
        if (gVar2 != null) {
            arrayList = gVar2.z();
        } else {
            arrayList = null;
        }
        if (this.f979p && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z11 = !arrayList.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f976l == null) {
                this.f976l = new d(this.f765a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f976l.getParent();
            if (viewGroup != this.f773j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f976l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f773j;
                actionMenuView.addView(this.f976l, actionMenuView.D());
            }
        } else {
            d dVar = this.f976l;
            if (dVar != null && dVar.getParent() == (nVar = this.f773j)) {
                ((ViewGroup) nVar).removeView(this.f976l);
            }
        }
        ((ActionMenuView) this.f773j).setOverflowReserved(this.f979p);
    }

    public boolean h() {
        int i10;
        ArrayList<i> arrayList;
        int i11;
        int i12;
        int i13;
        boolean z10;
        boolean z11;
        boolean z12;
        ActionMenuPresenter actionMenuPresenter = this;
        g gVar = actionMenuPresenter.f767c;
        View view = null;
        boolean z13 = false;
        if (gVar != null) {
            arrayList = gVar.E();
            i10 = arrayList.size();
        } else {
            arrayList = null;
            i10 = 0;
        }
        int i14 = actionMenuPresenter.f983x;
        int i15 = actionMenuPresenter.f982w;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f773j;
        boolean z14 = false;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < i10; i18++) {
            i iVar = arrayList.get(i18);
            if (iVar.o()) {
                i16++;
            } else if (iVar.n()) {
                i17++;
            } else {
                z14 = true;
            }
            if (actionMenuPresenter.C && iVar.isActionViewExpanded()) {
                i14 = 0;
            }
        }
        if (actionMenuPresenter.f979p && (z14 || i17 + i16 > i14)) {
            i14--;
        }
        int i19 = i14 - i16;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.E;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f985z) {
            int i20 = actionMenuPresenter.D;
            i11 = i15 / i20;
            i12 = i20 + ((i15 % i20) / i11);
        } else {
            i12 = 0;
            i11 = 0;
        }
        int i21 = 0;
        int i22 = 0;
        while (i21 < i10) {
            i iVar2 = arrayList.get(i21);
            if (iVar2.o()) {
                View n10 = actionMenuPresenter.n(iVar2, view, viewGroup);
                if (actionMenuPresenter.f985z) {
                    i11 -= ActionMenuView.J(n10, i12, i11, makeMeasureSpec, z13 ? 1 : 0);
                } else {
                    n10.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n10.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i22 == 0) {
                    i22 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
                z10 = z13;
                i13 = i10;
            } else if (iVar2.n()) {
                int groupId2 = iVar2.getGroupId();
                boolean z15 = sparseBooleanArray.get(groupId2);
                if ((i19 > 0 || z15) && i15 > 0 && (!actionMenuPresenter.f985z || i11 > 0)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z16 = z11;
                i13 = i10;
                if (z11) {
                    View n11 = actionMenuPresenter.n(iVar2, (View) null, viewGroup);
                    if (actionMenuPresenter.f985z) {
                        int J2 = ActionMenuView.J(n11, i12, i11, makeMeasureSpec, 0);
                        i11 -= J2;
                        if (J2 == 0) {
                            z16 = false;
                        }
                    } else {
                        n11.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z17 = z16;
                    int measuredWidth2 = n11.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i22 == 0) {
                        i22 = measuredWidth2;
                    }
                    if (!actionMenuPresenter.f985z ? i15 + i22 <= 0 : i15 < 0) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    z11 = z17 & z12;
                }
                if (z11 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z15) {
                    sparseBooleanArray.put(groupId2, false);
                    int i23 = 0;
                    while (i23 < i21) {
                        i iVar3 = arrayList.get(i23);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.l()) {
                                i19++;
                            }
                            iVar3.u(false);
                        }
                        i23++;
                    }
                }
                if (z11) {
                    i19--;
                }
                iVar2.u(z11);
                z10 = false;
            } else {
                z10 = z13;
                i13 = i10;
                iVar2.u(z10);
            }
            i21++;
            z13 = z10;
            i10 = i13;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    public void j(@NonNull Context context, g gVar) {
        super.j(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a b10 = androidx.appcompat.view.a.b(context);
        if (!this.f980q) {
            this.f979p = b10.h();
        }
        if (!this.B) {
            this.f981t = b10.c();
        }
        if (!this.f984y) {
            this.f983x = b10.d();
        }
        int i10 = this.f981t;
        if (this.f979p) {
            if (this.f976l == null) {
                d dVar = new d(this.f765a);
                this.f976l = dVar;
                if (this.f978n) {
                    dVar.setImageDrawable(this.f977m);
                    this.f977m = null;
                    this.f978n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f976l.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i10 -= this.f976l.getMeasuredWidth();
        } else {
            this.f976l = null;
        }
        this.f982w = i10;
        this.D = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean l(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f976l) {
            return false;
        }
        return super.l(viewGroup, i10);
    }

    public View n(i iVar, View view, ViewGroup viewGroup) {
        int i10;
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.n(iVar, view, viewGroup);
        }
        if (iVar.isActionViewExpanded()) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        actionView.setVisibility(i10);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m(layoutParams));
        }
        return actionView;
    }

    public n o(ViewGroup viewGroup) {
        n nVar = this.f773j;
        n o10 = super.o(viewGroup);
        if (nVar != o10) {
            ((ActionMenuView) o10).setPresenter(this);
        }
        return o10;
    }

    public boolean q(int i10, i iVar) {
        return iVar.l();
    }

    public boolean y() {
        return B() | C();
    }
}
