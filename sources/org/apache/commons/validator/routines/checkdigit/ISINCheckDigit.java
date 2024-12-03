package org.apache.commons.validator.routines.checkdigit;

public final class ISINCheckDigit extends ModulusCheckDigit {
    public static final CheckDigit ISIN_CHECK_DIGIT = new ISINCheckDigit();
    private static final int[] POSITION_WEIGHT = {2, 1};
    private static final long serialVersionUID = -1239211208101323599L;

    public ISINCheckDigit() {
        super(10);
    }

    /* access modifiers changed from: protected */
    public int calculateModulus(String str, boolean z10) throws CheckDigitException {
        StringBuilder sb2 = new StringBuilder(str.length() * 2);
        if (z10) {
            char charAt = str.charAt(str.length() - 1);
            if (!Character.isDigit(charAt)) {
                throw new CheckDigitException("Invalid checkdigit[" + charAt + "] in " + str);
            }
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            int numericValue = Character.getNumericValue(str.charAt(i10));
            if (numericValue < 0 || numericValue > 35) {
                throw new CheckDigitException("Invalid Character[" + (i10 + 1) + "] = '" + numericValue + "'");
            }
            sb2.append(numericValue);
        }
        return super.calculateModulus(sb2.toString(), z10);
    }

    /* access modifiers changed from: protected */
    public int weightedValue(int i10, int i11, int i12) {
        return ModulusCheckDigit.sumDigits(i10 * POSITION_WEIGHT[i12 % 2]);
    }
}
