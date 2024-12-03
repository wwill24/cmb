package org.apache.commons.validator.routines.checkdigit;

import java.io.Serializable;

public final class VerhoeffCheckDigit implements CheckDigit, Serializable {
    private static final int[][] D_TABLE = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 0, 6, 7, 8, 9, 5}, new int[]{2, 3, 4, 0, 1, 7, 8, 9, 5, 6}, new int[]{3, 4, 0, 1, 2, 8, 9, 5, 6, 7}, new int[]{4, 0, 1, 2, 3, 9, 5, 6, 7, 8}, new int[]{5, 9, 8, 7, 6, 0, 4, 3, 2, 1}, new int[]{6, 5, 9, 8, 7, 1, 0, 4, 3, 2}, new int[]{7, 6, 5, 9, 8, 2, 1, 0, 4, 3}, new int[]{8, 7, 6, 5, 9, 3, 2, 1, 0, 4}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}};
    private static final int[] INV_TABLE = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};
    private static final int[][] P_TABLE = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 5, 7, 6, 2, 8, 3, 0, 9, 4}, new int[]{5, 8, 0, 3, 7, 9, 6, 1, 4, 2}, new int[]{8, 9, 1, 6, 0, 4, 3, 5, 2, 7}, new int[]{9, 4, 5, 3, 1, 2, 6, 8, 7, 0}, new int[]{4, 2, 8, 6, 5, 7, 3, 9, 0, 1}, new int[]{2, 7, 9, 3, 8, 0, 6, 4, 1, 5}, new int[]{7, 0, 4, 6, 9, 1, 3, 2, 5, 8}};
    public static final CheckDigit VERHOEFF_CHECK_DIGIT = new VerhoeffCheckDigit();
    private static final long serialVersionUID = 4138993995483695178L;

    private int calculateChecksum(String str, boolean z10) throws CheckDigitException {
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length()) {
            int i12 = i10 + 1;
            int length = str.length() - i12;
            int numericValue = Character.getNumericValue(str.charAt(length));
            if (numericValue < 0 || numericValue > 9) {
                throw new CheckDigitException("Invalid Character[" + i10 + "] = '" + str.charAt(length) + "'");
            }
            if (!z10) {
                i10 = i12;
            }
            i11 = D_TABLE[i11][P_TABLE[i10 % 8][numericValue]];
            i10 = i12;
        }
        return i11;
    }

    public String calculate(String str) throws CheckDigitException {
        if (str == null || str.length() == 0) {
            throw new CheckDigitException("Code is missing");
        }
        return Integer.toString(INV_TABLE[calculateChecksum(str, false)]);
    }

    public boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            if (calculateChecksum(str, true) == 0) {
                return true;
            }
            return false;
        } catch (CheckDigitException unused) {
            return false;
        }
    }
}
