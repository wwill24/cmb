package com.coffeemeetsbagel.qna.data.network;

import java.io.Serializable;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkPeriodicQuestion implements Serializable {
    private final NetworkQuestion question;
    @c("question_group_name")
    private final String questionGroupName;

    public NetworkPeriodicQuestion(String str, NetworkQuestion networkQuestion) {
        j.g(str, "questionGroupName");
        j.g(networkQuestion, "question");
        this.questionGroupName = str;
        this.question = networkQuestion;
    }

    public static /* synthetic */ NetworkPeriodicQuestion copy$default(NetworkPeriodicQuestion networkPeriodicQuestion, String str, NetworkQuestion networkQuestion, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = networkPeriodicQuestion.questionGroupName;
        }
        if ((i10 & 2) != 0) {
            networkQuestion = networkPeriodicQuestion.question;
        }
        return networkPeriodicQuestion.copy(str, networkQuestion);
    }

    public final String component1() {
        return this.questionGroupName;
    }

    public final NetworkQuestion component2() {
        return this.question;
    }

    public final NetworkPeriodicQuestion copy(String str, NetworkQuestion networkQuestion) {
        j.g(str, "questionGroupName");
        j.g(networkQuestion, "question");
        return new NetworkPeriodicQuestion(str, networkQuestion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkPeriodicQuestion)) {
            return false;
        }
        NetworkPeriodicQuestion networkPeriodicQuestion = (NetworkPeriodicQuestion) obj;
        return j.b(this.questionGroupName, networkPeriodicQuestion.questionGroupName) && j.b(this.question, networkPeriodicQuestion.question);
    }

    public final NetworkQuestion getQuestion() {
        return this.question;
    }

    public final String getQuestionGroupName() {
        return this.questionGroupName;
    }

    public int hashCode() {
        return (this.questionGroupName.hashCode() * 31) + this.question.hashCode();
    }

    public String toString() {
        return "NetworkPeriodicQuestion(questionGroupName=" + this.questionGroupName + ", question=" + this.question + PropertyUtils.MAPPED_DELIM2;
    }
}
