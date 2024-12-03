package s8;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.List;
import kotlin.jvm.internal.j;

public final class c extends a {

    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, List<d> list) {
        super(context, list);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(list, "itemsList");
    }
}
