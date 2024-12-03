package androidx.lifecycle;

import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.a;
import kotlin.jvm.internal.j;

public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Lifecycle f5920a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f5921b;

    LegacySavedStateHandleController$tryToAddRecreator$1(Lifecycle lifecycle, a aVar) {
        this.f5920a = lifecycle;
        this.f5921b = aVar;
    }

    public void e(l lVar, Lifecycle.Event event) {
        j.g(lVar, "source");
        j.g(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this.f5920a.d(this);
            this.f5921b.i(LegacySavedStateHandleController.a.class);
        }
    }
}
