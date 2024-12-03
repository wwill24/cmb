package com.coffeemeetsbagel.models.body;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class QuestionGroupSkipBody {
    private final String question_id;

    public QuestionGroupSkipBody(String str) {
        j.g(str, "question_id");
        this.question_id = str;
    }

    public static /* synthetic */ QuestionGroupSkipBody copy$default(QuestionGroupSkipBody questionGroupSkipBody, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = questionGroupSkipBody.question_id;
        }
        return questionGroupSkipBody.copy(str);
    }

    public final String component1() {
        return this.question_id;
    }

    public final QuestionGroupSkipBody copy(String str) {
        j.g(str, "question_id");
        return new QuestionGroupSkipBody(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QuestionGroupSkipBody) && j.b(this.question_id, ((QuestionGroupSkipBody) obj).question_id);
    }

    public final String getQuestion_id() {
        return this.question_id;
    }

    public int hashCode() {
        return this.question_id.hashCode();
    }

    public String toString() {
        return "QuestionGroupSkipBody(question_id=" + this.question_id + PropertyUtils.MAPPED_DELIM2;
    }
}
