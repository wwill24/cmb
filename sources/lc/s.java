package lc;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.RosterElement;
import com.coffeemeetsbagel.models.SavedMessage;
import h6.a;
import h6.b;
import h6.c;
import h6.d;
import h6.e;
import h6.f;
import java.util.ArrayList;
import java.util.List;

public class s {
    public static a a(Object obj) {
        if (obj instanceof Bagel) {
            return b.d((Bagel) obj);
        }
        if (obj instanceof GiveTake) {
            return c.d((GiveTake) obj);
        }
        if (obj instanceof RisingGiveTake) {
            return d.c((RisingGiveTake) obj);
        }
        if (obj instanceof SavedMessage) {
            return f.c((SavedMessage) obj);
        }
        if (obj instanceof RosterElement) {
            return e.c((RosterElement) obj);
        }
        throw new IllegalArgumentException("No mapper available for " + obj.getClass());
    }

    public static List<a> b(List<? extends Object> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object a10 : list) {
            arrayList.add(a(a10));
        }
        return arrayList;
    }
}
