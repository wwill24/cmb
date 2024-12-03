package com.coffeemeetsbagel.discover;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.jvm.internal.j;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f12177a = new e();

    private e() {
    }

    public final Cursor a(SQLiteDatabase sQLiteDatabase, String str) {
        j.g(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        j.g(str, "now");
        Cursor rawQuery = sQLiteDatabase.rawQuery("\n            SELECT \n              * \n            FROM \n              (\n                SELECT \n                  " + "\n            rising_give_take_id,\n            profile_id,\n            rising_give_take_action,\n            rising_give_take_start_date,\n            rising_give_take_end_date,\n            rising_give_take_shown,\n            rising_give_take_given,\n            rising_give_take_pair_bagel_type,\n            pair_like_comment,\n            give_ten_start_date,\n            give_ten_end_date,\n            give_ten_date_shown,\n            give_ten_last_updated,\n            give_ten_id,\n            give_ten_is_given,\n            give_ten_is_taken,\n            give_ten_is_shown\n        " + "\n                FROM \n                  rising_give_take \n                  left outer join give_ten using (profile_id) \n                union \n                select \n                  " + "\n            rising_give_take_id,\n            profile_id,\n            rising_give_take_action,\n            rising_give_take_start_date,\n            rising_give_take_end_date,\n            rising_give_take_shown,\n            rising_give_take_given,\n            rising_give_take_pair_bagel_type,\n            pair_like_comment,\n            give_ten_start_date,\n            give_ten_end_date,\n            give_ten_date_shown,\n            give_ten_last_updated,\n            give_ten_id,\n            give_ten_is_given,\n            give_ten_is_taken,\n            give_ten_is_shown\n        " + "\n                from \n                  give_ten \n                  left outer join rising_give_take using (profile_id)\n              ) \n            where\n                (give_ten_end_date > " + str + " or give_ten_end_date is null)\n                 AND\n                 (cast(rising_give_take_end_date as integer) > " + str + " or rising_give_take_end_date is null)\n            group by \n              profile_id \n            order by \n              case when rising_give_take_id is null then 1 else 0 end\n        ", (String[]) null);
        j.f(rawQuery, "db.rawQuery(query, null)");
        return rawQuery;
    }
}
