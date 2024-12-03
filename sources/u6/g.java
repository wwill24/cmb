package u6;

import com.coffeemeetsbagel.models.entities.MatchEntity;
import com.coffeemeetsbagel.models.enums.MatchAction;
import com.coffeemeetsbagel.models.enums.MatchType;
import j$.time.OffsetDateTime;
import java.util.List;
import qj.h;
import qj.w;

public interface g {
    int a(MatchType matchType, OffsetDateTime offsetDateTime, List<String> list);

    int c(String str, MatchAction matchAction);

    int f(MatchType matchType);

    w<Integer> g(String str, boolean z10);

    int i(List<MatchEntity> list);

    h<List<MatchEntity>> j(String str);
}
