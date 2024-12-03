package com.clevertap.android.sdk.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import com.leanplum.internal.Constants;
import com.mparticle.kits.AppsFlyerKit;
import java.io.File;
import java.util.ArrayList;
import n4.e;
import org.json.JSONException;
import org.json.b;

public class DBAdapter {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f10146d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f10147e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String f10148f = ("CREATE TABLE " + Table.USER_PROFILES.getName() + " (_id STRING UNIQUE PRIMARY KEY, " + "data" + " STRING NOT NULL);");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String f10149g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String f10150h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f10151i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final String f10152j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final String f10153k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final String f10154l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final String f10155m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final String f10156n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final String f10157o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final String f10158p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final String f10159q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static final String f10160r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final String f10161s;

    /* renamed from: a  reason: collision with root package name */
    private CleverTapInstanceConfig f10162a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10163b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10164c;

    public enum Table {
        EVENTS(Constants.Params.API_EVENTS_STATE),
        PROFILE_EVENTS("profileEvents"),
        USER_PROFILES("userProfiles"),
        INBOX_MESSAGES("inboxMessages"),
        PUSH_NOTIFICATIONS("pushNotifications"),
        UNINSTALL_TS("uninstallTimestamp"),
        PUSH_NOTIFICATION_VIEWED("notificationViewed");
        
        private final String tableName;

        private Table(String str) {
            this.tableName = str;
        }

        public String getName() {
            return this.tableName;
        }
    }

    private static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        private final int f10173a = 20971520;

        /* renamed from: b  reason: collision with root package name */
        private final File f10174b;

