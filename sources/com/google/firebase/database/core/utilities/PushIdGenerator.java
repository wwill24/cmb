package com.google.firebase.database.core.utilities;

import com.google.android.gms.common.api.a;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Random;

public class PushIdGenerator {
    private static final int MAX_KEY_LEN = 786;
    private static final char MAX_PUSH_CHAR = 'z';
    private static final char MIN_PUSH_CHAR = '-';
    private static final String PUSH_CHARS = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz";
    private static long lastPushTime = 0;
    private static final int[] lastRandChars = new int[12];
    private static final Random randGen = new Random();

    public static synchronized String generatePushChildName(long j10) {
        boolean z10;
        boolean z11;
        String sb2;
        synchronized (PushIdGenerator.class) {
            boolean z12 = true;
            if (j10 == lastPushTime) {
                z10 = true;
            } else {
                z10 = false;
            }
            lastPushTime = j10;
            char[] cArr = new char[8];
            StringBuilder sb3 = new StringBuilder(20);
            for (int i10 = 7; i10 >= 0; i10--) {
                cArr[i10] = PUSH_CHARS.charAt((int) (j10 % 64));
                j10 /= 64;
            }
            if (j10 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Utilities.hardAssert(z11);
            sb3.append(cArr);
            if (!z10) {
                for (int i11 = 0; i11 < 12; i11++) {
                    lastRandChars[i11] = randGen.nextInt(64);
                }
            } else {
                incrementArray();
            }
            for (int i12 = 0; i12 < 12; i12++) {
                sb3.append(PUSH_CHARS.charAt(lastRandChars[i12]));
            }
            if (sb3.length() != 20) {
                z12 = false;
            }
            Utilities.hardAssert(z12);
            sb2 = sb3.toString();
        }
        return sb2;
    }

    private static void incrementArray() {
        int i10 = 11;
        while (i10 >= 0) {
            int[] iArr = lastRandChars;
            int i11 = iArr[i10];
            if (i11 != 63) {
                iArr[i10] = i11 + 1;
                return;
            } else {
                iArr[i10] = 0;
                i10--;
            }
        }
    }

    public static final String predecessor(String str) {
        Validation.validateNullableKey(str);
        Integer tryParseInt = Utilities.tryParseInt(str);
        if (tryParseInt == null) {
            StringBuilder sb2 = new StringBuilder(str);
            if (sb2.charAt(sb2.length() - 1) != '-') {
                sb2.setCharAt(sb2.length() - 1, PUSH_CHARS.charAt(PUSH_CHARS.indexOf(sb2.charAt(sb2.length() - 1)) - 1));
                sb2.append(new String(new char[(786 - sb2.length())]).replace("\u0000", "z"));
                return sb2.toString();
            } else if (sb2.length() == 1) {
                return String.valueOf(a.e.API_PRIORITY_OTHER);
            } else {
                return sb2.substring(0, sb2.length() - 1);
            }
        } else if (tryParseInt.intValue() == Integer.MIN_VALUE) {
            return ChildKey.MIN_KEY_NAME;
        } else {
            return String.valueOf(tryParseInt.intValue() - 1);
        }
    }

    public static final String successor(String str) {
        Validation.validateNullableKey(str);
        Integer tryParseInt = Utilities.tryParseInt(str);
        if (tryParseInt == null) {
            StringBuilder sb2 = new StringBuilder(str);
            if (sb2.length() < MAX_KEY_LEN) {
                sb2.append('-');
                return sb2.toString();
            }
            int length = sb2.length() - 1;
            while (length >= 0 && sb2.charAt(length) == 'z') {
                length--;
            }
            if (length == -1) {
                return ChildKey.MAX_KEY_NAME;
            }
            int i10 = length + 1;
            sb2.replace(length, i10, String.valueOf(PUSH_CHARS.charAt(PUSH_CHARS.indexOf(sb2.charAt(length)) + 1)));
            return sb2.substring(0, i10);
        } else if (tryParseInt.intValue() == Integer.MAX_VALUE) {
            return String.valueOf('-');
        } else {
            return String.valueOf(tryParseInt.intValue() + 1);
        }
    }
}
