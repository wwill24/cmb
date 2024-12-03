package org.jivesoftware.smack.datatypes;

import org.jivesoftware.smack.util.NumberUtil;

public final class UInt16 extends Scalar implements Comparable<UInt16> {
    public static final UInt16 MAX_VALUE = from(65535);
    public static final int MAX_VALUE_INT = 65535;
    public static final UInt16 MIN_VALUE = from(0);
    public static final int MIN_VALUE_INT = 0;
    private static final long serialVersionUID = 1;
    private final int number;

    private UInt16(int i10) {
        super(Integer.valueOf(NumberUtil.requireUShort16(i10)));
        this.number = i10;
    }

    public static UInt16 from(int i10) {
        return new UInt16(i10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UInt16)) {
            return super.equals(obj);
        }
        if (this.number == ((UInt16) obj).number) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.number;
    }

    public int nativeRepresentation() {
        return this.number;
    }

    public int compareTo(UInt16 uInt16) {
        return Integer.compare(this.number, uInt16.number);
    }

    public UInt16 getMaxValue() {
        return MAX_VALUE;
    }

    public UInt16 getMinValue() {
        return MIN_VALUE;
    }

    public UInt16 incrementedByOne() {
        int i10 = this.number;
        return from(i10 < 65535 ? i10 + 1 : 0);
    }
}
