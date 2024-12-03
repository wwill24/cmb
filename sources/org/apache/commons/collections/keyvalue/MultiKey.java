package org.apache.commons.collections.keyvalue;

import java.io.Serializable;
import java.util.Arrays;

public class MultiKey implements Serializable {
    private static final long serialVersionUID = 4465448607415788805L;
    private transient int hashCode;
    private final Object[] keys;

    public MultiKey(Object obj, Object obj2) {
        this(new Object[]{obj, obj2}, false);
    }

    private void calculateHashCode(Object[] objArr) {
        int i10 = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                i10 ^= obj.hashCode();
            }
        }
        this.hashCode = i10;
    }

    private Object readResolve() {
        calculateHashCode(this.keys);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiKey) {
            return Arrays.equals(this.keys, ((MultiKey) obj).keys);
        }
        return false;
    }

    public Object getKey(int i10) {
        return this.keys[i10];
    }

    public Object[] getKeys() {
        return (Object[]) this.keys.clone();
    }

    public int hashCode() {
        return this.hashCode;
    }

    public int size() {
        return this.keys.length;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MultiKey");
        stringBuffer.append(Arrays.asList(this.keys).toString());
        return stringBuffer.toString();
    }

    public MultiKey(Object obj, Object obj2, Object obj3) {
        this(new Object[]{obj, obj2, obj3}, false);
    }

    public MultiKey(Object obj, Object obj2, Object obj3, Object obj4) {
        this(new Object[]{obj, obj2, obj3, obj4}, false);
    }

    public MultiKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this(new Object[]{obj, obj2, obj3, obj4, obj5}, false);
    }

    public MultiKey(Object[] objArr) {
        this(objArr, true);
    }

    public MultiKey(Object[] objArr, boolean z10) {
        if (objArr != null) {
            if (z10) {
                this.keys = (Object[]) objArr.clone();
            } else {
                this.keys = objArr;
            }
            calculateHashCode(objArr);
            return;
        }
        throw new IllegalArgumentException("The array of keys must not be null");
    }
}
