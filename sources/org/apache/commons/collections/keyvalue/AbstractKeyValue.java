package org.apache.commons.collections.keyvalue;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.collections.KeyValue;

public abstract class AbstractKeyValue implements KeyValue {
    protected Object key;
    protected Object value;

    protected AbstractKeyValue(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getKey());
        stringBuffer.append(SignatureVisitor.INSTANCEOF);
        stringBuffer.append(getValue());
        return stringBuffer.toString();
    }
}
