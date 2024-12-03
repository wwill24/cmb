package g6;

import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import kotlin.jvm.internal.j;

public final class l {
    public final String a(QuestionGroupType questionGroupType) {
        j.g(questionGroupType, "questionGroup");
        return questionGroupType.getQuestionGroupApiString();
    }

    public final QuestionGroupType b(String str) {
        j.g(str, "questionGroupString");
        return QuestionGroupType.Companion.fromApiString(str);
    }
}
