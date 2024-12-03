package b6;

import androidx.annotation.NonNull;
import b6.q;
import com.coffeemeetsbagel.components.lifecycle.InteractorEvent;
import com.jakewharton.rxrelay2.c;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import hi.b;

public class i<R extends q> implements b<InteractorEvent> {

    /* renamed from: d  reason: collision with root package name */
    private static final hi.a<InteractorEvent> f7855d = new h();

    /* renamed from: a  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<InteractorEvent> f7856a;

    /* renamed from: b  reason: collision with root package name */
    private final c<InteractorEvent> f7857b;

    /* renamed from: c  reason: collision with root package name */
    private R f7858c;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7859a;

        static {
            int[] iArr = new int[InteractorEvent.values().length];
            f7859a = iArr;
            try {
                iArr[InteractorEvent.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public i() {
        com.jakewharton.rxrelay2.b<InteractorEvent> C0 = com.jakewharton.rxrelay2.b.C0();
        this.f7856a = C0;
        this.f7857b = C0.A0();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ InteractorEvent C1(InteractorEvent interactorEvent) throws OutsideScopeException {
        if (a.f7859a[interactorEvent.ordinal()] == 1) {
            return InteractorEvent.INACTIVE;
        }
        throw new LifecycleEndedException();
    }

    /* access modifiers changed from: package-private */
    public void A1() {
        this.f7857b.accept(InteractorEvent.INACTIVE);
        F1();
    }

    @NonNull
    public R B1() {
        R r10 = this.f7858c;
        if (r10 != null) {
            return r10;
        }
        throw new IllegalStateException("Attempting to get interactor's router before being set.");
    }

    /* renamed from: D1 */
    public InteractorEvent x0() {
        return this.f7856a.E0();
    }

    /* access modifiers changed from: package-private */
    public void E1(R r10) {
        this.f7858c = r10;
    }

    /* access modifiers changed from: protected */
    public void F1() {
    }

    public hi.a<InteractorEvent> a1() {
        return f7855d;
    }

    public qj.q<InteractorEvent> x() {
        return this.f7857b.P();
    }

    /* access modifiers changed from: protected */
    public void y1() {
    }

    /* access modifiers changed from: package-private */
    public void z1() {
        this.f7857b.accept(InteractorEvent.ACTIVE);
        y1();
    }
}
