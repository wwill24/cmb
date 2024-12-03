package b6;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.c;
import androidx.core.app.n;
import androidx.core.app.q0;
import com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent;
import com.uber.autodispose.OutsideScopeException;
import hi.b;
import qj.q;

public class l extends c implements b<ActivityLifecycleEvent> {

    /* renamed from: d  reason: collision with root package name */
    private static final hi.a<ActivityLifecycleEvent> f7860d = new k();

    /* renamed from: c  reason: collision with root package name */
    protected final d6.a f7861c = new d6.a();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7862a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent[] r0 = com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7862a = r0
                com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent.CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7862a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent.STOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7862a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent.START     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7862a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent.PAUSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7862a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent.RESUME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7862a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent.DESTROY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b6.l.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ActivityLifecycleEvent D0(ActivityLifecycleEvent activityLifecycleEvent) throws OutsideScopeException {
        switch (a.f7862a[activityLifecycleEvent.ordinal()]) {
            case 1:
            case 2:
                return ActivityLifecycleEvent.DESTROY;
            case 3:
            case 4:
                return ActivityLifecycleEvent.STOP;
            case 5:
                return ActivityLifecycleEvent.PAUSE;
            case 6:
                throw new IllegalStateException("Cannot bind to Activity lifecycle when outside of it.");
            default:
                throw new UnsupportedOperationException("Binding to " + activityLifecycleEvent + " not yet implemented");
        }
    }

    /* renamed from: E0 */
    public ActivityLifecycleEvent x0() {
        return this.f7861c.b();
    }

    public hi.a<ActivityLifecycleEvent> a1() {
        return f7860d;
    }

    public void onBackPressed() {
        Intent p10 = p();
        if (p10 == null || (!n.f(this, p10) && !isTaskRoot())) {
            super.onBackPressed();
        } else {
            q0.j(this).d(p10).o();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7861c.c(ActivityLifecycleEvent.CREATE);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f7861c.c(ActivityLifecycleEvent.DESTROY);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f7861c.c(ActivityLifecycleEvent.PAUSE);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f7861c.c(ActivityLifecycleEvent.RESUME);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f7861c.c(ActivityLifecycleEvent.START);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f7861c.c(ActivityLifecycleEvent.STOP);
    }

    public q<ActivityLifecycleEvent> x() {
        return this.f7861c.a();
    }
}
