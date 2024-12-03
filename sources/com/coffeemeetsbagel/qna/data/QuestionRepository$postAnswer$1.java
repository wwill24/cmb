package com.coffeemeetsbagel.qna.data;

import com.coffeemeetsbagel.models.responses.ResponseAnswer;
import com.coffeemeetsbagel.qna.data.network.AnswerBody;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.a;
import qj.f;
import retrofit2.r;

final class QuestionRepository$postAnswer$1 extends Lambda implements Function1<r<ResponseAnswer>, f> {
    final /* synthetic */ AnswerBody $answerBody;
    final /* synthetic */ Float $floatAnswer;
    final /* synthetic */ Integer $intAnswer;
    final /* synthetic */ String $profileId;
    final /* synthetic */ String $questionId;
    final /* synthetic */ List<String> $selectedOptionIds;
    final /* synthetic */ String $textAnswer;
    final /* synthetic */ QuestionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionRepository$postAnswer$1(AnswerBody answerBody, String str, QuestionRepository questionRepository, List<String> list, String str2, String str3, Integer num, Float f10) {
        super(1);
        this.$answerBody = answerBody;
        this.$profileId = str;
        this.this$0 = questionRepository;
        this.$selectedOptionIds = list;
        this.$textAnswer = str2;
        this.$questionId = str3;
        this.$intAnswer = num;
        this.$floatAnswer = f10;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.util.List, java.util.Collection] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r18v3, types: [com.coffeemeetsbagel.models.dto.Location] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void d(com.coffeemeetsbagel.qna.data.network.NetworkAnswer r26, java.lang.String r27, com.coffeemeetsbagel.qna.data.QuestionRepository r28, java.util.List r29, java.lang.String r30, java.lang.String r31, java.lang.Integer r32, java.lang.Float r33) {
        /*
            r15 = r27
            r14 = r31
            java.lang.String r0 = "$networkAnswer"
            r13 = r26
            kotlin.jvm.internal.j.g(r13, r0)
            java.lang.String r0 = "$profileId"
            kotlin.jvm.internal.j.g(r15, r0)
            java.lang.String r0 = "this$0"
            r12 = r28
            kotlin.jvm.internal.j.g(r12, r0)
            java.lang.String r0 = "$questionId"
            kotlin.jvm.internal.j.g(r14, r0)
            java.util.List r0 = r26.getOptionIds()
            r16 = 0
            r17 = 1
            if (r0 == 0) goto L_0x0030
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x002d
            goto L_0x0030
        L_0x002d:
            r0 = r16
            goto L_0x0032
        L_0x0030:
            r0 = r17
        L_0x0032:
            r1 = 0
            if (r0 != 0) goto L_0x009b
            java.util.List r0 = r26.getOptionIds()
            if (r0 == 0) goto L_0x0166
            java.util.ArrayList r11 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.r.t(r0, r1)
            r11.<init>(r1)
            java.util.Iterator r18 = r0.iterator()
        L_0x004a:
            boolean r0 = r18.hasNext()
            if (r0 == 0) goto L_0x0097
            java.lang.Object r0 = r18.next()
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            za.b r10 = new za.b
            java.lang.String r1 = r26.getId()
            java.lang.String r4 = r26.getQuestionId()
            r5 = 0
            r8 = 0
            r9 = 0
            r19 = 0
            java.lang.Boolean r20 = r26.isDealbreaker()
            r21 = 0
            r22 = 2960(0xb90, float:4.148E-42)
            r23 = 0
            r0 = r10
            r3 = r27
            r6 = r32
            r7 = r33
            r24 = r10
            r10 = r19
            r25 = r11
            r11 = r20
            r12 = r21
            r13 = r22
            r14 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = r24
            r0 = r25
            r0.add(r1)
            r13 = r26
            r12 = r28
            r14 = r31
            r11 = r0
            goto L_0x004a
        L_0x0097:
            r0 = r11
            r1 = r0
            goto L_0x0166
        L_0x009b:
            java.util.List r0 = r26.getOptionIds()
            if (r0 == 0) goto L_0x00ab
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00a8
            goto L_0x00ab
        L_0x00a8:
            r0 = r16
            goto L_0x00ad
        L_0x00ab:
            r0 = r17
        L_0x00ad:
            if (r0 == 0) goto L_0x0135
            java.lang.String r2 = r26.getId()
            r3 = 0
            java.lang.String r4 = r26.getQuestionId()
            java.lang.String r0 = r26.getTextValue()
            if (r0 == 0) goto L_0x00c8
            boolean r0 = kotlin.text.r.w(r0)
            if (r0 == 0) goto L_0x00c5
            goto L_0x00c8
        L_0x00c5:
            r0 = r16
            goto L_0x00ca
        L_0x00c8:
            r0 = r17
        L_0x00ca:
            if (r0 == 0) goto L_0x00cf
            java.lang.String r0 = ""
            goto L_0x00d6
        L_0x00cf:
            java.lang.String r0 = r26.getTextValue()
            kotlin.jvm.internal.j.d(r0)
        L_0x00d6:
            r5 = r0
            java.lang.Integer r6 = r26.getIntegerValue()
            java.lang.Float r7 = r26.getFloatValue()
            java.lang.Float r8 = r26.getMaxValue()
            java.lang.Float r9 = r26.getMinValue()
            com.coffeemeetsbagel.qna.data.network.AnswerJson r0 = r26.getJsonValue()
            if (r0 == 0) goto L_0x011c
            java.lang.String r10 = r0.getType()
            com.coffeemeetsbagel.qna.data.network.AnswerType r11 = com.coffeemeetsbagel.qna.data.network.AnswerType.LOCATION
            java.lang.String r11 = r11.getApiString()
            boolean r10 = kotlin.jvm.internal.j.b(r10, r11)
            if (r10 == 0) goto L_0x011c
            java.lang.Float r23 = r0.getLatitude()
            java.lang.Float r24 = r0.getLongitude()
            java.lang.String r19 = r0.getCity()
            java.lang.String r20 = r0.getState()
            java.lang.String r22 = r0.getZipcode()
            java.lang.String r21 = r0.getCountry()
            com.coffeemeetsbagel.models.dto.Location r1 = new com.coffeemeetsbagel.models.dto.Location
            r18 = r1
            r18.<init>(r19, r20, r21, r22, r23, r24)
        L_0x011c:
            r10 = r1
            java.lang.Boolean r11 = r26.isDealbreaker()
            r12 = 0
            r13 = 2050(0x802, float:2.873E-42)
            r14 = 0
            za.b r18 = new za.b
            r0 = r18
            r1 = r2
            r2 = r3
            r3 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            java.util.List r1 = kotlin.collections.p.e(r18)
            goto L_0x0166
        L_0x0135:
            fa.a$a r0 = fa.a.f40771d
            java.lang.String r1 = r28.f36242f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "original answers has selected options: "
            r2.append(r3)
            r3 = r29
            r2.append(r3)
            java.lang.String r3 = " and text: "
            r2.append(r3)
            r3 = r30
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "save answer request succeeded but backend returns no answers"
            r3.<init>(r4)
            r0.c(r1, r2, r3)
            java.util.List r1 = kotlin.collections.q.j()
        L_0x0166:
            if (r1 == 0) goto L_0x016e
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x0170
        L_0x016e:
            r16 = r17
        L_0x0170:
            if (r16 != 0) goto L_0x017b
            za.e r0 = r28.f36240d
            r2 = r31
            r0.h(r2, r15, r1)
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.qna.data.QuestionRepository$postAnswer$1.d(com.coffeemeetsbagel.qna.data.network.NetworkAnswer, java.lang.String, com.coffeemeetsbagel.qna.data.QuestionRepository, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Float):void");
    }

    /* renamed from: c */
    public final f invoke(r<ResponseAnswer> rVar) {
        j.g(rVar, "it");
        ResponseAnswer a10 = rVar.a();
        if (a10 != null) {
            return a.w(new r(a10.getData(), this.$profileId, this.this$0, this.$selectedOptionIds, this.$textAnswer, this.$questionId, this.$intAnswer, this.$floatAnswer));
        }
        throw new IllegalStateException("null response for non-delete request: " + this.$answerBody);
    }
}
