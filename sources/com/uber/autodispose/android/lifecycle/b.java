package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.l;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import qj.f;
import qj.q;

public final class b implements hi.b<Lifecycle.Event> {

    /* renamed from: c  reason: collision with root package name */
    private static final hi.a<Lifecycle.Event> f23318c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final hi.a<Lifecycle.Event> f23319a;

    /* renamed from: b  reason: collision with root package name */
    private final LifecycleEventsObservable f23320b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23321a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23321a = r0
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23321a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23321a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23321a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23321a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f23321a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uber.autodispose.android.lifecycle.b.a.<clinit>():void");
        }
    }

    private b(Lifecycle lifecycle, hi.a<Lifecycle.Event> aVar) {
        this.f23320b = new LifecycleEventsObservable(lifecycle);
        this.f23319a = aVar;
    }

    public static b b(Lifecycle lifecycle) {
        return c(lifecycle, f23318c);
    }

    public static b c(Lifecycle lifecycle, hi.a<Lifecycle.Event> aVar) {
        return new b(lifecycle, aVar);
    }

    public static b d(l lVar) {
        return b(lVar.getLifecycle());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Lifecycle.Event e(Lifecycle.Event event) throws OutsideScopeException {
        int i10 = a.f23321a[event.ordinal()];
        if (i10 == 1) {
            return Lifecycle.Event.ON_DESTROY;
        }
        if (i10 == 2) {
            return Lifecycle.Event.ON_STOP;
        }
        if (i10 == 3) {
            return Lifecycle.Event.ON_PAUSE;
        }
        if (i10 == 4) {
            return Lifecycle.Event.ON_STOP;
        }
        throw new LifecycleEndedException("Lifecycle has ended! Last event was " + event);
    }

    public hi.a<Lifecycle.Event> a1() {
        return this.f23319a;
    }

    /* renamed from: f */
    public Lifecycle.Event x0() {
        this.f23320b.A0();
        return this.f23320b.B0();
    }

    public f s() {
        return hi.f.e(this);
    }

    public q<Lifecycle.Event> x() {
        return this.f23320b;
    }
}
