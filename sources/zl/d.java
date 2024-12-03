package zl;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f24828a = 4;

    public static int a(int i10) {
        return 4 - (i10 % 4);
    }

    public static int b(char c10, CharSequence charSequence, int i10) {
        int length = charSequence.length();
        while (i10 < length) {
            if (charSequence.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int c(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt == 10 || charAt == 13) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private static int d(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt != ' ') {
                switch (charAt) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        return i10;
                }
            }
            i10++;
        }
        return -1;
    }

    public static boolean e(CharSequence charSequence) {
        int length = charSequence.length();
        if (k(' ', charSequence, 0, length) != length) {
            return true;
        }
        return false;
    }

    public static boolean f(CharSequence charSequence) {
        return d(charSequence, 0) == -1;
    }

    public static boolean g(CharSequence charSequence, int i10) {
        if (i10 >= charSequence.length()) {
            return false;
        }
        char charAt = charSequence.charAt(i10);
        switch (charAt) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (charAt) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (charAt) {
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                                return true;
                            default:
                                switch (charAt) {
                                    case '{':
                                    case '|':
                                    case '}':
                                    case '~':
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static boolean h(CharSequence charSequence, int i10) {
        return Character.isLetter(Character.codePointAt(charSequence, i10));
    }

    public static boolean i(CharSequence charSequence, int i10) {
        if (i10 >= charSequence.length()) {
            return false;
        }
        char charAt = charSequence.charAt(i10);
        if (charAt == 9 || charAt == ' ') {
            return true;
        }
        return false;
    }

    public static CharSequence j(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder sb2 = null;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = charSequence.charAt(i10);
            if (charAt == 0) {
                if (sb2 == null) {
                    sb2 = new StringBuilder(length);
                    sb2.append(charSequence, 0, i10);
                }
                sb2.append(65533);
            } else if (sb2 != null) {
                sb2.append(charAt);
            }
        }
        if (sb2 != null) {
            return sb2.toString();
        }
        return charSequence;
    }

    public static int k(char c10, CharSequence charSequence, int i10, int i11) {
        while (i10 < i11) {
            if (charSequence.charAt(i10) != c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int l(char c10, CharSequence charSequence, int i10, int i11) {
        while (i10 >= i11) {
            if (charSequence.charAt(i10) != c10) {
                return i10;
            }
            i10--;
        }
        return i11 - 1;
    }

    public static int m(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11) {
            char charAt = charSequence.charAt(i10);
            if (charAt != 9 && charAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int n(CharSequence charSequence, int i10, int i11) {
        while (i10 >= i11) {
            char charAt = charSequence.charAt(i10);
            if (charAt != 9 && charAt != ' ') {
                return i10;
            }
            i10--;
        }
        return i11 - 1;
    }
}
