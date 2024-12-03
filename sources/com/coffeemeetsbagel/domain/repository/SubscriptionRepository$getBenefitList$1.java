package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.BenefitEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import vb.b;

final class SubscriptionRepository$getBenefitList$1 extends Lambda implements Function1<List<? extends BenefitEntity>, List<? extends b>> {
    final /* synthetic */ List<String> $benefits;

    public static final class a<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f12441a;

        public a(List list) {
            this.f12441a = list;
        }

        public final int compare(T t10, T t11) {
            return b.a(Integer.valueOf(this.f12441a.indexOf(((BenefitEntity) t10).getKey())), Integer.valueOf(this.f12441a.indexOf(((BenefitEntity) t11).getKey())));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$getBenefitList$1(List<String> list) {
        super(1);
        this.$benefits = list;
    }

    /* renamed from: a */
    public final List<b> invoke(List<BenefitEntity> list) {
        j.g(list, "benefitList");
        List<String> list2 = this.$benefits;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (list2.contains(((BenefitEntity) next).getKey())) {
                arrayList.add(next);
            }
        }
        List<BenefitEntity> q02 = CollectionsKt___CollectionsKt.q0(arrayList, new a(this.$benefits));
        ArrayList arrayList2 = new ArrayList(r.t(q02, 10));
        for (BenefitEntity a10 : q02) {
            arrayList2.add(com.coffeemeetsbagel.store.b.f36778a.a(a10));
        }
        return arrayList2;
    }
}
