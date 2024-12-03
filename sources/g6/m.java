package g6;

import com.coffeemeetsbagel.models.enums.QuestionType;
import kotlin.jvm.internal.j;

public final class m {
    public final String a(QuestionType questionType) {
        j.g(questionType, "questionType");
        return questionType.getQuestionTypeApiString();
    }

    public final QuestionType b(String str) {
        j.g(str, "questionTypeString");
        return QuestionType.Companion.fromApiString(str);
    }
}
