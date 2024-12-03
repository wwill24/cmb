package org.apache.commons.validator.routines.checkdigit;

import java.io.Serializable;

public abstract class ModulusCheckDigit implements CheckDigit, Serializable {
    private static final long serialVersionUID = 2948962251251528941L;
    private final int modulus;

    public ModulusCheckDigit(int i10) {
        this.modulus = i10;
    }

    public static int sumDigits(int i10) {
        int i11 = 0;
        while (i10 > 0) {
            i11 += i10 % 10;
            i10 /= 10;
        }
        return i11;
    }

    public String calculate(String str) throws CheckDigitException {
        if (str == null || str.length() == 0) {
            throw new CheckDigitException("Code is missing");
        }
        int calculateModulus = calculateModulus(str, false);
        int i10 = this.modulus;
        return toCheckDigit((i10 - calculateModulus) % i10);
    }

    /* access modifiers changed from: protected */
    public int calculateModulus(String str, boolean z10) throws CheckDigitException {
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length()) {
            int i12 = i10 + 1;
            int length = (str.length() + (z10 ^ true ? 1 : 0)) - i10;
            i11 += weightedValue(toInt(str.charAt(i10), i12, length), i12, length);
            i10 = i12;
        }
        if (i11 != 0) {
            return i11 % this.modulus;
        }
        throw new CheckDigitException("Invalid code, sum is zero");
    }

    public int getModulus() {
        return this.modulus;
    }

    public boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            if (calculateModulus(str, true) == 0) {
                return true;
            }
            return false;
        } catch (CheckDigitException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public String toCheckDigit(int i10) throws CheckDigitException {
        if (i10 >= 0 && i10 <= 9) {
            return Integer.toString(i10);
        }
        throw new CheckDigitException("Invalid Check Digit Value =" + i10);
    }

    /* access modifiers changed from: protected */
    public int toInt(char c10, int i10, int i11) throws CheckDigitException {
        if (Character.isDigit(c10)) {
            return Character.getNumericValue(c10);
        }
        throw new CheckDigitException("Invalid Character[" + i10 + "] = '" + c10 + "'");
    }

    /* access modifiers changed from: protected */
    public abstract int weightedValue(int i10, int i11, int i12) throws CheckDigitException;
}
