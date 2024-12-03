package org.jivesoftware.smackx.iot.control.element;

import org.jivesoftware.smackx.iot.control.element.SetData;

public class SetLongData extends SetData {
    private Long longCache;

    public SetLongData(String str, long j10) {
        this(str, Long.toString(j10));
        this.longCache = Long.valueOf(j10);
    }

    public Long getLongValue() {
        if (this.longCache != null) {
            this.longCache = Long.valueOf(getValue());
        }
        return this.longCache;
    }

    protected SetLongData(String str, String str2) {
        super(str, SetData.Type.LONG, str2);
    }
}
