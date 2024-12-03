package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.ActiveSubscriptionEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;
import vb.b;

final class SubscriptionRepository$getActiveSubscription$1 extends Lambda implements Function1<List<? extends ActiveSubscriptionEntity>, a<? extends Optional<vb.a>>> {
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$getActiveSubscription$1(SubscriptionRepository subscriptionRepository) {
        super(1);
        this.this$0 = subscriptionRepository;
    }

    /* access modifiers changed from: private */
    public static final Optional d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* renamed from: c */
    public final a<? extends Optional<vb.a>> invoke(final List<ActiveSubscriptionEntity> list) {
        j.g(list, "list");
        if (!list.isEmpty()) {
            return this.this$0.V(list.get(0).getBenefits()).Y(new r1(new Function1<List<? extends b>, Optional<vb.a>>() {
                /* renamed from: a */
                public final Optional<vb.a> invoke(List<b> list) {
                    j.g(list, "benefitList");
                    return Optional.e(com.coffeemeetsbagel.store.a.f36745a.a(list.get(0), list));
                }
            }));
        }
        return h.X(Optional.a());
    }
}
