package com.mparticle;

import android.content.ContentValues;

public class t0 extends u0 {
    public static void a(w wVar, String str, String str2, long j10, boolean z10, long j11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mp_id", Long.valueOf(j11));
        contentValues.put("attribute_key", str);
        contentValues.put("attribute_value", str2);
        contentValues.put("is_list", Boolean.valueOf(z10));
        contentValues.put("created_time", Long.valueOf(j10));
        wVar.a("attributes", (String) null, contentValues);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        if (r4.isClosed() == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0047, code lost:
        if (r4.isClosed() == false) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.TreeMap<java.lang.String, java.lang.String> b(com.mparticle.w r13, long r14) {
        /*
            java.util.TreeMap r0 = new java.util.TreeMap
            java.util.Comparator r1 = java.lang.String.CASE_INSENSITIVE_ORDER
            r0.<init>(r1)
            r1 = 1
            r2 = 0
            r3 = 2
            r4 = 0
            java.lang.String[] r9 = new java.lang.String[r3]     // Catch:{ Exception -> 0x004c }
            java.lang.String r5 = "1"
            r9[r2] = r5     // Catch:{ Exception -> 0x004c }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x004c }
            r9[r1] = r14     // Catch:{ Exception -> 0x004c }
            java.lang.String r6 = "attributes"
            r7 = 0
            java.lang.String r8 = "is_list != ? and mp_id = ?"
            r10 = 0
            r11 = 0
            java.lang.String r12 = "attribute_key, created_time desc"
            r5 = r13
            android.database.Cursor r4 = r5.a(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x004c }
            java.lang.String r13 = "attribute_key"
            int r13 = r4.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x004c }
            java.lang.String r14 = "attribute_value"
            int r14 = r4.getColumnIndexOrThrow(r14)     // Catch:{ Exception -> 0x004c }
        L_0x0031:
            boolean r15 = r4.moveToNext()     // Catch:{ Exception -> 0x004c }
            if (r15 == 0) goto L_0x0043
            java.lang.String r15 = r4.getString(r13)     // Catch:{ Exception -> 0x004c }
            java.lang.String r5 = r4.getString(r14)     // Catch:{ Exception -> 0x004c }
            r0.put(r15, r5)     // Catch:{ Exception -> 0x004c }
            goto L_0x0031
        L_0x0043:
            boolean r13 = r4.isClosed()
            if (r13 != 0) goto L_0x0067
            goto L_0x0064
        L_0x004a:
            r13 = move-exception
            goto L_0x0068
        L_0x004c:
            r13 = move-exception
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ all -> 0x004a }
            java.lang.String r15 = "Error while querying user attributes: "
            r14[r2] = r15     // Catch:{ all -> 0x004a }
            java.lang.String r15 = r13.toString()     // Catch:{ all -> 0x004a }
            r14[r1] = r15     // Catch:{ all -> 0x004a }
            com.mparticle.internal.Logger.error(r13, r14)     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x0067
            boolean r13 = r4.isClosed()
            if (r13 != 0) goto L_0x0067
        L_0x0064:
            r4.close()
        L_0x0067:
            return r0
        L_0x0068:
            if (r4 == 0) goto L_0x0073
            boolean r14 = r4.isClosed()
            if (r14 != 0) goto L_0x0073
            r4.close()
        L_0x0073:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.t0.b(com.mparticle.w, long):java.util.TreeMap");
    }

    public static int a(w wVar, String str, long j10) {
        return wVar.a("attributes", "attribute_key = ? and mp_id = ?", new String[]{str, String.valueOf(j10)});
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: android.database.Cursor} */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (r13.isClosed() == false) goto L_0x0080;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.TreeMap<java.lang.String, java.util.List<java.lang.String>> a(com.mparticle.w r13, long r14) {
        /*
            java.util.TreeMap r0 = new java.util.TreeMap
            java.util.Comparator r1 = java.lang.String.CASE_INSENSITIVE_ORDER
            r0.<init>(r1)
            r1 = 1
            r2 = 0
            r3 = 2
            r4 = 0
            java.lang.String[] r9 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0067 }
            java.lang.String r5 = "1"
            r9[r2] = r5     // Catch:{ Exception -> 0x0067 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0067 }
            r9[r1] = r14     // Catch:{ Exception -> 0x0067 }
            java.lang.String r6 = "attributes"
            r7 = 0
            java.lang.String r8 = "is_list = ? and mp_id = ?"
            r10 = 0
            r11 = 0
            java.lang.String r12 = "attribute_key, created_time desc"
            r5 = r13
            android.database.Cursor r13 = r5.a(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r14 = "attribute_key"
            int r14 = r13.getColumnIndexOrThrow(r14)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            java.lang.String r15 = "attribute_value"
            int r15 = r13.getColumnIndexOrThrow(r15)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
        L_0x0031:
            boolean r5 = r13.moveToNext()     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            if (r5 == 0) goto L_0x0058
            java.lang.String r5 = r13.getString(r14)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            boolean r6 = r5.equals(r4)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            if (r6 != 0) goto L_0x004a
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r4.<init>()     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r0.put(r5, r4)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r4 = r5
        L_0x004a:
            java.lang.Object r5 = r0.get(r5)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            java.lang.String r6 = r13.getString(r15)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            r5.add(r6)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            goto L_0x0031
        L_0x0058:
            boolean r14 = r13.isClosed()
            if (r14 != 0) goto L_0x0083
            goto L_0x0080
        L_0x005f:
            r14 = move-exception
            r4 = r13
            goto L_0x0084
        L_0x0062:
            r14 = move-exception
            r4 = r13
            goto L_0x0068
        L_0x0065:
            r14 = move-exception
            goto L_0x0084
        L_0x0067:
            r14 = move-exception
        L_0x0068:
            java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ all -> 0x0065 }
            java.lang.String r15 = "Error while querying user attribute lists: "
            r13[r2] = r15     // Catch:{ all -> 0x0065 }
            java.lang.String r15 = r14.toString()     // Catch:{ all -> 0x0065 }
            r13[r1] = r15     // Catch:{ all -> 0x0065 }
            com.mparticle.internal.Logger.error(r14, r13)     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x0083
            boolean r13 = r4.isClosed()
            if (r13 != 0) goto L_0x0083
            r13 = r4
        L_0x0080:
            r13.close()
        L_0x0083:
            return r0
        L_0x0084:
            if (r4 == 0) goto L_0x008f
            boolean r13 = r4.isClosed()
            if (r13 != 0) goto L_0x008f
            r4.close()
        L_0x008f:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.t0.a(com.mparticle.w, long):java.util.TreeMap");
    }
}
