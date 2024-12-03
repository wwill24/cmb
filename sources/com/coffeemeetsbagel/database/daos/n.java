package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.BenefitEntity;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.a;
import qj.h;
import qj.w;
import u6.c;

public abstract class n implements l<BenefitEntity>, c {
    /* access modifiers changed from: private */
    public static final void j(n nVar, List list) {
        j.g(nVar, "this$0");
        j.g(list, "$benefits");
        nVar.n(list);
    }

    public h<List<BenefitEntity>> a() {
        return t();
    }

    public w<Long> c() {
        return u();
    }

    public a f(List<BenefitEntity> list) {
        j.g(list, "benefits");
        a w10 = a.w(new m(this, list));
        j.f(w10, "fromAction { resetBenefitsTransaction(benefits) }");
        return w10;
    }

    public abstract int i();

    public void n(List<BenefitEntity> list) {
        j.g(list, "benefits");
        i();
        s(list);
    }

    public abstract h<List<BenefitEntity>> t();

    public abstract w<Long> u();
}
