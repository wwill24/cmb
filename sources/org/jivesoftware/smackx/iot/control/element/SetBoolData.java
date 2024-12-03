package org.jivesoftware.smackx.iot.control.element;

import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smackx.iot.control.element.SetData;

public class SetBoolData extends SetData {
    private Boolean booleanCache;

    public SetBoolData(String str, boolean z10) {
        this(str, Boolean.toString(z10));
        this.booleanCache = Boolean.valueOf(z10);
    }

    public Boolean getBooleanValue() {
        if (this.booleanCache != null) {
            this.booleanCache = Boolean.valueOf(ParserUtils.parseXmlBoolean(getValue()));
        }
        return this.booleanCache;
    }

    protected SetBoolData(String str, String str2) {
        super(str, SetData.Type.BOOL, str2);
    }
}
