package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.BenefitEntity;
import com.coffeemeetsbagel.store.b;
import com.coffeemeetsbagel.subscription.network.models.BenefitsResponse;
import com.coffeemeetsbagel.subscription.network.models.NetworkBenefit;
import com.coffeemeetsbagel.subscription.network.models.NetworkSubscriptionBundle;
import com.coffeemeetsbagel.subscription.network.models.SubscriptionResponseData;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.a;
import qj.f;
import qj.w;

final class SubscriptionRepository$updateBenefits$2 extends Lambda implements Function1<Boolean, f> {
    final /* synthetic */ SubscriptionResponseData $data;
    final /* synthetic */ SubscriptionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionRepository$updateBenefits$2(SubscriptionRepository subscriptionRepository, SubscriptionResponseData subscriptionResponseData) {
        super(1);
        this.this$0 = subscriptionRepository;
        this.$data = subscriptionResponseData;
    }

    /* access modifiers changed from: private */
    public static final f d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* renamed from: c */
    public final f invoke(Boolean bool) {
        j.g(bool, "shouldGoToNetwork");
        if (!bool.booleanValue()) {
            return a.m();
        }
        w<BenefitsResponse> a10 = this.this$0.f12428b.a();
        final SubscriptionResponseData subscriptionResponseData = this.$data;
        final SubscriptionRepository subscriptionRepository = this.this$0;
        return a10.w(new x1(new Function1<BenefitsResponse, f>() {
            /* renamed from: a */
            public final f invoke(BenefitsResponse benefitsResponse) {
                BenefitEntity benefitEntity;
                j.g(benefitsResponse, "benefitsResponse");
                List<NetworkSubscriptionBundle> subscriptionBundles = subscriptionResponseData.getSubscriptionBundles();
                ArrayList arrayList = new ArrayList(r.t(subscriptionBundles, 10));
                for (NetworkSubscriptionBundle benefits : subscriptionBundles) {
                    arrayList.add(benefits.getBenefits());
                }
                List<String> u10 = r.u(arrayList);
                ArrayList arrayList2 = new ArrayList();
                for (String str : u10) {
                    NetworkBenefit networkBenefit = benefitsResponse.getData().get(str);
                    if (networkBenefit != null) {
                        benefitEntity = b.f36778a.b(str, networkBenefit);
                    } else {
                        benefitEntity = null;
                    }
                    if (benefitEntity != null) {
                        arrayList2.add(benefitEntity);
                    }
                }
                return subscriptionRepository.f12430d.f(arrayList2);
            }
        }));
    }
}
