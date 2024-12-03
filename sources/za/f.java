package za;

import com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.enums.QuestionType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f42204a;

    /* renamed from: b  reason: collision with root package name */
    private final QuestionGroupType f42205b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42206c;

    /* renamed from: d  reason: collision with root package name */
    private final QuestionType f42207d;

    /* renamed from: e  reason: collision with root package name */
    private final String f42208e;

    /* renamed from: f  reason: collision with root package name */
    private final String f42209f;

    /* renamed from: g  reason: collision with root package name */
    private final String f42210g;

    /* renamed from: h  reason: collision with root package name */
    private final List<c> f42211h;

    /* renamed from: i  reason: collision with root package name */
    private final QuestionInteractionPolicy f42212i;

    public f(String str, QuestionGroupType questionGroupType, String str2, QuestionType questionType, String str3, String str4, String str5, List<c> list, QuestionInteractionPolicy questionInteractionPolicy) {
        j.g(str, "id");
        j.g(questionGroupType, "group");
        j.g(questionType, "type");
        j.g(str3, "label");
        j.g(str4, "text");
        j.g(str5, "name");
        j.g(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        this.f42204a = str;
        this.f42205b = questionGroupType;
        this.f42206c = str2;
        this.f42207d = questionType;
        this.f42208e = str3;
        this.f42209f = str4;
        this.f42210g = str5;
        this.f42211h = list;
        this.f42212i = questionInteractionPolicy;
    }

    public final QuestionGroupType a() {
        return this.f42205b;
    }

    public final String b() {
        return this.f42204a;
    }

    public final QuestionInteractionPolicy c() {
        return this.f42212i;
    }

    public final String d() {
        return this.f42208e;
    }

    public final String e() {
        return this.f42210g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return j.b(this.f42204a, fVar.f42204a) && this.f42205b == fVar.f42205b && j.b(this.f42206c, fVar.f42206c) && this.f42207d == fVar.f42207d && j.b(this.f42208e, fVar.f42208e) && j.b(this.f42209f, fVar.f42209f) && j.b(this.f42210g, fVar.f42210g) && j.b(this.f42211h, fVar.f42211h) && j.b(this.f42212i, fVar.f42212i);
    }

    public final List<c> f() {
        return this.f42211h;
    }

    public final String g() {
        return this.f42206c;
    }

    public final String h() {
        return this.f42209f;
    }

    public int hashCode() {
        int hashCode = ((this.f42204a.hashCode() * 31) + this.f42205b.hashCode()) * 31;
        String str = this.f42206c;
        int i10 = 0;
        int hashCode2 = (((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f42207d.hashCode()) * 31) + this.f42208e.hashCode()) * 31) + this.f42209f.hashCode()) * 31) + this.f42210g.hashCode()) * 31) + this.f42211h.hashCode()) * 31;
        QuestionInteractionPolicy questionInteractionPolicy = this.f42212i;
        if (questionInteractionPolicy != null) {
            i10 = questionInteractionPolicy.hashCode();
        }
        return hashCode2 + i10;
    }

    public final QuestionType i() {
        return this.f42207d;
    }

    public String toString() {
        return "QuestionEntity(id=" + this.f42204a + ", group=" + this.f42205b + ", placeholder=" + this.f42206c + ", type=" + this.f42207d + ", label=" + this.f42208e + ", text=" + this.f42209f + ", name=" + this.f42210g + ", options=" + this.f42211h + ", interactionPolicy=" + this.f42212i + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(java.lang.String r12, com.coffeemeetsbagel.models.enums.QuestionGroupType r13, java.lang.String r14, com.coffeemeetsbagel.models.enums.QuestionType r15, java.lang.String r16, java.lang.String r17, com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy r18, java.lang.String r19) {
        /*
            r11 = this;
            java.lang.String r0 = "id"
            r2 = r12
            kotlin.jvm.internal.j.g(r12, r0)
            java.lang.String r0 = "group"
            r3 = r13
            kotlin.jvm.internal.j.g(r13, r0)
            java.lang.String r0 = "type"
            r5 = r15
            kotlin.jvm.internal.j.g(r15, r0)
            java.lang.String r0 = "label"
            r6 = r16
            kotlin.jvm.internal.j.g(r6, r0)
            java.lang.String r0 = "text"
            r7 = r17
            kotlin.jvm.internal.j.g(r7, r0)
            java.lang.String r0 = "name"
            r8 = r19
            kotlin.jvm.internal.j.g(r8, r0)
            java.util.List r9 = kotlin.collections.q.j()
            r1 = r11
            r4 = r14
            r10 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: za.f.<init>(java.lang.String, com.coffeemeetsbagel.models.enums.QuestionGroupType, java.lang.String, com.coffeemeetsbagel.models.enums.QuestionType, java.lang.String, java.lang.String, com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy, java.lang.String):void");
    }
}
