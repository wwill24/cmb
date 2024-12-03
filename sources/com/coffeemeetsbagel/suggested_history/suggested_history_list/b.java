package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import b6.d;
import b6.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.suggested_history.GetHistoryBagelUseCase;
import com.coffeemeetsbagel.suggested_history.suggested_history_list.f;
import fj.g;
import wb.c;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private f.c f37151a;

        /* renamed from: b  reason: collision with root package name */
        private f.a f37152b;

        private a() {
        }

        public f.b a() {
            g.a(this.f37151a, f.c.class);
            g.a(this.f37152b, f.a.class);
            return new C0460b(this.f37151a, this.f37152b);
        }

        public a b(f.a aVar) {
            this.f37152b = (f.a) g.b(aVar);
            return this;
        }

        public a c(f.c cVar) {
            this.f37151a = (f.c) g.b(cVar);
            return this;
        }
    }

    /* renamed from: com.coffeemeetsbagel.suggested_history.suggested_history_list.b$b  reason: collision with other inner class name */
    private static final class C0460b implements f.b {

        /* renamed from: a  reason: collision with root package name */
        private final f.c f37153a;

        /* renamed from: b  reason: collision with root package name */
        private final f.a f37154b;

        /* renamed from: c  reason: collision with root package name */
        private final C0460b f37155c;

        private C0460b(f.c cVar, f.a aVar) {
            this.f37155c = this;
            this.f37153a = cVar;
            this.f37154b = aVar;
        }

        private SuggestedHistoryListInteractor d(SuggestedHistoryListInteractor suggestedHistoryListInteractor) {
            t.a(suggestedHistoryListInteractor, g.a(this.f37153a));
            n.f(suggestedHistoryListInteractor, (UserRepository) g.d(this.f37154b.e()));
            n.d(suggestedHistoryListInteractor, (cb.a) g.d(this.f37154b.f()));
            n.b(suggestedHistoryListInteractor, (c) g.d(this.f37154b.r()));
            n.e(suggestedHistoryListInteractor, (a7.a) g.d(this.f37154b.c()));
            n.a(suggestedHistoryListInteractor, (a6.a) g.d(this.f37154b.x()));
            n.c(suggestedHistoryListInteractor, (GetHistoryBagelUseCase) g.d(this.f37154b.E0()));
            return suggestedHistoryListInteractor;
        }

        public d<?, ?> a() {
            return (d) g.d(this.f37154b.a());
        }

        /* renamed from: b */
        public void l1(SuggestedHistoryListInteractor suggestedHistoryListInteractor) {
            d(suggestedHistoryListInteractor);
        }

        public a7.a c() {
            return (a7.a) g.d(this.f37154b.c());
        }
    }

    public static a a() {
        return new a();
    }
}
