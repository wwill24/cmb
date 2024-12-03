package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import a6.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.match_prefs.GetMatchPreferencesUseCase;
import com.coffeemeetsbagel.match_prefs.MatchPreferenceQuestions;
import com.coffeemeetsbagel.match_prefs.f;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import gk.g;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

public final class MatchPreferencesViewModel extends f0 {

    /* renamed from: d  reason: collision with root package name */
    private final a f13287d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final SaveAnswerUseCase f13288e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final t<QuestionWAnswers> f13289f;

    /* renamed from: g  reason: collision with root package name */
    private final LiveData<QuestionWAnswers> f13290g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final t<QuestionWAnswers> f13291h;

    /* renamed from: i  reason: collision with root package name */
    private final LiveData<QuestionWAnswers> f13292i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final t<QuestionWAnswers> f13293j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveData<QuestionWAnswers> f13294k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final t<QuestionWAnswers> f13295l;

    /* renamed from: m  reason: collision with root package name */
    private final LiveData<QuestionWAnswers> f13296m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final t<Pair<QuestionWAnswers, Boolean>> f13297n;

    /* renamed from: o  reason: collision with root package name */
    private final LiveData<Pair<QuestionWAnswers, Boolean>> f13298o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final t<Pair<QuestionWAnswers, Boolean>> f13299p;

    /* renamed from: q  reason: collision with root package name */
    private final LiveData<Pair<QuestionWAnswers, Boolean>> f13300q;

    @d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences.MatchPreferencesViewModel$1", f = "MatchPreferencesViewModel.kt", l = {48}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences.MatchPreferencesViewModel$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences.MatchPreferencesViewModel$1$a */
        static final class a<T> implements kotlinx.coroutines.flow.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MatchPreferencesViewModel f13301a;

            a(MatchPreferencesViewModel matchPreferencesViewModel) {
                this.f13301a = matchPreferencesViewModel;
            }

