package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import pk.o;
import t1.l;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroid/database/sqlite/SQLiteDatabase;", "<anonymous parameter 0>", "Landroid/database/sqlite/SQLiteCursorDriver;", "masterQuery", "", "editTable", "Landroid/database/sqlite/SQLiteQuery;", "sqLiteQuery", "Landroid/database/sqlite/SQLiteCursor;", "a", "(Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;)Landroid/database/sqlite/SQLiteCursor;"}, k = 3, mv = {1, 7, 1})
final class FrameworkSQLiteDatabase$query$cursorFactory$1 extends Lambda implements o<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor> {
    final /* synthetic */ l $query;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FrameworkSQLiteDatabase$query$cursorFactory$1(l lVar) {
        super(4);
        this.$query = lVar;
    }

    /* renamed from: a */
    public final SQLiteCursor g(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        l lVar = this.$query;
        j.d(sQLiteQuery);
        lVar.b(new e(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }
}
