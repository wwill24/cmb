package ad;

import com.facebook.internal.security.OidcSecurityUtil;
import java.net.URL;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ URL f34005a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f34006b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34007c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ReentrantLock f34008d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Condition f34009e;

    public /* synthetic */ a(URL url, Ref$ObjectRef ref$ObjectRef, String str, ReentrantLock reentrantLock, Condition condition) {
        this.f34005a = url;
        this.f34006b = ref$ObjectRef;
        this.f34007c = str;
        this.f34008d = reentrantLock;
        this.f34009e = condition;
    }

    public final void run() {
        OidcSecurityUtil.m150getRawKeyFromEndPoint$lambda1(this.f34005a, this.f34006b, this.f34007c, this.f34008d, this.f34009e);
    }
}
