package f2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.core.net.a;
import b2.f;
import com.mparticle.identity.IdentityHttpResponse;
import d2.b;
import h2.l;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\"\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\b\"\u0018\u0010\u000e\u001a\u00020\u000b*\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001e\u0010\u0013\u001a\u00020\u0005*\u00020\n8@X\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroid/content/Context;", "context", "Li2/b;", "taskExecutor", "Lf2/h;", "Ld2/b;", "a", "", "Ljava/lang/String;", "TAG", "Landroid/net/ConnectivityManager;", "", "d", "(Landroid/net/ConnectivityManager;)Z", "isActiveNetworkValidated", "c", "(Landroid/net/ConnectivityManager;)Ld2/b;", "getActiveNetworkState$annotations", "(Landroid/net/ConnectivityManager;)V", "activeNetworkState", "work-runtime_release"}, k = 2, mv = {1, 7, 1})
public final class k {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f14657a;

    static {
        String i10 = f.i("NetworkStateTracker");
        j.f(i10, "tagWithPrefix(\"NetworkStateTracker\")");
        f14657a = i10;
    }

    public static final h<b> a(Context context, i2.b bVar) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(bVar, "taskExecutor");
        return new j(context, bVar);
    }

    public static final b c(ConnectivityManager connectivityManager) {
        boolean z10;
        j.g(connectivityManager, "<this>");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z11 = true;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean d10 = d(connectivityManager);
        boolean a10 = a.a(connectivityManager);
        if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
            z11 = false;
        }
        return new b(z10, d10, a10, z11);
    }

    public static final boolean d(ConnectivityManager connectivityManager) {
        j.g(connectivityManager, "<this>");
        try {
            NetworkCapabilities a10 = h2.k.a(connectivityManager, l.a(connectivityManager));
            if (a10 != null) {
                return h2.k.b(a10, 16);
            }
            return false;
        } catch (SecurityException e10) {
            f.e().d(f14657a, "Unable to validate active network", e10);
            return false;
        }
    }
}
