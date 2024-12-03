package yb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.coffeemeetsbagel.models.enums.BagelAction;
import kotlin.jvm.internal.j;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f42164a = new e();

    private e() {
    }

    public final Cursor a(SQLiteDatabase sQLiteDatabase) {
        j.g(sQLiteDatabase, "sqlite");
        String valueOf = String.valueOf(System.currentTimeMillis());
        Cursor rawQuery = sQLiteDatabase.rawQuery("\n                SELECT *\n                FROM    bagel\n                WHERE   end_date > " + valueOf + " AND\n                        start_date < " + valueOf + " AND\n                        bagel_type IN (\n                            0,\n                            1,\n                            4,\n                            5,\n                            7,\n                            10) AND\n                        action IN (\n                            " + BagelAction.PASS.getId() + ",\n                            " + BagelAction.LIKE.getId() + ") AND\n                        is_blocked != 1\n                ORDER BY show_order DESC\n                LIMIT 1\n        ", (String[]) null);
        j.f(rawQuery, "sqlite.rawQuery(queryString, null)");
        return rawQuery;
    }

    public final Cursor b(SQLiteDatabase sQLiteDatabase) {
        j.g(sQLiteDatabase, "sqlite");
        String valueOf = String.valueOf(System.currentTimeMillis());
        Cursor rawQuery = sQLiteDatabase.rawQuery("\n                SELECT *\n                FROM    bagel\n                WHERE   end_date > " + valueOf + " AND\n                        start_date < " + valueOf + " AND\n                        bagel_type IN (\n                            0,\n                            1,\n                            4,\n                            5,\n                            7,\n                            10) AND\n                        action = (" + BagelAction.PASS.getId() + ") AND\n                        is_blocked != 1\n                ORDER BY show_order DESC\n                LIMIT 1\n        ", (String[]) null);
        j.f(rawQuery, "sqlite.rawQuery(queryString, null)");
        return rawQuery;
    }

    public final Cursor c(SQLiteDatabase sQLiteDatabase) {
        j.g(sQLiteDatabase, "sqlite");
        String valueOf = String.valueOf(System.currentTimeMillis());
        Cursor rawQuery = sQLiteDatabase.rawQuery("\n                SELECT *\n                FROM    bagel\n                WHERE   end_date > " + valueOf + " AND\n                        start_date < " + valueOf + " AND\n                        bagel_type IN (\n                            0,\n                            1,\n                            4,\n                            5,\n                            7,\n                            10) AND\n                        action IN (\n                            " + BagelAction.PASS.getId() + ",\n                            " + BagelAction.LIKE.getId() + ")\n                            AND\n                        is_blocked != 1\n                ORDER BY show_order DESC\n        ", (String[]) null);
        j.f(rawQuery, "sqlite.rawQuery(queryString, null)");
        return rawQuery;
    }
}
