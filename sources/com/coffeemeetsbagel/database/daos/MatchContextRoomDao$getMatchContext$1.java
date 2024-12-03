package com.coffeemeetsbagel.database.daos;

import com.coffeemeetsbagel.models.dto.MatchContext;
import com.coffeemeetsbagel.models.entities.MatchContextEntity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class MatchContextRoomDao$getMatchContext$1 extends Lambda implements Function1<MatchContextEntity, MatchContext> {

    /* renamed from: a  reason: collision with root package name */
    public static final MatchContextRoomDao$getMatchContext$1 f11609a = new MatchContextRoomDao$getMatchContext$1();

    MatchContextRoomDao$getMatchContext$1() {
        super(1);
    }

    /* renamed from: a */
    public final MatchContext invoke(final MatchContextEntity matchContextEntity) {
        j.g(matchContextEntity, "it");
        return new MatchContext() {
            public String getBody() {
                return matchContextEntity.getBody();
            }

            public String getIcon() {
                return matchContextEntity.getIcon();
            }

            public String getMatchId() {
                return matchContextEntity.getMatchId();
            }

            public String getTitle() {
                return matchContextEntity.getTitle();
            }
        };
    }
}
