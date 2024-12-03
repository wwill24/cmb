package w5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import b6.p;
import com.coffeemeetsbagel.cmbbottomnav.component.CmbBottomNavView;
import com.coffeemeetsbagel.cmbbottomnav.view.CmbBottomNavItemView;
import java.util.List;
import v5.d;
import v5.e;
import x5.b;

class k extends p<CmbBottomNavView> {

    /* renamed from: e  reason: collision with root package name */
    private final Activity f18262e;

    /* renamed from: f  reason: collision with root package name */
    private final a f18263f;

    /* renamed from: g  reason: collision with root package name */
    private final int f18264g;

    public interface a {
        void I(int i10);
    }

    k(CmbBottomNavView cmbBottomNavView, a aVar, Activity activity) {
        super(cmbBottomNavView);
        this.f18262e = activity;
        this.f18263f = aVar;
        int generateViewId = View.generateViewId();
        this.f18264g = generateViewId;
        cmbBottomNavView.setId(generateViewId);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(b bVar, View view) {
        this.f18263f.I(bVar.c());
    }

    public void k(String str) {
        for (int i10 = 0; i10 < ((CmbBottomNavView) this.f7869c).getChildCount(); i10++) {
            if (((CmbBottomNavView) this.f7869c).getChildAt(i10) instanceof CmbBottomNavItemView) {
                ((CmbBottomNavItemView) ((CmbBottomNavView) this.f7869c).getChildAt(i10)).setUnselected(str);
            }
        }
    }

    public void m(Integer num, String str) {
        k(str);
        CmbBottomNavItemView cmbBottomNavItemView = (CmbBottomNavItemView) ((CmbBottomNavView) this.f7869c).l(num.intValue());
        if (cmbBottomNavItemView != null) {
            cmbBottomNavItemView.I(num.intValue(), str);
        }
    }

    public void n(List<b> list, String str, Boolean bool, Boolean bool2) {
        if (((CmbBottomNavView) this.f7869c).getChildCount() != list.size()) {
            ((CmbBottomNavView) this.f7869c).removeAllViews();
        }
        LayoutInflater from = LayoutInflater.from(this.f18262e);
        int[] iArr = new int[list.size()];
        b bVar = null;
        c cVar = new c();
        cVar.f((ConstraintLayout) this.f7869c);
        int i10 = 0;
        while (i10 < list.size()) {
            b bVar2 = list.get(i10);
            CmbBottomNavItemView cmbBottomNavItemView = (CmbBottomNavItemView) ((CmbBottomNavView) this.f7869c).l(bVar2.c());
            if (cmbBottomNavItemView == null) {
                cmbBottomNavItemView = (CmbBottomNavItemView) from.inflate(e.cmb_bottom_navigation_item, (ViewGroup) this.f7869c, false);
            }
            if (!bool.booleanValue()) {
                cmbBottomNavItemView.setMinWidth((int) ((CmbBottomNavView) this.f7869c).getContext().getResources().getDimension(v5.b.bottom_nav_item_width));
            }
            cmbBottomNavItemView.setOnClickListener(new j(this, bVar2));
            if (bVar2.c() == d.bottom_nav_item_badge_profile) {
                cmbBottomNavItemView.setProfileIconFromUrl(str);
                if (bool2.booleanValue()) {
                    cmbBottomNavItemView.G();
                }
            } else {
                cmbBottomNavItemView.setIcon(bVar2.b());
            }
            cmbBottomNavItemView.setTitle(bVar2.g());
            cmbBottomNavItemView.setId(bVar2.c());
            cmbBottomNavItemView.H(bVar2.f(), bVar2.a());
            cVar.h(bVar2.c(), 3, this.f18264g, 3);
            cVar.h(bVar2.c(), 4, this.f18264g, 4);
            cVar.m(bVar2.c(), -2);
            cVar.n(bVar2.c(), -2);
            if (((CmbBottomNavView) this.f7869c).l(cmbBottomNavItemView.getId()) == null) {
                ((CmbBottomNavView) this.f7869c).addView(cmbBottomNavItemView);
            }
            if (i10 == 0) {
                cVar.h(this.f18264g, 6, bVar2.c(), 6);
                if (list.size() == 1) {
                    cVar.h(bVar2.c(), 2, this.f18264g, 2);
                }
            } else if (i10 == list.size() - 1) {
                cVar.h(bVar2.c(), 1, bVar.c(), 2);
                cVar.h(bVar.c(), 2, bVar2.c(), 1);
                cVar.h(bVar2.c(), 2, this.f18264g, 2);
            } else {
                cVar.h(bVar2.c(), 1, bVar.c(), 2);
                cVar.h(bVar.c(), 2, bVar2.c(), 1);
            }
            iArr[i10] = bVar2.c();
            i10++;
            bVar = bVar2;
        }
        int i11 = this.f18264g;
        cVar.r(i11, 1, i11, 2, iArr, (float[]) null, 2);
        cVar.c((ConstraintLayout) this.f7869c);
    }
}
