package androidx.sqlite.db.framework;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import t1.j;

public final /* synthetic */ class c implements DatabaseErrorHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j.a f7037a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FrameworkSQLiteOpenHelper.b f7038b;

    public /* synthetic */ c(j.a aVar, FrameworkSQLiteOpenHelper.b bVar) {
        this.f7037a = aVar;
        this.f7038b = bVar;
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        FrameworkSQLiteOpenHelper.OpenHelper.b(this.f7037a, this.f7038b, sQLiteDatabase);
    }
}
