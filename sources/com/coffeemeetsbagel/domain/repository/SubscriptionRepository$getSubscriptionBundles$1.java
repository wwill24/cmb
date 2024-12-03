package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.h;
import vb.c;

final class SubscriptionRepository$getSubscriptionBundles$1 extends Lambda implements Function1<List<? extends SubscriptionBundleEntity>, b0<? extends List<? extends c>>> {
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$getSubscriptionBundles$1(SubscriptionRepository subscriptionRepository) {
        super(1);
        this.this$0 = subscriptionRepository;
    }

    /* access modifiers changed from: private */
    public static final b0 e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final int f(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* renamed from: d */
    public final b0<? extends List<c>> invoke(List<SubscriptionBundleEntity> list) {
        j.g(list, "entityList");
        h<T> U = h.U(list);
        final SubscriptionRepository subscriptionRepository = this.this$0;
        return U.S(new v1(new Function1<SubscriptionBundleEntity, b0<? extends c>>() {
            /* renamed from: a */
            public final b0<? extends c> invoke(SubscriptionBundleEntity subscriptionBundleEntity) {
                j.g(subscriptionBundleEntity, "entity");
                return subscriptionRepository.q0(subscriptionBundleEntity);
            }
        })).u0(new w1(AnonymousClass2.f12444a));
    }
}
