package com.appsflyer.internal;

import androidx.annotation.NonNull;
import net.bytebuddy.asm.Advice;

public final class AFe1zSDK {
    private static char[] AFInAppEventType = null;
    private static int AFKeystoreWrapper = 0;
    private static int values = 1;

    static {
        AFInAppEventParameterName();
        int i10 = values + 105;
        AFKeystoreWrapper = i10 % 128;
        int i11 = i10 % 2;
    }

    static void AFInAppEventParameterName() {
        AFInAppEventType = new char[]{'6', 'k', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'o', 'o', 'l', 'i', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 'q', 'k', 'l', 'k', 'j', 'q', Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 'k', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'k', 'l', 'n', 'n', 'l', 'n', Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'k', 'l', 'k', 'j', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'l', 'k', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'n', 'n', 'n', 'j', 'j', Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 'u', 'l', 'l', 'k', 'k', 'n', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 'n', 'n', 'u', 'u', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 'l', 'j', 'k', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL};
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r8v3, types: [char] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFKeystoreWrapper(java.lang.String r12, boolean r13, int[] r14, java.lang.Object[] r15) {
        /*
            if (r12 == 0) goto L_0x0008
            java.lang.String r0 = "ISO-8859-1"
            byte[] r12 = r12.getBytes(r0)
        L_0x0008:
            byte[] r12 = (byte[]) r12
            java.lang.Object r0 = com.appsflyer.internal.AFf1iSDK.valueOf
            monitor-enter(r0)
            r1 = 0
            r2 = r14[r1]     // Catch:{ all -> 0x008b }
            r3 = 1
            r4 = r14[r3]     // Catch:{ all -> 0x008b }
            r5 = 2
            r6 = r14[r5]     // Catch:{ all -> 0x008b }
            r7 = 3
            r7 = r14[r7]     // Catch:{ all -> 0x008b }
            char[] r8 = AFInAppEventType     // Catch:{ all -> 0x008b }
            char[] r9 = new char[r4]     // Catch:{ all -> 0x008b }
            java.lang.System.arraycopy(r8, r2, r9, r1, r4)     // Catch:{ all -> 0x008b }
            if (r12 == 0) goto L_0x0047
            char[] r2 = new char[r4]     // Catch:{ all -> 0x008b }
            com.appsflyer.internal.AFf1iSDK.values = r1     // Catch:{ all -> 0x008b }
            r8 = r1
        L_0x0027:
            int r10 = com.appsflyer.internal.AFf1iSDK.values     // Catch:{ all -> 0x008b }
            if (r10 >= r4) goto L_0x0046
            byte r11 = r12[r10]     // Catch:{ all -> 0x008b }
            if (r11 != r3) goto L_0x0038
            char r11 = r9[r10]     // Catch:{ all -> 0x008b }
            int r11 = r11 << r3
            int r11 = r11 + r3
            int r11 = r11 - r8
            char r8 = (char) r11     // Catch:{ all -> 0x008b }
            r2[r10] = r8     // Catch:{ all -> 0x008b }
            goto L_0x003f
        L_0x0038:
            char r11 = r9[r10]     // Catch:{ all -> 0x008b }
            int r11 = r11 << r3
            int r11 = r11 - r8
            char r8 = (char) r11     // Catch:{ all -> 0x008b }
            r2[r10] = r8     // Catch:{ all -> 0x008b }
        L_0x003f:
            char r8 = r2[r10]     // Catch:{ all -> 0x008b }
            int r10 = r10 + 1
            com.appsflyer.internal.AFf1iSDK.values = r10     // Catch:{ all -> 0x008b }
            goto L_0x0027
        L_0x0046:
            r9 = r2
        L_0x0047:
            if (r7 <= 0) goto L_0x0056
            char[] r12 = new char[r4]     // Catch:{ all -> 0x008b }
            java.lang.System.arraycopy(r9, r1, r12, r1, r4)     // Catch:{ all -> 0x008b }
            int r2 = r4 - r7
            java.lang.System.arraycopy(r12, r1, r9, r2, r7)     // Catch:{ all -> 0x008b }
            java.lang.System.arraycopy(r12, r7, r9, r1, r2)     // Catch:{ all -> 0x008b }
        L_0x0056:
            if (r13 == 0) goto L_0x006d
            char[] r12 = new char[r4]     // Catch:{ all -> 0x008b }
            com.appsflyer.internal.AFf1iSDK.values = r1     // Catch:{ all -> 0x008b }
        L_0x005c:
            int r13 = com.appsflyer.internal.AFf1iSDK.values     // Catch:{ all -> 0x008b }
            if (r13 >= r4) goto L_0x006c
            int r2 = r4 - r13
            int r2 = r2 - r3
            char r2 = r9[r2]     // Catch:{ all -> 0x008b }
            r12[r13] = r2     // Catch:{ all -> 0x008b }
            int r13 = r13 + 1
            com.appsflyer.internal.AFf1iSDK.values = r13     // Catch:{ all -> 0x008b }
            goto L_0x005c
        L_0x006c:
            r9 = r12
        L_0x006d:
            if (r6 <= 0) goto L_0x0082
            com.appsflyer.internal.AFf1iSDK.values = r1     // Catch:{ all -> 0x008b }
        L_0x0071:
            int r12 = com.appsflyer.internal.AFf1iSDK.values     // Catch:{ all -> 0x008b }
            if (r12 >= r4) goto L_0x0082
            char r13 = r9[r12]     // Catch:{ all -> 0x008b }
            r2 = r14[r5]     // Catch:{ all -> 0x008b }
            int r13 = r13 - r2
            char r13 = (char) r13     // Catch:{ all -> 0x008b }
            r9[r12] = r13     // Catch:{ all -> 0x008b }
            int r12 = r12 + 1
            com.appsflyer.internal.AFf1iSDK.values = r12     // Catch:{ all -> 0x008b }
            goto L_0x0071
        L_0x0082:
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x008b }
            r12.<init>(r9)     // Catch:{ all -> 0x008b }
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            r15[r1] = r12
            return
        L_0x008b:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1zSDK.AFKeystoreWrapper(java.lang.String, boolean, int[], java.lang.Object[]):void");
    }

    @NonNull
    private static AFb1iSDK values(@NonNull AFb1oSDK aFb1oSDK, String str, @NonNull String str2, @NonNull String str3) {
        String str4;
        AFf1xSDK aFf1xSDK;
        boolean z10 = true;
        if (str == null) {
            if (aFb1oSDK.values != AFf1wSDK.DEFAULT) {
                z10 = false;
            }
            return new AFb1iSDK(z10, AFf1xSDK.NA);
        }
        Object[] objArr = new Object[1];
        AFKeystoreWrapper("\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0000\u0001\u0001", false, new int[]{0, 64, 56, 15}, objArr);
        String intern = ((String) objArr[0]).intern();
        if (aFb1oSDK.values == AFf1wSDK.CUSTOM) {
            str4 = new StringBuilder(str2).reverse().toString();
        } else {
            str4 = "";
            str3 = intern;
        }
        boolean equals = AFInAppEventType(new StringBuilder(str3).reverse().toString(), aFb1oSDK.AFKeystoreWrapper, "android", "v1", str4).equals(str);
        if (equals) {
            aFf1xSDK = AFf1xSDK.SUCCESS;
        } else {
            aFf1xSDK = AFf1xSDK.FAILURE;
        }
        return new AFb1iSDK(equals, aFf1xSDK);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFb1iSDK AFInAppEventType(@androidx.annotation.NonNull com.appsflyer.internal.AFb1oSDK r5, java.lang.String r6, @androidx.annotation.NonNull java.lang.String r7, @androidx.annotation.NonNull java.lang.String r8) {
        /*
            r4 = this;
            int r0 = AFKeystoreWrapper
            int r0 = r0 + 51
            int r1 = r0 % 128
            values = r1
            int r0 = r0 % 2
            r0 = 71
            if (r5 == 0) goto L_0x0011
            r2 = 89
            goto L_0x0012
        L_0x0011:
            r2 = r0
        L_0x0012:
            r3 = 0
            if (r2 == r0) goto L_0x0029
            int r1 = r1 + 27
            int r2 = r1 % 128
            AFKeystoreWrapper = r2
            int r1 = r1 % 2
            if (r7 == 0) goto L_0x0029
            r1 = 42
            if (r8 == 0) goto L_0x0024
            r0 = r1
        L_0x0024:
            if (r0 == r1) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = r3
        L_0x002a:
            if (r0 != 0) goto L_0x003e
            com.appsflyer.internal.AFb1iSDK r5 = new com.appsflyer.internal.AFb1iSDK
            com.appsflyer.internal.AFf1xSDK r6 = com.appsflyer.internal.AFf1xSDK.INTERNAL_ERROR
            r5.<init>(r3, r6)
            int r6 = AFKeystoreWrapper
            int r6 = r6 + 21
            int r7 = r6 % 128
            values = r7
            int r6 = r6 % 2
            return r5
        L_0x003e:
            com.appsflyer.internal.AFb1iSDK r5 = values(r5, r6, r7, r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1zSDK.AFInAppEventType(com.appsflyer.internal.AFb1oSDK, java.lang.String, java.lang.String, java.lang.String):com.appsflyer.internal.AFb1iSDK");
    }

    private static String AFInAppEventType(String str, String str2, String str3, String str4, String str5) {
        String values2 = AFa1aSDK.values(AFa1aSDK.values(str2, str3, str4, str5, ""), str);
        if (values2.length() >= 12) {
            return values2.substring(0, 12);
        }
        int i10 = AFKeystoreWrapper;
        int i11 = i10 + 39;
        values = i11 % 128;
        int i12 = i11 % 2;
        int i13 = i10 + 93;
        values = i13 % 128;
        int i14 = i13 % 2;
        return values2;
    }
}
