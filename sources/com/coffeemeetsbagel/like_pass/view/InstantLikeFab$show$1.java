package com.coffeemeetsbagel.like_pass.view;

import fa.a;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import lc.h;
import qj.w;

final class InstantLikeFab$show$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InstantLikeFab this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeFab$show$1(InstantLikeFab instantLikeFab) {
        super(0);
        this.this$0 = instantLikeFab;
    }

    /* access modifiers changed from: private */
    public static final void d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* renamed from: c */
    public final Unit invoke() {
        a.f40771d.a("SuggestedActionButton", "fadeIn end ");
        w<Long> E = w.N(700, TimeUnit.MILLISECONDS, dk.a.c()).E(sj.a.a());
        final InstantLikeFab instantLikeFab = this.this$0;
        E.c(new a(new Function1<Long, Unit>() {
            public final void a(Long l10) {
                a.f40771d.a("SuggestedActionButton", "wait time over, fading out...");
                h.f41110a.b(instantLikeFab, 300, AnonymousClass1.f14063a);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Long) obj);
                return Unit.f32013a;
            }
        }));
        return null;
    }
}
