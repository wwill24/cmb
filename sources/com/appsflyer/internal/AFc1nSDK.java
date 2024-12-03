package com.appsflyer.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u0000 \u00012\u00020\u0014:\u0001\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u000b\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000b\u0010\u000eR\u0012\u0010\u0005\u001a\u00020\u0002X\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R \u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0002¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\b\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/appsflyer/internal/AFc1nSDK;", "AFa1wSDK", "", "valueOf", "[B", "AFInAppEventParameterName", "", "", "AFInAppEventType", "Ljava/util/Map;", "", "values", "I", "", "()Z", "p0", "p1", "p2", "<init>", "([BLjava/util/Map;I)V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AFc1nSDK {
    public static String AFKeystoreWrapper = "https://%smonitorsdk.%s/remote-debug/exception-manager";
    public static final AFa1wSDK AFa1wSDK = new AFa1wSDK((DefaultConstructorMarker) null);
    public Map<String, String> AFInAppEventType;
    public byte[] valueOf;
    public int values;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0003\u0018\u00002\u00020\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0004\u001a\u00020\u0001X\u0002¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/appsflyer/internal/AFc1nSDK$AFa1wSDK;", "", "AFKeystoreWrapper", "Ljava/lang/String;", "valueOf", "<init>", "()V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AFa1wSDK {
        private AFa1wSDK() {
        }

        public /* synthetic */ AFa1wSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFc1nSDK(byte[] bArr, Map<String, String> map, int i10) {
        j.g(bArr, "");
        this.valueOf = bArr;
        this.AFInAppEventType = map;
        this.values = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x017e, code lost:
        if (r10 == null) goto L_0x0180;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean values() {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r2 = "\n\ttook "
            java.lang.String r3 = "[Exception Manager]: "
            java.lang.String r4 = "] "
            java.lang.String r5 = "HTTP: ["
            java.lang.String r6 = ""
            long r7 = java.lang.System.currentTimeMillis()
            r9 = 0
            r10 = 0
            java.lang.String r0 = AFKeystoreWrapper     // Catch:{ all -> 0x01f0 }
            r11 = 2
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x01f0 }
            com.appsflyer.AppsFlyerLib r12 = com.appsflyer.AppsFlyerLib.getInstance()     // Catch:{ all -> 0x01f0 }
            java.lang.String r12 = r12.getHostPrefix()     // Catch:{ all -> 0x01f0 }
            r11[r9] = r12     // Catch:{ all -> 0x01f0 }
            com.appsflyer.internal.AFb1zSDK r12 = com.appsflyer.internal.AFb1zSDK.AFInAppEventType()     // Catch:{ all -> 0x01f0 }
            java.lang.String r12 = r12.getHostName()     // Catch:{ all -> 0x01f0 }
            r13 = 1
            r11[r13] = r12     // Catch:{ all -> 0x01f0 }
            java.lang.String r0 = java.lang.String.format(r0, r11)     // Catch:{ all -> 0x01f0 }
            kotlin.jvm.internal.j.f(r0, r6)     // Catch:{ all -> 0x01f0 }
            kotlin.jvm.internal.j.g(r0, r6)     // Catch:{ all -> 0x01f0 }
            java.net.URL r11 = new java.net.URL     // Catch:{ all -> 0x01f0 }
            r11.<init>(r0)     // Catch:{ all -> 0x01f0 }
            java.net.URLConnection r0 = r11.openConnection()     // Catch:{ all -> 0x01f0 }
            if (r0 == 0) goto L_0x01e8
            r11 = r0
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x01f0 }
            java.lang.String r0 = "POST"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x01e5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e5 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e5 }
            r10.<init>()     // Catch:{ all -> 0x01e5 }
            java.lang.String r12 = r11.getRequestMethod()     // Catch:{ all -> 0x01e5 }
            r10.append(r12)     // Catch:{ all -> 0x01e5 }
            r12 = 58
            r10.append(r12)     // Catch:{ all -> 0x01e5 }
            java.net.URL r12 = r11.getURL()     // Catch:{ all -> 0x01e5 }
            r10.append(r12)     // Catch:{ all -> 0x01e5 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01e5 }
            r0.<init>(r10)     // Catch:{ all -> 0x01e5 }
            java.lang.String r10 = "\n length: "
            r0.append(r10)     // Catch:{ all -> 0x01e5 }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x01e5 }
            byte[] r12 = r1.valueOf     // Catch:{ all -> 0x01e5 }
            java.nio.charset.Charset r14 = kotlin.text.d.f32216b     // Catch:{ all -> 0x01e5 }
            r10.<init>(r12, r14)     // Catch:{ all -> 0x01e5 }
            int r10 = r10.length()     // Catch:{ all -> 0x01e5 }
            r0.append(r10)     // Catch:{ all -> 0x01e5 }
            java.util.Map<java.lang.String, java.lang.String> r10 = r1.AFInAppEventType     // Catch:{ all -> 0x01e5 }
            if (r10 == 0) goto L_0x00b4
            java.util.Set r10 = r10.entrySet()     // Catch:{ all -> 0x01e5 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x01e5 }
        L_0x008b:
            boolean r12 = r10.hasNext()     // Catch:{ all -> 0x01e5 }
            if (r12 == 0) goto L_0x00b4
            java.lang.Object r12 = r10.next()     // Catch:{ all -> 0x01e5 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ all -> 0x01e5 }
            java.lang.String r14 = "\n "
            r0.append(r14)     // Catch:{ all -> 0x01e5 }
            java.lang.Object r14 = r12.getKey()     // Catch:{ all -> 0x01e5 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x01e5 }
            r0.append(r14)     // Catch:{ all -> 0x01e5 }
            java.lang.String r14 = ": "
            r0.append(r14)     // Catch:{ all -> 0x01e5 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ all -> 0x01e5 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x01e5 }
            r0.append(r12)     // Catch:{ all -> 0x01e5 }
            goto L_0x008b
        L_0x00b4:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e5 }
            r10.<init>(r5)     // Catch:{ all -> 0x01e5 }
            int r12 = r11.hashCode()     // Catch:{ all -> 0x01e5 }
            r10.append(r12)     // Catch:{ all -> 0x01e5 }
            r10.append(r4)     // Catch:{ all -> 0x01e5 }
            r10.append(r0)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x01e5 }
            kotlin.jvm.internal.j.g(r0, r6)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x01e5 }
            com.appsflyer.AFLogger.afRDLog(r0)     // Catch:{ all -> 0x01e5 }
            r11.setInstanceFollowRedirects(r9)     // Catch:{ all -> 0x01e5 }
            r11.setUseCaches(r9)     // Catch:{ all -> 0x01e5 }
            int r0 = r1.values     // Catch:{ all -> 0x01e5 }
            r11.setReadTimeout(r0)     // Catch:{ all -> 0x01e5 }
            int r0 = r1.values     // Catch:{ all -> 0x01e5 }
            r11.setConnectTimeout(r0)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r10 = "application/json"
            r11.addRequestProperty(r0, r10)     // Catch:{ all -> 0x01e5 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.AFInAppEventType     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x0117
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x01e5 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01e5 }
        L_0x00fb:
            boolean r10 = r0.hasNext()     // Catch:{ all -> 0x01e5 }
            if (r10 == 0) goto L_0x0117
            java.lang.Object r10 = r0.next()     // Catch:{ all -> 0x01e5 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x01e5 }
            java.lang.Object r12 = r10.getKey()     // Catch:{ all -> 0x01e5 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x01e5 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ all -> 0x01e5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x01e5 }
            r11.addRequestProperty(r12, r10)     // Catch:{ all -> 0x01e5 }
            goto L_0x00fb
        L_0x0117:
            r11.setDoOutput(r13)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = "Content-Length"
            byte[] r10 = r1.valueOf     // Catch:{ all -> 0x01e5 }
            int r10 = r10.length     // Catch:{ all -> 0x01e5 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x01e5 }
            r11.setRequestProperty(r0, r10)     // Catch:{ all -> 0x01e5 }
            java.io.OutputStream r0 = r11.getOutputStream()     // Catch:{ all -> 0x01e3 }
            kotlin.jvm.internal.j.f(r0, r6)     // Catch:{ all -> 0x01e3 }
            boolean r10 = r0 instanceof java.io.BufferedOutputStream     // Catch:{ all -> 0x01e3 }
            r12 = 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x0136
            java.io.BufferedOutputStream r0 = (java.io.BufferedOutputStream) r0     // Catch:{ all -> 0x01e3 }
            goto L_0x013c
        L_0x0136:
            java.io.BufferedOutputStream r10 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x01e3 }
            r10.<init>(r0, r12)     // Catch:{ all -> 0x01e3 }
            r0 = r10
        L_0x013c:
            byte[] r10 = r1.valueOf     // Catch:{ all -> 0x01e3 }
            r0.write(r10)     // Catch:{ all -> 0x01e3 }
            r0.close()     // Catch:{ all -> 0x01e5 }
            boolean r0 = com.appsflyer.internal.AFc1vSDK.AFa1wSDK.valueOf((java.net.HttpURLConnection) r11)     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x014f
            java.io.InputStream r0 = r11.getInputStream()     // Catch:{ all -> 0x01e5 }
            goto L_0x0153
        L_0x014f:
            java.io.InputStream r0 = r11.getErrorStream()     // Catch:{ all -> 0x01e5 }
        L_0x0153:
            if (r0 == 0) goto L_0x0180
            kotlin.jvm.internal.j.f(r0, r6)     // Catch:{ all -> 0x01e5 }
            java.nio.charset.Charset r10 = kotlin.text.d.f32216b     // Catch:{ all -> 0x01e5 }
            java.io.InputStreamReader r13 = new java.io.InputStreamReader     // Catch:{ all -> 0x01e5 }
            r13.<init>(r0, r10)     // Catch:{ all -> 0x01e5 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x01e5 }
            r0.<init>(r13, r12)     // Catch:{ all -> 0x01e5 }
            java.util.List r14 = kotlin.io.TextStreamsKt.e(r0)     // Catch:{ all -> 0x01e5 }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 63
            r22 = 0
            java.lang.String r10 = kotlin.collections.CollectionsKt___CollectionsKt.W(r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x01e5 }
            r0.close()     // Catch:{ all -> 0x01e5 }
            if (r10 != 0) goto L_0x0181
        L_0x0180:
            r10 = r6
        L_0x0181:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01e5 }
            long r12 = r12 - r7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e5 }
            java.lang.String r14 = "response code:"
            r0.<init>(r14)     // Catch:{ all -> 0x01e5 }
            int r14 = r11.getResponseCode()     // Catch:{ all -> 0x01e5 }
            r0.append(r14)     // Catch:{ all -> 0x01e5 }
            r14 = 32
            r0.append(r14)     // Catch:{ all -> 0x01e5 }
            java.lang.String r14 = r11.getResponseMessage()     // Catch:{ all -> 0x01e5 }
            r0.append(r14)     // Catch:{ all -> 0x01e5 }
            java.lang.String r14 = "\n\tbody:"
            r0.append(r14)     // Catch:{ all -> 0x01e5 }
            r0.append(r10)     // Catch:{ all -> 0x01e5 }
            r0.append(r2)     // Catch:{ all -> 0x01e5 }
            r0.append(r12)     // Catch:{ all -> 0x01e5 }
            java.lang.String r10 = "ms"
            r0.append(r10)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01e5 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e5 }
            r10.<init>(r5)     // Catch:{ all -> 0x01e5 }
            int r12 = r11.hashCode()     // Catch:{ all -> 0x01e5 }
            r10.append(r12)     // Catch:{ all -> 0x01e5 }
            r10.append(r4)     // Catch:{ all -> 0x01e5 }
            r10.append(r0)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x01e5 }
            kotlin.jvm.internal.j.g(r0, r6)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x01e5 }
            com.appsflyer.AFLogger.afRDLog(r0)     // Catch:{ all -> 0x01e5 }
            boolean r9 = com.appsflyer.internal.AFc1vSDK.AFa1wSDK.valueOf((java.net.HttpURLConnection) r11)     // Catch:{ all -> 0x01e5 }
            r11.disconnect()
            goto L_0x0243
        L_0x01e3:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x01e5 }
        L_0x01e5:
            r0 = move-exception
            r10 = r11
            goto L_0x01f1
        L_0x01e8:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x01f0 }
            java.lang.String r11 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r0.<init>(r11)     // Catch:{ all -> 0x01f0 }
            throw r0     // Catch:{ all -> 0x01f0 }
        L_0x01f0:
            r0 = move-exception
        L_0x01f1:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0244 }
            long r11 = r11 - r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0244 }
            java.lang.String r8 = "error: "
            r7.<init>(r8)     // Catch:{ all -> 0x0244 }
            r7.append(r0)     // Catch:{ all -> 0x0244 }
            r7.append(r2)     // Catch:{ all -> 0x0244 }
            r7.append(r11)     // Catch:{ all -> 0x0244 }
            java.lang.String r2 = "ms\n\t"
            r7.append(r2)     // Catch:{ all -> 0x0244 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0244 }
            r7.append(r0)     // Catch:{ all -> 0x0244 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0244 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0244 }
            r2.<init>(r5)     // Catch:{ all -> 0x0244 }
            if (r10 == 0) goto L_0x0222
            int r5 = r10.hashCode()     // Catch:{ all -> 0x0244 }
            goto L_0x0223
        L_0x0222:
            r5 = r9
        L_0x0223:
            r2.append(r5)     // Catch:{ all -> 0x0244 }
            r2.append(r4)     // Catch:{ all -> 0x0244 }
            r2.append(r0)     // Catch:{ all -> 0x0244 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0244 }
            kotlin.jvm.internal.j.g(r0, r6)     // Catch:{ all -> 0x0244 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0244 }
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0244 }
            com.appsflyer.AFLogger.afRDLog(r0)     // Catch:{ all -> 0x0244 }
            if (r10 == 0) goto L_0x0243
            r10.disconnect()
        L_0x0243:
            return r9
        L_0x0244:
            r0 = move-exception
            if (r10 == 0) goto L_0x024a
            r10.disconnect()
        L_0x024a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1nSDK.values():boolean");
    }
}
