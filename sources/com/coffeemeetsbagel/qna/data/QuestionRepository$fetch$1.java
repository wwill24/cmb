package com.coffeemeetsbagel.qna.data;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.responses.ResponseQuestionGroup;
import com.coffeemeetsbagel.qna.r;
import fa.a;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.h;
import qj.w;
import rn.a;

final class QuestionRepository$fetch$1 extends Lambda implements Function1<Boolean, a<? extends ab.a>> {
    final /* synthetic */ QuestionGroupType $groupType;
    final /* synthetic */ h<ab.a> $localStream;
    final /* synthetic */ boolean $networkFirst;
    final /* synthetic */ String $profileId;
    final /* synthetic */ boolean $shouldUpdateQuestions;
    final /* synthetic */ QuestionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionRepository$fetch$1(boolean z10, QuestionRepository questionRepository, QuestionGroupType questionGroupType, h<ab.a> hVar, String str, boolean z11) {
        super(1);
        this.$networkFirst = z10;
        this.this$0 = questionRepository;
        this.$groupType = questionGroupType;
        this.$localStream = hVar;
        this.$profileId = str;
        this.$shouldUpdateQuestions = z11;
    }

    /* access modifiers changed from: private */
    public static final b0 e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final a f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    /* renamed from: d */
    public final a<? extends ab.a> invoke(Boolean bool) {
        j.g(bool, "groupExists");
        if (bool.booleanValue() && !this.$networkFirst) {
            return this.$localStream;
        }
        a.C0491a aVar = fa.a.f40771d;
        String s10 = this.this$0.f36242f;
        aVar.a(s10, this.$groupType.getQuestionGroupApiString() + " is missing, fetching.");
        w<ResponseQuestionGroup> a10 = this.this$0.f36241e.a(this.$groupType.getQuestionGroupApiString());
        final QuestionRepository questionRepository = this.this$0;
        final QuestionGroupType questionGroupType = this.$groupType;
        final String str = this.$profileId;
        final boolean z10 = this.$shouldUpdateQuestions;
        w<R> v10 = a10.v(new o(new Function1<ResponseQuestionGroup, b0<? extends List<? extends Long>>>() {
            /* renamed from: a */
            public final b0<? extends List<Long>> invoke(ResponseQuestionGroup responseQuestionGroup) {
                j.g(responseQuestionGroup, "response");
                a.C0491a aVar = fa.a.f40771d;
                String s10 = questionRepository.f36242f;
                aVar.a(s10, questionGroupType.getQuestionGroupApiString() + " is being saved.");
                QuestionRepository questionRepository = questionRepository;
                String str = str;
                return questionRepository.Z(str, r.c(responseQuestionGroup, str), z10);
            }
        }));
        final h<ab.a> hVar = this.$localStream;
        h<R> y10 = v10.y(new p(new Function1<List<? extends Long>, rn.a<? extends ab.a>>() {
            /* renamed from: a */
            public final rn.a<? extends ab.a> invoke(List<Long> list) {
                j.g(list, "it");
                return hVar;
            }
        }));
        j.f(y10, "fun fetch(\n        group…On(Schedulers.io())\n    }");
        return y10;
    }
}
