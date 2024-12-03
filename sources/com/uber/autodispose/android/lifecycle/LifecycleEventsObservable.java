package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.v;
import gi.b;
import gi.d;
import qj.q;
import qj.u;

class LifecycleEventsObservable extends q<Lifecycle.Event> {

    /* renamed from: a  reason: collision with root package name */
    private final Lifecycle f23311a;

    /* renamed from: b  reason: collision with root package name */
    private final io.reactivex.subjects.a<Lifecycle.Event> f23312b = io.reactivex.subjects.a.C0();

    static final class ArchLifecycleObserver extends d implements k {

        /* renamed from: b  reason: collision with root package name */
        private final Lifecycle f23313b;

        /* renamed from: c  reason: collision with root package name */
        private final u<? super Lifecycle.Event> f23314c;

        /* renamed from: d  reason: collision with root package name */
        private final io.reactivex.subjects.a<Lifecycle.Event> f23315d;

        ArchLifecycleObserver(Lifecycle lifecycle, u<? super Lifecycle.Event> uVar, io.reactivex.subjects.a<Lifecycle.Event> aVar) {
            this.f23313b = lifecycle;
            this.f23314c = uVar;
            this.f23315d = aVar;
        }

        /* access modifiers changed from: protected */
        public void a() {
            this.f23313b.d(this);
        }

        /* access modifiers changed from: package-private */
        @v(Lifecycle.Event.ON_ANY)
        public void onStateChange(l lVar, Lifecycle.Event event) {
            if (!c()) {
                if (!(event == Lifecycle.Event.ON_CREATE && this.f23315d.E0() == event)) {
                    this.f23315d.d(event);
                }
                this.f23314c.d(event);
            }
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23316a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23316a = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23316a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23316a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23316a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23316a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uber.autodispose.android.lifecycle.LifecycleEventsObservable.a.<clinit>():void");
        }
    }

    LifecycleEventsObservable(Lifecycle lifecycle) {
        this.f23311a = lifecycle;
    }

    /* access modifiers changed from: package-private */
    public void A0() {
        Lifecycle.Event event;
        int i10 = a.f23316a[this.f23311a.b().ordinal()];
        if (i10 == 1) {
            event = Lifecycle.Event.ON_CREATE;
        } else if (i10 == 2) {
            event = Lifecycle.Event.ON_START;
        } else if (i10 == 3 || i10 == 4) {
            event = Lifecycle.Event.ON_RESUME;
        } else {
            event = Lifecycle.Event.ON_DESTROY;
        }
        this.f23312b.d(event);
    }

    /* access modifiers changed from: package-private */
    public Lifecycle.Event B0() {
        return this.f23312b.E0();
    }

    /* access modifiers changed from: protected */
    public void l0(u<? super Lifecycle.Event> uVar) {
        ArchLifecycleObserver archLifecycleObserver = new ArchLifecycleObserver(this.f23311a, uVar, this.f23312b);
        uVar.a(archLifecycleObserver);
        if (!b.b()) {
            uVar.onError(new IllegalStateException("Lifecycles can only be bound to on the main thread!"));
            return;
        }
        this.f23311a.a(archLifecycleObserver);
        if (archLifecycleObserver.c()) {
            this.f23311a.d(archLifecycleObserver);
        }
    }
}
