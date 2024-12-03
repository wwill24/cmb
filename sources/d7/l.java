package d7;

import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.authentication.LoginEvent;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import java.util.HashSet;
import java.util.Iterator;
import qj.q;

@Deprecated
public class l implements hi.b<LoginEvent> {

    /* renamed from: e  reason: collision with root package name */
    private static final hi.a<LoginEvent> f14492e = new k();

    /* renamed from: a  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<LoginEvent> f14493a;

    /* renamed from: b  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.c<LoginEvent> f14494b;

    /* renamed from: c  reason: collision with root package name */
    private b f14495c;

    /* renamed from: d  reason: collision with root package name */
    private HashSet<m> f14496d = new HashSet<>();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14497a;

        static {
            int[] iArr = new int[LoginEvent.values().length];
            f14497a = iArr;
            try {
                iArr[LoginEvent.LOGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public interface b {
    }

    public interface c {
    }

    public l() {
        com.jakewharton.rxrelay2.b<LoginEvent> C0 = com.jakewharton.rxrelay2.b.C0();
        this.f14493a = C0;
        this.f14494b = C0.A0();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ LoginEvent c(LoginEvent loginEvent) throws OutsideScopeException {
        if (a.f14497a[loginEvent.ordinal()] == 1) {
            return LoginEvent.LOGOUT;
        }
        throw new LifecycleEndedException("User is logged out and lifecycle has ended");
    }

    public hi.a<LoginEvent> a1() {
        return f14492e;
    }

    public void b(m mVar) {
        if (!this.f14496d.contains(mVar)) {
            this.f14496d.add(mVar);
            if (LoginEvent.LOGIN == x0()) {
                mVar.r();
            }
        }
    }

    public void d() {
        LoginEvent loginEvent = LoginEvent.LOGIN;
        if (loginEvent != x0()) {
            this.f14494b.accept(loginEvent);
            Iterator<m> it = this.f14496d.iterator();
            while (it.hasNext()) {
                it.next().r();
            }
            this.f14495c = i.a().b(Bakery.j()).a();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        Iterator<m> it = this.f14496d.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f14494b.accept(LoginEvent.LOGOUT);
        this.f14495c = null;
    }

    /* renamed from: f */
    public LoginEvent x0() {
        return this.f14493a.E0();
    }

    public q<LoginEvent> x() {
        return this.f14494b.P();
    }
}
