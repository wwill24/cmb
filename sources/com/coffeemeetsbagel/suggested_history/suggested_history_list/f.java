package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.suggested_history.GetHistoryBagelUseCase;
import com.coffeemeetsbagel.upsell_banner.g;

public final class f extends b6.c<SuggestedHistoryListRouter, a> {

    public interface a {
        GetHistoryBagelUseCase E0();

        d<?, ?> a();

        a7.a c();

        UserRepository e();

        cb.a f();

        wb.c r();

        a6.a x();
    }

    public interface b extends j<SuggestedHistoryListInteractor>, g.c {
        d<?, ?> a();
    }

    public final class c {

        /* renamed from: a  reason: collision with root package name */
        private final zb.a f37164a;

        /* renamed from: b  reason: collision with root package name */
        private final p f37165b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f37166c;

        public c(f fVar, zb.a aVar, p pVar) {
            kotlin.jvm.internal.j.g(aVar, "binding");
            kotlin.jvm.internal.j.g(pVar, "listener");
            this.f37166c = fVar;
            this.f37164a = aVar;
            this.f37165b = pVar;
        }

        public final SuggestedHistoryListPresenter a() {
            return new SuggestedHistoryListPresenter(this.f37164a, this.f37165b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final SuggestedHistoryListRouter b(ViewGroup viewGroup, com.coffeemeetsbagel.suggested_history.j jVar) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(jVar, "parentListener");
        SuggestedHistoryListInteractor suggestedHistoryListInteractor = new SuggestedHistoryListInteractor(jVar);
        zb.a c10 = zb.a.c(LayoutInflater.from(((a) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        b a10 = b.a().c(new c(this, c10, suggestedHistoryListInteractor)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new SuggestedHistoryListRouter(c10, a10, suggestedHistoryListInteractor);
    }
}
