package md;

import android.database.sqlite.SQLiteDatabase;
import md.t0;

public final /* synthetic */ class q0 implements t0.a {
    public final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
