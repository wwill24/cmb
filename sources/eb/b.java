package eb;

import com.coffeemeetsbagel.database.daos.l;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.h;

public abstract class b implements a, l<d> {
    public List<Long> a(List<d> list) {
        j.g(list, "entities");
        return s(list);
    }

    public abstract h<List<d>> c();

    public h<List<d>> getAll() {
        return c();
    }
}
