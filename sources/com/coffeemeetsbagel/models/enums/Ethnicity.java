package com.coffeemeetsbagel.models.enums;

import com.coffeemeetsbagel.models.interfaces.ApiParameterizable;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.List;

public enum Ethnicity implements ApiParameterizable {
    ASIAN("Asian"),
    ARAB("Arab"),
    BLACK("Black/African-descent"),
    HISPANIC("Hispanic/Latino"),
    NATIVE("Native American"),
    ISLANDER("Pacific Islander"),
    SOUTH_ASIAN("South Asian"),
    WHITE("White/Caucasian"),
    OTHER("Other");
    
    private String mApiParam;

    private Ethnicity(String str) {
        this.mApiParam = str;
    }

    public static String assemble(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (arrayList.size() > 0) {
            sb2.append(arrayList.get(0));
        }
        for (int i10 = 1; i10 < arrayList.size(); i10++) {
            sb2.append(AppsFlyerKit.COMMA);
            sb2.append(arrayList.get(i10));
        }
        return sb2.toString();
    }

    public static Ethnicity fromApiParam(String str) {
        for (Ethnicity ethnicity : values()) {
            if (ethnicity.getApiParam().equals(str)) {
                return ethnicity;
            }
        }
        return OTHER;
    }

    public static List<String> getApiParams() {
        ArrayList arrayList = new ArrayList(values().length);
        for (Ethnicity apiParam : values()) {
            arrayList.add(apiParam.getApiParam());
        }
        return arrayList;
    }

    public static int getIndex(String str) {
        for (Ethnicity ethnicity : values()) {
            if (ethnicity.getApiParam().equals(str)) {
                return ethnicity.ordinal();
            }
        }
        return OTHER.ordinal();
    }

    public String getApiParam() {
        return this.mApiParam;
    }
}
