package com.coffeemeetsbagel.shop.shop;

import com.coffeemeetsbagel.domain.repository.SkuDetailsRepository;
import com.coffeemeetsbagel.google_play.CmbBillingClient;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import qj.w;

public final class GetPlayAvailabilityUseCase {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f36482a = GetPlayAvailabilityUseCase.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final w<Boolean> f36483b;

    /* renamed from: c  reason: collision with root package name */
    private final w<Boolean> f36484c;

    public enum BillingAvailabilityStatus {
        PLAY_UNAVAILABLE,
        SKU_DETAILS_UNAVAILABLE,
        AVAILABLE
    }

    public GetPlayAvailabilityUseCase(SkuDetailsRepository skuDetailsRepository, CmbBillingClient cmbBillingClient) {
        j.g(skuDetailsRepository, "skuDetailsRepository");
        j.g(cmbBillingClient, "billingClient");
        w<Boolean> J = cmbBillingClient.A().J(Boolean.TRUE);
        j.f(J, "billingClient\n          …   .toSingleDefault(true)");
        this.f36483b = J;
        w<R> D = skuDetailsRepository.i().D(new d(GetPlayAvailabilityUseCase$pricesAreAvailable$1.f36490a));
        j.f(D, "skuDetailsRepository\n   …sNotEmpty()\n            }");
        this.f36484c = D;
    }

    /* access modifiers changed from: private */
    public static final BillingAvailabilityStatus f(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (BillingAvailabilityStatus) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final void g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Boolean h(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Boolean) function1.invoke(obj);
    }

    public final w<BillingAvailabilityStatus> e() {
        w<R> H = this.f36483b.U(this.f36484c, new e(GetPlayAvailabilityUseCase$invoke$1.f36489a)).L(3, TimeUnit.SECONDS).p(new f(new GetPlayAvailabilityUseCase$invoke$2(this))).H(BillingAvailabilityStatus.PLAY_UNAVAILABLE);
        j.f(H, "operator fun invoke(): S…s.PLAY_UNAVAILABLE)\n    }");
        return H;
    }
}
