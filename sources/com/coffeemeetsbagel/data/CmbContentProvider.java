package com.coffeemeetsbagel.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.discover.e;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.BagelAction;
import com.mparticle.kits.AppsFlyerKit;
import f6.f2;
import java.util.Locale;
import m5.c;

public class CmbContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11591a = ("action not in (" + BagelAction.PASS.getId() + AppsFlyerKit.COMMA + BagelAction.LIKE.getId() + ") ");

    /* renamed from: b  reason: collision with root package name */
    private static UriMatcher f11592b = a();

    private static UriMatcher a() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.coffeemeetsbagel", "bagels", 110);
        uriMatcher.addURI("com.coffeemeetsbagel", "bagels/today", 102);
        uriMatcher.addURI("com.coffeemeetsbagel", "bagels/unactioned", 117);
        uriMatcher.addURI("com.coffeemeetsbagel", "bagels/connected", 106);
        uriMatcher.addURI("com.coffeemeetsbagel", "give_take_items", 112);
        uriMatcher.addURI("com.coffeemeetsbagel", "resources", 115);
        return uriMatcher;
    }

    private static String b(String str) {
        return String.format(Locale.US, "end_date > %s and start_date < %s", new Object[]{str, str});
    }

    private static String c(String str) {
        return b(str) + " and " + "bagel_type in (0,1,4,5,7,10)";
    }

    public static Cursor d(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.query("(" + ("select * from bagel where " + c(String.valueOf(System.currentTimeMillis())) + " and " + f11591a + "and " + "is_blocked != 1") + ")", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    public static Cursor e(SQLiteDatabase sQLiteDatabase) {
        String c10 = c(String.valueOf(System.currentTimeMillis()));
        return sQLiteDatabase.query("(" + ("select * from (" + ("select * from bagel where " + c10 + " and " + f11591a + " and " + "is_blocked != 1" + " order by " + "show_order" + " limit 1") + ") union all select * from (" + ("select * from bagel where " + c10 + " and " + "is_blocked != 1" + " order by " + "show_order" + " desc limit 1") + ") order by " + "show_order") + ")", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] contentValuesArr) {
        throw new UnsupportedOperationException("Could not recognize uri: " + uri);
    }

    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(@NonNull Uri uri) {
        int match = f11592b.match(uri);
        if (match == 102) {
            return "vnd.android.cursor.item/com.coffeemeetsbagel/bagels";
        }
        if (match == 110) {
            return "vnd.android.cursor.dir/com.coffeemeetsbagel/bagels";
        }
        if (match == 112) {
            return "vnd.android.cursor.dir/com.coffeemeetsbagel/give_take_items";
        }
        if (match == 115) {
            return "vnd.android.cursor.dir/com.coffeemeetsbagel/resources";
        }
        if (match == 117) {
            return "vnd.android.cursor.item/com.coffeemeetsbagel/bagels";
        }
        throw new UnsupportedOperationException("Unknown Uri " + uri);
    }

    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("uri=");
        sb2.append(uri);
        sb2.append(", projection=");
        sb2.append(strArr);
        sb2.append(", selection=");
        sb2.append(str);
        sb2.append(", selectionArgs=");
        sb2.append(strArr2);
        sb2.append(", sortOrder=");
        sb2.append(str2);
        int match = f11592b.match(uri);
        new SQLiteQueryBuilder();
        String valueOf = String.valueOf(System.currentTimeMillis());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("now=");
        sb3.append(valueOf);
        if (match == 102) {
            cursor = e(Bakery.w().n().b().getReadableDatabase());
        } else if (match == 106) {
            Bakery.w().B();
            cursor = c.f16339a.b(f2.f().getReadableDatabase());
        } else if (match == 110) {
            cursor = Bakery.w().n().b().getReadableDatabase().query(Extra.BAGEL, strArr, str, strArr2, (String) null, (String) null, str2);
        } else if (match == 112) {
            e eVar = e.f12177a;
            Bakery.w().B();
            cursor = eVar.a(f2.f().getReadableDatabase(), String.valueOf(System.currentTimeMillis()));
        } else if (match == 117) {
            cursor = d(Bakery.w().n().b().getReadableDatabase());
        } else {
            throw new UnsupportedOperationException("Unknown Uri: " + uri);
        }
        if (getContext() != null) {
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }

    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
