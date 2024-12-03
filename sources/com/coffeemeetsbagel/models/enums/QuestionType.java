package com.coffeemeetsbagel.models.enums;

import com.leanplum.internal.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum QuestionType {
    TEXT("text"),
    SINGLE_CHOICE("single_choice"),
    MULTIPLE_CHOICE("multiple_choice"),
    INTEGER(Constants.Kinds.INT),
    NUMERIC("numeric"),
    FLOAT(Constants.Kinds.FLOAT),
    RANGE("range"),
    JSON("json_type"),
    NONE("");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, QuestionType> map = null;
    private final String questionTypeApiString;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final QuestionType fromApiString(String str) {
            j.g(str, "apiString");
            try {
                return (QuestionType) h0.j(QuestionType.map, str);
            } catch (NoSuchElementException unused) {
                return QuestionType.NONE;
            }
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        QuestionType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (QuestionType questionType : values) {
            linkedHashMap.put(questionType.questionTypeApiString, questionType);
        }
        map = linkedHashMap;
    }

    private QuestionType(String str) {
        this.questionTypeApiString = str;
    }

    public final String getQuestionTypeApiString() {
        return this.questionTypeApiString;
    }
}
