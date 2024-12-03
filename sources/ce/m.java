package ce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import he.a;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final a f34063a = new a("GoogleSignInCommon", new String[0]);

    public static Intent a(Context context, GoogleSignInOptions googleSignInOptions) {
        f34063a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static f b(d dVar, Context context, boolean z10) {
        f34063a.a("Revoking access", new Object[0]);
        String e10 = b.b(context).e();
        d(context);
        if (z10) {
            return d.a(e10);
        }
        return dVar.h(new k(dVar));
    }

    public static f c(d dVar, Context context, boolean z10) {
        f34063a.a("Signing out", new Object[0]);
        d(context);
        if (z10) {
            return g.b(Status.f38500g, dVar);
        }
        return dVar.h(new i(dVar));
    }

    private static void d(Context context) {
        n.a(context).b();
        for (d p10 : d.i()) {
            p10.p();
        }
        com.google.android.gms.common.api.internal.g.a();
    }
}
