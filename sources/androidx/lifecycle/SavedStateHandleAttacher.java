package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.j;

public final class SavedStateHandleAttacher implements i {

    /* renamed from: a  reason: collision with root package name */
    private final SavedStateHandlesProvider f5973a;

    public SavedStateHandleAttacher(SavedStateHandlesProvider savedStateHandlesProvider) {
        j.g(savedStateHandlesProvider, "provider");
        this.f5973a = savedStateHandlesProvider;
    }

    public void e(l lVar, Lifecycle.Event event) {
        boolean z10;
        j.g(lVar, "source");
        j.g(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            lVar.getLifecycle().d(this);
            this.f5973a.d();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
    }
}
