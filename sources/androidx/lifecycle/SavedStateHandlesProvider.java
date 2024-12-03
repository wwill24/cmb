package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.a;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import gk.f;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class SavedStateHandlesProvider implements a.c {

    /* renamed from: a  reason: collision with root package name */
    private final a f5981a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5982b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f5983c;

    /* renamed from: d  reason: collision with root package name */
    private final f f5984d;

    public SavedStateHandlesProvider(a aVar, l0 l0Var) {
        j.g(aVar, "savedStateRegistry");
        j.g(l0Var, "viewModelStoreOwner");
        this.f5981a = aVar;
        this.f5984d = b.b(new SavedStateHandlesProvider$viewModel$2(l0Var));
    }

    private final b0 c() {
        return (b0) this.f5984d.getValue();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f5983c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry next : c().f().entrySet()) {
            String str = (String) next.getKey();
            Bundle a10 = ((a0) next.getValue()).g().a();
            if (!j.b(a10, Bundle.EMPTY)) {
                bundle.putBundle(str, a10);
            }
        }
        this.f5982b = false;
        return bundle;
    }

    public final Bundle b(String str) {
        Bundle bundle;
        j.g(str, SDKConstants.PARAM_KEY);
        d();
        Bundle bundle2 = this.f5983c;
        if (bundle2 != null) {
            bundle = bundle2.getBundle(str);
        } else {
            bundle = null;
        }
        Bundle bundle3 = this.f5983c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f5983c;
        boolean z10 = true;
        if (bundle4 == null || !bundle4.isEmpty()) {
            z10 = false;
        }
        if (z10) {
            this.f5983c = null;
        }
        return bundle;
    }

    public final void d() {
        if (!this.f5982b) {
            this.f5983c = this.f5981a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
            this.f5982b = true;
            c();
        }
    }
}
