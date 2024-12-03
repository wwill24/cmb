package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.Bagel;
import java.util.List;

public class ResponseBagels extends ResponseGeneric {
    private String currentToken;
    private String cursorAfter;
    private String cursorBefore;
    private boolean moreAfter;
    private boolean moreBefore;
    private List<Bagel> results;

    public String getCurrentToken() {
        return this.currentToken;
    }

    public String getCursorAfter() {
        return this.cursorAfter;
    }

    public String getCursorBefore() {
        return this.cursorBefore;
    }

    public List<Bagel> getResults() {
        return this.results;
    }

    public boolean isMoreAfter() {
        return this.moreAfter;
    }

    public boolean isMoreBefore() {
        return this.moreBefore;
    }

    public void setCurrentToken(String str) {
        this.currentToken = str;
    }

    public void setCursorAfter(String str) {
        this.cursorAfter = str;
    }

    public void setCursorBefore(String str) {
        this.cursorBefore = str;
    }

    public void setMoreAfter(boolean z10) {
        this.moreAfter = z10;
    }

    public void setMoreBefore(boolean z10) {
        this.moreBefore = z10;
    }
}
