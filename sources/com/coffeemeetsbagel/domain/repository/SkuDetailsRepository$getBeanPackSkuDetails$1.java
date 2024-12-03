package com.coffeemeetsbagel.domain.repository;

import com.android.billingclient.api.o;
import com.coffeemeetsbagel.models.enums.RewardType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SkuDetailsRepository$getBeanPackSkuDetails$1 extends Lambda implements Function1<List<? extends o>, Map<String, ? extends o>> {
    final /* synthetic */ SkuDetailsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SkuDetailsRepository$getBeanPackSkuDetails$1(SkuDetailsRepository skuDetailsRepository) {
        super(1);
        this.this$0 = skuDetailsRepository;
    }

    /* renamed from: a */
    public final Map<String, o> invoke(List<o> list) {
        String str;
        Long l10;
        j.g(list, "list");
        SkuDetailsRepository skuDetailsRepository = this.this$0;
        for (o oVar : list) {
            HashMap f10 = skuDetailsRepository.f12426e;
            String b10 = oVar.b();
            j.f(b10, "skuDetails.productId");
            f10.put(b10, oVar);
            String b11 = oVar.b();
            o.a a10 = oVar.a();
            String str2 = null;
            if (a10 != null) {
                str = a10.a();
            } else {
                str = null;
            }
            o.a a11 = oVar.a();
            if (a11 != null) {
                l10 = Long.valueOf(a11.b());
            } else {
                l10 = null;
            }
            String valueOf = String.valueOf(l10);
            o.a a12 = oVar.a();
            if (a12 != null) {
                str2 = a12.c();
            }
            RewardType.updatePriceAndMicros(b11, str, valueOf, str2);
        }
        return this.this$0.f12426e;
    }
}
