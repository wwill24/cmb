package f6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteOpenHelper;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.constants.Extra;
import fa.a;
import hb.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a2 extends SQLiteOpenHelper {

    /* renamed from: d  reason: collision with root package name */
    private static a2 f14773d;

    /* renamed from: a  reason: collision with root package name */
    private File f14774a;

    /* renamed from: b  reason: collision with root package name */
    private c f14775b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f14776c = new ArrayList();

    private a2(Context context, c cVar) {
        super(context, "cmb.sqlite", (SQLiteDatabase.CursorFactory) null, 81);
        this.f14775b = cVar;
        this.f14774a = context.getDatabasePath("cmb.sqlite");
    }

    private void C(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction()) {
            sQLiteDatabase.endTransaction();
        }
    }

    private void E(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        y(cursor);
        C(sQLiteDatabase);
    }

    private void I(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("update " + str + " set " + str2 + " = " + str3 + ", " + str3 + " = " + str2);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        try {
            sQLiteDatabase.execSQL("alter table " + str + " add column " + str2);
        } catch (SQLException e10) {
            a.i(e10);
        }
    }

    public static void c() {
        f14773d = null;
    }

    private void f(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("drop table if exists " + str);
    }

    public static boolean h(int i10) {
        return i10 == 1;
    }

    private Cursor k(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        Cursor query = sQLiteDatabase.query(str, (String[]) null, str2 + " = ?", new String[]{String.valueOf(str3)}, (String) null, (String) null, (String) null, (String) null);
        if (query != null) {
            query.moveToFirst();
        }
        return query;
    }

    private Cursor l(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        Cursor query = sQLiteDatabase.query(str, (String[]) null, str2, strArr, (String) null, (String) null, (String) null, (String) null);
        if (query != null) {
            query.moveToFirst();
        }
        return query;
    }

    public static a2 m(Context context, c cVar) {
        if (f14773d == null) {
            f14773d = new a2(context, cVar);
        }
        return f14773d;
    }

    public static int n(boolean z10) {
        return z10 ? 1 : 0;
    }

    private void x(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        try {
            sQLiteDatabase.execSQL("alter table " + str + " drop column " + str2);
        } catch (SQLException e10) {
            a.i(e10);
        }
    }

    private void y(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r4v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.coffeemeetsbagel.models.Model> java.util.List<T> F(java.lang.String r3, h6.a<T> r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.getReadableDatabase()     // Catch:{ all -> 0x001d }
            r1.beginTransaction()     // Catch:{ all -> 0x0019 }
            android.database.Cursor r0 = r2.k(r1, r3, r5, r6)     // Catch:{ all -> 0x0019 }
            java.util.List r3 = r4.b(r0)     // Catch:{ all -> 0x0019 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0019 }
            r2.E(r1, r0)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)     // Catch:{ all -> 0x0023 }
            return r3
        L_0x0019:
            r3 = move-exception
            r4 = r0
            r0 = r1
            goto L_0x001f
        L_0x001d:
            r3 = move-exception
            r4 = r0
        L_0x001f:
            r2.E(r0, r4)     // Catch:{ all -> 0x0023 }
            throw r3     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0023 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.a2.F(java.lang.String, h6.a, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.coffeemeetsbagel.models.Model> java.util.List<T> G(java.lang.String r4, h6.a<T> r5, java.lang.String r6, java.lang.String[] r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r3.getReadableDatabase()     // Catch:{ SQLException -> 0x0023, all -> 0x0020 }
            r1.beginTransaction()     // Catch:{ SQLException -> 0x001d, all -> 0x0019 }
            android.database.Cursor r0 = r3.l(r1, r4, r6, r7)     // Catch:{ SQLException -> 0x001d, all -> 0x0019 }
            java.util.List r4 = r5.b(r0)     // Catch:{ SQLException -> 0x001d, all -> 0x0019 }
            r1.setTransactionSuccessful()     // Catch:{ SQLException -> 0x001d, all -> 0x0019 }
            r3.E(r1, r0)     // Catch:{ all -> 0x0036 }
            monitor-exit(r3)     // Catch:{ all -> 0x0036 }
            return r4
        L_0x0019:
            r4 = move-exception
            r5 = r0
            r0 = r1
            goto L_0x0032
        L_0x001d:
            r4 = r0
            r0 = r1
            goto L_0x0024
        L_0x0020:
            r4 = move-exception
            r5 = r0
            goto L_0x0032
        L_0x0023:
            r4 = r0
        L_0x0024:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x002e }
            r5.<init>()     // Catch:{ all -> 0x002e }
            r3.E(r0, r4)     // Catch:{ all -> 0x0036 }
            monitor-exit(r3)     // Catch:{ all -> 0x0036 }
            return r5
        L_0x002e:
            r5 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0032:
            r3.E(r0, r5)     // Catch:{ all -> 0x0036 }
            throw r4     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0036 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.a2.G(java.lang.String, h6.a, java.lang.String, java.lang.String[]):java.util.List");
    }

    public void b() {
        this.f14776c.clear();
    }

    public int e(String str, String str2, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        int delete;
        synchronized (this) {
            try {
                sQLiteDatabase = getWritableDatabase();
                try {
                    sQLiteDatabase.beginTransaction();
                    delete = sQLiteDatabase.delete(str, str2, strArr);
                    sQLiteDatabase.setTransactionSuccessful();
                    C(sQLiteDatabase);
                } catch (Throwable th2) {
                    th = th2;
                    C(sQLiteDatabase);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
                C(sQLiteDatabase);
                throw th;
            }
        }
        return delete;
    }

    public void g(Context context) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            while (writableDatabase != null && writableDatabase.isOpen()) {
                writableDatabase.close();
            }
            context.deleteDatabase("cmb.sqlite");
            if (!this.f14774a.delete()) {
                a.f("DatabaseOpenHelper", "Database File was not deleted for path: " + this.f14774a.getAbsolutePath());
            }
        } catch (Exception e10) {
            a.i(e10);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table bagel (_id integer primary key autoincrement,action integer,bagel_type integer,couple_id text,created_at integer,decoupling_date integer,end_date integer,given_by_first_name text,bagel_id text unique,is_rematched integer,is_blocked integer,is_pair_blocked integer,last_updated integer,num_mutual_friends integer,pair_action integer,pair_bagel_type integer,profile_id text,reveal_purchased integer,start_date integer,bonusbagel_prompt text,meetup_follow_up_answer integer,meetup_prompt_answer integer,bagel_ideal_first_date blob,bagel_ideal_next_vacation blob,bagel_total_woos integer,bagel_pair_total_woos integer,bagel_total_woos_seen integer,chat_removed integer,pair_chat_removed integer,show_bagel_in_history integer,show_order integer,rising_bagel_count integer,like_comment text,pair_like_comment text,purchase_attribution text);");
        sQLiteDatabase.execSQL("create table give_ten (_id integer primary key autoincrement,give_ten_date_shown long,give_ten_end_date long,give_ten_start_date long,give_ten_last_updated long,give_ten_id text unique,profile_id text,give_ten_is_given integer,give_ten_is_taken integer,give_ten_is_shown integer);");
        sQLiteDatabase.execSQL("create table rising_give_take (_id integer primary key autoincrement,rising_give_take_id text unique,profile_id text,rising_give_take_action integer,rising_give_take_start_date text,rising_give_take_end_date text,rising_give_take_shown integer,rising_give_take_given integer,rising_give_take_pair_bagel_type integer,pair_like_comment text);");
        sQLiteDatabase.execSQL("create table if not exists saved_message (_id integer primary key autoincrement,profile_id text,message text,timestamp text,message_id text unique,category text,url text,displayed_message_id text,to_me integer);");
        sQLiteDatabase.execSQL("create table if not exists roster_element (_id integer primary key autoincrement,profile_id text unique,jid text,group_name text);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Database upgrade from old: ");
        sb2.append(i10);
        sb2.append(" to: ");
        sb2.append(i11);
        if (i10 < 15) {
            f(sQLiteDatabase, Extra.BAGEL);
            f(sQLiteDatabase, "give_ten");
            f(sQLiteDatabase, "rising_give_take");
            this.f14775b.g("SELF_USER_PROFILE_ID", "key_user_id_to_impersonate");
            sQLiteDatabase.execSQL("create table bagel (_id integer primary key autoincrement,action integer,bagel_type integer,couple_id text,created_at integer,decoupling_date integer,end_date integer,given_by_first_name text,bagel_id text unique,is_rematched integer,is_blocked integer,is_pair_blocked integer,last_updated integer,num_mutual_friends integer,pair_action integer,pair_bagel_type integer,profile_id text,reveal_purchased integer,start_date integer,bonusbagel_prompt text,meetup_follow_up_answer integer,meetup_prompt_answer integer,bagel_ideal_first_date blob,bagel_ideal_next_vacation blob,bagel_total_woos integer,bagel_pair_total_woos integer,bagel_total_woos_seen integer,chat_removed integer,pair_chat_removed integer,show_bagel_in_history integer,show_order integer,rising_bagel_count integer,like_comment text,pair_like_comment text,purchase_attribution text);");
            sQLiteDatabase.execSQL("create table give_ten (_id integer primary key autoincrement,give_ten_date_shown long,give_ten_end_date long,give_ten_start_date long,give_ten_last_updated long,give_ten_id text unique,profile_id text,give_ten_is_given integer,give_ten_is_taken integer,give_ten_is_shown integer);");
            sQLiteDatabase.execSQL("create table rising_give_take (_id integer primary key autoincrement,rising_give_take_id text unique,profile_id text,rising_give_take_action integer,rising_give_take_start_date text,rising_give_take_end_date text,rising_give_take_shown integer,rising_give_take_given integer,rising_give_take_pair_bagel_type integer,pair_like_comment text);");
        }
        if (i10 < 16) {
            sQLiteDatabase.execSQL("create table report_meta (_id integer primary key autoincrement,id text unique,shown integer,icon text,updated_date text,field_order integer,title text,component_types blob,action_types blob,object_types blob);");
        }
        if (i10 < 17) {
            a(sQLiteDatabase, Extra.BAGEL, "bagel_total_woos");
            a(sQLiteDatabase, Extra.BAGEL, "bagel_pair_total_woos");
            a(sQLiteDatabase, Extra.BAGEL, "bagel_total_woos_seen");
        }
        if (i10 < 18) {
            a(sQLiteDatabase, Extra.BAGEL, "chat_removed");
            a(sQLiteDatabase, Extra.BAGEL, "pair_chat_removed");
        }
        if (i10 < 20) {
            a(sQLiteDatabase, Extra.BAGEL, "is_blocked");
            a(sQLiteDatabase, Extra.BAGEL, "is_pair_blocked");
            sQLiteDatabase.execSQL("create table reports (report_id text primary key,reports_last_updated text,reports_title text,reports_header blob,reports_cards blob,reports_store_id text);");
            x(sQLiteDatabase, Extra.BAGEL, "next_bonusbagel_price");
        }
        if (i10 < 21) {
            a(sQLiteDatabase, Extra.BAGEL, "created_at");
        }
        if (i10 < 22) {
            a(sQLiteDatabase, Extra.BAGEL, "show_bagel_in_history");
            a(sQLiteDatabase, Extra.BAGEL, "show_order");
        }
        if (i10 < 25) {
            I(sQLiteDatabase, Extra.BAGEL, "is_blocked", "is_pair_blocked");
        }
        if (i10 < 28) {
            a(sQLiteDatabase, Extra.BAGEL, "rising_bagel_count");
        }
        if (i10 < 37) {
            x(sQLiteDatabase, Extra.BAGEL, "bagel_interests");
        }
        if (i10 < 38) {
            x(sQLiteDatabase, Extra.BAGEL, "bagel_ideal_first_date");
            x(sQLiteDatabase, Extra.BAGEL, "bagel_ideal_next_vacation");
        }
        if (i10 < 41) {
            f(sQLiteDatabase, "reports");
            f(sQLiteDatabase, "report_meta");
            a(sQLiteDatabase, "rising_give_take", "rising_give_take_pair_bagel_type");
        }
        if (i10 < 42) {
            x(sQLiteDatabase, Extra.BAGEL, "show_bagel_in_history");
        }
        if (i10 < 43) {
            this.f14776c.add("givetake_current_token");
            this.f14776c.add("risinggivetakes_current_token");
        }
        if (i10 < 44) {
            x(sQLiteDatabase, Extra.BAGEL, "bonusbagel_prompt");
        }
        if (i10 < 45) {
            sQLiteDatabase.execSQL("create table if not exists saved_message (_id integer primary key autoincrement,profile_id text,message text,timestamp text,message_id text unique,category text,url text,displayed_message_id text,to_me integer);");
            sQLiteDatabase.execSQL("create table if not exists roster_element (_id integer primary key autoincrement,profile_id text unique,jid text,group_name text);");
        }
        if (i10 < 50) {
            a(sQLiteDatabase, Extra.BAGEL, "like_comment");
        }
        if (i10 < 51) {
            a(sQLiteDatabase, Extra.BAGEL, "pair_like_comment");
        }
        if (i10 < 55) {
            a(sQLiteDatabase, "rising_give_take", "pair_like_comment");
        }
        if (i10 < 59) {
            a(sQLiteDatabase, Extra.BAGEL, "purchase_attribution");
        }
        if (i10 < 60) {
            f(sQLiteDatabase, "photo_set");
        }
        if (i10 < 71) {
            f(sQLiteDatabase, ModelDeeplinkData.VALUE_PAGE_REWARDS);
        }
        if (i10 < 72) {
            f(sQLiteDatabase, "subscriptions");
        }
        if (i10 < 73) {
            f(sQLiteDatabase, "mutual_friends");
        }
        if (i10 < 74) {
            f(sQLiteDatabase, "Stickers");
        }
        if (i10 < 75) {
            f(sQLiteDatabase, "resources");
        }
        if (i10 < 76) {
            f(sQLiteDatabase, "ActivityReport");
        }
        if (i10 < 81) {
            f(sQLiteDatabase, "retry_call");
            f(sQLiteDatabase, "requests");
            f(sQLiteDatabase, "prices");
        }
    }

    public List<String> u() {
        return Collections.unmodifiableList(this.f14776c);
    }

    public long v(String str, List<ContentValues> list, int i10) {
        long j10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("insert into table=");
        sb2.append(str);
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = null;
            j10 = 0;
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    for (ContentValues insertWithOnConflict : list) {
                        if (writableDatabase.insertWithOnConflict(str, (String) null, insertWithOnConflict, i10) > -1) {
                            j10++;
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                } catch (SQLiteDiskIOException e10) {
                    e = e10;
                    sQLiteDatabase = writableDatabase;
                    try {
                        a.i(e);
                        C(sQLiteDatabase);
                        return j10;
                    } catch (Throwable th2) {
                        th = th2;
                        C(sQLiteDatabase);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = writableDatabase;
                    C(sQLiteDatabase);
                    throw th;
                }
                try {
                    C(writableDatabase);
                } catch (Throwable th4) {
                    throw th4;
                }
            } catch (SQLiteDiskIOException e11) {
                e = e11;
                a.i(e);
                C(sQLiteDatabase);
                return j10;
            }
        }
        return j10;
    }
}
