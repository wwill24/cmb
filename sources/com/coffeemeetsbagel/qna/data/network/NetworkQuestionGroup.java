package com.coffeemeetsbagel.qna.data.network;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkQuestionGroup implements Serializable {
    private final List<NetworkAnswer> answers;

    /* renamed from: id  reason: collision with root package name */
    private final String f36269id;
    @c("interaction_policy")
    private final QuestionGroupInteractionPolicy interactionPolicy;
    private final String name;
    private final List<NetworkQuestion> questions;

    public NetworkQuestionGroup(String str, String str2, QuestionGroupInteractionPolicy questionGroupInteractionPolicy, List<NetworkQuestion> list, List<NetworkAnswer> list2) {
        j.g(str, "id");
        j.g(str2, "name");
        j.g(list, ProfileConstants.Field.QUESTIONS);
        this.f36269id = str;
        this.name = str2;
        this.interactionPolicy = questionGroupInteractionPolicy;
        this.questions = list;
        this.answers = list2;
    }

    public static /* synthetic */ NetworkQuestionGroup copy$default(NetworkQuestionGroup networkQuestionGroup, String str, String str2, QuestionGroupInteractionPolicy questionGroupInteractionPolicy, List<NetworkQuestion> list, List<NetworkAnswer> list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = networkQuestionGroup.f36269id;
        }
        if ((i10 & 2) != 0) {
            str2 = networkQuestionGroup.name;
        }
        String str3 = str2;
        if ((i10 & 4) != 0) {
            questionGroupInteractionPolicy = networkQuestionGroup.interactionPolicy;
        }
        QuestionGroupInteractionPolicy questionGroupInteractionPolicy2 = questionGroupInteractionPolicy;
        if ((i10 & 8) != 0) {
            list = networkQuestionGroup.questions;
        }
        List<NetworkQuestion> list3 = list;
        if ((i10 & 16) != 0) {
            list2 = networkQuestionGroup.answers;
        }
        return networkQuestionGroup.copy(str, str3, questionGroupInteractionPolicy2, list3, list2);
    }

    public final String component1() {
        return this.f36269id;
    }

    public final String component2() {
        return this.name;
    }

    public final QuestionGroupInteractionPolicy component3() {
        return this.interactionPolicy;
    }

    public final List<NetworkQuestion> component4() {
        return this.questions;
    }

    public final List<NetworkAnswer> component5() {
        return this.answers;
    }

    public final NetworkQuestionGroup copy(String str, String str2, QuestionGroupInteractionPolicy questionGroupInteractionPolicy, List<NetworkQuestion> list, List<NetworkAnswer> list2) {
        j.g(str, "id");
        j.g(str2, "name");
        j.g(list, ProfileConstants.Field.QUESTIONS);
        return new NetworkQuestionGroup(str, str2, questionGroupInteractionPolicy, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkQuestionGroup)) {
            return false;
        }
        NetworkQuestionGroup networkQuestionGroup = (NetworkQuestionGroup) obj;
        return j.b(this.f36269id, networkQuestionGroup.f36269id) && j.b(this.name, networkQuestionGroup.name) && j.b(this.interactionPolicy, networkQuestionGroup.interactionPolicy) && j.b(this.questions, networkQuestionGroup.questions) && j.b(this.answers, networkQuestionGroup.answers);
    }

    public final List<NetworkAnswer> getAnswers() {
        return this.answers;
    }

    public final String getId() {
        return this.f36269id;
    }

    public final QuestionGroupInteractionPolicy getInteractionPolicy() {
        return this.interactionPolicy;
    }

    public final String getName() {
        return this.name;
    }

    public final List<NetworkQuestion> getQuestions() {
        return this.questions;
    }

    public int hashCode() {
        int hashCode = ((this.f36269id.hashCode() * 31) + this.name.hashCode()) * 31;
        QuestionGroupInteractionPolicy questionGroupInteractionPolicy = this.interactionPolicy;
        int i10 = 0;
        int hashCode2 = (((hashCode + (questionGroupInteractionPolicy == null ? 0 : questionGroupInteractionPolicy.hashCode())) * 31) + this.questions.hashCode()) * 31;
        List<NetworkAnswer> list = this.answers;
        if (list != null) {
            i10 = list.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "NetworkQuestionGroup(id=" + this.f36269id + ", name=" + this.name + ", interactionPolicy=" + this.interactionPolicy + ", questions=" + this.questions + ", answers=" + this.answers + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkQuestionGroup(String str, String str2, QuestionGroupInteractionPolicy questionGroupInteractionPolicy, List list, List list2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? null : questionGroupInteractionPolicy, list, (i10 & 16) != 0 ? null : list2);
    }
}
