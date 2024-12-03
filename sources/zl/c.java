package zl;

import org.apache.commons.beanutils.PropertyUtils;

public class c {
    public static int a(CharSequence charSequence, int i10) {
        char charAt;
        if (i10 >= charSequence.length()) {
            return -1;
        }
        if (charSequence.charAt(i10) != '<') {
            return b(charSequence, i10);
        }
        while (true) {
            i10++;
            if (i10 >= charSequence.length() || (charAt = charSequence.charAt(i10)) == 10 || charAt == '<') {
                return -1;
            }
            if (charAt == '>') {
                return i10 + 1;
            }
            if (charAt == '\\') {
                int i11 = i10 + 1;
                if (d.g(charSequence, i11)) {
                    i10 = i11;
                }
            }
        }
        return -1;
    }

    private static int b(CharSequence charSequence, int i10) {
        int i11 = 0;
        int i12 = i10;
        while (i12 < charSequence.length()) {
            char charAt = charSequence.charAt(i12);
            if (charAt != 0 && charAt != ' ') {
                if (charAt == '\\') {
                    int i13 = i12 + 1;
                    if (d.g(charSequence, i13)) {
                        i12 = i13;
                    }
                } else if (charAt == '(') {
                    i11++;
                    if (i11 > 32) {
                        return -1;
                    }
                } else if (charAt != ')') {
                    if (Character.isISOControl(charAt)) {
                        if (i12 != i10) {
                            return i12;
                        }
                        return -1;
                    }
                } else if (i11 == 0) {
                    return i12;
                } else {
                    i11--;
                }
                i12++;
            } else if (i12 != i10) {
                return i12;
            } else {
                return -1;
            }
        }
        return charSequence.length();
    }

    public static int c(CharSequence charSequence, int i10) {
        while (i10 < charSequence.length()) {
            switch (charSequence.charAt(i10)) {
                case '[':
                    return -1;
                case '\\':
                    int i11 = i10 + 1;
                    if (!d.g(charSequence, i11)) {
                        break;
                    } else {
                        i10 = i11;
                        break;
                    }
                case ']':
                    return i10;
            }
            i10++;
        }
        return charSequence.length();
    }

    public static int d(CharSequence charSequence, int i10) {
        if (i10 >= charSequence.length()) {
            return -1;
        }
        char charAt = charSequence.charAt(i10);
        char c10 = '\'';
        if (charAt == '\"') {
            c10 = '\"';
        } else if (charAt != '\'') {
            if (charAt != '(') {
                return -1;
            }
            c10 = PropertyUtils.MAPPED_DELIM2;
        }
        int e10 = e(charSequence, i10 + 1, c10);
        if (e10 != -1 && e10 < charSequence.length() && charSequence.charAt(e10) == c10) {
            return e10 + 1;
        }
        return -1;
    }

    public static int e(CharSequence charSequence, int i10, char c10) {
        while (i10 < charSequence.length()) {
            char charAt = charSequence.charAt(i10);
            if (charAt == '\\') {
                int i11 = i10 + 1;
                if (d.g(charSequence, i11)) {
                    i10 = i11;
                    i10++;
                }
            }
            if (charAt == c10) {
                return i10;
            }
            if (c10 == ')' && charAt == '(') {
                return -1;
            }
            i10++;
        }
        return charSequence.length();
    }
}
