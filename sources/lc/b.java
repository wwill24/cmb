package lc;

import android.content.Intent;
import c6.a;
import com.coffeemeetsbagel.models.constants.Extra;

public class b {
    public static Integer a(a aVar) {
        Intent a10 = aVar.a();
        if (a10 == null || !a10.hasExtra(Extra.GIVE_TAKE_POSITION)) {
            return null;
        }
        return Integer.valueOf(a10.getIntExtra(Extra.GIVE_TAKE_POSITION, 0));
    }

    public static Integer b(a aVar) {
        Intent a10 = aVar.a();
        if (a10 != null) {
            return Integer.valueOf(a10.getIntExtra(Extra.VIEW_PAGER_POSITION, 0));
        }
        return null;
    }

    public static boolean c(a aVar) {
        return aVar.c() == -1;
    }
}
