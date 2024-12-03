package com.appsflyer.internal;

import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.leanplum.internal.Constants;
import java.lang.ref.WeakReference;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jivesoftware.smack.util.StringUtils;
import org.json.b;

public final class AFa1aSDK {
    private static int AFInAppEventType = 0;
    private static int AFKeystoreWrapper = 1;
    private static char[] values = {137, 282, 289, 280, 277, 284, 278, 273, 272, 279, 284, 281};

    public static String AFInAppEventParameterName(String str) {
        String str2;
        int i10 = AFInAppEventType + 15;
        AFKeystoreWrapper = i10 % 128;
        String str3 = null;
        if ((i10 % 2 == 0 ? 'V' : '\\') != 'V') {
            try {
                MessageDigest instance = MessageDigest.getInstance(StringUtils.MD5);
                instance.reset();
                instance.update(str.getBytes("UTF-8"));
                str2 = AFInAppEventType(instance.digest());
            } catch (Exception e10) {
                StringBuilder sb2 = new StringBuilder("Error turning ");
                sb2.append(str.substring(0, 6));
                sb2.append(".. to MD5");
                AFLogger.afErrorLog(sb2.toString(), e10);
            }
        } else {
            MessageDigest instance2 = MessageDigest.getInstance(StringUtils.MD5);
            instance2.reset();
            instance2.update(str.getBytes("UTF-8"));
            str3 = AFInAppEventType(instance2.digest());
            int i11 = 61 / 0;
            str2 = str3;
        }
        int i12 = AFKeystoreWrapper + 119;
        AFInAppEventType = i12 % 128;
        int i13 = i12 % 2;
        return str2;
    }

