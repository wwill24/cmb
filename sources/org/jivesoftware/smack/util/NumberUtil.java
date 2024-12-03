package org.jivesoftware.smack.util;

import org.jivesoftware.smack.datatypes.UInt32;

public class NumberUtil {
    @Deprecated
    public static void checkIfInUInt32Range(long j10) {
        requireUInt32(j10);
    }

    public static long requireUInt32(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("unsigned 32-bit integers can't be negative: " + j10);
        } else if (j10 <= UInt32.MAX_VALUE_LONG) {
            return j10;
        } else {
            throw new IllegalArgumentException("unsigned 32-bit integers can't be greater than 2^32 - 1: " + j10);
        }
    }

    public static int requireUShort16(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("unsigned 16-bit integers can't be negative: " + i10);
        } else if (i10 <= 65535) {
            return i10;
        } else {
            throw new IllegalArgumentException("unsigned 16-bit integers can't be greater than 2^16 - 1: " + i10);
        }
    }
}
