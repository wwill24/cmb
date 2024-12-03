package f6;

import android.database.Cursor;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.Model;
import com.coffeemeetsbagel.models.constants.Extra;
import h6.c;
import j5.x;
import java.util.List;
import kotlin.jvm.internal.j;
import lc.s;
import qj.w;
import t7.a;

public final class z1 implements a {

    /* renamed from: a  reason: collision with root package name */
    private final f2 f14862a;

    public z1(f2 f2Var) {
        j.g(f2Var, "managerDatabase");
        this.f14862a = f2Var;
    }

    public <T extends Model> T a(String str, h6.a<T> aVar, String str2, String str3) {
        j.g(str, "table");
        j.g(aVar, "mapper");
        j.g(str2, "idColumn");
        j.g(str3, "id");
        return this.f14862a.h(str, aVar, str2, str3);
    }

    public a2 b() {
        a2 g10 = this.f14862a.g();
        j.f(g10, "managerDatabase.databaseOpenHelperNonStatic");
        return g10;
    }

    public int c(String str, String str2, String str3, String str4, String str5) {
        j.g(str, "table");
        j.g(str2, "col");
        j.g(str3, "val");
        j.g(str4, "idCol");
        j.g(str5, "id");
        return this.f14862a.s(str, str2, str3, str4, str5);
    }

    public Bagel d() {
        return this.f14862a.e();
    }

    public boolean e(String str, List<? extends Model> list) {
        j.g(str, "table");
        j.g(list, "objects");
        return this.f14862a.m(str, s.b(list));
    }

    public List<Model> f(String str, c cVar, String str2, String[] strArr) {
        j.g(str, "table");
        j.g(cVar, "instance");
        List<? extends Model> q10 = this.f14862a.q(str, cVar, str2, strArr);
        j.f(q10, "managerDatabase.selectWi…         values\n        )");
        return q10;
    }

    public Cursor g(String str, String[] strArr) {
        j.g(str, "query");
        j.g(strArr, "params");
        Cursor d10 = this.f14862a.d(str, strArr);
        j.f(d10, "managerDatabase.execQuery(query, params)");
        return d10;
    }

    public w<x> h(Bagel bagel) {
        j.g(bagel, Extra.BAGEL);
        w<x> i10 = this.f14862a.i(bagel);
        j.f(i10, "managerDatabase.insertBagel(bagel)");
        return i10;
    }

    public boolean i(String str, Model model) {
        j.g(str, "table");
        j.g(model, "object");
        return this.f14862a.k(str, s.a(model));
    }

    public int j(String str, String str2, String[] strArr) {
        j.g(str, "tableName");
        return this.f14862a.b(str, str2, strArr);
    }
}
