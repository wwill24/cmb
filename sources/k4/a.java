package k4;

import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import com.clevertap.android.sdk.p;
import java.util.HashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, CleverTapDisplayUnit> f15659a = new HashMap<>();

    public synchronized void a() {
        this.f15659a.clear();
        p.b("DisplayUnit : ", "Cleared Display Units Cache");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0060, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.ArrayList<com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit> b(org.json.a r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.a()     // Catch:{ all -> 0x0087 }
            r0 = 0
            if (r7 == 0) goto L_0x007e
            int r1 = r7.o()     // Catch:{ all -> 0x0087 }
            if (r1 <= 0) goto L_0x007e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0087 }
            r1.<init>()     // Catch:{ all -> 0x0087 }
            r2 = 0
        L_0x0013:
            int r3 = r7.o()     // Catch:{ Exception -> 0x0061 }
            if (r2 >= r3) goto L_0x0058
            java.lang.Object r3 = r7.get(r2)     // Catch:{ Exception -> 0x0061 }
            org.json.b r3 = (org.json.b) r3     // Catch:{ Exception -> 0x0061 }
            com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit r3 = com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit.d(r3)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = r3.getError()     // Catch:{ Exception -> 0x0061 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0061 }
            if (r4 == 0) goto L_0x003a
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit> r4 = r6.f15659a     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = r3.c()     // Catch:{ Exception -> 0x0061 }
            r4.put(r5, r3)     // Catch:{ Exception -> 0x0061 }
            r1.add(r3)     // Catch:{ Exception -> 0x0061 }
            goto L_0x0055
        L_0x003a:
            java.lang.String r3 = "DisplayUnit : "
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061 }
            r4.<init>()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = "Failed to convert JsonArray item at index:"
            r4.append(r5)     // Catch:{ Exception -> 0x0061 }
            r4.append(r2)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = " to Display Unit"
            r4.append(r5)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0061 }
            com.clevertap.android.sdk.p.b(r3, r4)     // Catch:{ Exception -> 0x0061 }
        L_0x0055:
            int r2 = r2 + 1
            goto L_0x0013
        L_0x0058:
            boolean r7 = r1.isEmpty()     // Catch:{ all -> 0x0087 }
            if (r7 != 0) goto L_0x005f
            r0 = r1
        L_0x005f:
            monitor-exit(r6)
            return r0
        L_0x0061:
            r7 = move-exception
            java.lang.String r1 = "DisplayUnit : "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r2.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "Failed while parsing Display Unit:"
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x0087 }
            r2.append(r7)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x0087 }
            com.clevertap.android.sdk.p.b(r1, r7)     // Catch:{ all -> 0x0087 }
            monitor-exit(r6)
            return r0
        L_0x007e:
            java.lang.String r7 = "DisplayUnit : "
            java.lang.String r1 = "Null json array response can't parse Display Units "
            com.clevertap.android.sdk.p.b(r7, r1)     // Catch:{ all -> 0x0087 }
            monitor-exit(r6)
            return r0
        L_0x0087:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.a.b(org.json.a):java.util.ArrayList");
    }
}
