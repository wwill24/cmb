package g6;

import com.coffeemeetsbagel.models.enums.MatchAction;
import kotlin.jvm.internal.j;

public final class f {
    public final MatchAction a(int i10) {
        return MatchAction.Companion.fromId(i10);
    }

    public final int b(MatchAction matchAction) {
        j.g(matchAction, "matchAction");
        return matchAction.getId();
    }
}
