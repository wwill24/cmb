package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public class m {

    /* renamed from: b  reason: collision with root package name */
    private static final h f39018b = new h("LibraryVersion", "");

    /* renamed from: c  reason: collision with root package name */
    private static m f39019c = new m();

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap f39020a = new ConcurrentHashMap();

    protected m() {
    }

    @NonNull
    public static m a() {
        return f39019c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa  */
    @androidx.annotation.NonNull
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(@androidx.annotation.NonNull java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Failed to get app version for libraryName: "
            java.lang.String r1 = "LibraryVersion"
            java.lang.String r2 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.p.h(r9, r2)
            java.util.concurrent.ConcurrentHashMap r2 = r8.f39020a
            boolean r2 = r2.containsKey(r9)
            if (r2 == 0) goto L_0x001a
            java.util.concurrent.ConcurrentHashMap r0 = r8.f39020a
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L_0x001a:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            r3 = 1
            r4 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x007b }
            r5 = 0
            r3[r5] = r9     // Catch:{ IOException -> 0x007b }
            java.lang.Class<com.google.android.gms.common.internal.m> r5 = com.google.android.gms.common.internal.m.class
            java.lang.String r6 = "/%s.properties"
            java.lang.String r3 = java.lang.String.format(r6, r3)     // Catch:{ IOException -> 0x007b }
            java.io.InputStream r3 = r5.getResourceAsStream(r3)     // Catch:{ IOException -> 0x007b }
            if (r3 == 0) goto L_0x0057
            r2.load(r3)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.String r5 = "version"
            java.lang.String r4 = r2.getProperty(r5, r4)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            com.google.android.gms.common.internal.h r2 = f39018b     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.<init>()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.append(r9)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.String r6 = " version is "
            r5.append(r6)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.append(r4)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r2.e(r1, r5)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            goto L_0x006b
        L_0x0057:
            com.google.android.gms.common.internal.h r2 = f39018b     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.<init>()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.append(r0)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r5.append(r9)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r2.f(r1, r5)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
        L_0x006b:
            if (r3 == 0) goto L_0x0097
            me.m.a(r3)
            goto L_0x0097
        L_0x0071:
            r9 = move-exception
            r4 = r3
            goto L_0x00a8
        L_0x0074:
            r2 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x007d
        L_0x0079:
            r9 = move-exception
            goto L_0x00a8
        L_0x007b:
            r2 = move-exception
            r3 = r4
        L_0x007d:
            com.google.android.gms.common.internal.h r5 = f39018b     // Catch:{ all -> 0x0079 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r6.<init>()     // Catch:{ all -> 0x0079 }
            r6.append(r0)     // Catch:{ all -> 0x0079 }
            r6.append(r9)     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0079 }
            r5.d(r1, r0, r2)     // Catch:{ all -> 0x0079 }
            if (r4 == 0) goto L_0x0096
            me.m.a(r4)
        L_0x0096:
            r4 = r3
        L_0x0097:
            if (r4 != 0) goto L_0x00a2
            com.google.android.gms.common.internal.h r0 = f39018b
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r0.b(r1, r2)
            java.lang.String r4 = "UNKNOWN"
        L_0x00a2:
            java.util.concurrent.ConcurrentHashMap r0 = r8.f39020a
            r0.put(r9, r4)
            return r4
        L_0x00a8:
            if (r4 == 0) goto L_0x00ad
            me.m.a(r4)
        L_0x00ad:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.m.b(java.lang.String):java.lang.String");
    }
}
