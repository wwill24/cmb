package org.jivesoftware.smack.datatypes;

import org.jivesoftware.smack.util.NumberUtil;

public final class UInt32 extends Scalar {
    public static final UInt32 MAX_VALUE = from(MAX_VALUE_LONG);
    public static final long MAX_VALUE_LONG = 4294967295L;
    public static final UInt32 MIN_VALUE = from(MAX_VALUE_LONG);
    public static final long MIN_VALUE_LONG = 0;
    private static final long serialVersionUID = 1;
    private final long number;

    private UInt32(long j10) {
        super(Long.valueOf(NumberUtil.requireUInt32(j10)));
        this.number = j10;
    }

    public static UInt32 from(long j10) {
        return new UInt32(j10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UInt32)) {
            return super.equals(obj);
        }
        if (this.number == ((UInt32) obj).number) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.number;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public long nativeRepresentation() {
        return this.number;
    }

    public UInt32 getMaxValue() {
        return MAX_VALUE;
    }

    public UInt32 getMinValue() {
        return MIN_VALUE;
    }

    public UInt32 incrementedByOne() {
        long j10 = this.number;
        return from(j10 < MAX_VALUE_LONG ? j10 + 1 : 0);
    }
}
