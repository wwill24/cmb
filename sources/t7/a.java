package t7;

import android.database.Cursor;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.Model;
import f6.a2;
import h6.c;
import j5.x;
import java.util.List;
import qj.w;

public interface a {
    <T extends Model> T a(String str, h6.a<T> aVar, String str2, String str3);

    a2 b();

    int c(String str, String str2, String str3, String str4, String str5);

    Bagel d();

    boolean e(String str, List<? extends Model> list);

    List<? extends Model> f(String str, c cVar, String str2, String[] strArr);

    Cursor g(String str, String[] strArr);

    w<x> h(Bagel bagel);

    boolean i(String str, Model model);

    int j(String str, String str2, String[] strArr);
}
