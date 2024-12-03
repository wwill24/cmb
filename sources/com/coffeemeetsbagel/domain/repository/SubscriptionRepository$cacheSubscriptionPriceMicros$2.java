package com.coffeemeetsbagel.domain.repository;

import fa.a;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

final class SubscriptionRepository$cacheSubscriptionPriceMicros$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ List<String> $skuList;
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$cacheSubscriptionPriceMicros$2(SubscriptionRepository subscriptionRepository, List<String> list) {
        super(1);
        this.this$0 = subscriptionRepository;
        this.$skuList = list;
    }

    public final void a(Throwable th2) {
        j.f(th2, "error");
        a.f40771d.c(this.this$0.f12436j, "Bad skus: [" + CollectionsKt___CollectionsKt.W(this.$skuList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + PropertyUtils.INDEXED_DELIM2, th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
