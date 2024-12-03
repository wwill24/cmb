package com.mparticle;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import com.leanplum.internal.Constants;
import com.mparticle.internal.Logger;
import com.mparticle.internal.b;
import java.util.Iterator;
import org.json.JSONException;

public class e0 implements m0 {

    /* renamed from: b  reason: collision with root package name */
    private static String f22307b = "mparticle.db";

    /* renamed from: a  reason: collision with root package name */
    private final Context f22308a;

    public e0(Context context) {
        this.f22308a = context;
    }

    public static String a() {
        return f22307b;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN dataplan_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN dataplan_version NUMBER");
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        String valueOf = String.valueOf(b.b(this.f22308a));
        String[] strArr = {"reporting", "sessions", "attributes", "breadcrumbs", Constants.Keys.MESSAGES};
        for (int i10 = 0; i10 < 5; i10++) {
            sQLiteDatabase.compileStatement(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT '%s'", new Object[]{strArr[i10], "mp_id", valueOf})).execute();
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE reporting ADD COLUMN session_id STRING");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE sessions ADD COLUMN app_info TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE sessions ADD COLUMN device_info TEXT");
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        String str;
        SharedPreferences sharedPreferences = this.f22308a.getSharedPreferences("mParticlePrefs", 0);
        try {
            org.json.b bVar = new org.json.b(sharedPreferences.getString("mp::user_attrs::" + b.a(this.f22308a).j(), (String) null));
            Iterator<String> keys = bVar.keys();
            double currentTimeMillis = (double) System.currentTimeMillis();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    Object obj = bVar.get(next);
                    if (obj != null) {
                        str = obj.toString();
                    } else {
                        str = null;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("attribute_key", next);
                    contentValues.put("attribute_value", str);
                    contentValues.put("is_list", Boolean.FALSE);
                    contentValues.put("created_time", Double.valueOf(currentTimeMillis));
                    sQLiteDatabase.insert("attributes", (String) null, contentValues);
                } catch (JSONException unused) {
                }
            }
        } catch (Exception unused2) {
        } finally {
            sharedPreferences.edit().remove("mp::user_attrs::" + b.a(this.f22308a).j()).apply();
        }
    }

    public void b(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sessions");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS uploads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS breadcrumbs");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS reporting");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS attributes");
        a(sQLiteDatabase);
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sessions (_id INTEGER PRIMARY KEY AUTOINCREMENT, session_id STRING NOT NULL, api_key STRING NOT NULL, start_time INTEGER NOT NULL,end_time INTEGER NOT NULL,session_length INTEGER NOT NULL,attributes TEXT, cfuuid TEXT,app_info TEXT, device_info TEXT, mp_id INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS messages (_id INTEGER PRIMARY KEY AUTOINCREMENT, session_id STRING NOT NULL, api_key STRING NOT NULL, message TEXT, upload_status INTEGER, message_time INTEGER NOT NULL, message_type TEXT, cfuuid TEXT, mp_id INTEGER, dataplan_id TEXT,dataplan_version INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS uploads (_id INTEGER PRIMARY KEY AUTOINCREMENT, api_key STRING NOT NULL, message TEXT, message_time INTEGER NOT NULL, cfuuid TEXT, session_id TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS breadcrumbs (_id INTEGER PRIMARY KEY AUTOINCREMENT, session_id STRING NOT NULL, api_key STRING NOT NULL, message TEXT, breadcrumb_time INTEGER NOT NULL, cfuuid TEXT, mp_id INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS reporting (_id INTEGER PRIMARY KEY AUTOINCREMENT, module_id INTEGER NOT NULL, message TEXT NOT NULL, session_id STRING NOT NULL, report_time INTEGER NOT NULL, mp_id INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS attributes (_id INTEGER PRIMARY KEY AUTOINCREMENT, attribute_key COLLATE NOCASE NOT NULL, attribute_value TEXT, is_list INTEGER NOT NULL, created_time INTEGER NOT NULL, mp_id INTEGER);");
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gcm_messages");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sessions (_id INTEGER PRIMARY KEY AUTOINCREMENT, session_id STRING NOT NULL, api_key STRING NOT NULL, start_time INTEGER NOT NULL,end_time INTEGER NOT NULL,session_length INTEGER NOT NULL,attributes TEXT, cfuuid TEXT,app_info TEXT, device_info TEXT, mp_id INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS messages (_id INTEGER PRIMARY KEY AUTOINCREMENT, session_id STRING NOT NULL, api_key STRING NOT NULL, message TEXT, upload_status INTEGER, message_time INTEGER NOT NULL, message_type TEXT, cfuuid TEXT, mp_id INTEGER, dataplan_id TEXT,dataplan_version INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS uploads (_id INTEGER PRIMARY KEY AUTOINCREMENT, api_key STRING NOT NULL, message TEXT, message_time INTEGER NOT NULL, cfuuid TEXT, session_id TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS breadcrumbs (_id INTEGER PRIMARY KEY AUTOINCREMENT, session_id STRING NOT NULL, api_key STRING NOT NULL, message TEXT, breadcrumb_time INTEGER NOT NULL, cfuuid TEXT, mp_id INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS reporting (_id INTEGER PRIMARY KEY AUTOINCREMENT, module_id INTEGER NOT NULL, message TEXT NOT NULL, session_id STRING NOT NULL, report_time INTEGER NOT NULL, mp_id INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS attributes (_id INTEGER PRIMARY KEY AUTOINCREMENT, attribute_key COLLATE NOCASE NOT NULL, attribute_value TEXT, is_list INTEGER NOT NULL, created_time INTEGER NOT NULL, mp_id INTEGER);");
        if (i10 < 5) {
            try {
                g(sQLiteDatabase);
            } catch (Exception e10) {
                Logger.warning("Exception while upgrading SQLite Database:\n" + e10.getMessage() + "\nThis may have been caused by the database having been already upgraded");
                return;
            }
        }
        if (i10 < 6) {
            f(sQLiteDatabase);
            e(sQLiteDatabase);
        }
        if (i10 < 7) {
            d(sQLiteDatabase);
            b.b(this.f22308a, true);
        }
        if (i10 < 8) {
            b(sQLiteDatabase);
        }
        if (i10 < 9) {
            c(sQLiteDatabase);
        }
    }
}
