package com.coffeemeetsbagel.qna.data.network;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class DeleteAnswerRequest {
    @c("question_id")
    private final String questionId;

    public DeleteAnswerRequest(String str) {
        j.g(str, "questionId");
        this.questionId = str;
    }

    private final String component1() {
        return this.questionId;
    }

    public static /* synthetic */ DeleteAnswerRequest copy$default(DeleteAnswerRequest deleteAnswerRequest, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = deleteAnswerRequest.questionId;
        }
        return deleteAnswerRequest.copy(str);
    }

    public final DeleteAnswerRequest copy(String str) {
        j.g(str, "questionId");
        return new DeleteAnswerRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DeleteAnswerRequest) && j.b(this.questionId, ((DeleteAnswerRequest) obj).questionId);
    }

    public int hashCode() {
        return this.questionId.hashCode();
    }

    public String toString() {
        return "DeleteAnswerRequest(questionId=" + this.questionId + PropertyUtils.MAPPED_DELIM2;
    }
}
