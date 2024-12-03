package m5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import j$.time.Instant;
import kotlin.jvm.internal.j;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f16339a = new c();

    private c() {
    }

    public final Cursor a(SQLiteDatabase sQLiteDatabase) {
        j.g(sQLiteDatabase, "sqlite");
        long epochMilli = Instant.now().toEpochMilli();
        Cursor rawQuery = sQLiteDatabase.rawQuery("\n            SELECT *\n            FROM   (SELECT *\n                    FROM   bagel\n                               INNER JOIN roster_element using (profile_id)\n                    WHERE  action = 1\n                           AND pair_action = 1\n                           AND decoupling_date > " + epochMilli + "\n                           AND couple_id > 0\n                           AND ( is_blocked = 0 OR is_blocked IS NULL )\n                           AND ( is_pair_blocked = 0 OR is_pair_blocked IS NULL )\n                           AND ( chat_removed = 0 OR chat_removed IS NULL ))\n            GROUP  BY profile_id\n            ORDER  BY start_date DESC,\n                      decoupling_date DESC \n        ", (String[]) null);
        j.f(rawQuery, "sqlite.rawQuery(queryString, null)");
        return rawQuery;
    }

    public final Cursor b(SQLiteDatabase sQLiteDatabase) {
        j.g(sQLiteDatabase, "sqlite");
        Cursor rawQuery = sQLiteDatabase.rawQuery("\n            SELECT * FROM\n                        (SELECT *\n                        FROM   bagel\n                               INNER JOIN roster_element using (profile_id)\n                        WHERE  action = 1\n                               AND pair_action = 1\n                               AND couple_id > 0\n                               AND (is_blocked = 0 OR is_blocked IS NULL )\n                               AND (is_pair_blocked = 0 OR is_pair_blocked IS NULL )\n                               AND (chat_removed = 0 OR chat_removed IS NULL )\n                        ORDER  BY profile_id DESC)\n            GROUP BY profile_id\n            ORDER BY start_date desc\n        ", (String[]) null);
        j.f(rawQuery, "sqlite.rawQuery(queryString, null)");
        return rawQuery;
    }

    public final Cursor c(SQLiteDatabase sQLiteDatabase) {
        j.g(sQLiteDatabase, "sqlite");
        long epochMilli = Instant.now().toEpochMilli();
        Cursor rawQuery = sQLiteDatabase.rawQuery("\n            SELECT *\n            FROM   (SELECT *\n                    FROM   bagel\n                               INNER JOIN roster_element using (profile_id)\n                    WHERE  action = 1\n                           AND pair_action = 1\n                           AND decoupling_date < " + epochMilli + "\n                           AND couple_id > 0\n                           AND ( is_blocked = 0 OR is_blocked IS NULL )\n                           AND ( is_pair_blocked = 0 OR is_pair_blocked IS NULL )\n                           AND ( chat_removed = 0 OR chat_removed IS NULL ))\n            GROUP  BY profile_id\n            ORDER  BY start_date DESC,\n                      decoupling_date DESC \n        ", (String[]) null);
        j.f(rawQuery, "sqlite.rawQuery(queryString, null)");
        return rawQuery;
    }
}
