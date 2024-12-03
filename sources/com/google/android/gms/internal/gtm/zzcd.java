package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

final class zzcd extends SQLiteOpenHelper {
    final /* synthetic */ zzce zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcd(zzce zzce, Context context, String str) {
        super(context, "google_analytics_v4.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzce;
    }

    private final boolean zza(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, (String) null, (String) null, (String) null);
            boolean moveToFirst = query.moveToFirst();
            query.close();
            return moveToFirst;
        } catch (SQLiteException e10) {
            this.zza.zzT("Error querying for table", str, e10);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    private static final Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder(str.length() + 22);
        sb2.append("SELECT * FROM ");
        sb2.append(str);
        sb2.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb2.toString(), (String[]) null);
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (String add : columnNames) {
                hashSet.add(add);
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (this.zza.zze.zzc(DateUtils.MILLIS_IN_HOUR)) {
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException unused) {
                this.zza.zze.zzb();
                this.zza.zzJ("Opening the database failed, dropping the table and recreating it");
                this.zza.zzo().getDatabasePath(this.zza.zzae()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    this.zza.zze.zza();
                    return writableDatabase;
                } catch (SQLiteException e10) {
                    this.zza.zzK("Failed to open freshly created database", e10);
                    throw e10;
                }
            }
        } else {
            throw new SQLiteException("Database open failed");
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        try {
            if (Integer.parseInt(Build.VERSION.SDK) >= 9) {
                File file = new File(path);
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        } catch (NumberFormatException unused) {
            zzfa.zzb("Invalid version number", Build.VERSION.SDK);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        String str;
        String str2;
        if (!zza(sQLiteDatabase, "hits2")) {
            sQLiteDatabase.execSQL(zzce.zza);
        } else {
            Set<String> zzb = zzb(sQLiteDatabase, "hits2");
            String[] strArr = {"hit_id", "hit_string", "hit_time", "hit_url"};
            for (int i10 = 0; i10 < 4; i10++) {
                String str3 = strArr[i10];
                if (!zzb.remove(str3)) {
                    String valueOf = String.valueOf(str3);
                    if (valueOf.length() != 0) {
                        str2 = "Database hits2 is missing required column: ".concat(valueOf);
                    } else {
                        str2 = new String("Database hits2 is missing required column: ");
                    }
                    throw new SQLiteException(str2);
                }
            }
            boolean z10 = !zzb.remove("hit_app_id");
            if (!zzb.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (z10) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        }
        if (zza(sQLiteDatabase, JivePropertiesExtension.ELEMENT)) {
            Set<String> zzb2 = zzb(sQLiteDatabase, JivePropertiesExtension.ELEMENT);
            String[] strArr2 = {"app_uid", "cid", "tid", "params", "adid", "hits_count"};
            for (int i11 = 0; i11 < 6; i11++) {
                String str4 = strArr2[i11];
                if (!zzb2.remove(str4)) {
                    String valueOf2 = String.valueOf(str4);
                    if (valueOf2.length() != 0) {
                        str = "Database properties is missing required column: ".concat(valueOf2);
                    } else {
                        str = new String("Database properties is missing required column: ");
                    }
                    throw new SQLiteException(str);
                }
            }
            if (!zzb2.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
            return;
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
