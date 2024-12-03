package com.coffeemeetsbagel.feature.profile_completion_helper;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.feature.profile_completion_helper.education.EducationFragment;
import com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityFragment;
import com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences.MatchPreferencesFragment;
import com.coffeemeetsbagel.feature.profile_completion_helper.religion.ReligionFragment;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.j;
import f8.n;
import gk.g;
import ja.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

public class ProfileCompletionHelperViewModel extends f0 {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final j f13182d;

    /* renamed from: e  reason: collision with root package name */
    private final a6.a f13183e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final t<List<QuestionWAnswers>> f13184f;

    /* renamed from: g  reason: collision with root package name */
    private final LiveData<List<QuestionWAnswers>> f13185g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final t<Pair<b, l>> f13186h;

    /* renamed from: i  reason: collision with root package name */
    private final LiveData<Pair<b, l>> f13187i;

    /* renamed from: j  reason: collision with root package name */
    private final t<List<Photo>> f13188j = new t<>();

    @d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperViewModel$1", f = "ProfileCompletionHelperViewModel.kt", l = {46}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperViewModel$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperViewModel$1$a */
        static final class a<T> implements kotlinx.coroutines.flow.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ProfileCompletionHelperViewModel f13189a;

            a(ProfileCompletionHelperViewModel profileCompletionHelperViewModel) {
                this.f13189a = profileCompletionHelperViewModel;
            }

            /* renamed from: a */
            public final Object c(Triple<b, l, ? extends List<Photo>> triple, c<? super Unit> cVar) {
                this.f13189a.f13186h.m(new Pair(triple.a(), triple.b()));
                Object i10 = this.f13189a.m(triple.a().u(), cVar);
                if (i10 == b.d()) {
                    return i10;
                }
                return Unit.f32013a;
            }
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(getMyOwnProfileLocalUseCase, this, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                kotlinx.coroutines.flow.b<Triple<b, l, List<Photo>>> a10 = kotlinx.coroutines.reactive.c.a(getMyOwnProfileLocalUseCase.c());
                a aVar = new a(this);
                this.label = 1;
                if (a10.a(aVar, this) == d10) {
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

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f13190a;

        /* renamed from: b  reason: collision with root package name */
        private final long f13191b;

        public a(Fragment fragment, long j10) {
            kotlin.jvm.internal.j.g(fragment, "fragmentProvider");
            this.f13190a = fragment;
            this.f13191b = j10;
        }

        public final Fragment a() {
            return this.f13190a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.j.b(this.f13190a, aVar.f13190a) && this.f13191b == aVar.f13191b;
        }

        public int hashCode() {
            return (this.f13190a.hashCode() * 31) + Long.hashCode(this.f13191b);
        }

        public String toString() {
            Fragment fragment = this.f13190a;
            long j10 = this.f13191b;
            return "FragmentInformation(fragmentProvider=" + fragment + ", itemId=" + j10 + ")";
        }
    }

    public ProfileCompletionHelperViewModel(final GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase, j jVar, a6.a aVar) {
        kotlin.jvm.internal.j.g(getMyOwnProfileLocalUseCase, "getMyOwnProfileUseCase");
        kotlin.jvm.internal.j.g(jVar, "getQuestionGroupWQuestions");
        kotlin.jvm.internal.j.g(aVar, "coachmarkManager");
        this.f13182d = jVar;
        this.f13183e = aVar;
        t<List<QuestionWAnswers>> tVar = new t<>();
        this.f13184f = tVar;
        this.f13185g = tVar;
        t<Pair<b, l>> tVar2 = new t<>();
        this.f13186h = tVar2;
        this.f13187i = tVar2;
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object m(String str, c<? super Unit> cVar) {
        Object g10 = h.g(x0.b(), new ProfileCompletionHelperViewModel$loadQuestions$2(this, str, (c<? super ProfileCompletionHelperViewModel$loadQuestions$2>) null), cVar);
        return g10 == b.d() ? g10 : Unit.f32013a;
    }

    public final LiveData<List<QuestionWAnswers>> j() {
        return this.f13185g;
    }

    public final LiveData<Pair<b, l>> k() {
        return this.f13187i;
    }

    public final List<a> l(List<QuestionWAnswers> list, boolean z10) {
        kotlin.jvm.internal.j.g(list, "questionsList");
        ArrayList arrayList = new ArrayList();
        boolean a10 = this.f13183e.a("has_seen_like_flow");
        boolean a11 = this.f13183e.a("has_seen_pass_flow");
        if (!z10 && !a11) {
            arrayList.add(new a(MatchPreferencesFragment.f13273m.a(true), (long) MatchPreferencesFragment.class.hashCode()));
        }
        if (this.f13188j.f() != null) {
            List<Photo> f10 = this.f13188j.f();
            kotlin.jvm.internal.j.d(f10);
            if (f10.isEmpty() && !a10) {
                n B1 = n.B1();
                kotlin.jvm.internal.j.f(B1, "newInstanceOnboarding()");
                arrayList.add(new a(B1, (long) n.class.getName().hashCode()));
            }
        }
        for (QuestionWAnswers e10 : list) {
            String name = e10.e().getName();
            if (kotlin.jvm.internal.j.b(name, ProfileQuestion.ETHNICITY.getApiKey())) {
                arrayList.add(new a(EthnicityFragment.f13236f.a(), (long) EthnicityFragment.class.hashCode()));
            } else if (kotlin.jvm.internal.j.b(name, ProfileQuestion.RELIGION.getApiKey())) {
                arrayList.add(new a(ReligionFragment.f13343g.a(), (long) ReligionFragment.class.hashCode()));
            } else if (kotlin.jvm.internal.j.b(name, ProfileQuestion.SCHOOL_ONE.getApiKey())) {
                arrayList.add(new a(EducationFragment.f13199g.a(), (long) EducationFragment.class.hashCode()));
            } else if (kotlin.jvm.internal.j.b(name, ProfileQuestion.OCCUPATION.getApiKey())) {
                arrayList.add(new a(com.coffeemeetsbagel.feature.profile_completion_helper.occupation.a.f13336d.a(), (long) com.coffeemeetsbagel.feature.profile_completion_helper.occupation.a.class.hashCode()));
            } else if (kotlin.jvm.internal.j.b(name, ProfileQuestion.ICEBREAKER_ONE.getApiKey())) {
                arrayList.add(new a(com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.a.f13263d.a(), (long) com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.a.class.hashCode()));
            }
        }
        if (z10 && !a11) {
            arrayList.add(new a(MatchPreferencesFragment.f13273m.a(false), (long) MatchPreferencesFragment.class.hashCode()));
        }
        return arrayList;
    }

    public final void n() {
        this.f13183e.b("has_completed_like_flow");
    }
}
