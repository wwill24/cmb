package g6;

import com.coffeemeetsbagel.models.enums.MatchType;
import kotlin.jvm.internal.j;

public final class g {
    public final String a(MatchType matchType) {
        j.g(matchType, "type");
        return matchType.getKey();
    }

    public final MatchType b(String str) {
        j.g(str, "s");
        return MatchType.Companion.fromKey(str);
    }
}
