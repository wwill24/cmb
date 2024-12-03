package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.suggested.models.RefillBagelsNetwork;
import fa.a;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SuggestedRepository$refill$2 extends Lambda implements Function1<RefillBagelsNetwork, List<? extends Bagel>> {
    final /* synthetic */ SuggestedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedRepository$refill$2(SuggestedRepository suggestedRepository) {
        super(1);
        this.this$0 = suggestedRepository;
    }

    /* renamed from: a */
    public final List<Bagel> invoke(RefillBagelsNetwork refillBagelsNetwork) {
        Integer num;
        j.g(refillBagelsNetwork, "networkResponse");
        List<Bagel> bagels = refillBagelsNetwork.getBagels();
        if (refillBagelsNetwork.getOutOfBagels()) {
            a.C0491a aVar = a.f40771d;
            String u10 = this.this$0.f12458h;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("These ");
            if (bagels != null) {
                num = Integer.valueOf(bagels.size());
            } else {
                num = null;
            }
            sb2.append(num);
            sb2.append(" matches are the last Suggested for user till next noon");
            aVar.a(u10, sb2.toString());
        }
        if (bagels == null) {
            return q.j();
        }
        return bagels;
    }
}
