package org.apache.commons.validator.routines.checkdigit;

public final class LuhnCheckDigit extends ModulusCheckDigit {
    public static final CheckDigit LUHN_CHECK_DIGIT = new LuhnCheckDigit();
    private static final int[] POSITION_WEIGHT = {2, 1};
    private static final long serialVersionUID = -2976900113942875999L;

    public LuhnCheckDigit() {
        super(10);
    }

    /* access modifiers changed from: protected */
    public int weightedValue(int i10, int i11, int i12) {
        int i13 = i10 * POSITION_WEIGHT[i12 % 2];
        return i13 > 9 ? i13 - 9 : i13;
    }
}
