package com.coffeemeetsbagel.models.entities;

import java.io.Serializable;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class QuestionInteractionPolicy implements Serializable {
    @c("max_options")
    private final Integer maxOptions;

    public QuestionInteractionPolicy(Integer num) {
        this.maxOptions = num;
    }

    public static /* synthetic */ QuestionInteractionPolicy copy$default(QuestionInteractionPolicy questionInteractionPolicy, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = questionInteractionPolicy.maxOptions;
        }
        return questionInteractionPolicy.copy(num);
    }

    public final Integer component1() {
        return this.maxOptions;
    }

    public final QuestionInteractionPolicy copy(Integer num) {
        return new QuestionInteractionPolicy(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QuestionInteractionPolicy) && j.b(this.maxOptions, ((QuestionInteractionPolicy) obj).maxOptions);
    }

    public final Integer getMaxOptions() {
        return this.maxOptions;
    }

    public int hashCode() {
        Integer num = this.maxOptions;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "QuestionInteractionPolicy(maxOptions=" + this.maxOptions + PropertyUtils.MAPPED_DELIM2;
    }
}
