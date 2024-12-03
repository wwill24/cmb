package com.facebook.stetho.server.http;

import java.util.ArrayList;

public class LightHttpMessage {
    public final ArrayList<String> headerNames = new ArrayList<>();
    public final ArrayList<String> headerValues = new ArrayList<>();

    public void addHeader(String str, String str2) {
        this.headerNames.add(str);
        this.headerValues.add(str2);
    }

    public String getFirstHeaderValue(String str) {
        int size = this.headerNames.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equals(this.headerNames.get(i10))) {
                return this.headerValues.get(i10);
            }
        }
        return null;
    }

    public void reset() {
        this.headerNames.clear();
        this.headerValues.clear();
    }
}
