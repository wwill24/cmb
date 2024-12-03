package com.coffeemeetsbagel.match;

import com.coffeemeetsbagel.models.Bagel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

final class BagelRepository$updateBagel$2 extends Lambda implements Function1<Boolean, b0<? extends Bagel>> {
    final /* synthetic */ Bagel $bagel;
    final /* synthetic */ BagelRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BagelRepository$updateBagel$2(BagelRepository bagelRepository, Bagel bagel) {
        super(1);
        this.this$0 = bagelRepository;
        this.$bagel = bagel;
    }

    /* access modifiers changed from: private */
    public static final Bagel d(BagelRepository bagelRepository, Bagel bagel) {
        j.g(bagelRepository, "this$0");
        j.g(bagel, "$bagel");
        Bagel o10 = bagelRepository.f34485a.o(bagel.getId());
        j.d(o10);
        return o10;
    }

    /* renamed from: c */
    public final b0<? extends Bagel> invoke(Boolean bool) {
        j.g(bool, "it");
        return w.A(new s(this.this$0, this.$bagel));
    }
}
