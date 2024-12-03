package com.coffeemeetsbagel.deactivate;

import com.coffeemeetsbagel.deactivate.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class DeactivateCompPresenter$adapter$2 extends Lambda implements Function0<u> {
    final /* synthetic */ DeactivateCompPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeactivateCompPresenter$adapter$2(DeactivateCompPresenter deactivateCompPresenter) {
        super(0);
        this.this$0 = deactivateCompPresenter;
    }

    /* renamed from: a */
    public final u invoke() {
        final DeactivateCompPresenter deactivateCompPresenter = this.this$0;
        return new u(new u.a(new Function1<Integer, Unit>() {
            public final void a(int i10) {
                deactivateCompPresenter.p().Q(i10);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).intValue());
                return Unit.f32013a;
            }
        }));
    }
}
