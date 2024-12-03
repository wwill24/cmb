package com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.j;
import fa.a;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

public final class IcebreakersViewModel extends f0 {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final SaveAnswerUseCase f13259d;

    /* renamed from: e  reason: collision with root package name */
    private final String f13260e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final t<List<QuestionWAnswers>> f13261f;

    /* renamed from: g  reason: collision with root package name */
    private final LiveData<List<QuestionWAnswers>> f13262g;

    @d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.IcebreakersViewModel$1", f = "IcebreakersViewModel.kt", l = {88, 97}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.IcebreakersViewModel$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(userRepository, jVar, this, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x008f A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0098 A[Catch:{ all -> 0x00f9, all -> 0x0105 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00d2 A[Catch:{ all -> 0x0034 }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00db A[Catch:{ all -> 0x0034 }] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00ed A[SYNTHETIC, Splitter:B:40:0x00ed] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r1 = r19
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
                int r2 = r1.label
                r3 = 0
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L_0x005f
                if (r2 == r5) goto L_0x0040
                if (r2 != r4) goto L_0x0038
                java.lang.Object r2 = r1.L$5
                kotlinx.coroutines.channels.f r2 = (kotlinx.coroutines.channels.f) r2
                java.lang.Object r7 = r1.L$4
                kotlinx.coroutines.channels.q r7 = (kotlinx.coroutines.channels.q) r7
                java.lang.Object r8 = r1.L$3
                kotlinx.coroutines.channels.f r8 = (kotlinx.coroutines.channels.f) r8
                java.lang.Object r9 = r1.L$2
                kotlinx.coroutines.channels.q r9 = (kotlinx.coroutines.channels.q) r9
                java.lang.Object r10 = r1.L$1
                com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.IcebreakersViewModel r10 = (com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.IcebreakersViewModel) r10
                java.lang.Object r11 = r1.L$0
                com.coffeemeetsbagel.qna.j r11 = (com.coffeemeetsbagel.qna.j) r11
                gk.g.b(r20)     // Catch:{ all -> 0x0034 }
                r13 = r20
                r12 = r11
                r11 = r10
                r10 = r1
                goto L_0x00d3
            L_0x0034:
                r0 = move-exception
                r2 = r0
                goto L_0x00f8
            L_0x0038:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0040:
                java.lang.Object r2 = r1.L$3
                kotlinx.coroutines.channels.f r2 = (kotlinx.coroutines.channels.f) r2
                java.lang.Object r7 = r1.L$2
                kotlinx.coroutines.channels.q r7 = (kotlinx.coroutines.channels.q) r7
                java.lang.Object r8 = r1.L$1
                com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.IcebreakersViewModel r8 = (com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.IcebreakersViewModel) r8
                java.lang.Object r9 = r1.L$0
                com.coffeemeetsbagel.qna.j r9 = (com.coffeemeetsbagel.qna.j) r9
                gk.g.b(r20)     // Catch:{ all -> 0x005c }
                r11 = r20
                r10 = r1
            L_0x0056:
                r18 = r9
                r9 = r7
                r7 = r18
                goto L_0x0090
            L_0x005c:
                r0 = move-exception
                goto L_0x010b
            L_0x005f:
                gk.g.b(r20)
                com.coffeemeetsbagel.domain.repository.UserRepository r2 = r7
                qj.h r2 = r2.p()
                com.coffeemeetsbagel.qna.j r7 = r8
                com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.IcebreakersViewModel r8 = r6
                kotlinx.coroutines.channels.q r2 = kotlinx.coroutines.reactive.a.b(r2, r3, r5, r6)
                kotlinx.coroutines.channels.f r9 = r2.iterator()     // Catch:{ all -> 0x0109 }
                r10 = r1
                r18 = r7
                r7 = r2
                r2 = r9
                r9 = r18
            L_0x007b:
                r10.L$0 = r9     // Catch:{ all -> 0x005c }
                r10.L$1 = r8     // Catch:{ all -> 0x005c }
                r10.L$2 = r7     // Catch:{ all -> 0x005c }
                r10.L$3 = r2     // Catch:{ all -> 0x005c }
                r10.L$4 = r6     // Catch:{ all -> 0x005c }
                r10.L$5 = r6     // Catch:{ all -> 0x005c }
                r10.label = r5     // Catch:{ all -> 0x005c }
                java.lang.Object r11 = r2.a(r10)     // Catch:{ all -> 0x005c }
                if (r11 != r0) goto L_0x0056
                return r0
            L_0x0090:
                java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0105 }
                boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0105 }
                if (r11 == 0) goto L_0x00ff
                java.lang.Object r11 = r2.next()     // Catch:{ all -> 0x0105 }
                ja.b r11 = (ja.b) r11     // Catch:{ all -> 0x0105 }
                java.lang.String r13 = r11.u()     // Catch:{ all -> 0x0105 }
                com.coffeemeetsbagel.models.enums.QuestionGroupType r14 = com.coffeemeetsbagel.models.enums.QuestionGroupType.ICEBREAKERS     // Catch:{ all -> 0x0105 }
                r15 = 0
                r16 = 4
                r17 = 0
                r12 = r7
                qj.h r11 = com.coffeemeetsbagel.qna.j.b(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0105 }
                kotlinx.coroutines.channels.q r11 = kotlinx.coroutines.reactive.a.b(r11, r3, r5, r6)     // Catch:{ all -> 0x0105 }
                kotlinx.coroutines.channels.f r12 = r11.iterator()     // Catch:{ all -> 0x00f5 }
                r18 = r8
                r8 = r2
                r2 = r12
                r12 = r7
                r7 = r11
                r11 = r18
            L_0x00be:
                r10.L$0 = r12     // Catch:{ all -> 0x0034 }
                r10.L$1 = r11     // Catch:{ all -> 0x0034 }
                r10.L$2 = r9     // Catch:{ all -> 0x0034 }
                r10.L$3 = r8     // Catch:{ all -> 0x0034 }
                r10.L$4 = r7     // Catch:{ all -> 0x0034 }
                r10.L$5 = r2     // Catch:{ all -> 0x0034 }
                r10.label = r4     // Catch:{ all -> 0x0034 }
                java.lang.Object r13 = r2.a(r10)     // Catch:{ all -> 0x0034 }
                if (r13 != r0) goto L_0x00d3
                return r0
            L_0x00d3:
                java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x0034 }
                boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x0034 }
                if (r13 == 0) goto L_0x00ed
                java.lang.Object r13 = r2.next()     // Catch:{ all -> 0x0034 }
                ab.a r13 = (ab.a) r13     // Catch:{ all -> 0x0034 }
                androidx.lifecycle.t r14 = r11.f13261f     // Catch:{ all -> 0x0034 }
                java.util.List r13 = r13.b()     // Catch:{ all -> 0x0034 }
                r14.m(r13)     // Catch:{ all -> 0x0034 }
                goto L_0x00be
            L_0x00ed:
                kotlinx.coroutines.channels.i.a(r7, r6)     // Catch:{ all -> 0x0105 }
                r2 = r8
                r7 = r9
                r8 = r11
                r9 = r12
                goto L_0x007b
            L_0x00f5:
                r0 = move-exception
                r2 = r0
                r7 = r11
            L_0x00f8:
                throw r2     // Catch:{ all -> 0x00f9 }
            L_0x00f9:
                r0 = move-exception
                r3 = r0
                kotlinx.coroutines.channels.i.a(r7, r2)     // Catch:{ all -> 0x0105 }
                throw r3     // Catch:{ all -> 0x0105 }
            L_0x00ff:
                kotlinx.coroutines.channels.i.a(r9, r6)
                kotlin.Unit r0 = kotlin.Unit.f32013a
                return r0
            L_0x0105:
                r0 = move-exception
                r2 = r0
                r7 = r9
                goto L_0x010c
            L_0x0109:
                r0 = move-exception
                r7 = r2
            L_0x010b:
                r2 = r0
            L_0x010c:
                throw r2     // Catch:{ all -> 0x010d }
            L_0x010d:
                r0 = move-exception
                r3 = r0
                kotlinx.coroutines.channels.i.a(r7, r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.IcebreakersViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public IcebreakersViewModel(final UserRepository userRepository, final j jVar, SaveAnswerUseCase saveAnswerUseCase) {
        kotlin.jvm.internal.j.g(userRepository, "userRepository");
        kotlin.jvm.internal.j.g(jVar, "getQuestionGroup");
        kotlin.jvm.internal.j.g(saveAnswerUseCase, "saveAnswerUseCase");
        this.f13259d = saveAnswerUseCase;
        String simpleName = IcebreakersViewModel.class.getSimpleName();
        kotlin.jvm.internal.j.f(simpleName, "IcebreakersViewModel::class.java.simpleName");
        this.f13260e = simpleName;
        t<List<QuestionWAnswers>> tVar = new t<>();
        this.f13261f = tVar;
        this.f13262g = tVar;
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
    }

    private final void i(g gVar, String str, String str2, String str3) {
        s1 unused = j.d(gVar, (CoroutineContext) null, (CoroutineStart) null, new IcebreakersViewModel$postAnswerAndSaveToDb$1(this, str, str2, str3, (c<? super IcebreakersViewModel$postAnswerAndSaveToDb$1>) null), 3, (Object) null);
    }

    public final LiveData<List<QuestionWAnswers>> h() {
        return this.f13262g;
    }

    public final void j(g gVar, List<String> list) {
        int i10;
        Integer num;
        kotlin.jvm.internal.j.g(gVar, "activityScope");
        kotlin.jvm.internal.j.g(list, "answers");
        List f10 = this.f13262g.f();
        int i11 = 0;
        if (f10 != null) {
            i10 = f10.size();
        } else {
            i10 = 0;
        }
        if (i10 < list.size()) {
            a.C0491a aVar = a.f40771d;
            String str = this.f13260e;
            List f11 = this.f13262g.f();
            if (f11 != null) {
                num = Integer.valueOf(f11.size());
            } else {
                num = null;
            }
            aVar.b(str, "Only have: " + num + " Questions in the Icebreakers group.");
        }
        for (T next : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                q.s();
            }
            String str2 = (String) next;
            List f12 = this.f13262g.f();
            if (f12 != null) {
                kotlin.jvm.internal.j.f(f12, "value");
                QuestionWAnswers questionWAnswers = (QuestionWAnswers) CollectionsKt___CollectionsKt.Q(f12, i11);
                if (questionWAnswers != null) {
                    i(gVar, str2, questionWAnswers.e().getId(), questionWAnswers.e().getGroup().getQuestionGroupApiString());
                }
            }
            i11 = i12;
        }
    }
}
