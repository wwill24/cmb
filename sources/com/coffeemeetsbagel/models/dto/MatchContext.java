package com.coffeemeetsbagel.models.dto;

import java.io.Serializable;

public interface MatchContext extends Serializable {
    String getBody();

    String getIcon();

    String getMatchId();

    String getTitle();
}
