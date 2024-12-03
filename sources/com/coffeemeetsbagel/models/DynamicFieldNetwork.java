package com.coffeemeetsbagel.models;

import java.io.Serializable;
import lg.c;

public class DynamicFieldNetwork implements Serializable, Model {
    private final String label;
    @c("show_order")
    private final int showOrder;
    private final String value;

    public DynamicFieldNetwork(String str, String str2, int i10) {
        this.label = str;
        this.value = str2;
        this.showOrder = i10;
    }

    public String getLabel() {
        return this.label;
    }

    public int getShowOrder() {
        return this.showOrder;
    }

    public String getValue() {
        return this.value;
    }
}
