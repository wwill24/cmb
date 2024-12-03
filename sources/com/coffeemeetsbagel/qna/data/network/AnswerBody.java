package com.coffeemeetsbagel.qna.data.network;

import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class AnswerBody {
    @c("json_value")
    private final AnswerJson answerJson;
    @c("float_value")
    private final Float floatValue;
    @c("int_value")
    private final Integer integerValue;
    @c("is_dealbreaker")
    private final Boolean isDealbreaker;
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

    public AnswerBody(List<String> list, String str, String str2, Integer num, Float f10, Float f11, Float f12, Boolean bool, AnswerJson answerJson2) {
        j.g(str, "questionId");
        this.optionIds = list;
        this.questionId = str;
        this.textValue = str2;
        this.integerValue = num;
        this.floatValue = f10;
        this.minValue = f11;
        this.maxValue = f12;
        this.isDealbreaker = bool;
        this.answerJson = answerJson2;
    }

    private final List<String> component1() {
        return this.optionIds;
    }

    private final String component2() {
        return this.questionId;
    }

    private final String component3() {
        return this.textValue;
    }

    private final Integer component4() {
        return this.integerValue;
    }

    private final Float component5() {
        return this.floatValue;
    }

    private final Float component6() {
        return this.minValue;
    }

    private final Float component7() {
        return this.maxValue;
    }

    private final Boolean component8() {
        return this.isDealbreaker;
    }

    private final AnswerJson component9() {
        return this.answerJson;
    }

    public static /* synthetic */ AnswerBody copy$default(AnswerBody answerBody, List list, String str, String str2, Integer num, Float f10, Float f11, Float f12, Boolean bool, AnswerJson answerJson2, int i10, Object obj) {
        AnswerBody answerBody2 = answerBody;
        int i11 = i10;
        return answerBody.copy((i11 & 1) != 0 ? answerBody2.optionIds : list, (i11 & 2) != 0 ? answerBody2.questionId : str, (i11 & 4) != 0 ? answerBody2.textValue : str2, (i11 & 8) != 0 ? answerBody2.integerValue : num, (i11 & 16) != 0 ? answerBody2.floatValue : f10, (i11 & 32) != 0 ? answerBody2.minValue : f11, (i11 & 64) != 0 ? answerBody2.maxValue : f12, (i11 & 128) != 0 ? answerBody2.isDealbreaker : bool, (i11 & 256) != 0 ? answerBody2.answerJson : answerJson2);
    }

    public final AnswerBody copy(List<String> list, String str, String str2, Integer num, Float f10, Float f11, Float f12, Boolean bool, AnswerJson answerJson2) {
        j.g(str, "questionId");
        return new AnswerBody(list, str, str2, num, f10, f11, f12, bool, answerJson2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnswerBody)) {
            return false;
        }
        AnswerBody answerBody = (AnswerBody) obj;
        return j.b(this.optionIds, answerBody.optionIds) && j.b(this.questionId, answerBody.questionId) && j.b(this.textValue, answerBody.textValue) && j.b(this.integerValue, answerBody.integerValue) && j.b(this.floatValue, answerBody.floatValue) && j.b(this.minValue, answerBody.minValue) && j.b(this.maxValue, answerBody.maxValue) && j.b(this.isDealbreaker, answerBody.isDealbreaker) && j.b(this.answerJson, answerBody.answerJson);
    }

    public int hashCode() {
        List<String> list = this.optionIds;
        int i10 = 0;
        int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.questionId.hashCode()) * 31;
        String str = this.textValue;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.integerValue;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Float f10 = this.floatValue;
        int hashCode4 = (hashCode3 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Float f11 = this.minValue;
        int hashCode5 = (hashCode4 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.maxValue;
        int hashCode6 = (hashCode5 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Boolean bool = this.isDealbreaker;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        AnswerJson answerJson2 = this.answerJson;
        if (answerJson2 != null) {
            i10 = answerJson2.hashCode();
        }
        return hashCode7 + i10;
    }

    public String toString() {
        return "AnswerBody(optionIds=" + this.optionIds + ", questionId=" + this.questionId + ", textValue=" + this.textValue + ", integerValue=" + this.integerValue + ", floatValue=" + this.floatValue + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + ", isDealbreaker=" + this.isDealbreaker + ", answerJson=" + this.answerJson + PropertyUtils.MAPPED_DELIM2;
    }
}
