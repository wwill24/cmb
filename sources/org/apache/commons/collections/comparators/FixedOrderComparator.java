package org.apache.commons.collections.comparators;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FixedOrderComparator implements Comparator {
    public static final int UNKNOWN_AFTER = 1;
    public static final int UNKNOWN_BEFORE = 0;
    public static final int UNKNOWN_THROW_EXCEPTION = 2;
    private int counter;
    private boolean isLocked;
    private final Map map;
    private int unknownObjectBehavior;

    public FixedOrderComparator() {
        this.map = new HashMap();
        this.counter = 0;
        this.isLocked = false;
        this.unknownObjectBehavior = 2;
    }

    public boolean add(Object obj) {
        checkLocked();
        Map map2 = this.map;
        int i10 = this.counter;
        this.counter = i10 + 1;
        if (map2.put(obj, new Integer(i10)) == null) {
            return true;
        }
        return false;
    }

    public boolean addAsEqual(Object obj, Object obj2) {
        checkLocked();
        Integer num = (Integer) this.map.get(obj);
        if (num == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj);
            stringBuffer.append(" not known to ");
            stringBuffer.append(this);
            throw new IllegalArgumentException(stringBuffer.toString());
        } else if (this.map.put(obj2, num) == null) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void checkLocked() {
        if (isLocked()) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    public int compare(Object obj, Object obj2) {
        this.isLocked = true;
        Integer num = (Integer) this.map.get(obj);
        Integer num2 = (Integer) this.map.get(obj2);
        if (num != null && num2 != null) {
            return num.compareTo(num2);
        }
        int i10 = this.unknownObjectBehavior;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    if (num != null) {
                        obj = obj2;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Attempting to compare unknown object ");
                    stringBuffer.append(obj);
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Unknown unknownObjectBehavior: ");
                stringBuffer2.append(this.unknownObjectBehavior);
                throw new UnsupportedOperationException(stringBuffer2.toString());
            } else if (num != null) {
                return -1;
            } else {
                if (num2 == null) {
                    return 0;
                }
                return 1;
            }
        } else if (num != null) {
            return 1;
        } else {
            if (num2 == null) {
                return 0;
            }
            return -1;
        }
    }

    public int getUnknownObjectBehavior() {
        return this.unknownObjectBehavior;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setUnknownObjectBehavior(int i10) {
        checkLocked();
        if (i10 == 1 || i10 == 0 || i10 == 2) {
            this.unknownObjectBehavior = i10;
            return;
        }
        throw new IllegalArgumentException("Unrecognised value for unknown behaviour flag");
    }

    public FixedOrderComparator(Object[] objArr) {
        this.map = new HashMap();
        this.counter = 0;
        this.isLocked = false;
        this.unknownObjectBehavior = 2;
        if (objArr != null) {
            for (Object add : objArr) {
                add(add);
            }
            return;
        }
        throw new IllegalArgumentException("The list of items must not be null");
    }

    public FixedOrderComparator(List list) {
        this.map = new HashMap();
        this.counter = 0;
        this.isLocked = false;
        this.unknownObjectBehavior = 2;
        if (list != null) {
            for (Object add : list) {
                add(add);
            }
            return;
        }
        throw new IllegalArgumentException("The list of items must not be null");
    }
}
