package f7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.match.l;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.jakewharton.rxrelay2.b;
import h6.b;
import j5.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import t7.a;
import u6.e;

public class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final a f14864a;

    /* renamed from: b  reason: collision with root package name */
    private final d f14865b;

    /* renamed from: c  reason: collision with root package name */
    private final b<x> f14866c = b.C0();

    /* renamed from: d  reason: collision with root package name */
    private final e f14867d;

    public c(a aVar, d dVar, e eVar) {
        this.f14864a = aVar;
        this.f14865b = dVar;
        this.f14867d = eVar;
    }

    private static String p(String str) {
        return String.format(Locale.US, "end_date > %s and start_date < %s", new Object[]{str, str});
    }

    private static Bagel q(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        return new b.a(cursor).a();
    }

    private static String r(String str) {
        return p(str) + " and " + "bagel_type in (0,1,4,5,7,10)";
    }

    private boolean s(List<Bagel> list) {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Bagel next : list) {
            if (next.getProfile() != null) {
                arrayList.add(next.getProfile());
                ConnectionDetails c10 = this.f14867d.c(next.getProfileId());
                if (c10 != null) {
                    hashMap.put(next, c10);
                }
            }
        }
        u(list);
        boolean e10 = this.f14864a.e(Extra.BAGEL, list);
        if (list.isEmpty() || e10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            for (Map.Entry entry : hashMap.entrySet()) {
                Bakery.j().t().q((ConnectionDetails) entry.getValue(), (Bagel) entry.getKey());
            }
        }
        t(z10);
        return z10;
    }

    private void t(boolean z10) {
        if (z10) {
            this.f14866c.accept(x.a());
        }
    }

    private void u(List<Bagel> list) {
        for (Bagel next : list) {
            if (next.getShowOrder() == null) {
                Cursor g10 = this.f14864a.g("select show_order from bagel where bagel_id = ?", new String[]{next.getId()});
                Integer a10 = this.f14865b.a(g10);
                if (a10 != null) {
                    next.setShowOrder(a10);
                }
                g10.close();
            }
        }
    }

    private int v(String str, String str2, int i10) {
        return w(str, str2, String.valueOf(i10));
    }

    private int w(String str, String str2, String str3) {
        boolean z10;
        int c10 = this.f14864a.c(Extra.BAGEL, str2, str3, Extra.BAGEL_ID, str);
        if (c10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        t(z10);
        return c10;
    }

    private int x(String str, String str2, boolean z10) {
        return v(str, str2, z10 ? 1 : 0);
    }

    public boolean a(List<Bagel> list) {
        return s(list);
    }

    public int b(String str, boolean z10) {
        return x(str, "chat_removed", z10);
    }

    public int c(String str, String str2) {
        return w(str, "like_comment", str2);
    }

    public int d(String str, String str2) {
        return w(str, "decoupling_date", str2);
    }

    public int e(String str, String str2) {
        return w(str, "couple_id", str2);
    }

    public List<Bagel> f() {
        SQLiteDatabase readableDatabase = this.f14864a.b().getReadableDatabase();
        yb.e eVar = yb.e.f42164a;
        Cursor c10 = eVar.c(readableDatabase);
        ArrayList arrayList = new ArrayList();
        if (c10.moveToFirst()) {
            do {
                arrayList.add(q(readableDatabase, c10));
            } while (c10.moveToNext());
        } else {
            Cursor a10 = eVar.a(readableDatabase);
            if (a10.moveToFirst()) {
                arrayList.add(q(readableDatabase, a10));
            }
        }
        c10.close();
        return arrayList;
    }

    public int g(String str, int i10) {
        return v(str, "action", i10);
    }

    public List<Bagel> h() {
        Cursor b10 = m5.c.f16339a.b(this.f14864a.b().getReadableDatabase());
        List<Bagel> b11 = this.f14865b.b(b10, true);
        if (!b10.isClosed()) {
            b10.close();
        }
        return b11;
    }

    public int i(String str, boolean z10) {
        return x(str, "is_blocked", z10);
    }

    public List<Bagel> j(long j10) {
        ArrayList arrayList;
        Cursor cursor;
        SQLiteDatabase readableDatabase = this.f14864a.b().getReadableDatabase();
        String valueOf = String.valueOf(System.currentTimeMillis());
        Cursor query = readableDatabase.query("(" + ("select * from bagel where " + r(valueOf) + " order by " + "show_order") + ")", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        ArrayList arrayList2 = new ArrayList();
        if (query.moveToFirst()) {
            do {
                arrayList2.add(q(readableDatabase, query));
            } while (query.moveToNext());
            arrayList = arrayList2;
            cursor = query;
        } else {
            String str = "select * from bagel where " + r(valueOf) + " and " + "is_blocked != 1" + " order by " + "show_order" + " desc limit 1";
            arrayList = arrayList2;
            cursor = query;
            Cursor query2 = readableDatabase.query("(" + str + ")", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query2.moveToFirst()) {
                arrayList.add(q(readableDatabase, query2));
            }
        }
        cursor.close();
        return arrayList;
    }

    public com.jakewharton.rxrelay2.b<x> k() {
        return this.f14866c;
    }

    public Bagel l() {
        return this.f14864a.d();
    }

    public Bagel m() {
        SQLiteDatabase readableDatabase = this.f14864a.b().getReadableDatabase();
        Cursor b10 = yb.e.f42164a.b(readableDatabase);
        ArrayList arrayList = new ArrayList();
        if (b10.moveToFirst()) {
            arrayList.add(q(readableDatabase, b10));
        }
        b10.close();
        return (Bagel) arrayList.get(0);
    }

    public boolean n(Bagel bagel) {
        return s(Collections.singletonList(bagel));
    }

    public Bagel o(String str) {
        List<T> F = this.f14864a.b().F(Extra.BAGEL, h6.b.c(), Extra.BAGEL_ID, str);
        if (CollectionUtils.isEmpty((List) F)) {
            return null;
        }
        return (Bagel) F.get(0);
    }
}
