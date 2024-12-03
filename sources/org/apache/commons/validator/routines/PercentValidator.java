package org.apache.commons.validator.routines;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;

public class PercentValidator extends BigDecimalValidator {
    private static final char PERCENT_SYMBOL = '%';
    private static final BigDecimal POINT_ZERO_ONE = new BigDecimal("0.01");
    private static final PercentValidator VALIDATOR = new PercentValidator();
    private static final long serialVersionUID = -3508241924961535772L;

    public PercentValidator() {
        this(true);
    }

    public static BigDecimalValidator getInstance() {
        return VALIDATOR;
    }

    /* access modifiers changed from: protected */
    public Object parse(String str, Format format2) {
        BigDecimal bigDecimal = (BigDecimal) super.parse(str, format2);
        if (bigDecimal != null || !(format2 instanceof DecimalFormat)) {
            return bigDecimal;
        }
        DecimalFormat decimalFormat = (DecimalFormat) format2;
        String pattern = decimalFormat.toPattern();
        if (pattern.indexOf(37) < 0) {
            return bigDecimal;
        }
        StringBuilder sb2 = new StringBuilder(pattern.length());
        for (int i10 = 0; i10 < pattern.length(); i10++) {
            if (pattern.charAt(i10) != '%') {
                sb2.append(pattern.charAt(i10));
            }
        }
        decimalFormat.applyPattern(sb2.toString());
        BigDecimal bigDecimal2 = (BigDecimal) super.parse(str, decimalFormat);
        if (bigDecimal2 != null) {
            return bigDecimal2.multiply(POINT_ZERO_ONE);
        }
        return bigDecimal2;
    }

    public PercentValidator(boolean z10) {
        super(z10, 2, true);
    }
}
