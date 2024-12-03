package za;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final f f42221a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f42222b;

    public i(f fVar, List<c> list) {
        j.g(fVar, "question");
        j.g(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        this.f42221a = fVar;
        this.f42222b = list;
    }

    public final List<c> a() {
        return this.f42222b;
    }

    public final f b() {
        return this.f42221a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return j.b(this.f42221a, iVar.f42221a) && j.b(this.f42222b, iVar.f42222b);
    }

    public int hashCode() {
        return (this.f42221a.hashCode() * 31) + this.f42222b.hashCode();
    }

    public String toString() {
        return "QuestionWithOptionsRoom(question=" + this.f42221a + ", options=" + this.f42222b + PropertyUtils.MAPPED_DELIM2;
    }
}
