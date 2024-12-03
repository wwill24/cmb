package com.coffeemeetsbagel.qna.data;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.body.QuestionGroupSkipBody;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.qna.QnaPair;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.data.network.AnswerBody;
import com.coffeemeetsbagel.qna.data.network.AnswerJson;
import com.coffeemeetsbagel.qna.data.network.AnswerType;
import com.coffeemeetsbagel.qna.data.network.DeleteAnswerRequest;
import com.coffeemeetsbagel.qna.data.network.NetworkQuestionGroup;
import com.coffeemeetsbagel.qna.q;
import com.coffeemeetsbagel.qna.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ma.b;
import ma.f;
import ma.h;
import qj.b0;
import qj.w;
import rn.a;
import za.d;
import za.e;
import za.g;

public final class QuestionRepository {

    /* renamed from: a  reason: collision with root package name */
    private final f f36237a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d f36238b;

    /* renamed from: c  reason: collision with root package name */
    private final b f36239c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final e f36240d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final h f36241e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f36242f = "QuestionRepository";

    public QuestionRepository(f fVar, d dVar, b bVar, e eVar, h hVar) {
        j.g(fVar, "periodicQuestionsService");
        j.g(dVar, "questionDao");
        j.g(bVar, "answerService");
        j.g(eVar, "qnaDao");
        j.g(hVar, "remote");
        this.f36237a = fVar;
        this.f36238b = dVar;
        this.f36239c = bVar;
        this.f36240d = eVar;
        this.f36241e = hVar;
    }

