package com.coffeemeetsbagel.boost;

import androidx.lifecycle.g;
import androidx.lifecycle.m;
import fa.a;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

final class BoostDialogFragment$onCreate$4 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ BoostDialogFragment this$0;

    @d(c = "com.coffeemeetsbagel.boost.BoostDialogFragment$onCreate$4$1", f = "BoostDialogFragment.kt", l = {135}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.boost.BoostDialogFragment$onCreate$4$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(boostDialogFragment, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                gk.g.b(obj);
                BoostViewModel L0 = boostDialogFragment.f11422j;
                if (L0 == null) {
                    j.y("viewModel");
                    L0 = null;
                }
                this.label = 1;
                if (L0.B(this) == d10) {
                    return d10;
                }
            } else if (i10 == 1) {
                gk.g.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f32013a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoostDialogFragment$onCreate$4(BoostDialogFragment boostDialogFragment) {
        super(1);
        this.this$0 = boostDialogFragment;
    }

    public final void a(Long l10) {
        a.C0491a aVar = a.f40771d;
        String J0 = this.this$0.f11415b;
        aVar.a(J0, "beanBalance changed: " + l10);
        if (this.this$0.f11423k != null) {
            g a10 = m.a(this.this$0);
            final BoostDialogFragment boostDialogFragment = this.this$0;
            s1 unused = j.d(a10, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
            this.this$0.f11423k = null;
        }
        this.this$0.l1();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Long) obj);
        return Unit.f32013a;
    }
}
