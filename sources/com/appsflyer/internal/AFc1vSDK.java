package com.appsflyer.internal;

import android.util.Base64;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import kotlin.text.d;
import org.json.a;

public interface AFc1vSDK {
    void values(byte[] bArr, Map<String, String> map, int i10);

    public static final class AFa1wSDK {
        public final String AFInAppEventType;
        public final Boolean valueOf;
        public Boolean values;

        public AFa1wSDK() {
        }

        public AFa1wSDK(String str, Boolean bool) {
            this.AFInAppEventType = str;
            this.valueOf = bool;
        }

        public static String AFInAppEventType(String str) {
            j.g(str, "");
            byte[] bytes = str.getBytes(d.f32216b);
            j.f(bytes, "");
            String encodeToString = Base64.encodeToString(bytes, 2);
            j.f(encodeToString, "");
            return encodeToString;
        }

        public static String AFKeystoreWrapper(String str) {
            j.g(str, "");
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes(d.f32216b);
            j.f(bytes, "");
            byte[] digest = instance.digest(bytes);
            j.f(digest, "");
            String str2 = "";
            for (byte valueOf2 : digest) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                String format2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf2)}, 1));
                j.f(format2, "");
                sb2.append(format2);
                str2 = sb2.toString();
            }
            return str2;
        }

        public static a valueOf(List<AFb1aSDK> list) {
            j.g(list, "");
            ArrayList arrayList = new ArrayList(r.t(list, 10));
            for (AFb1aSDK AFKeystoreWrapper : list) {
                arrayList.add(AFKeystoreWrapper.AFKeystoreWrapper());
            }
            return new a((Collection<?>) arrayList);
        }

        public static boolean valueOf(HttpURLConnection httpURLConnection) {
            j.g(httpURLConnection, "");
            return httpURLConnection.getResponseCode() / 100 == 2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
            r0 = kotlin.text.q.j((r0 = r0.a()));
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int valueOf(java.lang.String r4) {
            /*
                java.lang.String r0 = ""
                kotlin.jvm.internal.j.g(r4, r0)
                kotlin.text.Regex r0 = new kotlin.text.Regex
                java.lang.String r1 = "(\\d+).?(\\d+)?.?(\\d+)?(-rc\\d+)?(_.*)?"
                r0.<init>((java.lang.String) r1)
                kotlin.text.MatchResult r4 = r0.d(r4)
                if (r4 == 0) goto L_0x0071
                kotlin.text.g r0 = r4.b()
                r1 = 1
                kotlin.text.MatchGroup r0 = r0.get(r1)
                r1 = 0
                if (r0 == 0) goto L_0x002f
                java.lang.String r0 = r0.a()
                if (r0 == 0) goto L_0x002f
                java.lang.Integer r0 = kotlin.text.q.j(r0)
                if (r0 == 0) goto L_0x002f
                int r0 = r0.intValue()
                goto L_0x0030
            L_0x002f:
                r0 = r1
            L_0x0030:
                r2 = 1000000(0xf4240, float:1.401298E-39)
                int r0 = r0 * r2
                kotlin.text.g r2 = r4.b()
                r3 = 2
                kotlin.text.MatchGroup r2 = r2.get(r3)
                if (r2 == 0) goto L_0x0050
                java.lang.String r2 = r2.a()
                if (r2 == 0) goto L_0x0050
                java.lang.Integer r2 = kotlin.text.q.j(r2)
                if (r2 == 0) goto L_0x0050
                int r2 = r2.intValue()
                goto L_0x0051
            L_0x0050:
                r2 = r1
            L_0x0051:
                int r2 = r2 * 1000
                int r0 = r0 + r2
                kotlin.text.g r4 = r4.b()
                r2 = 3
                kotlin.text.MatchGroup r4 = r4.get(r2)
                if (r4 == 0) goto L_0x006f
                java.lang.String r4 = r4.a()
                if (r4 == 0) goto L_0x006f
                java.lang.Integer r4 = kotlin.text.q.j(r4)
                if (r4 == 0) goto L_0x006f
                int r1 = r4.intValue()
            L_0x006f:
                int r0 = r0 + r1
                return r0
            L_0x0071:
                r4 = -1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1vSDK.AFa1wSDK.valueOf(java.lang.String):int");
        }
    }
}
