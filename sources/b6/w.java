package b6;

import com.coffeemeetsbagel.components.lifecycle.WorkerEvent;
import com.jakewharton.rxrelay2.c;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import hi.b;
import qj.q;

public abstract class w implements b<WorkerEvent> {

    /* renamed from: c  reason: collision with root package name */
    private static final hi.a<WorkerEvent> f7877c = new v();

    /* renamed from: a  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<WorkerEvent> f7878a;

    /* renamed from: b  reason: collision with root package name */
    private final c<WorkerEvent> f7879b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7880a;

        static {
            int[] iArr = new int[WorkerEvent.values().length];
            f7880a = iArr;
            try {
                iArr[WorkerEvent.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public w() {
        com.jakewharton.rxrelay2.b<WorkerEvent> C0 = com.jakewharton.rxrelay2.b.C0();
        this.f7878a = C0;
        this.f7879b = C0.A0();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ WorkerEvent t(WorkerEvent workerEvent) throws OutsideScopeException {
        if (a.f7880a[workerEvent.ordinal()] == 1) {
            return WorkerEvent.STOP;
        }
        throw new LifecycleEndedException();
    }

    public hi.a<WorkerEvent> a1() {
        return f7877c;
    }

    public void start() {
        this.f7879b.accept(WorkerEvent.START);
    }

    /* renamed from: u */
    public WorkerEvent x0() {
        return this.f7878a.E0();
    }

    public void v() {
        this.f7879b.accept(WorkerEvent.STOP);
    }

    public q<WorkerEvent> x() {
        return this.f7879b.P();
    }
}
