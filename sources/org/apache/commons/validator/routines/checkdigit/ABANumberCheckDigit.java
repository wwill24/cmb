package org.apache.commons.validator.routines.checkdigit;

public final class ABANumberCheckDigit extends ModulusCheckDigit {
    public static final CheckDigit ABAN_CHECK_DIGIT = new ABANumberCheckDigit();
    private static final int[] POSITION_WEIGHT = {3, 1, 7};
    private static final long serialVersionUID = -8255937433810380145L;

    public ABANumberCheckDigit() {
        super(10);
    }

    /* access modifiers changed from: protected */
    public int weightedValue(int i10, int i11, int i12) {
        return i10 * POSITION_WEIGHT[i12 % 3];
    }
}
