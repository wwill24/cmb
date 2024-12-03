package com.coffeemeetsbagel.models.enums;

import com.coffeemeetsbagel.models.interfaces.ApiParameterizable;
import java.util.ArrayList;
import java.util.List;

public enum Religion implements ApiParameterizable {
    BUDDHIST("Buddhist"),
    CHRISTIAN("Christian"),
    CATHOLIC("Catholic"),
    HINDU("Hindu"),
    JEWISH("Jewish"),
    MUSLIM("Muslim"),
    SIKH("Sikh"),
    SHINTO("Shinto"),
    SPIRITUAL_BUT_NOT_RELIGIOUS("Spiritual but not religious"),
    NEITHER_SPIRITUAL_NOR_RELIGIOUS("Neither religious nor spiritual"),
    OTHER("Other");
    
    private String mApiParam;

    private Religion(String str) {
        this.mApiParam = str;
    }

    public static List<String> getApiParams() {
        ArrayList arrayList = new ArrayList(values().length);
        for (Religion apiParam : values()) {
            arrayList.add(apiParam.getApiParam());
        }
        return arrayList;
    }

    public static int getIndex(String str) {
        for (Religion religion : values()) {
            if (religion.getApiParam().equals(str)) {
                return religion.ordinal();
            }
        }
        return OTHER.ordinal();
    }

    public String getApiParam() {
        return this.mApiParam;
    }
}
