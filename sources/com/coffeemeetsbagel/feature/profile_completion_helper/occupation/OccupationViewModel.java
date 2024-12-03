package com.coffeemeetsbagel.feature.profile_completion_helper.occupation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

public final class OccupationViewModel extends f0 {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final SaveAnswerUseCase f13332d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final t<List<QuestionWAnswers>> f13333e;

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<List<QuestionWAnswers>> f13334f;

    @d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel$1", f = "OccupationViewModel.kt", l = {73, 33}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel$1$a */
        static final class a<T> implements kotlinx.coroutines.flow.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ OccupationViewModel f13335a;

            a(OccupationViewModel occupationViewModel) {
                this.f13335a = occupationViewModel;
            }

            /* renamed from: a */
            public final Object c(List<QuestionWAnswers> list, c<? super Unit> cVar) {
                this.f13335a.f13333e.m(list);
                return Unit.f32013a;
            }
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(userRepository, iVar, this, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A[Catch:{ all -> 0x0044 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
                int r1 = r12.label
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L_0x0047
                if (r1 == r4) goto L_0x002f
                if (r1 != r2) goto L_0x0027
                java.lang.Object r1 = r12.L$3
                kotlinx.coroutines.channels.f r1 = (kotlinx.coroutines.channels.f) r1
                java.lang.Object r5 = r12.L$2
                kotlinx.coroutines.channels.q r5 = (kotlinx.coroutines.channels.q) r5
                java.lang.Object r6 = r12.L$1
                com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel r6 = (com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel) r6
                java.lang.Object r7 = r12.L$0
                com.coffeemeetsbagel.qna.i r7 = (com.coffeemeetsbagel.qna.i) r7
                gk.g.b(r13)     // Catch:{ all -> 0x0044 }
                r13 = r5
                r5 = r6
                r6 = r1
                r1 = r7
                goto L_0x005d
            L_0x0027:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x002f:
                java.lang.Object r1 = r12.L$3
                kotlinx.coroutines.channels.f r1 = (kotlinx.coroutines.channels.f) r1
                java.lang.Object r5 = r12.L$2
                kotlinx.coroutines.channels.q r5 = (kotlinx.coroutines.channels.q) r5
                java.lang.Object r6 = r12.L$1
                com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel r6 = (com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel) r6
                java.lang.Object r7 = r12.L$0
                com.coffeemeetsbagel.qna.i r7 = (com.coffeemeetsbagel.qna.i) r7
                gk.g.b(r13)     // Catch:{ all -> 0x0044 }
                r8 = r12
                goto L_0x0076
            L_0x0044:
                r13 = move-exception
                goto L_0x00d3
            L_0x0047:
                gk.g.b(r13)
                com.coffeemeetsbagel.domain.repository.UserRepository r13 = r7
                qj.h r13 = r13.m()
                com.coffeemeetsbagel.qna.i r1 = r8
                com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel r5 = r6
                r6 = 0
                kotlinx.coroutines.channels.q r13 = kotlinx.coroutines.reactive.a.b(r13, r6, r4, r3)
                kotlinx.coroutines.channels.f r6 = r13.iterator()     // Catch:{ all -> 0x00d0 }
            L_0x005d:
                r7 = r12
            L_0x005e:
                r7.L$0 = r1     // Catch:{ all -> 0x00d0 }
                r7.L$1 = r5     // Catch:{ all -> 0x00d0 }
                r7.L$2 = r13     // Catch:{ all -> 0x00d0 }
                r7.L$3 = r6     // Catch:{ all -> 0x00d0 }
                r7.label = r4     // Catch:{ all -> 0x00d0 }
                java.lang.Object r8 = r6.a(r7)     // Catch:{ all -> 0x00d0 }
                if (r8 != r0) goto L_0x006f
                return r0
            L_0x006f:
                r11 = r5
                r5 = r13
                r13 = r8
                r8 = r7
                r7 = r1
                r1 = r6
                r6 = r11
            L_0x0076:
                java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x0044 }
                boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x0044 }
                if (r13 == 0) goto L_0x00ca
                java.lang.Object r13 = r1.next()     // Catch:{ all -> 0x0044 }
                java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0044 }
                java.lang.String r9 = "profileId"
                kotlin.jvm.internal.j.f(r13, r9)     // Catch:{ all -> 0x0044 }
                com.coffeemeetsbagel.models.enums.ProfileQuestion r9 = com.coffeemeetsbagel.models.enums.ProfileQuestion.OCCUPATION     // Catch:{ all -> 0x0044 }
                java.lang.String r9 = r9.getApiKey()     // Catch:{ all -> 0x0044 }
                qj.h r9 = r7.a(r13, r9)     // Catch:{ all -> 0x0044 }
                kotlinx.coroutines.flow.b r9 = kotlinx.coroutines.reactive.c.a(r9)     // Catch:{ all -> 0x0044 }
                com.coffeemeetsbagel.models.enums.ProfileQuestion r10 = com.coffeemeetsbagel.models.enums.ProfileQuestion.EMPLOYER     // Catch:{ all -> 0x0044 }
                java.lang.String r10 = r10.getApiKey()     // Catch:{ all -> 0x0044 }
                qj.h r13 = r7.a(r13, r10)     // Catch:{ all -> 0x0044 }
                kotlinx.coroutines.flow.b r13 = kotlinx.coroutines.reactive.c.a(r13)     // Catch:{ all -> 0x0044 }
                com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel$1$1$1 r10 = new com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel$1$1$1     // Catch:{ all -> 0x0044 }
                r10.<init>(r3)     // Catch:{ all -> 0x0044 }
                kotlinx.coroutines.flow.b r13 = kotlinx.coroutines.flow.d.j(r9, r13, r10)     // Catch:{ all -> 0x0044 }
                com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel$1$a r9 = new com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel$1$a     // Catch:{ all -> 0x0044 }
                r9.<init>(r6)     // Catch:{ all -> 0x0044 }
                r8.L$0 = r7     // Catch:{ all -> 0x0044 }
                r8.L$1 = r6     // Catch:{ all -> 0x0044 }
                r8.L$2 = r5     // Catch:{ all -> 0x0044 }
                r8.L$3 = r1     // Catch:{ all -> 0x0044 }
                r8.label = r2     // Catch:{ all -> 0x0044 }
                java.lang.Object r13 = r13.a(r9, r8)     // Catch:{ all -> 0x0044 }
                if (r13 != r0) goto L_0x00c4
                return r0
            L_0x00c4:
                r13 = r5
                r5 = r6
                r6 = r1
                r1 = r7
                r7 = r8
                goto L_0x005e
            L_0x00ca:
                kotlinx.coroutines.channels.i.a(r5, r3)
                kotlin.Unit r13 = kotlin.Unit.f32013a
                return r13
            L_0x00d0:
                r0 = move-exception
                r5 = r13
                r13 = r0
            L_0x00d3:
                throw r13     // Catch:{ all -> 0x00d4 }
            L_0x00d4:
                r0 = move-exception
                kotlinx.coroutines.channels.i.a(r5, r13)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.profile_completion_helper.occupation.OccupationViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public OccupationViewModel(final UserRepository userRepository, final i iVar, SaveAnswerUseCase saveAnswerUseCase) {
        j.g(userRepository, "userRepository");
        j.g(iVar, "getQuestionUseCase");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13332d = saveAnswerUseCase;
        t<List<QuestionWAnswers>> tVar = new t<>();
        this.f13333e = tVar;
        this.f13334f = tVar;
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final void h(g gVar, String str, String str2) {
        QuestionWAnswers questionWAnswers;
        QuestionWAnswers questionWAnswers2;
        j.g(gVar, "lifecycleCoroutineScope");
        j.g(str, "occupationText");
        j.g(str2, "employerText");
        List f10 = this.f13334f.f();
        if (f10 != null) {
            questionWAnswers = (QuestionWAnswers) f10.get(0);
        } else {
            questionWAnswers = null;
        }
        List f11 = this.f13334f.f();
        if (f11 != null) {
            questionWAnswers2 = (QuestionWAnswers) f11.get(1);
        } else {
            questionWAnswers2 = null;
        }
        s1 unused = j.d(gVar, (CoroutineContext) null, (CoroutineStart) null, new OccupationViewModel$saveAnswers$1(this, str, questionWAnswers, str2, questionWAnswers2, (c<? super OccupationViewModel$saveAnswers$1>) null), 3, (Object) null);
    }
}
