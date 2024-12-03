package org.apache.commons.beanutils.converters;

import java.math.BigInteger;

public final class BigIntegerConverter extends NumberConverter {
    public BigIntegerConverter() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public Class<BigInteger> getDefaultType() {
        return BigInteger.class;
    }

    public BigIntegerConverter(Object obj) {
        super(false, obj);
    }
}
