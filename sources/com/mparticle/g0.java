package com.mparticle;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.leanplum.internal.Constants;
import com.mparticle.internal.Logger;
import com.mparticle.internal.listeners.InternalListenerManager;
import com.mparticle.kits.ReportingMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;

public class g0 extends h0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f22311a = {"_id", "message", "message_time", "upload_status", SDKAnalyticsEvents.PARAMETER_SESSION_ID, "mp_id", "dataplan_id", "dataplan_version"};

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private long f22312a;

        /* renamed from: b  reason: collision with root package name */
        private String f22313b;

        /* renamed from: c  reason: collision with root package name */
        private int f22314c;

        /* renamed from: d  reason: collision with root package name */
        private String f22315d;

        /* renamed from: e  reason: collision with root package name */
        private String f22316e;

        /* renamed from: f  reason: collision with root package name */
        private Integer f22317f;

        public String a() {
            return this.f22316e;
        }

        public Integer b() {
            return this.f22317f;
        }

        public String c() {
            return this.f22315d;
        }

        public int d() {
            return this.f22314c;
        }

        public long e() {
            return this.f22312a;
        }

        public String f() {
            return this.f22313b;
        }

        private b(long j10, String str, int i10, String str2, String str3, Integer num) {
            this.f22312a = j10;
            this.f22313b = str;
            this.f22314c = i10;
            this.f22315d = str2;
            this.f22316e = str3;
            this.f22317f = num;
        }
    }

    private static String a(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(%s = %d) and (%s != ?) and (%s ");
        sb2.append(z10 ? " = ?" : "!= ?");
        sb2.append(")");
        return String.format(sb2.toString(), new Object[]{"upload_status", 3, SDKAnalyticsEvents.PARAMETER_SESSION_ID, "mp_id"});
    }

    public static List<b> b(w wVar, String str) {
        return a(wVar, str, false, h.f22319b.longValue());
    }

    public static Set<String> c(w wVar) {
        HashSet hashSet = new HashSet();
        Cursor cursor = null;
        try {
            Cursor a10 = wVar.a("SELECT DISTINCT session_id FROM messages", new String[0]);
            while (a10.moveToNext()) {
                hashSet.add(a10.getString(0));
            }
            if (!a10.isClosed()) {
                a10.close();
            }
            return hashSet;
        } catch (Throwable th2) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th2;
        }
    }

    public static boolean d(w wVar) {
        Cursor cursor = null;
        try {
            boolean z10 = false;
            Cursor a10 = wVar.a(Constants.Keys.MESSAGES, new String[]{"_id"}, "upload_status != ? and message_time < " + System.currentTimeMillis() + " and " + "mp_id" + " != ?", new String[]{Integer.toString(3), String.valueOf(h.f22319b)}, (String) null, (String) null, "_id asc");
            if (a10.getCount() > 0) {
                z10 = true;
            }
            if (!a10.isClosed()) {
                a10.close();
            }
            return z10;
        } catch (Throwable th2) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th2;
        }
    }

    public static List<b> b(w wVar) {
        return a(wVar, false, h.f22319b.longValue());
    }

    public static int b(w wVar, int i10) {
        String[] strArr = {Integer.toString(i10), String.valueOf(h.f22319b)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("upload_status", 3);
        return wVar.a(Constants.Keys.MESSAGES, contentValues, "_id <= ? and mp_id != ? ", strArr);
    }

    static List<b> a(w wVar, String str, boolean z10, long j10) {
        String[] strArr = {str, String.valueOf(j10)};
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a10 = wVar.a(Constants.Keys.MESSAGES, f22311a, a(z10), strArr, (String) null, (String) null, "_id asc", String.valueOf(h.a()));
            try {
                int columnIndexOrThrow = a10.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = a10.getColumnIndexOrThrow("message");
                int columnIndexOrThrow3 = a10.getColumnIndexOrThrow(SDKAnalyticsEvents.PARAMETER_SESSION_ID);
                int columnIndexOrThrow4 = a10.getColumnIndexOrThrow("mp_id");
                int columnIndexOrThrow5 = a10.getColumnIndexOrThrow("dataplan_id");
                int columnIndexOrThrow6 = a10.getColumnIndexOrThrow("dataplan_version");
                while (a10.moveToNext()) {
                    b bVar = new b(a10.getLong(columnIndexOrThrow4), a10.getString(columnIndexOrThrow3), a10.getInt(columnIndexOrThrow), a10.getString(columnIndexOrThrow2), a10.getString(columnIndexOrThrow5), !a10.isNull(columnIndexOrThrow6) ? Integer.valueOf(a10.getInt(columnIndexOrThrow6)) : null);
                    InternalListenerManager.getListener().onCompositeObjects(a10, bVar);
                    arrayList.add(bVar);
                }
                if (!a10.isClosed()) {
                    a10.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursor = a10;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor.close();
            throw th;
        }
    }

    public static int a(w wVar, String str) {
        return wVar.a(Constants.Keys.MESSAGES, a(false), new String[]{str, String.valueOf(h.f22319b)});
    }

    static List<b> a(w wVar, boolean z10, long j10) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("upload_status != ? and message_time < ");
            sb2.append(System.currentTimeMillis());
            sb2.append(" and ");
            sb2.append("mp_id");
            sb2.append(z10 ? " = ?" : " != ?");
            Cursor a10 = wVar.a(Constants.Keys.MESSAGES, (String[]) null, sb2.toString(), new String[]{Integer.toString(3), String.valueOf(j10)}, (String) null, (String) null, "_id asc", String.valueOf(h.a()));
            try {
                int columnIndexOrThrow = a10.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = a10.getColumnIndexOrThrow("message");
                int columnIndexOrThrow3 = a10.getColumnIndexOrThrow(SDKAnalyticsEvents.PARAMETER_SESSION_ID);
                int columnIndexOrThrow4 = a10.getColumnIndexOrThrow("mp_id");
                int columnIndexOrThrow5 = a10.getColumnIndexOrThrow("dataplan_id");
                int columnIndexOrThrow6 = a10.getColumnIndexOrThrow("dataplan_version");
                while (a10.moveToNext()) {
                    b bVar = new b(a10.getLong(columnIndexOrThrow4), a10.getString(columnIndexOrThrow3), a10.getInt(columnIndexOrThrow), a10.getString(columnIndexOrThrow2), a10.getString(columnIndexOrThrow5), !a10.isNull(columnIndexOrThrow6) ? Integer.valueOf(a10.getInt(columnIndexOrThrow6)) : null);
                    InternalListenerManager.getListener().onCompositeObjects(a10, bVar);
                    arrayList.add(bVar);
                }
                if (!a10.isClosed()) {
                    a10.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursor = a10;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor.close();
            throw th;
        }
    }

    public static int a(w wVar) {
        return wVar.a(Constants.Keys.MESSAGES, "length(message) > 102400", (String[]) null);
    }

    public static int a(w wVar, int i10) {
        return wVar.a(Constants.Keys.MESSAGES, "_id <= ? and mp_id != ?", new String[]{Integer.toString(i10), String.valueOf(h.f22319b)});
    }

    public static void a(w wVar, String str, c cVar, long j10, String str2, Integer num) throws JSONException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("api_key", str);
        contentValues.put("message_time", Long.valueOf(cVar.getLong("ct")));
        String d10 = cVar.d();
        contentValues.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, d10);
        contentValues.put("mp_id", Long.valueOf(j10));
        contentValues.put("dataplan_id", str2);
        contentValues.put("dataplan_version", num);
        if ("NO-SESSION".equals(d10)) {
            cVar.remove("sid");
        }
        String obj = cVar.toString();
        if (obj.length() > 102400) {
            Logger.error("Message logged of size " + obj.length() + " that exceeds maximum safe size of " + 102400 + " bytes.");
            return;
        }
        contentValues.put("message", obj);
        if (ReportingMessage.MessageType.FIRST_RUN.equals(cVar.getString("dt"))) {
            contentValues.put("upload_status", 2);
        } else {
            contentValues.put("upload_status", 1);
        }
        InternalListenerManager.getListener().onCompositeObjects(cVar, contentValues);
        wVar.a(Constants.Keys.MESSAGES, (String) null, contentValues);
    }
}
