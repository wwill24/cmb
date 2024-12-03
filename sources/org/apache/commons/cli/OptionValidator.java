package org.apache.commons.cli;

class OptionValidator {
    OptionValidator() {
    }

    private static boolean isValidChar(char c10) {
        return Character.isJavaIdentifierPart(c10);
    }

    private static boolean isValidOpt(char c10) {
        return isValidChar(c10) || c10 == ' ' || c10 == '?' || c10 == '@';
    }

    static void validateOption(String str) throws IllegalArgumentException {
        if (str != null) {
            int i10 = 0;
            if (str.length() == 1) {
                char charAt = str.charAt(0);
                if (!isValidOpt(charAt)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("illegal option value '");
                    stringBuffer.append(charAt);
                    stringBuffer.append("'");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                return;
            }
            char[] charArray = str.toCharArray();
            while (i10 < charArray.length) {
                if (isValidChar(charArray[i10])) {
                    i10++;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("opt contains illegal character value '");
                    stringBuffer2.append(charArray[i10]);
                    stringBuffer2.append("'");
                    throw new IllegalArgumentException(stringBuffer2.toString());
                }
            }
        }
    }
}
