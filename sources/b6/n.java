package b6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent;
import com.uber.autodispose.OutsideScopeException;
import hi.b;
import qj.q;

public class n extends Fragment implements b<FragmentLifecycleEvent> {

    /* renamed from: b  reason: collision with root package name */
    private static final hi.a<FragmentLifecycleEvent> f7863b = new m();

    /* renamed from: a  reason: collision with root package name */
    protected final d6.b f7864a = new d6.b();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7865a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent[] r0 = com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7865a = r0
                com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent.CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7865a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent.CREATE_VIEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7865a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent.START     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7865a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent.RESUME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7865a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent.PAUSE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7865a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent.STOP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7865a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent.DESTROY_VIEW     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7865a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent r1 = com.coffeemeetsbagel.components.lifecycle.FragmentLifecycleEvent.DESTROY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b6.n.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ FragmentLifecycleEvent A0(FragmentLifecycleEvent fragmentLifecycleEvent) throws OutsideScopeException {
        switch (a.f7865a[fragmentLifecycleEvent.ordinal()]) {
            case 1:
                return FragmentLifecycleEvent.DESTROY;
            case 2:
                return FragmentLifecycleEvent.DESTROY_VIEW;
            case 3:
                return FragmentLifecycleEvent.STOP;
            case 4:
                return FragmentLifecycleEvent.PAUSE;
            case 5:
                return FragmentLifecycleEvent.STOP;
            case 6:
                return FragmentLifecycleEvent.DESTROY_VIEW;
            case 7:
                return FragmentLifecycleEvent.DESTROY;
            case 8:
                throw new IllegalStateException("Cannot bind to Activity lifecycle when outside of it.");
            default:
                throw new UnsupportedOperationException("Binding to " + fragmentLifecycleEvent + " not yet implemented");
        }
    }

    /* renamed from: B0 */
    public FragmentLifecycleEvent x0() {
        return this.f7864a.b();
    }

    public hi.a<FragmentLifecycleEvent> a1() {
        return f7863b;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7864a.c(FragmentLifecycleEvent.CREATE);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f7864a.c(FragmentLifecycleEvent.CREATE_VIEW);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f7864a.c(FragmentLifecycleEvent.DESTROY);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f7864a.c(FragmentLifecycleEvent.DESTROY_VIEW);
    }

    public void onPause() {
        super.onPause();
        this.f7864a.c(FragmentLifecycleEvent.PAUSE);
    }

    public void onResume() {
        super.onResume();
        this.f7864a.c(FragmentLifecycleEvent.RESUME);
    }

    public void onStart() {
        super.onStart();
        this.f7864a.c(FragmentLifecycleEvent.START);
    }

    public void onStop() {
        super.onStop();
        this.f7864a.c(FragmentLifecycleEvent.STOP);
    }

    public q<FragmentLifecycleEvent> x() {
        return this.f7864a.a();
    }
}
