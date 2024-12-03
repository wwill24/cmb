package com.mparticle;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.internal.h;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.b;

public class n0 extends o0 {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f22608a = {Integer.toString(3)};

    public static int a(w wVar, String str) {
        return wVar.a("sessions", "session_id!=? ", new String[]{str});
    }

    public static void b(w wVar, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("cfuuid", str2);
        wVar.a("sessions", contentValues, "session_id=?", new String[]{str});
    }

    public static Cursor c(w wVar, String str) throws JSONException {
        return wVar.a("sessions", new String[]{"start_time", SDKConstants.PARAM_TOURNAMENTS_END_TIME, "session_length", "attributes"}, "session_id=? and cfuuid IS NULL", new String[]{str}, (String) null, (String) null, (String) null);
    }

    public static int a(w wVar, Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (String str : set) {
            arrayList.add("'" + str + "'");
        }
        String join = TextUtils.join(AppsFlyerKit.COMMA, arrayList.toArray());
        return wVar.a("sessions", "session_id NOT IN (" + join + ")", (String[]) null);
    }

    public static List<String> b(w wVar, String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            Cursor a10 = wVar.a("sessions", new String[]{SDKAnalyticsEvents.PARAMETER_SESSION_ID}, "api_key= ? and cfuuid IS NULL", strArr, (String) null, (String) null, (String) null);
            while (a10.moveToNext()) {
                arrayList.add(a10.getString(0));
            }
            if (!a10.isClosed()) {
                a10.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th2;
        }
    }

    public static Cursor a(w wVar) {
        return wVar.a("sessions", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    public static void a(w wVar, String str, long j10, long j11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SDKConstants.PARAM_TOURNAMENTS_END_TIME, Long.valueOf(j10));
        if (j11 > 0) {
            contentValues.put("session_length", Long.valueOf(j11));
        }
        wVar.a("sessions", contentValues, "session_id=?", new String[]{str});
    }

    public static void a(w wVar, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("attributes", str2);
        wVar.a("sessions", contentValues, "session_id=?", new String[]{str});
    }

    public static void a(w wVar, c cVar, String str, String str2, String str3, long j10) throws JSONException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mp_id", Long.valueOf(j10));
        contentValues.put("api_key", str);
        contentValues.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, cVar.d());
        contentValues.put("start_time", Long.valueOf(cVar.getLong("ct")));
        contentValues.put(SDKConstants.PARAM_TOURNAMENTS_END_TIME, Long.valueOf(cVar.getLong("ct")));
        contentValues.put("session_length", 0);
        contentValues.put("app_info", str2);
        contentValues.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, str3);
        wVar.a("sessions", (String) null, contentValues);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000d */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0013 A[Catch:{ all -> 0x0067 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<org.json.b> a(com.mparticle.w r5, java.util.HashMap<com.mparticle.e, com.mparticle.internal.h> r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Map r6 = a((java.util.Map<com.mparticle.e, com.mparticle.internal.h>) r6)
            android.database.Cursor r5 = a((com.mparticle.w) r5)     // Catch:{ all -> 0x0069 }
        L_0x000d:
            boolean r1 = r5.moveToNext()     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = "session_id"
            int r1 = r5.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = r5.getString(r1)     // Catch:{ all -> 0x0067 }
            java.lang.Object r1 = r6.get(r1)     // Catch:{ all -> 0x0067 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x000d
            java.lang.String r2 = "app_info"
            int r2 = r5.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x000d }
            java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x000d }
            org.json.b r3 = new org.json.b     // Catch:{ Exception -> 0x000d }
            r3.<init>((java.lang.String) r2)     // Catch:{ Exception -> 0x000d }
            java.lang.String r2 = "device_info"
            int r2 = r5.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x000d }
            java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x000d }
            org.json.b r4 = new org.json.b     // Catch:{ Exception -> 0x000d }
            r4.<init>((java.lang.String) r2)     // Catch:{ Exception -> 0x000d }
            r0.add(r4)     // Catch:{ Exception -> 0x000d }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x000d }
        L_0x004a:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x000d }
            if (r2 == 0) goto L_0x000d
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x000d }
            com.mparticle.internal.h r2 = (com.mparticle.internal.h) r2     // Catch:{ Exception -> 0x000d }
            r2.d(r3)     // Catch:{ Exception -> 0x000d }
            r2.e(r4)     // Catch:{ Exception -> 0x000d }
            goto L_0x004a
        L_0x005d:
            boolean r6 = r5.isClosed()
            if (r6 != 0) goto L_0x0066
            r5.close()
        L_0x0066:
            return r0
        L_0x0067:
            r6 = move-exception
            goto L_0x006b
        L_0x0069:
            r6 = move-exception
            r5 = 0
        L_0x006b:
            if (r5 == 0) goto L_0x0076
            boolean r0 = r5.isClosed()
            if (r0 != 0) goto L_0x0076
            r5.close()
        L_0x0076:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.n0.a(com.mparticle.w, java.util.HashMap):java.util.List");
    }

    public static void a(w wVar, b bVar, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_info", bVar.toString());
        wVar.a("sessions", contentValues, "session_id=?", new String[]{str});
    }

    static Map<String, List<h>> a(Map<e, h> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String e10 = ((e) next.getKey()).e();
            List list = (List) hashMap.get(e10);
            if (list == null) {
                list = new ArrayList();
                hashMap.put(e10, list);
            }
            list.add((h) next.getValue());
        }
        return hashMap;
    }
}
