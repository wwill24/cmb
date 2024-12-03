package b6;

import android.view.View;
import com.coffeemeetsbagel.components.lifecycle.PresenterEvent;
import com.jakewharton.rxrelay2.c;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import hi.b;
import qj.q;

public class p<V extends View> implements b {

    /* renamed from: d  reason: collision with root package name */
    private static final hi.a<PresenterEvent> f7866d = new o();

    /* renamed from: a  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<PresenterEvent> f7867a;

    /* renamed from: b  reason: collision with root package name */
    private final c<PresenterEvent> f7868b;

    /* renamed from: c  reason: collision with root package name */
    protected final V f7869c;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7870a;

        static {
            int[] iArr = new int[PresenterEvent.values().length];
            f7870a = iArr;
            try {
                iArr[PresenterEvent.LOADED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public p(V v10) {
        com.jakewharton.rxrelay2.b<PresenterEvent> C0 = com.jakewharton.rxrelay2.b.C0();
        this.f7867a = C0;
        this.f7868b = C0.A0();
        this.f7869c = v10;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ PresenterEvent h(PresenterEvent presenterEvent) throws OutsideScopeException {
        if (a.f7870a[presenterEvent.ordinal()] == 1) {
            return PresenterEvent.UNLOADED;
        }
        throw new LifecycleEndedException();
    }

    public hi.a<PresenterEvent> a1() {
        return f7866d;
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.f7867a.accept(PresenterEvent.LOADED);
        d();
    }

    /* access modifiers changed from: protected */
    public void f() {
        i();
        this.f7867a.accept(PresenterEvent.UNLOADED);
    }

    public V g() {
        return this.f7869c;
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    public q<PresenterEvent> x() {
        return this.f7868b.P();
    }

    public Object x0() {
        return this.f7867a.E0();
    }
}
