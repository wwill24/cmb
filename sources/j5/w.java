package j5;

import android.os.Bundle;
import android.view.View;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.models.constants.Extra;
import r7.b;
import sb.a;

public abstract class w extends b {

    /* renamed from: d  reason: collision with root package name */
    public int f15627d;

    public abstract void Q0();

    public void R0(int i10) {
        this.f15627d = i10;
    }

    /* access modifiers changed from: protected */
    public void S0(View view, int i10) {
        if (getActivity() == null) {
            return;
        }
        if (getActivity() instanceof ActivityMain) {
            ((ActivityMain) getActivity()).z1(i10);
        } else {
            a.i(view, i10);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (getArguments() != null && getArguments().containsKey(Extra.TAB_INDEX)) {
            this.f15627d = getArguments().getInt(Extra.TAB_INDEX, -1);
        } else if (bundle == null) {
            this.f15627d = -1;
        } else {
            this.f15627d = bundle.getInt(Extra.TAB_INDEX);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(Extra.TAB_INDEX, this.f15627d);
    }
}
