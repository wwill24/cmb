package com.coffeemeetsbagel.deactivate;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.c;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.deactivate.DeactivateCompPresenter;
import com.coffeemeetsbagel.deactivate.q;

public final class g extends c<DeactivateCompRouter, q.a> {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f12019b;

    public interface a extends j<DeactivateCompInteractor> {
        d<?, ?> a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final k6.g f12020a;

        /* renamed from: b  reason: collision with root package name */
        private final DeactivateCompPresenter.a f12021b;

        public b(k6.g gVar, DeactivateCompPresenter.a aVar) {
            kotlin.jvm.internal.j.g(gVar, "binding");
            kotlin.jvm.internal.j.g(aVar, "listeners");
            this.f12020a = gVar;
            this.f12021b = aVar;
        }

        public final DeactivateCompPresenter a(d<?, ?> dVar) {
            kotlin.jvm.internal.j.g(dVar, "activity");
            return new DeactivateCompPresenter(this.f12020a, this.f12021b, dVar);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(q.a aVar, boolean z10) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
        this.f12019b = z10;
    }

    public final DeactivateCompRouter b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        DeactivateCompInteractor deactivateCompInteractor = new DeactivateCompInteractor(this.f12019b);
        k6.g c10 = k6.g.c(LayoutInflater.from(((q.a) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a a10 = b.a().b(new b(c10, deactivateCompInteractor)).c((q.a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new DeactivateCompRouter(c10, a10, deactivateCompInteractor);
    }
}
