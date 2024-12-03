package org.apache.commons.validator.routines.checkdigit;

public final class ISBN10CheckDigit extends ModulusCheckDigit {
    public static final CheckDigit ISBN10_CHECK_DIGIT = new ISBN10CheckDigit();
    private static final long serialVersionUID = 8000855044504864964L;

    public ISBN10CheckDigit() {
        super(11);
    }

    /* access modifiers changed from: protected */
    public String toCheckDigit(int i10) throws CheckDigitException {
        return i10 == 10 ? "X" : super.toCheckDigit(i10);
    }

    /* access modifiers changed from: protected */
    public int toInt(char c10, int i10, int i11) throws CheckDigitException {
        if (i11 == 1 && c10 == 'X') {
            return 10;
        }
        return super.toInt(c10, i10, i11);
    }

    /* access modifiers changed from: protected */
    public int weightedValue(int i10, int i11, int i12) {
        return i10 * i12;
    }
}
