package com.coffeemeetsbagel.models.body;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class AnswerRequest {
    @c("question_id")
    private final String questionId;
    @c("text_value")
    private final String textValue;

    public AnswerRequest(String str, String str2) {
        j.g(str, "questionId");
        j.g(str2, "textValue");
        this.questionId = str;
        this.textValue = str2;
    }

    private final String component1() {
        return this.questionId;
    }

    private final String component2() {
        return this.textValue;
    }

    public static /* synthetic */ AnswerRequest copy$default(AnswerRequest answerRequest, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = answerRequest.questionId;
        }
        if ((i10 & 2) != 0) {
            str2 = answerRequest.textValue;
        }
        return answerRequest.copy(str, str2);
    }

    public final AnswerRequest copy(String str, String str2) {
        j.g(str, "questionId");
        j.g(str2, "textValue");
        return new AnswerRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnswerRequest)) {
            return false;
        }
        AnswerRequest answerRequest = (AnswerRequest) obj;
        return j.b(this.questionId, answerRequest.questionId) && j.b(this.textValue, answerRequest.textValue);
    }

    public int hashCode() {
        return (this.questionId.hashCode() * 31) + this.textValue.hashCode();
    }

    public String toString() {
        return "AnswerRequest(questionId=" + this.questionId + ", textValue=" + this.textValue + PropertyUtils.MAPPED_DELIM2;
    }
}
