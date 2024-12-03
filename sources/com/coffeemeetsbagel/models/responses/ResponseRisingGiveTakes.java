package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.RisingGiveTake;
import java.util.List;

public class ResponseRisingGiveTakes {
    private String currentToken;
    private List<RisingGiveTake> results;

    public String getCurrentToken() {
        return this.currentToken;
    }

    public List<RisingGiveTake> getResults() {
        return this.results;
    }
}
