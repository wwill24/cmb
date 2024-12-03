package z5;

import android.view.MotionEvent;
import android.view.View;
import com.coffeemeetsbagel.cmbbottomnav.view.CmbBottomNavItemView;

public final /* synthetic */ class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CmbBottomNavItemView f18833a;

    public /* synthetic */ a(CmbBottomNavItemView cmbBottomNavItemView) {
        this.f18833a = cmbBottomNavItemView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f18833a.C(view, motionEvent);
    }
}
