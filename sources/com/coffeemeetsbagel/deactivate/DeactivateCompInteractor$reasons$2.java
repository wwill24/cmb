package com.coffeemeetsbagel.deactivate;

import com.coffeemeetsbagel.models.DeactivateReason;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class DeactivateCompInteractor$reasons$2 extends Lambda implements Function0<List<? extends DeactivateReason>> {
    final /* synthetic */ DeactivateCompInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompInteractor$reasons$2(DeactivateCompInteractor deactivateCompInteractor) {
        super(0);
        this.this$0 = deactivateCompInteractor;
    }

    /* renamed from: a */
    public final List<DeactivateReason> invoke() {
        return this.this$0.b2();
    }
}
