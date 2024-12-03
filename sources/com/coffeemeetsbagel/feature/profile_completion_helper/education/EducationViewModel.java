package com.coffeemeetsbagel.feature.profile_completion_helper.education;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.School;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import fa.a;
import gk.g;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import qj.b0;
import qj.h;
import qj.w;

public final class EducationViewModel extends f0 {

    /* renamed from: d  reason: collision with root package name */
    private final QuestionRepository f13212d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final SaveAnswerUseCase f13213e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f13214f = EducationViewModel.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final t<List<School>> f13215g;

    /* renamed from: h  reason: collision with root package name */
    private final LiveData<List<School>> f13216h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final t<Pair<List<QuestionWAnswers>, List<QuestionWAnswers>>> f13217i;

    /* renamed from: j  reason: collision with root package name */
    private final LiveData<Pair<List<QuestionWAnswers>, List<QuestionWAnswers>>> f13218j;

    @d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.education.EducationViewModel$1", f = "EducationViewModel.kt", l = {44}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.education.EducationViewModel$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.education.EducationViewModel$1$a */
        static final class a<T> implements kotlinx.coroutines.flow.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EducationViewModel f13219a;

            a(EducationViewModel educationViewModel) {
                this.f13219a = educationViewModel;
            }

            /* renamed from: a */
            public final Object c(List<School> list, c<? super Unit> cVar) {
                this.f13219a.f13215g.m(list);
                return Unit.f32013a;
            }
        }

        /* access modifiers changed from: private */
        public static final b0 k(Function1 function1, Object obj) {
            return (b0) function1.invoke(obj);
        }

        /* access modifiers changed from: private */
        public static final void m(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(getSingleSchoolsUseCase, userRepository, this, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                h<List<School>> O = getSingleSchoolsUseCase.b().O();
                j.f(O, "getSingleSchoolsUseCase.invoke().toFlowable()");
                b<List<School>> a10 = kotlinx.coroutines.reactive.c.a(O);
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
            w<String> L = userRepository.m().L();
            final EducationViewModel educationViewModel = this;
            w<R> v10 = L.v(new g(new Function1<String, b0<? extends Pair<? extends List<? extends QuestionWAnswers>, ? extends List<? extends QuestionWAnswers>>>>() {
                /* renamed from: a */
                public final b0<? extends Pair<List<QuestionWAnswers>, List<QuestionWAnswers>>> invoke(String str) {
                    j.g(str, "profileId");
                    return educationViewModel.l(str);
                }
            }));
            final EducationViewModel educationViewModel2 = this;
            v10.c(new h(new Function1<Pair<? extends List<? extends QuestionWAnswers>, ? extends List<? extends QuestionWAnswers>>, Unit>() {
                public final void a(Pair<? extends List<QuestionWAnswers>, ? extends List<QuestionWAnswers>> pair) {
                    educationViewModel2.f13217i.m(pair);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((Pair) obj);
                    return Unit.f32013a;
                }
            }));
            return Unit.f32013a;
        }
    }

    public EducationViewModel(final UserRepository userRepository, final GetSingleSchoolsUseCase getSingleSchoolsUseCase, QuestionRepository questionRepository, SaveAnswerUseCase saveAnswerUseCase) {
        j.g(userRepository, "userRepository");
        j.g(getSingleSchoolsUseCase, "getSingleSchoolsUseCase");
        j.g(questionRepository, "questionRepository");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13212d = questionRepository;
        this.f13213e = saveAnswerUseCase;
        t<List<School>> tVar = new t<>();
        this.f13215g = tVar;
        this.f13216h = tVar;
        t<Pair<List<QuestionWAnswers>, List<QuestionWAnswers>>> tVar2 = new t<>();
        this.f13217i = tVar2;
        this.f13218j = tVar2;
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final w<Pair<List<QuestionWAnswers>, List<QuestionWAnswers>>> l(String str) {
        return h.n(QuestionRepository.y(this.f13212d, QuestionGroupType.EDUCATION_ONE, str, false, false, 8, (Object) null), QuestionRepository.y(this.f13212d, QuestionGroupType.EDUCATION_TWO, str, false, false, 8, (Object) null), new f(EducationViewModel$fetchAnswers$1.f13220a)).L();
    }

    /* access modifiers changed from: private */
    public static final Pair m(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    private final void p(androidx.lifecycle.g gVar, List<String> list, String str, String str2, String str3) {
        s1 unused = j.d(gVar, (CoroutineContext) null, (CoroutineStart) null, new EducationViewModel$postAnswerAndSaveToDb$1(this, list, str, str2, str3, (c<? super EducationViewModel$postAnswerAndSaveToDb$1>) null), 3, (Object) null);
    }

    public final LiveData<Pair<List<QuestionWAnswers>, List<QuestionWAnswers>>> n() {
        return this.f13218j;
    }

    public final LiveData<List<School>> o() {
        return this.f13216h;
    }

    public final void q(androidx.lifecycle.g gVar, String str, String str2, String str3, String str4) {
        int i10;
        int i11;
        QuestionWAnswers questionWAnswers;
        QuestionWAnswers questionWAnswers2;
        QuestionWAnswers questionWAnswers3;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        j.g(gVar, "lifecycleScope");
        Pair f10 = this.f13218j.f();
        if (f10 == null || (list6 = (List) f10.c()) == null) {
            i10 = 0;
        } else {
            i10 = list6.size();
        }
        Pair f11 = this.f13218j.f();
        if (f11 == null || (list5 = (List) f11.d()) == null) {
            i11 = 0;
        } else {
            i11 = list5.size();
        }
        if (i10 + i11 == 0) {
            a.C0491a aVar = a.f40771d;
            String str5 = this.f13214f;
            j.f(str5, "tag");
            aVar.b(str5, "No questions present is EDUCATION_ONE and EDUCATION_TWO question groups");
        }
        Pair f12 = this.f13218j.f();
        QuestionWAnswers questionWAnswers4 = null;
        if (f12 == null || (list4 = (List) f12.c()) == null) {
            questionWAnswers = null;
        } else {
            questionWAnswers = (QuestionWAnswers) CollectionsKt___CollectionsKt.Q(list4, 0);
        }
        Pair f13 = this.f13218j.f();
        if (f13 == null || (list3 = (List) f13.d()) == null) {
            questionWAnswers2 = null;
        } else {
            questionWAnswers2 = (QuestionWAnswers) CollectionsKt___CollectionsKt.Q(list3, 0);
        }
        Pair f14 = this.f13218j.f();
        if (f14 == null || (list2 = (List) f14.c()) == null) {
            questionWAnswers3 = null;
        } else {
            questionWAnswers3 = (QuestionWAnswers) CollectionsKt___CollectionsKt.Q(list2, 1);
        }
        Pair f15 = this.f13218j.f();
        if (!(f15 == null || (list = (List) f15.d()) == null)) {
            questionWAnswers4 = (QuestionWAnswers) CollectionsKt___CollectionsKt.Q(list, 1);
        }
        if (str != null) {
            if (questionWAnswers != null) {
                p(gVar, (List<String>) null, str, questionWAnswers.e().getId(), questionWAnswers.e().getGroup().getQuestionGroupApiString());
                Unit unit = Unit.f32013a;
            } else {
                new EducationViewModel$saveAnswers$1$2(this);
            }
        }
        if (str2 != null) {
            if (questionWAnswers3 != null) {
                p(gVar, (List<String>) null, str2, questionWAnswers3.e().getId(), questionWAnswers3.e().getGroup().getQuestionGroupApiString());
                Unit unit2 = Unit.f32013a;
            } else {
                new EducationViewModel$saveAnswers$2$2(this);
            }
        }
        if (str3 != null) {
            if (questionWAnswers2 != null) {
                p(gVar, p.e(str3), (String) null, questionWAnswers2.e().getId(), questionWAnswers2.e().getGroup().getQuestionGroupApiString());
                Unit unit3 = Unit.f32013a;
            } else {
                new EducationViewModel$saveAnswers$3$2(this);
            }
        }
        if (str4 == null) {
            return;
        }
        if (questionWAnswers4 != null) {
            p(gVar, p.e(str4), (String) null, questionWAnswers4.e().getId(), questionWAnswers4.e().getGroup().getQuestionGroupApiString());
            Unit unit4 = Unit.f32013a;
            return;
        }
        new EducationViewModel$saveAnswers$4$2(this);
    }
}
