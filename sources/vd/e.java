package vd;

import android.content.Context;
import android.os.Looper;
import ce.g;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import java.util.Collections;
import java.util.List;

final class e extends a.C0480a {
    e() {
    }

    public final /* synthetic */ a.f buildClient(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, Object obj, d.b bVar, d.c cVar) {
        return new g(context, looper, eVar, (GoogleSignInOptions) obj, bVar, cVar);
    }

    public final /* bridge */ /* synthetic */ List getImpliedScopes(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        if (googleSignInOptions == null) {
            return Collections.emptyList();
        }
        return googleSignInOptions.c0();
    }
}
