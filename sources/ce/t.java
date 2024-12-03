package ce;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.a;
import com.google.android.gms.auth.api.signin.b;
import me.s;

public final class t extends o {

    /* renamed from: a  reason: collision with root package name */
    private final Context f34068a;

    public t(Context context) {
        this.f34068a = context;
    }

    private final void c() {
        if (!s.a(this.f34068a, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            throw new SecurityException("Calling UID " + callingUid + " is not Google Play services.");
        }
    }

    public final void h() {
        c();
        n.a(this.f34068a).b();
    }

    public final void m() {
        c();
        b b10 = b.b(this.f34068a);
        GoogleSignInAccount c10 = b10.c();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f38383m;
        if (c10 != null) {
            googleSignInOptions = b10.d();
        }
        b a10 = a.a(this.f34068a, googleSignInOptions);
        if (c10 != null) {
            a10.d();
        } else {
            a10.signOut();
        }
    }
}
