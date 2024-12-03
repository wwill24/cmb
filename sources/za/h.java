package za;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final g f42219a;

    /* renamed from: b  reason: collision with root package name */
    private final List<i> f42220b;

    public h(g gVar, List<i> list) {
        j.g(gVar, "questionGroup");
        j.g(list, ProfileConstants.Field.QUESTIONS);
        this.f42219a = gVar;
        this.f42220b = list;
    }

    public final g a() {
        return this.f42219a;
    }

    public final List<i> b() {
        return this.f42220b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return j.b(this.f42219a, hVar.f42219a) && j.b(this.f42220b, hVar.f42220b);
    }

    public int hashCode() {
        return (this.f42219a.hashCode() * 31) + this.f42220b.hashCode();
    }

    public String toString() {
        return "QuestionGroupWithQuestionsRoom(questionGroup=" + this.f42219a + ", questions=" + this.f42220b + PropertyUtils.MAPPED_DELIM2;
    }
}
