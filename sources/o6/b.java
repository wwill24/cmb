package o6;

import android.view.ViewGroup;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.models.constants.Extra;
import j5.p;
import s6.d;
import s6.m;

public class b extends p {
    /* access modifiers changed from: protected */
    /* renamed from: D0 */
    public s6.p z0(ViewGroup viewGroup) {
        return new d((d.c) ((ActivityMain) requireActivity()).K2().A0()).b(viewGroup);
    }

    public void E0() {
        if (this.f7852a.f() instanceof m) {
            m mVar = (m) this.f7852a.f();
            mVar.S1();
            if (getArguments() != null && getArguments().containsKey(Extra.ROUTE_TO_DISCOVER_FILTERS)) {
                mVar.T1(getArguments().getBoolean(Extra.ROUTE_TO_DISCOVER_FILTERS));
                getArguments().remove(Extra.ROUTE_TO_DISCOVER_FILTERS);
            }
        }
    }

    public void F0() {
    }
}
