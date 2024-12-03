package org.jivesoftware.smack.sm;

import java.math.BigInteger;
import org.apache.commons.beanutils.PropertyUtils;

public class SMUtils {
    private static long MASK_32_BIT;

    static {
        BigInteger bigInteger = BigInteger.ONE;
        MASK_32_BIT = bigInteger.shiftLeft(32).subtract(bigInteger).longValue();
    }

    public static long calculateDelta(long j10, long j11) {
        if (j11 <= j10) {
            return (j10 - j11) & MASK_32_BIT;
        }
        throw new IllegalStateException("Illegal Stream Management State: Last known handled count (" + j11 + ") is greater than reported handled count (" + j10 + PropertyUtils.MAPPED_DELIM2);
    }

    public static long incrementHeight(long j10) {
        return (j10 + 1) & MASK_32_BIT;
    }
}
