package org.apache.commons.beanutils.converters;

import java.math.BigDecimal;

public final class BigDecimalConverter extends NumberConverter {
    public BigDecimalConverter() {
        super(true);
    }

    /* access modifiers changed from: protected */
    public Class<BigDecimal> getDefaultType() {
        return BigDecimal.class;
    }

    public BigDecimalConverter(Object obj) {
        super(true, obj);
    }
}
