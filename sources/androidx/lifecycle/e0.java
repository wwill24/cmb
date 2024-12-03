package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.j;

public class e0 {

    /* renamed from: a  reason: collision with root package name */
    private final n f6017a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6018b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private a f6019c;

    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final n f6020a;

        /* renamed from: b  reason: collision with root package name */
        private final Lifecycle.Event f6021b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6022c;

        public a(n nVar, Lifecycle.Event event) {
            j.g(nVar, "registry");
            j.g(event, "event");
            this.f6020a = nVar;
            this.f6021b = event;
        }

        public void run() {
            if (!this.f6022c) {
                this.f6020a.j(this.f6021b);
                this.f6022c = true;
            }
        }
    }

    public e0(l lVar) {
        j.g(lVar, "provider");
        this.f6017a = new n(lVar);
    }

    private final void f(Lifecycle.Event event) {
        a aVar = this.f6019c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f6017a, event);
        this.f6019c = aVar2;
        Handler handler = this.f6018b;
        j.d(aVar2);
        handler.postAtFrontOfQueue(aVar2);
    }

    public Lifecycle a() {
        return this.f6017a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }
}
