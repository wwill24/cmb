package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.qna.data.network.NetworkPeriodicQuestionGroup;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ResponsePeriodicQuestions extends ResponseGeneric {
    private NetworkPeriodicQuestionGroup data;

    public ResponsePeriodicQuestions(NetworkPeriodicQuestionGroup networkPeriodicQuestionGroup) {
        j.g(networkPeriodicQuestionGroup, "data");
        this.data = networkPeriodicQuestionGroup;
    }

    public static /* synthetic */ ResponsePeriodicQuestions copy$default(ResponsePeriodicQuestions responsePeriodicQuestions, NetworkPeriodicQuestionGroup networkPeriodicQuestionGroup, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            networkPeriodicQuestionGroup = responsePeriodicQuestions.data;
        }
        return responsePeriodicQuestions.copy(networkPeriodicQuestionGroup);
    }

    public final NetworkPeriodicQuestionGroup component1() {
        return this.data;
    }

    public final ResponsePeriodicQuestions copy(NetworkPeriodicQuestionGroup networkPeriodicQuestionGroup) {
        j.g(networkPeriodicQuestionGroup, "data");
        return new ResponsePeriodicQuestions(networkPeriodicQuestionGroup);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResponsePeriodicQuestions) && j.b(this.data, ((ResponsePeriodicQuestions) obj).data);
    }

    public final NetworkPeriodicQuestionGroup getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public final void setData(NetworkPeriodicQuestionGroup networkPeriodicQuestionGroup) {
        j.g(networkPeriodicQuestionGroup, "<set-?>");
        this.data = networkPeriodicQuestionGroup;
    }

    public String toString() {
        return "ResponsePeriodicQuestions(data=" + this.data + PropertyUtils.MAPPED_DELIM2;
    }
}
