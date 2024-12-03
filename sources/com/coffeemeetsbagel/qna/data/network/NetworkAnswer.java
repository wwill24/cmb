package com.coffeemeetsbagel.qna.data.network;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkAnswer implements Serializable {
    @c("float_value")
    private final Float floatValue;

    /* renamed from: id  reason: collision with root package name */
    private final String f36266id;
    @c("int_value")
    private final Integer integerValue;
    @c("is_dealbreaker")
    private final Boolean isDealbreaker;
    @c("json_value")
    private final AnswerJson jsonValue;
    @c("max_value")
    private final Float maxValue;
    @c("min_value")
    private final Float minValue;
    @c("option_ids")
    private final List<String> optionIds;
    @c("question_id")
    private final String questionId;
    @c("text_value")
    private final String textValue;

    public NetworkAnswer(String str, List<String> list, String str2, String str3, Integer num, Float f10, Float f11, Float f12, Boolean bool, AnswerJson answerJson) {
        j.g(str, "id");
        j.g(str2, "questionId");
        this.f36266id = str;
        this.optionIds = list;
        this.questionId = str2;
        this.textValue = str3;
        this.integerValue = num;
        this.floatValue = f10;
        this.maxValue = f11;
        this.minValue = f12;
        this.isDealbreaker = bool;
        this.jsonValue = answerJson;
    }

    public static /* synthetic */ NetworkAnswer copy$default(NetworkAnswer networkAnswer, String str, List list, String str2, String str3, Integer num, Float f10, Float f11, Float f12, Boolean bool, AnswerJson answerJson, int i10, Object obj) {
        NetworkAnswer networkAnswer2 = networkAnswer;
        int i11 = i10;
        return networkAnswer.copy((i11 & 1) != 0 ? networkAnswer2.f36266id : str, (i11 & 2) != 0 ? networkAnswer2.optionIds : list, (i11 & 4) != 0 ? networkAnswer2.questionId : str2, (i11 & 8) != 0 ? networkAnswer2.textValue : str3, (i11 & 16) != 0 ? networkAnswer2.integerValue : num, (i11 & 32) != 0 ? networkAnswer2.floatValue : f10, (i11 & 64) != 0 ? networkAnswer2.maxValue : f11, (i11 & 128) != 0 ? networkAnswer2.minValue : f12, (i11 & 256) != 0 ? networkAnswer2.isDealbreaker : bool, (i11 & 512) != 0 ? networkAnswer2.jsonValue : answerJson);
    }

    public final String component1() {
        return this.f36266id;
    }

    public final AnswerJson component10() {
        return this.jsonValue;
    }

    public final List<String> component2() {
        return this.optionIds;
    }

    public final String component3() {
        return this.questionId;
    }

    public final String component4() {
        return this.textValue;
    }

    public final Integer component5() {
        return this.integerValue;
    }

    public final Float component6() {
        return this.floatValue;
    }

    public final Float component7() {
        return this.maxValue;
    }

    public final Float component8() {
        return this.minValue;
    }

    public final Boolean component9() {
        return this.isDealbreaker;
    }

    public final NetworkAnswer copy(String str, List<String> list, String str2, String str3, Integer num, Float f10, Float f11, Float f12, Boolean bool, AnswerJson answerJson) {
        j.g(str, "id");
        j.g(str2, "questionId");
        return new NetworkAnswer(str, list, str2, str3, num, f10, f11, f12, bool, answerJson);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkAnswer)) {
            return false;
        }
        NetworkAnswer networkAnswer = (NetworkAnswer) obj;
        return j.b(this.f36266id, networkAnswer.f36266id) && j.b(this.optionIds, networkAnswer.optionIds) && j.b(this.questionId, networkAnswer.questionId) && j.b(this.textValue, networkAnswer.textValue) && j.b(this.integerValue, networkAnswer.integerValue) && j.b(this.floatValue, networkAnswer.floatValue) && j.b(this.maxValue, networkAnswer.maxValue) && j.b(this.minValue, networkAnswer.minValue) && j.b(this.isDealbreaker, networkAnswer.isDealbreaker) && j.b(this.jsonValue, networkAnswer.jsonValue);
    }

    public final Float getFloatValue() {
        return this.floatValue;
    }

    public final String getId() {
        return this.f36266id;
    }

    public final Integer getIntegerValue() {
        return this.integerValue;
    }

    public final AnswerJson getJsonValue() {
        return this.jsonValue;
    }

    public final Float getMaxValue() {
        return this.maxValue;
    }

    public final Float getMinValue() {
        return this.minValue;
    }

    public final List<String> getOptionIds() {
        return this.optionIds;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final String getTextValue() {
        return this.textValue;
    }

    public int hashCode() {
        int hashCode = this.f36266id.hashCode() * 31;
        List<String> list = this.optionIds;
        int i10 = 0;
        int hashCode2 = (((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.questionId.hashCode()) * 31;
        String str = this.textValue;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.integerValue;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Float f10 = this.floatValue;
        int hashCode5 = (hashCode4 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Float f11 = this.maxValue;
        int hashCode6 = (hashCode5 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.minValue;
        int hashCode7 = (hashCode6 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Boolean bool = this.isDealbreaker;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        AnswerJson answerJson = this.jsonValue;
        if (answerJson != null) {
            i10 = answerJson.hashCode();
        }
        return hashCode8 + i10;
    }

    public final Boolean isDealbreaker() {
        return this.isDealbreaker;
    }

    public String toString() {
        return "NetworkAnswer(id=" + this.f36266id + ", optionIds=" + this.optionIds + ", questionId=" + this.questionId + ", textValue=" + this.textValue + ", integerValue=" + this.integerValue + ", floatValue=" + this.floatValue + ", maxValue=" + this.maxValue + ", minValue=" + this.minValue + ", isDealbreaker=" + this.isDealbreaker + ", jsonValue=" + this.jsonValue + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NetworkAnswer(java.lang.String r15, java.util.List r16, java.lang.String r17, java.lang.String r18, java.lang.Integer r19, java.lang.Float r20, java.lang.Float r21, java.lang.Float r22, java.lang.Boolean r23, com.coffeemeetsbagel.qna.data.network.AnswerJson r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r16
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0011
            r7 = r2
            goto L_0x0013
        L_0x0011:
            r7 = r18
        L_0x0013:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0019
            r8 = r2
            goto L_0x001b
        L_0x0019:
            r8 = r19
        L_0x001b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0021
            r9 = r2
            goto L_0x0023
        L_0x0021:
            r9 = r20
        L_0x0023:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0029
            r10 = r2
            goto L_0x002b
        L_0x0029:
            r10 = r21
        L_0x002b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0031
            r11 = r2
            goto L_0x0033
        L_0x0031:
            r11 = r22
        L_0x0033:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0039
            r12 = r2
            goto L_0x003b
        L_0x0039:
            r12 = r23
        L_0x003b:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0041
            r13 = r2
            goto L_0x0043
        L_0x0041:
            r13 = r24
        L_0x0043:
            r3 = r14
            r4 = r15
            r6 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.qna.data.network.NetworkAnswer.<init>(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Boolean, com.coffeemeetsbagel.qna.data.network.AnswerJson, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
