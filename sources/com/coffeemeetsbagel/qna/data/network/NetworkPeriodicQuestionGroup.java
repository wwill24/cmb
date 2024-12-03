package com.coffeemeetsbagel.qna.data.network;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkPeriodicQuestionGroup implements Serializable {
    private final List<NetworkPeriodicQuestion> questions;

    public NetworkPeriodicQuestionGroup(List<NetworkPeriodicQuestion> list) {
        j.g(list, ProfileConstants.Field.QUESTIONS);
        this.questions = list;
    }

    public static /* synthetic */ NetworkPeriodicQuestionGroup copy$default(NetworkPeriodicQuestionGroup networkPeriodicQuestionGroup, List<NetworkPeriodicQuestion> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = networkPeriodicQuestionGroup.questions;
        }
        return networkPeriodicQuestionGroup.copy(list);
    }

    public final List<NetworkPeriodicQuestion> component1() {
        return this.questions;
    }

    public final NetworkPeriodicQuestionGroup copy(List<NetworkPeriodicQuestion> list) {
        j.g(list, ProfileConstants.Field.QUESTIONS);
        return new NetworkPeriodicQuestionGroup(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkPeriodicQuestionGroup) && j.b(this.questions, ((NetworkPeriodicQuestionGroup) obj).questions);
    }

    public final List<NetworkPeriodicQuestion> getQuestions() {
        return this.questions;
    }

    public int hashCode() {
        return this.questions.hashCode();
    }

    public String toString() {
        return "NetworkPeriodicQuestionGroup(questions=" + this.questions + PropertyUtils.MAPPED_DELIM2;
    }
}
