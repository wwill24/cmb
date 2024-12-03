package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Session;
import qj.b0;
import qj.w;
import vb.c;

final class SubscriptionRepository$getHighestTierSubscriptionBundleByIntent$1 extends Lambda implements Function1<Optional<SubscriptionBundleEntity>, b0<? extends Optional<c>>> {
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$getHighestTierSubscriptionBundleByIntent$1(SubscriptionRepository subscriptionRepository) {
        super(1);
        this.this$0 = subscriptionRepository;
    }

    /* access modifiers changed from: private */
    public static final Optional d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends Optional<c>> invoke(Optional<SubscriptionBundleEntity> optional) {
        j.g(optional, Session.Feature.OPTIONAL_ELEMENT);
        if (!optional.d()) {
            return w.C(Optional.a());
        }
        SubscriptionBundleEntity c10 = optional.c();
        SubscriptionRepository subscriptionRepository = this.this$0;
        j.f(c10, "bundleEntity");
        return subscriptionRepository.q0(c10).D(new s1(AnonymousClass1.f12442a));
    }
}
