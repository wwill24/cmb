package com.google.gson.internal;

import net.bytebuddy.ClassFileVersion;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21363a = a();

    private static int a() {
        return c(System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION));
    }

    private static int b(String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb2.append(charAt);
            }
            return Integer.parseInt(sb2.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static int c(String str) {
        int e10 = e(str);
        if (e10 == -1) {
            e10 = b(str);
        }
        if (e10 == -1) {
            return 6;
        }
        return e10;
    }

    public static boolean d() {
        return f21363a >= 9;
    }

    private static int e(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt != 1 || split.length <= 1) {
                return parseInt;
            }
            return Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
