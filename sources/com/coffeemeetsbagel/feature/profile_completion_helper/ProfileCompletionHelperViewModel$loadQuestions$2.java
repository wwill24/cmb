package com.coffeemeetsbagel.feature.profile_completion_helper;

import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import gk.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;
import pk.p;

@d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperViewModel$loadQuestions$2", f = "ProfileCompletionHelperViewModel.kt", l = {127}, m = "invokeSuspend")
final class ProfileCompletionHelperViewModel$loadQuestions$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ String $profileId;
    int label;
    final /* synthetic */ ProfileCompletionHelperViewModel this$0;

    @d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperViewModel$loadQuestions$2$1", f = "ProfileCompletionHelperViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperViewModel$loadQuestions$2$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements p<ab.a, ab.a, ab.a, ab.a, c<? super List<QuestionWAnswers>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        /* synthetic */ Object L$3;
        int label;

        /* renamed from: i */
        public final Object v(ab.a aVar, ab.a aVar2, ab.a aVar3, ab.a aVar4, c<? super List<QuestionWAnswers>> cVar) {
            AnonymousClass1 r02 = new AnonymousClass1(cVar);
            r02.L$0 = aVar;
            r02.L$1 = aVar2;
            r02.L$2 = aVar3;
            r02.L$3 = aVar4;
            return r02.invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            boolean z10;
            boolean z11;
            boolean z12;
            Object unused = b.d();
            if (this.label == 0) {
                g.b(obj);
                ab.a aVar = (ab.a) this.L$0;
                ab.a aVar2 = (ab.a) this.L$1;
                ab.a aVar3 = (ab.a) this.L$2;
                ab.a aVar4 = (ab.a) this.L$3;
                ArrayList arrayList = new ArrayList();
                List<QuestionWAnswers> b10 = aVar.b();
                ArrayList<QuestionWAnswers> arrayList2 = new ArrayList<>();
                Iterator<T> it = b10.iterator();
                while (true) {
                    boolean z13 = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    String name = ((QuestionWAnswers) next).e().getName();
                    if (j.b(name, ProfileQuestion.ETHNICITY.getApiKey()) || j.b(name, ProfileQuestion.RELIGION.getApiKey())) {
                        z13 = true;
                    }
                    if (z13) {
                        arrayList2.add(next);
                    }
                }
                for (QuestionWAnswers questionWAnswers : arrayList2) {
                    if (questionWAnswers.d().isEmpty()) {
                        arrayList.add(questionWAnswers);
                    }
                }
                List<QuestionWAnswers> b11 = aVar2.b();
                ArrayList arrayList3 = new ArrayList();
                for (T next2 : b11) {
                    if (((QuestionWAnswers) next2).e().getGroup() == QuestionGroupType.EDUCATION_ONE) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        arrayList3.add(next2);
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                for (Object next3 : arrayList3) {
                    if (((QuestionWAnswers) next3).d().isEmpty()) {
                        arrayList4.add(next3);
                    }
                }
                int size = arrayList4.size();
                List<QuestionWAnswers> b12 = aVar3.b();
                ArrayList arrayList5 = new ArrayList();
                for (T next4 : b12) {
                    if (((QuestionWAnswers) next4).e().getGroup() == QuestionGroupType.EDUCATION_TWO) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        arrayList5.add(next4);
                    }
                }
                ArrayList arrayList6 = new ArrayList();
                for (Object next5 : arrayList5) {
                    if (((QuestionWAnswers) next5).d().isEmpty()) {
                        arrayList6.add(next5);
                    }
                }
                int size2 = arrayList6.size();
                if (size >= 1 && size2 >= 1) {
                    arrayList.add(aVar2.b().get(0));
                }
                List<QuestionWAnswers> b13 = aVar.b();
                ArrayList arrayList7 = new ArrayList();
                for (T next6 : b13) {
                    QuestionWAnswers questionWAnswers2 = (QuestionWAnswers) next6;
                    if (!j.b(questionWAnswers2.e().getName(), ProfileQuestion.OCCUPATION.getApiKey()) || !questionWAnswers2.d().isEmpty()) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        arrayList7.add(next6);
                    }
                }
                if (!arrayList7.isEmpty()) {
                    arrayList.addAll(arrayList7);
                }
                List<QuestionWAnswers> b14 = aVar4.b();
                ArrayList arrayList8 = new ArrayList();
                for (T next7 : b14) {
                    if (((QuestionWAnswers) next7).d().isEmpty()) {
                        arrayList8.add(next7);
                    }
                }
                if (!arrayList8.isEmpty()) {
                    arrayList.add(aVar4.b().get(0));
                }
                return arrayList;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class a<T> implements kotlinx.coroutines.flow.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProfileCompletionHelperViewModel f13192a;

        a(ProfileCompletionHelperViewModel profileCompletionHelperViewModel) {
            this.f13192a = profileCompletionHelperViewModel;
        }

        /* renamed from: a */
        public final Object c(List<QuestionWAnswers> list, c<? super Unit> cVar) {
            this.f13192a.f13184f.m(list);
            return Unit.f32013a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileCompletionHelperViewModel$loadQuestions$2(ProfileCompletionHelperViewModel profileCompletionHelperViewModel, String str, c<? super ProfileCompletionHelperViewModel$loadQuestions$2> cVar) {
        super(2, cVar);
        this.this$0 = profileCompletionHelperViewModel;
        this.$profileId = str;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ProfileCompletionHelperViewModel$loadQuestions$2(this.this$0, this.$profileId, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((ProfileCompletionHelperViewModel$loadQuestions$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            b<R> G = kotlinx.coroutines.flow.d.G(kotlinx.coroutines.flow.d.i(kotlinx.coroutines.reactive.c.a(this.this$0.f13182d.a(this.$profileId, QuestionGroupType.ORIGINAL_PROFILE, false)), kotlinx.coroutines.reactive.c.a(this.this$0.f13182d.a(this.$profileId, QuestionGroupType.EDUCATION_ONE, false)), kotlinx.coroutines.reactive.c.a(this.this$0.f13182d.a(this.$profileId, QuestionGroupType.EDUCATION_TWO, false)), kotlinx.coroutines.reactive.c.a(this.this$0.f13182d.a(this.$profileId, QuestionGroupType.ICEBREAKERS, false)), new AnonymousClass1((c<? super AnonymousClass1>) null)), 1);
            a aVar = new a(this.this$0);
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
