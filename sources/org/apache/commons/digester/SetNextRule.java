package org.apache.commons.digester;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.logging.Log;

public class SetNextRule extends Rule {
    protected String methodName;
    protected String paramType;
    protected boolean useExactMatch;

    public SetNextRule(Digester digester, String str) {
        this(str);
    }

    public void end() throws Exception {
        Object peek = this.digester.peek(0);
        Object peek2 = this.digester.peek(1);
        if (this.digester.log.isDebugEnabled()) {
            if (peek2 == null) {
                Log log = this.digester.log;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[SetNextRule]{");
                stringBuffer.append(this.digester.match);
                stringBuffer.append("} Call [NULL PARENT].");
                stringBuffer.append(this.methodName);
                stringBuffer.append("(");
                stringBuffer.append(peek);
                stringBuffer.append(")");
                log.debug(stringBuffer.toString());
            } else {
                Log log2 = this.digester.log;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[SetNextRule]{");
                stringBuffer2.append(this.digester.match);
                stringBuffer2.append("} Call ");
                stringBuffer2.append(peek2.getClass().getName());
                stringBuffer2.append(".");
                stringBuffer2.append(this.methodName);
                stringBuffer2.append("(");
                stringBuffer2.append(peek);
                stringBuffer2.append(")");
                log2.debug(stringBuffer2.toString());
            }
        }
        Class[] clsArr = new Class[1];
        if (this.paramType != null) {
            clsArr[0] = this.digester.getClassLoader().loadClass(this.paramType);
        } else {
            clsArr[0] = peek.getClass();
        }
        if (this.useExactMatch) {
            MethodUtils.invokeExactMethod(peek2, this.methodName, new Object[]{peek}, clsArr);
            return;
        }
        MethodUtils.invokeMethod(peek2, this.methodName, new Object[]{peek}, clsArr);
    }

    public boolean isExactMatch() {
        return this.useExactMatch;
    }

    public void setExactMatch(boolean z10) {
        this.useExactMatch = z10;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SetNextRule[");
        stringBuffer.append("methodName=");
        stringBuffer.append(this.methodName);
        stringBuffer.append(", paramType=");
        stringBuffer.append(this.paramType);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public SetNextRule(Digester digester, String str, String str2) {
        this(str, str2);
    }

    public SetNextRule(String str) {
        this(str, (String) null);
    }

    public SetNextRule(String str, String str2) {
        this.useExactMatch = false;
        this.methodName = str;
        this.paramType = str2;
    }
}