        a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 3);
            this.f10174b = context.getDatabasePath(str);
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"UsableSpace"})
        public boolean a() {
            if (!this.f10174b.exists() || Math.max(this.f10174b.getUsableSpace(), 20971520) >= this.f10174b.length()) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            close();
            this.f10174b.delete();
        }

        @SuppressLint({"SQLiteString"})
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            p.o("Creating CleverTap DB");
            SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(DBAdapter.f10146d);
            p.o("Executing - " + DBAdapter.f10146d);
            compileStatement.execute();
            SQLiteStatement compileStatement2 = sQLiteDatabase.compileStatement(DBAdapter.f10147e);
            p.o("Executing - " + DBAdapter.f10147e);
            compileStatement2.execute();
            SQLiteStatement compileStatement3 = sQLiteDatabase.compileStatement(DBAdapter.f10148f);
            p.o("Executing - " + DBAdapter.f10148f);
            compileStatement3.execute();
            SQLiteStatement compileStatement4 = sQLiteDatabase.compileStatement(DBAdapter.f10149g);
            p.o("Executing - " + DBAdapter.f10149g);
            compileStatement4.execute();
            SQLiteStatement compileStatement5 = sQLiteDatabase.compileStatement(DBAdapter.f10153k);
            p.o("Executing - " + DBAdapter.f10153k);
            compileStatement5.execute();
            SQLiteStatement compileStatement6 = sQLiteDatabase.compileStatement(DBAdapter.f10155m);
            p.o("Executing - " + DBAdapter.f10155m);
            compileStatement6.execute();
            SQLiteStatement compileStatement7 = sQLiteDatabase.compileStatement(DBAdapter.f10157o);
            p.o("Executing - " + DBAdapter.f10157o);
            compileStatement7.execute();
            SQLiteStatement compileStatement8 = sQLiteDatabase.compileStatement(DBAdapter.f10151i);
            p.o("Executing - " + DBAdapter.f10151i);
            compileStatement8.execute();
            SQLiteStatement compileStatement9 = sQLiteDatabase.compileStatement(DBAdapter.f10152j);
            p.o("Executing - " + DBAdapter.f10152j);
            compileStatement9.execute();
            SQLiteStatement compileStatement10 = sQLiteDatabase.compileStatement(DBAdapter.f10156n);
            p.o("Executing - " + DBAdapter.f10156n);
            compileStatement10.execute();
            SQLiteStatement compileStatement11 = sQLiteDatabase.compileStatement(DBAdapter.f10154l);
            p.o("Executing - " + DBAdapter.f10154l);
            compileStatement11.execute();
            SQLiteStatement compileStatement12 = sQLiteDatabase.compileStatement(DBAdapter.f10150h);
            p.o("Executing - " + DBAdapter.f10150h);
            compileStatement12.execute();
            SQLiteStatement compileStatement13 = sQLiteDatabase.compileStatement(DBAdapter.f10158p);
            p.o("Executing - " + DBAdapter.f10158p);
            compileStatement13.execute();
        }

        @SuppressLint({"SQLiteString"})
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            p.o("Upgrading CleverTap DB to version " + i11);
            if (i10 == 1) {
                SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(DBAdapter.f10159q);
                p.o("Executing - " + DBAdapter.f10159q);
                compileStatement.execute();
                SQLiteStatement compileStatement2 = sQLiteDatabase.compileStatement(DBAdapter.f10160r);
                p.o("Executing - " + DBAdapter.f10160r);
                compileStatement2.execute();
                SQLiteStatement compileStatement3 = sQLiteDatabase.compileStatement(DBAdapter.f10161s);
                p.o("Executing - " + DBAdapter.f10161s);
                compileStatement3.execute();
                SQLiteStatement compileStatement4 = sQLiteDatabase.compileStatement(DBAdapter.f10149g);
                p.o("Executing - " + DBAdapter.f10149g);
                compileStatement4.execute();
                SQLiteStatement compileStatement5 = sQLiteDatabase.compileStatement(DBAdapter.f10153k);
                p.o("Executing - " + DBAdapter.f10153k);
                compileStatement5.execute();
                SQLiteStatement compileStatement6 = sQLiteDatabase.compileStatement(DBAdapter.f10155m);
                p.o("Executing - " + DBAdapter.f10155m);
                compileStatement6.execute();
                SQLiteStatement compileStatement7 = sQLiteDatabase.compileStatement(DBAdapter.f10157o);
                p.o("Executing - " + DBAdapter.f10157o);
                compileStatement7.execute();
                SQLiteStatement compileStatement8 = sQLiteDatabase.compileStatement(DBAdapter.f10156n);
                p.o("Executing - " + DBAdapter.f10156n);
                compileStatement8.execute();
                SQLiteStatement compileStatement9 = sQLiteDatabase.compileStatement(DBAdapter.f10154l);
                p.o("Executing - " + DBAdapter.f10154l);
                compileStatement9.execute();
                SQLiteStatement compileStatement10 = sQLiteDatabase.compileStatement(DBAdapter.f10150h);
                p.o("Executing - " + DBAdapter.f10150h);
                compileStatement10.execute();
                SQLiteStatement compileStatement11 = sQLiteDatabase.compileStatement(DBAdapter.f10158p);
                p.o("Executing - " + DBAdapter.f10158p);
                compileStatement11.execute();
            } else if (i10 == 2) {
                SQLiteStatement compileStatement12 = sQLiteDatabase.compileStatement(DBAdapter.f10161s);
                p.o("Executing - " + DBAdapter.f10161s);
                compileStatement12.execute();
                SQLiteStatement compileStatement13 = sQLiteDatabase.compileStatement(DBAdapter.f10157o);
                p.o("Executing - " + DBAdapter.f10157o);
                compileStatement13.execute();
                SQLiteStatement compileStatement14 = sQLiteDatabase.compileStatement(DBAdapter.f10158p);
                p.o("Executing - " + DBAdapter.f10158p);
                compileStatement14.execute();
            }
        }
    }

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE ");
        Table table = Table.EVENTS;
        sb2.append(table.getName());
        sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb2.append("data");
        sb2.append(" STRING NOT NULL, ");
        sb2.append("created_at");
        sb2.append(" INTEGER NOT NULL);");
        f10146d = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("CREATE TABLE ");
        Table table2 = Table.PROFILE_EVENTS;
        sb3.append(table2.getName());
        sb3.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb3.append("data");
        sb3.append(" STRING NOT NULL, ");
        sb3.append("created_at");
        sb3.append(" INTEGER NOT NULL);");
        f10147e = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("CREATE TABLE ");
        Table table3 = Table.INBOX_MESSAGES;
        sb4.append(table3.getName());
        sb4.append(" (_id STRING NOT NULL, ");
        sb4.append("data");
        sb4.append(" TEXT NOT NULL, ");
        sb4.append("wzrkParams");
        sb4.append(" TEXT NOT NULL, ");
        sb4.append("campaignId");
        sb4.append(" STRING NOT NULL, ");
        sb4.append("tags");
        sb4.append(" TEXT NOT NULL, ");
        sb4.append(Constants.Keys.IS_READ);
        sb4.append(" INTEGER NOT NULL DEFAULT 0, ");
        sb4.append("expires");
        sb4.append(" INTEGER NOT NULL, ");
        sb4.append("created_at");
        sb4.append(" INTEGER NOT NULL, ");
        sb4.append("messageUser");
        sb4.append(" STRING NOT NULL);");
        f10149g = sb4.toString();
        f10150h = "CREATE UNIQUE INDEX IF NOT EXISTS userid_id_idx ON " + table3.getName() + " (" + "messageUser" + AppsFlyerKit.COMMA + "_id" + ");";
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb5.append(table.getName());
        sb5.append(" (");
        sb5.append("created_at");
        sb5.append(");");
        f10151i = sb5.toString();
        f10152j = "CREATE INDEX IF NOT EXISTS time_idx ON " + table2.getName() + " (" + "created_at" + ");";
        StringBuilder sb6 = new StringBuilder();
        sb6.append("CREATE TABLE ");
        Table table4 = Table.PUSH_NOTIFICATIONS;
        sb6.append(table4.getName());
        sb6.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb6.append("data");
        sb6.append(" STRING NOT NULL, ");
        sb6.append("created_at");
        sb6.append(" INTEGER NOT NULL,");
        sb6.append(Constants.Keys.IS_READ);
        sb6.append(" INTEGER NOT NULL);");
        f10153k = sb6.toString();
        f10154l = "CREATE INDEX IF NOT EXISTS time_idx ON " + table4.getName() + " (" + "created_at" + ");";
        StringBuilder sb7 = new StringBuilder();
        sb7.append("CREATE TABLE ");
        Table table5 = Table.UNINSTALL_TS;
        sb7.append(table5.getName());
        sb7.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb7.append("created_at");
        sb7.append(" INTEGER NOT NULL);");
        f10155m = sb7.toString();
        f10156n = "CREATE INDEX IF NOT EXISTS time_idx ON " + table5.getName() + " (" + "created_at" + ");";
        StringBuilder sb8 = new StringBuilder();
        sb8.append("CREATE TABLE ");
        Table table6 = Table.PUSH_NOTIFICATION_VIEWED;
        sb8.append(table6.getName());
        sb8.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb8.append("data");
        sb8.append(" STRING NOT NULL, ");
        sb8.append("created_at");
        sb8.append(" INTEGER NOT NULL);");
        f10157o = sb8.toString();
        f10158p = "CREATE INDEX IF NOT EXISTS time_idx ON " + table6.getName() + " (" + "created_at" + ");";
        StringBuilder sb9 = new StringBuilder();
        sb9.append("DROP TABLE IF EXISTS ");
        sb9.append(table5.getName());
        f10159q = sb9.toString();
        f10160r = "DROP TABLE IF EXISTS " + table3.getName();
        f10161s = "DROP TABLE IF EXISTS " + table6.getName();
    }

    public DBAdapter(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this(context, D(cleverTapInstanceConfig));
        this.f10162a = cleverTapInstanceConfig;
    }

    private p C() {
        return this.f10162a.n();
    }

    private static String D(CleverTapInstanceConfig cleverTapInstanceConfig) {
        if (cleverTapInstanceConfig.t()) {
            return "clevertap";
        }
        return "clevertap_" + cleverTapInstanceConfig.e();
    }

    private boolean q() {
        return this.f10163b.a();
    }

    private void r(Table table, long j10) {
        long currentTimeMillis = (System.currentTimeMillis() - j10) / 1000;
        String name = table.getName();
        try {
            SQLiteDatabase writableDatabase = this.f10163b.getWritableDatabase();
            writableDatabase.delete(name, "created_at <= " + currentTimeMillis, (String[]) null);
        } catch (SQLiteException e10) {
            p C = C();
            C.v("Error removing stale event records from " + name + ". Recreating DB.", e10);
            v();
        } catch (Throwable th2) {
            this.f10163b.close();
            throw th2;
        }
        this.f10163b.close();
    }

    private void v() {
        this.f10163b.b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
        if (r9 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        if (r9 == null) goto L_0x007a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String z(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch:{ all -> 0x0087 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0087 }
            r9 = 0
            java.lang.String r10 = ""
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r11.f10163b     // Catch:{ SQLiteException -> 0x0054 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0054 }
            r3 = 0
            java.lang.String r4 = "data =?"
            r2 = 1
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0054 }
            r2 = 0
            r5[r2] = r12     // Catch:{ SQLiteException -> 0x0054 }
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0054 }
            if (r9 == 0) goto L_0x0033
            boolean r12 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x0054 }
            if (r12 == 0) goto L_0x0033
            java.lang.String r12 = "data"
            int r12 = r9.getColumnIndex(r12)     // Catch:{ SQLiteException -> 0x0054 }
            java.lang.String r10 = r9.getString(r12)     // Catch:{ SQLiteException -> 0x0054 }
        L_0x0033:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0054 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0054 }
            java.lang.String r1 = "Fetching PID for check - "
            r12.append(r1)     // Catch:{ SQLiteException -> 0x0054 }
            r12.append(r10)     // Catch:{ SQLiteException -> 0x0054 }
            java.lang.String r12 = r12.toString()     // Catch:{ SQLiteException -> 0x0054 }
            com.clevertap.android.sdk.p.o(r12)     // Catch:{ SQLiteException -> 0x0054 }
            com.clevertap.android.sdk.db.DBAdapter$a r12 = r11.f10163b     // Catch:{ all -> 0x0087 }
            r12.close()     // Catch:{ all -> 0x0087 }
            if (r9 == 0) goto L_0x007a
        L_0x004e:
            r9.close()     // Catch:{ all -> 0x0087 }
            goto L_0x007a
        L_0x0052:
            r12 = move-exception
            goto L_0x007c
        L_0x0054:
            r12 = move-exception
            com.clevertap.android.sdk.p r1 = r11.C()     // Catch:{ all -> 0x0052 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r2.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r3 = "Could not fetch records out of database "
            r2.append(r3)     // Catch:{ all -> 0x0052 }
            r2.append(r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "."
            r2.append(r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0052 }
            r1.v(r0, r12)     // Catch:{ all -> 0x0052 }
            com.clevertap.android.sdk.db.DBAdapter$a r12 = r11.f10163b     // Catch:{ all -> 0x0087 }
            r12.close()     // Catch:{ all -> 0x0087 }
            if (r9 == 0) goto L_0x007a
            goto L_0x004e
        L_0x007a:
            monitor-exit(r11)
            return r10
        L_0x007c:
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r11.f10163b     // Catch:{ all -> 0x0087 }
            r0.close()     // Catch:{ all -> 0x0087 }
            if (r9 == 0) goto L_0x0086
            r9.close()     // Catch:{ all -> 0x0087 }
        L_0x0086:
            throw r12     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.z(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (r10 != null) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String[] A() {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.f10164c     // Catch:{ all -> 0x00ac }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ all -> 0x00ac }
            monitor-exit(r12)
            return r0
        L_0x000a:
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch:{ all -> 0x00ac }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x00ac }
            r10 = 0
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x00ac }
            r11.<init>()     // Catch:{ all -> 0x00ac }
            com.clevertap.android.sdk.db.DBAdapter$a r2 = r12.f10163b     // Catch:{ SQLiteException -> 0x0071 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0071 }
            r4 = 0
            java.lang.String r5 = "isRead =?"
            java.lang.String r3 = "0"
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0071 }
            r7 = 0
            r8 = 0
            r9 = 0
            r3 = r0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0071 }
            if (r10 == 0) goto L_0x0064
        L_0x002f:
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0071 }
            if (r2 == 0) goto L_0x0061
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0071 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r3 = "Fetching PID - "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r3 = "data"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ SQLiteException -> 0x0071 }
            r2.append(r3)     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x0071 }
            com.clevertap.android.sdk.p.o(r2)     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r2 = "data"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r2 = r10.getString(r2)     // Catch:{ SQLiteException -> 0x0071 }
            r11.add(r2)     // Catch:{ SQLiteException -> 0x0071 }
            goto L_0x002f
        L_0x0061:
            r10.close()     // Catch:{ SQLiteException -> 0x0071 }
        L_0x0064:
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r12.f10163b     // Catch:{ all -> 0x00ac }
            r0.close()     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x0097
        L_0x006b:
            r10.close()     // Catch:{ all -> 0x00ac }
            goto L_0x0097
        L_0x006f:
            r0 = move-exception
            goto L_0x00a1
        L_0x0071:
            r2 = move-exception
            com.clevertap.android.sdk.p r3 = r12.C()     // Catch:{ all -> 0x006f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r4.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r5 = "Could not fetch records out of database "
            r4.append(r5)     // Catch:{ all -> 0x006f }
            r4.append(r0)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = "."
            r4.append(r0)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x006f }
            r3.v(r0, r2)     // Catch:{ all -> 0x006f }
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r12.f10163b     // Catch:{ all -> 0x00ac }
            r0.close()     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x0097
            goto L_0x006b
        L_0x0097:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ all -> 0x00ac }
            java.lang.Object[] r0 = r11.toArray(r0)     // Catch:{ all -> 0x00ac }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x00ac }
            monitor-exit(r12)
            return r0
        L_0x00a1:
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r12.f10163b     // Catch:{ all -> 0x00ac }
            r1.close()     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x00ab
            r10.close()     // Catch:{ all -> 0x00ac }
        L_0x00ab:
            throw r0     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.A():java.lang.String[]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|(3:10|11|(3:13|14|15))|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        if (r12 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
        if (r12 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        return r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003e */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0078=Splitter:B:33:0x0078, B:17:0x003e=Splitter:B:17:0x003e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.json.b B(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            if (r12 != 0) goto L_0x0006
            monitor-exit(r11)
            return r0
        L_0x0006:
            com.clevertap.android.sdk.db.DBAdapter$Table r1 = com.clevertap.android.sdk.db.DBAdapter.Table.USER_PROFILES     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0083 }
            com.clevertap.android.sdk.db.DBAdapter$a r2 = r11.f10163b     // Catch:{ SQLiteException -> 0x004e, all -> 0x0049 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch:{ SQLiteException -> 0x004e, all -> 0x0049 }
            r4 = 0
            java.lang.String r5 = "_id =?"
            r3 = 1
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x004e, all -> 0x0049 }
            r3 = 0
            r6[r3] = r12     // Catch:{ SQLiteException -> 0x004e, all -> 0x0049 }
            r7 = 0
            r8 = 0
            r9 = 0
            r3 = r1
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x004e, all -> 0x0049 }
            if (r12 == 0) goto L_0x003e
            boolean r2 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x003c }
            if (r2 == 0) goto L_0x003e
            org.json.b r2 = new org.json.b     // Catch:{ JSONException -> 0x003e }
            java.lang.String r3 = "data"
            int r3 = r12.getColumnIndex(r3)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ JSONException -> 0x003e }
            r2.<init>((java.lang.String) r3)     // Catch:{ JSONException -> 0x003e }
            r0 = r2
            goto L_0x003e
        L_0x003c:
            r2 = move-exception
            goto L_0x0050
        L_0x003e:
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r11.f10163b     // Catch:{ all -> 0x0083 }
            r1.close()     // Catch:{ all -> 0x0083 }
            if (r12 == 0) goto L_0x0075
        L_0x0045:
            r12.close()     // Catch:{ all -> 0x0083 }
            goto L_0x0075
        L_0x0049:
            r12 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x0078
        L_0x004e:
            r2 = move-exception
            r12 = r0
        L_0x0050:
            com.clevertap.android.sdk.p r3 = r11.C()     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r4.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r5 = "Could not fetch records out of database "
            r4.append(r5)     // Catch:{ all -> 0x0077 }
            r4.append(r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0077 }
            r3.v(r1, r2)     // Catch:{ all -> 0x0077 }
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r11.f10163b     // Catch:{ all -> 0x0083 }
            r1.close()     // Catch:{ all -> 0x0083 }
            if (r12 == 0) goto L_0x0075
            goto L_0x0045
        L_0x0075:
            monitor-exit(r11)
            return r0
        L_0x0077:
            r0 = move-exception
        L_0x0078:
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r11.f10163b     // Catch:{ all -> 0x0083 }
            r1.close()     // Catch:{ all -> 0x0083 }
            if (r12 == 0) goto L_0x0082
            r12.close()     // Catch:{ all -> 0x0083 }
        L_0x0082:
            throw r0     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.B(java.lang.String):org.json.b");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r10 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        if (r10 == null) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long E() {
        /*
            r13 = this;
            monitor-enter(r13)
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.UNINSTALL_TS     // Catch:{ all -> 0x0070 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0070 }
            r10 = 0
            r11 = 0
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r13.f10163b     // Catch:{ SQLiteException -> 0x003d }
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ SQLiteException -> 0x003d }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "created_at DESC"
            java.lang.String r9 = "1"
            r2 = r0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x003d }
            if (r10 == 0) goto L_0x0030
            boolean r1 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x003d }
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = "created_at"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ SQLiteException -> 0x003d }
            long r11 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x003d }
        L_0x0030:
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r13.f10163b     // Catch:{ all -> 0x0070 }
            r0.close()     // Catch:{ all -> 0x0070 }
            if (r10 == 0) goto L_0x0063
        L_0x0037:
            r10.close()     // Catch:{ all -> 0x0070 }
            goto L_0x0063
        L_0x003b:
            r0 = move-exception
            goto L_0x0065
        L_0x003d:
            r1 = move-exception
            com.clevertap.android.sdk.p r2 = r13.C()     // Catch:{ all -> 0x003b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r3.<init>()     // Catch:{ all -> 0x003b }
            java.lang.String r4 = "Could not fetch records out of database "
            r3.append(r4)     // Catch:{ all -> 0x003b }
            r3.append(r0)     // Catch:{ all -> 0x003b }
            java.lang.String r0 = "."
            r3.append(r0)     // Catch:{ all -> 0x003b }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x003b }
            r2.v(r0, r1)     // Catch:{ all -> 0x003b }
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r13.f10163b     // Catch:{ all -> 0x0070 }
            r0.close()     // Catch:{ all -> 0x0070 }
            if (r10 == 0) goto L_0x0063
            goto L_0x0037
        L_0x0063:
            monitor-exit(r13)
            return r11
        L_0x0065:
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r13.f10163b     // Catch:{ all -> 0x0070 }
            r1.close()     // Catch:{ all -> 0x0070 }
            if (r10 == 0) goto L_0x006f
            r10.close()     // Catch:{ all -> 0x0070 }
        L_0x006f:
            throw r0     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.E():long");
    }

    public synchronized ArrayList<e> F(String str) {
        ArrayList<e> arrayList;
        String name = Table.INBOX_MESSAGES.getName();
        arrayList = new ArrayList<>();
        try {
            Cursor query = this.f10163b.getWritableDatabase().query(name, (String[]) null, "messageUser =?", new String[]{str}, (String) null, (String) null, "created_at DESC");
            if (query != null) {
                while (query.moveToNext()) {
                    e eVar = new e();
                    eVar.p(query.getString(query.getColumnIndex("_id")));
                    eVar.q(new b(query.getString(query.getColumnIndex("data"))));
                    eVar.u(new b(query.getString(query.getColumnIndex("wzrkParams"))));
                    eVar.n(query.getLong(query.getColumnIndex("created_at")));
                    eVar.o(query.getLong(query.getColumnIndex("expires")));
                    eVar.r(query.getInt(query.getColumnIndex(Constants.Keys.IS_READ)));
                    eVar.t(query.getString(query.getColumnIndex("messageUser")));
                    eVar.s(query.getString(query.getColumnIndex("tags")));
                    eVar.m(query.getString(query.getColumnIndex("campaignId")));
                    arrayList.add(eVar);
                }
                query.close();
            }
            this.f10163b.close();
        } catch (SQLiteException e10) {
            p C = C();
            C.v("Error retrieving records from " + name, e10);
            this.f10163b.close();
            return null;
        } catch (JSONException e11) {
            try {
                p C2 = C();
                C2.t("Error retrieving records from " + name, e11.getMessage());
                return null;
            } finally {
                this.f10163b.close();
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean G(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            if (r9 == 0) goto L_0x0064
            if (r10 != 0) goto L_0x0007
            goto L_0x0064
        L_0x0007:
            com.clevertap.android.sdk.db.DBAdapter$Table r1 = com.clevertap.android.sdk.db.DBAdapter.Table.INBOX_MESSAGES     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = r1.getName()     // Catch:{ all -> 0x0061 }
            com.clevertap.android.sdk.db.DBAdapter$a r3 = r8.f10163b     // Catch:{ SQLiteException -> 0x003b }
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ SQLiteException -> 0x003b }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x003b }
            r4.<init>()     // Catch:{ SQLiteException -> 0x003b }
            java.lang.String r5 = "isRead"
            r6 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x003b }
            r4.put(r5, r7)     // Catch:{ SQLiteException -> 0x003b }
            java.lang.String r1 = r1.getName()     // Catch:{ SQLiteException -> 0x003b }
            java.lang.String r5 = "_id = ? AND messageUser = ?"
            r7 = 2
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x003b }
            r7[r0] = r9     // Catch:{ SQLiteException -> 0x003b }
            r7[r6] = r10     // Catch:{ SQLiteException -> 0x003b }
            r3.update(r1, r4, r5, r7)     // Catch:{ SQLiteException -> 0x003b }
            com.clevertap.android.sdk.db.DBAdapter$a r9 = r8.f10163b     // Catch:{ all -> 0x0061 }
            r9.close()     // Catch:{ all -> 0x0061 }
            monitor-exit(r8)
            return r6
        L_0x0039:
            r9 = move-exception
            goto L_0x005b
        L_0x003b:
            r9 = move-exception
            com.clevertap.android.sdk.p r10 = r8.C()     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r1.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = "Error removing stale records from "
            r1.append(r3)     // Catch:{ all -> 0x0039 }
            r1.append(r2)     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0039 }
            r10.v(r1, r9)     // Catch:{ all -> 0x0039 }
            com.clevertap.android.sdk.db.DBAdapter$a r9 = r8.f10163b     // Catch:{ all -> 0x0061 }
            r9.close()     // Catch:{ all -> 0x0061 }
            monitor-exit(r8)
            return r0
        L_0x005b:
            com.clevertap.android.sdk.db.DBAdapter$a r10 = r8.f10163b     // Catch:{ all -> 0x0061 }
            r10.close()     // Catch:{ all -> 0x0061 }
            throw r9     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        L_0x0064:
            monitor-exit(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.G(java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0 = C();
        r0.s("Error removing all events from table " + r4 + " Recreating DB");
        v();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4 = r3.f10163b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.f10163b.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void H(com.clevertap.android.sdk.db.DBAdapter.Table r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0042 }
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r3.f10163b     // Catch:{ SQLiteException -> 0x0017 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0017 }
            r1 = 0
            r0.delete(r4, r1, r1)     // Catch:{ SQLiteException -> 0x0017 }
            com.clevertap.android.sdk.db.DBAdapter$a r4 = r3.f10163b     // Catch:{ all -> 0x0042 }
        L_0x0011:
            r4.close()     // Catch:{ all -> 0x0042 }
            goto L_0x003a
        L_0x0015:
            r4 = move-exception
            goto L_0x003c
        L_0x0017:
            com.clevertap.android.sdk.p r0 = r3.C()     // Catch:{ all -> 0x0015 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            java.lang.String r2 = "Error removing all events from table "
            r1.append(r2)     // Catch:{ all -> 0x0015 }
            r1.append(r4)     // Catch:{ all -> 0x0015 }
            java.lang.String r4 = " Recreating DB"
            r1.append(r4)     // Catch:{ all -> 0x0015 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0015 }
            r0.s(r4)     // Catch:{ all -> 0x0015 }
            r3.v()     // Catch:{ all -> 0x0015 }
            com.clevertap.android.sdk.db.DBAdapter$a r4 = r3.f10163b     // Catch:{ all -> 0x0042 }
            goto L_0x0011
        L_0x003a:
            monitor-exit(r3)
            return
        L_0x003c:
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r3.f10163b     // Catch:{ all -> 0x0042 }
            r0.close()     // Catch:{ all -> 0x0042 }
            throw r4     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.H(com.clevertap.android.sdk.db.DBAdapter$Table):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r6 = C();
        r6.s("Error removing user profile from " + r0 + " Recreating DB");
        r5.f10163b.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r6 = r5.f10163b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r5.f10163b.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void I(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 != 0) goto L_0x0005
            monitor-exit(r5)
            return
        L_0x0005:
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.USER_PROFILES     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0051 }
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r5.f10163b     // Catch:{ SQLiteException -> 0x0024 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0024 }
            java.lang.String r2 = "_id = ?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0024 }
            r4 = 0
            r3[r4] = r6     // Catch:{ SQLiteException -> 0x0024 }
            r1.delete(r0, r2, r3)     // Catch:{ SQLiteException -> 0x0024 }
            com.clevertap.android.sdk.db.DBAdapter$a r6 = r5.f10163b     // Catch:{ all -> 0x0051 }
        L_0x001e:
            r6.close()     // Catch:{ all -> 0x0051 }
            goto L_0x0049
        L_0x0022:
            r6 = move-exception
            goto L_0x004b
        L_0x0024:
            com.clevertap.android.sdk.p r6 = r5.C()     // Catch:{ all -> 0x0022 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r1.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = "Error removing user profile from "
            r1.append(r2)     // Catch:{ all -> 0x0022 }
            r1.append(r0)     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = " Recreating DB"
            r1.append(r0)     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0022 }
            r6.s(r0)     // Catch:{ all -> 0x0022 }
            com.clevertap.android.sdk.db.DBAdapter$a r6 = r5.f10163b     // Catch:{ all -> 0x0022 }
            r6.b()     // Catch:{ all -> 0x0022 }
            com.clevertap.android.sdk.db.DBAdapter$a r6 = r5.f10163b     // Catch:{ all -> 0x0051 }
            goto L_0x001e
        L_0x0049:
            monitor-exit(r5)
            return
        L_0x004b:
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r5.f10163b     // Catch:{ all -> 0x0051 }
            r0.close()     // Catch:{ all -> 0x0051 }
            throw r6     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.I(java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r7 = C();
        r7.s("Error adding data to table " + r8 + " Recreating DB");
        r6.f10163b.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r7 = r6.f10163b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6.f10163b.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int J(org.json.b r7, com.clevertap.android.sdk.db.DBAdapter.Table r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.q()     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x000f
            java.lang.String r7 = "There is not enough space left on the device to store data, data discarded"
            com.clevertap.android.sdk.p.o(r7)     // Catch:{ all -> 0x0089 }
            r7 = -2
            monitor-exit(r6)
            return r7
        L_0x000f:
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0089 }
            r0 = -1
            com.clevertap.android.sdk.db.DBAdapter$a r2 = r6.f10163b     // Catch:{ SQLiteException -> 0x005b }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ SQLiteException -> 0x005b }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x005b }
            r3.<init>()     // Catch:{ SQLiteException -> 0x005b }
            java.lang.String r4 = "data"
            java.lang.String r7 = r7.toString()     // Catch:{ SQLiteException -> 0x005b }
            r3.put(r4, r7)     // Catch:{ SQLiteException -> 0x005b }
            java.lang.String r7 = "created_at"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ SQLiteException -> 0x005b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x005b }
            r3.put(r7, r4)     // Catch:{ SQLiteException -> 0x005b }
            r7 = 0
            r2.insert(r8, r7, r3)     // Catch:{ SQLiteException -> 0x005b }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x005b }
            r7.<init>()     // Catch:{ SQLiteException -> 0x005b }
            java.lang.String r3 = "SELECT COUNT(*) FROM "
            r7.append(r3)     // Catch:{ SQLiteException -> 0x005b }
            r7.append(r8)     // Catch:{ SQLiteException -> 0x005b }
            java.lang.String r7 = r7.toString()     // Catch:{ SQLiteException -> 0x005b }
            android.database.sqlite.SQLiteStatement r7 = r2.compileStatement(r7)     // Catch:{ SQLiteException -> 0x005b }
            long r0 = r7.simpleQueryForLong()     // Catch:{ SQLiteException -> 0x005b }
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r6.f10163b     // Catch:{ all -> 0x0089 }
        L_0x0055:
            r7.close()     // Catch:{ all -> 0x0089 }
            goto L_0x0080
        L_0x0059:
            r7 = move-exception
            goto L_0x0083
        L_0x005b:
            com.clevertap.android.sdk.p r7 = r6.C()     // Catch:{ all -> 0x0059 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r2.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r3 = "Error adding data to table "
            r2.append(r3)     // Catch:{ all -> 0x0059 }
            r2.append(r8)     // Catch:{ all -> 0x0059 }
            java.lang.String r8 = " Recreating DB"
            r2.append(r8)     // Catch:{ all -> 0x0059 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x0059 }
            r7.s(r8)     // Catch:{ all -> 0x0059 }
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r6.f10163b     // Catch:{ all -> 0x0059 }
            r7.b()     // Catch:{ all -> 0x0059 }
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r6.f10163b     // Catch:{ all -> 0x0089 }
            goto L_0x0055
        L_0x0080:
            int r7 = (int) r0
            monitor-exit(r6)
            return r7
        L_0x0083:
            com.clevertap.android.sdk.db.DBAdapter$a r8 = r6.f10163b     // Catch:{ all -> 0x0089 }
            r8.close()     // Catch:{ all -> 0x0089 }
            throw r7     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.J(org.json.b, com.clevertap.android.sdk.db.DBAdapter$Table):int");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0076, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r6 = C();
        r6.s("Error adding data to table " + r0 + " Recreating DB");
        r5.f10163b.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r6 = r5.f10163b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r5.f10163b.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void K(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 != 0) goto L_0x0005
            monitor-exit(r5)
            return
        L_0x0005:
            boolean r0 = r5.q()     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x0016
            com.clevertap.android.sdk.p r6 = r5.C()     // Catch:{ all -> 0x00a5 }
            java.lang.String r7 = "There is not enough space left on the device to store data, data discarded"
            r6.s(r7)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r5)
            return
        L_0x0016:
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x00a5 }
            r1 = 0
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x002a
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a5 }
            r1 = 345600000(0x14997000, double:1.70749087E-315)
            long r7 = r7 + r1
        L_0x002a:
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r5.f10163b     // Catch:{ SQLiteException -> 0x0078 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0078 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0078 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r3 = "data"
            r2.put(r3, r6)     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r3 = "created_at"
            java.lang.Long r4 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x0078 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r3 = "isRead"
            r4 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x0078 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0078 }
            r3 = 0
            r1.insert(r0, r3, r2)     // Catch:{ SQLiteException -> 0x0078 }
            r1 = 1
            r5.f10164c = r1     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0078 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r2 = "Stored PN - "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x0078 }
            r1.append(r6)     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r6 = " with TTL - "
            r1.append(r6)     // Catch:{ SQLiteException -> 0x0078 }
            r1.append(r7)     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r6 = r1.toString()     // Catch:{ SQLiteException -> 0x0078 }
            com.clevertap.android.sdk.p.o(r6)     // Catch:{ SQLiteException -> 0x0078 }
            com.clevertap.android.sdk.db.DBAdapter$a r6 = r5.f10163b     // Catch:{ all -> 0x00a5 }
        L_0x0072:
            r6.close()     // Catch:{ all -> 0x00a5 }
            goto L_0x009d
        L_0x0076:
            r6 = move-exception
            goto L_0x009f
        L_0x0078:
            com.clevertap.android.sdk.p r6 = r5.C()     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r7.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = "Error adding data to table "
            r7.append(r8)     // Catch:{ all -> 0x0076 }
            r7.append(r0)     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = " Recreating DB"
            r7.append(r8)     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0076 }
            r6.s(r7)     // Catch:{ all -> 0x0076 }
            com.clevertap.android.sdk.db.DBAdapter$a r6 = r5.f10163b     // Catch:{ all -> 0x0076 }
            r6.b()     // Catch:{ all -> 0x0076 }
            com.clevertap.android.sdk.db.DBAdapter$a r6 = r5.f10163b     // Catch:{ all -> 0x00a5 }
            goto L_0x0072
        L_0x009d:
            monitor-exit(r5)
            return
        L_0x009f:
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r5.f10163b     // Catch:{ all -> 0x00a5 }
            r7.close()     // Catch:{ all -> 0x00a5 }
            throw r6     // Catch:{ all -> 0x00a5 }
        L_0x00a5:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.K(java.lang.String, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r1 = C();
        r1.s("Error adding data to table " + r0 + " Recreating DB");
        r6.f10163b.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0 = r6.f10163b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r6.f10163b.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void L() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.q()     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0012
            com.clevertap.android.sdk.p r0 = r6.C()     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = "There is not enough space left on the device to store data, data discarded"
            r0.s(r1)     // Catch:{ all -> 0x0069 }
            monitor-exit(r6)
            return
        L_0x0012:
            com.clevertap.android.sdk.db.DBAdapter$Table r0 = com.clevertap.android.sdk.db.DBAdapter.Table.UNINSTALL_TS     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0069 }
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r6.f10163b     // Catch:{ SQLiteException -> 0x003c }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x003c }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x003c }
            r2.<init>()     // Catch:{ SQLiteException -> 0x003c }
            java.lang.String r3 = "created_at"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ SQLiteException -> 0x003c }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x003c }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x003c }
            r3 = 0
            r1.insert(r0, r3, r2)     // Catch:{ SQLiteException -> 0x003c }
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r6.f10163b     // Catch:{ all -> 0x0069 }
        L_0x0036:
            r0.close()     // Catch:{ all -> 0x0069 }
            goto L_0x0061
        L_0x003a:
            r0 = move-exception
            goto L_0x0063
        L_0x003c:
            com.clevertap.android.sdk.p r1 = r6.C()     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r2.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r3 = "Error adding data to table "
            r2.append(r3)     // Catch:{ all -> 0x003a }
            r2.append(r0)     // Catch:{ all -> 0x003a }
            java.lang.String r0 = " Recreating DB"
            r2.append(r0)     // Catch:{ all -> 0x003a }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x003a }
            r1.s(r0)     // Catch:{ all -> 0x003a }
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r6.f10163b     // Catch:{ all -> 0x003a }
            r0.b()     // Catch:{ all -> 0x003a }
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r6.f10163b     // Catch:{ all -> 0x0069 }
            goto L_0x0036
        L_0x0061:
            monitor-exit(r6)
            return
        L_0x0063:
            com.clevertap.android.sdk.db.DBAdapter$a r1 = r6.f10163b     // Catch:{ all -> 0x0069 }
            r1.close()     // Catch:{ all -> 0x0069 }
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.L():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:20|21|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r7 = C();
        r7.s("Error adding data to table " + r2 + " Recreating DB");
        r6.f10163b.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r7 = r6.f10163b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r6.f10163b.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long M(java.lang.String r7, org.json.b r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = -1
            if (r7 != 0) goto L_0x0007
            monitor-exit(r6)
            return r0
        L_0x0007:
            boolean r2 = r6.q()     // Catch:{ all -> 0x0074 }
            if (r2 != 0) goto L_0x001a
            com.clevertap.android.sdk.p r7 = r6.C()     // Catch:{ all -> 0x0074 }
            java.lang.String r8 = "There is not enough space left on the device to store data, data discarded"
            r7.s(r8)     // Catch:{ all -> 0x0074 }
            r7 = -2
            monitor-exit(r6)
            return r7
        L_0x001a:
            com.clevertap.android.sdk.db.DBAdapter$Table r2 = com.clevertap.android.sdk.db.DBAdapter.Table.USER_PROFILES     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0074 }
            com.clevertap.android.sdk.db.DBAdapter$a r3 = r6.f10163b     // Catch:{ SQLiteException -> 0x0047 }
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0047 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0047 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0047 }
            java.lang.String r5 = "data"
            java.lang.String r8 = r8.toString()     // Catch:{ SQLiteException -> 0x0047 }
            r4.put(r5, r8)     // Catch:{ SQLiteException -> 0x0047 }
            java.lang.String r8 = "_id"
            r4.put(r8, r7)     // Catch:{ SQLiteException -> 0x0047 }
            r7 = 0
            r8 = 5
            long r0 = r3.insertWithOnConflict(r2, r7, r4, r8)     // Catch:{ SQLiteException -> 0x0047 }
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r6.f10163b     // Catch:{ all -> 0x0074 }
        L_0x0041:
            r7.close()     // Catch:{ all -> 0x0074 }
            goto L_0x006c
        L_0x0045:
            r7 = move-exception
            goto L_0x006e
        L_0x0047:
            com.clevertap.android.sdk.p r7 = r6.C()     // Catch:{ all -> 0x0045 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r8.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "Error adding data to table "
            r8.append(r3)     // Catch:{ all -> 0x0045 }
            r8.append(r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = " Recreating DB"
            r8.append(r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0045 }
            r7.s(r8)     // Catch:{ all -> 0x0045 }
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r6.f10163b     // Catch:{ all -> 0x0045 }
            r7.b()     // Catch:{ all -> 0x0045 }
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r6.f10163b     // Catch:{ all -> 0x0074 }
            goto L_0x0041
        L_0x006c:
            monitor-exit(r6)
            return r0
        L_0x006e:
            com.clevertap.android.sdk.db.DBAdapter$a r8 = r6.f10163b     // Catch:{ all -> 0x0074 }
            r8.close()     // Catch:{ all -> 0x0074 }
            throw r7     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.M(java.lang.String, org.json.b):long");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:22|23|24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        C().s("Error adding data to table " + com.clevertap.android.sdk.db.DBAdapter.Table.f10169e.getName() + " Recreating DB");
        r7.f10163b.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r8 = r7.f10163b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r7.f10163b.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009f, code lost:
        throw r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x006d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void N(java.lang.String[] r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r8.length     // Catch:{ all -> 0x00a0 }
            if (r0 != 0) goto L_0x0006
            monitor-exit(r7)
            return
        L_0x0006:
            boolean r0 = r7.q()     // Catch:{ all -> 0x00a0 }
            if (r0 != 0) goto L_0x0013
            java.lang.String r8 = "There is not enough space left on the device to store data, data discarded"
            com.clevertap.android.sdk.p.o(r8)     // Catch:{ all -> 0x00a0 }
            monitor-exit(r7)
            return
        L_0x0013:
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r7.f10163b     // Catch:{ SQLiteException -> 0x006d }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x006d }
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x006d }
            r1.<init>()     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r2 = "isRead"
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x006d }
            r1.put(r2, r4)     // Catch:{ SQLiteException -> 0x006d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x006d }
            r2.<init>()     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r4 = "?"
            r2.append(r4)     // Catch:{ SQLiteException -> 0x006d }
            r4 = 0
            r5 = r4
        L_0x0034:
            int r6 = r8.length     // Catch:{ SQLiteException -> 0x006d }
            int r6 = r6 - r3
            if (r5 >= r6) goto L_0x0040
            java.lang.String r6 = ", ?"
            r2.append(r6)     // Catch:{ SQLiteException -> 0x006d }
            int r5 = r5 + 1
            goto L_0x0034
        L_0x0040:
            com.clevertap.android.sdk.db.DBAdapter$Table r3 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r3 = r3.getName()     // Catch:{ SQLiteException -> 0x006d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x006d }
            r5.<init>()     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r6 = "data IN ( "
            r5.append(r6)     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x006d }
            r5.append(r2)     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r2 = " )"
            r5.append(r2)     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r2 = r5.toString()     // Catch:{ SQLiteException -> 0x006d }
            r0.update(r3, r1, r2, r8)     // Catch:{ SQLiteException -> 0x006d }
            r7.f10164c = r4     // Catch:{ SQLiteException -> 0x006d }
            com.clevertap.android.sdk.db.DBAdapter$a r8 = r7.f10163b     // Catch:{ all -> 0x00a0 }
        L_0x0067:
            r8.close()     // Catch:{ all -> 0x00a0 }
            goto L_0x0098
        L_0x006b:
            r8 = move-exception
            goto L_0x009a
        L_0x006d:
            com.clevertap.android.sdk.p r8 = r7.C()     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r0.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r1 = "Error adding data to table "
            r0.append(r1)     // Catch:{ all -> 0x006b }
            com.clevertap.android.sdk.db.DBAdapter$Table r1 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATIONS     // Catch:{ all -> 0x006b }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x006b }
            r0.append(r1)     // Catch:{ all -> 0x006b }
            java.lang.String r1 = " Recreating DB"
            r0.append(r1)     // Catch:{ all -> 0x006b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006b }
            r8.s(r0)     // Catch:{ all -> 0x006b }
            com.clevertap.android.sdk.db.DBAdapter$a r8 = r7.f10163b     // Catch:{ all -> 0x006b }
            r8.b()     // Catch:{ all -> 0x006b }
            com.clevertap.android.sdk.db.DBAdapter$a r8 = r7.f10163b     // Catch:{ all -> 0x00a0 }
            goto L_0x0067
        L_0x0098:
            monitor-exit(r7)
            return
        L_0x009a:
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r7.f10163b     // Catch:{ all -> 0x00a0 }
            r0.close()     // Catch:{ all -> 0x00a0 }
            throw r8     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.N(java.lang.String[]):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a1, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r7 = C();
        r7.s("Error adding data to table " + com.clevertap.android.sdk.db.DBAdapter.Table.f10168d.getName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r7 = r6.f10163b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r6.f10163b.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00cb, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x00a3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void O(java.util.ArrayList<n4.e> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.q()     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x000e
            java.lang.String r7 = "There is not enough space left on the device to store data, data discarded"
            com.clevertap.android.sdk.p.o(r7)     // Catch:{ all -> 0x00cc }
            monitor-exit(r6)
            return
        L_0x000e:
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r6.f10163b     // Catch:{ SQLiteException -> 0x00a3 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00a3 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ SQLiteException -> 0x00a3 }
        L_0x0018:
            boolean r1 = r7.hasNext()     // Catch:{ SQLiteException -> 0x00a3 }
            if (r1 == 0) goto L_0x009b
            java.lang.Object r1 = r7.next()     // Catch:{ SQLiteException -> 0x00a3 }
            n4.e r1 = (n4.e) r1     // Catch:{ SQLiteException -> 0x00a3 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x00a3 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r3 = "_id"
            java.lang.String r4 = r1.e()     // Catch:{ SQLiteException -> 0x00a3 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r3 = "data"
            org.json.b r4 = r1.f()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x00a3 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r3 = "wzrkParams"
            org.json.b r4 = r1.j()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x00a3 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r3 = "campaignId"
            java.lang.String r4 = r1.b()     // Catch:{ SQLiteException -> 0x00a3 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r3 = "tags"
            java.lang.String r4 = r1.g()     // Catch:{ SQLiteException -> 0x00a3 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r3 = "isRead"
            int r4 = r1.l()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x00a3 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r3 = "expires"
            long r4 = r1.d()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00a3 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r3 = "created_at"
            long r4 = r1.c()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00a3 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r3 = "messageUser"
            java.lang.String r1 = r1.h()     // Catch:{ SQLiteException -> 0x00a3 }
            r2.put(r3, r1)     // Catch:{ SQLiteException -> 0x00a3 }
            com.clevertap.android.sdk.db.DBAdapter$Table r1 = com.clevertap.android.sdk.db.DBAdapter.Table.INBOX_MESSAGES     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r1 = r1.getName()     // Catch:{ SQLiteException -> 0x00a3 }
            r3 = 0
            r4 = 5
            r0.insertWithOnConflict(r1, r3, r2, r4)     // Catch:{ SQLiteException -> 0x00a3 }
            goto L_0x0018
        L_0x009b:
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r6.f10163b     // Catch:{ all -> 0x00cc }
        L_0x009d:
            r7.close()     // Catch:{ all -> 0x00cc }
            goto L_0x00c4
        L_0x00a1:
            r7 = move-exception
            goto L_0x00c6
        L_0x00a3:
            com.clevertap.android.sdk.p r7 = r6.C()     // Catch:{ all -> 0x00a1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
            r0.<init>()     // Catch:{ all -> 0x00a1 }
            java.lang.String r1 = "Error adding data to table "
            r0.append(r1)     // Catch:{ all -> 0x00a1 }
            com.clevertap.android.sdk.db.DBAdapter$Table r1 = com.clevertap.android.sdk.db.DBAdapter.Table.INBOX_MESSAGES     // Catch:{ all -> 0x00a1 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x00a1 }
            r0.append(r1)     // Catch:{ all -> 0x00a1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a1 }
            r7.s(r0)     // Catch:{ all -> 0x00a1 }
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r6.f10163b     // Catch:{ all -> 0x00cc }
            goto L_0x009d
        L_0x00c4:
            monitor-exit(r6)
            return
        L_0x00c6:
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r6.f10163b     // Catch:{ all -> 0x00cc }
            r0.close()     // Catch:{ all -> 0x00cc }
            throw r7     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.O(java.util.ArrayList):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void s() {
        r(Table.PUSH_NOTIFICATIONS, 0);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4 = C();
        r4.s("Error removing sent data from table " + r5 + " Recreating DB");
        v();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4 = r3.f10163b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.f10163b.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void t(java.lang.String r4, com.clevertap.android.sdk.db.DBAdapter.Table r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0053 }
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r3.f10163b     // Catch:{ SQLiteException -> 0x0028 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0028 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0028 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0028 }
            java.lang.String r2 = "_id <= "
            r1.append(r2)     // Catch:{ SQLiteException -> 0x0028 }
            r1.append(r4)     // Catch:{ SQLiteException -> 0x0028 }
            java.lang.String r4 = r1.toString()     // Catch:{ SQLiteException -> 0x0028 }
            r1 = 0
            r0.delete(r5, r4, r1)     // Catch:{ SQLiteException -> 0x0028 }
            com.clevertap.android.sdk.db.DBAdapter$a r4 = r3.f10163b     // Catch:{ all -> 0x0053 }
        L_0x0022:
            r4.close()     // Catch:{ all -> 0x0053 }
            goto L_0x004b
        L_0x0026:
            r4 = move-exception
            goto L_0x004d
        L_0x0028:
            com.clevertap.android.sdk.p r4 = r3.C()     // Catch:{ all -> 0x0026 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
            r0.<init>()     // Catch:{ all -> 0x0026 }
            java.lang.String r1 = "Error removing sent data from table "
            r0.append(r1)     // Catch:{ all -> 0x0026 }
            r0.append(r5)     // Catch:{ all -> 0x0026 }
            java.lang.String r5 = " Recreating DB"
            r0.append(r5)     // Catch:{ all -> 0x0026 }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x0026 }
            r4.s(r5)     // Catch:{ all -> 0x0026 }
            r3.v()     // Catch:{ all -> 0x0026 }
            com.clevertap.android.sdk.db.DBAdapter$a r4 = r3.f10163b     // Catch:{ all -> 0x0053 }
            goto L_0x0022
        L_0x004b:
            monitor-exit(r3)
            return
        L_0x004d:
            com.clevertap.android.sdk.db.DBAdapter$a r5 = r3.f10163b     // Catch:{ all -> 0x0053 }
            r5.close()     // Catch:{ all -> 0x0053 }
            throw r4     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.t(java.lang.String, com.clevertap.android.sdk.db.DBAdapter$Table):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void u(Table table) {
        r(table, 432000000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0053, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean w(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            if (r6 == 0) goto L_0x0052
            if (r7 != 0) goto L_0x0007
            goto L_0x0052
        L_0x0007:
            com.clevertap.android.sdk.db.DBAdapter$Table r1 = com.clevertap.android.sdk.db.DBAdapter.Table.INBOX_MESSAGES     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x004f }
            com.clevertap.android.sdk.db.DBAdapter$a r2 = r5.f10163b     // Catch:{ SQLiteException -> 0x0029 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0029 }
            java.lang.String r3 = "_id = ? AND messageUser = ?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0029 }
            r4[r0] = r6     // Catch:{ SQLiteException -> 0x0029 }
            r6 = 1
            r4[r6] = r7     // Catch:{ SQLiteException -> 0x0029 }
            r2.delete(r1, r3, r4)     // Catch:{ SQLiteException -> 0x0029 }
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r5.f10163b     // Catch:{ all -> 0x004f }
            r7.close()     // Catch:{ all -> 0x004f }
            monitor-exit(r5)
            return r6
        L_0x0027:
            r6 = move-exception
            goto L_0x0049
        L_0x0029:
            r6 = move-exception
            com.clevertap.android.sdk.p r7 = r5.C()     // Catch:{ all -> 0x0027 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0027 }
            r2.<init>()     // Catch:{ all -> 0x0027 }
            java.lang.String r3 = "Error removing stale records from "
            r2.append(r3)     // Catch:{ all -> 0x0027 }
            r2.append(r1)     // Catch:{ all -> 0x0027 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0027 }
            r7.v(r1, r6)     // Catch:{ all -> 0x0027 }
            com.clevertap.android.sdk.db.DBAdapter$a r6 = r5.f10163b     // Catch:{ all -> 0x004f }
            r6.close()     // Catch:{ all -> 0x004f }
            monitor-exit(r5)
            return r0
        L_0x0049:
            com.clevertap.android.sdk.db.DBAdapter$a r7 = r5.f10163b     // Catch:{ all -> 0x004f }
            r7.close()     // Catch:{ all -> 0x004f }
            throw r6     // Catch:{ all -> 0x004f }
        L_0x004f:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x0052:
            monitor-exit(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.w(java.lang.String, java.lang.String):boolean");
    }

    public synchronized boolean x(String str) {
        return str.equals(z(str));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:10|(1:12)|13|14|47|46|8|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028 A[Catch:{ SQLiteException -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084 A[SYNTHETIC, Splitter:B:29:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.json.b y(com.clevertap.android.sdk.db.DBAdapter.Table r12, int r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x009d }
            org.json.a r9 = new org.json.a     // Catch:{ all -> 0x009d }
            r9.<init>()     // Catch:{ all -> 0x009d }
            r10 = 0
            com.clevertap.android.sdk.db.DBAdapter$a r0 = r11.f10163b     // Catch:{ SQLiteException -> 0x0058, all -> 0x0056 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0058, all -> 0x0056 }
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "created_at ASC"
            java.lang.String r8 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x0058, all -> 0x0056 }
            r1 = r12
            android.database.Cursor r13 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0058, all -> 0x0056 }
            r0 = r10
        L_0x0022:
            boolean r1 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x0054 }
            if (r1 == 0) goto L_0x004b
            boolean r1 = r13.isLast()     // Catch:{ SQLiteException -> 0x0054 }
            if (r1 == 0) goto L_0x0038
            java.lang.String r0 = "_id"
            int r0 = r13.getColumnIndex(r0)     // Catch:{ SQLiteException -> 0x0054 }
            java.lang.String r0 = r13.getString(r0)     // Catch:{ SQLiteException -> 0x0054 }
        L_0x0038:
            org.json.b r1 = new org.json.b     // Catch:{ JSONException -> 0x0022 }
            java.lang.String r2 = "data"
            int r2 = r13.getColumnIndex(r2)     // Catch:{ JSONException -> 0x0022 }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ JSONException -> 0x0022 }
            r1.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x0022 }
            r9.E(r1)     // Catch:{ JSONException -> 0x0022 }
            goto L_0x0022
        L_0x004b:
            com.clevertap.android.sdk.db.DBAdapter$a r12 = r11.f10163b     // Catch:{ all -> 0x009d }
            r12.close()     // Catch:{ all -> 0x009d }
            r13.close()     // Catch:{ all -> 0x009d }
            goto L_0x0082
        L_0x0054:
            r0 = move-exception
            goto L_0x005a
        L_0x0056:
            r12 = move-exception
            goto L_0x0092
        L_0x0058:
            r0 = move-exception
            r13 = r10
        L_0x005a:
            com.clevertap.android.sdk.p r1 = r11.C()     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r2.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "Could not fetch records out of database "
            r2.append(r3)     // Catch:{ all -> 0x0090 }
            r2.append(r12)     // Catch:{ all -> 0x0090 }
            java.lang.String r12 = "."
            r2.append(r12)     // Catch:{ all -> 0x0090 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x0090 }
            r1.v(r12, r0)     // Catch:{ all -> 0x0090 }
            com.clevertap.android.sdk.db.DBAdapter$a r12 = r11.f10163b     // Catch:{ all -> 0x009d }
            r12.close()     // Catch:{ all -> 0x009d }
            if (r13 == 0) goto L_0x0081
            r13.close()     // Catch:{ all -> 0x009d }
        L_0x0081:
            r0 = r10
        L_0x0082:
            if (r0 == 0) goto L_0x008e
            org.json.b r12 = new org.json.b     // Catch:{ JSONException -> 0x008e }
            r12.<init>()     // Catch:{ JSONException -> 0x008e }
            r12.put((java.lang.String) r0, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x008e }
            monitor-exit(r11)
            return r12
        L_0x008e:
            monitor-exit(r11)
            return r10
        L_0x0090:
            r12 = move-exception
            r10 = r13
        L_0x0092:
            com.clevertap.android.sdk.db.DBAdapter$a r13 = r11.f10163b     // Catch:{ all -> 0x009d }
            r13.close()     // Catch:{ all -> 0x009d }
            if (r10 == 0) goto L_0x009c
            r10.close()     // Catch:{ all -> 0x009d }
        L_0x009c:
            throw r12     // Catch:{ all -> 0x009d }
        L_0x009d:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.db.DBAdapter.y(com.clevertap.android.sdk.db.DBAdapter$Table, int):org.json.b");
    }

    private DBAdapter(Context context, String str) {
        this.f10164c = true;
        this.f10163b = new a(context, str);
    }
}
