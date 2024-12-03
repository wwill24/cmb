package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.api.a;
import fa.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import qj.h;
import u6.o;

public abstract class SubscriptionBundleRoomDao implements l<SubscriptionBundleEntity>, o {

    /* renamed from: a  reason: collision with root package name */
    private final String f11615a;

    public static final class a<T> implements Comparator {
        public final int compare(T t10, T t11) {
            return b.a(Integer.valueOf(((SubscriptionBundleEntity) t11).getTier()), Integer.valueOf(((SubscriptionBundleEntity) t10).getTier()));
        }
    }

    public SubscriptionBundleRoomDao() {
        String simpleName = SubscriptionBundleRoomDao.class.getSimpleName();
        j.f(simpleName, "SubscriptionBundleRoomDao::class.java.simpleName");
        this.f11615a = simpleName;
    }

    /* access modifiers changed from: private */
    public static final rn.a A(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Optional B(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    private final String C(String str) {
        String str2;
        if (!StringsKt__StringsKt.H0(str, '%', false, 2, (Object) null)) {
            str2 = '%' + str;
        } else {
            str2 = str;
        }
        if (StringsKt__StringsKt.R(str, '%', false, 2, (Object) null)) {
            return str2;
        }
        return str2 + '%';
    }

    private final int D(int i10) {
        return i10 < 0 ? a.e.API_PRIORITY_OTHER : i10;
    }

    /* access modifiers changed from: private */
    public static final void K(SubscriptionBundleRoomDao subscriptionBundleRoomDao, List list) {
        j.g(subscriptionBundleRoomDao, "this$0");
        j.g(list, "$bundles");
        subscriptionBundleRoomDao.L(list);
    }

    /* access modifiers changed from: private */
    public final List<SubscriptionBundleEntity> x(List<SubscriptionBundleEntity> list, String str) {
        a.C0491a aVar = fa.a.f40771d;
        String str2 = this.f11615a;
        aVar.a(str2, "filterByIntent: " + str + " bundles=" + list);
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (((SubscriptionBundleEntity) next).getIntents().contains(str)) {
                arrayList.add(next);
            }
        }
        return CollectionsKt___CollectionsKt.q0(arrayList, new a());
    }

    /* access modifiers changed from: private */
    public static final Optional y(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List z(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    public abstract h<List<SubscriptionBundleEntity>> E(int i10);

    public abstract h<List<SubscriptionBundleEntity>> F(String str);

    public abstract h<List<SubscriptionBundleEntity>> G(String str);

    public abstract h<List<Integer>> H();

    public abstract h<List<SubscriptionBundleEntity>> I(int i10);

    public abstract h<List<SubscriptionBundleEntity>> J(String str, int i10);

    public void L(List<SubscriptionBundleEntity> list) {
        j.g(list, "bundles");
        w();
        s(list);
    }

    public h<Optional<SubscriptionBundleEntity>> a(String str) {
        j.g(str, "id");
        a.C0491a aVar = fa.a.f40771d;
        String str2 = this.f11615a;
        aVar.a(str2, "getBundleById(" + str + PropertyUtils.MAPPED_DELIM2);
        h<R> Y = F(str).Y(new w0(SubscriptionBundleRoomDao$getBundleById$1.f11616a));
        j.f(Y, "selectBundleById(id).map…)\n            }\n        }");
        return Y;
    }

    public qj.a c(List<SubscriptionBundleEntity> list) {
        j.g(list, "bundles");
        qj.a w10 = qj.a.w(new u0(this, list));
        j.f(w10, "fromAction { upsertAllTransaction(bundles) }");
        return w10;
    }

    public h<List<SubscriptionBundleEntity>> f(String str, int i10) {
        boolean z10;
        j.g(str, SDKConstants.PARAM_INTENT);
        a.C0491a aVar = fa.a.f40771d;
        String str2 = this.f11615a;
        aVar.a(str2, "getHigherTierBundles(" + str + ',' + i10 + PropertyUtils.MAPPED_DELIM2);
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return I(D(i10));
        }
        h<R> Y = J(C(str), D(i10)).Y(new v0(new SubscriptionBundleRoomDao$getHigherTierBundles$1(this, str)));
        j.f(Y, "override fun getHigherTi…        }\n        }\n    }");
        return Y;
    }

    public h<Optional<SubscriptionBundleEntity>> g(String str) {
        boolean z10;
        j.g(str, SDKConstants.PARAM_INTENT);
        a.C0491a aVar = fa.a.f40771d;
        String str2 = this.f11615a;
        aVar.a(str2, "getHighestTierBundles(" + str + PropertyUtils.MAPPED_DELIM2);
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            h<R> M = H().M(new s0(new SubscriptionBundleRoomDao$getHighestTierBundle$1(this)));
            j.f(M, "override fun getHighestT…        }\n        }\n    }");
            return M;
        }
        h<R> Y = G(C(str)).Y(new t0(new SubscriptionBundleRoomDao$getHighestTierBundle$2(this, str)));
        j.f(Y, "override fun getHighestT…        }\n        }\n    }");
        return Y;
    }

    public abstract int w();
}
