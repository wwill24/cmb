package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.protocol.module.Database;
import java.util.List;

public abstract class BaseDatabaseDriver<DESC> {
    protected Context mContext;

    public interface ExecuteResultHandler<RESULT> {
        RESULT handleInsert(long j10) throws SQLiteException;

        RESULT handleRawQuery() throws SQLiteException;

        RESULT handleSelect(Cursor cursor) throws SQLiteException;

        RESULT handleUpdateDelete(int i10) throws SQLiteException;
    }

    public BaseDatabaseDriver(Context context) {
        this.mContext = context;
    }

    public abstract Database.ExecuteSQLResponse executeSQL(DESC desc, String str, ExecuteResultHandler<Database.ExecuteSQLResponse> executeResultHandler) throws SQLiteException;

    public Context getContext() {
        return this.mContext;
    }

    public abstract List<DESC> getDatabaseNames();

    public abstract List<String> getTableNames(DESC desc);
}
