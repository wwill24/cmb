package org.jivesoftware.smackx.iot.control.element;

import org.jivesoftware.smackx.iot.control.element.SetData;

public class SetIntData extends SetData {
    private Integer integerCache;

    public SetIntData(String str, int i10) {
        this(str, Integer.toString(i10));
        this.integerCache = Integer.valueOf(i10);
    }

    public Integer getIntegerValue() {
        if (this.integerCache != null) {
            this.integerCache = Integer.valueOf(getValue());
        }
        return this.integerCache;
    }

    protected SetIntData(String str, String str2) {
        super(str, SetData.Type.INT, str2);
    }
}
