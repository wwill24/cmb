package com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;
import gk.g;
import ja.b;
import java.util.List;
import java.util.Optional;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import qj.h;

public final class EthnicityViewModel extends f0 {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final SaveAnswerUseCase f13245d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final t<QuestionWAnswers> f13246e;

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<QuestionWAnswers> f13247f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f13248g = "EthnicityViewModel";

    @d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$1", f = "EthnicityViewModel.kt", l = {34}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$1$a */
        static final class a<T> implements kotlinx.coroutines.flow.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EthnicityViewModel f13249a;

            a(EthnicityViewModel ethnicityViewModel) {
                this.f13249a = ethnicityViewModel;
            }

            /* renamed from: a */
            public final Object c(Optional<QuestionWAnswers> optional, c<? super Unit> cVar) {
                this.f13249a.f13246e.m(optional.get());
                return Unit.f32013a;
            }
        }

        /* access modifiers changed from: private */
        public static final Optional j(Function1 function1, Object obj) {
            return (Optional) function1.invoke(obj);
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(userRepository, iVar, this, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                h<b> p10 = userRepository.p();
                final i iVar = iVar;
                h<R> Y = p10.Y(new c(new Function1<b, Optional<QuestionWAnswers>>() {
                    /* renamed from: a */
                    public final Optional<QuestionWAnswers> invoke(b bVar) {
                        j.g(bVar, "it");
                        return iVar.a(bVar.u(), ProfileQuestion.ETHNICITY.getApiKey()).h();
                    }
                }));
                j.f(Y, "getQuestionUseCase: GetQ…kingFirst()\n            }");
                kotlinx.coroutines.flow.b<R> a10 = kotlinx.coroutines.reactive.c.a(Y);
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

    public EthnicityViewModel(final UserRepository userRepository, final i iVar, SaveAnswerUseCase saveAnswerUseCase) {
        j.g(userRepository, "userRepository");
        j.g(iVar, "getQuestionUseCase");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13245d = saveAnswerUseCase;
        t<QuestionWAnswers> tVar = new t<>();
        this.f13246e = tVar;
        this.f13247f = tVar;
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(java.util.List<java.lang.String> r11, java.lang.String r12, java.lang.String r13, kotlin.coroutines.c<? super tj.b> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$save$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$save$1 r0 = (com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$save$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$save$1 r0 = new com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$save$1
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            gk.g.b(r14)
            goto L_0x004c
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            gk.g.b(r14)
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.x0.b()
            com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$save$2 r2 = new com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel$save$2
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.label = r3
            java.lang.Object r14 = kotlinx.coroutines.h.g(r14, r2, r0)
            if (r14 != r1) goto L_0x004c
            return r1
        L_0x004c:
            java.lang.String r11 = "private suspend fun save…le) }\n            )\n    }"
            kotlin.jvm.internal.j.f(r14, r11)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel.k(java.util.List, java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public final LiveData<QuestionWAnswers> j() {
        return this.f13247f;
    }

    public final void l(List<String> list) {
        j.g(list, "optionIds");
        QuestionWAnswers f10 = this.f13247f.f();
        j.d(f10);
        String id2 = f10.e().getId();
        QuestionWAnswers f11 = this.f13247f.f();
        j.d(f11);
        String questionGroupApiString = f11.e().getGroup().getQuestionGroupApiString();
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new EthnicityViewModel$saveAnswers$1(this, list, id2, questionGroupApiString, (c<? super EthnicityViewModel$saveAnswers$1>) null), 3, (Object) null);
    }
}
