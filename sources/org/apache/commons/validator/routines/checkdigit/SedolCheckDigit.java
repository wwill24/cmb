package org.apache.commons.validator.routines.checkdigit;

import com.mparticle.kits.AppsFlyerKit;

public final class SedolCheckDigit extends ModulusCheckDigit {
    private static final int[] POSITION_WEIGHT = {1, 3, 1, 7, 3, 9, 1};
    public static final CheckDigit SEDOL_CHECK_DIGIT = new SedolCheckDigit();
    private static final long serialVersionUID = -8976881621148878443L;

    public SedolCheckDigit() {
        super(10);
    }

    /* access modifiers changed from: protected */
    public int calculateModulus(String str, boolean z10) throws CheckDigitException {
        if (str.length() <= 7) {
            return super.calculateModulus(str, z10);
        }
        throw new CheckDigitException("Invalid Code Length = " + str.length());
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
        return i10 * POSITION_WEIGHT[i11 - 1];
    }
}
