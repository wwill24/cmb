package com.coffeemeetsbagel.match_prefs;

import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final MatchPreference$Type f34591a;

    /* renamed from: b  reason: collision with root package name */
    private final QuestionWAnswers f34592b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f34593c;

    public f(MatchPreference$Type matchPreference$Type, QuestionWAnswers questionWAnswers, boolean z10) {
        j.g(matchPreference$Type, "type");
        this.f34591a = matchPreference$Type;
        this.f34592b = questionWAnswers;
        this.f34593c = z10;
    }

    public final QuestionWAnswers a() {
        return this.f34592b;
    }

    public final MatchPreference$Type b() {
        return this.f34591a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f34591a != fVar.f34591a || !j.b(this.f34592b, fVar.f34592b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f34591a, this.f34592b});
    }

    public String toString() {
        return "MatchPrefUiItem(type=" + this.f34591a + ", question=" + this.f34592b + ", locked=" + this.f34593c + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(MatchPreference$Type matchPreference$Type, QuestionWAnswers questionWAnswers, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(matchPreference$Type, (i10 & 2) != 0 ? null : questionWAnswers, (i10 & 4) != 0 ? false : z10);
    }
}