            /* renamed from: a */
            public final Object c(GetMatchPreferencesUseCase.a aVar, c<? super Unit> cVar) {
                String str;
                Question e10;
                List<f> a10 = aVar.a();
                MatchPreferencesViewModel matchPreferencesViewModel = this.f13301a;
                for (f fVar : a10) {
                    QuestionWAnswers a11 = fVar.a();
                    if (a11 == null || (e10 = a11.e()) == null) {
                        str = null;
                    } else {
                        str = e10.getName();
                    }
                    if (j.b(str, MatchPreferenceQuestions.f34559g.b())) {
                        t j10 = matchPreferencesViewModel.f13289f;
                        QuestionWAnswers a12 = fVar.a();
                        j.d(a12);
                        j10.m(a12);
                    } else if (j.b(str, MatchPreferenceQuestions.f34560h.b())) {
                        t g10 = matchPreferencesViewModel.f13291h;
                        QuestionWAnswers a13 = fVar.a();
                        j.d(a13);
                        g10.m(a13);
                    } else if (j.b(str, MatchPreferenceQuestions.f34556d.b())) {
                        t i10 = matchPreferencesViewModel.f13295l;
                        QuestionWAnswers a14 = fVar.a();
                        j.d(a14);
                        i10.m(a14);
                    } else if (j.b(str, MatchPreferenceQuestions.f34555c.b())) {
                        t l10 = matchPreferencesViewModel.f13293j;
                        QuestionWAnswers a15 = fVar.a();
                        j.d(a15);
                        l10.m(a15);
                    } else if (j.b(str, MatchPreferenceQuestions.f34558f.b())) {
                        QuestionWAnswers a16 = fVar.a();
                        j.d(a16);
                        matchPreferencesViewModel.f13297n.m(new Pair(a16, kotlin.coroutines.jvm.internal.a.a(aVar.d().x())));
                    } else if (j.b(str, MatchPreferenceQuestions.f34557e.b())) {
                        QuestionWAnswers a17 = fVar.a();
                        j.d(a17);
                        matchPreferencesViewModel.f13299p.m(new Pair(a17, kotlin.coroutines.jvm.internal.a.a(aVar.d().x())));
                    }
                }
                return Unit.f32013a;
            }
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(getMatchPreferencesUseCase, this, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                b<GetMatchPreferencesUseCase.a> G = kotlinx.coroutines.flow.d.G(kotlinx.coroutines.reactive.c.a(getMatchPreferencesUseCase.m()), 1);
                a aVar = new a(this);
                this.label = 1;
                if (G.a(aVar, this) == d10) {
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

    public MatchPreferencesViewModel(final GetMatchPreferencesUseCase getMatchPreferencesUseCase, a aVar, SaveAnswerUseCase saveAnswerUseCase) {
        j.g(getMatchPreferencesUseCase, "getMatchPreferencesUseCase");
        j.g(aVar, "coachmarkManager");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13287d = aVar;
        this.f13288e = saveAnswerUseCase;
        t<QuestionWAnswers> tVar = new t<>();
        this.f13289f = tVar;
        this.f13290g = tVar;
        t<QuestionWAnswers> tVar2 = new t<>();
        this.f13291h = tVar2;
        this.f13292i = tVar2;
        t<QuestionWAnswers> tVar3 = new t<>();
        this.f13293j = tVar3;
        this.f13294k = tVar3;
        t<QuestionWAnswers> tVar4 = new t<>();
        this.f13295l = tVar4;
        this.f13296m = tVar4;
        t<Pair<QuestionWAnswers, Boolean>> tVar5 = new t<>();
        this.f13297n = tVar5;
        this.f13298o = tVar5;
        t<Pair<QuestionWAnswers, Boolean>> tVar6 = new t<>();
        this.f13299p = tVar6;
        this.f13300q = tVar6;
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final LiveData<QuestionWAnswers> m() {
        return this.f13292i;
    }

    public final LiveData<Pair<QuestionWAnswers, Boolean>> n() {
        return this.f13298o;
    }

    public final LiveData<QuestionWAnswers> o() {
        return this.f13296m;
    }

    public final LiveData<QuestionWAnswers> p() {
        return this.f13290g;
    }

    public final LiveData<Pair<QuestionWAnswers, Boolean>> q() {
        return this.f13300q;
    }

    public final LiveData<QuestionWAnswers> r() {
        return this.f13294k;
    }

    public final void s(Pair<Float, Float> pair) {
        j.g(pair, "range");
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new MatchPreferencesViewModel$saveAgeRange$1(this, this.f13292i.f(), pair, (c<? super MatchPreferencesViewModel$saveAgeRange$1>) null), 3, (Object) null);
    }

    public final void t(int i10) {
        QuestionWAnswers questionWAnswers;
        Pair f10 = this.f13298o.f();
        if (f10 != null) {
            questionWAnswers = (QuestionWAnswers) f10.c();
        } else {
            questionWAnswers = null;
        }
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new MatchPreferencesViewModel$saveDistancePreferences$1(this, questionWAnswers, i10, (c<? super MatchPreferencesViewModel$saveDistancePreferences$1>) null), 3, (Object) null);
    }

    public final void u(List<String> list) {
        j.g(list, "optionIds");
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new MatchPreferencesViewModel$saveEthnicityPreferences$1(this, list, this.f13296m.f(), (c<? super MatchPreferencesViewModel$saveEthnicityPreferences$1>) null), 3, (Object) null);
    }

    public final void v(String str) {
        j.g(str, "optionId");
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new MatchPreferencesViewModel$saveGenderPreferences$1(this, str, this.f13290g.f(), (c<? super MatchPreferencesViewModel$saveGenderPreferences$1>) null), 3, (Object) null);
    }

    public final void w(Pair<Float, Float> pair) {
        QuestionWAnswers questionWAnswers;
        j.g(pair, "range");
        Pair f10 = this.f13300q.f();
        if (f10 != null) {
            questionWAnswers = (QuestionWAnswers) f10.c();
        } else {
            questionWAnswers = null;
        }
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new MatchPreferencesViewModel$saveHeight$1(this, questionWAnswers, pair, (c<? super MatchPreferencesViewModel$saveHeight$1>) null), 3, (Object) null);
    }

    public final void x(List<String> list) {
        j.g(list, "optionIds");
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new MatchPreferencesViewModel$saveReligionPreferences$1(this, list, this.f13294k.f(), (c<? super MatchPreferencesViewModel$saveReligionPreferences$1>) null), 3, (Object) null);
    }

    public final void y() {
        this.f13287d.b("has_seen_pass_flow");
    }
}
