package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor;
import com.facebook.stetho.inspector.protocol.module.DatabaseDriver2;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class DatabaseDriver2Adapter extends DatabaseDriver2<StringDatabaseDescriptor> {
    private final Database.DatabaseDriver mLegacy;

    static class StringDatabaseDescriptor implements DatabaseDescriptor {
        public final String name;

        public StringDatabaseDescriptor(String str) {
            this.name = str;
        }

        public String name() {
            return this.name;
        }
    }

    public DatabaseDriver2Adapter(Database.DatabaseDriver databaseDriver) {
        super(databaseDriver.getContext());
        this.mLegacy = databaseDriver;
    }

    public List<StringDatabaseDescriptor> getDatabaseNames() {
        List<Object> databaseNames = this.mLegacy.getDatabaseNames();
        ArrayList arrayList = new ArrayList(databaseNames.size());
        for (Object obj : databaseNames) {
            arrayList.add(new StringDatabaseDescriptor(obj.toString()));
        }
        return arrayList;
    }

    public Database.ExecuteSQLResponse executeSQL(StringDatabaseDescriptor stringDatabaseDescriptor, String str, BaseDatabaseDriver.ExecuteResultHandler executeResultHandler) throws SQLiteException {
        return this.mLegacy.executeSQL(stringDatabaseDescriptor.name, str, executeResultHandler);
    }

    public List<String> getTableNames(StringDatabaseDescriptor stringDatabaseDescriptor) {
        return this.mLegacy.getTableNames(stringDatabaseDescriptor.name);
    }
}
