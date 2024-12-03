package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.GiveTake;
import java.util.List;

public class ResponseGiveTakes {
    private String currentToken;
    private List<GiveTake> results;

    public String getCurrentToken() {
        return this.currentToken;
    }

    public List<GiveTake> getResults() {
        return this.results;
    }
}
