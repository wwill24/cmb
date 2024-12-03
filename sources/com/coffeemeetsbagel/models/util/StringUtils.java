package com.coffeemeetsbagel.models.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private static final String DEFAULT_SEPARATOR = ", ";
    public static final String EMPTY_STRING = "";
    private static final Pattern NUMBER_IN_STRING = Pattern.compile("(^|[^0-9])([0-9]+)($|[^0-9])");

    public static String bytesToHex(byte[] bArr, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            if (z10) {
                sb2.append(String.format("%02X ", new Object[]{Byte.valueOf(b10)}));
            } else {
                sb2.append(String.format("%02X", new Object[]{Byte.valueOf(b10)}));
            }
        }
        return sb2.toString();
    }

    public static boolean compareWithNullAsEqual(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static boolean equalsAny(String str, String... strArr) {
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static int getFirstNumericSequence(String str) {
        Matcher matcher = NUMBER_IN_STRING.matcher(str);
        if (!matcher.find()) {
            return -1;
        }
        try {
            return Integer.parseInt(matcher.group(2));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int getLastNumericSequence(String str) {
        String[] split = str.split("\\.");
        if (split.length > 0) {
            try {
                return Integer.parseInt(split[split.length - 1]);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public static char getOffsetLetterOrDigit(char c10, int i10) {
        char c11;
        if (!Character.isLetterOrDigit(c10)) {
            return c10;
        }
        int i11 = 26;
        if (Character.isDigit(c10)) {
            c11 = '0';
            i11 = 10;
        } else if (Character.isLowerCase(c10)) {
            c11 = 'a';
        } else if (!Character.isUpperCase(c10)) {
            return c10;
        } else {
            c11 = 'A';
        }
        int i12 = ((c10 - c11) + i10) % i11;
        if (i12 < 0) {
            i12 += i11;
        }
        return (char) (c11 + i12);
    }

    public static String intelliJoin(String str, String str2) {
        String str3;
        String trim = str.trim();
        String trim2 = str2.trim();
        if (isLatinPunctuationLastNonWhitespaceCharacterOf(trim)) {
            str3 = " ";
        } else {
            str3 = ". ";
        }
        return trim + str3 + trim2;
    }

    public static boolean isAlphaNumeric(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (!Character.isLetterOrDigit(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLatinPunctuationLastNonWhitespaceCharacterOf(String str) {
        return "?!.".contains(str.trim().substring(str.length() - 1));
    }

    public static boolean isProfileStringComplete(String str) {
        if (str == null || str.equals("N/A") || str.equals("n/a") || str.isEmpty()) {
            return false;
        }
        return true;
    }

    public static String join(List<String> list, String str) {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!TextUtils.isEmpty(next)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0) {
            return "";
        }
        Iterator it = arrayList.iterator();
        sb2.append((String) arrayList.get(0));
        it.next();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(str);
                sb2.append(str2);
            }
        }
        return sb2.toString();
    }

    public static String offsetEachCharacter(String str, int i10) {
        StringBuilder sb2 = new StringBuilder("");
        for (char offsetLetterOrDigit : str.toCharArray()) {
            sb2.append(getOffsetLetterOrDigit(offsetLetterOrDigit, i10));
        }
        return sb2.toString();
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String rotate(String str, int i10) {
        int i11;
        if (i10 == 0 || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder("");
        int length = str.length();
        int i12 = i10 % length;
        if (i12 < 0) {
            i11 = Math.abs(i12);
        } else {
            i11 = length - i12;
        }
        for (int i13 = i11; i13 < length; i13++) {
            sb2.append(str.charAt(i13));
        }
        for (int i14 = 0; i14 < i11; i14++) {
            sb2.append(str.charAt(i14));
        }
        return sb2.toString();
    }

    public static String rotateLeft(String str, int i10) {
        return rotate(str, -i10);
    }

    public static String rotateRight(String str, int i10) {
        return rotate(str, i10);
    }

    public static List<String> splitStringByComma(String str) {
        if (TextUtils.isEmpty(str)) {
            return new LinkedList();
        }
        return new LinkedList(Arrays.asList(str.split("\\s*,\\s*")));
    }

    public static String toTitleCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public String getQuantityString(Context context, int i10, int i11, Object... objArr) {
        return context.getResources().getQuantityString(i10, i11, objArr);
    }

    public static String join(List<String> list) {
        if (list != null) {
            return join(list, DEFAULT_SEPARATOR);
        }
        return null;
    }
}
