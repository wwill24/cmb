package ab;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<QuestionWAnswers> f34001a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f34002b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f34003c;

    public a(List<QuestionWAnswers> list, Integer num, Integer num2) {
        j.g(list, ProfileConstants.Field.QUESTIONS);
        this.f34001a = list;
        this.f34002b = num;
        this.f34003c = num2;
    }

    public final Integer a() {
        return this.f34003c;
    }

    public final List<QuestionWAnswers> b() {
        return this.f34001a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.b(this.f34001a, aVar.f34001a) && j.b(this.f34002b, aVar.f34002b) && j.b(this.f34003c, aVar.f34003c);
    }

    public int hashCode() {
        int hashCode = this.f34001a.hashCode() * 31;
        Integer num = this.f34002b;
        int i10 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f34003c;
        if (num2 != null) {
            i10 = num2.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "QuestionGroupWQuestions(questions=" + this.f34001a + ", maxAllowed=" + this.f34002b + ", maxSubOptions=" + this.f34003c + PropertyUtils.MAPPED_DELIM2;
    }
}
