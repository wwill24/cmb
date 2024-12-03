package org.apache.commons.validator.routines.checkdigit;

import com.mparticle.kits.AppsFlyerKit;

public final class CUSIPCheckDigit extends ModulusCheckDigit {
    public static final CheckDigit CUSIP_CHECK_DIGIT = new CUSIPCheckDigit();
    private static final int[] POSITION_WEIGHT = {2, 1};
    private static final long serialVersionUID = 666941918490152456L;

    public CUSIPCheckDigit() {
        super(10);
    }

    /* access modifiers changed from: protected */
    public int toInt(char c10, int i10, int i11) throws CheckDigitException {
        int i12;
        int numericValue = Character.getNumericValue(c10);
        if (i11 == 1) {
            i12 = 9;
        } else {
            i12 = 35;
        }
        if (numericValue >= 0 && numericValue <= i12) {
            return numericValue;
        }
        throw new CheckDigitException("Invalid Character[" + i10 + AppsFlyerKit.COMMA + i11 + "] = '" + numericValue + "' out of range 0 to " + i12);
    }

    /* access modifiers changed from: protected */
    public int weightedValue(int i10, int i11, int i12) {
        return ModulusCheckDigit.sumDigits(i10 * POSITION_WEIGHT[i12 % 2]);
    }
}
