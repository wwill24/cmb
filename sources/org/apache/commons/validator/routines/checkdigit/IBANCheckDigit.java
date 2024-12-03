package org.apache.commons.validator.routines.checkdigit;

import java.io.Serializable;

public final class IBANCheckDigit implements CheckDigit, Serializable {
    public static final CheckDigit IBAN_CHECK_DIGIT = new IBANCheckDigit();
    private static final long MAX = 999999999;
    private static final long MODULUS = 97;
    private static final long serialVersionUID = -3600191725934382801L;

    private int calculateModulus(String str) throws CheckDigitException {
        long j10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str.substring(4));
        sb2.append(str.substring(0, 4));
        String sb3 = sb2.toString();
        long j11 = 0;
        for (int i10 = 0; i10 < sb3.length(); i10++) {
            int numericValue = Character.getNumericValue(sb3.charAt(i10));
            if (numericValue < 0 || numericValue > 35) {
                throw new CheckDigitException("Invalid Character[" + i10 + "] = '" + numericValue + "'");
            }
            if (numericValue > 9) {
                j10 = 100;
            } else {
                j10 = 10;
            }
            j11 = (j11 * j10) + ((long) numericValue);
            if (j11 > MAX) {
                j11 %= MODULUS;
            }
        }
        return (int) (j11 % MODULUS);
    }

    public String calculate(String str) throws CheckDigitException {
        int i10 = 0;
        if (str == null || str.length() < 5) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid Code length=");
            if (str != null) {
                i10 = str.length();
            }
            sb2.append(i10);
            throw new CheckDigitException(sb2.toString());
        }
        int calculateModulus = 98 - calculateModulus(str.substring(0, 2) + "00" + str.substring(4));
        String num = Integer.toString(calculateModulus);
        if (calculateModulus > 9) {
            return num;
        }
        return "0" + num;
    }

    public boolean isValid(String str) {
        if (str == null || str.length() < 5) {
            return false;
        }
        String substring = str.substring(2, 4);
        if ("00".equals(substring) || "01".equals(substring) || "99".equals(substring)) {
            return false;
        }
        try {
            if (calculateModulus(str) == 1) {
                return true;
            }
            return false;
        } catch (CheckDigitException unused) {
            return false;
        }
    }
}
