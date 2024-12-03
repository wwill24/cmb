package org.apache.commons.validator.routines;

import java.io.Serializable;

public class InetAddressValidator implements Serializable {
    private static final String IPV4_REGEX = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
    private static final InetAddressValidator VALIDATOR = new InetAddressValidator();
    private static final long serialVersionUID = -919201640201914789L;
    private final RegexValidator ipv4Validator = new RegexValidator(IPV4_REGEX);

    public static InetAddressValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isValid(String str) {
        return isValidInet4Address(str) || isValidInet6Address(str);
    }

    public boolean isValidInet4Address(String str) {
        String[] match = this.ipv4Validator.match(str);
        if (match == null) {
            return false;
        }
        int i10 = 0;
        while (i10 <= 3) {
            String str2 = match[i10];
            if (!(str2 == null || str2.length() == 0)) {
                try {
                    if (Integer.parseInt(str2) > 255) {
                        return false;
                    }
                    if (str2.length() > 1 && str2.startsWith("0")) {
                        return false;
                    }
                    i10++;
                } catch (NumberFormatException unused) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValidInet6Address(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "::"
            boolean r1 = r11.contains(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0014
            int r3 = r11.indexOf(r0)
            int r4 = r11.lastIndexOf(r0)
            if (r3 == r4) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.String r3 = ":"
            boolean r4 = r11.startsWith(r3)
            if (r4 == 0) goto L_0x0022
            boolean r4 = r11.startsWith(r0)
            if (r4 == 0) goto L_0x002e
        L_0x0022:
            boolean r4 = r11.endsWith(r3)
            if (r4 == 0) goto L_0x002f
            boolean r4 = r11.endsWith(r0)
            if (r4 != 0) goto L_0x002f
        L_0x002e:
            return r2
        L_0x002f:
            java.lang.String[] r3 = r11.split(r3)
            if (r1 == 0) goto L_0x0066
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.List r3 = java.util.Arrays.asList(r3)
            r4.<init>(r3)
            boolean r3 = r11.endsWith(r0)
            if (r3 == 0) goto L_0x004a
            java.lang.String r0 = ""
            r4.add(r0)
            goto L_0x0059
        L_0x004a:
            boolean r0 = r11.startsWith(r0)
            if (r0 == 0) goto L_0x0059
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x0059
            r4.remove(r2)
        L_0x0059:
            int r0 = r4.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.Object[] r0 = r4.toArray(r0)
            r3 = r0
            java.lang.String[] r3 = (java.lang.String[]) r3
        L_0x0066:
            int r0 = r3.length
            r4 = 8
            if (r0 <= r4) goto L_0x006c
            return r2
        L_0x006c:
            r0 = r2
            r5 = r0
            r6 = r5
        L_0x006f:
            int r7 = r3.length
            r8 = 1
            if (r0 >= r7) goto L_0x00c3
            r7 = r3[r0]
            int r9 = r7.length()
            if (r9 != 0) goto L_0x007f
            int r6 = r6 + r8
            if (r6 <= r8) goto L_0x00bd
            return r2
        L_0x007f:
            java.lang.String r6 = "."
            boolean r6 = r7.contains(r6)
            if (r6 == 0) goto L_0x00a2
            boolean r6 = r11.endsWith(r7)
            if (r6 != 0) goto L_0x008e
            return r2
        L_0x008e:
            int r6 = r3.length
            int r6 = r6 - r8
            if (r0 > r6) goto L_0x00a1
            r6 = 6
            if (r0 <= r6) goto L_0x0096
            goto L_0x00a1
        L_0x0096:
            boolean r6 = r10.isValidInet4Address(r7)
            if (r6 != 0) goto L_0x009d
            return r2
        L_0x009d:
            int r5 = r5 + 2
            r6 = r2
            goto L_0x00bf
        L_0x00a1:
            return r2
        L_0x00a2:
            int r6 = r7.length()
            r8 = 4
            if (r6 <= r8) goto L_0x00aa
            return r2
        L_0x00aa:
            r6 = 16
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7, r6)     // Catch:{ NumberFormatException -> 0x00c2 }
            int r6 = r6.intValue()     // Catch:{ NumberFormatException -> 0x00c2 }
            if (r6 < 0) goto L_0x00c2
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r6 <= r7) goto L_0x00bc
            goto L_0x00c2
        L_0x00bc:
            r6 = r2
        L_0x00bd:
            int r5 = r5 + 1
        L_0x00bf:
            int r0 = r0 + 1
            goto L_0x006f
        L_0x00c2:
            return r2
        L_0x00c3:
            if (r5 >= r4) goto L_0x00c8
            if (r1 != 0) goto L_0x00c8
            return r2
        L_0x00c8:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.validator.routines.InetAddressValidator.isValidInet6Address(java.lang.String):boolean");
    }
}
