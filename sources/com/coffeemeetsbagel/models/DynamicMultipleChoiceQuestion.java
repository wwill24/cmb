package com.coffeemeetsbagel.models;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class DynamicMultipleChoiceQuestion {
    private final String answerName;
    private final String answerText;
    private final String questionName;
    private final String questionText;

    public DynamicMultipleChoiceQuestion(String str, String str2, String str3, String str4) {
        j.g(str, "questionName");
        j.g(str3, "answerName");
        this.questionName = str;
        this.questionText = str2;
        this.answerName = str3;
        this.answerText = str4;
    }

    public static /* synthetic */ DynamicMultipleChoiceQuestion copy$default(DynamicMultipleChoiceQuestion dynamicMultipleChoiceQuestion, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = dynamicMultipleChoiceQuestion.questionName;
        }
        if ((i10 & 2) != 0) {
            str2 = dynamicMultipleChoiceQuestion.questionText;
        }
        if ((i10 & 4) != 0) {
            str3 = dynamicMultipleChoiceQuestion.answerName;
        }
        if ((i10 & 8) != 0) {
            str4 = dynamicMultipleChoiceQuestion.answerText;
        }
        return dynamicMultipleChoiceQuestion.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.questionName;
    }

    public final String component2() {
        return this.questionText;
    }

    public final String component3() {
        return this.answerName;
    }

    public final String component4() {
        return this.answerText;
    }

    public final DynamicMultipleChoiceQuestion copy(String str, String str2, String str3, String str4) {
        j.g(str, "questionName");
        j.g(str3, "answerName");
        return new DynamicMultipleChoiceQuestion(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicMultipleChoiceQuestion)) {
            return false;
        }
        DynamicMultipleChoiceQuestion dynamicMultipleChoiceQuestion = (DynamicMultipleChoiceQuestion) obj;
        return j.b(this.questionName, dynamicMultipleChoiceQuestion.questionName) && j.b(this.questionText, dynamicMultipleChoiceQuestion.questionText) && j.b(this.answerName, dynamicMultipleChoiceQuestion.answerName) && j.b(this.answerText, dynamicMultipleChoiceQuestion.answerText);
    }

    public final String getAnswerName() {
        return this.answerName;
    }

    public final String getAnswerText() {
        return this.answerText;
    }

    public final String getQuestionName() {
        return this.questionName;
    }

    public final String getQuestionText() {
        return this.questionText;
    }

    public int hashCode() {
        int hashCode = this.questionName.hashCode() * 31;
        String str = this.questionText;
        int i10 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.answerName.hashCode()) * 31;
        String str2 = this.answerText;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "DynamicMultipleChoiceQuestion(questionName=" + this.questionName + ", questionText=" + this.questionText + ", answerName=" + this.answerName + ", answerText=" + this.answerText + PropertyUtils.MAPPED_DELIM2;
    }
}
