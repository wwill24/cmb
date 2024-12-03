package org.apache.commons.collections.comparators;

import com.google.android.gms.common.api.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;

public class ComparatorChain implements Comparator, Serializable {
    private static final long serialVersionUID = -721644942746081630L;
    protected List comparatorChain;
    protected boolean isLocked;
    protected BitSet orderingBits;

    public ComparatorChain() {
        this((List) new ArrayList(), new BitSet());
    }

    private void checkChainIntegrity() {
        if (this.comparatorChain.size() == 0) {
            throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
        }
    }

    private void checkLocked() {
        if (this.isLocked) {
            throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
        }
    }

    public void addComparator(Comparator comparator) {
        addComparator(comparator, false);
    }

    public int compare(Object obj, Object obj2) throws UnsupportedOperationException {
        if (!this.isLocked) {
            checkChainIntegrity();
            this.isLocked = true;
        }
        int i10 = 0;
        for (Comparator compare : this.comparatorChain) {
            int compare2 = compare.compare(obj, obj2);
            if (compare2 == 0) {
                i10++;
            } else if (!this.orderingBits.get(i10)) {
                return compare2;
            } else {
                if (Integer.MIN_VALUE == compare2) {
                    return a.e.API_PRIORITY_OTHER;
                }
                return compare2 * -1;
            }
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ComparatorChain comparatorChain2 = (ComparatorChain) obj;
        BitSet bitSet = this.orderingBits;
        if (bitSet != null ? bitSet.equals(comparatorChain2.orderingBits) : comparatorChain2.orderingBits == null) {
            List list = this.comparatorChain;
            List list2 = comparatorChain2.comparatorChain;
            if (list == null) {
                if (list2 == null) {
                    return true;
                }
            } else if (list.equals(list2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        List list = this.comparatorChain;
        int i10 = 0;
        if (list != null) {
            i10 = 0 ^ list.hashCode();
        }
        BitSet bitSet = this.orderingBits;
        if (bitSet != null) {
            return i10 ^ bitSet.hashCode();
        }
        return i10;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setComparator(int i10, Comparator comparator) throws IndexOutOfBoundsException {
        setComparator(i10, comparator, false);
    }

    public void setForwardSort(int i10) {
        checkLocked();
        this.orderingBits.clear(i10);
    }

    public void setReverseSort(int i10) {
        checkLocked();
        this.orderingBits.set(i10);
    }

    public int size() {
        return this.comparatorChain.size();
    }

    public ComparatorChain(Comparator comparator) {
        this(comparator, false);
    }

    public void addComparator(Comparator comparator, boolean z10) {
        checkLocked();
        this.comparatorChain.add(comparator);
        if (z10) {
            this.orderingBits.set(this.comparatorChain.size() - 1);
        }
    }

    public void setComparator(int i10, Comparator comparator, boolean z10) {
        checkLocked();
        this.comparatorChain.set(i10, comparator);
        if (z10) {
            this.orderingBits.set(i10);
        } else {
            this.orderingBits.clear(i10);
        }
    }

    public ComparatorChain(Comparator comparator, boolean z10) {
        this.comparatorChain = null;
        this.orderingBits = null;
        this.isLocked = false;
        ArrayList arrayList = new ArrayList();
        this.comparatorChain = arrayList;
        arrayList.add(comparator);
        BitSet bitSet = new BitSet(1);
        this.orderingBits = bitSet;
        if (z10) {
            bitSet.set(0);
        }
    }

    public ComparatorChain(List list) {
        this(list, new BitSet(list.size()));
    }

    public ComparatorChain(List list, BitSet bitSet) {
        this.isLocked = false;
        this.comparatorChain = list;
        this.orderingBits = bitSet;
    }
}
