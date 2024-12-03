package ye;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.e;

final class b extends a.C0480a {
    b() {
    }

    public final /* bridge */ /* synthetic */ a.f buildClient(Context context, Looper looper, e eVar, Object obj, d.b bVar, d.c cVar) {
        a aVar = (a) obj;
        return new com.google.android.gms.signin.internal.a(context, looper, true, eVar, com.google.android.gms.signin.internal.a.e(eVar), bVar, cVar);
    }
}
