package com.appsflyer.internal;

public final class AFc1mSDK {
    private final int AFKeystoreWrapper;

    public AFc1mSDK(int i10) {
        this.AFKeystoreWrapper = i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFInAppEventType(java.net.HttpURLConnection r4, boolean r5) throws java.io.IOException {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0008
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x0048 }
            goto L_0x000c
        L_0x0008:
            java.io.InputStream r4 = r4.getErrorStream()     // Catch:{ all -> 0x0048 }
        L_0x000c:
            if (r4 != 0) goto L_0x0011
            java.lang.String r4 = ""
            return r4
        L_0x0011:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r5.<init>()     // Catch:{ all -> 0x0048 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x0048 }
            r1.<init>(r4)     // Catch:{ all -> 0x0048 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0044 }
            r4.<init>(r1)     // Catch:{ all -> 0x0044 }
            r0 = 1
        L_0x0021:
            java.lang.String r2 = r4.readLine()     // Catch:{ all -> 0x003e }
            if (r2 == 0) goto L_0x0033
            if (r0 != 0) goto L_0x002e
            r0 = 10
            r5.append(r0)     // Catch:{ all -> 0x003e }
        L_0x002e:
            r5.append(r2)     // Catch:{ all -> 0x003e }
            r0 = 0
            goto L_0x0021
        L_0x0033:
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x003e }
            r1.close()
            r4.close()
            return r5
        L_0x003e:
            r5 = move-exception
            r0 = r1
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x004a
        L_0x0044:
            r4 = move-exception
            r5 = r0
            r0 = r1
            goto L_0x004a
        L_0x0048:
            r4 = move-exception
            r5 = r0
        L_0x004a:
            if (r0 == 0) goto L_0x004f
            r0.close()
        L_0x004f:
            if (r5 == 0) goto L_0x0054
            r5.close()
        L_0x0054:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1mSDK.AFInAppEventType(java.net.HttpURLConnection, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x014b A[Catch:{ Exception -> 0x01e0, all -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x023d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFc1dSDK<java.lang.String> AFInAppEventParameterName(com.appsflyer.internal.AFc1sSDK r20) throws java.io.IOException {
        /*
            r19 = this;
            java.lang.String r1 = "ms"
            java.lang.String r2 = "\n took "
            java.lang.String r3 = "] "
            java.lang.String r4 = "HTTP: ["
            long r5 = java.lang.System.currentTimeMillis()
            r8 = 0
            byte[] r0 = r20.AFInAppEventType()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            r10.<init>()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.lang.String r11 = r20.AFLogger()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            r10.append(r11)     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.lang.String r11 = ":"
            r10.append(r11)     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.lang.String r11 = r20.values()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            r10.append(r11)     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            byte[] r10 = r20.AFInAppEventType()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            if (r10 == 0) goto L_0x005c
            boolean r11 = r20.afErrorLog()     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            if (r11 == 0) goto L_0x0041
            java.lang.String r10 = "<encrypted>"
            goto L_0x0047
        L_0x0041:
            java.lang.String r11 = new java.lang.String     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            r10 = r11
        L_0x0047:
            java.lang.String r11 = "\n payload: "
            r9.append(r11)     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            r9.append(r10)     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            goto L_0x005c
        L_0x0050:
            r0 = move-exception
            r7 = 0
            r10 = r19
            goto L_0x023b
        L_0x0056:
            r0 = move-exception
            r7 = 0
            r10 = r19
            goto L_0x01f7
        L_0x005c:
            java.util.Map r10 = r20.afInfoLog()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.util.Set r10 = r10.entrySet()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
        L_0x0068:
            boolean r11 = r10.hasNext()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            if (r11 == 0) goto L_0x0091
            java.lang.Object r11 = r10.next()     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            java.lang.String r12 = "\n "
            r9.append(r12)     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            r9.append(r12)     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            java.lang.String r12 = ": "
            r9.append(r12)     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            java.lang.Object r11 = r11.getValue()     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            r9.append(r11)     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            goto L_0x0068
        L_0x0091:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            r10.<init>(r4)     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            int r11 = r20.hashCode()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            r10.append(r11)     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            r10.append(r3)     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            r10.append(r9)     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            com.appsflyer.AFLogger.afDebugLog(r9)     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.lang.String r10 = r20.values()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ Exception -> 0x01f2, all -> 0x01ec }
            java.lang.String r10 = r20.AFLogger()     // Catch:{ Exception -> 0x01e7, all -> 0x01e2 }
            r9.setRequestMethod(r10)     // Catch:{ Exception -> 0x01e7, all -> 0x01e2 }
            boolean r10 = r20.AFVersionDeclaration()     // Catch:{ Exception -> 0x01e7, all -> 0x01e2 }
            if (r10 == 0) goto L_0x00c9
            r9.setUseCaches(r8)     // Catch:{ Exception -> 0x01e7, all -> 0x01e2 }
        L_0x00c9:
            boolean r10 = r20.getLevel()     // Catch:{ Exception -> 0x01e7, all -> 0x01e2 }
            if (r10 != 0) goto L_0x00d2
            r9.setInstanceFollowRedirects(r8)     // Catch:{ Exception -> 0x01e7, all -> 0x01e2 }
        L_0x00d2:
            r10 = r19
            int r11 = r10.AFKeystoreWrapper     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            int r12 = r20.afDebugLog()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r13 = -1
            if (r12 == r13) goto L_0x00de
            r11 = r12
        L_0x00de:
            r9.setConnectTimeout(r11)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r9.setReadTimeout(r11)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            boolean r11 = r20.afErrorLog()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            if (r11 == 0) goto L_0x00ed
            java.lang.String r11 = "application/octet-stream"
            goto L_0x00ef
        L_0x00ed:
            java.lang.String r11 = "application/json"
        L_0x00ef:
            java.lang.String r12 = "Content-Type"
            r9.addRequestProperty(r12, r11)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.util.Map r11 = r20.afInfoLog()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.util.Set r11 = r11.entrySet()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
        L_0x0100:
            boolean r12 = r11.hasNext()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            if (r12 == 0) goto L_0x011c
            java.lang.Object r12 = r11.next()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.Object r13 = r12.getKey()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.Object r12 = r12.getValue()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r9.setRequestProperty(r13, r12)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            goto L_0x0100
        L_0x011c:
            r11 = 1
            if (r0 == 0) goto L_0x014f
            r9.setDoOutput(r11)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r12 = "Content-Length"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r13.<init>()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            int r14 = r0.length     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r13.append(r14)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r9.setRequestProperty(r12, r13)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.io.BufferedOutputStream r12 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0147 }
            java.io.OutputStream r13 = r9.getOutputStream()     // Catch:{ all -> 0x0147 }
            r12.<init>(r13)     // Catch:{ all -> 0x0147 }
            r12.write(r0)     // Catch:{ all -> 0x0144 }
            r12.close()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            goto L_0x014f
        L_0x0144:
            r0 = move-exception
            r7 = r12
            goto L_0x0149
        L_0x0147:
            r0 = move-exception
            r7 = 0
        L_0x0149:
            if (r7 == 0) goto L_0x014e
            r7.close()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
        L_0x014e:
            throw r0     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
        L_0x014f:
            int r0 = r9.getResponseCode()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            int r0 = r0 / 100
            r12 = 2
            if (r0 != r12) goto L_0x0159
            goto L_0x015a
        L_0x0159:
            r11 = r8
        L_0x015a:
            boolean r0 = r20.afRDLog()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r12 = ""
            if (r0 == 0) goto L_0x0168
            java.lang.String r0 = AFInAppEventType(r9, r11)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r14 = r0
            goto L_0x0169
        L_0x0168:
            r14 = r12
        L_0x0169:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            long r12 = r12 - r5
            com.appsflyer.internal.AFc1jSDK r0 = new com.appsflyer.internal.AFc1jSDK     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r0.<init>(r12)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r13 = "response code:"
            r12.<init>(r13)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            int r13 = r9.getResponseCode()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r12.append(r13)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r13 = " "
            r12.append(r13)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r13 = r9.getResponseMessage()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r12.append(r13)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r13 = "\n body:"
            r12.append(r13)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r12.append(r14)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r12.append(r2)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            long r7 = r0.values     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r12.append(r7)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r12.append(r1)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r7 = r12.toString()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r8.<init>(r4)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            int r12 = r20.hashCode()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r8.append(r12)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r8.append(r3)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r8.append(r7)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            com.appsflyer.AFLogger.afDebugLog(r7)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            java.util.Map r8 = r9.getHeaderFields()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r7.<init>(r8)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r8 = 0
            r7.remove(r8)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            com.appsflyer.internal.AFc1dSDK r8 = new com.appsflyer.internal.AFc1dSDK     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            int r15 = r9.getResponseCode()     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r13 = r8
            r16 = r11
            r17 = r7
            r18 = r0
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x01e0, all -> 0x01de }
            r9.disconnect()
            return r8
        L_0x01de:
            r0 = move-exception
            goto L_0x01e5
        L_0x01e0:
            r0 = move-exception
            goto L_0x01ea
        L_0x01e2:
            r0 = move-exception
            r10 = r19
        L_0x01e5:
            r7 = r9
            goto L_0x023b
        L_0x01e7:
            r0 = move-exception
            r10 = r19
        L_0x01ea:
            r7 = r9
            goto L_0x01f7
        L_0x01ec:
            r0 = move-exception
            r10 = r19
            r8 = 0
            r7 = r8
            goto L_0x023b
        L_0x01f2:
            r0 = move-exception
            r10 = r19
            r8 = 0
            r7 = r8
        L_0x01f7:
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x023a }
            long r8 = r8 - r5
            com.appsflyer.internal.AFc1jSDK r5 = new com.appsflyer.internal.AFc1jSDK     // Catch:{ all -> 0x023a }
            r5.<init>(r8)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x023a }
            java.lang.String r8 = "error: "
            r6.<init>(r8)     // Catch:{ all -> 0x023a }
            r6.append(r0)     // Catch:{ all -> 0x023a }
            r6.append(r2)     // Catch:{ all -> 0x023a }
            long r8 = r5.values     // Catch:{ all -> 0x023a }
            r6.append(r8)     // Catch:{ all -> 0x023a }
            r6.append(r1)     // Catch:{ all -> 0x023a }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x023a }
            r2.<init>(r4)     // Catch:{ all -> 0x023a }
            int r4 = r20.hashCode()     // Catch:{ all -> 0x023a }
            r2.append(r4)     // Catch:{ all -> 0x023a }
            r2.append(r3)     // Catch:{ all -> 0x023a }
            r2.append(r1)     // Catch:{ all -> 0x023a }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x023a }
            r2 = 0
            com.appsflyer.AFLogger.afErrorLog(r1, r0, r2, r2)     // Catch:{ all -> 0x023a }
            com.appsflyer.internal.components.network.http.exceptions.HttpException r1 = new com.appsflyer.internal.components.network.http.exceptions.HttpException     // Catch:{ all -> 0x023a }
            r1.<init>(r0, r5)     // Catch:{ all -> 0x023a }
            throw r1     // Catch:{ all -> 0x023a }
        L_0x023a:
            r0 = move-exception
        L_0x023b:
            if (r7 == 0) goto L_0x0240
            r7.disconnect()
        L_0x0240:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1mSDK.AFInAppEventParameterName(com.appsflyer.internal.AFc1sSDK):com.appsflyer.internal.AFc1dSDK");
    }
}