    /* access modifiers changed from: private */
    public static final a A(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    private final qj.h<List<QnaPair>> B(String str, QuestionGroupType questionGroupType, boolean z10) {
        qj.h<R> M = this.f36241e.a(questionGroupType.getQuestionGroupApiString()).D(new n(new QuestionRepository$fetchFromNetworkAndSave$1(str))).v(new b(new QuestionRepository$fetchFromNetworkAndSave$2(this, str, z10))).O().M(new c(new QuestionRepository$fetchFromNetworkAndSave$3(this, str, questionGroupType)));
        j.f(M, "private fun fetchFromNet…onGroupApiString) }\n    }");
        return M;
    }

    static /* synthetic */ qj.h C(QuestionRepository questionRepository, String str, QuestionGroupType questionGroupType, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return questionRepository.B(str, questionGroupType, z10);
    }

    /* access modifiers changed from: private */
    public static final g D(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (g) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 E(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final a F(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Optional J(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final QuestionWAnswers N(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (QuestionWAnswers) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 P(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List Q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void T(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static /* synthetic */ qj.a V(QuestionRepository questionRepository, String str, List list, String str2, Integer num, Float f10, String str3, String str4, Float f11, Float f12, boolean z10, Location location, int i10, Object obj) {
        int i11 = i10;
        return questionRepository.U(str, (i11 & 2) != 0 ? null : list, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? null : f10, str3, str4, (i11 & 128) != 0 ? null : f11, (i11 & 256) != 0 ? null : f12, (i11 & 512) != 0 ? false : z10, (i11 & 1024) != 0 ? null : location);
    }

    /* access modifiers changed from: private */
    public static final qj.f W(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (qj.f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List Y(List list, QuestionRepository questionRepository) {
        j.g(list, "$profiles");
        j.g(questionRepository, "this$0");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NetworkProfile networkProfile = (NetworkProfile) it.next();
            List<NetworkQuestionGroup> questionGroups = networkProfile.getQuestionGroups();
            j.f(questionGroups, "networkProfile.questionGroups");
            ArrayList arrayList2 = new ArrayList(r.t(questionGroups, 10));
            for (NetworkQuestionGroup networkQuestionGroup : questionGroups) {
                j.f(networkQuestionGroup, "it");
                String id2 = networkProfile.getId();
                j.f(id2, "networkProfile.id");
                arrayList2.add(r.d(networkQuestionGroup, id2));
            }
            arrayList.add(new Pair(networkProfile.getId(), arrayList2));
        }
        return questionRepository.f36240d.e(arrayList);
    }

    /* access modifiers changed from: private */
    public final w<List<Long>> Z(String str, g gVar, boolean z10) {
        w<List<Long>> K = w.A(new l(this, str, gVar, z10)).K(dk.a.c());
        j.f(K, "fromCallable {\n         …scribeOn(Schedulers.io())");
        return K;
    }

    /* access modifiers changed from: private */
    public static final List a0(QuestionRepository questionRepository, String str, g gVar, boolean z10) {
        j.g(questionRepository, "this$0");
        j.g(str, "$profileId");
        j.g(gVar, "$questionGroupEntity");
        return questionRepository.f36240d.b(str, gVar, z10);
    }

    /* access modifiers changed from: private */
    public final ab.a u(List<za.h> list, List<za.b> list2) {
        za.h hVar = list.get(0);
        return new ab.a(q.f36305a.a(list2, hVar.b()), hVar.a().b(), hVar.a().c());
    }

    /* access modifiers changed from: private */
    public static final void w(QuestionRepository questionRepository, String str, String str2) {
        j.g(questionRepository, "this$0");
        j.g(str, "$profileId");
        j.g(str2, "$questionId");
        questionRepository.f36240d.c(str, str2);
    }

    public static /* synthetic */ qj.h y(QuestionRepository questionRepository, QuestionGroupType questionGroupType, String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        return questionRepository.x(questionGroupType, str, z10, z11);
    }

    /* access modifiers changed from: private */
    public static final ab.a z(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (ab.a) function1.invoke(obj);
    }

    public final qj.h<Integer> G(String str) {
        j.g(str, "profileId");
        return this.f36238b.c(str);
    }

    public final qj.h<List<String>> H(String str, QuestionGroupType questionGroupType) {
        j.g(str, "profileId");
        j.g(questionGroupType, "groupType");
        qj.h<List<String>> o02 = this.f36240d.g(str, questionGroupType.getQuestionGroupApiString()).o0(dk.a.c());
        j.f(o02, "qnaDao.getMCQAnswers(pro…scribeOn(Schedulers.io())");
        return o02;
    }

    public final qj.h<Optional<QuestionWAnswers>> I(String str, String str2) {
        j.g(str, "name");
        j.g(str2, "profileId");
        qj.h<R> o02 = this.f36238b.a(str, str2).Y(new d(QuestionRepository$getQuestion$1.f36243a)).o0(dk.a.c());
        j.f(o02, "questionDao\n            …scribeOn(Schedulers.io())");
        return o02;
    }

    public final w<OptionalInt> K(QuestionGroupType questionGroupType) {
        j.g(questionGroupType, "questionGroupType");
        w<OptionalInt> K = this.f36240d.l(questionGroupType.getQuestionGroupApiString()).K(dk.a.c());
        j.f(K, "qnaDao\n            .getQ…scribeOn(Schedulers.io())");
        return K;
    }

    public final w<Integer> L(QuestionGroupType questionGroupType, int i10) {
        j.g(questionGroupType, "questionGroupType");
        w<Integer> K = this.f36240d.i(questionGroupType.getQuestionGroupApiString(), i10).K(dk.a.c());
        j.f(K, "qnaDao.getQuestionGroupM…scribeOn(Schedulers.io())");
        return K;
    }

    public final qj.h<QuestionWAnswers> M(String str, String str2) {
        j.g(str, "profileId");
        j.g(str2, "questionId");
        qj.h<R> Y = this.f36240d.a(str, str2).Y(new m(QuestionRepository$getQuestionWithAnswers$1.f36244a));
        j.f(Y, "qnaDao\n            .getQ….first))[0]\n            }");
        return Y;
    }

    public final w<List<QuestionWAnswers>> O() {
        w<R> D = this.f36237a.a().K(dk.a.c()).v(new a(new QuestionRepository$getQuestions$1(this))).D(new f(QuestionRepository$getQuestions$2.f36245a));
        j.f(D, "fun getQuestions(): Sing…    }\n            }\n    }");
        return D;
    }

    public final qj.h<List<QnaPair>> R(String str, QuestionGroupType questionGroupType, boolean z10) {
        j.g(str, "profileId");
        j.g(questionGroupType, "groupType");
        if (z10) {
            qj.h<List<QnaPair>> o02 = C(this, str, questionGroupType, false, 4, (Object) null).o0(dk.a.c());
            j.f(o02, "{\n            fetchFromN…chedulers.io())\n        }");
            return o02;
        }
        qj.h<List<QnaPair>> o03 = this.f36240d.k(str, questionGroupType.getQuestionGroupApiString()).o0(dk.a.c());
        j.f(o03, "{\n            qnaDao.get…chedulers.io())\n        }");
        return o03;
    }

    public final w<ResponseGeneric> S(Question question) {
        j.g(question, "question");
        w<ResponseGeneric> p10 = this.f36241e.b(question.getGroup().getQuestionGroupApiString(), new QuestionGroupSkipBody(question.getId())).K(dk.a.c()).p(new g(new QuestionRepository$markQuestionSkipped$1(this)));
        j.f(p10, "fun markQuestionSkipped(…, it)\n            }\n    }");
        return p10;
    }

    public final qj.a U(String str, List<String> list, String str2, Integer num, Float f10, String str3, String str4, Float f11, Float f12, boolean z10, Location location) {
        boolean z11;
        AnswerJson answerJson;
        String str5 = str;
        String str6 = str3;
        String str7 = str4;
        j.g(str5, "profileId");
        j.g(str6, "questionId");
        j.g(str7, "group");
        boolean z12 = false;
        if (list == null || list.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (str2 == null || str2.length() == 0) {
                z12 = true;
            }
            if (z12 && num == null && f10 == null && f11 == null && f12 == null && location == null) {
                return v(str7, str6, str5);
            }
        }
        if (location != null) {
            answerJson = new AnswerJson(AnswerType.LOCATION.getApiString(), location.getLatitude(), location.getLongitude(), location.getCity(), location.getState(), location.getCountry(), location.getZip());
        } else {
            answerJson = null;
        }
        AnswerBody answerBody = new AnswerBody(list, str3, str2, num, f10, f11, f12, Boolean.valueOf(z10), answerJson);
        qj.a w10 = this.f36239c.b(str7, answerBody).K(dk.a.c()).w(new j(new QuestionRepository$postAnswer$1(answerBody, str, this, list, str2, str3, num, f10)));
        j.f(w10, "fun postAnswer(\n        …        }\n        }\n    }");
        return w10;
    }

    public final w<List<Long>> X(List<? extends NetworkProfile> list) {
        j.g(list, "profiles");
        w<List<Long>> K = w.A(new e(list, this)).K(dk.a.c());
        j.f(K, "fromCallable {\n         …scribeOn(Schedulers.io())");
        return K;
    }

    public final qj.a v(String str, String str2, String str3) {
        j.g(str, "group");
        j.g(str2, "questionId");
        j.g(str3, "profileId");
        qj.a b10 = this.f36239c.a(str, new DeleteAnswerRequest(str2)).F(dk.a.c()).b(qj.a.w(new k(this, str3, str2)));
        j.f(b10, "answerService.deleteAnsw…         )\n            })");
        return b10;
    }

    public final qj.h<ab.a> x(QuestionGroupType questionGroupType, String str, boolean z10, boolean z11) {
        j.g(questionGroupType, "groupType");
        j.g(str, "profileId");
        qj.h<R> Y = ck.a.f24943a.a(this.f36240d.d(questionGroupType.getQuestionGroupApiString()), this.f36240d.j(questionGroupType.getQuestionGroupApiString(), str)).Y(new h(new QuestionRepository$fetch$localStream$1(questionGroupType, this)));
        j.f(Y, "fun fetch(\n        group…On(Schedulers.io())\n    }");
        qj.h<R> o02 = this.f36240d.f(questionGroupType.getQuestionGroupApiString()).y(new i(new QuestionRepository$fetch$1(z10, this, questionGroupType, Y, str, z11))).o0(dk.a.c());
        j.f(o02, "fun fetch(\n        group…On(Schedulers.io())\n    }");
        return o02;
    }
}
