package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.utils.model.Optional;
import fa.a;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.discoverV2.DiscoverViewModel$didBecomeActive$1", f = "DiscoverViewModel.kt", l = {192}, m = "invokeSuspend")
final class DiscoverViewModel$didBecomeActive$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiscoverViewModel this$0;

    static final class a<T> implements kotlinx.coroutines.flow.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DiscoverViewModel f12262a;

        a(DiscoverViewModel discoverViewModel) {
            this.f12262a = discoverViewModel;
        }

        /* renamed from: a */
        public final Object c(Optional<vb.a> optional, c<? super Unit> cVar) {
            a.C0491a aVar = fa.a.f40771d;
            String m10 = this.f12262a.f12227s;
            String name = Thread.currentThread().getName();
            aVar.a(m10, "getActiveSubscriptionUseCase: Thread=" + name);
            this.f12262a.F0(optional.d());
            if (!j.b(this.f12262a.f12234z.f(), kotlin.coroutines.jvm.internal.a.a(optional.d())) && j.b(this.f12262a.f12234z.f(), kotlin.coroutines.jvm.internal.a.a(true))) {
                this.f12262a.L0();
            }
            return Unit.f32013a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverViewModel$didBecomeActive$1(DiscoverViewModel discoverViewModel, c<? super DiscoverViewModel$didBecomeActive$1> cVar) {
        super(2, cVar);
        this.this$0 = discoverViewModel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new DiscoverViewModel$didBecomeActive$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((DiscoverViewModel$didBecomeActive$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        DiscoverViewModel.FilterStateViewState filterStateViewState;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            a.C0491a aVar = fa.a.f40771d;
            String m10 = this.this$0.f12227s;
            String name = Thread.currentThread().getName();
            aVar.a(m10, "\tThread=" + name);
            DiscoverViewModel discoverViewModel = this.this$0;
            discoverViewModel.B0(discoverViewModel.f0().p().h().A());
            DiscoverViewModel discoverViewModel2 = this.this$0;
            if (discoverViewModel2.P().c()) {
                filterStateViewState = DiscoverViewModel.FilterStateViewState.ON;
            } else {
                filterStateViewState = DiscoverViewModel.FilterStateViewState.OFF;
            }
            discoverViewModel2.C0(filterStateViewState);
            DiscoverViewModel discoverViewModel3 = this.this$0;
            discoverViewModel3.f12231w = discoverViewModel3.b0().getPrice(PurchaseType.DISCOVER_LIKES);
            DiscoverViewModel discoverViewModel4 = this.this$0;
            discoverViewModel4.f12232x = discoverViewModel4.b0().getPrice(PurchaseType.PAID_LIKE);
            DiscoverViewModel discoverViewModel5 = this.this$0;
            Price k10 = discoverViewModel5.f12232x;
            j.d(k10);
            discoverViewModel5.D0(k10.getFreeItemCount());
            b<Optional<vb.a>> a10 = kotlinx.coroutines.reactive.c.a(this.this$0.R().a());
            a aVar2 = new a(this.this$0);
            this.label = 1;
            if (a10.a(aVar2, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
