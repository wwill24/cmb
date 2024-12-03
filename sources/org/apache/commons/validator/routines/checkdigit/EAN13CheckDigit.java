package org.apache.commons.validator.routines.checkdigit;

public final class EAN13CheckDigit extends ModulusCheckDigit {
    public static final CheckDigit EAN13_CHECK_DIGIT = new EAN13CheckDigit();
    private static final int[] POSITION_WEIGHT = {3, 1};
    private static final long serialVersionUID = 1726347093230424107L;

    public EAN13CheckDigit() {
        super(10);
    }

    /* access modifiers changed from: protected */
    public int weightedValue(int i10, int i11, int i12) {
        return i10 * POSITION_WEIGHT[i12 % 2];
    }
}
