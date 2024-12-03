package org.apache.commons.digester;

import org.apache.commons.collections.ArrayStack;
import org.xml.sax.Attributes;

public class CallParamRule extends Rule {
    protected String attributeName;
    protected ArrayStack bodyTextStack;
    protected boolean fromStack;
    protected int paramIndex;
    protected int stackIndex;

    public CallParamRule(Digester digester, int i10) {
        this(i10);
    }

    public void begin(Attributes attributes) throws Exception {
        Object obj;
        String str = this.attributeName;
        if (str != null) {
            obj = attributes.getValue(str);
        } else if (this.fromStack) {
            obj = this.digester.peek(this.stackIndex);
            if (this.digester.log.isDebugEnabled()) {
                StringBuffer stringBuffer = new StringBuffer("[CallParamRule]{");
                stringBuffer.append(this.digester.match);
                stringBuffer.append("} Save from stack; from stack?");
                stringBuffer.append(this.fromStack);
                stringBuffer.append("; object=");
                stringBuffer.append(obj);
                this.digester.log.debug(stringBuffer.toString());
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            ((Object[]) this.digester.peekParams())[this.paramIndex] = obj;
        }
    }

    public void body(String str) throws Exception {
        if (this.attributeName == null && !this.fromStack) {
            if (this.bodyTextStack == null) {
                this.bodyTextStack = new ArrayStack();
            }
            this.bodyTextStack.push(str.trim());
        }
    }

    public void end(String str, String str2) {
        ArrayStack arrayStack = this.bodyTextStack;
        if (arrayStack != null && !arrayStack.empty()) {
            ((Object[]) this.digester.peekParams())[this.paramIndex] = this.bodyTextStack.pop();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CallParamRule[");
        stringBuffer.append("paramIndex=");
        stringBuffer.append(this.paramIndex);
        stringBuffer.append(", attributeName=");
        stringBuffer.append(this.attributeName);
        stringBuffer.append(", from stack=");
        stringBuffer.append(this.fromStack);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public CallParamRule(Digester digester, int i10, String str) {
        this(i10, str);
    }

    public CallParamRule(int i10) {
        this(i10, (String) null);
    }

    public CallParamRule(int i10, String str) {
        this.fromStack = false;
        this.stackIndex = 0;
        this.paramIndex = i10;
        this.attributeName = str;
    }

    public CallParamRule(int i10, boolean z10) {
        this.attributeName = null;
        this.stackIndex = 0;
        this.paramIndex = i10;
        this.fromStack = z10;
    }

    public CallParamRule(int i10, int i11) {
        this.attributeName = null;
        this.paramIndex = i10;
        this.fromStack = true;
        this.stackIndex = i11;
    }
}
