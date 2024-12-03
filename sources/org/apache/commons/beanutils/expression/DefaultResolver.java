package org.apache.commons.beanutils.expression;

public class DefaultResolver implements Resolver {
    private static final char INDEXED_END = ']';
    private static final char INDEXED_START = '[';
    private static final char MAPPED_END = ')';
    private static final char MAPPED_START = '(';
    private static final char NESTED = '.';

    public int getIndex(String str) {
        char charAt;
        if (!(str == null || str.length() == 0)) {
            int i10 = 0;
            while (i10 < str.length() && (charAt = str.charAt(i10)) != '.' && charAt != '(') {
                if (charAt == '[') {
                    int indexOf = str.indexOf(93, i10);
                    if (indexOf >= 0) {
                        String substring = str.substring(i10 + 1, indexOf);
                        if (substring.length() != 0) {
                            try {
                                return Integer.parseInt(substring, 10);
                            } catch (Exception unused) {
                                throw new IllegalArgumentException("Invalid index value '" + substring + "'");
                            }
                        } else {
                            throw new IllegalArgumentException("No Index Value");
                        }
                    } else {
                        throw new IllegalArgumentException("Missing End Delimiter");
                    }
                } else {
                    i10++;
                }
            }
        }
        return -1;
    }

    public String getKey(String str) {
        char charAt;
        if (!(str == null || str.length() == 0)) {
            int i10 = 0;
            while (i10 < str.length() && (charAt = str.charAt(i10)) != '.' && charAt != '[') {
                if (charAt == '(') {
                    int indexOf = str.indexOf(41, i10);
                    if (indexOf >= 0) {
                        return str.substring(i10 + 1, indexOf);
                    }
                    throw new IllegalArgumentException("Missing End Delimiter");
                }
                i10++;
            }
        }
        return null;
    }

    public String getProperty(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '.') {
                return str.substring(0, i10);
            }
            if (charAt == '(' || charAt == '[') {
                return str.substring(0, i10);
            }
        }
        return str;
    }

    public boolean hasNested(String str) {
        if (str == null || str.length() == 0 || remove(str) == null) {
            return false;
        }
        return true;
    }

    public boolean isIndexed(String str) {
        char charAt;
        if (!(str == null || str.length() == 0)) {
            int i10 = 0;
            while (i10 < str.length() && (charAt = str.charAt(i10)) != '.' && charAt != '(') {
                if (charAt == '[') {
                    return true;
                }
                i10++;
            }
        }
        return false;
    }

    public boolean isMapped(String str) {
        char charAt;
        if (!(str == null || str.length() == 0)) {
            int i10 = 0;
            while (i10 < str.length() && (charAt = str.charAt(i10)) != '.' && charAt != '[') {
                if (charAt == '(') {
                    return true;
                }
                i10++;
            }
        }
        return false;
    }

    public String next(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (z10) {
                if (charAt == ']') {
                    return str.substring(0, i10 + 1);
                }
            } else if (z11) {
                if (charAt == ')') {
                    return str.substring(0, i10 + 1);
                }
            } else if (charAt == '.') {
                return str.substring(0, i10);
            } else {
                if (charAt == '(') {
                    z11 = true;
                } else if (charAt == '[') {
                    z10 = true;
                }
            }
        }
        return str;
    }

    public String remove(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String next = next(str);
        if (str.length() == next.length()) {
            return null;
        }
        int length = next.length();
        if (str.charAt(length) == '.') {
            length++;
        }
        return str.substring(length);
    }
}
