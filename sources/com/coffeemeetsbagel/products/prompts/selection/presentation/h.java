package com.coffeemeetsbagel.products.prompts.selection.presentation;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b6.c;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.products.prompts.selection.presentation.n;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import io.reactivex.BackpressureStrategy;
import io.reactivex.subjects.PublishSubject;

public final class h extends c<y, n.a> {

    public interface a extends j<PromptSelectionInteractor> {
        d<?, ?> a();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final wa.b f35988a;

        public b(wa.b bVar) {
            kotlin.jvm.internal.j.g(bVar, "binding");
            this.f35988a = bVar;
        }

        public final qj.h<QuestionWAnswers> a(PublishSubject<QuestionWAnswers> publishSubject) {
            kotlin.jvm.internal.j.g(publishSubject, "promptItemCLicks");
            return publishSubject.v0(BackpressureStrategy.LATEST);
        }

        public final PublishSubject<QuestionWAnswers> b() {
            PublishSubject<QuestionWAnswers> C0 = PublishSubject.C0();
            kotlin.jvm.internal.j.f(C0, "create()");
            return C0;
        }

        public final PromptSelectionAdapter c(PublishSubject<QuestionWAnswers> publishSubject) {
            kotlin.jvm.internal.j.g(publishSubject, "promptItemCLicks");
            return new PromptSelectionAdapter(publishSubject);
        }

        public final PromptSelectionPresenter d(PromptSelectionAdapter promptSelectionAdapter) {
            kotlin.jvm.internal.j.g(promptSelectionAdapter, "adapter");
            return new PromptSelectionPresenter(this.f35988a, promptSelectionAdapter);
        }

        public final ya.a e(a7.a aVar) {
            kotlin.jvm.internal.j.g(aVar, "analyticsManager");
            return new ya.a(aVar);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(n.a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final y b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        PromptSelectionInteractor promptSelectionInteractor = new PromptSelectionInteractor();
        wa.b c10 = wa.b.c(LayoutInflater.from(((n.a) a()).a()), viewGroup, false);
        kotlin.jvm.internal.j.f(c10, "inflate(inflater, parentViewGroup, false)");
        a b10 = b.a().c(new b(c10)).a((n.a) a()).b();
        RecyclerView b11 = c10.getRoot();
        kotlin.jvm.internal.j.f(b11, "binding.root");
        kotlin.jvm.internal.j.f(b10, "component");
        return new y(b11, b10, promptSelectionInteractor);
    }
}
