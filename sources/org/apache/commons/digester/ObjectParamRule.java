package org.apache.commons.digester;

import org.xml.sax.Attributes;

public class ObjectParamRule extends Rule {
    protected String attributeName;
    protected Object param;
    protected int paramIndex;

    public ObjectParamRule(int i10, Object obj) {
        this(i10, (String) null, obj);
    }

    public void begin(String str, String str2, Attributes attributes) throws Exception {
        Object[] objArr = (Object[]) this.digester.peekParams();
        String str3 = this.attributeName;
        if (str3 == null) {
            objArr[this.paramIndex] = this.param;
        } else if (attributes.getValue(str3) != null) {
            objArr[this.paramIndex] = this.param;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ObjectParamRule[");
        stringBuffer.append("paramIndex=");
        stringBuffer.append(this.paramIndex);
        stringBuffer.append(", attributeName=");
        stringBuffer.append(this.attributeName);
        stringBuffer.append(", param=");
        stringBuffer.append(this.param);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public ObjectParamRule(int i10, String str, Object obj) {
        this.paramIndex = i10;
        this.attributeName = str;
        this.param = obj;
    }
}
