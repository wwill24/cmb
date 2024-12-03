package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public final class AFa1lSDK {
    final AFc1ySDK AFInAppEventType;

    public AFa1lSDK() {
    }

    public AFa1lSDK(AFc1ySDK aFc1ySDK) {
        this.AFInAppEventType = aFc1ySDK;
    }

    public static b AFInAppEventParameterName(Map<String, ?> map) {
        b bVar = new b();
        for (Map.Entry next : map.entrySet()) {
            try {
                bVar.put((String) next.getKey(), AFInAppEventParameterName(next.getValue()));
            } catch (JSONException unused) {
            }
        }
        return bVar;
    }

    public static Map<String, Object> AFInAppEventType(@NonNull b bVar) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = bVar.get(next);
            if (obj instanceof a) {
                obj = values((a) obj);
            } else if (obj instanceof b) {
                obj = AFInAppEventType((b) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033 A[SYNTHETIC, Splitter:B:18:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040 A[SYNTHETIC, Splitter:B:26:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.appsflyer.internal.AFc1rSDK valueOf(java.io.File r5) {
        /*
            java.lang.String r0 = "could not close load reader"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            long r3 = r5.length()     // Catch:{ Exception -> 0x0026 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x0026 }
            char[] r3 = new char[r3]     // Catch:{ Exception -> 0x0026 }
            r2.read(r3)     // Catch:{ Exception -> 0x0026 }
            com.appsflyer.internal.AFc1rSDK r4 = new com.appsflyer.internal.AFc1rSDK     // Catch:{ Exception -> 0x0026 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0026 }
            r4.values = r5     // Catch:{ Exception -> 0x0026 }
            r2.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r5 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
        L_0x0025:
            return r4
        L_0x0026:
            r5 = move-exception
            goto L_0x002c
        L_0x0028:
            r5 = move-exception
            goto L_0x003e
        L_0x002a:
            r5 = move-exception
            r2 = r1
        L_0x002c:
            java.lang.String r3 = "error while loading request from cache"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r3, r5)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x003b
            r2.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r5 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
        L_0x003b:
            return r1
        L_0x003c:
            r5 = move-exception
            r1 = r2
        L_0x003e:
            if (r1 == 0) goto L_0x0048
            r1.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r1 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r1)
        L_0x0048:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1lSDK.valueOf(java.io.File):com.appsflyer.internal.AFc1rSDK");
    }

    private static List<Object> values(a aVar) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            Object obj = aVar.get(i10);
            if (obj instanceof a) {
                obj = values((a) obj);
            } else if (obj instanceof b) {
                obj = AFInAppEventType((b) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    @NonNull
    public final List<AFc1rSDK> AFKeystoreWrapper() {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(this.AFInAppEventType.values.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            for (File file2 : listFiles) {
                StringBuilder sb2 = new StringBuilder("CACHE: Found cached request");
                sb2.append(file2.getName());
                AFLogger.afInfoLog(sb2.toString());
                arrayList.add(valueOf(file2));
            }
            return arrayList;
        } catch (Exception e10) {
            AFLogger.afErrorLog("CACHE: Could not get cached requests", e10);
        }
    }

    private static Object AFInAppEventParameterName(Object obj) {
        if (obj == null) {
            return b.NULL;
        }
        if ((obj instanceof a) || (obj instanceof b) || obj.equals(b.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                a aVar = new a();
                for (Object AFInAppEventParameterName : (Collection) obj) {
                    aVar.E(AFInAppEventParameterName(AFInAppEventParameterName));
                }
                return aVar;
            } else if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                a aVar2 = new a();
                for (int i10 = 0; i10 < length; i10++) {
                    aVar2.E(AFInAppEventParameterName(Array.get(obj, i10)));
                }
                return aVar2;
            } else if (obj instanceof Map) {
                return AFInAppEventParameterName((Map<String, ?>) (Map) obj);
            } else {
                return ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) ? obj : obj.toString();
            }
        } catch (Exception unused) {
            return b.NULL;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d5 A[SYNTHETIC, Splitter:B:32:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e2 A[SYNTHETIC, Splitter:B:40:0x00e2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String values(com.appsflyer.internal.AFc1rSDK r8) {
        /*
            r7 = this;
            java.lang.String r0 = "AFRequestCache"
            java.lang.String r1 = "could not close cache writer"
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            com.appsflyer.internal.AFc1ySDK r4 = r7.AFInAppEventType     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            android.content.Context r4 = r4.values     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            r3.<init>(r4, r0)     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            if (r4 != 0) goto L_0x001c
            r3.mkdir()     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            return r2
        L_0x001c:
            java.io.File[] r3 = r3.listFiles()     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            if (r3 == 0) goto L_0x002d
            int r3 = r3.length     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            r4 = 40
            if (r3 <= r4) goto L_0x002d
            java.lang.String r8 = "CACHE: reached cache limit, not caching request"
            com.appsflyer.AFLogger.afInfoLog(r8)     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            return r2
        L_0x002d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.lang.String r4 = "CACHE: caching request with URL: "
            r3.<init>(r4)     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.lang.String r4 = r8.AFKeystoreWrapper     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            r3.append(r4)     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.lang.String r3 = java.lang.Long.toString(r3)     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            com.appsflyer.internal.AFc1ySDK r6 = r7.AFInAppEventType     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            android.content.Context r6 = r6.values     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            r5.<init>(r6, r0)     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            r4.<init>(r5, r3)     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            r4.createNewFile()     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.lang.String r4 = r4.getPath()     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            r6 = 1
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00cc, all -> 0x00ca }
            java.lang.String r4 = "version="
            r0.write(r4)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r4 = r8.AFInAppEventType     // Catch:{ Exception -> 0x00c8 }
            r0.write(r4)     // Catch:{ Exception -> 0x00c8 }
            r4 = 10
            r0.write(r4)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r5 = "url="
            r0.write(r5)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r5 = r8.AFKeystoreWrapper     // Catch:{ Exception -> 0x00c8 }
            r0.write(r5)     // Catch:{ Exception -> 0x00c8 }
            r0.write(r4)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r5 = "data="
            r0.write(r5)     // Catch:{ Exception -> 0x00c8 }
            byte[] r5 = r8.AFInAppEventParameterName()     // Catch:{ Exception -> 0x00c8 }
            r6 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r5, r6)     // Catch:{ Exception -> 0x00c8 }
            r0.write(r5)     // Catch:{ Exception -> 0x00c8 }
            r0.write(r4)     // Catch:{ Exception -> 0x00c8 }
            com.appsflyer.internal.AFd1wSDK r8 = r8.valueOf     // Catch:{ Exception -> 0x00c8 }
            if (r8 == 0) goto L_0x00af
            java.lang.String r5 = "type="
            r0.write(r5)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r8 = r8.name()     // Catch:{ Exception -> 0x00c8 }
            r0.write(r8)     // Catch:{ Exception -> 0x00c8 }
            r0.write(r4)     // Catch:{ Exception -> 0x00c8 }
        L_0x00af:
            r0.flush()     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r8 = "CACHE: done, cacheKey: "
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r8 = r8.concat(r4)     // Catch:{ Exception -> 0x00c8 }
            com.appsflyer.AFLogger.afInfoLog(r8)     // Catch:{ Exception -> 0x00c8 }
            r0.close()     // Catch:{ IOException -> 0x00c3 }
            goto L_0x00c7
        L_0x00c3:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r8)
        L_0x00c7:
            return r3
        L_0x00c8:
            r8 = move-exception
            goto L_0x00ce
        L_0x00ca:
            r8 = move-exception
            goto L_0x00e0
        L_0x00cc:
            r8 = move-exception
            r0 = r2
        L_0x00ce:
            java.lang.String r3 = "CACHE: Could not cache request"
            com.appsflyer.AFLogger.afErrorLog(r3, r8)     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x00dd
            r0.close()     // Catch:{ IOException -> 0x00d9 }
            goto L_0x00dd
        L_0x00d9:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r8)
        L_0x00dd:
            return r2
        L_0x00de:
            r8 = move-exception
            r2 = r0
        L_0x00e0:
            if (r2 == 0) goto L_0x00ea
            r2.close()     // Catch:{ IOException -> 0x00e6 }
            goto L_0x00ea
        L_0x00e6:
            r0 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r0)
        L_0x00ea:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1lSDK.values(com.appsflyer.internal.AFc1rSDK):java.lang.String");
    }

    public final boolean AFInAppEventType(String str) {
        File file = new File(new File(this.AFInAppEventType.values.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb2 = new StringBuilder("CACHE: Deleting ");
        sb2.append(str);
        sb2.append(" from cache");
        AFLogger.afInfoLog(sb2.toString());
        if (!file.exists()) {
            return true;
        }
        try {
            return file.delete();
        } catch (Exception e10) {
            StringBuilder sb3 = new StringBuilder("CACHE: Could not delete ");
            sb3.append(str);
            sb3.append(" from cache");
            AFLogger.afErrorLog(sb3.toString(), e10);
            return false;
        }
    }

    static AFe1oSDK AFInAppEventParameterName(Context context) {
        if (context instanceof Activity) {
            return AFe1oSDK.activity;
        }
        if (context instanceof Application) {
            return AFe1oSDK.application;
        }
        return AFe1oSDK.other;
    }
}
