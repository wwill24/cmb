package com.coffeemeetsbagel.feature_flag_toggle.interactor;

import b6.s;
import com.coffeemeetsbagel.experiment.r;
import com.uber.autodispose.t;
import java.util.Comparator;
import java.util.List;
import sj.a;

public class l extends s<o, p> {

    /* renamed from: f  reason: collision with root package name */
    r f13487f;

    /* access modifiers changed from: private */
    public /* synthetic */ void I1(List list) throws Exception {
        list.sort(Comparator.comparing(new k()));
        ((o) this.f7875e).m(list);
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((t) this.f13487f.c().E(a.a()).g(com.uber.autodispose.a.a(this))).c(new j(this));
    }
}