    private static String AFInAppEventType(byte[] bArr) {
        boolean z10;
        Formatter formatter = new Formatter();
        int length = bArr.length;
        int i10 = AFKeystoreWrapper + 37;
        AFInAppEventType = i10 % 128;
        int i11 = i10 % 2;
        int i12 = 0;
        while (true) {
            if (i12 < length) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i12])});
                i12++;
                int i13 = AFKeystoreWrapper + 109;
                AFInAppEventType = i13 % 128;
                int i14 = i13 % 2;
            } else {
                String obj = formatter.toString();
                formatter.close();
                return obj;
            }
        }
    }

    public static boolean AFKeystoreWrapper(Map<String, Object> map, String[] strArr, AFb1fSDK aFb1fSDK) throws IllegalStateException {
        int i10 = AFKeystoreWrapper + 111;
        AFInAppEventType = i10 % 128;
        int i11 = i10 % 2;
        if (map != null) {
            if ((map.isEmpty() ? '<' : '_') != '<') {
                int length = strArr.length;
                int i12 = 0;
                while (true) {
                    if ((i12 < length ? 'B' : SignatureVisitor.EXTENDS) != 'B') {
                        String str = (String) map.remove("sig");
                        if (str == null) {
                            int i13 = AFInAppEventType + 7;
                            AFKeystoreWrapper = i13 % 128;
                            int i14 = i13 % 2;
                            return false;
                        }
                        String valueOf = AFb1fSDK.valueOf();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(new b((Map<?, ?>) map));
                        sb2.append(valueOf);
                        return values(sb2.toString(), AFb1xSDK.AFInAppEventParameterName(new WeakReference(aFb1fSDK.valueOf.values))).equals(str);
                    } else if (!map.containsKey(strArr[i12])) {
                        return false;
                    } else {
                        i12++;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        r3 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0079 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String valueOf(java.lang.String r7) {
        /*
            int r0 = AFInAppEventType
            int r0 = r0 + 73
            int r1 = r0 % 128
            AFKeystoreWrapper = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            java.lang.String r3 = "UTF-8"
            java.lang.String r4 = "SHA-1"
            r5 = 0
            if (r0 != r2) goto L_0x002f
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r4)     // Catch:{ Exception -> 0x004a }
            r0.reset()     // Catch:{ Exception -> 0x004a }
            byte[] r3 = r7.getBytes(r3)     // Catch:{ Exception -> 0x004a }
            r0.update(r3)     // Catch:{ Exception -> 0x004a }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x004a }
            java.lang.String r7 = AFInAppEventType(r0)     // Catch:{ Exception -> 0x004a }
            goto L_0x0069
        L_0x002f:
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r4)     // Catch:{ Exception -> 0x004a }
            r0.reset()     // Catch:{ Exception -> 0x004a }
            byte[] r3 = r7.getBytes(r3)     // Catch:{ Exception -> 0x004a }
            r0.update(r3)     // Catch:{ Exception -> 0x004a }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x004a }
            java.lang.String r0 = AFInAppEventType(r0)     // Catch:{ Exception -> 0x004a }
            throw r5     // Catch:{ Exception -> 0x0048, all -> 0x0046 }
        L_0x0046:
            r7 = move-exception
            throw r7
        L_0x0048:
            r3 = move-exception
            goto L_0x004d
        L_0x004a:
            r0 = move-exception
            r3 = r0
            r0 = r5
        L_0x004d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Error turning "
            r4.<init>(r6)
            r6 = 6
            java.lang.String r7 = r7.substring(r1, r6)
            r4.append(r7)
            java.lang.String r7 = ".. to SHA1"
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            com.appsflyer.AFLogger.afErrorLog(r7, r3)
            r7 = r0
        L_0x0069:
            int r0 = AFInAppEventType
            int r0 = r0 + 45
            int r3 = r0 % 128
            AFKeystoreWrapper = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0076
            r1 = r2
        L_0x0076:
            if (r1 == r2) goto L_0x0079
            return r7
        L_0x0079:
            throw r5     // Catch:{ all -> 0x007a }
        L_0x007a:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1aSDK.valueOf(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r3 = r0;
        r0 = r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String values(java.lang.String r5) {
        /*
            int r0 = AFKeystoreWrapper
            int r0 = r0 + 63
            int r1 = r0 % 128
            AFInAppEventType = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L_0x000f
            r0 = 1
            goto L_0x0010
        L_0x000f:
            r0 = r1
        L_0x0010:
            java.lang.String r2 = "SHA-256"
            r3 = 0
            if (r0 != 0) goto L_0x002b
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0029 }
            byte[] r2 = r5.getBytes()     // Catch:{ Exception -> 0x0029 }
            r0.update(r2)     // Catch:{ Exception -> 0x0029 }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x0029 }
            java.lang.String r5 = AFInAppEventParameterName((byte[]) r0)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0060
        L_0x0029:
            r0 = move-exception
            goto L_0x0044
        L_0x002b:
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0029 }
            byte[] r2 = r5.getBytes()     // Catch:{ Exception -> 0x0029 }
            r0.update(r2)     // Catch:{ Exception -> 0x0029 }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x0029 }
            java.lang.String r0 = AFInAppEventParameterName((byte[]) r0)     // Catch:{ Exception -> 0x0029 }
            throw r3     // Catch:{ Exception -> 0x0041, all -> 0x003f }
        L_0x003f:
            r5 = move-exception
            throw r5
        L_0x0041:
            r2 = move-exception
            r3 = r0
            r0 = r2
        L_0x0044:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Error turning "
            r2.<init>(r4)
            r4 = 6
            java.lang.String r5 = r5.substring(r1, r4)
            r2.append(r5)
            java.lang.String r5 = ".. to SHA-256"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            com.appsflyer.AFLogger.afErrorLog(r5, r0)
            r5 = r3
        L_0x0060:
            int r0 = AFInAppEventType
            int r0 = r0 + 105
            int r1 = r0 % 128
            AFKeystoreWrapper = r1
            int r0 = r0 % 2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1aSDK.values(java.lang.String):java.lang.String");
    }

    public static String values(String str, String str2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            String lowerCase = AFInAppEventParameterName(instance.doFinal(str.getBytes())).toLowerCase();
            int i10 = AFInAppEventType + 51;
            AFKeystoreWrapper = i10 % 128;
            if ((i10 % 2 == 0 ? 'a' : '2') == '2') {
                return lowerCase;
            }
            throw null;
        } catch (InvalidKeyException | NoSuchAlgorithmException e10) {
            AFLogger.afErrorLog(e10.getMessage(), e10, true);
            return e10.getMessage();
        }
    }

    private static String AFInAppEventParameterName(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        int length = bArr.length;
        int i10 = AFKeystoreWrapper + 41;
        AFInAppEventType = i10 % 128;
        int i11 = i10 % 2;
        int i12 = 0;
        while (true) {
            if (!(i12 >= length)) {
                sb2.append(Integer.toString((bArr[i12] & 255) + 256, 16).substring(1));
                i12++;
            } else {
                String obj = sb2.toString();
                int i13 = AFKeystoreWrapper + 59;
                AFInAppEventType = i13 % 128;
                int i14 = i13 % 2;
                return obj;
            }
        }
    }

    public static String valueOf(Map<String, Object> map) {
        Object[] objArr = new Object[1];
        AFKeystoreWrapper("\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000", false, new int[]{0, 12, Opcodes.FRETURN, 6}, objArr);
        String str = (String) map.get(((String) objArr[0]).intern());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((String) map.get("appsflyerKey")).substring(0, 7));
        sb2.append(((String) map.get("uid")).substring(0, 7));
        sb2.append(str.substring(str.length() - 7));
        String valueOf = valueOf(sb2.toString());
        int i10 = AFInAppEventType + 71;
        AFKeystoreWrapper = i10 % 128;
        if ((i10 % 2 == 0 ? 'L' : 14) != 'L') {
            return valueOf;
        }
        throw null;
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
            char[] r8 = values     // Catch:{ all -> 0x008b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1aSDK.AFKeystoreWrapper(java.lang.String, boolean, int[], java.lang.Object[]):void");
    }

    public static String values(Map<String, Object> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((String) map.get("appsflyerKey"));
        Object[] objArr = new Object[1];
        boolean z10 = false;
        AFKeystoreWrapper("\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000", false, new int[]{0, 12, Opcodes.FRETURN, 6}, objArr);
        sb2.append(map.get(((String) objArr[0]).intern()));
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append(map.get("uid"));
        String obj2 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(obj2);
        sb4.append(map.get(Constants.Params.INSTALL_DATE));
        String obj3 = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(obj3);
        sb5.append(map.get("counter"));
        String obj4 = sb5.toString();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(obj4);
        sb6.append(map.get("iaecounter"));
        String valueOf = valueOf(AFInAppEventParameterName(sb6.toString()));
        int i10 = AFKeystoreWrapper + 13;
        AFInAppEventType = i10 % 128;
        if (i10 % 2 == 0) {
            z10 = true;
        }
        if (z10) {
            return valueOf;
        }
        throw null;
    }

    public static String values(String... strArr) {
        int i10 = AFKeystoreWrapper + 61;
        AFInAppEventType = i10 % 128;
        if ((i10 % 2 != 0 ? 'O' : '&') == '&') {
            return TextUtils.join("⁣", strArr);
        }
        TextUtils.join("⁣", strArr);
        throw null;
    }
}
