package com.mparticle;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.mparticle.internal.JsonReportingMessage;
import com.mparticle.internal.listeners.InternalListenerManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class k0 extends l0 {

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private long f22591a;

        /* renamed from: b  reason: collision with root package name */
        private org.json.b f22592b;

        /* renamed from: c  reason: collision with root package name */
        private String f22593c;

        /* renamed from: d  reason: collision with root package name */
        private int f22594d;

        public Long a() {
            return Long.valueOf(this.f22591a);
        }

        public org.json.b b() {
            return this.f22592b;
        }

        public int c() {
            return this.f22594d;
        }

        public String d() {
            return this.f22593c;
        }

        private b(org.json.b bVar, String str, int i10, long j10) {
            this.f22592b = bVar;
            this.f22593c = str;
            this.f22594d = i10;
            this.f22591a = j10;
        }
    }

    public static void a(w wVar, JsonReportingMessage jsonReportingMessage, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mp_id", Long.valueOf(j10));
        contentValues.put("report_time", Long.valueOf(jsonReportingMessage.getTimestamp()));
        contentValues.put("module_id", Integer.valueOf(jsonReportingMessage.getModuleId()));
        contentValues.put("message", jsonReportingMessage.toJson().toString());
        contentValues.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, jsonReportingMessage.getSessionId());
        wVar.a("reporting", (String) null, contentValues);
    }

    public static List<b> a(w wVar) throws JSONException {
        return a(wVar, false, h.f22319b.longValue());
    }

    static List<b> a(w wVar, boolean z10, long j10) throws JSONException {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("mp_id");
            sb2.append(z10 ? " = ?" : " != ?");
            Cursor a10 = wVar.a("reporting", (String[]) null, sb2.toString(), new String[]{String.valueOf(j10)}, (String) null, (String) null, "_id asc");
            int columnIndexOrThrow = a10.getColumnIndexOrThrow("_id");
            while (a10.moveToNext()) {
                b bVar = new b(new org.json.b(a10.getString(a10.getColumnIndexOrThrow("message"))), a10.getString(a10.getColumnIndexOrThrow(SDKAnalyticsEvents.PARAMETER_SESSION_ID)), a10.getInt(columnIndexOrThrow), a10.getLong(a10.getColumnIndexOrThrow("mp_id")));
                InternalListenerManager.getListener().onCompositeObjects(a10, bVar);
                arrayList.add(bVar);
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

    public static void a(w wVar, int i10) {
        wVar.a("reporting", "_id =?", new String[]{Long.toString((long) i10)});
    }
}
