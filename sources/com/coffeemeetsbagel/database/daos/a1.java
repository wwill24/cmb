package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.SubscriptionEntity;
import com.leanplum.internal.Constants;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.a;
import qj.h;
import u6.p;

public abstract class a1 implements l<SubscriptionEntity>, p {
    /* access modifiers changed from: private */
    public static final void i(a1 a1Var, List list) {
        j.g(a1Var, "this$0");
        j.g(list, "$variants");
        a1Var.j(list);
    }

    public h<List<SubscriptionEntity>> a(String str) {
        boolean z10;
        j.g(str, "bundleId");
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return t(str);
        }
        return n();
    }

    public a c(List<SubscriptionEntity> list) {
        j.g(list, Constants.Keys.VARIANTS);
        a w10 = a.w(new z0(this, list));
        j.f(w10, "fromAction { resetVariantsTransaction(variants) }");
        return w10;
    }

    public abstract int g();

    public void j(List<SubscriptionEntity> list) {
        j.g(list, Constants.Keys.VARIANTS);
        g();
        s(list);
    }

    public abstract h<List<SubscriptionEntity>> n();

    public abstract h<List<SubscriptionEntity>> t(String str);
}
