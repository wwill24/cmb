package com.coffeemeetsbagel.products.prompts.editor.presentation;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b6.c;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.products.prompts.editor.presentation.l;
import io.reactivex.BackpressureStrategy;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import qj.h;

public final class g extends c<v, l.a> {

    public interface a extends j<PromptEditInteractor> {
        d<?, ?> a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final wa.a f35936a;

        /* renamed from: b  reason: collision with root package name */
        private final w f35937b;

        public b(wa.a aVar, w wVar) {
            kotlin.jvm.internal.j.g(aVar, "view");
            kotlin.jvm.internal.j.g(wVar, "listener");
            this.f35936a = aVar;
            this.f35937b = wVar;
        }

        public final h<Unit> a(PublishSubject<Unit> publishSubject) {
            kotlin.jvm.internal.j.g(publishSubject, "clicks");
            return publishSubject.v0(BackpressureStrategy.LATEST);
        }

        public final PublishSubject<Unit> b() {
            PublishSubject<Unit> C0 = PublishSubject.C0();
            kotlin.jvm.internal.j.f(C0, "create<Unit>()");
            return C0;
        }

        public final PromptEditPresenter c(PublishSubject<Unit> publishSubject) {
            kotlin.jvm.internal.j.g(publishSubject, "backNavClicks");
            return new PromptEditPresenter(this.f35936a, this.f35937b, publishSubject);
        }

        public final xa.a d(a7.a aVar) {
            kotlin.jvm.internal.j.g(aVar, "analyticsManager");
            return new xa.a(aVar);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(l.a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final v b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        PromptEditInteractor promptEditInteractor = new PromptEditInteractor();
        wa.a c10 = wa.a.c(LayoutInflater.from(((l.a) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a a10 = b.a().c(new b(c10, promptEditInteractor)).b((l.a) a()).a();
        ConstraintLayout b10 = c10.getRoot();
        kotlin.jvm.internal.j.f(b10, "binding.root");
        kotlin.jvm.internal.j.f(a10, "component");
        return new v(b10, a10, promptEditInteractor);
    }
}
