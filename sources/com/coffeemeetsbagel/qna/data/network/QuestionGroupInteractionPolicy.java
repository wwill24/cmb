package com.coffeemeetsbagel.qna.data.network;

import java.io.Serializable;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class QuestionGroupInteractionPolicy implements Serializable {
    private final Integer max;
    @c("max_sub_options")
    private final Integer maxSubOptions;

    public QuestionGroupInteractionPolicy(Integer num, Integer num2) {
        this.max = num;
        this.maxSubOptions = num2;
    }

    public static /* synthetic */ QuestionGroupInteractionPolicy copy$default(QuestionGroupInteractionPolicy questionGroupInteractionPolicy, Integer num, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = questionGroupInteractionPolicy.max;
        }
        if ((i10 & 2) != 0) {
            num2 = questionGroupInteractionPolicy.maxSubOptions;
        }
        return questionGroupInteractionPolicy.copy(num, num2);
    }

    public final Integer component1() {
        return this.max;
    }

    public final Integer component2() {
        return this.maxSubOptions;
    }

    public final QuestionGroupInteractionPolicy copy(Integer num, Integer num2) {
        return new QuestionGroupInteractionPolicy(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuestionGroupInteractionPolicy)) {
            return false;
        }
        QuestionGroupInteractionPolicy questionGroupInteractionPolicy = (QuestionGroupInteractionPolicy) obj;
        return j.b(this.max, questionGroupInteractionPolicy.max) && j.b(this.maxSubOptions, questionGroupInteractionPolicy.maxSubOptions);
    }

    public final Integer getMax() {
        return this.max;
    }

    public final Integer getMaxSubOptions() {
        return this.maxSubOptions;
    }

    public int hashCode() {
        Integer num = this.max;
        int i10 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.maxSubOptions;
        if (num2 != null) {
            i10 = num2.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return "QuestionGroupInteractionPolicy(max=" + this.max + ", maxSubOptions=" + this.maxSubOptions + PropertyUtils.MAPPED_DELIM2;
    }
}
