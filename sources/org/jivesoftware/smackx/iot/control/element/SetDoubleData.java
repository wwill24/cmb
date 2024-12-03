package org.jivesoftware.smackx.iot.control.element;

import org.jivesoftware.smackx.iot.control.element.SetData;

public class SetDoubleData extends SetData {
    private Double doubleCache;

    public SetDoubleData(String str, double d10) {
        this(str, Double.toString(d10));
        this.doubleCache = Double.valueOf(d10);
    }

    public Double getDoubleValue() {
        if (this.doubleCache != null) {
            this.doubleCache = Double.valueOf(getValue());
        }
        return this.doubleCache;
    }

    protected SetDoubleData(String str, String str2) {
        super(str, SetData.Type.DOUBLE, str2);
    }
}
