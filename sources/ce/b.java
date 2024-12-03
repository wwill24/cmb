package ce;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.p;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f34051c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private static b f34052d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f34053a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f34054b;

    b(Context context) {
        this.f34054b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @NonNull
    public static b b(@NonNull Context context) {
        p.k(context);
        Lock lock = f34051c;
        lock.lock();
        try {
            if (f34052d == null) {
                f34052d = new b(context.getApplicationContext());
            }
            b bVar = f34052d;
            lock.unlock();
            return bVar;
        } catch (Throwable th2) {
            f34051c.unlock();
            throw th2;
        }
    }

    private static final String i(String str, String str2) {
        return str + CertificateUtil.DELIMITER + str2;
    }

    public void a() {
        this.f34053a.lock();
        try {
            this.f34054b.edit().clear().apply();
        } finally {
            this.f34053a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        String g10;
        String g11 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(g11) || (g10 = g(i("googleSignInAccount", g11))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.q0(g10);
        } catch (JSONException unused) {
            return null;
        }
    }

    public GoogleSignInOptions d() {
        String g10;
        String g11 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(g11) || (g10 = g(i("googleSignInOptions", g11))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.B0(g10);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String e() {
        return g("refreshToken");
    }

    public void f(@NonNull GoogleSignInAccount googleSignInAccount, @NonNull GoogleSignInOptions googleSignInOptions) {
        p.k(googleSignInAccount);
        p.k(googleSignInOptions);
        h("defaultGoogleSignInAccount", googleSignInAccount.t0());
        p.k(googleSignInAccount);
        p.k(googleSignInOptions);
        String t02 = googleSignInAccount.t0();
        h(i("googleSignInAccount", t02), googleSignInAccount.B0());
        h(i("googleSignInOptions", t02), googleSignInOptions.W0());
    }

    /* access modifiers changed from: protected */
    public final String g(@NonNull String str) {
        this.f34053a.lock();
        try {
            return this.f34054b.getString(str, (String) null);
        } finally {
            this.f34053a.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final void h(@NonNull String str, @NonNull String str2) {
        this.f34053a.lock();
        try {
            this.f34054b.edit().putString(str, str2).apply();
        } finally {
            this.f34053a.unlock();
        }
    }
}
