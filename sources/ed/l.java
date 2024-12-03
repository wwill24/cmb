package ed;

import android.annotation.SuppressLint;
import cd.e;
import com.google.android.datatransport.Priority;
import id.a;

public final class l {
    @SuppressLint({"DiscouragedApi"})
    public static void a(e<?> eVar, Priority priority) {
        if (eVar instanceof s) {
            u.c().e().u(((s) eVar).d().f(priority), 1);
            return;
        }
        a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", eVar);
    }
}
