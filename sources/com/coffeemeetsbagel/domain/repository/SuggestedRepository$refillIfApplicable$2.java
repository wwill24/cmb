package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.util.DateUtils;
import fa.a;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

final class SuggestedRepository$refillIfApplicable$2 extends Lambda implements Function1<Pair<? extends Boolean, ? extends Long>, b0<? extends List<? extends Bagel>>> {
    final /* synthetic */ long $timestamp;
    final /* synthetic */ SuggestedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedRepository$refillIfApplicable$2(SuggestedRepository suggestedRepository, long j10) {
        super(1);
        this.this$0 = suggestedRepository;
        this.$timestamp = j10;
    }

    /* renamed from: a */
    public final b0<? extends List<Bagel>> invoke(Pair<Boolean, Long> pair) {
        boolean z10;
        j.g(pair, "pair");
        boolean booleanValue = pair.c().booleanValue();
        if (pair.d().longValue() < DateUtils.getTimestampForLastNoon()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!booleanValue || !z10) {
            return this.this$0.z(this.$timestamp);
        }
        a.f40771d.a(this.this$0.f12458h, "\tout of bagels and already requested today.");
        w C = w.C(q.j());
        j.f(C, "{\n                      …())\n                    }");
        return C;
    }
}
