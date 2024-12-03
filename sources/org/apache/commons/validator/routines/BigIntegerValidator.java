package org.apache.commons.validator.routines;

import java.math.BigInteger;
import java.text.Format;
import java.util.Locale;

public class BigIntegerValidator extends AbstractNumberValidator {
    private static final BigIntegerValidator VALIDATOR = new BigIntegerValidator();
    private static final long serialVersionUID = 6713144356347139988L;

    public BigIntegerValidator() {
        this(true, 0);
    }

    public static BigIntegerValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isInRange(BigInteger bigInteger, long j10, long j11) {
        return bigInteger.longValue() >= j10 && bigInteger.longValue() <= j11;
    }

    public boolean maxValue(BigInteger bigInteger, long j10) {
        return bigInteger.longValue() <= j10;
    }

    public boolean minValue(BigInteger bigInteger, long j10) {
        return bigInteger.longValue() >= j10;
    }

    /* access modifiers changed from: protected */
    public Object processParsedValue(Object obj, Format format2) {
        return BigInteger.valueOf(((Number) obj).longValue());
    }

    public BigInteger validate(String str) {
        return (BigInteger) parse(str, (String) null, (Locale) null);
    }

    public BigIntegerValidator(boolean z10, int i10) {
        super(z10, i10, false);
    }

    public BigInteger validate(String str, String str2) {
        return (BigInteger) parse(str, str2, (Locale) null);
    }

    public BigInteger validate(String str, Locale locale) {
        return (BigInteger) parse(str, (String) null, locale);
    }

    public BigInteger validate(String str, String str2, Locale locale) {
        return (BigInteger) parse(str, str2, locale);
    }
}
