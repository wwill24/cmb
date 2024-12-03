package ce;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class n {

    /* renamed from: d  reason: collision with root package name */
    private static n f34064d;

    /* renamed from: a  reason: collision with root package name */
    final b f34065a;

    /* renamed from: b  reason: collision with root package name */
    GoogleSignInAccount f34066b;

    /* renamed from: c  reason: collision with root package name */
    GoogleSignInOptions f34067c;

    private n(Context context) {
        b b10 = b.b(context);
        this.f34065a = b10;
        this.f34066b = b10.c();
        this.f34067c = b10.d();
    }

    public static synchronized n a(@NonNull Context context) {
        n d10;
        synchronized (n.class) {
            d10 = d(context.getApplicationContext());
        }
        return d10;
    }

    private static synchronized n d(Context context) {
        synchronized (n.class) {
            n nVar = f34064d;
            if (nVar != null) {
                return nVar;
            }
            n nVar2 = new n(context);
            f34064d = nVar2;
            return nVar2;
        }
    }

    public final synchronized void b() {
        this.f34065a.a();
        this.f34066b = null;
        this.f34067c = null;
    }

    public final synchronized void c(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f34065a.f(googleSignInAccount, googleSignInOptions);
        this.f34066b = googleSignInAccount;
        this.f34067c = googleSignInOptions;
    }
}
