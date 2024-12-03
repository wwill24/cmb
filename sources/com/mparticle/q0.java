package com.mparticle;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.mparticle.d0;
import com.mparticle.internal.listeners.InternalListenerManager;
import java.util.ArrayList;
import java.util.List;
import org.json.b;

public class q0 extends r0 {
    public static int a(w wVar) {
        return wVar.a("uploads", "length(message) > 204800", (String[]) null);
    }

    public static List<d0.d> b(w wVar) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = wVar.a("uploads", new String[]{"_id", "message", "cfuuid"}, (String) null, (String[]) null, (String) null, (String) null, "message_time");
            try {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("message");
                int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("cfuuid");
                while (cursor.moveToNext()) {
                    d0.d dVar = new d0.d(cursor.getInt(columnIndexOrThrow), AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(cursor.getString(columnIndexOrThrow3)), cursor.getString(columnIndexOrThrow2));
                    arrayList.add(dVar);
                    InternalListenerManager.getListener().onCompositeObjects(cursor, dVar);
                }
                if (!cursor.isClosed()) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable unused) {
                cursor.close();
                return arrayList;
            }
        } catch (Throwable unused2) {
            cursor = null;
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public static void a(w wVar, b bVar, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("api_key", str);
        contentValues.put("message_time", Long.valueOf(bVar.optLong("ct", System.currentTimeMillis())));
        contentValues.put("message", bVar.toString());
        contentValues.put("cfuuid", "0");
        InternalListenerManager.getListener().onCompositeObjects(bVar, contentValues);
        wVar.a("uploads", (String) null, contentValues);
    }

    public static int a(w wVar, int i10) {
        return wVar.a("uploads", "_id=?", new String[]{Long.toString((long) i10)});
    }

    public static long a(w wVar, String str, b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("api_key", str);
        contentValues.put("message_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("message", bVar.toString());
        contentValues.put("cfuuid", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        InternalListenerManager.getListener().onCompositeObjects(bVar, contentValues);
        return wVar.a("uploads", (String) null, contentValues);
    }
}
