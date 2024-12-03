package com.mparticle;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mparticle.internal.listeners.InternalListenerManager;
import java.util.ArrayList;
import java.util.Arrays;

public class x implements w {

    /* renamed from: a  reason: collision with root package name */
    SQLiteDatabase f22648a;

    public x(SQLiteDatabase sQLiteDatabase) {
        this.f22648a = sQLiteDatabase;
    }

    public long a(String str, String str2, ContentValues contentValues) {
        long insert = this.f22648a.insert(str, str2, contentValues);
        if (InternalListenerManager.isEnabled() && insert >= 0) {
            InternalListenerManager.getListener().onEntityStored(Long.valueOf(insert), str, contentValues);
        }
        return insert;
    }

    public void b() {
        this.f22648a.beginTransaction();
    }

    public void c() {
        this.f22648a.setTransactionSuccessful();
    }

    public Cursor a(String str, String... strArr) {
        return this.f22648a.rawQuery(str, strArr);
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        String[] strArr3;
        if (InternalListenerManager.isEnabled()) {
            String[] strArr4 = strArr;
            strArr3 = a(strArr);
        } else {
            strArr3 = strArr;
        }
        Cursor query = this.f22648a.query(str, strArr3, str2, strArr2, str3, str4, str5, str6);
        if (InternalListenerManager.isEnabled()) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
            if (columnIndexOrThrow >= 0 && query.getCount() > 0) {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    l listener = InternalListenerManager.getListener();
                    StringBuilder sb2 = new StringBuilder();
                    String str7 = str;
                    sb2.append(str);
                    sb2.append(query.getInt(columnIndexOrThrow));
                    listener.onCompositeObjects(sb2.toString(), query);
                    query.moveToNext();
                }
            }
            query.moveToFirst();
            query.move(-1);
        }
        return query;
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (InternalListenerManager.isEnabled()) {
            strArr = a(strArr);
        }
        Cursor query = this.f22648a.query(str, strArr, str2, strArr2, str3, str4, str5);
        if (InternalListenerManager.isEnabled()) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
            if (columnIndexOrThrow >= 0 && query.getCount() > 0) {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    l listener = InternalListenerManager.getListener();
                    listener.onCompositeObjects(str + query.getInt(columnIndexOrThrow), query);
                    query.moveToNext();
                }
            }
            query.moveToFirst();
            query.move(-1);
        }
        return query;
    }

    private String[] a(String[] strArr) {
        if (strArr == null) {
            return strArr;
        }
        boolean z10 = false;
        for (String equals : strArr) {
            if (equals.equals("_id")) {
                z10 = true;
            }
        }
        if (z10) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add("_id");
        return (String[]) arrayList.toArray(new String[(strArr.length + 1)]);
    }

    public int a(String str, String str2, String[] strArr) {
        return this.f22648a.delete(str, str2, strArr);
    }

    public void a() {
        this.f22648a.endTransaction();
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        return this.f22648a.update(str, contentValues, str2, strArr);
    }
}
