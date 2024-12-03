package org.apache.commons.beanutils.converters;

import java.sql.Date;

public final class SqlDateConverter extends DateTimeConverter {
    public SqlDateConverter() {
    }

    /* access modifiers changed from: protected */
    public Class<?> getDefaultType() {
        return Date.class;
    }

    public SqlDateConverter(Object obj) {
        super(obj);
    }
}
