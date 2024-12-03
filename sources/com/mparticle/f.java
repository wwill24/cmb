package com.mparticle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.mparticle.internal.b;
import org.json.JSONException;

public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f22309a = {"_id"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f22310b = {"breadcrumb_time", "message"};

    public static int a(w wVar, Context context, c cVar, String str, Long l10) throws JSONException {
        if (cVar == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("mp_id", l10);
        contentValues.put("api_key", str);
        contentValues.put("breadcrumb_time", Long.valueOf(cVar.getLong("ct")));
        contentValues.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, cVar.d());
        contentValues.put("message", cVar.toString());
        wVar.a("breadcrumbs", (String) null, contentValues);
        Cursor a10 = wVar.a("breadcrumbs", f22309a, "mp_id = ?", new String[]{String.valueOf(l10)}, (String) null, (String) null, " _id asc");
        if (a10.moveToFirst()) {
            int i10 = a10.getInt(0);
            if (a10.getCount() > b.b(context, l10.longValue())) {
                return wVar.a("breadcrumbs", " _id = ?", new String[]{String.valueOf(i10)});
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
        if (r2.isClosed() == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008b, code lost:
        if (r2.isClosed() == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008d, code lost:
        r2.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.a a(com.mparticle.w r12, android.content.Context r13, java.lang.Long r14) throws org.json.JSONException {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.String r4 = "breadcrumbs"
            java.lang.String[] r5 = f22310b     // Catch:{ Exception -> 0x0068 }
            java.lang.String r6 = "mp_id = ? "
            java.lang.String[] r7 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0068 }
            java.lang.String r3 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0068 }
            r7[r0] = r3     // Catch:{ Exception -> 0x0068 }
            r8 = 0
            r9 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0068 }
            r3.<init>()     // Catch:{ Exception -> 0x0068 }
            java.lang.String r10 = "breadcrumb_time desc limit "
            r3.append(r10)     // Catch:{ Exception -> 0x0068 }
            long r10 = r14.longValue()     // Catch:{ Exception -> 0x0068 }
            int r13 = com.mparticle.internal.b.b((android.content.Context) r13, (long) r10)     // Catch:{ Exception -> 0x0068 }
            r3.append(r13)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r10 = r3.toString()     // Catch:{ Exception -> 0x0068 }
            r3 = r12
            android.database.Cursor r2 = r3.a(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0068 }
            int r12 = r2.getCount()     // Catch:{ Exception -> 0x0068 }
            if (r12 <= 0) goto L_0x005f
            org.json.a r12 = new org.json.a     // Catch:{ Exception -> 0x0068 }
            r12.<init>()     // Catch:{ Exception -> 0x0068 }
            java.lang.String r13 = "message"
            int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x0068 }
        L_0x0042:
            boolean r14 = r2.moveToNext()     // Catch:{ Exception -> 0x0068 }
            if (r14 == 0) goto L_0x0055
            org.json.b r14 = new org.json.b     // Catch:{ Exception -> 0x0068 }
            java.lang.String r3 = r2.getString(r13)     // Catch:{ Exception -> 0x0068 }
            r14.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x0068 }
            r12.E(r14)     // Catch:{ Exception -> 0x0068 }
            goto L_0x0042
        L_0x0055:
            boolean r13 = r2.isClosed()
            if (r13 != 0) goto L_0x005e
            r2.close()
        L_0x005e:
            return r12
        L_0x005f:
            boolean r12 = r2.isClosed()
            if (r12 != 0) goto L_0x0090
            goto L_0x008d
        L_0x0066:
            r12 = move-exception
            goto L_0x0096
        L_0x0068:
            r12 = move-exception
            java.lang.String[] r13 = new java.lang.String[r1]     // Catch:{ all -> 0x0066 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
            r14.<init>()     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Error while appending breadcrumbs: "
            r14.append(r1)     // Catch:{ all -> 0x0066 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0066 }
            r14.append(r12)     // Catch:{ all -> 0x0066 }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x0066 }
            r13[r0] = r12     // Catch:{ all -> 0x0066 }
            com.mparticle.internal.Logger.debug(r13)     // Catch:{ all -> 0x0066 }
            if (r2 == 0) goto L_0x0090
            boolean r12 = r2.isClosed()
            if (r12 != 0) goto L_0x0090
        L_0x008d:
            r2.close()
        L_0x0090:
            org.json.a r12 = new org.json.a
            r12.<init>()
            return r12
        L_0x0096:
            if (r2 == 0) goto L_0x00a1
            boolean r13 = r2.isClosed()
            if (r13 != 0) goto L_0x00a1
            r2.close()
        L_0x00a1:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.f.a(com.mparticle.w, android.content.Context, java.lang.Long):org.json.a");
    }
}
