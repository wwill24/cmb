package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import com.coffeemeetsbagel.store.v0;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;
import vb.b;
import vb.c;
import vb.d;

final class SubscriptionRepository$getSubscriptionBundle$1 extends Lambda implements Function1<Optional<SubscriptionBundleEntity>, a<? extends Optional<c>>> {
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$getSubscriptionBundle$1(SubscriptionRepository subscriptionRepository) {
        super(1);
        this.this$0 = subscriptionRepository;
    }

    /* access modifiers changed from: private */
    public static final Pair e(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final Optional f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* renamed from: d */
    public final a<? extends Optional<c>> invoke(final Optional<SubscriptionBundleEntity> optional) {
        j.g(optional, "bundleOptional");
        if (optional.d()) {
            return h.n(this.this$0.V(optional.c().getBenefits()), this.this$0.n0(optional.c().getId()), new t1(AnonymousClass1.f12443a)).Y(new u1(new Function1<Pair<? extends List<? extends b>, ? extends List<? extends d>>, Optional<c>>() {
                /* renamed from: a */
                public final Optional<c> invoke(Pair<? extends List<b>, ? extends List<d>> pair) {
                    j.g(pair, "pair");
                    v0 v0Var = v0.f37002a;
                    SubscriptionBundleEntity c10 = optional.c();
                    j.f(c10, "bundleOptional.get()");
                    Object c11 = pair.c();
                    j.f(c11, "pair.first");
                    Object d10 = pair.d();
                    j.f(d10, "pair.second");
                    return Optional.e(v0Var.a(c10, (List) c11, (List) d10));
                }
            }));
        }
        return h.X(Optional.a());
    }
}
