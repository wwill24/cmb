package com.coffeemeetsbagel.instant_like;

import com.coffeemeetsbagel.models.Bagel;
import fa.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$2 extends Lambda implements Function1<Bagel, b0<? extends Bagel>> {
    final /* synthetic */ InstantLikeBottomSheetInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetInteractor$purchaseOrSpendInstantLike$2(InstantLikeBottomSheetInteractor instantLikeBottomSheetInteractor) {
        super(1);
        this.this$0 = instantLikeBottomSheetInteractor;
    }

    /* renamed from: a */
    public final b0<? extends Bagel> invoke(Bagel bagel) {
        boolean z10;
        j.g(bagel, "updatedBagel");
        String lastUpdated = bagel.getLastUpdated();
        if (lastUpdated == null || lastUpdated.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String str = "bagel " + bagel.getId() + " missing last_updated";
            a.C0491a aVar = a.f40771d;
            String X1 = this.this$0.f13996w;
            j.f(X1, "tag");
            aVar.c(X1, str, new IllegalArgumentException(str));
        }
        return this.this$0.q2().e(bagel);
    }
}
