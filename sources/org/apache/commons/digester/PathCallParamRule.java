package org.apache.commons.digester;

import org.xml.sax.Attributes;

public class PathCallParamRule extends Rule {
    protected int paramIndex;

    public PathCallParamRule(int i10) {
        this.paramIndex = i10;
    }

    public void begin(String str, String str2, Attributes attributes) throws Exception {
        String match = getDigester().getMatch();
        if (match != null) {
            ((Object[]) this.digester.peekParams())[this.paramIndex] = match;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PathCallParamRule[");
        stringBuffer.append("paramIndex=");
        stringBuffer.append(this.paramIndex);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
