package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.a;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.j;

public final class SavedStateHandleController implements i {

    /* renamed from: a  reason: collision with root package name */
    private final String f5974a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f5975b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5976c;

    public SavedStateHandleController(String str, a0 a0Var) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(a0Var, "handle");
        this.f5974a = str;
        this.f5975b = a0Var;
    }

    public final void a(a aVar, Lifecycle lifecycle) {
        j.g(aVar, "registry");
        j.g(lifecycle, "lifecycle");
        if (!this.f5976c) {
            this.f5976c = true;
            lifecycle.a(this);
            aVar.h(this.f5974a, this.f5975b.g());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    public final a0 b() {
        return this.f5975b;
    }

    public final boolean c() {
        return this.f5976c;
    }

    public void e(l lVar, Lifecycle.Event event) {
        j.g(lVar, "source");
        j.g(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f5976c = false;
            lVar.getLifecycle().d(this);
        }
    }
}
