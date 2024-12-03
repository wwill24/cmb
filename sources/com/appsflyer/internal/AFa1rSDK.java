package com.appsflyer.internal;

@Deprecated
public final class AFa1rSDK {
    private final AFe1jSDK AFKeystoreWrapper;

    public interface AFa1vSDK {
        void AFKeystoreWrapper(String str);

        void values(String str, String str2, String str3);
    }

    AFa1rSDK() {
    }

    public AFa1rSDK(AFe1jSDK aFe1jSDK) {
        this.AFKeystoreWrapper = aFe1jSDK;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0177  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.HttpURLConnection AFKeystoreWrapper(java.lang.String r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = ""
            com.appsflyer.internal.AFe1jSDK r0 = r1.AFKeystoreWrapper
            java.lang.String r3 = r0.AFLogger
            java.util.Map r0 = r0.AFInAppEventType()
            org.json.b r0 = com.appsflyer.internal.AFa1lSDK.AFInAppEventParameterName((java.util.Map<java.lang.String, ?>) r0)
            java.lang.String r0 = r0.toString()
            com.appsflyer.internal.AFe1jSDK r4 = r1.AFKeystoreWrapper
            boolean r4 = r4.AFVersionDeclaration()
            com.appsflyer.internal.AFe1jSDK r5 = r1.AFKeystoreWrapper
            boolean r5 = r5.afErrorLogForExcManagerOnly()
            com.appsflyer.internal.AFe1jSDK r6 = r1.AFKeystoreWrapper
            boolean r6 = r6.afWarnLog()
            com.appsflyer.internal.AFe1jSDK r7 = r1.AFKeystoreWrapper
            boolean r7 = r7.AFInAppEventParameterName()
            byte[] r8 = r0.getBytes()
            r9 = 0
            if (r4 == 0) goto L_0x0034
            return r9
        L_0x0034:
            r4 = 1
            r10 = 0
            java.net.URL r11 = new java.net.URL     // Catch:{ all -> 0x015c }
            r11.<init>(r3)     // Catch:{ all -> 0x015c }
            if (r6 == 0) goto L_0x007e
            com.appsflyer.internal.AFb1uSDK r12 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()     // Catch:{ all -> 0x015c }
            java.lang.String r13 = r11.toString()     // Catch:{ all -> 0x015c }
            r12.valueOf((java.lang.String) r13, (java.lang.String) r0)     // Catch:{ all -> 0x015c }
            java.lang.String r12 = "UTF-8"
            byte[] r12 = r0.getBytes(r12)     // Catch:{ all -> 0x015c }
            int r12 = r12.length     // Catch:{ all -> 0x015c }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x015c }
            java.lang.String r14 = "call = "
            r13.<init>(r14)     // Catch:{ all -> 0x015c }
            r13.append(r11)     // Catch:{ all -> 0x015c }
            java.lang.String r14 = "; size = "
            r13.append(r14)     // Catch:{ all -> 0x015c }
            r13.append(r12)     // Catch:{ all -> 0x015c }
            java.lang.String r14 = " byte"
            r13.append(r14)     // Catch:{ all -> 0x015c }
            if (r12 <= r4) goto L_0x006b
            java.lang.String r12 = "s"
            goto L_0x006c
        L_0x006b:
            r12 = r2
        L_0x006c:
            r13.append(r12)     // Catch:{ all -> 0x015c }
            java.lang.String r12 = "; body = "
            r13.append(r12)     // Catch:{ all -> 0x015c }
            r13.append(r0)     // Catch:{ all -> 0x015c }
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x015c }
            com.appsflyer.internal.AFc1sSDK.valueOf((java.lang.String) r0)     // Catch:{ all -> 0x015c }
        L_0x007e:
            java.lang.String r0 = "AppsFlyer"
            int r0 = r0.hashCode()     // Catch:{ all -> 0x015c }
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ all -> 0x015c }
            java.net.URLConnection r0 = r11.openConnection()     // Catch:{ all -> 0x015c }
            r12 = r0
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x015c }
            r0 = 30000(0x7530, float:4.2039E-41)
            r12.setReadTimeout(r0)     // Catch:{ all -> 0x0159 }
            r12.setConnectTimeout(r0)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = "POST"
            r12.setRequestMethod(r0)     // Catch:{ all -> 0x0159 }
            r12.setDoInput(r4)     // Catch:{ all -> 0x0159 }
            r12.setDoOutput(r4)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = "Content-Type"
            if (r7 == 0) goto L_0x00a8
            java.lang.String r13 = "application/octet-stream"
            goto L_0x00aa
        L_0x00a8:
            java.lang.String r13 = "application/json"
        L_0x00aa:
            r12.setRequestProperty(r0, r13)     // Catch:{ all -> 0x0159 }
            java.io.OutputStream r0 = r12.getOutputStream()     // Catch:{ all -> 0x0159 }
            if (r7 == 0) goto L_0x012e
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x0125 }
            r7[r10] = r18     // Catch:{ all -> 0x0125 }
            int r13 = android.view.KeyEvent.getModifierMetaStateMask()     // Catch:{ all -> 0x0125 }
            byte r13 = (byte) r13     // Catch:{ all -> 0x0125 }
            int r13 = 36 - r13
            int r14 = android.view.ViewConfiguration.getFadingEdgeLength()     // Catch:{ all -> 0x0125 }
            int r14 = r14 >> 16
            int r14 = r14 + 37
            int r15 = android.view.View.resolveSizeAndState(r10, r10, r10)     // Catch:{ all -> 0x0125 }
            char r15 = (char) r15     // Catch:{ all -> 0x0125 }
            java.lang.Object r13 = com.appsflyer.internal.AFa1vSDK.AFInAppEventType(r13, r14, r15)     // Catch:{ all -> 0x0125 }
            java.lang.Class r13 = (java.lang.Class) r13     // Catch:{ all -> 0x0125 }
            java.lang.String r14 = "AFKeystoreWrapper"
            java.lang.Class[] r15 = new java.lang.Class[r4]     // Catch:{ all -> 0x0125 }
            java.lang.Class<java.lang.String> r16 = java.lang.String.class
            r15[r10] = r16     // Catch:{ all -> 0x0125 }
            java.lang.reflect.Method r13 = r13.getMethod(r14, r15)     // Catch:{ all -> 0x0125 }
            java.lang.Object r7 = r13.invoke(r9, r7)     // Catch:{ all -> 0x0125 }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x011c }
            r9[r10] = r8     // Catch:{ all -> 0x011c }
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x011c }
            r15 = 0
            int r8 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            int r8 = 38 - r8
            int r13 = android.os.Process.getThreadPriority(r10)     // Catch:{ all -> 0x011c }
            int r13 = r13 + 20
            int r13 = r13 >> 6
            int r13 = 37 - r13
            r14 = 48
            int r14 = android.text.TextUtils.indexOf(r2, r14, r10, r10)     // Catch:{ all -> 0x011c }
            int r14 = -1 - r14
            char r14 = (char) r14     // Catch:{ all -> 0x011c }
            java.lang.Object r8 = com.appsflyer.internal.AFa1vSDK.AFInAppEventType(r8, r13, r14)     // Catch:{ all -> 0x011c }
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x011c }
            java.lang.String r13 = "AFInAppEventType"
            java.lang.Class[] r14 = new java.lang.Class[r4]     // Catch:{ all -> 0x011c }
            java.lang.Class<byte[]> r15 = byte[].class
            r14[r10] = r15     // Catch:{ all -> 0x011c }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r13, r14)     // Catch:{ all -> 0x011c }
            java.lang.Object r7 = r8.invoke(r7, r9)     // Catch:{ all -> 0x011c }
            r8 = r7
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x011c }
            goto L_0x012e
        L_0x011c:
            r0 = move-exception
            java.lang.Throwable r5 = r0.getCause()     // Catch:{ all -> 0x0159 }
            if (r5 == 0) goto L_0x0124
            throw r5     // Catch:{ all -> 0x0159 }
        L_0x0124:
            throw r0     // Catch:{ all -> 0x0159 }
        L_0x0125:
            r0 = move-exception
            java.lang.Throwable r5 = r0.getCause()     // Catch:{ all -> 0x0159 }
            if (r5 == 0) goto L_0x012d
            throw r5     // Catch:{ all -> 0x0159 }
        L_0x012d:
            throw r0     // Catch:{ all -> 0x0159 }
        L_0x012e:
            r0.write(r8)     // Catch:{ all -> 0x0159 }
            r0.close()     // Catch:{ all -> 0x0159 }
            r12.connect()     // Catch:{ all -> 0x0159 }
            int r0 = r12.getResponseCode()     // Catch:{ all -> 0x0159 }
            if (r5 == 0) goto L_0x0141
            java.lang.String r2 = com.appsflyer.internal.AFb1zSDK.AFInAppEventParameterName((java.net.HttpURLConnection) r12)     // Catch:{ all -> 0x0159 }
        L_0x0141:
            if (r6 == 0) goto L_0x014e
            com.appsflyer.internal.AFb1uSDK r5 = com.appsflyer.internal.AFb1uSDK.AFInAppEventType()     // Catch:{ all -> 0x0159 }
            java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x0159 }
            r5.AFInAppEventType(r6, r0, r2)     // Catch:{ all -> 0x0159 }
        L_0x014e:
            r5 = 200(0xc8, float:2.8E-43)
            if (r0 != r5) goto L_0x016b
            java.lang.String r0 = "Status 200 ok"
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x0159 }
            r4 = r10
            goto L_0x016b
        L_0x0159:
            r0 = move-exception
            r9 = r12
            goto L_0x015d
        L_0x015c:
            r0 = move-exception
        L_0x015d:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "Error while calling "
            java.lang.String r3 = r5.concat(r3)
            com.appsflyer.AFLogger.afErrorLog(r3, r0)
            r12 = r9
        L_0x016b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Connection "
            r0.<init>(r3)
            if (r4 == 0) goto L_0x0177
            java.lang.String r3 = "error"
            goto L_0x0179
        L_0x0177:
            java.lang.String r3 = "call succeeded"
        L_0x0179:
            r0.append(r3)
            java.lang.String r3 = ": "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1rSDK.AFKeystoreWrapper(java.lang.String):java.net.HttpURLConnection");
    }
}
