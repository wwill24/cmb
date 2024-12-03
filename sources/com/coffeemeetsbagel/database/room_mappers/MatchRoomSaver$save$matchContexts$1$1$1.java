package com.coffeemeetsbagel.database.room_mappers;

import com.coffeemeetsbagel.models.dto.MatchContext;

public final class MatchRoomSaver$save$matchContexts$1$1$1 implements MatchContext {
    final /* synthetic */ String $bagelId;
    final /* synthetic */ com.coffeemeetsbagel.models.MatchContext $it;

    MatchRoomSaver$save$matchContexts$1$1$1(String str, com.coffeemeetsbagel.models.MatchContext matchContext) {
        this.$bagelId = str;
        this.$it = matchContext;
    }

    public String getBody() {
        return this.$it.getMatchContextV2().getBody();
    }

    public String getIcon() {
        return this.$it.getMatchContextV2().getIcon();
    }

    public String getMatchId() {
        return this.$bagelId;
    }

    public String getTitle() {
        return this.$it.getMatchContextV2().getTitle();
    }
}
