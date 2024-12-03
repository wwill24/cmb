package org.apache.commons.digester;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.logging.Log;

public class SetTopRule extends Rule {
    protected String methodName;
    protected String paramType;
    protected boolean useExactMatch;

    public SetTopRule(Digester digester, String str) {
        this(str);
    }

    public void end() throws Exception {
        Object peek = this.digester.peek(0);
        Object peek2 = this.digester.peek(1);
        if (this.digester.log.isDebugEnabled()) {
            if (peek == null) {
                Log log = this.digester.log;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[SetTopRule]{");
                stringBuffer.append(this.digester.match);
                stringBuffer.append("} Call [NULL CHILD].");
                stringBuffer.append(this.methodName);
                stringBuffer.append("(");
                stringBuffer.append(peek2);
                stringBuffer.append(")");
                log.debug(stringBuffer.toString());
            } else {
                Log log2 = this.digester.log;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[SetTopRule]{");
                stringBuffer2.append(this.digester.match);
                stringBuffer2.append("} Call ");
                stringBuffer2.append(peek.getClass().getName());
                stringBuffer2.append(".");
                stringBuffer2.append(this.methodName);
                stringBuffer2.append("(");
                stringBuffer2.append(peek2);
                stringBuffer2.append(")");
                log2.debug(stringBuffer2.toString());
            }
        }
        Class[] clsArr = new Class[1];
        if (this.paramType != null) {
            clsArr[0] = this.digester.getClassLoader().loadClass(this.paramType);
        } else {
            clsArr[0] = peek2.getClass();
        }
        if (this.useExactMatch) {
            MethodUtils.invokeExactMethod(peek, this.methodName, new Object[]{peek2}, clsArr);
            return;
        }
        MethodUtils.invokeMethod(peek, this.methodName, new Object[]{peek2}, clsArr);
    }

    public boolean isExactMatch() {
        return this.useExactMatch;
    }

    public void setExactMatch(boolean z10) {
        this.useExactMatch = z10;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SetTopRule[");
        stringBuffer.append("methodName=");
        stringBuffer.append(this.methodName);
        stringBuffer.append(", paramType=");
        stringBuffer.append(this.paramType);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public SetTopRule(Digester digester, String str, String str2) {
        this(str, str2);
    }

    public SetTopRule(String str) {
        this(str, (String) null);
    }

    public SetTopRule(String str, String str2) {
        this.useExactMatch = false;
        this.methodName = str;
        this.paramType = str2;
    }
}
