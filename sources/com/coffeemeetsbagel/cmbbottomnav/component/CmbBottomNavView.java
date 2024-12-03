package com.coffeemeetsbagel.cmbbottomnav.component;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.coffeemeetsbagel.cmbbottomnav.behavior.AHBottomNavigationBehavior;
import v5.b;

public class CmbBottomNavView extends ConstraintLayout {
    private AHBottomNavigationBehavior<CmbBottomNavView> F;

    public CmbBottomNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void B() {
        this.F.U(this, getHeight(), true);
        this.F.W(false);
    }

    public void C() {
        this.F.V(this, true);
        this.F.W(true);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        AHBottomNavigationBehavior<CmbBottomNavView> aHBottomNavigationBehavior = new AHBottomNavigationBehavior<>(true, (int) getResources().getDimension(b.bottom_nav_height));
        this.F = aHBottomNavigationBehavior;
        ((CoordinatorLayout.f) getLayoutParams()).o(aHBottomNavigationBehavior);
        requestLayout();
    }
}
