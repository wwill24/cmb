package f6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.os.AsyncTask;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.data.CmbContentProvider;
import com.coffeemeetsbagel.database.room_mappers.d;
import com.coffeemeetsbagel.exception.DatabaseInsertionException;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.Model;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import h6.c;
import j5.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lc.s;
import qj.w;

public class f2 {

    class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f14797a;

        a(List list) {
            this.f14797a = list;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            new d(Bakery.w().k(), Bakery.j().A()).a(this.f14797a);
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
        }
    }

    public static a2 f() {
        Bakery w10 = Bakery.w();
        return a2.m(w10.getApplicationContext(), w10.M());
    }

    private long l(String str, List<? extends h6.a> list, int i10) {
        a2 f10 = f();
        ArrayList arrayList = new ArrayList();
        for (h6.a aVar : list) {
            if (aVar != null) {
                arrayList.add(aVar.a());
            }
        }
        return f10.v(str, arrayList, i10);
    }

    private boolean n(String str, List<? extends h6.a> list, int i10) {
        if (list == null) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Inserting ");
        sb2.append(list.size());
        sb2.append(" into ");
        sb2.append(str);
        p(list);
        try {
            t(l(str, list, i10), list.size());
            return true;
        } catch (DatabaseInsertionException e10) {
            fa.a.g("ManagerDatabase", "insertion error", e10);
            return false;
        } catch (SQLiteReadOnlyDatabaseException e11) {
            fa.a.g("ManagerDatabase", "read only, not writable", e11);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x o(Bagel bagel) throws Exception {
        j(Collections.singletonList(bagel));
        return x.a();
    }

    private void p(List<? extends h6.a> list) {
        new a(list).execute(new Void[0]);
    }

    private void r(List<Bagel> list) {
        if (list != null) {
            for (Bagel next : list) {
                if (next.getShowOrder() == null) {
                    Cursor d10 = d("select show_order from bagel where bagel_id = ?", new String[]{next.getId()});
                    if (d10 != null) {
                        try {
                            if (!d10.isClosed() && d10.moveToFirst()) {
                                next.setShowOrder(Integer.valueOf(d10.getInt(d10.getColumnIndex("show_order"))));
                            }
                        } catch (Throwable th2) {
                            d10.close();
                            throw th2;
                        }
                    }
                    if (d10 != null) {
                        d10.close();
                    }
                }
            }
        }
    }

    private void t(long j10, int i10) throws DatabaseInsertionException {
        if (j10 != ((long) i10)) {
            throw new DatabaseInsertionException("Failed to insert one or more rows! Rows affected: " + j10 + " out of " + i10);
        }
    }

    public int b(String str, String str2, String[] strArr) {
        return f().e(str, str2, strArr);
    }

    public void c(Context context) {
        f().g(context);
        a2.c();
    }

    public Cursor d(String str, String[] strArr) {
        return f().getWritableDatabase().rawQuery(str, strArr);
    }

    public Bagel e() {
        Bagel bagel;
        Cursor e10 = CmbContentProvider.e(f().getReadableDatabase());
        if (e10 == null || e10.getCount() <= 0 || !e10.moveToFirst()) {
            bagel = null;
        } else {
            bagel = new f7.a().b(e10, false).get(0);
        }
        if (e10 != null && !e10.isClosed()) {
            e10.close();
        }
        return bagel;
    }

    public a2 g() {
        return f();
    }

    public <T extends Model> T h(String str, h6.a<T> aVar, String str2, String str3) {
        List<T> F = f().F(str, aVar, str2, str3);
        if (CollectionUtils.isEmpty((List) F)) {
            return null;
        }
        return (Model) F.get(0);
    }

    public w<x> i(Bagel bagel) {
        return w.A(new e2(this, bagel)).K(dk.a.c());
    }

    public void j(List<Bagel> list) {
        r(list);
        m(Extra.BAGEL, s.b(list));
    }

    public boolean k(String str, h6.a aVar) {
        return m(str, Collections.singletonList(aVar));
    }

    public boolean m(String str, List<? extends h6.a> list) {
        return n(str, list, 5);
    }

    public List<? extends Model> q(String str, c cVar, String str2, String[] strArr) {
        return f().G(str, cVar, str2, strArr);
    }

    public int s(String str, String str2, String str3, String str4, String str5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(str2, str3);
        String[] strArr = {str5};
        SQLiteDatabase writableDatabase = f().getWritableDatabase();
        return writableDatabase.update(str, contentValues, str4 + " = ?", strArr);
    }
}
